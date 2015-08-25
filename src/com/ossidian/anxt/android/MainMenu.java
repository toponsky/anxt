package com.ossidian.anxt.android;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.ossidian.ant.android.Uitl.AppUitl;

public class MainMenu
{
	private View view;
	private Main context;
	private LayoutInflater inflater;
	private Button check_button;
	private Button learn_button;
	private Button act_button;
	private LinearLayout linearlayout;
	public MainMenu(Main context ,int orentation)
	{
		this.context=context;
		inflater = (LayoutInflater)context.getSystemService
	      (Context.LAYOUT_INFLATER_SERVICE);
		this.changeOrientation(orentation);
		
		
	}
	public View getView()
	{
		return view;
	}
	public void initView()
	{
		LinearLayout linearlayout= (LinearLayout)view.findViewById(R.id.center_container);
		Bitmap cycle = BitmapFactory.decodeResource(context.getResources(), R.drawable.transparentcycle);
		if(linearlayout==null)
		{
			AppUitl.print("null");
		}
		Canvas c = new Canvas();
		c.drawBitmap(cycle, 0, 0, new Paint());
	}
	public void changeOrientation(int orientation)
	{
		check_button=null;
		learn_button=null;
		act_button=null;
		linearlayout=null;
		view=null;
		if(orientation ==Configuration.ORIENTATION_PORTRAIT)
		{
			view = inflater.inflate(R.layout.main_menu_portrait_layout, null);
			
			check_button = (Button)view.findViewById(R.id.check_button);
			check_button.setTextColor(Color.WHITE);
			
			learn_button = (Button)view.findViewById(R.id.learn_button);
			learn_button.setTextColor(Color.WHITE);
			
			act_button = (Button)view.findViewById(R.id.act_button);
			act_button.setTextColor(Color.WHITE);
		}
		else
		{
			view = inflater.inflate(R.layout.main_menu_landscape_layout, null);
			
			check_button = (Button)view.findViewById(R.id.check_button);
			check_button.setTextColor(Color.WHITE);
			
			learn_button = (Button)view.findViewById(R.id.learn_button);
			learn_button.setTextColor(Color.WHITE);
			
			act_button = (Button)view.findViewById(R.id.act_button);
			act_button.setTextColor(Color.WHITE);
		}
	}

}

