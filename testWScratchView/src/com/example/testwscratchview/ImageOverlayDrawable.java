package com.example.testwscratchview;

import com.winsontan520.WScratchView;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageOverlayDrawable extends Activity {
	private WScratchView scratchView;
	private TextView percentageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image_overlay_drawable);

		percentageView = (TextView) findViewById(R.id.percentage);
		scratchView = (WScratchView) findViewById(R.id.scratch_view);

		// set drawable to scratchview
		scratchView.setScratchDrawable(getResources().getDrawable(R.drawable.test));

		// add callback for update scratch percentage
		scratchView.setOnScratchCallback(new WScratchView.OnScratchCallback() {

			@Override
			public void onScratch(float percentage) {
				updatePercentage(percentage);
			}

		});

		updatePercentage(0f);
	}

	protected void updatePercentage(float percentage) {
		String percentage2decimal = String.format("%.2f", percentage) + " %";
		percentageView.setText(percentage2decimal);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void onClickHandler(View view) {
		switch (view.getId()) {
		case R.id.reset_button:
			scratchView.resetView();
			updatePercentage(0f);
			break;
		}
	}
}
