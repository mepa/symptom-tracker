package com.ladieshack.symptomtracker;

import android.app.Activity;
import android.os.Bundle;

public class OpenSymptomActivity extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_open_symptom);
    }
	
}

//#figure out how long some symptom is open



//print "has this ended yet? yes/no"
//ended = raw_input()
//if ended == "yes":
//    duration = time.time()-starttimecomputer
//    endtime = datetime.datetime.now().time()

	//enddate = datetime.datetime.now().date()
	//enddate = str(enddate)
	//duration = str(duration)
