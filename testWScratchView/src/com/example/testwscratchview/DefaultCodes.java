package com.example.testwscratchview;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.winsontan520.WScratchView;

public class DefaultCodes extends Activity {
	private WScratchView scratchView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.default_codes);

		scratchView = (WScratchView) findViewById(R.id.scratch_view);
		
		// customize attribute programmatically
	    scratchView.setScratchable(true);
	    scratchView.setRevealSize(50);
	    scratchView.setAntiAlias(true);
	    scratchView.setOverlayColor(Color.RED); 
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void onClickHandler(View view){
		switch(view.getId()){
		case R.id.reset_button:
			scratchView.resetView();
			break;
		}
	}
}
