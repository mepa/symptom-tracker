package com.ladieshack.symptomtracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {

    //create SQL table
    //checkfordb = os.system("ls sym-track.db")

    //con = lite.connect('sym-track.db')
    //with con:
    //cur = con.cursor()
    //if checkfordb > 0:
    //    print 'making a new database sym-track.db'
    //   cur.execute("CREATE TABLE userx(user_id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, firstname VARCHAR, dob DATE)")
    //   cur.execute("CREATE TABLE event( event_id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, user_id INTEGER, start_date DATE, start_time VARCHAR, end_date DATE, end_time VARCHAR, duration FLOAT, body_part VARCHAR, symptom VARCHAR, intensity INTEGER, temperature FLOAT)")


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Check if database table with user information exists
        boolean userExists = false;
        
        // if it does not
        if (!userExists)
        	setContentView(R.layout.activity_new_user);
	//    cur.execute("INSERT INTO userx (firstname, dob) VALUES ('"+username+"','"+dateofbirth+"')")



        else {
        	Intent intent = new Intent(this, MainMenuActivity.class);
        	startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void goToMainMenu(View view) {
    	Intent intent = new Intent(this, MainMenuActivity.class);
    	startActivity(intent);
    }
}
