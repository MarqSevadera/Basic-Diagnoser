package com.mjabueg.basic_diagnoser;

import java.util.ArrayList;

public class Diagnosis {

    private ArrayList<Symptom> symptomList;
    private ArrayList<Medicine> medicineList;
    private String name;

    private int score = 0 ;

    public Diagnosis(String name , ArrayList<Symptom> symptoms , ArrayList<Medicine> medicine){
        this.name = name;
        this.symptomList = symptoms;

        this.medicineList = medicine;

    }


    public ArrayList<Medicine> getMedicineList() {
        return medicineList;
    }


    public ArrayList<Symptom> getSymptomList() {
        return symptomList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isPerfect(){
        return symptomList.size() == score;
    }

}

