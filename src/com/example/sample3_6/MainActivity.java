package com.example.sample3_6;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
	ImageView iv;
	Bitmap bmp;
	int screenWidth,screenHeight;
	float scaleWidth,scaleHeight;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bmp=BitmapFactory.decodeResource(getResources(), R.drawable.xiaohei);
		DisplayMetrics dm=new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		screenWidth=dm.widthPixels;
		screenHeight=dm.heightPixels-80; 
		iv=(ImageView)findViewById(R.id.ImageView01);
		Button b1=(Button)findViewById(R.id.Button01);
		Button b2=(Button)findViewById(R.id.Button02);
		iv.setImageBitmap(bmp);

		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				iv.setImageBitmap(ScaleToFit(bmp,0.8f));
			}
		});
b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				iv.setImageBitmap(ScaleToFit(bmp,1.2f));
			}
		});
	}
	private static Bitmap ScaleToFit(Bitmap bm,float scale) {
		int width=bm.getWidth();
		int height=bm.getHeight();
		Matrix matrix=new Matrix();
		matrix.postScale(scale, scale);
		Bitmap bmResultBitmap=Bitmap.createBitmap(bm,0,0,width,height,matrix,true);
		return bmResultBitmap;
	}

}
