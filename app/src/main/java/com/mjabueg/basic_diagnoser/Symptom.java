package com.mjabueg.basic_diagnoser;

import java.io.Serializable;

public class Symptom implements Serializable {
    private String name;
    private boolean isSelected;

    public Symptom(String name, boolean isSelected) {

        this.name = name;
        this.isSelected = isSelected;
    }

    public Symptom(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }


}
