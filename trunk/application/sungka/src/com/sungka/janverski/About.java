package com.sungka.janverski;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class About extends Activity implements OnClickListener {
	
	public static final int ANDROID_BUILD_GINGERBREAD = 9;
	public static final int SCREEN_ORIENTATION_SENSOR_LANDSCAPE = 6;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        
        if (Build.VERSION.SDK_INT >= ANDROID_BUILD_GINGERBREAD) {
            setRequestedOrientation(SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        }
        
        
    }

	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

}
