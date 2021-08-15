package main.model;

import main.ListGeneration;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.HashSet;

public class Conversion {
    private PartFraction numerator;
    private PartFraction denominator;
    private HashSet<String> uniqueUnit;
    private HashMap<String, HashMap<String, Index>> convertList = ListGeneration.getConvertList();

    public boolean isCompletionFraction(String from, String to) {
        Expression expressionFrom = new Expression();
        Expression expressionTo = new Expression();
        if (!(expressionFrom.isParsingText(from) && expressionTo.isParsingText(to))) {
            return false;
        }
        numerator = new PartFraction();
        denominator = new PartFraction();
        numerator.getUnitList().addAll(expressionFrom.getNumerator());
        numerator.getUnitList().addAll(expressionTo.getDenominator());
        denominator.getUnitList().addAll(expressionFrom.getDenominator());
        denominator.getUnitList().addAll(expressionTo.getNumerator());
        return true;
    }

    public boolean isParsingExpression() {
        uniqueUnit = new HashSet<>();
        while (numerator.getUnitList().size() > 0) {
            String n = numerator.getUnitList().get(0);
            uniqueUnit.add(n);
            if (!recursiveTask(n, new Index(1.0, 1.0))) {
                return false;
            }
            if (uniqueUnit.contains(n)) {
                return true;
            }
        }
        return true;
    }

    private boolean recursiveTask(String n, Index index) {
        for (int i = 0; i < denominator.getUnitList().size(); i++) {
            String d = denominator.getUnitList().get(i);
            if (!convertList.containsKey(n) || !convertList.containsKey(d)) {
                return false;
            }
            if (n.equals(d)) {
                numerator.getUnitList().remove(numerator.getUnitList().get(0));
                denominator.getUnitList().remove(denominator.getUnitList().get(i));
                uniqueUnit = new HashSet<>();
                return true;
            }
            if (convertList.get(n).containsKey(d)) {
                numerator.setIndex(numerator.getIndex() * convertList.get(n).get(d).getNumerator() * index.getNumerator());
                denominator.setIndex(denominator.getIndex() * convertList.get(n).get(d).getDenominator() * index.getDenominator());
                numerator.getUnitList().remove(numerator.getUnitList().get(0));
                denominator.getUnitList().remove(denominator.getUnitList().get(i));
                uniqueUnit = new HashSet<>();
                return true;
            }
        }

        HashMap<String, Index> hashMap = convertList.get(n);
        for (String s : hashMap.keySet()) {
            if (!uniqueUnit.contains(s)) {
                uniqueUnit.add(s);
                index.setNumerator(index.getNumerator() * convertList.get(n).get(s).getNumerator());
                index.setDenominator(index.getDenominator() * convertList.get(n).get(s).getDenominator());
                recursiveTask(s, index);
            }
        }
        return true;
    }

    public boolean isConvert() {
        return (numerator.getUnitList().size() == 0 && denominator.getUnitList().size() == 0);
    }

    public double getConvertIndex() {
        return BigDecimal.valueOf(numerator.getIndex() / denominator.getIndex()).setScale(17, RoundingMode.UP).doubleValue();
    }

}
