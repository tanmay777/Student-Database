package com.example.tanmayjha.studentdatabase.Entity.AddFamilyDetails;


import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.tanmayjha.studentdatabase.Boundary.FragmentChangeListener;
import com.example.tanmayjha.studentdatabase.Control.FamilyDatabaseHelper;
import com.example.tanmayjha.studentdatabase.Control.StudentDatabaseHelper;
import com.example.tanmayjha.studentdatabase.Entity.AddProctorDetails.AddProctorDetailFragment;
import com.example.tanmayjha.studentdatabase.Entity.FamilyDetails.FamilyDetailsFragment;
import com.example.tanmayjha.studentdatabase.Entity.ProctorDetails.ProctorDetailsFragment;
import com.example.tanmayjha.studentdatabase.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddFamilyDetailFragment extends Fragment {
    SQLiteDatabase db;
    EditText fathersName,mothersName,familyAddress,fathersPhoneNo,mothersPhoneNo,fathersEmail,mothersEmail;
    Button next;

    public AddFamilyDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_family_detail, container, false);
    }

    @Override
    public void onStart()
    {
        super.onStart();
        View view=getView();
        fathersName=(EditText)view.findViewById(R.id.add_fathers_name);
        mothersName=(EditText)view.findViewById(R.id.add_mothers_name);
        familyAddress=(EditText)view.findViewById(R.id.add_family_address);
        fathersPhoneNo=(EditText)view.findViewById(R.id.add_fathers_phone_no);
        mothersPhoneNo=(EditText)view.findViewById(R.id.add_mothers_phone_no);
        fathersEmail=(EditText)view.findViewById(R.id.add_fathers_email);
        mothersEmail=(EditText)view.findViewById(R.id.add_mothers_email);
        next=(Button)view.findViewById(R.id.next_proctor_details);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fr=new AddProctorDetailFragment();
                FragmentChangeListener fc=(FragmentChangeListener)getActivity();
                Bundle args=new Bundle();
                args.putString("RegistrationNo",getArguments().getString("RegistrationNo"));
                fr.setArguments(args);
                fc.replaceFragment(fr);
            }
        });
        SQLiteOpenHelper familyDatabaseHelper=new FamilyDatabaseHelper(this.getActivity());
        db=familyDatabaseHelper.getWritableDatabase();
        insertFamilyDetails(db,getArguments().getString("RegistrationNo"),fathersName.getText().toString(),mothersName.getText().toString(),familyAddress.getText().toString(),fathersPhoneNo.getText().toString(),mothersPhoneNo.getText().toString(),fathersEmail.getText().toString(),mothersEmail.getText().toString());
    }

    public static void insertFamilyDetails(SQLiteDatabase db, String parentOf,String fathersName,String mothersName,String familyAddress,String fathersPhoneNo,String mothersPhoneNo,String fathersEmail,String mothersEmail)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put("PARENT_OF",parentOf);
        contentValues.put("FATHERS_NAME",fathersName);
        contentValues.put("MOTHERS_NAME",mothersName);
        contentValues.put("ADDRESS",familyAddress);
        contentValues.put("FATHERS_PHONENO",fathersPhoneNo);
        contentValues.put("MOTHERS_PHONENO",mothersPhoneNo);
        contentValues.put("FATHERS_EMAIL",fathersEmail);
        contentValues.put("MOTHERS_EMAIL",mothersEmail);
        db.insert("FAMILY_DETAILS",null,contentValues);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        db.close();
    }
}
