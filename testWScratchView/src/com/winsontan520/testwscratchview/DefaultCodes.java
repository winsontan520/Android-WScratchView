package com.winsontan520.testwscratchview;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.winsontan520.testwscratchview.R;
import com.winsontan520.WScratchView;

public class DefaultCodes extends Activity {
	private WScratchView scratchView;
	private TextView percentageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.default_codes);

		percentageView = (TextView) findViewById(R.id.percentage);
		scratchView = (WScratchView) findViewById(R.id.scratch_view);

		// customize attribute programmatically
		scratchView.setScratchable(true);
		scratchView.setRevealSize(50);
		scratchView.setAntiAlias(true);
		scratchView.setOverlayColor(Color.RED);

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
