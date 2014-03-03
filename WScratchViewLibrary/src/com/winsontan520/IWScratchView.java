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
	 * Get the ratio of scratched area.
	 * 
	 * @return the ratio of scratched area from 0.0 to 1.0
	 */
	public float getScratchedRatio();

	/**
	 * Get the ratio of scratched area with the specified speed.
	 * It is done by comparing how many pixels have been set to transparent.
	 * 
	 * @param speed 1 is the slowest comparing all pixels, 2 compares half of the pixels, etc.
	 * @return the ratio of scratched area from 0.0 to 1.0
	 */
	public float getScratchedRatio(int speed);
}