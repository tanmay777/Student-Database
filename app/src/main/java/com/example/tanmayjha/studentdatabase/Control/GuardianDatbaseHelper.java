package com.example.tanmayjha.studentdatabase.Control;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by tanmay jha on 02-11-2016.
 */
public class GuardianDatbaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "guardian details database"; // the name of our database
    private static final int DB_VERSION = 1; // the version of the database


    public GuardianDatbaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE GUARDIAN_DETAIL(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "GUARDIAN_OF TEXT,"+
                "GUARDIAN_NAME TEXT," +
                "GUARDIAN_SEX TEXT," +
                "GUARDIAN_ADDRESS TEXT," +
                "GUARDIAN_PHONE_NO TEXT," +
                "GUARDIAN_EMAIL TEXT");
        insertGuardianDetail(sqLiteDatabase,"15BCE0618","Gunjan Jha","F","Bangalore","9382938482","gunjan@gmail.com");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public static void insertGuardianDetail(SQLiteDatabase db,String guardianOf,String guardianName,String guardianSex,String guardianAddress,String guardianPhoneNo,String guardianEmail)
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
}
