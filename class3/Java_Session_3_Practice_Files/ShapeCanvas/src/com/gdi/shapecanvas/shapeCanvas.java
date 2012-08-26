package com.gdi.shapecanvas;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Canvas;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.View;

public class shapeCanvas extends Activity {
    /** Called when the activity is first created. */
	

    @Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/*Draw a rectangle with width, height and color as defined in the class below*/
		Rectangle myRectangle = new Rectangle(this, 100 ,200,Color.MAGENTA, Color.CYAN);
		setContentView(myRectangle);
		 
		
	}
    
    
    private class Rectangle extends View{
    	/*Declare variables to be used internally whenever our class is called*/
    	private final float x;
    	private final float y;
    	private final int color1;
    	private final int color2;
    	/*Call Paint class*/
    	private Paint rectPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    	/*create a Rectangle that takes parameters for the context (this), the width, the height, and two colors*/
    	public Rectangle(Context context, float x, float y, int color, int color2) {
            super(context);
            
            this.x = x;
            this.y = y;
            this.color1=color;
            this.color2=color2;
        }
    	/*New method that draws whatever we call*/
    	@Override
    	protected void onDraw(Canvas canvas) {
    	    //super.onDraw(canvas);
    		/*Because we want to enter a height and width, and the default Paint class needs an upper left and an upper right corner, we need to figure out what those corners are based on the given height and width and the height and width of our phone*/
    	    float centerX=canvas.getWidth()/2;
    	    float centerY=canvas.getWidth()/2;
    	    int topX=(int)(centerX-(x/2));
    	    int topY=(int)(centerY-(y/2));
    	    int botX=(int)(centerX+(x/2));
    	    int botY=(int)(centerY+(y/2));
    	    
    	  //rectPaint.setColor(color);/*Code to just set one color*/
         //   rectPaint.setShader(new LinearGradient(topX,botY,topX,botY, color1, color2, Shader.TileMode.MIRROR));/*Code to set a linear gradient*/
            rectPaint.setShader(new RadialGradient(centerX, centerY, 7, color1, color2, Shader.TileMode.MIRROR));/*Code to set a radial gradient*/
           /*Now that we have made the rectangle, draw it*/
            canvas.drawRect(topX, topY, botX, botY, rectPaint);
    	}
    }
  
}

