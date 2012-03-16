package com.sungka.janverski;


import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SungkaActivity extends Activity 
implements OnClickListener{
	
	Button newgame;
	Button opt;
	Button tut;
	
	boolean ctr;
	
	public static final int ANDROID_BUILD_GINGERBREAD = 9;
	public static final int SCREEN_ORIENTATION_SENSOR_LANDSCAPE = 6;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        
        if (Build.VERSION.SDK_INT >= ANDROID_BUILD_GINGERBREAD) {
            setRequestedOrientation(SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        }
        
        newgame = (Button) findViewById(R.id.newgame);
        newgame.setOnClickListener(this);
        
        opt = (Button) findViewById(R.id.option);
        opt.setOnClickListener(this);
        
        tut = (Button) findViewById(R.id.tutorial);
        tut.setOnClickListener(this);
        
    }

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if (v == newgame){
			Intent intent = new Intent (this, Game.class);
			startActivity(intent);
		}
		
		if (v == opt){
			Intent intent = new Intent (this, Option.class);
			startActivity(intent);
		}
		
		if (v == tut){
			Intent intent = new Intent (this, Tutorial.class);
			startActivity(intent);
		}
		
		
	}
}