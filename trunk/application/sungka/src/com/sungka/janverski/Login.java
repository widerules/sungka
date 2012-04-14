package com.sungka.janverski;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Login extends Activity implements OnClickListener {
	
	public static final int ANDROID_BUILD_GINGERBREAD = 9;
	public static final int SCREEN_ORIENTATION_SENSOR_PORTRAIT = 7;
	
	Button login, reg, nologin;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        if (Build.VERSION.SDK_INT >= ANDROID_BUILD_GINGERBREAD) {
            setRequestedOrientation(SCREEN_ORIENTATION_SENSOR_PORTRAIT);
        }
        
        login = (Button) findViewById(R.id.btnLogin);
        login.setOnClickListener(this);
        
        reg = (Button) findViewById(R.id.btnReg);
        reg.setOnClickListener(this);
        
        nologin = (Button) findViewById(R.id.btnNoLogin);
        nologin.setOnClickListener(this);
        
    }

	public void onClick(View v) {
		// TODO Auto-generated method stub
		final Intent register = new Intent (this, Register.class);
		final Intent solo = new Intent (this, MainMenu.class);
		
		if (v == reg){
			
			startActivity(register);
			Login.this.finish();
		}
		
		if (v == nologin){
			
			
            AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
 
            
            alertbox.setMessage("Warning! \nYour scores will not be saved\nRegistration is required for saving game scores");
 
            
            alertbox.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

				public void onClick(DialogInterface arg0, int arg1) {
					startActivity(solo);
					Login.this.finish();
				}
 
                
            });
            
            alertbox.setNeutralButton("Register", new DialogInterface.OnClickListener() {

				public void onClick(DialogInterface arg0, int arg1) {
					startActivity(register);
					Login.this.finish();
				}
 
                
            });
 
            
            alertbox.show();
            
			
		}

	}

}
