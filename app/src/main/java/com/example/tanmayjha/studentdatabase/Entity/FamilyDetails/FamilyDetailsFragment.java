package com.example.tanmayjha.studentdatabase.Entity.FamilyDetails;


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

import com.example.tanmayjha.studentdatabase.Control.FamilyDatabaseHelper;
import com.example.tanmayjha.studentdatabase.Control.StudentDatabaseHelper;
import com.example.tanmayjha.studentdatabase.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FamilyDetailsFragment extends Fragment {
    private SQLiteDatabase db;
    private Cursor cursor;
    EditText registrationNo;
    TextView fathersName,mothersName,familyAddress,fathersPhoneNo,mothersPhoneNo,fathersEmail,mothersEmail;
    Button done;

    public FamilyDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_family_details, container, false);
    }

    @Override
    public void onStart()
    {
        super.onStart();
        View view=getView();
        registrationNo=(EditText)view.findViewById(R.id.family_fragments_registration_no);
        fathersName=(TextView)view.findViewById(R.id.father_name);
        mothersName=(TextView)view.findViewById(R.id.mothers_name);
        familyAddress=(TextView)view.findViewById(R.id.family_address);
        fathersPhoneNo=(TextView)view.findViewById(R.id.fathers_phone_no);
        mothersPhoneNo=(TextView)view.findViewById(R.id.mothers_phone_no);
        fathersEmail=(TextView)view.findViewById(R.id.fathers_email);
        mothersEmail=(TextView)view.findViewById(R.id.mothers_email);
        done=(Button)view.findViewById(R.id.family_detail_fragment_done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    SQLiteOpenHelper familyDatabaseHelper  = new FamilyDatabaseHelper(this);
                    db = familyDatabaseHelper.getReadableDatabase();
                    cursor = db.query("FAMILY_DETAILS",
                            new String[]{"PARENT_OF","FATHERS_NAME","MOTHERS_NAME","ADDRESS","FATHERS_PHONENO","MOTHERS_PHONENO","FATHERS_EMAIL","MOTHERS_EMAIL"},
                            "PARENT_OF= ?",
                            new String[]{registrationNo.getText().toString()},
                            null, null, null);
                    if(cursor.moveToFirst()){
                        fathersName.setText(cursor.getString(1));
                        mothersName.setText(cursor.getString(2));
                        familyAddress.setText(cursor.getString(3));
                        fathersPhoneNo.setText(cursor.getString(4));
                        mothersPhoneNo.setText(cursor.getString(5));
                        fathersEmail.setText(cursor.getString(6));
                        mothersEmail.setText(cursor.getString(7));
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
