package com.example.tanmayjha.studentdatabase.Control;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by tanmay jha on 02-11-2016.
 */
public class StudentDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "student details database"; // the name of our database
    private static final int DB_VERSION = 1; // the version of the database

    public StudentDatabaseHelper(Context context) {
        super(context,DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE STUDENT_DETAILS(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "REGISTRATION_NO TEXT," +
                "NAME TEXT," +
                "SEX TEXT," +
                "ADDRESS TEXT," +
                "PHONE_NO TEXT," +
                "BLOOD_GROUP TEXT," +
                "EMAIL TEXT)");
        insertStudentDetail(sqLiteDatabase,"15BCE0618","Tanmay Jha","M","K-628","9790048621","A+","tanmay.jha1@gmail.com");
        insertStudentDetail(sqLiteDatabase,"15BCE0396","Barkha Aggrawal","F","F-338","9790048837","B+","barkha.aggarwal1@gmail.com");
        insertStudentDetail(sqLiteDatabase,"15BCE0143","Vaibhav Aggrawal","M","K-628","9790042341","A+","vaibhav.aggarwal1@gmail.com");
        insertStudentDetail(sqLiteDatabase,"15BCE0960","Paridhi Srivastava","F","F-328","9799842341","AB+","paridhi.srivastava1@gmail.com");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    private static void insertStudentDetail(SQLiteDatabase db,String registrationNo,String name,String sex,String address,String phoneNo,String bloodGroup,String email)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put("REGISTRATION_NO",registrationNo);
        contentValues.put("NAME",name);
        contentValues.put("SEX",sex);
        contentValues.put("ADDRESS",address);
        contentValues.put("PHONE_NO",phoneNo);
        contentValues.put("BLOOD_GROUP",bloodGroup);
        contentValues.put("EMAIL",email);
        db.insert("STUDENT_DETAILS",null,contentValues);

        //Check for null column hack
    }
}
