package com.sungka.janverski;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Option extends Activity implements OnClickListener {
	
	public static final int ANDROID_BUILD_GINGERBREAD = 9;
	public static final int SCREEN_ORIENTATION_SENSOR_LANDSCAPE = 6;
	
	Button back;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.option);
	    
	    if (Build.VERSION.SDK_INT >= ANDROID_BUILD_GINGERBREAD) {
            setRequestedOrientation(SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        }
	    
	    back = (Button) findViewById(R.id.btnback);
        back.setOnClickListener(this);
	
	    // TODO Auto-generated method stub
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if (v == back){
			Intent intent = new Intent (this, SungkaActivity.class);
			startActivity(intent);
		}

	}

}
