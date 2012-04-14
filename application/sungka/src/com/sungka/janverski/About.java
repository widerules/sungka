package com.sungka.janverski;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class About extends Activity implements OnClickListener {
	
	public static final int ANDROID_BUILD_GINGERBREAD = 9;
	public static final int SCREEN_ORIENTATION_SENSOR_LANDSCAPE = 6;
	
	TextView jayven, janver, tang, paul;
	Button backjayven, backjanver, backtang, backpaul, backabout;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        
        if (Build.VERSION.SDK_INT >= ANDROID_BUILD_GINGERBREAD) {
            setRequestedOrientation(SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        }
        
        jayven = (TextView) findViewById(R.id.jayven);
        jayven.setOnClickListener(this);
        
        janver = (TextView) findViewById(R.id.janver);
        janver.setOnClickListener(this);
        
        tang = (TextView) findViewById(R.id.tang);
        tang.setOnClickListener(this);
        
        paul = (TextView) findViewById(R.id.paul);
        paul.setOnClickListener(this);
        
        backabout = (Button) findViewById(R.id.backabout);
        backabout.setOnClickListener(this);
        
    }

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if (v == jayven){
			setContentView(R.layout.jayven);
			
			backjayven = (Button) findViewById(R.id.backjayven);
	        backjayven.setOnClickListener(this);
		}
		
		if (v == janver){
			setContentView(R.layout.janver);
			
			backjanver = (Button) findViewById(R.id.backjanver);
	        backjanver.setOnClickListener(this);
	        
		}
		
		if (v == tang){
			setContentView(R.layout.tang);
			
			backtang = (Button) findViewById(R.id.backtang);
	        backtang.setOnClickListener(this);
		}
		
		if (v == paul){
			setContentView(R.layout.paul);
			
			backpaul = (Button) findViewById(R.id.backpaul);
	        backpaul.setOnClickListener(this);
		}
		
		if (v == backjayven){
			Intent intent = new Intent (this, About.class);
			startActivity(intent);
			
			About.this.finish();
		}
		
		if (v == backjanver){
			Intent intent = new Intent (this, About.class);
			startActivity(intent);
			
			About.this.finish();
		}
		
		if (v == backpaul){
			Intent intent = new Intent (this, About.class);
			startActivity(intent);
			
			About.this.finish();
		}
		
		if (v == backtang){
			Intent intent = new Intent (this, About.class);
			startActivity(intent);
			
			About.this.finish();
		}
		
		if (v == backabout){
			Intent intent = new Intent (this, MainMenu.class);
			startActivity(intent);
			
			About.this.finish();
		}

	}

}
