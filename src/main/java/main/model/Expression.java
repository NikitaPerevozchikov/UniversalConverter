package main.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Expression {

    private List<String> numerator;
    private List<String> denominator;

    public Expression() {
        numerator = new ArrayList<>();
        denominator = new ArrayList<>();
    }

    public List<String> getNumerator() {
        return numerator;
    }

    public List<String> getDenominator() {
        return denominator;
    }

    public boolean isParsingText(String text) {
        List<String> unitList = Arrays.asList(text.trim().split("\\s*/\\s*"));
        if (unitList.size() == 1 &&
                isParsePartText(unitList.get(0), numerator)) {
            return true;
        }
        return unitList.size() == 2 &&
                isParsePartText(unitList.get(0), numerator) &&
                isParsePartText(unitList.get(1), denominator);
    }

    private boolean isParsePartText(String text, List<String> list) {
        if (text.equals("")) {
            return true;
        }
        String[] part = text.split("\\s*\\*\\s*");
        for (String s : part) {
            if (!s.matches("[a-zA-Zа-яА-Я]+")) {
                return false;
            }
            list.add(s);
        }
        return true;
    }
}
