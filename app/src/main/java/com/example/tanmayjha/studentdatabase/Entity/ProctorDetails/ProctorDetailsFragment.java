package com.example.tanmayjha.studentdatabase.Entity.ProctorDetails;


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

import com.example.tanmayjha.studentdatabase.Control.ProctorDatabaseHelper;
import com.example.tanmayjha.studentdatabase.Control.StudentDatabaseHelper;
import com.example.tanmayjha.studentdatabase.R;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProctorDetailsFragment extends Fragment {
    private SQLiteDatabase db;
    private Cursor cursor;
    EditText registrationNo;
    TextView proctorName,proctorId,proctorSex,proctorOfficeAddress,proctorPhoneNo,proctorEmail,proctorAge,proctorBirthdate;
    Button done;

    public ProctorDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_proctor_details, container, false);
    }

    @Override
    public void onStart()
    {
        super.onStart();
        View view=getView();
        registrationNo=(EditText)view.findViewById(R.id.proctor_registration_no);
        proctorName=(TextView)view.findViewById(R.id.proctor_name);
        proctorId=(TextView)view.findViewById(R.id.proctor_id);
        proctorSex=(TextView)view.findViewById(R.id.proctor_sex);
        proctorOfficeAddress=(TextView)view.findViewById(R.id.proctor_office_no);
        proctorPhoneNo=(TextView)view.findViewById(R.id.proctor_phone_no);
        proctorEmail=(TextView)view.findViewById(R.id.proctor_email_address);
        proctorAge=(TextView)view.findViewById(R.id.proctor_age);
        proctorBirthdate=(TextView)view.findViewById(R.id.proctor_birthdate);
        done=(Button)view.findViewById(R.id.proctor_detail_fragment_done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    SQLiteOpenHelper proctorDatabaseHelper  = new ProctorDatabaseHelper(getActivity());
                    db = proctorDatabaseHelper.getReadableDatabase();
                    cursor = db.query("PROCTOR_DETAIL",
                            new String[]{"PROCTOR_NAME","PROCTOR_OF","PROCTOR_ID","PROCTOR_SEX","PROCTOR_ADDRESS","PROCTOR_PHONE_NO","PROCTOR_EMAIL","PROCTOR_AGE","PROCTOR_DOB"},
                            "PROCTOR_OF= ?",
                            new String[]{registrationNo.getText().toString()},
                            null, null, null);
                    if(cursor.moveToFirst()){
                        proctorName.setText(cursor.getString(0));
                        proctorId.setText(cursor.getString(2));
                        proctorSex.setText(cursor.getString(3));
                        proctorOfficeAddress.setText(cursor.getString(4));
                        proctorPhoneNo.setText(cursor.getString(5));
                        proctorEmail.setText(cursor.getString(6));
                        proctorAge.setText(cursor.getString(7));
                        proctorBirthdate.setText(cursor.getString(8));
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
