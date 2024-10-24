package com.example.pestanas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //view pager2 nuevo
        ViewPager2 viewPager2=findViewById(R.id.view_pager);
        viewPager2.setAdapter(new MiPageAdapter(this));
        //tabs
        TabLayout tabs=findViewById(R.id.tabs);
       /* tabs.addTab(tabs.newTab().setText("AUDIO"));
        tabs.addTab(tabs.newTab().setText("VIDEO"));
        tabs.addTab(tabs.newTab().setText("EXTRA"));*/
        //view pager2 nuevo
        //tablayoutMediator sirve para asignar los tabs al viewpager e indicamos los nombres
        new TabLayoutMediator (tabs,viewPager2,new TabLayoutMediator.TabConfigurationStrategy(){

            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("PESTAÑA 1");
                        break;
                    case 1:
                        tab.setText("PESTAÑA 2");
                        break;
                    case 2:
                        tab.setText("REPRODUCTOR");
                    case 3:
                        tab.setText("FAVORITOS");
                }
            }
        }).attach();
      /*  tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                final TextView texto=findViewById(R.id.texto);
                switch (tab.getPosition()){
                    case 0:
                        texto.setText("PESTAÑA 1");
                        break;
                    case 1:
                        texto.setText("PESTAÑA 2");
                        break;
                    case 2:
                        texto.setText("PESTAÑA 3");
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });*/

    }
}