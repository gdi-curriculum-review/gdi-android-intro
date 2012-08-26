package com.gdi.geospatial;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView; 

public class FindMe extends MapActivity {     
    /** Called when the activity is first created. */
	protected boolean isRouteDisplayed() {
		return false;
	}
	Button button;
	EditText address;
	TextView latLong;
	Geocoder myGeoCoder;
	double lat;
	double lng;
	MapView myMap;
	ImageView myMapMarker;
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
             
       //   myMap = (MapView) findViewById(R.id.simpleGM_map); //Get map from XML
          button = (Button) findViewById(R.id.button1); //Get button from XML
          address = (EditText) findViewById(R.id.editText1); //Get address from XML
          latLong = (TextView) findViewById(R.id.textView1);   
          myGeoCoder = new Geocoder(this); //create new geocoder instance
          
           myMapMarker = new ImageView(this) ;
          

          
          button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
              String addressInput = address.getText().toString(); //Get input text
                                     
              try {
                                             
                List<Address> foundAdresses = myGeoCoder.getFromLocationName(addressInput, 5); //Search addresses
                                             
                if (foundAdresses.size() == 0) { //if no address found, display an error in the TextView
                	latLong.setText("Sorry, we could not find that address");
                }
                else { //else display address on map
                  for (int i = 0; i < foundAdresses.size(); ++i) {
                    //Save results as Longitude and Latitude
                    Address x = foundAdresses.get(i);
                    lat = x.getLatitude();
                    lng = x.getLongitude();
                    latLong.setText("Latitude: "+lat+", Longitude: "+lng);
                  }
                  myMap = (MapView) findViewById(R.id. mapView1);
                  myMap. setSatellite(false) ; 
                  myMap.setBuiltInZoomControls(true);

                  MapController myController = myMap.getController();
                  myController.setZoom(17);

                  GeoPoint myGeoPoint = new GeoPoint((int)(lat*1000000), (int)(lng*1000000)); 	
                  myController.animateTo(myGeoPoint);
                  MapView.LayoutParams myMapMarkerParams = new MapView.LayoutParams( LayoutParams.WRAP_CONTENT,
                  			LayoutParams.WRAP_CONTENT, myGeoPoint, MapView.LayoutParams.TOP_LEFT ) ;
                  
                  myMapMarker.setImageResource(R.drawable.marker) ;
                  myMap.addView(myMapMarker, myMapMarkerParams);
                  //display the found address
                 
                } 
              }
              catch (Exception e) {
              }
                                     
            }
          });
          }
         
        /**
        * Navigates a given MapView to the specified Longitude and Latitude
        */
       /* public static void navigateToLocation (double latitude, double longitude, MapView mv) {
          GeoPoint p = new GeoPoint((int) latitude, (int) longitude); //new GeoPoint
          mv.displayZoomControls(true); //display Zoom (seems that it doesn't work yet)
          MapController mc = mv.getController();
          mc.animateTo(p); //move map to the given point
          int zoomlevel = mv.getMaxZoomLevel(); //detect maximum zoom level
          mc.setZoom(zoomlevel - 1); //zoom
          mv.setSatellite(false); //display only "normal" mapview    
        }*/
    //  }
    //}
    
}