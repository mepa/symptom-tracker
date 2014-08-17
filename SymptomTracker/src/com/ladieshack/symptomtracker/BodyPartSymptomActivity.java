package com.ladieshack.symptomtracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class BodyPartSymptomActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Intent intent = getIntent();
        String message = intent.getStringExtra(WholeBodyActivity.EXTRA_MESSAGE);
        if (message.equals("head")) {
            setContentView(R.layout.activity_head_symptoms);
        }
        else if (message.equals("foot")) {
        	setContentView(R.layout.activity_foot_symptoms);
        }
    }
    
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.choose_headache:
                if (checked) {

                }
                break;
            case R.id.choose_fever:
            	if (checked) {

                }    
                break;
            case R.id.choose_blurred_vision:
            	if (checked) {
            		
            	}
            	break;
            case R.id.choose_foot_pain:
                if (checked) {

                }
                break;
            case R.id.choose_foot_limp:
            	if (checked) {

                }    
                break;
            case R.id.choose_foot_soreness:
            	if (checked) {
            		
            	}
            	break;	
        }
    }
	
}
