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

public class JobSearch extends Fragment {



    public static JobSearch newInstance() {
        return new JobSearch();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.job_search_fragment, container, false);
    }


}