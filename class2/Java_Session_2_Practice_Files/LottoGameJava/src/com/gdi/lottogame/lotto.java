package com.gdi.lottogame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class lotto extends Activity {
    /** Called when the activity is first created. */
	/*Create Variables*/
	Button button;
	EditText editText;
	TextView textView;
	int guess;
	int answer;
	String guessString;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /*Identify widgets by IDs named in main.xml*/
        button = (Button)this.findViewById(R.id.button1);
        editText = (EditText)this.findViewById(R.id.editText1);
        textView = (TextView)this.findViewById(R.id.textView1);
       
        /*Set event listener for button*/
        button.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
            /*onClick get Text from editText*/
        	 guessString = editText.getText().toString();
        	/*Cast Text as Integer*/
        	 guess=Integer.parseInt(guessString);
        	/*Code from original LottoGame of Week 1.
        	 * Set guessString instead of using System.out.println*/
        	 answer = (int)(Math.random()*6+1);
     		if (guess==answer){
     			guessString="Congratulations! You guessed right!";
     		}
     		else {
     			guessString="Sorry, that wasn't right. The correct answer was " + answer+".";
     		}
        	/*Set Text of textView to the guessString created in the if/else statement*/ 
        	 textView.setText(guessString);
          }
        });

   
    
    }
}