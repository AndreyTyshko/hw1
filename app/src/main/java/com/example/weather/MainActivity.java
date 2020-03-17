package com.example.weather;

import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static com.example.weather.Main2Activity.TEXT;
import static com.example.weather.Main2Activity.TEXT1;


public class MainActivity extends AppCompatActivity {


    public List<State> states = new ArrayList<>();
    ListView countriesList;
    private Object State;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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



       // countriesList= (ListView) getIntent().getExtras().getSerializable(TEXT1);
        //String text = getIntent().getExtras().getString(TEXT1);
       /* Bundle extras = getIntent().getExtras();
        states = extras.getStringArray(TEXT1);*/
        // countriesList = getIntent().getParcelableExtra(TEXT1);
      // countriesList = (ListView) getIntent().getExtras().getSerializable(TEXT1);

        stateList(getParent());
        setInitialData();
    }


    public void stateList(Object state) {
        countriesList = findViewById(R.id.countriesList);
        StateAdapter stateAdapter = new StateAdapter(this, R.layout.list_item, states);

        countriesList.setAdapter(stateAdapter);

        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                State selectedState = (State) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Был выбран пункт " + selectedState.getName(), Toast.LENGTH_SHORT).show();

            }
        };

        countriesList.setOnItemClickListener(itemListener);
    }


    public void setInitialData() {
        states.add(new State("Бразилия", "Бразилиа", R.drawable.brazilia));
        states.add(new State("Аргентина", "Буэнос-Айрес", R.drawable.argentina));
        states.add(new State("Колумбия", "Богота", R.drawable.colombia));
        states.add(new State("Уругвай", "Монтевидео", R.drawable.uruguai));
        states.add(new State("Чили", "Сантьяго", R.drawable.chile));

    }



}



