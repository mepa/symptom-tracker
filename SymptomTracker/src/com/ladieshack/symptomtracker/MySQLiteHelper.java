package com.ladieshack.symptomtracker;
 
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
 
public class MySQLiteHelper extends SQLiteOpenHelper {
 
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "DatabaseDB";
 
    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);  
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create user table
        String CREATE_USER_TABLE = "CREATE TABLE users ( " +
                "user_id INTEGER PRIMARY KEY AUTOINCREMENT, " + 
                "dob DATE)";
 
        // create users table
        db.execSQL(CREATE_USER_TABLE);
        
        // SQL statement to create event table
        String CREATE_EVENT_TABLE = "CREATE TABLE events ( " +
        		"event_id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, " +
        		"user_id INTEGER, " +
        		"start_datetime TIMESTAMP, " +
        		"end_datetime TIMESTAMP, " +
        		"duration FLOAT, " +
        		"body_part VARCHAR, " +
        		"symptom VARCHAR, " +
        		"intensity INTEGER, " +
        		"temperature FLOAT)";
        
        // create events table
        db.execSQL(CREATE_EVENT_TABLE);
    }
    
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older user table if existed
        db.execSQL("DROP TABLE IF EXISTS users");
 
        // create fresh user table
        this.onCreate(db);
        
        // Drop older event table if existed
        db.execSQL("DROP TABLE IF EXISTS events");
 
        // create fresh event table
        this.onCreate(db);
    }
    
    //---------------------------------------------------------------------
    
    /**
     * CRUD operations (create "add", read "get", update, delete) 
     * user + get all users + delete all users
     * 
     *  CRUD operations (create "add", read "get", update, delete) 
     * event + get all events + delete all events
     */
    
    // Users table name
    private static final String TABLE_USERS = "users";
    // Events table name
    private static final String TABLE_EVENTS = "events";
 
    // Users Table Columns names
    private static final String USER_KEY_ID = "user_id";
    private static final String USER_KEY_DOB = "dob";
    // Events Table Columns names
    private static final String EVENT_KEY_ID = "event_id";
    private static final String EVENT_KEY_USER_ID = "user_id";
    private static final String EVENT_KEY_START_DATETIME = "start_datetime";
    private static final String EVENT_KEY_END_DATETIME = "end_datetime";
    private static final String EVENT_KEY_DURATION = "duration";
    private static final String EVENT_KEY_BODY_PART = "body_part";
    private static final String EVENT_KEY_SYMPTOM = "symptom";
    private static final String EVENT_KEY_INTENSITY = "intensity";
    private static final String EVENT_KEY_TEMPERATURE = "temperature";	
 
    private static final String[] USER_COLUMNS = {USER_KEY_ID,USER_KEY_DOB};
    private static final String[] EVENT_COLUMNS = {EVENT_KEY_ID, 
    	EVENT_KEY_USER_ID, 
    	EVENT_KEY_START_DATETIME, 
    	EVENT_KEY_END_DATETIME, 
    	EVENT_KEY_DURATION, 
    	EVENT_KEY_BODY_PART, 
    	EVENT_KEY_SYMPTOM, 
    	EVENT_KEY_INTENSITY, 
    	EVENT_KEY_TEMPERATURE};
 
    @SuppressLint("SimpleDateFormat") public void addUser(User user){
        Log.d("addUser", user.toString());

        SQLiteDatabase db = this.getWritableDatabase();
 
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ContentValues values = new ContentValues();
        values.put(USER_KEY_DOB, dateFormat.format(user.getDOB())); // get date of birth
 
        db.insert(TABLE_USERS, null, values);
        db.close(); 
    }
    
    @SuppressLint("SimpleDateFormat") public void addEvent(Event event){
        Log.d("addEvent", event.toString());
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(EVENT_KEY_USER_ID, event.getUserID()); // get user_id
        values.put(EVENT_KEY_START_DATETIME, dateFormat.format(event.getStartDatetime())); // get start_datetime
        values.put(EVENT_KEY_END_DATETIME, dateFormat.format(event.getEndDatetime())); // get end_datetime
        values.put(EVENT_KEY_DURATION, event.getDuration()); // get duration
        values.put(EVENT_KEY_BODY_PART, event.getBodyPart()); // get body_part
        values.put(EVENT_KEY_SYMPTOM, event.getSymptom()); // get symptom
        values.put(EVENT_KEY_INTENSITY, event.getIntensity()); // get intensity
        values.put(EVENT_KEY_TEMPERATURE, event.getTemperature()); // get temperature
 
        // 3. insert
        db.insert(TABLE_EVENTS, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values
 
        // 4. close
        db.close(); 
    }
    
    public User getUser(int id) throws ParseException{
    	 
        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();
     
        // 2. build query
        Cursor cursor = 
                db.query(TABLE_USERS, // a. table
                USER_COLUMNS, // b. column names
                " id = ?", // c. selections 
                new String[] { String.valueOf(id) }, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
     
        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();
     
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 4. build book object
        User user = new User();
        user.setUserID(Integer.parseInt(cursor.getString(0)));
        user.setDOB(dateFormat.parse(cursor.getString(1)));
     
        //log 
    Log.d("getUser("+id+")", user.toString());
     
        // 5. return book
        return user;
    }

 
    public Event getEvent(int id) throws ParseException{
 
        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();
 
        // 2. build query
        Cursor cursor = 
                db.query(TABLE_EVENTS, // a. table
                EVENT_COLUMNS, // b. column names
                " id = ?", // c. selections 
                new String[] { String.valueOf(id) }, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
 
        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();
 
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 4. build book object
        Event event = new Event();
        event.setEventID(Integer.parseInt(cursor.getString(0)));
        event.setUserID(Integer.parseInt(cursor.getString(1)));
        event.setStartDatetime(dateFormat.parse(cursor.getString(2)));
        event.setEndDatetime(dateFormat.parse(cursor.getString(3)));
        event.setDuration(Float.parseFloat(cursor.getString(4)));
        event.setBodyPart(cursor.getString(5));
        event.setSymptom(cursor.getString(6));
        event.setIntensity(Integer.parseInt(cursor.getString(7)));
        event.setTemperature(Float.parseFloat(cursor.getString(8)));
 
        Log.d("getEvent("+id+")", event.toString());
 
        // 5. return book
        return event;
    }
 
    
    // Get All Users
    public List<User> getAllUsers() throws ParseException {
        List<User> users = new LinkedList<User>();
 
        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_USERS;
 
        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
 
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 3. go over each row, build book and add it to list
        User user = null;
        if (cursor.moveToFirst()) {
            do {
                user = new User();
                user.setUserID(Integer.parseInt(cursor.getString(0)));
                user.setDOB(dateFormat.parse(cursor.getString(1)));
 
                // Add book to books
                users.add(user);
            } while (cursor.moveToNext());
        }
 
        Log.d("getAllUsers()", users.toString());
 
        // return users
        return users;
    }
    
    // Get All Events
    public List<Event> getAllEvents() throws ParseException {
        List<Event> events = new LinkedList<Event>();
 
        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_EVENTS;
 
        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
 
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 3. go over each row, build book and add it to list
        Event event = null;
        if (cursor.moveToFirst()) {
            do {
                event = new Event();
                event.setEventID(Integer.parseInt(cursor.getString(0)));
                event.setUserID(Integer.parseInt(cursor.getString(1)));
                event.setStartDatetime(dateFormat.parse(cursor.getString(2)));
                event.setEndDatetime(dateFormat.parse(cursor.getString(3)));
                event.setDuration(Float.parseFloat(cursor.getString(4)));
                event.setBodyPart(cursor.getString(5));
                event.setSymptom(cursor.getString(6));
                event.setIntensity(Integer.parseInt(cursor.getString(7)));
                event.setTemperature(Float.parseFloat(cursor.getString(8)));
 
                // Add book to books
                events.add(event);
            } while (cursor.moveToNext());
        }
 
        Log.d("getAllEvents()", events.toString());
 
        // return events
        return events;
    }
 
     // Updating single user
    public int updateUser(User user) {
 
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
 
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put("dob", dateFormat.format(user.getDOB())); // get date of birth
 
        // 3. updating row
        int i = db.update(TABLE_USERS, //table
                values, // column/value
                USER_KEY_ID+" = ?", // selections
                new String[] { String.valueOf(user.getUserID()) }); //selection args
 
        // 4. close
        db.close();
 
        return i;
 
    }
    
    // Updating single event
   public int updateEvent(Event event) {

       // 1. get reference to writable DB
       SQLiteDatabase db = this.getWritableDatabase();

       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       // 2. create ContentValues to add key "column"/value
       ContentValues values = new ContentValues();
       values.put("user_id", event.getUserID()); // get user_id
       values.put("start_datetime", dateFormat.format(event.getStartDatetime())); // get start_datetime
       values.put("end_datetime", dateFormat.format(event.getEndDatetime())); // get end_datetime
       values.put("duration", event.getDuration()); // get duration
       values.put("body_part", event.getBodyPart()); // get body_part
       values.put("symptom", event.getSymptom()); // get symptom
       values.put("intensity", event.getIntensity()); // get intensity
       values.put("temperature", event.getTemperature()); // get temperature

       // 3. updating row
       int i = db.update(TABLE_EVENTS, //table
               values, // column/value
               EVENT_KEY_ID+" = ?", // selections
               new String[] { String.valueOf(event.getEventId()) }); //selection args

       // 4. close
       db.close();

       return i;

   }
 
    // Deleting single user
    public void deleteUser(User user) {
 
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
 
        // 2. delete
        db.delete(TABLE_USERS,
                USER_KEY_ID+" = ?",
                new String[] { String.valueOf(user.getUserID()) });
 
        // 3. close
        db.close();
 
        Log.d("deleteUser", user.toString());
 
    }
    
    // Deleting single event
    public void deleteEvent(Event event) {
 
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
 
        // 2. delete
        db.delete(TABLE_EVENTS,
                EVENT_KEY_ID+" = ?",
                new String[] { String.valueOf(event.getEventId()) });
 
        // 3. close
        db.close();
 
        Log.d("deleteEvent", event.toString());
 
    }
    
 
}
