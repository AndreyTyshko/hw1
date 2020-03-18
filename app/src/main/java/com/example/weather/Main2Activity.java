package com.example.weather;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class Main2Activity extends AppCompatActivity {

    public final static String TEXT = "Text";
    public final static String TEXT1 = "Text1";
    public String city;
    public String wind;
    public String txtSwitch;

    TextInputEditText cityText;
    Switch switch2;

    private String spinnerText;

    public List<State> states = new ArrayList<>();
    Spinner countriesList;
    private int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        cityText = findViewById(R.id.TIET);

        switch2 = findViewById(R.id.switch2);
        Spinner spinner = findViewById(R.id.spinner);
        checkTypeWeather(switch2);
        selectCity(spinner);


        setInitialData();

        stateList(countriesList);
//countriesList.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

    }

    public void onClick(View v) {
        Send send = new Send();
        send.textCity = cityText.getText().toString();
        if (switch2.isChecked()) {
            send.windText = switch2.getText().toString();
        }

        city = cityText.getText().toString();
        Intent intent = new Intent(this, MainActivity.class);

        intent.putExtra(TEXT, send);
        countriesList.getItemAtPosition(position);
        //  intent.putExtra(TEXT1, position);


        //intent.putExtra("text1", String.valueOf(countriesList.getContext()));
        if (city.equals("")) {
            showToast(v);
        } else startActivity(intent);


       /* Intent intent1 = new Intent(Main2Activity.this, MainActivity.class);
        //states.get(position);
        //states.get()
        //State selectedState = (State) parent.getItemAtPosition(position);

        startActivity(intent1);*/

    }
   /* public void stateList() {
        countriesList = (Spinner) findViewById(R.id.countriesList);
        StateAdapter stateAdapter = new StateAdapter(this, R.layout.list_item, states);

        countriesList.setAdapter(stateAdapter);

        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                State selectedState = (State) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Был выбран пункт " + selectedState.getName(), Toast.LENGTH_SHORT).show();

            }
        };

       // countriesList.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) itemListener);
    }
*/




    public void stateList(Spinner countriesList) {



        StateAdapter stateAdapter = new StateAdapter(this, R.layout.list_item, states);
        this.countriesList = findViewById(R.id.countriesList);
        this.countriesList.setAdapter(stateAdapter);

       // stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        State state = (State) ((Spinner) findViewById(R.id.countriesList)).getSelectedItem();



    }


    private void selectCity(final Spinner spinner) {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View itemSelected, int selectedItemPosition, long Id) {

                String[] choose = getResources().getStringArray(R.array.cityList);
                Toast toast = Toast.makeText(getApplicationContext(), "Ваш выбор: " + choose[selectedItemPosition], Toast.LENGTH_SHORT);
                toast.show();

                spinnerText = spinner.getSelectedItem().toString();
                cityText.setText(spinnerText);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }


        });


    }

    public void setInitialData() {
        states.add(new State("Бразилия", "Бразилиа", R.drawable.brazilia));
        states.add(new State("Аргентина", "Буэнос-Айрес", R.drawable.argentina));
        states.add(new State("Колумбия", "Богота", R.drawable.colombia));
        states.add(new State("Уругвай", "Монтевидео", R.drawable.uruguai));
        states.add(new State("Чили", "Сантьяго", R.drawable.chile));

    }

    private void checkTypeWeather(Switch switch2) {
        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    txtSwitch = "Ветренно";
                    Toast.makeText(getApplicationContext(), "Включено", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Выключено", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void showToast(View view) {
        Toast mToast = Toast.makeText(getApplicationContext(), "Ведите текст", Toast.LENGTH_SHORT);
        mToast.show();
    }


}
