package com.example.tanmayjha.studentdatabase.Entity.AddGuardianDetails;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.tanmayjha.studentdatabase.Control.GuardianDatbaseHelper;
import com.example.tanmayjha.studentdatabase.Control.ProctorDatabaseHelper;
import com.example.tanmayjha.studentdatabase.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddGuardianDetailFragment extends Fragment {
    SQLiteDatabase db;
    Button next;
    Spinner guardianSex;
    EditText guardianName,guardianaddress,guardianPhoneNo,guardianEmail;

    public AddGuardianDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_guardian_detail, container, false);
    }

    @Override
    public void onStart()
    {
        super.onStart();
        View view=getView();
        next=(Button)view.findViewById(R.id.the_end);
        guardianSex=(Spinner)view.findViewById(R.id.add_guardian_sex);
        guardianName=(EditText)view.findViewById(R.id.add_guardian_name);
        guardianaddress=(EditText)view.findViewById(R.id.add_guardian_address);
        guardianPhoneNo=(EditText)view.findViewById(R.id.add_guardian_phone_no);
        guardianEmail=(EditText)view.findViewById(R.id.add_guardian_email);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        SQLiteOpenHelper guardianDatbaseHelper = new GuardianDatbaseHelper(this.getActivity());
        db = guardianDatbaseHelper.getWritableDatabase();
        insertGuardianDetail(db,registrationno,guardianName.getText().toString(),guardianSex.getSelectedItem().toString(),guardianaddress.getText().toString(),guardianPhoneNo.getText().toString(),guardianEmail.getText().toString());
    }

    public static void insertGuardianDetail(SQLiteDatabase db, String guardianOf, String guardianName, String guardianSex, String guardianAddress, String guardianPhoneNo, String guardianEmail)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put("GUARDIAN_OF",guardianOf);
        contentValues.put("GUARDIAN_NAME",guardianName);
        contentValues.put("GUARDIAN_SEX",guardianSex);
        contentValues.put("GUARDIAN_ADDRESS",guardianAddress);
        contentValues.put("GUARDIAN_PHONE_NO",guardianPhoneNo);
        contentValues.put("GUARDIAN_EMAIL",guardianEmail);
        db.insert("GUARDIAN_DETAIL",null,contentValues);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        db.close();
    }

}
