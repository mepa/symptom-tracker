package com.ladieshack.symptomtracker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class WholeBodyActivity extends Activity {

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
                if (checked)
                    
                break;
            case R.id.choose_foot:
                if (checked)
                    
                break;
        }
    }
	
}
