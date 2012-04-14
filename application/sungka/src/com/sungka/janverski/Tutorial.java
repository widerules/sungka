package com.sungka.janverski;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Tutorial extends Activity implements OnClickListener {
	
	public static final int ANDROID_BUILD_GINGERBREAD = 9;
	public static final int SCREEN_ORIENTATION_SENSOR_LANDSCAPE = 6;
	
	Button tutorialnext, tutorialfinish;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playturn);
        
        if (Build.VERSION.SDK_INT >= ANDROID_BUILD_GINGERBREAD) {
            setRequestedOrientation(SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        }
        
        tutorialnext = (Button) findViewById(R.id.tutorialnext);
        tutorialnext.setOnClickListener(this);
              
    }

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if (v == tutorialnext){
			setContentView(R.layout.playfull);
			
			tutorialfinish = (Button) findViewById(R.id.tutorialfinish);
	        tutorialfinish.setOnClickListener(this);
			
		}
		
		if (v == tutorialfinish){
			
			Intent intent = new Intent (this, MainMenu.class);
			startActivity(intent);
			
			Tutorial.this.finish();
		}

	}

}
