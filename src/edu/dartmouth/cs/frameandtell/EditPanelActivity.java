package edu.dartmouth.cs.frameandtell;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


public class EditPanelActivity extends Activity {
	private Panel panel;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		panel = new Panel();
//		requestWindowFeature(Window.FEATURE_NO_TITLE);
//		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);

		// Begin with main data entry view,
		// NewMealFragment
		setContentView(R.layout.activity_edit_panel);
//		FragmentManager manager = getFragmentManager();
//		Fragment fragment = manager.findFragmentById(R.id.fragmentContainer);
//
//		if (fragment == null) {
//			fragment = new NewPanelFragment();
//			manager.beginTransaction().add(R.id.fragmentContainer, fragment)
//			.commit();
//		}
	}
	public Panel getCurrentPanel() {
		return panel;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_panel, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle presses on the action bar items
		switch (item.getItemId()) {
		case R.id.action_home:
			Intent intent = new Intent(getApplicationContext(),
					HomeActivity.class);
			startActivity(intent);
			return true;
		case R.id.activity_timeline:
			Intent intent1 = new Intent(getApplicationContext(),
					TimelineActivity.class);
			startActivity(intent1);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	public void onSaveClicked(View view) {
		Intent intent = new Intent(getApplicationContext(),
				TimelineActivity.class);
		startActivity(intent);
	}

	public void onCancelClicked(View view) {
		Intent intent = new Intent(getApplicationContext(),
				TimelineActivity.class);
		startActivity(intent);
	}
	
	public void onAddImageClicked(View view) {
		FragmentManager manager = getFragmentManager();
		Fragment fragment = manager.findFragmentById(R.id.fragmentContainer);

		if (fragment == null) {
			fragment = new NewPanelFragment();
			manager.beginTransaction().add(R.id.fragmentContainer, fragment)
			.commit();
		}

	}

	public void onAddTextClicked(View view) {

	}

	public void onUndoClicked(View view) {

	}
	
	
	
}
