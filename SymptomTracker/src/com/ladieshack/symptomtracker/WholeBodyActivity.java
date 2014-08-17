package com.ladieshack.symptomtracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class WholeBodyActivity extends Activity {

	public final static String EXTRA_MESSAGE = "com.ladieshack.symptomtracker.MESSAGE";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whole_body);
    }
    
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.choose_head:
                if (checked) {
                	Intent i = new Intent (this, BodyPartSymptomActivity.class);
                	i.putExtra(EXTRA_MESSAGE, "head");
                	startActivity(i);
                }
                break;
            case R.id.choose_foot:
            	if (checked) {
                	Intent i = new Intent (this, BodyPartSymptomActivity.class);
                	i.putExtra(EXTRA_MESSAGE, "foot");
                	startActivity(i);
                }    
                break;
        }
    }
	
}
