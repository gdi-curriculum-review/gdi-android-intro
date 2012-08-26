package com.gdi.shapedrawable;

import com.gdi.touchshapes.R;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

public class shapeDrawable extends Activity {
    /** Called when the activity is first created. */
	/*Declare variables for width, height and color, and for all the widgets we will be using.*/
	public int width;
	public int height;
	public int color;
	Button button;
	EditText widthText;
	EditText heightText;
	Spinner colorSpinner;
	 ImageView iView;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
   /*Use id as written in main.xml to tell which buttons, etc. we are using*/
        button = (Button)this.findViewById(R.id.button1);
        widthText = (EditText)this.findViewById(R.id.editText1);
        heightText = (EditText)this.findViewById(R.id.editText2);
        colorSpinner = (Spinner)this.findViewById(R.id.spinner1);
        
       /*When the button is clicked, do something*/ 
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	/*Get the width entered into the text box as a string and parse it as an integer*/
	          	 String widthString=widthText.getText().toString();
	          	 width=Integer.parseInt(widthString);
	          	/*Get the height entered into the text box as a string and parse it as an integer*/
	          	 String heightString=heightText.getText().toString();
	          	 height=Integer.parseInt(heightString);
	          	 /*Get the select position of the spinner. For each possible position, set a color*/
	          	 int colorPos=colorSpinner.getSelectedItemPosition();
	          	 if (colorPos==0){
	          		 color=Color.GREEN;
	          	 }
	          	 else if(colorPos==1){
	          		 color=Color.BLUE;
	          	 }
	          	 else if(colorPos==2){
	          		 color=Color.MAGENTA;
	          	 }
	          	 else{
	          		 color=Color.CYAN;
	          	 }
	        /*Declare a new drawable shape named rectangle*/  	 
            ShapeDrawable rectangle = new ShapeDrawable ();
            /*Say that rectangle is a RectShape(), a built in method for drawing rectangles*/
            rectangle.setShape(new RectShape());
            /*set  the height and width to what the user gave us*/
            rectangle.setIntrinsicHeight(width);
            rectangle.setIntrinsicWidth(height);
            /*set the color to what the user gave us*/
            rectangle.getPaint().setColor(color);
            /*Set our imageview as the image view we put in our layout*/
            iView = (ImageView)findViewById(R.id.imageView1);
            /*Draw our rectangle in the image view*/
            iView.setImageDrawable(rectangle); 
            }
        });
          	 
        
    }
}
/*****/