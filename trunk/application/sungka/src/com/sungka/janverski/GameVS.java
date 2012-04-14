package com.sungka.janverski;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class GameVS extends Activity implements OnClickListener {
	
	public static final int ANDROID_BUILD_GINGERBREAD = 9;
	public static final int SCREEN_ORIENTATION_SENSOR_LANDSCAPE = 6;
	
	TextView p1pit1, p1pit2, p1pit3, p1pit4, p1pit5, p1pit6, p1pit7, p1pitmain,
		p2pit1, p2pit2, p2pit3, p2pit4, p2pit5, p2pit6, p2pit7, p2pitmain,
		txtTurn, wintext1, wintext2;
	
	int[][] pit = new int[2][8] ;
	
	int turn = 0;
	int hand = 0;
	int index;
	
	public void Calculate(){
		
		int i = index;
		int j = turn;
		boolean isDropping = true;
		boolean pick = true;
		
		hand = pit[turn][index];
		
		while (isDropping) {
			
			if(pick){
				
				hand = pit[j][i];
				pit[j][i] = 0;
				pick = false;
			}
			
			while (hand > 0) {
				
				i += 1;
				
				if (i == 7) {
					
					if (j == turn) {
						
						pit[j][i] += 1;
		                hand -= 1;
						
					} 
					
					if (hand > 0) {
						
						i = -1;
						
						if (j == 0) {
							
							j = 1;
							
						} 
						else {
							
							j = 0;

						}
						
					} 
					
			
				} 
				
				else {
					
					pit[j][i] += 1;
		            hand -= 1;
				}
				
				
			}
			
			if (i == 7) {
				
				isDropping = false;
				
			} 
			else {
				
				if (pit[j][i] > 1) {
					
					pick = true;
					
				}
				
				else if (j == turn) {
					
					int temp = (Math.abs(6 - i));
					
                    pit[turn][7] += pit[0][i] + pit[1][temp];
                    pit[0][i] = 0;
                    pit[1][temp] = 0;
					changeTurn();
					isDropping = false;
				}
				
				else {
					
					changeTurn();
                    isDropping = false;

				}

			}
			
		}
		
		updateBoard();
		
	}
	
	public void changeTurn(){
		
		if (turn == 0) {
			turn = 1;
			
			p1pit1.setClickable(false);
			p1pit2.setClickable(false);
			p1pit3.setClickable(false);
			p1pit4.setClickable(false);
			p1pit5.setClickable(false);
			p1pit6.setClickable(false);
			p1pit7.setClickable(false);
			
			p2pit1.setClickable(true);
			p2pit2.setClickable(true);
			p2pit3.setClickable(true);
			p2pit4.setClickable(true);
			p2pit5.setClickable(true);
			p2pit6.setClickable(true);
			p2pit7.setClickable(true);
		} 
		
		else {
			turn = 0;
			
			p1pit1.setClickable(true);
			p1pit2.setClickable(true);
			p1pit3.setClickable(true);
			p1pit4.setClickable(true);
			p1pit5.setClickable(true);
			p1pit6.setClickable(true);
			p1pit7.setClickable(true);
			
			p2pit1.setClickable(false);
			p2pit2.setClickable(false);
			p2pit3.setClickable(false);
			p2pit4.setClickable(false);
			p2pit5.setClickable(false);
			p2pit6.setClickable(false);
			p2pit7.setClickable(false);

		}
		
		if (pit[0][7] >= 49) {
			Toast.makeText(this, "Player 1 Wins!", Toast.LENGTH_LONG).show();
			
			wintext1.setText("Player 1 Has Already Won");
			wintext2.setText("Player 1 Has Already Won");
		}
		
		else if (pit[1][7] >= 49){
			Toast.makeText(this, "Player 2 Wins!", Toast.LENGTH_LONG).show();
			
			wintext1.setText("Player 2 Has Already Won");
			wintext2.setText("Player 2 Has Already Won");
		}
		
	}
	
	public void updateBoard() {
		
		p1pit1.setText(Integer.toString(pit[0][0]));
		p1pit2.setText(Integer.toString(pit[0][1]));
		p1pit3.setText(Integer.toString(pit[0][2]));
		p1pit4.setText(Integer.toString(pit[0][3]));
		p1pit5.setText(Integer.toString(pit[0][4]));
		p1pit6.setText(Integer.toString(pit[0][5]));
		p1pit7.setText(Integer.toString(pit[0][6]));
		p1pitmain.setText(Integer.toString(pit[0][7]));
		
		p2pit1.setText(Integer.toString(pit[1][0]));
		p2pit2.setText(Integer.toString(pit[1][1]));
		p2pit3.setText(Integer.toString(pit[1][2]));
		p2pit4.setText(Integer.toString(pit[1][3]));
		p2pit5.setText(Integer.toString(pit[1][4]));
		p2pit6.setText(Integer.toString(pit[1][5]));
		p2pit7.setText(Integer.toString(pit[1][6]));
		p2pitmain.setText(Integer.toString(pit[1][7]));
		
		txtTurn.setText("Turn of Player "+ (turn+1));
	}
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.game);
	    
	    // TODO Auto-generated method stub
	    
	    if (Build.VERSION.SDK_INT >= ANDROID_BUILD_GINGERBREAD) {
            setRequestedOrientation(SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        }
	    
	    pit[0][0] = 7;
        pit[0][1] = 7;
        pit[0][2] = 7;
        pit[0][3] = 7;
        pit[0][4] = 7;
        pit[0][5] = 7;
        pit[0][6] = 7;
        pit[0][7] = 0;
        
        pit[1][0] = 7;
        pit[1][1] = 7;
        pit[1][2] = 7;
        pit[1][3] = 7;
        pit[1][4] = 7;
        pit[1][5] = 7;
        pit[1][6] = 7;
        pit[1][7] = 0;
	    
	    
		
	    p1pit1 = (TextView) findViewById(R.id.p1pit1);
	    p1pit2 = (TextView) findViewById(R.id.p1pit2);
	    p1pit3 = (TextView) findViewById(R.id.p1pit3);
	    p1pit4 = (TextView) findViewById(R.id.p1pit4);
	    p1pit5 = (TextView) findViewById(R.id.p1pit5);
	    p1pit6 = (TextView) findViewById(R.id.p1pit6);
	    p1pit7 = (TextView) findViewById(R.id.p1pit7);
	    p1pitmain = (TextView) findViewById(R.id.p1pitmain);
	    
	    p2pit1 = (TextView) findViewById(R.id.p2pit1);
	    p2pit2 = (TextView) findViewById(R.id.p2pit2);
	    p2pit3 = (TextView) findViewById(R.id.p2pit3);
	    p2pit4 = (TextView) findViewById(R.id.p2pit4);
	    p2pit5 = (TextView) findViewById(R.id.p2pit5);
	    p2pit6 = (TextView) findViewById(R.id.p2pit6);
	    p2pit7 = (TextView) findViewById(R.id.p2pit7);
	    p2pitmain = (TextView) findViewById(R.id.p2pitmain);
	    
	    txtTurn = (TextView) findViewById(R.id.txtTurn);
	    
	    wintext1 = (TextView) findViewById(R.id.wintext1);
	    wintext2 = (TextView) findViewById(R.id.wintext2);
	    
	    p1pit1.setOnClickListener(this);
	    p1pit2.setOnClickListener(this);
	    p1pit3.setOnClickListener(this);
	    p1pit4.setOnClickListener(this);
	    p1pit5.setOnClickListener(this);
	    p1pit6.setOnClickListener(this);
	    p1pit7.setOnClickListener(this);

	    
	    p2pit1.setOnClickListener(this);
	    p2pit2.setOnClickListener(this);
	    p2pit3.setOnClickListener(this);
	    p2pit4.setOnClickListener(this);
	    p2pit5.setOnClickListener(this);
	    p2pit6.setOnClickListener(this);
	    p2pit7.setOnClickListener(this);

	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if (v == p1pit1) {
			index = 0;
			Calculate();
		}
		
		if (v == p1pit2) {
			index = 1;
			Calculate();
		}
		
		if (v == p1pit3) {
			index = 2;
			Calculate();
		}
		
		if (v == p1pit4) {
			index = 3;
			Calculate();
		}
		
		if (v == p1pit5) {
			index = 4;
			Calculate();
		}
		
		if (v == p1pit6) {
			index = 5;
			Calculate();
		}
		
		if (v == p1pit7) {
			index = 6;
			Calculate();
		}
		
		
		if (v == p2pit1) {
			index = 0;
			Calculate();
		}
		
		if (v == p2pit2) {
			index = 1;
			Calculate();
		}
		
		if (v == p2pit3) {
			index = 2;
			Calculate();
		}
		
		if (v == p2pit4) {
			index = 3;
			Calculate();
		}
		
		if (v == p2pit5) {
			index = 4;
			Calculate();
		}
		
		if (v == p2pit6) {
			index = 5;
			Calculate();
		}
		
		if (v == p2pit7) {
			index = 6;
			Calculate();
		}

	}

}
