package com.example.pestanas;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;


public class Tab2 extends Fragment {
    private VideoView mVideo;


    public Tab2() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.fragment_tab2, container, false);
        mVideo=view.findViewById(R.id.videoView);
        mVideo.setVideoURI(Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.video));
        //mVideo.setVideoPath("/storage/emulated/0/video.mp4");
        mVideo.setMediaController(new MediaController(view.getContext()));

        mVideo.start();
        mVideo.requestFocus();

        // Añadir un Toast para mostrar un mensaje de error si el vídeo no se carga
        mVideo.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
                Toast.makeText(view.getContext(), "Error al cargar el vídeo", Toast.LENGTH_LONG).show();

                return false;
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}