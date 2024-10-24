package com.example.pestanas;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Tab3 extends Fragment {
    private Spinner spinner;
    private Button btnplay, btnpause, btnstop, btnfavorito;
    private SeekBar seekBar;
    private MediaPlayer mediaplayer;
    private int currentSong = -1;
    private Handler handler = new Handler(); // Handler para actualizar la SeekBar

    private int[] canciones = {R.raw.amoalleramos, R.raw.vatoslocos, R.raw.pucabon};

    private static ArrayList<String> listaFavoritos = new ArrayList<>();
    private String[] items = new String[]{"AMO ALLER AMOS", "VATOS LOCOS", "PUCABON"};

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab3, container, false);


        spinner = view.findViewById(R.id.spinner);
        btnplay = view.findViewById(R.id.btnplay);
        btnpause = view.findViewById(R.id.btnpause);
        btnstop = view.findViewById(R.id.btnstop);
        seekBar = view.findViewById(R.id.seekBar);
        btnfavorito = view.findViewById(R.id.btnfavorito);

        // Crear un array de elementos para el Spinner


        // Crear un ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Asignar el adaptador al Spinner
        spinner.setAdapter(adapter);

        // Configurar botón Play
        btnplay.setOnClickListener(v -> playSong());

        // Configurar botón Pause
        btnpause.setOnClickListener(v -> pauseSong());

        // Configurar botón Stop
        btnstop.setOnClickListener(v -> stopSong());

        btnfavorito.setOnClickListener(v -> agregarAFavoritos());

        // Configurar SeekBar para controlar el progreso
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser && mediaplayer != null) {
                    mediaplayer.seekTo(progress); // Adelantar o retroceder la canción
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // No es necesario hacer nada aquí
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // No es necesario hacer nada aquí
            }
        });

        return view;
    }
    private void playSong() {
        int selectedPosition = spinner.getSelectedItemPosition(); // Obtiene la posición seleccionada en el Spinner

        // Si se selecciona una nueva canción o el MediaPlayer no está inicializado
        if (currentSong != selectedPosition) {
            if (mediaplayer != null) {
                mediaplayer.release(); // Libera el MediaPlayer si ya está reproduciendo otra canción
            }

            // Inicializa MediaPlayer con la nueva canción
            mediaplayer = MediaPlayer.create(getContext(), canciones[selectedPosition]);
            mediaplayer.start(); // Inicia la reproducción

            currentSong = selectedPosition; // Guarda la posición de la canción actual

            // Configura el SeekBar con la duración de la canción
            seekBar.setMax(mediaplayer.getDuration());

            // Actualiza la SeekBar mientras la canción se reproduce
            updateSeekBar();
        } else if (mediaplayer != null && !mediaplayer.isPlaying()) {
            mediaplayer.start(); // Si la canción ya está cargada, continúa reproduciéndola
            updateSeekBar();
        }
    }

    // Método para pausar la canción
    private void pauseSong() {
        if (mediaplayer != null && mediaplayer.isPlaying()) {
            mediaplayer.pause(); // Pausa la canción actual
        } else {
            Toast.makeText(getContext(), "No hay ninguna canción reproduciéndose", Toast.LENGTH_SHORT).show();
        }
    }

    // Método para detener la canción
    private void stopSong() {
        if (mediaplayer != null) {
            mediaplayer.stop(); // Detiene la reproducción
            mediaplayer.reset(); // Resetea el MediaPlayer para que vuelva al principio
            mediaplayer.release(); // Libera los recursos
            mediaplayer = null;
            currentSong = -1; // Resetea la canción actual

            seekBar.setProgress(0); // Resetea la SeekBar al principio
        }
    }
    // Método para actualizar la SeekBar mientras la canción se reproduce
    private void updateSeekBar() {
        if (mediaplayer != null) {
            seekBar.setProgress(mediaplayer.getCurrentPosition());

            // Ejecuta este bloque de nuevo después de 1 segundo
            handler.postDelayed(this::updateSeekBar, 1000);
        }
    }

    private void agregarAFavoritos() {
        int selectedPosition = spinner.getSelectedItemPosition();
        String cancionFavorita = items[selectedPosition];

        if (!listaFavoritos.contains(cancionFavorita)) {
            listaFavoritos.add(cancionFavorita);
            Toast.makeText(getContext(), "Añadido a Favoritos: " + cancionFavorita, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "La canción ya está en favoritos", Toast.LENGTH_SHORT).show();
        }
    }

    public static ArrayList<String> getListaFavoritos() {
        return listaFavoritos;
    }
}