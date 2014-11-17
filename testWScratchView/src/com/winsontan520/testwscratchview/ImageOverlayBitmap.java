package com.winsontan520.testwscratchview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.winsontan520.testwscratchview.R;
import com.winsontan520.WScratchView;

public class ImageOverlayBitmap extends Activity {
	private WScratchView scratchView;
	private TextView percentageView;
	private float mPercentage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image_overlay_bitmap);

		percentageView = (TextView) findViewById(R.id.percentage);
		scratchView = (WScratchView) findViewById(R.id.scratch_view);

		// set bitmap to scratchview
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
		scratchView.setScratchBitmap(bitmap);

		// add callback for update scratch percentage
		scratchView.setOnScratchCallback(new WScratchView.OnScratchCallback() {

			@Override
			public void onScratch(float percentage) {
				updatePercentage(percentage);
			}

			@Override
			public void onDetach(boolean fingerDetach) {
				if(mPercentage > 50){
					scratchView.setScratchAll(true);
					updatePercentage(100);
				}
			}
		});

		updatePercentage(0f);
	}

	protected void updatePercentage(float percentage) {
		mPercentage = percentage;
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
			scratchView.setScratchAll(false); // todo: should include to resetView?
			updatePercentage(0f);
			break;
		}
	}
}
