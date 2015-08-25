package com.ossidian.ant.android.Uitl;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import com.ossidian.anxt.android.Main;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

public class ResourceMan
{
	private static Main context;
	private static Map<String, Bitmap> cache = new HashMap<String, Bitmap>();

	public static void init(Main context)
	{
		ResourceMan.context = context;
		initEnvir(context);
	}
	public static void initEnvir(Main context)
	{
		WindowManager winManager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics dm = new DisplayMetrics();     
		winManager.getDefaultDisplay().getMetrics(dm);     
		EnvirParam.SCREEN_WIDTH = dm.widthPixels;     
		EnvirParam.SCREEN_HIEGHT = dm.heightPixels;
	}
	public static void close(InputStream inputSteram)
	{
		if (null == inputSteram)
			return;
		try
		{
			inputSteram.close();
		} catch (Exception ex)
		{
		}
		return;
	}

	public static Bitmap getPicture(String path)
	{
		AssetManager am = context.getAssets();
		InputStream inputStream = null;
		try
		{
			inputStream = am.open(path);
			return BitmapFactory.decodeStream(inputStream);
		} catch (Exception ex)
		{
			Log.e("debug", ex.getMessage(), ex);
		} finally
		{
			close(inputStream);
		}
		return cache.get(path);
	}

	public static Bitmap get(String path)
	{
		if (cache.containsKey(path) == false)
		{
			Bitmap result = getPicture(path);
			cache.put(path, result);
			return result;
		}
		return cache.get(path);
	}

}
