package com.sungka.janverski;


import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainMenu extends Activity 
implements OnClickListener{
	
	Button newgame, opt, tut, aboutus, exit;
	
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
        
        aboutus = (Button) findViewById(R.id.about);
        aboutus.setOnClickListener(this);
        
        exit = (Button) findViewById(R.id.exit);
        exit.setOnClickListener(this);
        
    }

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if (v == newgame){
			Intent intent = new Intent (this, GameVS.class);
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
		
		if (v == aboutus){
			Intent intent = new Intent (this, About.class);
			startActivity(intent);
		}
		
		if (v == exit){
			finish();
		}
		
		
	}
}