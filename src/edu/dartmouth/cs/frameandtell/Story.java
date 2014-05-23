package edu.dartmouth.cs.frameandtell;

import java.util.ArrayList;

import android.app.Activity;

public class Story extends Activity {
	String title;
	ArrayList<Panel> panels;
	
	private Panel mPanel;

	Story(String title) {
		title = this.title;
		panels = new ArrayList<Panel>();
	}
	
	//setting the title for each panel
	public void onTitleSet(String s)
	{
		
		mPanel.setTitle(s);
	}
	
	
}
