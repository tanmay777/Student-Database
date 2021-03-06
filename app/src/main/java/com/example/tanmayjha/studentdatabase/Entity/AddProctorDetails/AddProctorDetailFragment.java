package com.example.tanmayjha.studentdatabase.Entity.AddProctorDetails;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.tanmayjha.studentdatabase.Boundary.FragmentChangeListener;
import com.example.tanmayjha.studentdatabase.Control.ProctorDatabaseHelper;
import com.example.tanmayjha.studentdatabase.Entity.AddGuardianDetails.AddGuardianDetailFragment;
import com.example.tanmayjha.studentdatabase.Entity.GuardianDetails.GuardianDetailFragment;
import com.example.tanmayjha.studentdatabase.Entity.ProctorDetails.ProctorDetailsFragment;
import com.example.tanmayjha.studentdatabase.R;

import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddProctorDetailFragment extends Fragment {
    SQLiteDatabase db;
    EditText proctorName,proctorId,proctorAddress,proctorPhoneNo,proctorEmail,proctorAge,proctorsStudentRegistrationNo;
    Spinner proctorSex;
    DatePicker proctorDob;
    Button next;

    public AddProctorDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_proctor_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        proctorName = (EditText) view.findViewById(R.id.add_proctor_name);
        proctorId = (EditText) view.findViewById(R.id.add_proctor_id);
        proctorSex = (Spinner) view.findViewById(R.id.add_proctor_sex);
        proctorAddress = (EditText) view.findViewById(R.id.add_proctor_address);
        proctorPhoneNo = (EditText) view.findViewById(R.id.add_proctor_phone_no);
        proctorEmail = (EditText) view.findViewById(R.id.add_proctor_email);
        proctorAge = (EditText) view.findViewById(R.id.add_proctor_age);
        proctorDob = (DatePicker) view.findViewById(R.id.add_proctor_dob);
        //HERE I AM ADDING ANOTHER ATTRIBUTE,i.e PROCOTOR_OF
        next = (Button) view.findViewById(R.id.next_guardian_detail);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteOpenHelper proctorDatabaseHelper = new ProctorDatabaseHelper(getActivity());
                db = proctorDatabaseHelper.getWritableDatabase();
                insertProctorDetail(db,getArguments().getString("RegistrationNo"),proctorName.getText().toString(),proctorId.getText().toString(),proctorSex.getSelectedItem().toString(),proctorAddress.getText().toString(),proctorPhoneNo.getText().toString(),proctorEmail.getText().toString(),proctorAge.getText().toString(),proctorDob.getDayOfMonth()+""+proctorDob.getDayOfMonth()+1+""+proctorDob.getYear()+"");
                Fragment fr=new AddGuardianDetailFragment();
                FragmentChangeListener fc=(FragmentChangeListener)getActivity();
                Bundle args=new Bundle();
                args.putString("RegistrationNo",getArguments().getString("RegistrationNo"));
                fr.setArguments(args);
                fc.replaceFragment(fr);
            }
        });
    }

    public static void insertProctorDetail(SQLiteDatabase db,String proctorOf,String proctorName,String proctorID,String proctorSex,String proctorAddress,String proctorPhoneNo,String proctorEmail,String proctorAge,String proctorDOB)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put("PROCTOR_OF",proctorOf);
        contentValues.put("PROCTOR_NAME",proctorName);
        contentValues.put("PROCTOR_ID",proctorID);
        contentValues.put("PROCTOR_SEX",proctorSex);
        contentValues.put("PROCTOR_ADDRESS",proctorAddress);
        contentValues.put("PROCTOR_PHONE_NO",proctorPhoneNo);
        contentValues.put("PROCTOR_EMAIL",proctorEmail);
        contentValues.put("PROCTOR_AGE",proctorAge);
        contentValues.put("PROCTOR_DOB",proctorDOB);
        db.insert("PROCTOR_DETAIL",null,contentValues);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        db.close();
    }
}
