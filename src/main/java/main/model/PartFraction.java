package main.model;

import java.util.ArrayList;
import java.util.List;

public class PartFraction {

    private Double index;
    private List<String> unitList;

    public PartFraction() {
        index = 1.0;
        unitList = new ArrayList<>();
    }

    public Double getIndex() {
        return index;
    }

    public void setIndex(Double index) {
        this.index = index;
    }

    public List<String> getUnitList() {
        return unitList;
    }
}
