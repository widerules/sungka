package com.sungka.janverski;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
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
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Activity implements OnClickListener {
	
	public static final int ANDROID_BUILD_GINGERBREAD = 9;
	public static final int SCREEN_ORIENTATION_SENSOR_PORTRAIT = 7;
	
	Button regback, btnreg;
	EditText reguser, regpass, regpassv, regfname, reglname, regemail;
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        
        if (Build.VERSION.SDK_INT >= ANDROID_BUILD_GINGERBREAD) {
            setRequestedOrientation(SCREEN_ORIENTATION_SENSOR_PORTRAIT);
        }
        
        reguser = (EditText) findViewById(R.id.reguser);
        regpass = (EditText) findViewById(R.id.regpass);
        regpassv = (EditText) findViewById(R.id.regpassv);
        regfname = (EditText) findViewById(R.id.regfname);
        reglname = (EditText) findViewById(R.id.reglname);
        regemail = (EditText) findViewById(R.id.regemail);
              
        btnreg = (Button) findViewById(R.id.btnreg);
        btnreg.setOnClickListener(this);
        
        regback = (Button) findViewById(R.id.btnregback);
        regback.setOnClickListener(this);
        
    }
	
	public InputStream openHttpConnection(String url){
    	
    	HttpURLConnection huc = null;
    	InputStream istream = null;
    	
    	try {
			URL address = new URL(url);
			URLConnection uconnect = address.openConnection();
			
			if(uconnect instanceof HttpURLConnection){
				huc = (HttpURLConnection) uconnect;
			    huc.connect();
				
			    int response = huc.getResponseCode();
			    
			    if(response == HttpURLConnection.HTTP_OK){
			    	
			    	istream =  huc.getInputStream();
			    	
			    }
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return istream;
    	
    }

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if (v == regback){
			Intent intent = new Intent (this, Login.class);
			startActivity(intent);
			
			Register.this.finish();
		}
		
		if (v == btnreg){
			
			String url = "";
			
			String username = reguser.getEditableText().toString();
			String password = regpass.getEditableText().toString();
			String password2 = regpassv.getEditableText().toString();
			String firstname = regfname.getEditableText().toString();
			String lastname = reglname.getEditableText().toString();
			String email = regemail.getEditableText().toString();
			
			url="http://10.0.2.2:8080/SUNGKA2/MainServlet";
			
			
			DefaultHttpClient hc=new DefaultHttpClient();  
			ResponseHandler <String> res=new BasicResponseHandler();  
			HttpPost postMethod=new HttpPost("http://10.0.2.2:8080/SUNGKA2/MainServlet");  
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(7);    
			nameValuePairs.add(new BasicNameValuePair("action", "signupandroid"));    
			nameValuePairs.add(new BasicNameValuePair("username", username));
			nameValuePairs.add(new BasicNameValuePair("password", password));
			nameValuePairs.add(new BasicNameValuePair("password2", password2));
			nameValuePairs.add(new BasicNameValuePair("fname", firstname));
			nameValuePairs.add(new BasicNameValuePair("lname", lastname));
			nameValuePairs.add(new BasicNameValuePair("address", email));
			try {
				postMethod.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    
			try {
				String response=hc.execute(postMethod,res);
				Toast.makeText(this, "Successfully Registered!", Toast.LENGTH_LONG).show();
				
				Intent intent = new Intent (this, Login.class);
				startActivity(intent);
				
				Register.this.finish();
				
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

	}

}
