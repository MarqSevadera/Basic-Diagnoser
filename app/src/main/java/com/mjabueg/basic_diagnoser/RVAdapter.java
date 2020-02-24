package com.mjabueg.basic_diagnoser;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RVAdapter extends  RecyclerView.Adapter<RVAdapter.DiagnosisViewHolder> {

    public static class DiagnosisViewHolder extends RecyclerView.ViewHolder  {

        CardView cv;
        TextView diagName;
        TextView diagSymptoms;
        TextView diagPrescription;

        DiagnosisViewHolder(View itemView){
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            diagName = (TextView) itemView.findViewById(R.id.diagnosisName);
            diagSymptoms = (TextView) itemView.findViewById(R.id.tvSymptom);
            diagPrescription = (TextView) itemView.findViewById(R.id.tvPrescription);
        }
    }

    ArrayList<Diagnosis> diagnosisList;

    public RVAdapter(ArrayList<Diagnosis> diagnosisList) {
        this.diagnosisList = diagnosisList;
    }



    @Override
    public DiagnosisViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_item, parent, false);
        DiagnosisViewHolder holder = new DiagnosisViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(DiagnosisViewHolder holder, int position) {
        Diagnosis diagnosis = diagnosisList.get(position);
        String name = diagnosis.getName();
        String symptom = concatSymptom(diagnosis);
        String prescription = concatPrescription(diagnosis);
        holder.diagName.setText(name);
        holder.diagSymptoms.setText(symptom);
        holder.diagPrescription.setText(prescription);
    }

    @Override
    public int getItemCount() {
        return diagnosisList.size();
    }





    private String concatSymptom(Diagnosis diagnosis){
        ArrayList<Symptom> symptoms = diagnosis.getSymptomList();
        String result = "";
        int i = 1;
        int size = symptoms.size();

        for(Symptom symptom : symptoms){
            if( i == size)
                result = result + symptom.getName();
            else
                result = result + symptom.getName() + " | ";
            i++;
        }

        return result;
    }


    private String concatPrescription(Diagnosis diagnosis){
        ArrayList<Medicine> medicines = diagnosis.getMedicineList();
        String result = "";
        int i = 1;
        int size = medicines.size();

        for(Medicine meds : medicines){
            if( i == size)
                result = result + meds.getName();
            else
                result = result + meds.getName() + " | ";
            i++;
        }

        return result;
    }

}
