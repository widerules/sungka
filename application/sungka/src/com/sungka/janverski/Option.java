package com.sungka.janverski;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

public class Option extends Activity implements OnItemSelectedListener, OnClickListener{
	
	public static final int ANDROID_BUILD_GINGERBREAD = 9;
	public static final int SCREEN_ORIENTATION_SENSOR_LANDSCAPE = 6;
	
	int image_index = 0;
	
	Spinner board;
	
	
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
	
        board = (Spinner) findViewById(R.id.board);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this, R.array.board_arrays, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        board.setAdapter(adapter);
        board.setOnItemSelectedListener(this);
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if (v == back){
			Intent intent = new Intent (this, MainMenu.class);
			startActivity(intent);
			
			Option.this.finish();
		}

	}

    public void onItemSelected(AdapterView<?> arg0, View arg1,
            int position, long arg3) {
    	
    	Editor editor= getSharedPreferences("boardid", 0).edit();

                    if(board.getSelectedItem().equals("Blue")){
                    	
                    	image_index = 0;	
                    	
                    	editor.putInt("boardid", image_index);
                        editor.commit();
              
                    }
                    
                    else if (board.getSelectedItem().equals("Black")) {
                    	
                    	image_index = 1;	
                    	
                    	editor.putInt("boardid", image_index);
                        editor.commit();
						
					}
                    
                    else if (board.getSelectedItem().equals("Green")) {
                    	
                    	image_index = 2;	

                    	editor.putInt("boardid", image_index);
                        editor.commit();
						
					}
                    
                    else if (board.getSelectedItem().equals("Yellow")) {
                    	
                    	image_index = 3;	

                    	editor.putInt("boardid", image_index);
                        editor.commit();
						
					}
    }    
   
    public void onNothingSelected(AdapterView<?> arg0) {
    	
    	Editor editor= getSharedPreferences("boardid", 0).edit();
    	
    	image_index = 0;	

    	editor.putLong("boardid", image_index);
        editor.commit();
    }

}
