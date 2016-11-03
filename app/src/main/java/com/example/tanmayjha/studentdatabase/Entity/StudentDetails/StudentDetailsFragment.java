package com.example.tanmayjha.studentdatabase.Entity.StudentDetails;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tanmayjha.studentdatabase.Control.StudentDatabaseHelper;
import com.example.tanmayjha.studentdatabase.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StudentDetailsFragment extends Fragment {
    private SQLiteDatabase db;
    private Cursor cursor;
    TextView studentsName,studentSex,studentsAddress,studentsPhoneNo,studentsBloodGroup,studentsEmail;
    EditText registrationNumber;
    Button done;

    public StudentDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_details, container, false);
    }

    @Override
    public void onStart()
    {
        super.onStart();
        View view=getView();
        registrationNumber=(EditText) view.findViewById(R.id.student_fragment_registration_no);
        studentsName=(TextView) view.findViewById(R.id.students_name);
        studentSex=(TextView)view.findViewById(R.id.students_sex);
        studentsAddress=(TextView)view.findViewById(R.id.students_address);
        studentsPhoneNo=(TextView)view.findViewById(R.id.students_phone_no);
        studentsBloodGroup=(TextView)view.findViewById(R.id.students_blood_group);
        studentsEmail=(TextView)view.findViewById(R.id.students_email_address);
        done=(Button)view.findViewById(R.id.student_fragment_done);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    SQLiteOpenHelper studentDatabaseHelper  = new StudentDatabaseHelper(this);
                    db = studentDatabaseHelper.getReadableDatabase();
                    cursor = db.query("STUDENT_DETAILS",
                            new String[]{"REGISTRATION_NO","NAME","SEX","ADDRESS","PHONE_NO","BLOOD_GROUP","EMAIL"},
                            "REGISTRATION_NO= ?",
                            new String[]{registrationNumber.getText().toString()},
                            null, null, null);
                    if(cursor.moveToFirst()){
                        studentsName.setText(cursor.getString(1));
                        studentSex.setText(cursor.getString(2));
                        studentsAddress.setText(cursor.getString(3));
                        studentsPhoneNo.setText(cursor.getString(4));
                        studentsBloodGroup.setText(cursor.getString(5));
                        studentsEmail.setText(cursor.getString(6));
                    }

                } catch(SQLiteException e) {
                    Toast toast = Toast.makeText(getActivity(), "Database unavailable", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cursor.close();
        db.close();
    }

}
