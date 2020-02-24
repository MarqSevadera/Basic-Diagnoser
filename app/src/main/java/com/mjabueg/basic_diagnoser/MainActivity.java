package com.mjabueg.basic_diagnoser;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    boolean ClickTwice = false;
    private static int DELAY_BEFORE_EXPIRY = 3000;

    private ListView listView;
    private SymptomAdapter symptomAdapter;
    private ArrayList<Symptom> symptomList;
    private ArrayList<Symptom> searchList;
    private SearchView searchView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        setTitle(Html.fromHtml("<font color='#ffffff'> Search Symptoms </font>"));
        initView();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu , menu);
        MenuItem item = menu.findItem(R.id.search);
        searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if(TextUtils.isEmpty(s))
                    resetList();
                else
                    SearchString(s);

                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public void onBackPressed(){

        if(ClickTwice){
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            System.exit(0);
        }

        else{
            Toast.makeText(MainActivity.this,"Press Back Again to Exit", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable(){
                @Override
                public void run(){
                    ClickTwice = false;

                }
            },DELAY_BEFORE_EXPIRY);

            ClickTwice = true;

        }


    }


    private void initView(){

        initData();

        initDialog();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                overriteArray();

                final ArrayList<Symptom> selected = new ArrayList<>();
                for(Symptom symptom : symptomList){
                    if(symptom.isSelected())
                        selected.add(symptom);
                }


                if(selected.isEmpty()) {
                    showEmptyDialog();
                    return;
                }


                final ProgressDialog pd = new ProgressDialog(MainActivity.this);
                pd.setMessage("Diagnosing..");
                pd.show();

                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pd.dismiss();
                        Intent intent = new Intent(MainActivity.this , ResultActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("ARRAYLIST" , (Serializable) selected);
                        intent.putExtra("BUNDLE" , bundle);
                        startActivity(intent);
                        finish();

                    }
                } , 3000);


            }
        });

        listView = (ListView) findViewById(R.id.symptomsList);
        symptomAdapter = new SymptomAdapter(this , symptomList);
        listView.setAdapter(symptomAdapter);
        addListViewListener(symptomList);

    }


    private void initDialog(){
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        mBuilder.setTitle("Select Symptoms");
        mBuilder.setMessage("Check all the symptoms you're experiencing.Then click the red medical button to diagnose.");
        mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alertDialog = mBuilder.create();
        alertDialog.show();
    }





    private void initData(){

        symptomList = new ArrayList<>();
        searchList = new ArrayList<>();
        symptomList.add(new Symptom("Abdominal pain",false));
        symptomList.add(new Symptom("Aching muscles",false));
        symptomList.add(new Symptom("Bloating",false));
        symptomList.add(new Symptom("Burning sensation of eye",false));
        symptomList.add(new Symptom("Chest pain",false));
        symptomList.add(new Symptom("Chills and sweats",false));
        symptomList.add(new Symptom("Cough",false));
        symptomList.add(new Symptom("Dry eyes",false));
        symptomList.add(new Symptom("Dull headed",false));
        symptomList.add(new Symptom("Fatigue",false));
        symptomList.add(new Symptom("Fever",false));
        symptomList.add(new Symptom("Head pain",false));
        symptomList.add(new Symptom("Hoarseness",false));
        symptomList.add(new Symptom("Insomnia",false));
        symptomList.add(new Symptom("Irregular heartbeat",false));
        symptomList.add(new Symptom("Itchy eyes",false));
        symptomList.add(new Symptom("Loose and watery tools",false));
        symptomList.add(new Symptom("Low energy",false));
        symptomList.add(new Symptom("Muscles cramping",false));
        symptomList.add(new Symptom("Nasal congestion",false));
        symptomList.add(new Symptom("Nausea",false));
        symptomList.add(new Symptom("Pressure in the head",false));
        symptomList.add(new Symptom("Red, watering eyes",false));
        symptomList.add(new Symptom("Runny or stuffy nose",false));
        symptomList.add(new Symptom("Sharp and pelvic cramps",false));
        symptomList.add(new Symptom("Sharp pain in the teeth",false));
        symptomList.add(new Symptom("Shortness of breath",false));
        symptomList.add(new Symptom("Sneezing",false));
        symptomList.add(new Symptom("Sore throat",false));
        symptomList.add(new Symptom("Swelling",false));
        symptomList.add(new Symptom("Swelling around the tooth",false));
        symptomList.add(new Symptom("Upset stomach",false));
        symptomList.add(new Symptom("Vision problems",false));
        symptomList.add(new Symptom("Vomiting",false));

    }



    private void resetList(){
        overriteArray();
        symptomAdapter = new SymptomAdapter(this , symptomList);
        listView.setAdapter(symptomAdapter);
        addListViewListener(symptomList);
    }


    private void SearchString (String str){

            searchList.clear();
            for(Symptom s : symptomList){
                if(s.getName().toLowerCase().contains(str.toLowerCase())){
                    searchList.add(s);
                }
            }

            symptomAdapter = new SymptomAdapter(this , searchList); //populate symptomAdapter with our searched Items
            listView.setAdapter(symptomAdapter);
            addListViewListener(searchList);


    }



    private void addListViewListener(final ArrayList<Symptom> list){

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Symptom symptom = list.get(i);

                if(symptom.isSelected())
                    symptom.setSelected(false);
                else
                    symptom.setSelected(true);

                list.set(i , symptom);

                symptomAdapter.updateRecords(list);
            }
        });
    }


    private void overriteArray(){
        for(Symptom symptom: symptomList){
            for(Symptom searched : searchList){
                if(searched.getName().equals(symptom.getName())){
                    if(searched.isSelected())
                        symptom.setSelected(true);
                }
            }
        }

    }


    private void showEmptyDialog(){
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        mBuilder.setTitle("You did'nt select any symptoms!");
        mBuilder.setMessage("So you're actually fine huh?, get outta here!");
        mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alertDialog = mBuilder.create();
        alertDialog.show();
    }




}
