package com.gdi.drawabletouch;


import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class touchDrawable extends Activity implements OnTouchListener{
    /** Called when the activity is first created. */
	ImageView iView;
	private final static int START_DRAGGING = 0;
	private final static int STOP_DRAGGING = 1;
	private FrameLayout layout;
	private int status;
	private LayoutParams params;
	Button button;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        layout = (FrameLayout)findViewById(R.id.frameLayout1);
        button=(Button)findViewById(R.id.button1);
        button.setOnTouchListener(this);

		params = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
    }
    @Override
	public boolean onTouch(View view, MotionEvent me) {
		if (me.getAction() == MotionEvent.ACTION_DOWN) {
			ShapeDrawable rectangle = new ShapeDrawable ();
	        rectangle.setShape(new RectShape());
	        rectangle.setIntrinsicHeight(100);
	        rectangle.setIntrinsicWidth(200);
	        rectangle.getPaint().setColor(Color.GREEN);
	        iView = new ImageView(this);
	        iView.setImageDrawable(rectangle); 
	        
			layout.addView(iView, params);
		}
		if (me.getAction() == MotionEvent.ACTION_UP) {
			status = STOP_DRAGGING;
			
		} else if (me.getAction() == MotionEvent.ACTION_MOVE) {
			if (status == START_DRAGGING) {
				System.out.println("Dragging");
				iView.setPadding((int) me.getRawX(), (int) me.getRawY(), 0, 0);
				iView.invalidate();
			}
		}
		return false;
	}
}