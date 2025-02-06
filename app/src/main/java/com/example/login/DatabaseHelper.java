package com.example.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "userdb";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_USERS = "users";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_MOBILE = "mobile";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_USERS + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USERNAME + " TEXT, " +
                COLUMN_PASSWORD + " TEXT, " +
                COLUMN_EMAIL + " TEXT, " +
                COLUMN_MOBILE + " TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    // Check if the user exists and password is correct
    public boolean checkUser(String username, String password) {
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            db = this.getReadableDatabase();
            cursor = db.rawQuery("SELECT * FROM " + TABLE_USERS + " WHERE " +
                    COLUMN_USERNAME + "=? AND " + COLUMN_PASSWORD + "=?", new String[]{username, password});
            return cursor.getCount() > 0;
        } catch (SQLException e) {
            e.printStackTrace();  // Log the error
            return false;
        } finally {
            if (cursor != null) cursor.close();
            if (db != null) db.close();  // Close database connection
        }
    }

    // Get email of the user based on username
    public String getUserEmail(String username) {
        SQLiteDatabase db = null;
        Cursor cursor = null;
        String email = null;
        try {
            db = this.getReadableDatabase();
            cursor = db.rawQuery("SELECT " + COLUMN_EMAIL + " FROM " + TABLE_USERS + " WHERE " +
                    COLUMN_USERNAME + "=?", new String[]{username});
            if (cursor != null && cursor.moveToFirst()) {
                email = cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL));
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Log the error
        } finally {
            if (cursor != null) cursor.close();
            if (db != null) db.close();  // Close database connection
        }
        return email;
    }

    // Get mobile number of the user based on username
    public String getUserMobile(String username) {
        SQLiteDatabase db = null;
        Cursor cursor = null;
        String mobileNo = null;
        try {
            db = this.getReadableDatabase();
            cursor = db.rawQuery("SELECT " + COLUMN_MOBILE + " FROM " + TABLE_USERS + " WHERE " +
                    COLUMN_USERNAME + "=?", new String[]{username});
            if (cursor != null && cursor.moveToFirst()) {
                mobileNo = cursor.getString(cursor.getColumnIndex(COLUMN_MOBILE));
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Log the error
        } finally {
            if (cursor != null) cursor.close();
            if (db != null) db.close();  // Close database connection
        }
        return mobileNo;
    }

    // Method to add a new user to the database
    public boolean addUser(String username, String email, String password, String mobile) {
        SQLiteDatabase db = this.getWritableDatabase();

        // Check if the username already exists
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_USERS + " WHERE " +
                COLUMN_USERNAME + "=?", new String[]{username});

        if (cursor.getCount() > 0) {
            // Username already exists
            cursor.close();
            return false;
        }

        // Insert new user into the database
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, username);
        values.put(COLUMN_PASSWORD, password);
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_MOBILE, mobile);

        long result = db.insert(TABLE_USERS, null, values);
        cursor.close();

        // If the insertion is successful, result will be greater than -1
        return result != -1;
    }
}
