package com.example.kiabifan;

import org.json.JSONObject;

import com.facebook.android.AsyncFacebookRunner;
import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.FacebookError;
import com.facebook.android.Facebook.DialogListener;
import com.facebook.android.Util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences; 
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



public class Deconnecter extends Activity {
	
	private static String APP_ID = "215850891893789"; // Replace your App ID here
	 
	private static final String[] PERMISSIONS =
	           new String[] {"publish_stream", "read_stream", "offline_access"};
	
	private ProgressDialog 	dialog;
	private Handler	mHandler;
	
    // Instance of Facebook Class
    private Facebook facebook;
    String FILENAME = "AndroidSSO_data";
    private SharedPreferences mPrefs;
    
	ImageView deconnecter,share;
	TextView bravo,tictac ;
	String nom;
	private AsyncFacebookRunner mAsyncRunner;
    
	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.deconnect);
	
	Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Lato-Bold.ttf");
	TextView txt_title = (TextView)findViewById(R.id.txt_conteur);
	TextView home_t = (TextView)findViewById(R.id.home_text);
	TextView home_t_2 = (TextView)findViewById(R.id.home_text_2);
	txt_title.setTypeface(font);
	home_t.setTypeface(font);
	home_t_2.setTypeface(font);
	
	/*facebook = new Facebook(APP_ID);
    mAsyncRunner = new AsyncFacebookRunner(facebook);
    
	*/
	tictac = (TextView)findViewById(R.id.tictac);
	

    MyCount counter = new MyCount(15000, 1000);
    counter.start();
	dialog  = new ProgressDialog(this);
	   
	 
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
		
	Intent getNom = getIntent();
	nom = getNom.getStringExtra("name");
	bravo = (TextView)findViewById(R.id.bravo);
	bravo.setText("Bravo , "+nom+" !");
    
	share = (ImageView)findViewById(R.id.share);
	share.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//Bundle params = Post();
			sendtoFacebook();
			/*dialog.setMessage("Partage en cours ... ");
			dialog.show();
			 new Thread(new Runnable(){
					public void run() {
						Looper.prepare();
			             
			             postFacebookMessage();
			             mHandler.sendEmptyMessage(1);
					}
				}).start();
		   Toast.makeText(getBaseContext(), "Contenu paragé !", Toast.LENGTH_LONG).show();*/
		}
	});
	
	deconnecter = (ImageView)findViewById(R.id.deconnecter);
	deconnecter.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			dialog.setMessage("Déconnection en cours ... ");
			dialog.show();
			 new Thread(new Runnable(){
					public void run() {
						Looper.prepare();
						//restartFirstActivity();
					}
				}).start();
		   mHandler.sendEmptyMessage(1);
		}
	});
	
	}
   /* public void loginToFacebook() {
        mPrefs = getPreferences(MODE_PRIVATE);
        String access_token = mPrefs.getString("access_token", null);
        long expires = mPrefs.getLong("access_expires", 0);

            facebook.setAccessToken(access_token);
            

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
                            
                            ShareIt();
                        }
     
                        private void ShareIt() {
							// TODO Auto-generated method stub
                            try {
                                //Log.d("Tests", "Testing request for 'me'");
                            	//facebook.dialog(getApplicationContext(), "feed", parameters, listener)
                                String response = facebook.request("me");
                                JSONObject obj = Util.parseJson(response);

                                Log.d("Tests", "Testing graph API wall post");
                                Bundle parameters = new Bundle();
                                parameters.putString("picture", "http://kiabifans.smartcafeine.com/img/logo.png");
                                parameters.putString("message","KIABI FAN SELECTION");
                                parameters.putString("description","Je viens de voter pour mes articles préférés KIABI pour gagner un bon d'achat d'une valeur de 200€ " );
                                parameters.putString("link","https://apps.facebook.com/kiabifanselection/");
                                /*parameters.putString("message", "Amit Siddhpura");
                                parameters.putString("description", "Hi Mr. Amit Siddhpura");*/
                                //facebook.dialog(getApplicationContext(),"me/feed", parameters,(DialogListener) Deconnecter.this);
                               /* response = facebook.request("me/feed", parameters, 
                                        "POST");
                                /*Toast.makeText(getBaseContext(), "Contenu paragé !"+response, Toast.LENGTH_LONG).show();
                                Log.i("********* FACEBOOK RESPONSE ***************",response.toString());*/
                                
                            /*} catch (Throwable e) {
                                e.printStackTrace();
                            }
                             
						}

						public void onError(DialogError error) {
                            // Function to handle error
     
                        }
     
                        public void onFacebookError(FacebookError fberror) {
                            // Function to handle Facebook errors
     
                        }
     
                    });
        }*/
    
    /*private void postFacebookMessage() {

    	  AsyncFacebookRunner mAsyncRunner = new AsyncFacebookRunner(facebook);
    	  Bundle params = new Bundle();
    	  params.putString("message", "");
    	  params.putString("picture", "http://meanwhileinwv.com/meanwhile.png");
    	  mAsyncRunner.request("me/feed", params, "POST",null, null); }    

    	@Override
    	public void onActivityResult(int requestCode, int resultCode, Intent data) {
    	    super.onActivityResult(requestCode, resultCode, data);
    	    facebook.authorizeCallback(requestCode, resultCode, data);
    	}*/
    	
	public void sendtoFacebook(){
        facebook = new Facebook(APP_ID);
        facebook.authorize(Deconnecter.this, new AuthorizeListener());
    }
	
	class AuthorizeListener implements DialogListener {
	    public void onComplete(Bundle values) {
	        Bundle parameters = new Bundle();
	        parameters.putString("picture", "http://kiabifans.smartcafeine.com/img/logo.png");
            parameters.putString("message","KIABI FAN SELECTION");
            parameters.putString("description","Je viens de voter pour mes articles préférés KIABI pour gagner un bon d'achat d'une valeur de 200€ " );
            parameters.putString("link","https://apps.facebook.com/kiabifanselection/");
	        facebook.dialog(Deconnecter.this, "feed", parameters, this);// "stream.publish" is an API call
	    }
	    @Override
	    public void onFacebookError(FacebookError e) {
	    }
	    @Override
	    public void onError(DialogError e) {
	    }
	    @Override
	    public void onCancel() {
	    }
	}
	
    private Bundle Post() {
		// TODO Auto-generated method stub
    	Bundle parameters = new Bundle();
    	try {
            //Log.d("Tests", "Testing request for 'me'");
        	//facebook.dialog(getApplicationContext(), "feed", parameters, listener)
            String response = facebook.request("POST");
            JSONObject obj = Util.parseJson(response);

            Log.d("Tests", "Testing graph API wall post");
            
            parameters.putString("picture", "http://kiabifans.smartcafeine.com/img/logo.png");
            parameters.putString("message","KIABI FAN SELECTION");
            parameters.putString("description","Je viens de voter pour mes articles préférés KIABI pour gagner un bon d'achat d'une valeur de 200€ " );
            parameters.putString("link","https://apps.facebook.com/kiabifanselection/");
            /*parameters.putString("message", "Amit Siddhpura");
            parameters.putString("description", "Hi Mr. Amit Siddhpura");*/
            //facebook.dialog(getApplicationContext(),"me/feed", parameters,(DialogListener) Deconnecter.this);
           /* response = facebook.request("me/feed", parameters, 
                    "POST");
            /*Toast.makeText(getBaseContext(), "Contenu paragé !"+response, Toast.LENGTH_LONG).show();
            Log.i("********* FACEBOOK RESPONSE ***************",response.toString());*/
            
        } catch (Throwable e) {
            e.printStackTrace();
        }
		return parameters;
	}
    /*
	private void shareIt() {
		// TODO Auto-generated method stub
		Bundle parameters = new Bundle();
		parameters.putString("picture", "http://kiabifans.smartcafeine.com/img/logo.png");
        parameters.putString("message","KIABI FAN SELECTION");
        parameters.putString("description","Je viens de voter pour mes articles préférés KIABI pour gagner un bon d'achat d'une valeur de 200€ " );
        parameters.putString("link","https://apps.facebook.com/kiabifanselection/");
		    // post on user's wall.
		    facebook.dialog(this, "me/feed", parameters,new DialogListener() {

				@Override
				public void onComplete(Bundle values) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onFacebookError(FacebookError e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onError(DialogError e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onCancel() {
					// TODO Auto-generated method stub
					
				}

		    });
		 
		
        /*try {
            //Log.d("Tests", "Testing request for 'me'");
            String response = facebook.request("me");
            JSONObject obj = Util.parseJson(response);

            Log.d("Tests", "Testing graph API wall post");
            Bundle parameters = new Bundle();
            parameters.putString("picture", "http://kiabifans.smartcafeine.com/img/logo.png");
            parameters.putString("message","KIABI FAN SELECTION");
            parameters.putString("description","Je viens de voter pour mes articles préférés KIABI pour gagner un bon d'achat d'une valeur de 200€ " );
            parameters.putString("link","https://apps.facebook.com/kiabifanselection/");
            response = facebook.request("me/feed", parameters,"POST");
            //facebook.dialog(getApplicationContext(),"me/feed", parameters,(DialogListener) Deconnecter.this);
            
        } catch (Throwable e) {
            e.printStackTrace();
        }*/
//	}

	// countdowntimer is an abstract class, so extend it and fill in methods
    public class MyCount extends CountDownTimer {

        public MyCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            tictac.setText("0");
            //restartFirstActivity();
        }

        @Override
        public void onTick(long millisUntilFinished) {
        	tictac.setText(" " + millisUntilFinished / 1000 +" secondes");
        }
    }
    
	private void restartFirstActivity()
	 {
		dialog.setMessage("Déconnection en cours ... ");
		dialog.show();
		 new Thread(new Runnable(){
				public void run() {
					Looper.prepare();
		             //Toast.makeText(getBaseContext(), "Contenu paragé !", Toast.LENGTH_LONG).show();
					Log.i(" *************************** "," FKGJUNVGK;WJRPTVNWJRGWIRPGJVPWRI ");
					Intent i = getBaseContext().getPackageManager()
					.getLaunchIntentForPackage(getBaseContext().getPackageName() );
					i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK );
					startActivity(i); 
		            
				}
			}).start();
		 mHandler.sendEmptyMessage(1);

	 }
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
	    super.onActivityResult(requestCode, resultCode, data);

	    facebook.authorizeCallback(requestCode, resultCode, data);
	}

}
