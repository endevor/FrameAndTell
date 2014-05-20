package edu.dartmouth.cs.frameandtell;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class EditPanelActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_panel);
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

	}
	
	public void onAddTextClicked(View view) {

	}
	
	public void onUndoClicked(View view) {

	}

}
