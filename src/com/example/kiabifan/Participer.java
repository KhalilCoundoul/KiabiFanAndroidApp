package com.example.kiabifan;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class Participer extends Activity {
	String nom,image,url,likes;
	String name;
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
		setContentView(R.layout.participer);
		
		
		
		Intent extra = getIntent();
		name = extra.getStringExtra("name");
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
		
			
		// Log.i("FROM PARTICIPER",nom);
		ImageView participer = (ImageView)findViewById(R.id.entrer);
		participer.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent facebook_connect = new Intent(getBaseContext(),FacebookConnect.class);	

				
				facebook_connect.putExtra("name", name);
            	
            	facebook_connect.putExtra("produit_name_1",produit_name_1);
        		facebook_connect.putExtra("produit_image_1",produit_image_1);
        		facebook_connect.putExtra("produit_url_1",produit_url_1);
        		facebook_connect.putExtra("produit_likes_1",produit_likes_1);
        		
        		facebook_connect.putExtra("produit_name_2",produit_name_2);
        		facebook_connect.putExtra("produit_image_2",produit_image_2);
        		facebook_connect.putExtra("produit_url_2",produit_url_1);
        		facebook_connect.putExtra("produit_likes_2",produit_likes_2);
        		
        		facebook_connect.putExtra("produit_name_3",produit_name_3);
        		facebook_connect.putExtra("produit_image_3",produit_image_3);
        		facebook_connect.putExtra("produit_url_3",produit_url_3);
        		facebook_connect.putExtra("produit_likes_3",produit_likes_3);
        		
        		facebook_connect.putExtra("produit_name_4",produit_name_4);
        		facebook_connect.putExtra("produit_image_4",produit_image_4);
        		facebook_connect.putExtra("produit_url_4",produit_url_1);
        		facebook_connect.putExtra("produit_likes_4",produit_likes_4);
        		
        		facebook_connect.putExtra("produit_name_5",produit_name_5);
        		facebook_connect.putExtra("produit_image_5",produit_image_5);
        		facebook_connect.putExtra("produit_url_5",produit_url_5);
        		facebook_connect.putExtra("produit_likes_5",produit_likes_5);
        		
        		facebook_connect.putExtra("produit_name_6",produit_name_6);
        		facebook_connect.putExtra("produit_image_6",produit_image_6);
        		facebook_connect.putExtra("produit_url_6",produit_url_6);
        		facebook_connect.putExtra("produit_likes_6",produit_likes_6);
        		
        		facebook_connect.putExtra("produit_name_7",produit_name_7);
        		facebook_connect.putExtra("produit_image_7",produit_image_7);
        		facebook_connect.putExtra("produit_url_7",produit_url_7);
        		facebook_connect.putExtra("produit_likes_7",produit_likes_7);
        		
        		facebook_connect.putExtra("produit_name_8",produit_name_8);
        		facebook_connect.putExtra("produit_image_8",produit_image_8);
        		facebook_connect.putExtra("produit_url_8",produit_url_8);
        		facebook_connect.putExtra("produit_likes_8",produit_likes_8);
        		
        		facebook_connect.putExtra("produit_name_9",produit_name_9);
        		facebook_connect.putExtra("produit_image_9",produit_image_9);
        		facebook_connect.putExtra("produit_url_9",produit_url_9);
        		facebook_connect.putExtra("produit_likes_9",produit_likes_9);
        		
        		facebook_connect.putExtra("produit_name_10",produit_name_10);
        		facebook_connect.putExtra("produit_image_10",produit_image_10);
        		facebook_connect.putExtra("produit_url_10",produit_url_10);
        		facebook_connect.putExtra("produit_likes_10",produit_likes_10);
				
				startActivity(facebook_connect);	
			}
		});
		
	}
}
