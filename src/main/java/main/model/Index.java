package main.model;

public class Index {

    private Double numerator;
    private Double denominator;

    public Index(Double numerator, Double denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Double getNumerator() {
        return numerator;
    }

    public Double getDenominator() {
        return denominator;
    }

    public void setNumerator(Double numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(Double denominator) {
        this.denominator = denominator;
    }
}

