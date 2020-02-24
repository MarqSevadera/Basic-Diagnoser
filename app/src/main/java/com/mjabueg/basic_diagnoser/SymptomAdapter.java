package com.mjabueg.basic_diagnoser;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SymptomAdapter extends BaseAdapter {
    Activity activity;
    ArrayList<Symptom> symptoms;
    LayoutInflater inflater;

    public SymptomAdapter(Activity activity){
        this.activity = activity;
    }

    public SymptomAdapter(Activity activity , ArrayList<Symptom> symptoms){
        this.symptoms = symptoms;
        this.activity = activity;
        inflater = activity.getLayoutInflater();
    }

    @Override
    public int getCount() {
        return symptoms.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if(view == null){
            view = inflater.inflate(R.layout.list_item_layout, viewGroup , false);
            viewHolder = new ViewHolder();

            viewHolder.symptomName = (TextView) view.findViewById(R.id.tvSymptom);
            viewHolder.ivCheckBox = (ImageView) view.findViewById(R.id.ivCheckBox);

            view.setTag(viewHolder);
        }else
            viewHolder = (ViewHolder) view.getTag();

        Symptom symptom = symptoms.get(i);
        viewHolder.symptomName.setText(symptom.getName());

        if(symptom.isSelected())
            viewHolder.ivCheckBox.setBackgroundResource(R.drawable.checked);
        else
            viewHolder.ivCheckBox.setBackgroundResource(R.drawable.check);


        return view;
    }

    class ViewHolder{
        TextView symptomName;
        ImageView ivCheckBox;
    }


    public void updateRecords(ArrayList<Symptom> symptoms){
        this.symptoms = symptoms;
        notifyDataSetChanged();
    }

}

