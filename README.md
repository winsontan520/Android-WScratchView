Android-WScratchView
====================
##PLEASE NOTE, THIS PROJECT IS NO LONGER BEING MAINTAINED, YOU ARE WELCOME TO COPY AND IMPROVE AS YOUR OWN PROJECT. PLEASE INFORM ME THE IMPROVED VERSION SO I CAN LINK TO IT FOR OTHER USERS
####NOTE: This is NOT the best method but just a quick hack, the overlay will always on top of all layout. Improvement is needed for drawing one time on surface instead drawing multiple times.

## Features
This is a simple library that provide a quick implementation by writing code in xml layout to create a view which can be scratched to reveal items behind it like Scratchcard!

## Progress Note
Please use only project library for latest build

## Changelog
- v1.0 First version - Color Overlay
- v1.1 Add image overlay (Experimental) and getPercentage with callback (thanks to davefong)
- v1.2 Add Click Listener and Automatically Scratch All Features (by gilbert1991)

## Todo
- update Image Overlay (done 23 June 2014)
- update getPercentage (done 23 June 2014)
- update project structures
- update google play sample
- update tutorial

## Screenshots
![Screenshot](https://github.com/winsontan520/Android-WScratchView/raw/master/github_screenshot.png)

## Demo
[![Get it on Google Play](http://www.android.com/images/brand/get_it_on_play_logo_small.png)](https://play.google.com/store/apps/details?id=com.winsontan520.testwscratchview)

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

## Contributions

* [daveyfong](https://github.com/daveyfong)
* [gilbert1991](https://github.com/gilbert1991)

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
