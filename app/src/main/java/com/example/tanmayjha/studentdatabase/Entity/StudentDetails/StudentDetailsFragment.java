package com.example.tanmayjha.studentdatabase.Entity.StudentDetails;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tanmayjha.studentdatabase.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StudentDetailsFragment extends Fragment {

    TextView registrationNumber,studentsName,studentSex,studentsAddress,studentsPhoneNo,studentsBloodGroup,studentsEmail;

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
        registrationNumber=(TextView) view.findViewById(R.id.student_registration_no);
        studentsName=(TextView) view.findViewById(R.id.students_name);
        studentSex=(TextView)view.findViewById(R.id.students_sex);
        studentsAddress=(TextView)view.findViewById(R.id.students_address);
        studentsPhoneNo=(TextView)view.findViewById(R.id.students_phone_no);
        studentsBloodGroup=(TextView)view.findViewById(R.id.students_blood_group);
        studentsEmail=(TextView)view.findViewById(R.id.students_email_address);

        
    }

}
