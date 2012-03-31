package com.sungka.janverski;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Login extends Activity implements OnClickListener {
	
	public static final int ANDROID_BUILD_GINGERBREAD = 9;
	public static final int SCREEN_ORIENTATION_SENSOR_PORTRAIT = 7;
	
	Button reg, nologin;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        if (Build.VERSION.SDK_INT >= ANDROID_BUILD_GINGERBREAD) {
            setRequestedOrientation(SCREEN_ORIENTATION_SENSOR_PORTRAIT);
        }
        
        reg = (Button) findViewById(R.id.btnReg);
        reg.setOnClickListener(this);
        
        nologin = (Button) findViewById(R.id.btnNoLogin);
        nologin.setOnClickListener(this);
        
    }

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if (v == reg){
			Intent intent = new Intent (this, Register.class);
			startActivity(intent);
		}
		
		if (v == nologin){
			Intent intent = new Intent (this, MainMenu.class);
			startActivity(intent);
		}

	}

}
