package com.ladieshack.symptomtracker;

import android.app.Activity;
import android.os.Bundle;

public class WholeBodyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whole_body);
    }
	
}


//#this creates the intrinsic lists/ranges for body parts/symptoms/etc

//for b in range (0, i):
//    body = eachline1[b]
//   body = body.replace("\n","")
//    intrinsicappendage.append(body)

//for b in range (0, j):
//    symptom = eachline2[b]
//    symptom = symptom.replace("\n","")
//    intrinsicsymptom.append(body)

//for b in range (0, 10):
//    temperature = 96 + float(b) * 10 
//    intrinsictemperature.append(temperature)

//for b in range (0, 10):
//    intensity = b
//    intrinsicintensity.append(intensity)

//#this starts recording the time

//starttimecomputer = time.time()
//startdate = datetime.datetime.now().date()
//startdate = str(startdate)
//starttime = datetime.datetime.now().time()


// print "Where does it hurt?"
//extrinsicbodypart = raw_input()

//print "How does it hurt? ache, chills "
//extrinsicsymptom = raw_input() 


//print "What is your temperature?"
//extrinsictemperature = raw_input()

//print "On a scale of 1-10 how severe is your %s ?" % extrinsicsymptom
//extrinsicintensity = raw_input()


//    cur.execute("INSERT INTO event (user_id, start_date, start_time, end_date, end_time, duration, body_part, symptom, intensity, temperature)  SELECT user_id, "+startdate+",'"+starttime+"',"+enddate+",'"+endtime+"',"+duration+",'"+extrinsicbodypart+"','"+extrinsicsymptom+"',"+extrinsicintensity+","+extrinsictemperature+" FROM userx WHERE userx.firstname = '"+username+"'")


