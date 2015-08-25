package com.ossidian.anxt.android;

import com.ossidian.ant.android.Uitl.FinalResourceRef;
import com.ossidian.ant.android.Uitl.ResourceMan;

import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;

public class FlashScreen extends View
{

	private Main mScreen;
	

	public FlashScreen(Main ms)
	{
		super(ms);
		this.mScreen = ms;
		this.setBackgroundDrawable(new BitmapDrawable(ResourceMan
				.getPicture(FinalResourceRef.FLAHS_SCREEN_IMAGE)));
		ms.initApp();
	}

	private final Runnable runable = new Runnable()
	{
		public void run()
		{
			mScreen.setMainMenuScreen();
		}
	};

	protected void onDraw(Canvas canvas)
	{
		this.postDelayed(runable, 2000);
	}

}