package com.example.tanmayjha.studentdatabase.Entity.AddStudentDetails;


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
import android.widget.Spinner;

import com.example.tanmayjha.studentdatabase.Control.StudentDatabaseHelper;
import com.example.tanmayjha.studentdatabase.Entity.FamilyDetails.FamilyDetailsFragment;
import com.example.tanmayjha.studentdatabase.Entity.Navigation.MainActivity;
import com.example.tanmayjha.studentdatabase.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddStudentDetailFragment extends Fragment {
    SQLiteDatabase db;
    EditText registrationNumber,studentsName,studentsAddress,studentsPhoneNo,studentsBloodGroup,studentsEmail;
    Spinner studentsSex;
    Button next;
    public AddStudentDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_student_detail, container, false);
    }

    @Override
    public void onStart()
    {
        super.onStart();
        View view=getView();
        registrationNumber=(EditText)view.findViewById(R.id.add_registration_no);
        studentsName=(EditText)view.findViewById(R.id.add_students_name);
        studentsSex=(Spinner)view.findViewById(R.id.add_student_sex);
        studentsAddress=(EditText)view.findViewById(R.id.add_students_address);
        studentsPhoneNo=(EditText)view.findViewById(R.id.add_student_phone_no);
        studentsBloodGroup=(EditText)view.findViewById(R.id.add_students_blood_group);
        studentsEmail=(EditText)view.findViewById(R.id.add_students_email);
        next=(Button)view.findViewById(R.id.next_family_details);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), FamilyDetailsFragment.class);
                intent.putExtra("RegistrationNo",registrationNumber.toString());
                startActivity(intent);
                //how to start new fragment here?
            }
        });
        SQLiteOpenHelper studentDatabaseHelper=new StudentDatabaseHelper(this.getActivity());
        db=studentDatabaseHelper.getWritableDatabase();
        insertStudentDetail(db,registrationNumber.getText().toString(),studentsName.getText().toString(),studentsSex.getSelectedItem().toString(),studentsAddress.getText().toString(),studentsPhoneNo.getText().toString(),studentsBloodGroup.getText().toString(),studentsEmail.getText().toString());
        }

    private static void insertStudentDetail(SQLiteDatabase db, String registrationNo, String name, String sex, String studentAddress, String phoneNo, String bloodGroup, String email)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put("REGISTRATION_NO",registrationNo);
        contentValues.put("NAME",name);
        contentValues.put("SEX",sex);
        contentValues.put("ADDRESS",studentAddress);
        contentValues.put("PHONE_NO",phoneNo);
        contentValues.put("BLOOD_GROUP",bloodGroup);
        contentValues.put("EMAIL",email);
        db.insert("DRINK",null,contentValues);
        //Check for null column hack
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        db.close();
    }

}
