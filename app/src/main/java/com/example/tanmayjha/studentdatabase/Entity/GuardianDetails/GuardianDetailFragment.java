package com.example.tanmayjha.studentdatabase.Entity.GuardianDetails;


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

import com.example.tanmayjha.studentdatabase.Control.GuardianDatbaseHelper;
import com.example.tanmayjha.studentdatabase.Control.StudentDatabaseHelper;
import com.example.tanmayjha.studentdatabase.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GuardianDetailFragment extends Fragment {

    private SQLiteDatabase db;
    private Cursor cursor;
    EditText registrationNo;
    TextView guardianName,guardianaddress,guardianPhoneNo,guardianEmail,guardianSex;
    Button done;
    public GuardianDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_guardian_detail, container, false);
    }

    @Override
    public void onStart()
    {
        super.onStart();
        View view=getView();
        registrationNo=(EditText)view.findViewById(R.id.guardian_fragemnts_registration_no);
        guardianName=(TextView)view.findViewById(R.id.guardian_name);
        guardianaddress=(TextView)view.findViewById(R.id.guardian_address);
        guardianPhoneNo=(TextView)view.findViewById(R.id.guardian_phone_no);
        guardianEmail=(TextView)view.findViewById(R.id.guardian_email);
        guardianSex=(TextView)view.findViewById(R.id.guardian_sex);
        done=(Button)view.findViewById(R.id.guardian_detail_fragment_button);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    SQLiteOpenHelper guardianDatbaseHelper  = new GuardianDatbaseHelper(getActivity());
                    db = guardianDatbaseHelper.getReadableDatabase();
                    cursor = db.query("STUDENT_DETAILS",
                            new String[]{"GUARDIAN_OF","GUARDIAN_NAME","GUARDIAN_SEX","GUARDIAN_ADDRESS","GUARDIAN_PHONE_NO","GUARDIAN_EMAIL"},
                            "GUARDIAN_OF= ?",
                            new String[]{registrationNo.getText().toString()},
                            null, null, null);
                    if(cursor.moveToFirst()){
                        guardianName.setText(cursor.getString(1));
                        guardianSex.setText(cursor.getString(2));
                        guardianaddress.setText(cursor.getString(3));
                        guardianPhoneNo.setText(cursor.getString(4));
                        guardianEmail.setText(cursor.getString(5));
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
