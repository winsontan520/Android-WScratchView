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

import com.winsontan520.WScratchView.OnScratchCallback;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public interface IWScratchView {

	/**
	 * Whether the view receive user on touch motion
	 * 
	 * @return true if scratchable
	 */
	public boolean isScratchable();

	/**
	 * If true, set the view allow receive on touch to reveal the view
	 * By default, scratchable is true
	 * 
	 * @param flag - flag for enable/disable scratch
	 */
	public void setScratchable(boolean flag);

	/**
	 * Set the color of overlay
	 * 
	 * @param ResId - resources identifier for color in INT type
	 */
	public void setOverlayColor(int ResId);

	/**
	 * Set the radius size of the circle to be revealed
	 * 
	 * @param size - radius size of circle in pixel unit
	 */
	public void setRevealSize(int size);

	/**
	 * Set turn on/off effect of anti alias of circle revealed
	 * By default, anti alias is turn off
	 * 
	 * @param flag - set true to turn on anti alias
	 */
	public void setAntiAlias(boolean flag);

	/**
	 * Reset the scratch view
	 * 
	 */
	public void resetView();

	/**
	 * Set drawable for scratch view
	 * 
	 * @param drawable - Set drawable for scratch view
	 */
	public void setScratchDrawable(Drawable drawable);

	/**
	 * Set bitmap for scratch view
	 * 
	 * @param bitmap - Set bitmap for scratch view
	 */
	public void setScratchBitmap(Bitmap b);

	/**
	 * Get scratched ratio (contribution from daveyfong)
	 * 
	 * @return  float - return Scratched ratio
	 */
	public float getScratchedRatio();

	/**
	 * Get scratched ratio (contribution from daveyfong)
	 * 
	 * @param int - Scratch speed
	 * @return  float - return Scratched ratio
	 */
	public float getScratchedRatio(int speed);

	public void setOnScratchCallback(OnScratchCallback callback);
}