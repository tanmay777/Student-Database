package com.example.tanmayjha.studentdatabase.Control;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by tanmay jha on 02-11-2016.
 */
public class FamilyDatabaseHelper extends SQLiteOpenHelper{

    private static final String DB_NAME = "family details database"; // the name of our database
    private static final int DB_VERSION = 1; // the version of the database

    public FamilyDatabaseHelper(Context context) {
        super(context,DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE FAMILY_DETAILS(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "PARENT_OF TEXT,"+
                "FATHERS_NAME TEXT," +
                "MOTHERS_NAME TEXT," +
                "ADDRESS TEXT," +
                "FATHERS_PHONENO TEXT," +
                "MOTHERS_PHONENO TEXT," +
                "FATHERS_EMAIL TEXT," +
                "MOTHERS_EMAIL TEXT)");
        insertFamilyDetails(sqLiteDatabase,"15BCE0618","Ajay Jha","Minakshi Jha","Saket,New Delhi","9650488222","9871907913","ajay.jha1@gmail.com","minakshi.jha1@gmail.com");
        insertFamilyDetails(sqLiteDatabase,"15BCE0321","Rakesh Kumar","Rakshita Kumar","SouthExtension,New Delhi","9634488222","9855907913","rakesh.kumar1@gmail.com","rakshita.kumar1@gmail.com");

    }

    public static void insertFamilyDetails(SQLiteDatabase db,String parentOf,String fathersName,String mothersName,String familyAddress,String fathersPhoneNo,String mothersPhoneNo,String fathersEmail,String mothersEmail)
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
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
