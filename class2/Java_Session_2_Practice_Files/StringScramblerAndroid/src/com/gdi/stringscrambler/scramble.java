package com.gdi.stringscrambler;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class scramble extends Activity {
    /** Called when the activity is first created. */
	/*Create Variables*/
	Button button;
	EditText editText;
	TextView textView;
	String word;
	char[] characters;
	String reversedWord="";
	String scrambledWord="";
	String outputString;
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
        	 word = editText.getText().toString();
        	
        	/*Code from original StringRevers of Week 1.
        	 * Set outputString instead of using System.out.println*/
        	 characters=word.toCharArray();
        	 for (int i=characters.length-1; i>-1; i--){
        			
     			reversedWord=reversedWord + characters[i];
     		}
        	 for (int i=0; i<characters.length; i++){
     			int randomIndex=(int)(Math.random()*characters.length);
     			char temp=characters[i];
     				characters[i]=characters[randomIndex];
     				characters[randomIndex]=temp;
     			
     		}
        	 /*Set new scrambled characters to scrambled word. 
        	  * This is different than the original because setText() does not like to mix
        	  * characters with strings. Everything in Output String must be a string.
        	  */
        	 for (int i=0;i<characters.length; i++){
        		 scrambledWord=scrambledWord+ characters[i];
        	 }
        	 
        	/*Set Text of textView to the outputString*/ 
        	 outputString="You're word backwards:\n"+reversedWord+"\nYou're word scrambled:\n"+scrambledWord;
        	 textView.setText(outputString);
        	 /*Reset reversedWord and scrambledWord*/
        	 reversedWord="";
        	 scrambledWord="";
          }
        });

   
    
    }
}