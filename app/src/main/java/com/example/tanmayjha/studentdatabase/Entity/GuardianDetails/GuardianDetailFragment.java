package com.example.tanmayjha.studentdatabase.Entity.GuardianDetails;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tanmayjha.studentdatabase.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GuardianDetailFragment extends Fragment {


    public GuardianDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_guardian_detail, container, false);
    }

}
