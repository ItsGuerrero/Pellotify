package com.example.pestanas;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MiPageAdapter extends FragmentStateAdapter {
    public MiPageAdapter(MainActivity activity) {
        super(activity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new Tab1();

            case 1:
                return new Tab2();
            case 2:
                return new Tab3();
            case 3:
                return new Tab4();

        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 4;
    }

}
