package com.mjabueg.basic_diagnoser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    private ArrayList<Diagnosis> diagnosisList = new ArrayList<>();
    private ArrayList<Symptom> selectedSymptoms;
    private RecyclerView recyclerView;


    private ArrayList<Diagnosis> possibleDiagnosis = new ArrayList<>();
    private ArrayList<Diagnosis> finalDiagnosis = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_layout);


        setTitle(Html.fromHtml("<font color='#ffffff'> Diagnosis </font>"));

        initDiagnosis();

        if (getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getBundleExtra("BUNDLE");

            selectedSymptoms = (ArrayList<Symptom>) bundle.getSerializable("ARRAYLIST");
        }
        Diagnose();


        recyclerView=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);

        RVAdapter adapter = new RVAdapter(finalDiagnosis);
        recyclerView.setAdapter(adapter);
    }

    private void initDiagnosis() {
        initCommonCold();
        initAllergies();
        initFlu();
        initCommonCough();
        initHeadAche();
        initHypertension();
        initSoreEyes();
        initStress();
        initMusclePain();
        initDiarrhea();
        initToothAche();
        initDysmenorrhea();
    }

    private void initCommonCold() {
        ArrayList<Symptom> symptoms = new ArrayList<>();
        ArrayList<Medicine> medicines = new ArrayList<>();
        Diagnosis diag;

        //COMMON COLD
        symptoms.add(new Symptom("Cough"));
        symptoms.add(new Symptom("Nasal congestion"));
        symptoms.add(new Symptom("Runny or stuffy nose"));
        symptoms.add(new Symptom("Sore throat"));

        //COMMON COLD PRESCRIPTION
        medicines.add(new Medicine("Acetaminophen"));
        medicines.add(new Medicine("Decongestant"));
        medicines.add(new Medicine("Nasal Spray"));

        diag = new Diagnosis("Common Cold", symptoms, medicines);
        diagnosisList.add(diag);
    }

    private void initFlu() {
        ArrayList<Symptom> symptoms = new ArrayList<>();
        ArrayList<Medicine> medicines = new ArrayList<>();
        Diagnosis diag;

        //FLU
        symptoms.add(new Symptom("Aching muscles"));
        symptoms.add(new Symptom("Chills and sweats"));
        symptoms.add(new Symptom("Fever"));
        symptoms.add(new Symptom("Head pain"));
        symptoms.add(new Symptom("Cough"));
        symptoms.add(new Symptom("Nasal congestion"));

        //FLU PRESCRIPTION
        medicines.add(new Medicine("Ibuprofen"));
        medicines.add(new Medicine("Acetaminophen"));

        diag = new Diagnosis("Flu", symptoms, medicines);
        diagnosisList.add(diag);

    }

    private void initAllergies() {
        ArrayList<Symptom> symptoms = new ArrayList<>();
        ArrayList<Medicine> medicines = new ArrayList<>();
        Diagnosis diag;

        //ALLERGIES
        symptoms.add(new Symptom("Cough"));
        symptoms.add(new Symptom("Runny or stuffy nose"));
        symptoms.add(new Symptom("Red, watering eyes"));
        symptoms.add(new Symptom("Shortness of breath"));
        symptoms.add(new Symptom("Sneezing"));
        symptoms.add(new Symptom("Swelling"));


        //ALLERGIES PRESCRIPTION
        medicines.add(new Medicine("Loratadine"));
        medicines.add(new Medicine("Cetirizine"));

        diag = new Diagnosis("Allergies", symptoms, medicines);
        diagnosisList.add(diag);
    }

    private void initCommonCough() {
        ArrayList<Symptom> symptoms = new ArrayList<>();
        ArrayList<Medicine> medicines = new ArrayList<>();
        Diagnosis diag;

        //COMMON COUGH
        symptoms.add(new Symptom("Runny or stuffy nose"));
        symptoms.add(new Symptom("Hoarseness"));
        symptoms.add(new Symptom("Shortness of breath"));
        symptoms.add(new Symptom("Sore throat"));
        symptoms.add(new Symptom("Cough"));

        //COMMON COUGH PRESCRIPTION
        medicines.add(new Medicine("Dextromethorphan"));
        medicines.add(new Medicine("Antihistamine"));

        diag = new Diagnosis("Common Cough", symptoms, medicines);
        diagnosisList.add(diag);
    }

    private void initHypertension() {
        ArrayList<Symptom> symptoms = new ArrayList<>();
        ArrayList<Medicine> medicines = new ArrayList<>();
        Diagnosis diag;
        //HYPERTENSION
        symptoms.add(new Symptom("Head pain"));
        symptoms.add(new Symptom("Fatigue"));
        symptoms.add(new Symptom("Vision problems"));
        symptoms.add(new Symptom("Chest pain"));
        symptoms.add(new Symptom("Irregular heartbeat"));
        symptoms.add(new Symptom("Pressure in the head"));

        //HYPERTENSION PRESCRIPTION
        medicines.add(new Medicine("Atenolol"));
        medicines.add(new Medicine("Acebutolol"));

        diag = new Diagnosis("Hypertension", symptoms, medicines);
        diagnosisList.add(diag);

    }

    private void initStress() {

        ArrayList<Symptom> symptoms = new ArrayList<>();
        ArrayList<Medicine> medicines = new ArrayList<>();
        Diagnosis diag;

        //STRESS
        symptoms.add(new Symptom("Upset stomach"));
        symptoms.add(new Symptom("Insomnia"));
        symptoms.add(new Symptom("Chest pain"));
        symptoms.add(new Symptom("Low energy"));

        //STRESS PRESCRIPTION
        medicines.add(new Medicine("Antidepressant"));
        medicines.add(new Medicine("Benzodiazepines"));

        diag = new Diagnosis("Stress", symptoms, medicines);
        diagnosisList.add(diag);

    }

    private void initMusclePain() {
        ArrayList<Symptom> symptoms = new ArrayList<>();
        ArrayList<Medicine> medicines = new ArrayList<>();
        Diagnosis diag;

        //MUSCLE PAIN
        symptoms.add(new Symptom("Aching muscles"));
        symptoms.add(new Symptom("Muscles cramping"));

        //MUSCLE PAIN PRESCRIPTION
        medicines.add(new Medicine("Aspirin"));
        medicines.add(new Medicine("Ibuprofen"));
        medicines.add(new Medicine("Naproxen"));

        diag = new Diagnosis("Muscle Pain", symptoms, medicines);
        diagnosisList.add(diag);
    }



    private void initSoreEyes() {
        ArrayList<Symptom> symptoms = new ArrayList<>();
        ArrayList<Medicine> medicines = new ArrayList<>();
        Diagnosis diag;

        //SORE EYES
        symptoms.add(new Symptom("Dry eyes"));
        symptoms.add(new Symptom("Itchy eyes"));
        symptoms.add(new Symptom("Burning sensation of eye"));
        symptoms.add(new Symptom("Red, watering eyes"));


        //SORE EYES PRESCRIPTION
        medicines.add(new Medicine("Antibacterial Drops"));

        diag = new Diagnosis("Sore Eyes", symptoms, medicines);
        diagnosisList.add(diag);
    }

    private void initHeadAche() {
        ArrayList<Symptom> symptoms = new ArrayList<>();
        ArrayList<Medicine> medicines = new ArrayList<>();
        Diagnosis diag;

        //HEAD ACHE
        symptoms.add(new Symptom("Dull headed"));
        symptoms.add(new Symptom("Head pain"));
        symptoms.add(new Symptom("Pressure in the head"));

        //HEAD ACHE PRESCRIPTION
        medicines.add(new Medicine("Acetaminophen"));
        medicines.add(new Medicine("Aspirin"));
        medicines.add(new Medicine("Ibuprofen"));

        diag = new Diagnosis("Head Ache", symptoms, medicines);
        diagnosisList.add(diag);
    }

    private void initToothAche() {
        ArrayList<Symptom> symptoms = new ArrayList<>();
        ArrayList<Medicine> medicines = new ArrayList<>();
        Diagnosis diag;

        //TOOTH ACHE
        symptoms.add(new Symptom("Sharp pain in the teeth"));
        symptoms.add(new Symptom("Swelling around the tooth"));

        //TOOTH ACHE PRESCRIPTION
        medicines.add(new Medicine("Ibuprofen"));
        medicines.add(new Medicine("Naproxen"));
        medicines.add(new Medicine("Acetaminophen"));

        diag = new Diagnosis("Tooth Ache", symptoms, medicines);
        diagnosisList.add(diag);
    }

    private void initDiarrhea() {
        ArrayList<Symptom> symptoms = new ArrayList<>();
        ArrayList<Medicine> medicines = new ArrayList<>();
        Diagnosis diag;
        //DIARRHEA
        symptoms.add(new Symptom("Abdominal pain"));
        symptoms.add(new Symptom("Bloating"));
        symptoms.add(new Symptom("Loose and watery tools"));
        symptoms.add(new Symptom("Nausea"));

        //DIARRHEA PRESCRIPTION
        medicines.add(new Medicine("Loperamide"));
        medicines.add(new Medicine("Bismuth Subsalicylate"));

        diag = new Diagnosis("Diarrhea", symptoms, medicines);
        diagnosisList.add(diag);
    }

    private void initDysmenorrhea() {
        ArrayList<Symptom> symptoms = new ArrayList<>();
        ArrayList<Medicine> medicines = new ArrayList<>();
        Diagnosis diag;
        //DYSMENORRHEA
        symptoms.add(new Symptom("Abdominal pain"));
        symptoms.add(new Symptom("Nausea"));
        symptoms.add(new Symptom("Sharp and pelvic cramps"));
        symptoms.add(new Symptom("Vomiting"));
        symptoms.add(new Symptom("Fatigue"));
        //DYSMENORRHEA PRESCRIPTION
        medicines.add(new Medicine("Diclofenac"));
        medicines.add(new Medicine("Ibuprofen"));
        medicines.add(new Medicine("Naproxen"));

        diag = new Diagnosis("Dysmenorrhea", symptoms, medicines);
        diagnosisList.add(diag);
    }

    private void Diagnose() {

        for (Diagnosis diag : diagnosisList) {  //isaisahin muna yung diagnosis data
            int match = 0;

            ArrayList<Symptom> symptomList = diag.getSymptomList(); //tapos kunin yung list ng sintomas ng current diagnosis

            for (Symptom symptom : symptomList) { //isa isahin yong list ng sintomas

                for (Symptom selected : selectedSymptoms) { //tas isa isahin den syempre yung mga napiling sintomas ng user

                    if (selected.getName().equals(symptom.getName())) { //ngayon icompare na kung yung sintomas ba na napili ng user ay nasa sintomas ng current diagnosis
                        match++; //increase yung match counter kailangan naten to mamaya..
                        break;
                    }
                }
            }


            if (match == symptomList.size()) {
                finalDiagnosis.add(diag);
            } else if (match > 0) {
                diag.setScore(match);
                possibleDiagnosis.add(diag);
            }

        }


        if (hasOtherPossibleDiagnosis(selectedSymptoms, finalDiagnosis)) {
            int highestScore = 0;
            ArrayList<Diagnosis> diagWithHighestScore  = new ArrayList<>();
            for (Diagnosis possibleDiag : possibleDiagnosis) {

                if(possibleDiag.getScore() > highestScore ){
                    diagWithHighestScore.clear();
                    diagWithHighestScore.add(possibleDiag);
                    highestScore = possibleDiag.getScore();
                }else if(possibleDiag.getScore() == highestScore){
                    diagWithHighestScore.add(possibleDiag);
                }
            }


            finalDiagnosis.removeAll(diagWithHighestScore); //remove duplicate
            finalDiagnosis.addAll(diagWithHighestScore); // add to finalDiagnosis;

            printFinalDiagnosis(finalDiagnosis);
        }


    }



    private void printFinalDiagnosis(ArrayList<Diagnosis> diagnosis){
        int i = 1;
        for(Diagnosis d : diagnosis){
            Log.i("DIAGOSIS " + i , d.getName());
            i++;
        }
    }




    private boolean hasOtherPossibleDiagnosis(ArrayList<Symptom> selected, ArrayList<Diagnosis> finalDiag){
        if (!finalDiag.isEmpty()) {//may laman ba yung final diagnosis

            if(possibleDiagnosis.isEmpty()) return false; // kung walang laman possible diagnsis matic na yon  na walang ibang possible diagnosis duh..

            if( selected.size() > finalDiag.get(0).getSymptomList().size()) //pag mas madami yung napiling sintomas kesa sa bilang ng sintomas ng na diagnose na
                return true; //ibig sabihin meron pang ibang possible diagnosis
            else
                return false; //kung hindi naman edi matic yon sya lang

        }else{ //kung walang laman yung final diag, matic na yon syempre nasa possible diag lahat yon
            return true;
        }

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ResultActivity.this , MainActivity.class);
        startActivity(intent);
        finish();;
        super.onBackPressed();
    }
}










