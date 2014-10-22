package net.mobctrl.glsurfaceviewbmp;

import java.util.Random;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.WindowManager;

/**
 * 
 * @author Zheng Haibo
 * @web http://www.mobctrl.net
 *
 */
public class MainActivity extends Activity {

	private GLSurfaceView glView; // Use GLSurfaceView
	Random rnd = new Random();

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(android.R.style.Theme_Translucent_NoTitleBar);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		glView = new GLSurfaceView(this); // Allocate a GLSurfaceView
		glView.setRenderer(new MyGLRenderer(this)); // Use a custom renderer
		glView.getAlpha();
		this.setContentView(glView); 

	}

	@Override
	protected void onPause() {
		super.onPause();
		glView.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		glView.onResume();
		android.provider.Settings.System.putInt(this.getContentResolver(),
				android.provider.Settings.System.SCREEN_BRIGHTNESS,
				rnd.nextInt(256));

	}
}
