package com.example.kiabifan;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import com.facebook.android.AsyncFacebookRunner;
import com.facebook.android.Facebook;
import com.facebook.android.FacebookError;
import com.facebook.android.AsyncFacebookRunner.RequestListener;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.Uri;
import android.opengl.Visibility;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class Produits extends Activity implements OnClickListener {
	
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
	
	Typeface font_nom;
	private static String APP_ID = "308180782571605"; // Replace your App ID here
	 
	private ProgressDialog 	dialog;
	private Handler	mHandler; 
	
    // Instance of Facebook Class
    private Facebook facebook;
    String FILENAME = "AndroidSSO_data";
    private SharedPreferences mPrefs;
    
	ImageView deconnecter,deconnecter_2,like_1,like_2,like_3,like_4,like_5,like_6,like_7,like_8,like_9,like_10;
	ImageView liked_1,liked_2,liked_3,liked_4,liked_5,liked_6,liked_7,liked_8,liked_9,liked_10;
	ImageView produit_1,produit_2,produit_3,produit_4,produit_5,produit_6,produit_7,produit_8,produit_9,produit_10;
	TextView nom_1,nom_2,nom_3,nom_4,nom_5,nom_6,nom_7,nom_8,nom_9,nom_10;
	TextView conteur_1,conteur_2,conteur_3,conteur_4,conteur_5,conteur_6,conteur_7,conteur_8,conteur_9,conteur_10;
	
	
	private AsyncFacebookRunner mAsyncRunner;
	
	ViewFlipper flipper;
	private float oldTouchValue;
	JSONParser parser;
	String name,nom,image,url,likes;
	TextView home_1,home_2,txt_nom;
	ImageView slide_left,slide_right,see_next,see_previous,valider;
	public static Animation inFromRightAnimation() {

    	Animation inFromRight = new TranslateAnimation(
    	Animation.RELATIVE_TO_PARENT,  +1.0f, Animation.RELATIVE_TO_PARENT,  0.0f,
    	Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,   0.0f
    	);
    	inFromRight.setDuration(350);
    	inFromRight.setInterpolator(new AccelerateInterpolator());
    	return inFromRight;
    	}
    public static Animation outToLeftAnimation() {
    	Animation outtoLeft = new TranslateAnimation(
    	 Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,  -1.0f,
    	 Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,   0.0f
    	);
    	outtoLeft.setDuration(350);
    	outtoLeft.setInterpolator(new AccelerateInterpolator());
    	return outtoLeft;
    	}    
    // for the next movement
    public static Animation inFromLeftAnimation() {
    	Animation inFromLeft = new TranslateAnimation(
    	Animation.RELATIVE_TO_PARENT,  -1.0f, Animation.RELATIVE_TO_PARENT,  0.0f,
    	Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,   0.0f
    	);
    	inFromLeft.setDuration(350);
    	inFromLeft.setInterpolator(new AccelerateInterpolator());
    	return inFromLeft;
    	}
    public static Animation outToRightAnimation() {
    	Animation outtoRight = new TranslateAnimation(
    	 Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,  +1.0f,
    	 Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,   0.0f
    	);
    	outtoRight.setDuration(350);
    	outtoRight.setInterpolator(new AccelerateInterpolator());
    	return outtoRight;
    	}
    
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.produits);
		
		Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Lato-Bold.ttf");
		TextView txt_1 = (TextView)findViewById(R.id.txt_conteur);
		TextView txt_2 = (TextView)findViewById(R.id.txt_conteur_2);
		txt_1.setTypeface(font);
		txt_2.setTypeface(font);
		
		font_nom = Typeface.createFromAsset(getAssets(), "fonts/Lato-Bold.ttf");
		dialog  = new ProgressDialog(this);
		   
		 dialog.setMessage("Déconnection en cours ... ");
		 dialog.setCancelable(true);
		 
		 mHandler = new Handler() {
				public void handleMessage(Message msg) {
					switch(msg.what){
						case 1:
						dialog.dismiss();
						//Toast.makeText(getBaseContext(), "Chargement términé", 2000).show();
						break;
						
					}
				}
			};
		
		facebook = new Facebook(APP_ID);
	    mAsyncRunner = new AsyncFacebookRunner(facebook);
	    
		Intent i = getIntent();
        
        name = i.getStringExtra("name");
        
        produit_name_1 = i.getStringExtra("produit_name_1");
        produit_image_1 = i.getStringExtra("produit_image_1");
        produit_url_1 = i.getStringExtra("produit_url_1");
        produit_likes_1 = i.getStringExtra("produit_likes_1");
		
        produit_name_2 = i.getStringExtra("produit_name_2");
        produit_image_2 = i.getStringExtra("produit_image_2");
        produit_url_2 = i.getStringExtra("produit_url_2");
        produit_likes_2 = i.getStringExtra("produit_likes_2");
		
        produit_name_3 = i.getStringExtra("produit_name_3");
        produit_image_3 = i.getStringExtra("produit_image_3");
        produit_url_3 = i.getStringExtra("produit_url_3");
        produit_likes_3 = i.getStringExtra("produit_likes_3");
		
        produit_name_4 = i.getStringExtra("produit_name_4");
        produit_image_4 = i.getStringExtra("produit_image_4");
        produit_url_4 = i.getStringExtra("produit_url_4");
        produit_likes_4 = i.getStringExtra("produit_likes_4");
		
        produit_name_5 = i.getStringExtra("produit_name_5");
        produit_image_5 = i.getStringExtra("produit_image_5");
        produit_url_5 = i.getStringExtra("produit_url_5");
        produit_likes_5 = i.getStringExtra("produit_likes_5");
		
        produit_name_6 = i.getStringExtra("produit_name_6");
        produit_image_6 = i.getStringExtra("produit_image_6");
        produit_url_6 = i.getStringExtra("produit_url_6");
        produit_likes_6 = i.getStringExtra("produit_likes_6");
		
        produit_name_7 = i.getStringExtra("produit_name_7");
        produit_image_7 = i.getStringExtra("produit_image_7");
        produit_url_7 = i.getStringExtra("produit_url_7");
        produit_likes_7 = i.getStringExtra("produit_likes_7");
		
        produit_name_8 = i.getStringExtra("produit_name_8");
        produit_image_8 = i.getStringExtra("produit_image_8");
        produit_url_8 = i.getStringExtra("produit_url_8");
        produit_likes_8 = i.getStringExtra("produit_likes_8");
		
        produit_name_9 = i.getStringExtra("produit_name_9");
        produit_image_9 = i.getStringExtra("produit_image_9");
        produit_url_9 = i.getStringExtra("produit_url_9");
        produit_likes_9 = i.getStringExtra("produit_likes_9");
		
        produit_name_10 = i.getStringExtra("produit_name_10");
        produit_image_10 = i.getStringExtra("produit_image_10");
        produit_url_10 = i.getStringExtra("produit_url_10");
        produit_likes_10 = i.getStringExtra("produit_likes_10");
		
        
        home_1 = (TextView)findViewById(R.id.user_name_1);
        home_2 = (TextView)findViewById(R.id.user_name_2);
        
        home_1.setText(name);
        home_2.setText(name);
        
        nom_1 = (TextView)findViewById(R.id.nom_1);
        nom_1.setText(produit_name_1);
        nom_1.setTypeface(font_nom);
        
        nom_2 = (TextView)findViewById(R.id.nom_2);
        nom_2.setText(produit_name_2);
        nom_2.setTypeface(font_nom);
        
        nom_3 = (TextView)findViewById(R.id.nom_3);
        nom_3.setText(produit_name_3);
        nom_3.setTypeface(font_nom);
        
        
        nom_4 = (TextView)findViewById(R.id.nom_4);
        nom_4.setText(produit_name_4);
        nom_4.setTypeface(font_nom);
        
        nom_5 = (TextView)findViewById(R.id.nom_5);
        nom_5.setText(produit_name_5);
        nom_5.setTypeface(font_nom);
        
        nom_6 = (TextView)findViewById(R.id.nom_6);
        nom_6.setText(produit_name_6);
        nom_6.setTypeface(font_nom);
        
        nom_7 = (TextView)findViewById(R.id.nom_7);
        nom_7.setText(produit_name_7);
        nom_7.setTypeface(font_nom);
        
        nom_8 = (TextView)findViewById(R.id.nom_8);
        nom_8.setText(produit_name_8);
        nom_8.setTypeface(font_nom);
        
        nom_9 = (TextView)findViewById(R.id.nom_9);
        nom_9.setText(produit_name_9);
        nom_9.setTypeface(font_nom);
        
        nom_10 = (TextView)findViewById(R.id.nom_10);
        nom_10.setText(produit_name_10);
        nom_10.setTypeface(font_nom);
        /**********************************************************************************************/
        
        conteur_1 = (TextView)findViewById(R.id.conteur_1);
        conteur_1.setText(produit_likes_1);
        
        conteur_2 = (TextView)findViewById(R.id.conteur_2);
        conteur_2.setText(produit_likes_2);
        
        conteur_3 = (TextView)findViewById(R.id.conteur_3);
        conteur_3.setText(produit_likes_3);
        
        conteur_4 = (TextView)findViewById(R.id.conteur_4);
        conteur_4.setText(produit_likes_4);
        
        conteur_5 = (TextView)findViewById(R.id.conteur_5);
        conteur_5.setText(produit_likes_5);
        
        conteur_6 = (TextView)findViewById(R.id.conteur_6);
        conteur_6.setText(produit_likes_6);
        
        conteur_7 = (TextView)findViewById(R.id.conteur_7);
        conteur_7.setText(produit_likes_7);
        
        conteur_8 = (TextView)findViewById(R.id.conteur_8);
        conteur_8.setText(produit_likes_8);
        
        conteur_9 = (TextView)findViewById(R.id.conteur_9);
        conteur_9.setText(produit_likes_9);
        
        conteur_10 = (TextView)findViewById(R.id.conteur_10);
        conteur_10.setText(produit_likes_10);
        
       
        
        /**********************************************************************************************/
        ImageLoader loadit = new ImageLoader(getApplicationContext());
        
        produit_1 = (ImageView)findViewById(R.id.product_1);
        loadit.DisplayImage(produit_image_1, produit_1);
        //produit_1.setTag(produit_url_1);
        Log.i("*********** URL ****************",produit_image_1);
        
        produit_2 = (ImageView)findViewById(R.id.product_2);
        loadit.DisplayImage(produit_image_2, produit_2);
        //produit_2.setTag(produit_url_2);
        Log.i("*********** URL ****************",produit_image_2);

        produit_3 = (ImageView)findViewById(R.id.product_3);
        loadit.DisplayImage(produit_image_3, produit_3);
        //produit_3.setTag(produit_url_3);
        
        Log.i("*********** URL ****************",produit_image_3);
        
        produit_4 = (ImageView)findViewById(R.id.product_4);
        loadit.DisplayImage(produit_image_4, produit_4);
        //produit_4.setTag(produit_url_4);
        Log.i("*********** URL ****************",produit_image_4);
        
        produit_5 = (ImageView)findViewById(R.id.product_5);
        loadit.DisplayImage(produit_image_5, produit_5);
        //produit_5.setTag(produit_url_5);
        Log.i("*********** URL ****************",produit_image_5);
        
        produit_6 = (ImageView)findViewById(R.id.product_6);
        loadit.DisplayImage(produit_image_6, produit_6);
        //produit_6.setTag(produit_url_6);
        Log.i("*********** URL ****************",produit_image_6);
        
        produit_7 = (ImageView)findViewById(R.id.product_7);
        loadit.DisplayImage(produit_image_7, produit_7);
        //produit_7.setTag(produit_url_7); 
        Log.i("*********** URL ****************",produit_image_7);
        
        produit_8 = (ImageView)findViewById(R.id.product_8);
        loadit.DisplayImage(produit_image_8, produit_8);
        //produit_8.setTag(produit_url_8);
        Log.i("*********** URL ****************",produit_image_8);
        
        produit_9 = (ImageView)findViewById(R.id.product_9);
        loadit.DisplayImage(produit_image_9, produit_9);
        //produit_9.setTag(produit_url_9);
        Log.i("*********** URL ****************",produit_image_9);
        
        produit_10 = (ImageView)findViewById(R.id.product_10);
        loadit.DisplayImage(produit_image_10, produit_10);
        //produit_10.setTag(produit_url_10);
        Log.i("*********** URL ****************",produit_image_10);
        
        
        
        //home.setText(name+" , votez pour vos articles préférés en cliquant sur “j’aime”!");
        
        slide_left = (ImageView)findViewById(R.id.slide_left);
        slide_right = (ImageView)findViewById(R.id.slide_right);
        see_next = (ImageView)findViewById(R.id.see_next);
        see_previous = (ImageView)findViewById(R.id.see_previous);
        valider = (ImageView)findViewById(R.id.valider);
        deconnecter = (ImageView)findViewById(R.id.deconnect);
        deconnecter_2 = (ImageView)findViewById(R.id.deconnect_2);
        
        like_1 = (ImageView)findViewById(R.id.like_1);
        like_1.setOnClickListener(this);
        
        like_2 = (ImageView)findViewById(R.id.like_2);
        like_2.setOnClickListener(this);

        like_3 = (ImageView)findViewById(R.id.like_3);
        like_3.setOnClickListener(this);
        
        like_4 = (ImageView)findViewById(R.id.like_4);
        like_4.setOnClickListener(this);
        
        like_5 = (ImageView)findViewById(R.id.like_5);
        like_5.setOnClickListener(this);
        
        like_6 = (ImageView)findViewById(R.id.like_6);
        like_6.setOnClickListener(this);
        
        like_7 = (ImageView)findViewById(R.id.like_7);
        like_7.setOnClickListener(this);
        
        like_8 = (ImageView)findViewById(R.id.like_8);
        like_8.setOnClickListener(this);
        
        like_9 = (ImageView)findViewById(R.id.like_9);
        like_9.setOnClickListener(this);
        
        like_10 = (ImageView)findViewById(R.id.like_10);
        like_10.setOnClickListener(this);
        
        
        liked_1 = (ImageView)findViewById(R.id.liked_1);
        liked_1.setTag(produit_url_1);
        liked_1.setVisibility(View.INVISIBLE);
        
        liked_2 = (ImageView)findViewById(R.id.liked_2);
        liked_2.setTag(produit_url_2);
        liked_2.setVisibility(View.INVISIBLE);

        liked_3 = (ImageView)findViewById(R.id.liked_3);
        liked_3.setTag(produit_url_3);
        liked_3.setVisibility(View.INVISIBLE);
        
        liked_4 = (ImageView)findViewById(R.id.liked_4);
        liked_4.setTag(produit_url_4);
        liked_4.setVisibility(View.INVISIBLE);
        
        liked_5 = (ImageView)findViewById(R.id.liked_5);
        liked_5.setTag(produit_url_5);
        liked_5.setVisibility(View.INVISIBLE);
        
        liked_6 = (ImageView)findViewById(R.id.liked_6);
        liked_6.setTag(produit_url_6);
        liked_6.setVisibility(View.INVISIBLE);
        
        liked_7 = (ImageView)findViewById(R.id.liked_7);
        liked_7.setTag(produit_url_7);
        liked_7.setVisibility(View.INVISIBLE);
        
        liked_8 = (ImageView)findViewById(R.id.liked_8);
        liked_8.setTag(produit_url_8);
        liked_8.setVisibility(View.INVISIBLE);
        
        liked_9 = (ImageView)findViewById(R.id.liked_9);
        liked_9.setTag(produit_url_9);
        liked_9.setVisibility(View.INVISIBLE);
        
        liked_10 = (ImageView)findViewById(R.id.liked_10);
        liked_10.setTag(produit_url_10);
        liked_10.setVisibility(View.INVISIBLE);
        
        
        valider.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent deconnecter = new Intent(getBaseContext(),Deconnecter.class);
				deconnecter.putExtra("nom",nom);
				deconnecter.putExtra("name",name);
				startActivity(deconnecter);
				
			}
		});
        
        slide_left.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				flipper.setOutAnimation(Produits.this, R.anim.view_transition_out_left);
				flipper.setInAnimation(Produits.this, R.anim.view_transition_in_left);
				/*flipper.setInAnimation(inFromRightAnimation());
            	flipper.setOutAnimation(outToLeftAnimation());*/
            	flipper.showNext();
				
			}
		});
        
        slide_right.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				flipper.setOutAnimation(Produits.this, R.anim.view_transition_out_right);
				flipper.setInAnimation(Produits.this, R.anim.view_transition_in_right);
				/*flipper.setInAnimation(inFromRightAnimation());
            	flipper.setOutAnimation(outToLeftAnimation());*/
            	flipper.showPrevious();
			}
		});
        
        see_next.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				flipper.setOutAnimation(Produits.this, R.anim.view_transition_out_right);
				flipper.setInAnimation(Produits.this, R.anim.view_transition_in_right);
				/*flipper.setInAnimation(inFromRightAnimation());
            	flipper.setOutAnimation(outToLeftAnimation());*/
            	flipper.showNext();
				
			}
		});
        
        deconnecter.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dialog.show();
				 new Thread(new Runnable(){
						public void run() {
							Looper.prepare();
							restartFirstActivity();
						}
					}).start();
			   mHandler.sendEmptyMessage(1);
			}
		});
        
        deconnecter_2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dialog.show();
				 new Thread(new Runnable(){
						public void run() {
							Looper.prepare();
							restartFirstActivity();
						}
					}).start();
			   mHandler.sendEmptyMessage(1);
				
			}
		});
        

        
        
        /*publicvoid onCreate(Bundle savedInstanceState) { 
        	super.onCreate(savedInstanceState); 
        	setContentView(R.layout.main); 
        	final ViewFlipper viewFlipper = (ViewFlipper)findViewById(R.id.viewFlipper); 
        	Button nextButton = (Button) this.findViewById(R.id.nextButton); 
        	nextButton.setOnClickListener(new OnClickListener() 
        				{ 
        					@Override 12 publicvoid onClick(View v) {
        						viewFlipper.setInAnimation(MainActivity.this, R.anim.view_transition_in_left); 
        						viewFlipper.setOutAnimation(MainActivity.this, R.anim.view_transition_out_left); 
        						viewFlipper.showNext();  } 
        					}); 
        			Button previousButton = (Button) this.findViewById(R.id.previousButton);
        			previousButton.setOnClickListener(new OnClickListener() { 
        				@Override 25 publicvoid onClick(View v) { 
        					viewFlipper.setInAnimation(MainActivity.this, R.anim.view_transition_in_right); 
        					viewFlipper.setOutAnimation(MainActivity.this, R.anim.view_transition_out_right); 
        					viewFlipper.showPrevious();  } 
        				});
        			}*/
        
        
        
        
        see_previous.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				flipper.setOutAnimation(Produits.this, R.anim.view_transition_out_left);
				flipper.setInAnimation(Produits.this, R.anim.view_transition_in_left);
				/*flipper.setInAnimation(inFromRightAnimation());
            	flipper.setOutAnimation(outToLeftAnimation());*/
            	flipper.showPrevious();
			}
		});
        
        /*see_previous.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				flipper.setInAnimation(inFromRightAnimation());
            	flipper.setOutAnimation(outToLeftAnimation());
            	flipper.showPrevious();
			}
		});*/
        
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

		StrictMode.setThreadPolicy(policy); 
		
		flipper = (ViewFlipper) findViewById(R.id.flipper);
		
		
		
		
	}
	
	private void restartFirstActivity()
	 {
    	try {
			facebook.logout(getBaseContext());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.i(" *************************** "," FKGJUNVGK;WJRPTVNWJRGWIRPGJVPWRI ");
		Intent i = getBaseContext().getPackageManager()
		.getLaunchIntentForPackage(getBaseContext().getPackageName() );
		i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK );
		startActivity(i);
	 }
	
	 public void logoutFromFacebook() {
	        mAsyncRunner.logout(this, new RequestListener() {
	            @Override
	            public void onComplete(String response, Object state) {
	                Log.d("Logout from Facebook", response);
	                if (Boolean.parseBoolean(response) == true) {
	                    // User successfully Logged out
	                }
	            }
	     
	            @Override
	            public void onIOException(IOException e, Object state) {
	            }
	     
	            @Override
	            public void onFileNotFoundException(FileNotFoundException e,
	                    Object state) {
	            }
	     
	            @Override
	            public void onMalformedURLException(MalformedURLException e,
	                    Object state) {
	            }
	     
	            @Override
	            public void onFacebookError(FacebookError e, Object state) {
	            }
	        });
	    }
	
	public boolean onTouchEvent(MotionEvent touchevent) {
    	
        switch (touchevent.getAction())
        {
           case MotionEvent.ACTION_DOWN:
            {
                oldTouchValue = touchevent.getX();
                break;
            }
            case MotionEvent.ACTION_UP:
            {
            	
                float currentX = touchevent.getX();
                
                if (oldTouchValue < currentX)
                {
    				flipper.setOutAnimation(Produits.this, R.anim.view_transition_out_right);
    				flipper.setInAnimation(Produits.this, R.anim.view_transition_in_right);
    				/*flipper.setInAnimation(inFromRightAnimation());
                	flipper.setOutAnimation(outToLeftAnimation());*/
                	flipper.showNext();
                }
                
                if (oldTouchValue > currentX)
                {
                	flipper.setOutAnimation(Produits.this, R.anim.view_transition_out_right);
    				flipper.setInAnimation(Produits.this, R.anim.view_transition_in_right);
    				/*flipper.setInAnimation(inFromRightAnimation());
                	flipper.setOutAnimation(outToLeftAnimation());*/
                	flipper.showPrevious();
                }
            break;
        	}
    	}
    	return false;
	}
	
	public String  PostLike(View v) {    
		  String URL = "https://kiabifans.smartcafeine.com/api/product/like";
	      HttpClient httpclient = new DefaultHttpClient();
	      HttpPost httppost = new HttpPost(URL);
	      String data = v.getTag().toString();
	      String s="";
		    try {
		    	  
		          List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
		          nameValuePairs.add(new BasicNameValuePair("url", data));
		          httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		          // Execute HTTP Post Request
		          HttpResponse response = httpclient.execute(httppost);
		          BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));     
		           s = reader.readLine();	          
		          //Toast.makeText(getBaseContext(), data, 3000).show();
		          // v.setVisibility(View.INVISIBLE);
		      } catch (Exception e) {
		      	e.printStackTrace();
		      }
		    return s; 
	     }
	
    public void onClick(View v) {
    	
    	switch (v.getId()) {
    	
		case R.id.like_1:
			
			//Toast.makeText(getBaseContext(), liked_1.getTag().toString(), Toast.LENGTH_LONG).show();
			int count_1 = Integer.parseInt(conteur_1.getText().toString());
			conteur_1.setText(Integer.toString(count_1+1));
			like_1.setVisibility(View.INVISIBLE);
			liked_1.setVisibility(View.VISIBLE);
			PostLike(liked_1);
			break;
			
		case R.id.like_2:
			
			//Toast.makeText(getBaseContext(), "Like it 3", Toast.LENGTH_LONG).show();
			int count_2 = Integer.parseInt(conteur_2.getText().toString());
			conteur_2.setText(Integer.toString(count_2+1));
			like_2.setVisibility(View.INVISIBLE);
			liked_2.setVisibility(View.VISIBLE);
			PostLike(liked_2);
			break;
			
		case R.id.like_3:
			
			//Toast.makeText(getBaseContext(), "Like it 3", Toast.LENGTH_LONG).show();
			int count_3 = Integer.parseInt(conteur_3.getText().toString());
			conteur_3.setText(Integer.toString(count_3+1));
			like_3.setVisibility(View.INVISIBLE);
			liked_3.setVisibility(View.VISIBLE);
			PostLike(liked_3);
			break;
		
		case R.id.like_4:

			//Toast.makeText(getBaseContext(), "Like it 4", Toast.LENGTH_LONG).show();
			int count_4 = Integer.parseInt(conteur_4.getText().toString());
			conteur_4.setText(Integer.toString(count_4+1));
			like_4.setVisibility(View.INVISIBLE);
			liked_4.setVisibility(View.VISIBLE);
			PostLike(liked_4);
			break;
			
		case R.id.like_5:

			//Toast.makeText(getBaseContext(), "Like it 5", Toast.LENGTH_LONG).show();
			int count_5 = Integer.parseInt(conteur_5.getText().toString());
			conteur_5.setText(Integer.toString(count_5+1));
			like_5.setVisibility(View.INVISIBLE);
			liked_5.setVisibility(View.VISIBLE);
			PostLike(liked_5);
			break;
		
		case R.id.like_6:
			
			//Toast.makeText(getBaseContext(), "Like it 6", Toast.LENGTH_LONG).show();
			int count_6 = Integer.parseInt(conteur_6.getText().toString());
			conteur_6.setText(Integer.toString(count_6+1));
			like_6.setVisibility(View.INVISIBLE);
			liked_6.setVisibility(View.VISIBLE);
			PostLike(liked_6);
			break;
			
		case R.id.like_7:
			
			//Toast.makeText(getBaseContext(), "Like it 7", Toast.LENGTH_LONG).show();
			int count_7 = Integer.parseInt(conteur_7.getText().toString());
			conteur_7.setText(Integer.toString(count_7+1));
			like_7.setVisibility(View.INVISIBLE);
			liked_7.setVisibility(View.VISIBLE);
			PostLike(liked_7);
			break;
			
		case R.id.like_8:
			
			//Toast.makeText(getBaseContext(), "Like it 8", Toast.LENGTH_LONG).show();
			int count_8 = Integer.parseInt(conteur_8.getText().toString());
			conteur_8.setText(Integer.toString(count_8+1));
			like_8.setVisibility(View.INVISIBLE);
			liked_8.setVisibility(View.VISIBLE);
			PostLike(liked_8);
			break;
		
		case R.id.like_9:

			//Toast.makeText(getBaseContext(), "Like it 9", Toast.LENGTH_LONG).show();
			int count_9 = Integer.parseInt(conteur_9.getText().toString());
			conteur_9.setText(Integer.toString(count_9+1));
			like_9.setVisibility(View.INVISIBLE);
			liked_9.setVisibility(View.VISIBLE);
			PostLike(liked_9);
			break;
			
		case R.id.like_10:

			//Toast.makeText(getBaseContext(), "Like it 10", Toast.LENGTH_LONG).show();
			int count_10 = Integer.parseInt(conteur_10.getText().toString());
			conteur_10.setText(Integer.toString(count_10+1));
			like_10.setVisibility(View.INVISIBLE);
			liked_10.setVisibility(View.VISIBLE);
			PostLike(liked_10);
			break;
		}
   }
    
   }
