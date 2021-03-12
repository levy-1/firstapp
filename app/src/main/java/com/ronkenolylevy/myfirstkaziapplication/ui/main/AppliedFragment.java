package com.ronkenolylevy.myfirstkaziapplication.ui.main;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ronkenolylevy.myfirstkaziapplication.R;

public class AppliedFragment extends Fragment {


    public static AppliedFragment newInstance() {
        return new AppliedFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.applied_fragment, container, false);
    }


}