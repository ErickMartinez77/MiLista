package com.changos.milista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lista;

    String[][] datos = {
            {"Fortnite", "Batalla Real", "2017", "Fortnite es un videojuego del año 2017 desarrollado por la empresa Epic Games, lanzado como diferentes paquetes de software que presentan diferentes modos de juego, pero que comparten el mismo motor general de juego y las mecánicas. Fue anunciado en los Spike Video Game Awards en 2011."},
            {"Apex Legends", "Batalla Real", "2019","Se trata de un juego battle royale desarrollado por Respawn Entertainment (la compañía detrás de la franquicia ‘Titanfall’) y distribuido por EA Games."},
            {"Call of Duty Black Ops 3", "Guerra", "2015","Es un videojuego de disparos en primera persona (FPS), de estilo bélico, creada por Ben Chichoski, desarrollada principal e inicialmente por Infinity Ward, y distribuida por Activision."},
            {"Days Gone", "Supervivencia", "2019","Days Gone es un videojuego en desarrollo de acción-aventura y survival horror, desarrollado por el estudio SIE Bend Studio y que será publicado por Sony Interactive Entertainment en exclusiva para la consola PlayStation 4."},
            {"Fifa 19", "Fútbol", "2018","FIFA 19 es un videojuego arcade de fútbol desarrollado por EA Vancouver y EA Rumania, ayudando también en su desarrollo está también EA España y EA Holanda, como parte de la serie FIFA de Electronic Arts."}

    };

    int [] datosImg = {R.drawable.fortnite, R.drawable.apex, R.drawable.callofduty, R.drawable.daysgone,R.drawable.fifa19};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.Lista1);

        lista.setAdapter(new Adaptador(this,datos,datosImg));

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent visorDetalles = new Intent(view.getContext(), DetallesJuego.class);
                visorDetalles.putExtra("TIT", datos[position][0]);
                visorDetalles.putExtra("DET", datos[position][3]);
                startActivity(visorDetalles);
            }
        });
    }

}
