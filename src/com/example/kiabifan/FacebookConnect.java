package com.example.kiabifan;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.facebook.android.AsyncFacebookRunner;
import com.facebook.android.AsyncFacebookRunner.RequestListener;
import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.Facebook.DialogListener;
import com.facebook.android.FacebookError;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FacebookConnect extends Activity {

    // Your Facebook APP ID
    private static String APP_ID = "215850891893789"; // Replace your App ID here
    
	private static final String[] PERMISSIONS =
	           new String[] {"publish_stream"};
 
    // Instance of Facebook Class
    private Facebook facebook;
    private AsyncFacebookRunner mAsyncRunner;
    String FILENAME = "AndroidSSO_data";
    private SharedPreferences mPrefs;
    ImageView btnFbLogin,getinfos;
   // String nom,image,url,likes;
    
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
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fcbk_connect);
 
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Lato-Bold.ttf");
		TextView txt_title = (TextView)findViewById(R.id.home_text);
		txt_title.setTypeface(font);
		
        Intent extra = getIntent();
        
        produit_name_1 = extra.getStringExtra("produit_name_1");
        produit_image_1 = extra.getStringExtra("produit_image_1");
        produit_url_1 = extra.getStringExtra("produit_url_1");
        produit_likes_1 = extra.getStringExtra("produit_likes_1");
		
        produit_name_2 = extra.getStringExtra("produit_name_2");
        produit_image_2 = extra.getStringExtra("produit_image_2");
        produit_url_2 = extra.getStringExtra("produit_url_2");
        produit_likes_2 = extra.getStringExtra("produit_likes_2");
		
        produit_name_3 = extra.getStringExtra("produit_name_3");
        produit_image_3 = extra.getStringExtra("produit_image_3");
        produit_url_3 = extra.getStringExtra("produit_url_3");
        produit_likes_3 = extra.getStringExtra("produit_likes_3");
		
        produit_name_4 = extra.getStringExtra("produit_name_4");
        produit_image_4 = extra.getStringExtra("produit_image_4");
        produit_url_4 = extra.getStringExtra("produit_url_4");
        produit_likes_4 = extra.getStringExtra("produit_likes_4");
		
        produit_name_5 = extra.getStringExtra("produit_name_5");
        produit_image_5 = extra.getStringExtra("produit_image_5");
        produit_url_5 = extra.getStringExtra("produit_url_5");
        produit_likes_5 = extra.getStringExtra("produit_likes_5");
		
        produit_name_6 = extra.getStringExtra("produit_name_6");
        produit_image_6 = extra.getStringExtra("produit_image_6");
        produit_url_6 = extra.getStringExtra("produit_url_6");
        produit_likes_6 = extra.getStringExtra("produit_likes_6");
		
        produit_name_7 = extra.getStringExtra("produit_name_7");
        produit_image_7 = extra.getStringExtra("produit_image_7");
        produit_url_7 = extra.getStringExtra("produit_url_7");
        produit_likes_7 = extra.getStringExtra("produit_likes_7");
		
        produit_name_8 = extra.getStringExtra("produit_name_8");
        produit_image_8 = extra.getStringExtra("produit_image_8");
        produit_url_8 = extra.getStringExtra("produit_url_8");
        produit_likes_8 = extra.getStringExtra("produit_likes_8");
		
        produit_name_9 = extra.getStringExtra("produit_name_9");
        produit_image_9 = extra.getStringExtra("produit_image_9");
        produit_url_9 = extra.getStringExtra("produit_url_9");
        produit_likes_9 = extra.getStringExtra("produit_likes_9");
		
        produit_name_10 = extra.getStringExtra("produit_name_10");
        produit_image_10 = extra.getStringExtra("produit_image_10");
        produit_url_10 = extra.getStringExtra("produit_url_10");
        produit_likes_10 = extra.getStringExtra("produit_likes_10");
		
    	/*extra.putExtra("produit_name", nom);
    	extra.putExtra("produit_image", image);
    	extra.putExtra("produit_url", url);
    	extra.putExtra("produit_likes", likes);*/
    	
        //nom = extra.getStringExtra("produit_name");

		 
		//Log.i("FROM FACEBOOK",nom);
        facebook = new Facebook(APP_ID);
        mAsyncRunner = new AsyncFacebookRunner(facebook);
        
        btnFbLogin = (ImageView)findViewById(R.id.participer);
        
		btnFbLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    loginToFacebook();
                }
        });
		
		
        /*getinfos = (ImageView)findViewById(R.id.getinfos);
        
        getinfos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	getProfileInformation();
                }
        });*/
	}

    public void loginToFacebook() {
        mPrefs = getPreferences(MODE_PRIVATE);
        String access_token = mPrefs.getString("access_token", null);
        long expires = mPrefs.getLong("access_expires", 0);
     
        if (access_token != null) {
        	//access_token = null;
            facebook.setAccessToken(access_token);
            
            getProfileInformation();
        }
     
        if (expires != 0) { 
            facebook.setAccessExpires(expires);
        }
     
        if (!facebook.isSessionValid()) {
            facebook.authorize(this,
                    new String[] { "email","publish_stream", "read_stream", "offline_access" },
                    new DialogListener() {
     
                        public void onCancel() {
                            // Function to handle cancel event
                        }
     
                        public void onComplete(Bundle values) {
                            // Function to handle complete event
                            // Edit Preferences and update facebook acess_token
                            SharedPreferences.Editor editor = mPrefs.edit();
                            editor.putString("access_token",
                                    facebook.getAccessToken());
                            editor.putLong("access_expires",
                                    facebook.getAccessExpires());
                            editor.commit();
                            
                            getProfileInformation();
                        }
     
                        public void onError(DialogError error) {
                            // Function to handle error
     
                        }
     
                        public void onFacebookError(FacebookError fberror) {
                            // Function to handle Facebook errors
     
                        }
     
                    });
        }
    }
    
	public void  Register() throws IllegalStateException, IOException, URISyntaxException {    

	      try {
	          HttpClient client = new DefaultHttpClient();
	          HttpGet request = new HttpGet();
	          request.setURI(new URI("https://kiabifans.smartcafeine.com/api/register"));
	          HttpResponse response = client.execute(request);
	          //Toast.makeText(getBaseContext(), response.toString(), 3000).show();	
	          Log.i("RESQUEST SEND","RESQUEST SEND");
	      	}  catch (IOException e) {
		   	   e.printStackTrace();
		   	Log.i("ERROR SEND","ERROR SEND");		   	   }
	   }
	      
	
    public void getProfileInformation() {
        mAsyncRunner.request("me", new RequestListener() {
            @Override
            public void onComplete(String response, Object state) {
                Log.i("Profile", response);
                String json = response;
                try {
                    JSONObject profile = new JSONObject(json);
                    // getting name of the user
                    final String name = profile.getString("first_name");
                    // getting email of the user
                    final String email = profile.getString("email");
     
                    runOnUiThread(new Runnable() {
     
                        @Override
                        public void run() {
                        	Intent produits = new Intent(getApplicationContext(),Produits.class);
                        	produits.putExtra("name", name);
                        	
                        	produits.putExtra("produit_name_1",produit_name_1);
                    		produits.putExtra("produit_image_1",produit_image_1);
                    		produits.putExtra("produit_url_1",produit_url_1);
                    		produits.putExtra("produit_likes_1",produit_likes_1);
                    		
                    		produits.putExtra("produit_name_2",produit_name_2);
                    		produits.putExtra("produit_image_2",produit_image_2);
                    		produits.putExtra("produit_url_2",produit_url_1);
                    		produits.putExtra("produit_likes_2",produit_likes_2);
                    		
                    		produits.putExtra("produit_name_3",produit_name_3);
                    		produits.putExtra("produit_image_3",produit_image_3);
                    		produits.putExtra("produit_url_3",produit_url_3);
                    		produits.putExtra("produit_likes_3",produit_likes_3);
                    		
                    		produits.putExtra("produit_name_4",produit_name_4);
                    		produits.putExtra("produit_image_4",produit_image_4);
                    		produits.putExtra("produit_url_4",produit_url_1);
                    		produits.putExtra("produit_likes_4",produit_likes_4);
                    		
                    		produits.putExtra("produit_name_5",produit_name_5);
                    		produits.putExtra("produit_image_5",produit_image_5);
                    		produits.putExtra("produit_url_5",produit_url_5);
                    		produits.putExtra("produit_likes_5",produit_likes_5);
                    		
                    		produits.putExtra("produit_name_6",produit_name_6);
                    		produits.putExtra("produit_image_6",produit_image_6);
                    		produits.putExtra("produit_url_6",produit_url_6);
                    		produits.putExtra("produit_likes_6",produit_likes_6);
                    		
                    		produits.putExtra("produit_name_7",produit_name_7);
                    		produits.putExtra("produit_image_7",produit_image_7);
                    		produits.putExtra("produit_url_7",produit_url_7);
                    		produits.putExtra("produit_likes_7",produit_likes_7);
                    		
                    		produits.putExtra("produit_name_8",produit_name_8);
                    		produits.putExtra("produit_image_8",produit_image_8);
                    		produits.putExtra("produit_url_8",produit_url_8);
                    		produits.putExtra("produit_likes_8",produit_likes_8);
                    		
                    		produits.putExtra("produit_name_9",produit_name_9);
                    		produits.putExtra("produit_image_9",produit_image_9);
                    		produits.putExtra("produit_url_9",produit_url_9);
                    		produits.putExtra("produit_likes_9",produit_likes_9);
                    		
                    		produits.putExtra("produit_name_10",produit_name_10);
                    		produits.putExtra("produit_image_10",produit_image_10);
                    		produits.putExtra("produit_url_10",produit_url_10);
                    		produits.putExtra("produit_likes_10",produit_likes_10);
                    		
                        	/*produits.putExtra("produit_name", nom);
                        	produits.putExtra("produit_image", image);
                        	produits.putExtra("produit_url", url);
                        	produits.putExtra("produit_likes", likes);*/
                        	
                        	startActivity(produits);
                        	//Toast.makeText(getApplicationContext(), "Name: " + name + "\nEmail: " + email, Toast.LENGTH_LONG).show();
                            Log.i("Values **************","Name: " + name + "\nEmail: " + email);
                        }
     
                    });
                    Register();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }
     
          
            public void onIOException(IOException e, Object state) {
            }
     
           
            public void onFileNotFoundException(FileNotFoundException e,
                    Object state) {
            }
     
           
            public void onMalformedURLException(MalformedURLException e,
                    Object state) {
            }
     
           
            public void onFacebookError(FacebookError e, Object state) {
            }
        });
    }
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
