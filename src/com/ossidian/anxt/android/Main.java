package com.ossidian.anxt.android;

import com.ossidian.ant.android.Uitl.AppUitl;
import com.ossidian.ant.android.Uitl.EnvirParam;
import com.ossidian.ant.android.Uitl.ResourceMan;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;

public class Main extends Activity {
    /** Called when the activity is first created. */
	private FrameLayout rootFrame;
	private View currentView;
	private MainMenu mainMenu;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        rootFrame = new FrameLayout(this);
        ResourceMan.init(this);
		setContentView(rootFrame); // display the game view.
		this.setFlashScreen();
    }
    public void initApp()
    {
    	//Initialise main menu (The view after flashing screen).
    	mainMenu= new MainMenu(this,this.getResources().getConfiguration().orientation);
    }
   
	public void setFlashScreen()
	{
		if (currentView != null)
		{
			rootFrame.removeView(currentView);
			currentView = null;
		}
		currentView = new FlashScreen(this);
		rootFrame.addView(currentView);
	}
	public void setMainMenuScreen()
	{
		if (currentView != null)
		{
			rootFrame.removeView(currentView);
			currentView = null;
		}
		currentView = mainMenu.getView();
		rootFrame.addView(currentView);
	}
    public void onOrientationChanged(float azimuth, float pitch, float roll) 
    {
    	AppUitl.print("azimuth : "+String.valueOf(azimuth));
    	AppUitl.print("pitch : "+String.valueOf(pitch));
    	AppUitl.print("roll : "+String.valueOf(roll));
    }
	@Override
    public void onConfigurationChanged(Configuration newConfig) {
            super.onConfigurationChanged(newConfig);
            if(currentView.equals(mainMenu.getView()))
            {
            	mainMenu.changeOrientation(this.getResources().getConfiguration().orientation);
            	this.setMainMenuScreen();
            }
    }
}