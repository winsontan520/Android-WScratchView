Android-WScratchView
====================

## Features
This is a simple library that provide a quick implementation by writing code in xml layout to create a view which can be scratched to reveal items behind it like Scratchcard!

## Progress Note
The standalone is obsolete, please use only project library for latest build

## Changelog
v1.0 First version - Color Overlay

## Todo
-update Image Overlay
-update project structures
-update google play sample

## Screenshots
![Screenshot](https://github.com/winsontan520/Android-WScratchView/raw/master/screenshot1.png)

## Usage
## Option 1: With library project
1. Git clone the project git://github.com/winsontan520/Android-WScratchView.git
2. For Eclipse, Import > Existing Android Code Into Workspace > Browse folder WScratchViewLibrary > Finish
3. Build the imported library project
4. Include the library in your project by right click your project > Android > In library tab click Add and choose the imported library
For testing, you may use sample project by import the folder testWScratchView and add the library
If you never include library project, I would recommend you to use option 2.
5. To call the view, in your layout xml,
    
        <com.winsontan520.WScratchView
            xmlns:wsv="http://schemas.android.com/apk/res-auto"
            android:id="@+id/scratch_view"
            android:layout_width="300dp"
            android:layout_height="300dp"
            android:layout_centerInParent="true"
            wsv:antiAlias="true"
            wsv:overlayColor="#0000ff"
            wsv:revealSize="20dp"
            wsv:scratchable="true" />


6. You can customize the overlay color, size and other attributes by changing the value. The attributes are self explanatory.

## Option 2: Without library project (Using standalone Jar) (OBSOLETE)
1. Copy https://github.com/winsontan520/Android-WScratchView/blob/master/wscratchviewjar.jar to your project libs folder
2. In your xml write something like below, 
    
        <com.winsontan520.WScratchView
            android:id="@+id/scratch_view"
            android:layout_width="300dp"
            android:layout_height="300dp"
            android:layout_centerInParent="true" />

3. Drawback of this option is you cant customize value in xml like option 1
4. To customize value, in your Activity,


    	protected void onCreate(Bundle savedInstanceState) {
    		super.onCreate(savedInstanceState);
    		setContentView(R.layout.activity_main);
    		
    		scratchView = (WScratchView) findViewById(R.id.scratch_view);
    		
    		// customize attribute programmatically
    		scratchView.setScratchable(true);
    		scratchView.setRevealSize(50);
    		scratchView.setAntiAlias(true);
    		scratchView.setOverlayColor(Color.RED);	
    	}

## License
    Copyright 2013 Winson Tan
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
       http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
