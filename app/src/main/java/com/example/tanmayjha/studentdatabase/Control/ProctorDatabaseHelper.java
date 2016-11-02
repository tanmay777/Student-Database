package com.example.tanmayjha.studentdatabase.Control;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by tanmay jha on 02-11-2016.
 */
public class ProctorDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "proctor details database"; // the name of our database
    private static final int DB_VERSION = 1; // the version of the database

    public ProctorDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context,DB_NAME, factory, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE PROCTOR_DETAIL(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "PROCTOR_NAME TEXT," +
                "PROCTOR_ID TEXT," +
                "PROCTOR_SEX TEXT," +
                "PROCTOR_ADDRESS TEXT," +
                "PROCTOR_PHONE_NO TEXT," +
                "PROCTOR_EMAIL TEXT," +
                "PROCTOR_AGE TEXT," +
                "PROCTOR_DOB TEXT");
        insertProctorDetail(sqLiteDatabase,"Rama","1234","M","C-222","23423423","rama@gmail.com","25","22-dec-91");
    }

    public static void insertProctorDetail(SQLiteDatabase db,String proctorName,String proctorID,String proctorSex,String proctorAddress,String proctorPhoneNo,String proctorEmail,String proctorAge,String proctorDOB)
    {
        ContentValues contentValues=new ContentValues();
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
}
