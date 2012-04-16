package com.sungka.janverski;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;



public class Login extends Activity implements OnClickListener {
	
	public static final int ANDROID_BUILD_GINGERBREAD = 9;
	public static final int SCREEN_ORIENTATION_SENSOR_PORTRAIT = 7;
	
	public String username;
	public String password;
	
	Button login, reg, nologin;
	
	EditText loginuser;
	EditText loginpass;
	
	// Use of SharedPreferences for storage of Remember Me
	String PREFS = "MyPrefs";
	static SharedPreferences pref;
	
	/** VERY IPORTANT! This defines the IP address of the Web Server (Apache Tomcat) usually ip address of the PC **/
	public static String ip = "192.168.0.2";
	
	/** VERY IPORTANT! This defines the Port # of the Web Server depending on the server settings of Apache Tomcat **/
	public static String port = "8080";
	
	// Flag set if username & pass is correct and remember me is not checked
	public static int noremlogin = 0;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        pref = getSharedPreferences(PREFS, 0);
        
        
        if (Build.VERSION.SDK_INT >= ANDROID_BUILD_GINGERBREAD) {
            setRequestedOrientation(SCREEN_ORIENTATION_SENSOR_PORTRAIT);
        }
        
        boolean rememberMe = pref.getBoolean("rememberMe", false);
        
        if(rememberMe == true){
            //get previously stored login details
            String loginuser = pref.getString("login", null);
            String loginpass = pref.getString("password", null);

            if(loginuser != null && loginpass != null){
                //fill input boxes with stored login and pass
                EditText loginusere = (EditText)findViewById(R.id.loginuser);
                EditText loginpasse = (EditText)findViewById(R.id.loginpass);
                loginusere.setText(loginuser);
                loginpasse.setText(loginpass);

                //set the check box to 'checked' 
                CheckBox rememberbox = (CheckBox)findViewById(R.id.rememberbox);
                rememberbox.setChecked(true);
            }
            else{
            	
            	EditText loginusere = (EditText)findViewById(R.id.loginuser);
                EditText loginpasse = (EditText)findViewById(R.id.loginpass);
            	username = loginusere.getText().toString();
                password = loginpasse.getText().toString();
            }
        }
        
        loginuser = (EditText) findViewById(R.id.loginuser);
        loginpass = (EditText) findViewById(R.id.loginpass);
        
        login = (Button) findViewById(R.id.btnLogin);
        login.setOnClickListener(this);
        
        reg = (Button) findViewById(R.id.btnReg);
        reg.setOnClickListener(this);
        
        nologin = (Button) findViewById(R.id.btnNoLogin);
        nologin.setOnClickListener(this);
        
        
        
    }
    
    private void saveLoginDetails(){
        //fill input boxes with stored login and pass
        EditText loginusere = (EditText)findViewById(R.id.loginuser);
        EditText loginpasse = (EditText)findViewById(R.id.loginpass);
        String loginuser = loginusere.getText().toString();
        String loginpass = loginpasse.getText().toString();

        Editor e = pref.edit();
        e.putBoolean("rememberMe", true);
        e.putString("login", loginuser);
        e.putString("password", loginpass);
        e.commit();
    }
    
    private void saveLoginDetailsNoCheck(){
        //fill input boxes with stored login and pass no save
        EditText loginusere = (EditText)findViewById(R.id.loginuser);
        EditText loginpasse = (EditText)findViewById(R.id.loginpass);
        String loginuser = loginusere.getText().toString();
        String loginpass = loginpasse.getText().toString();

        Editor e = pref.edit();
        e.putBoolean("rememberMe", false);
        e.putString("login", loginuser);
        e.putString("password", loginpass);
        e.commit();
    }
    
    // Deletes login details from SharedPreferences
    public static void removeLoginDetails(){
        Editor e = pref.edit();
        e.putBoolean("rememberMe", false);
        e.remove("login");
        e.remove("password");
        e.commit();
    }

	public void onClick(View v) {
		// TODO Auto-generated method stub
		final Intent register = new Intent (this, Register.class);
		final Intent solo = new Intent (this, MainMenu.class);
		
		CheckBox rememberMeCbx = (CheckBox)findViewById(R.id.rememberbox);
		boolean isChecked = rememberMeCbx.isChecked();
		if(isChecked){
		    saveLoginDetails();
		}else{
			
			saveLoginDetailsNoCheck();
		    noremlogin = 1;
		}
		
		if (v == login){
			
			String resp = null;
	        
			String username = loginuser.getEditableText().toString();
			String password = loginpass.getEditableText().toString();
					
			DefaultHttpClient hc=new DefaultHttpClient();  
			ResponseHandler <String> res=new BasicResponseHandler();  
			HttpPost postMethod=new HttpPost("http://"+ip+":"+port+"/SUNGKA2/MainServlet");  
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(3);    
			nameValuePairs.add(new BasicNameValuePair("action", "loginandroid"));    
			nameValuePairs.add(new BasicNameValuePair("username", username));
			nameValuePairs.add(new BasicNameValuePair("password", password));
			
			try {
				postMethod.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    
			try {
				String response=hc.execute(postMethod,res);
				//Toast.makeText(this, "Successfully Registered!", Toast.LENGTH_LONG).show();
				
				try {
					resp = CustomHttpClient.executeHttpGet("http://"+ip+":"+port+"/SUNGKA2/MainServlet");
					String respo=response.toString();
					
					if(respo.equals("1")){
						
						
						Toast.makeText(this, "Login Successful!", Toast.LENGTH_LONG).show();
						
						
						startActivity(solo);
						Login.this.finish();
					}
					
					else if(respo.equals("0")){
						
						Toast.makeText(this, "User does not exist!", Toast.LENGTH_LONG).show();
					}
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				Toast.makeText(this, "Registration Failed!\nData Error", Toast.LENGTH_LONG).show();
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				Toast.makeText(this, "Registration Failed!\nCheck Internet Connectivity", Toast.LENGTH_LONG).show();
				e.printStackTrace();
			}
			
		}
		
		if (v == reg){
			
			startActivity(register);
			Login.this.finish();
		}
		
		if (v == nologin){
			
			removeLoginDetails();
			
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
