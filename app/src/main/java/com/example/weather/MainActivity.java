package com.example.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static com.example.weather.Main2Activity.TEXT;
import static com.example.weather.Main2Activity.TEXT1;

//import static com.example.weather.Main2Activity.POSITION;
//import static com.example.weather.Main2Activity.TEXT1;


public class MainActivity extends AppCompatActivity {


    public List<State> states = new ArrayList<>();
    ListView countriesList;
    private Object State;

    String country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView textView1 = new TextView(this);
        textView1.setTextSize(20);
        textView1.setPadding(16, 16, 16, 16);


        TextView cityText = findViewById(R.id.city);

        String tow = getResources().getString(R.string.typeOfWear);

        TextView textView = findViewById(R.id.typeOfWeather);
        textView.setText(tow);



        TextView textViewDate = findViewById(R.id.textViewDate);
        TextView textViewWind = findViewById(R.id.typeOfWind);

        Date currentDate = new Date();
        // Форматирование времени как "день.месяц.год"
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        String dateText = dateFormat.format(currentDate);
        textViewDate.setText(dateText);


        Send send = (Send) getIntent().getExtras().getSerializable(TEXT);
        cityText.setText(send.textCity);
        textViewWind.setText(send.windText);


       Intent intent = getIntent();

      ArrayList<String> arrayFromIntent =(ArrayList<String>) getIntent().getSerializableExtra("list");

        country = intent.getStringExtra(TEXT1);

        Toast toast1 = Toast.makeText(getApplicationContext(), country, Toast.LENGTH_SHORT);
        toast1.show();
       // Integer text = Integer.valueOf(country);


        stateList();
        setInitialData();
    }


    public void stateList() {
        countriesList = findViewById(R.id.countriesList);
        StateAdapter stateAdapter = new StateAdapter(this, R.layout.list_item, states);


        //stateAdapter.getPosition(2);

      countriesList.setAdapter(stateAdapter);
//stateAdapter.getView(2,View convertView, ViewGroup parent);

       //countriesList.getItemAtPosition(Integer.parseInt(country));



    }


    public void setInitialData() {
        states.add(new State("Бразилия", "Бразилиа", R.drawable.brazilia));
        states.add(new State("Аргентина", "Буэнос-Айрес", R.drawable.argentina));
        states.add(new State("Колумбия", "Богота", R.drawable.colombia));
        states.add(new State("Уругвай", "Монтевидео", R.drawable.uruguai));
        states.add(new State("Чили", "Сантьяго", R.drawable.chile));

    }


}



