package com.example.pmdmtarea2ud3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    ImageButton play, pause, stop, avance, sigueMusica;
    Switch bucleReproduccion;
    TextView estado;
    int repetir = 2;

    MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.btnPlay);
        pause = findViewById(R.id.btnPause);
        stop = findViewById(R.id.btnStop);
        avance = findViewById(R.id.btnAvance);
        sigueMusica = findViewById(R.id.btnContinua);
        bucleReproduccion = findViewById(R.id.switchBucle);
        estado = findViewById(R.id.textView);
        estado.setText("Detenido");

        play.setBackgroundColor(Color.TRANSPARENT);
        pause.setBackgroundColor(Color.TRANSPARENT);
        stop.setBackgroundColor(Color.TRANSPARENT);
        avance.setBackgroundColor(Color.TRANSPARENT);
        sigueMusica.setBackgroundColor(Color.TRANSPARENT);


        mp = MediaPlayer.create(this, R.raw.theweekndsacrifice);

    }

    public void Play(View view){
        mp.start();
        estado.setText("Reproduciendo");
        play.setBackgroundColor(Color.BLACK);
        pause.setBackgroundColor(Color.TRANSPARENT);
        stop.setBackgroundColor(Color.TRANSPARENT);
    }

    public void Pause(View view){
        mp.pause();
        estado.setText("Pausa");
        play.setBackgroundColor(Color.TRANSPARENT);
        pause.setBackgroundColor(Color.BLUE);
        stop.setBackgroundColor(Color.TRANSPARENT);
    }

    public void Stop(View view){
        mp.stop();
        estado.setText("Finalizado");
        mp = MediaPlayer.create(this, R.raw.theweekndsacrifice);
        play.setBackgroundColor(Color.TRANSPARENT);
        pause.setBackgroundColor(Color.TRANSPARENT);
        stop.setBackgroundColor(Color.RED);

    }

    public void Avanzar(View view){
        
    }

    public void ReproducirBucle(View view){
        if(repetir == 1){
            estado.setText("Reproduciendo");
            mp.setLooping(false);
            repetir = 2;
        } else{
            estado.setText("Reproducción en bucle");
            mp.setLooping(true);
            repetir = 1;
        }


    }
}