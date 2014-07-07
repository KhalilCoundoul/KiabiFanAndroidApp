package com.example.kiabifan;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.facebook.android.AsyncFacebookRunner;
import com.facebook.android.Facebook;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends Activity {
	
	// url to make request
	private static String url = "https://kiabifans.smartcafeine.com/api/products";
	 
	String produit_name_1,produit_image_1,produit_url_1,produit_likes_1;
	String produit_name_2,produit_image_2,produit_url_2,produit_likes_2;
	String produit_name_3,produit_image_3,produit_url_3,produit_likes_3;
	String produit_name_4,produit_image_4,produit_url_4,produit_likes_4;
	String produit_name_5,produit_image_5,produit_url_5,produit_likes_5;
	String produit_name_6,produit_image_6,produit_url_6,produit_likes_6;
	String produit_name_7,produit_image_7,produit_url_7,produit_likes_7;
	String produit_name_8,produit_image_8,produit_url_8,produit_likes_8;
	String produit_name_9,produit_image_9,produit_url_9,produit_likes_9;
	String produit_name_10,produit_image_10,produit_url_10,produit_likes_10;
	
	
	String nom = "";
	// contacts JSONArray
	Produit produits;
	JSONArray contacts = null;
    
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		  Log.i("***********************","oncreate");
		  
		  StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

		  StrictMode.setThreadPolicy(policy); 
			
		  Log.i("***********************","policy set");
		 produits = new Produit();
		try{
			
		String entry = new Communicator().executeHttpGet(url);
		
		for (int i = 0 ; i < entry.length(); i++ ) {
		  JSONObject obj = new JSONObject(entry);
		  JSONArray array = new JSONArray(obj.getString("products"));
		  //obj.getString("name").toString();
		  // now get the data from each entry
		  JSONObject getit = new JSONObject(array.getString(i).toString());
		  
		  switch (i) {
		case 0:
			produit_name_1 = getit.getString("name");
			produit_likes_1 = getit.getString("likes");
			produit_url_1 = getit.getString("url");
			produit_image_1 = getit.getString("img");
			 Log.i("*** FROM SWITCH JSON ***",getit.getString("name"));
			break;
		case 1:
			
			produit_name_2 = getit.getString("name");
			produit_likes_2 = getit.getString("likes");
			produit_url_2 = getit.getString("url");
			produit_image_2 = getit.getString("img");
			 Log.i("*** FROM SWITCH JSON ***",getit.getString("name"));
			break;
		case 2:
			
			produit_name_3 = getit.getString("name");
			produit_likes_3 = getit.getString("likes");
			produit_url_3 = getit.getString("url");
			produit_image_3 = getit.getString("img");
			 Log.i("*** FROM SWITCH JSON ***",getit.getString("name"));
			break;
		case 3:
			
			produit_name_4 = getit.getString("name");
			produit_likes_4 = getit.getString("likes");
			produit_url_4 = getit.getString("url");
			produit_image_4 = getit.getString("img");
			 Log.i("*** FROM SWITCH JSON ***",getit.getString("name"));
			break;
		case 4:
			
			produit_name_5 = getit.getString("name");
			produit_likes_5 = getit.getString("likes");
			produit_url_5 = getit.getString("url");
			produit_image_5 = getit.getString("img");
			 Log.i("*** FROM SWITCH JSON ***",getit.getString("name"));
			break;
		case 5:
			
			produit_name_6 = getit.getString("name");
			produit_likes_6 = getit.getString("likes");
			produit_url_6 = getit.getString("url");
			produit_image_6 = getit.getString("img");
			 Log.i("*** FROM SWITCH JSON ***",getit.getString("name"));
			break;
		case 6:
			
			produit_name_7 = getit.getString("name");
			produit_likes_7 = getit.getString("likes");
			produit_url_7 = getit.getString("url");
			produit_image_7 = getit.getString("img");
			 Log.i("*** FROM SWITCH JSON ***",getit.getString("name"));
			break;
		case 7:
			
			produit_name_8 = getit.getString("name");
			produit_likes_8 = getit.getString("likes");
			produit_url_8 = getit.getString("url");
			produit_image_8 = getit.getString("img");
			 Log.i("*** FROM SWITCH JSON ***",getit.getString("name"));
			break;
		case 8:
			
			produit_name_9 = getit.getString("name");
			produit_likes_9 = getit.getString("likes");
			produit_url_9 = getit.getString("url");
			produit_image_9 = getit.getString("img");
			 Log.i("*** FROM SWITCH JSON ***",getit.getString("name"));
			break;
		case 9:
			
			produit_name_10 = getit.getString("name");
			produit_likes_10 = getit.getString("likes");
			produit_url_10 = getit.getString("url");
			produit_image_10 = getit.getString("img");
			 Log.i("*** FROM SWITCH JSON ***",getit.getString("name"));
			break;

		default:
			break;
		}
	 }
    }catch (Exception e) {
			// TODO: handle exception
			Log.i("*** ERROR FROM JSON ***",e.toString());
	}

		
		
/*
		  
		// Creating JSON Parser instance
		  
		// Creating JSON Parser instance
		  JSONParser jParser = new JSONParser();
		   
		  // getting JSON string from URL
		  JSONObject json = jParser.getJSONFromUrl(url);
		   
		  try {
		      // Getting Array of Contacts
		      contacts = json.getJSONArray(TAG_CONTACTS);
		   
		      // looping through All Contacts
		      for(int i = 0; i < contacts.length(); i++){
		          JSONObject c = contacts.getJSONObject(i);
		   
		          // Storing each json item in variable
		          String id = c.getString(TAG_ID);
		          String name = c.getString(TAG_NAME);
		          
		          String email = c.getString(TAG_EMAIL);
		          String address = c.getString(TAG_ADDRESS);
		          String gender = c.getString(TAG_GENDER);
		          nom = name; 
		          Log.i("FROM MAIN",nom);
		          Log.i("***********************",email);
		          // Phone number is agin JSON Object
		          JSONObject phone = c.getJSONObject(TAG_PHONE);
		          String mobile = phone.getString(TAG_PHONE_MOBILE);
		          String home = phone.getString(TAG_PHONE_HOME);
		          String office = phone.getString(TAG_PHONE_OFFICE);
		   
		      }
		  } catch (Exception e) {
		      e.printStackTrace();
		      Log.i("***********************",e.toString());
		  }*/
		  
		  /*try {
				JSONObject markets = new JSONObject("http://api.androidhive.info/contacts/");
				Log.i("***********************",Integer.toString(markets.length()));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Log.i("***********************",e.toString());
			}*/
		
	}
	
	
	
	public boolean onTouchEvent(MotionEvent touchevent) {
		

		 /**/
		Intent participer = new Intent(getApplicationContext(),Participer.class);
		participer.putExtra("nom", produits.getNom());
		
		participer.putExtra("produit_name_1",produit_name_1);
		participer.putExtra("produit_image_1",produit_image_1);
		participer.putExtra("produit_url_1",produit_url_1);
		participer.putExtra("produit_likes_1",produit_likes_1);
		
		participer.putExtra("produit_name_2",produit_name_2);
		participer.putExtra("produit_image_2",produit_image_2);
		participer.putExtra("produit_url_2",produit_url_1);
		participer.putExtra("produit_likes_2",produit_likes_2);
		
		participer.putExtra("produit_name_3",produit_name_3);
		participer.putExtra("produit_image_3",produit_image_3);
		participer.putExtra("produit_url_3",produit_url_3);
		participer.putExtra("produit_likes_3",produit_likes_3);
		
		participer.putExtra("produit_name_4",produit_name_4);
		participer.putExtra("produit_image_4",produit_image_4);
		participer.putExtra("produit_url_4",produit_url_1);
		participer.putExtra("produit_likes_4",produit_likes_4);
		
		participer.putExtra("produit_name_5",produit_name_5);
		participer.putExtra("produit_image_5",produit_image_5);
		participer.putExtra("produit_url_5",produit_url_5);
		participer.putExtra("produit_likes_5",produit_likes_5);
		
		participer.putExtra("produit_name_6",produit_name_6);
		participer.putExtra("produit_image_6",produit_image_6);
		participer.putExtra("produit_url_6",produit_url_6);
		participer.putExtra("produit_likes_6",produit_likes_6);
		
		participer.putExtra("produit_name_7",produit_name_7);
		participer.putExtra("produit_image_7",produit_image_7);
		participer.putExtra("produit_url_7",produit_url_7);
		participer.putExtra("produit_likes_7",produit_likes_7);
		
		participer.putExtra("produit_name_8",produit_name_8);
		participer.putExtra("produit_image_8",produit_image_8);
		participer.putExtra("produit_url_8",produit_url_8);
		participer.putExtra("produit_likes_8",produit_likes_8);
		
		participer.putExtra("produit_name_9",produit_name_9);
		participer.putExtra("produit_image_9",produit_image_9);
		participer.putExtra("produit_url_9",produit_url_9);
		participer.putExtra("produit_likes_9",produit_likes_9);
		
		participer.putExtra("produit_name_10",produit_name_10);
		participer.putExtra("produit_image_10",produit_image_10);
		participer.putExtra("produit_url_10",produit_url_10);
		participer.putExtra("produit_likes_10",produit_likes_10);
		
		Log.i("************ EXTRA CONTROLER ",produit_likes_10);
		startActivity(participer);
		
		return false;
		}

}
