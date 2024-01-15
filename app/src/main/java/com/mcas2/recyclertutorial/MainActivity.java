    package com.mcas2.recyclertutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

    public class MainActivity extends AppCompatActivity {

    ArrayList<HistoricEventModel> historicEventModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Pasos
        * 1. Creamos los arrays
        * 2. Creamos el CardView
        * 3. Creamos el modelo de datos
        * 4. Instanciamos tantas clases como elementos tengan los arrays (método setUpHistoricEvents())
        * 5. Hacemos el adaptador
        * 6. Llamamos al adaptador
        * */

        RecyclerView recyclerView = findViewById(R.id.rvEventos);
        setHistoricEventModels();

        HistoricEventRVAdapter adapter = new HistoricEventRVAdapter(
                this, historicEventModels
        );

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setHistoricEventModels(){
        String[] eventNames = getResources().getStringArray(R.array.historic_event_name);
        String[] eventDates = getResources().getStringArray(R.array.historic_event_date);
        String[] eventLocations = getResources().getStringArray(R.array.historic_event_location);


        for (int i = 0; i < eventNames.length; i++) {
            historicEventModels.add(new HistoricEventModel(
                    eventNames[i],
                    eventDates[i],
                    eventLocations[i]
            ));
        }
    }
}