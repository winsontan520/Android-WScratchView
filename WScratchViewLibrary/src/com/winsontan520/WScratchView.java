/*******************************************************************************
 * Copyright 2013 Winson Tan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.winsontan520;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * This view start with full gray color bitmap and onTouch to make it transparent
 * 
 * @author winsontan520
 */
public class WScratchView extends SurfaceView implements IWScratchView, SurfaceHolder.Callback{
    private static final String TAG = "WScratchView";
    
    // default value constants
    private final int DEFAULT_COLOR = 0xff444444; // default color is dark gray
    private final int DEFAULT_REVEAL_SIZE = 30;
    
    private Context mContext;
    private WScratchViewThread mThread;
    List<Point> mPointTouchedList = new ArrayList<Point>();
    private int mOverlayColor;
    private Paint mOverlayPaint;
    private int mRevealSize;
    private boolean mIsScratchable = true;
    private boolean mIsAntiAlias = false;

    public WScratchView(Context ctx, AttributeSet attrs) {
        super(ctx, attrs);
        init(ctx, attrs); 
    }

	public WScratchView(Context context) {
        super(context);
        init(context, null);
    }
	
    private void init(Context context, AttributeSet attrs) {
    	mContext = context;
        
    	// default value
    	mOverlayColor = DEFAULT_COLOR;
    	
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.WScratchView, 0, 0);

        final int indexCount = ta.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
        	int attr = ta.getIndex(i);
        	switch(attr){
        		case R.styleable.WScratchView_overlayColor:
        			mOverlayColor = ta.getColor(attr, DEFAULT_COLOR);
        			break;
        		case R.styleable.WScratchView_revealSize:
                    mRevealSize = ta.getDimensionPixelSize(attr, DEFAULT_REVEAL_SIZE);
                    break;
        		case R.styleable.WScratchView_antiAlias:
        			mIsAntiAlias = ta.getBoolean(attr, false);
                    break;
        		case R.styleable.WScratchView_scratchable:
        			mIsScratchable = ta.getBoolean(attr, true);
                    break;         
        	}
        }
        
    	setZOrderOnTop(true);   
    	SurfaceHolder holder = getHolder();
    	holder.addCallback(this);
    	holder.setFormat(PixelFormat.TRANSPARENT);
	    
		mThread = new WScratchViewThread(getHolder(), this);

		mOverlayPaint = new Paint();   
		mOverlayPaint.setXfermode(new PorterDuffXfermode(Mode.CLEAR)); 
		
		mOverlayPaint.setAntiAlias(mIsAntiAlias);

	}
    

	@Override
	public void onDraw(Canvas canvas) {
		canvas.drawColor(mOverlayColor);
		for (Point point : mPointTouchedList) {
			canvas.drawCircle(point.x, point.y, mRevealSize, mOverlayPaint);
		}
		super.onDraw(canvas);

	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		synchronized (mThread.getSurfaceHolder()) {
			if (!mIsScratchable) {
				return true;
			}

			Point pointTouched = new Point();
			pointTouched.x = (int) event.getX();
			pointTouched.y = (int) event.getY();
			if (!mPointTouchedList.contains(pointTouched)) {
				mPointTouchedList.add(pointTouched);

			}
			return true;
		}
	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		// do nothing
	}

	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
		mThread.setRunning(true);
        mThread.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		boolean retry = true;
        mThread.setRunning(false);
        while (retry) {
            try {
                mThread.join();
                retry = false;
            } catch (InterruptedException e) {
                // do nothing but keep retry
            }
        }
		
	}

	class WScratchViewThread extends Thread {
		private SurfaceHolder mSurfaceHolder;
		private WScratchView mView;
		private boolean mRun = false;

		public WScratchViewThread(SurfaceHolder surfaceHolder, WScratchView view) {
			mSurfaceHolder = surfaceHolder;
			mView = view;
		}

		public void setRunning(boolean run) {
			mRun = run;
		}

		public SurfaceHolder getSurfaceHolder() {
			return mSurfaceHolder;
		}

		@Override
		public void run() {
			Canvas c;
			while (mRun) {
				c = null;
				try {
					c = mSurfaceHolder.lockCanvas(null);
					synchronized (mSurfaceHolder) {
						mView.onDraw(c);
					}
				} finally {
					if (c != null) {
						mSurfaceHolder.unlockCanvasAndPost(c);
					}
				}
			}
		}
	}
	
	@Override
	public void resetView(){
		synchronized (mThread.getSurfaceHolder()) {
			mPointTouchedList.clear();
		}
	}

	@Override
	public boolean isScratchable() {
		return mIsScratchable;
	}

	@Override
	public void setScratchable(boolean flag) {
		mIsScratchable = flag;
	}

	@Override
	public void setOverlayColor(int ResId) {
		mOverlayColor = ResId;
	}

	@Override
	public void setRevealSize(int size) {
		mRevealSize = size;
	}

	@Override
	public void setAntiAlias(boolean flag) {
		mOverlayPaint.setAntiAlias(flag);
	}
}



