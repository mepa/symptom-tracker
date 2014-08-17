package com.ladieshack.symptomtracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainMenuActivity extends Activity {
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main_menu);
    }
	
    public void addNewSymptom(View view) {
    	Intent intent = new Intent(this, WholeBodyActivity.class);
    	startActivity(intent);
    }
    
    public void openSymptomHistory(View view) {
    	Intent intent = new Intent(this, SymptomHistoryActivity.class);
    	startActivity(intent);
    }
    
    public void openSymptom(View view) {
    	Intent intent = new Intent(this, OpenSymptomActivity.class);
    	startActivity(intent);
    }
    
    public void reportSymptoms(View view) {
    	Intent intent = new Intent(this, ReportSymptomsActivity.class);
    	startActivity(intent);
    }
}
