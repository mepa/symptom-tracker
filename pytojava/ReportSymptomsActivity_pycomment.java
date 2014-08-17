package com.ladieshack.symptomtracker;

import android.app.Activity;
import android.os.Bundle;

public class ReportSymptomsActivity extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_report_symptoms);
    }
	
}


//#These never worked properly
//#Make a db call 

//    startdate_db = cur.execute("SELECT start_date from event")
//    intensity_db = cur.execute("SELECT intensity from event")

//startdate_db = float(startdate_db.replace("|", " "))
//intensity_db = float(intensity_db.replace("|", " "))

//#do something here with plotting
//pl.plot(startdate_db, intensity_db)

