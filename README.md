# Photogrid

Minimalistic tool to arrange images in a grid, saving the result as a png image (or sequence of png images).

## Usage

java -cp photogrid-1.0.jar tech.rallen.photogrid.Main

This has been tested with OpenJDK 11, and should work with any version of Java from 11 on.

The tool takes 5 optional command line parameters

  0 : path of input directory (default is ./testimages).

  1 : width (in pixels) of each input image in the output image (default 1000)  

  2 : height (in pixels) of each input image in the output image (default 1000)
    (note the image will be scaled maintaining aspect ratio so it fits within both the width and height above)

  3 : number of images per row in the output image(s)

  4 : number of images per column in the output image(s) 
    (default is to make a square with enough rows/columns to fit all the input images in a single output image)

  5 : output path and filename, this will be suffixed by either just '.png' or if there is more than one output image then a sequence number followed by '.png' (default is '2print')

## License

Copyright 2021 under the MIT License

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 


## About Me

Robert Allen is [Chief Marketing Officer at Droid Mobile](https://www.droid.mobi/)

<P  STYLE="margin-bottom: 0cm;"><A HREF="https://www.droid.mobi/">Droid Mobile is a mobile first software consultancy</A> that develops and advises on mobile apps, <A HREF="https://www.droid.mobi/android-mobile-apps-development.html">specialising in native Android</A> apps <A HREF="https://www.droid.mobi/kotlin-android-development-consultancy.html"> in Kotlin</A>
			and<A HREF="https://www.droid.mobi/java-android-development-consultancy.html"> in Java</A>, <A HREF="https://www.droid.mobi/ios-mobile-apps-development.html">in addition to native iOS</A> apps <A HREF="https://www.droid.mobi/swift-ios-development-consultancy.html">in Swift</A>
			, <A HREF="https://www.droid.mobi/cross-platform-mobile-development-consultancy.html">along with multi-platform
			apps</A> that support iOS, Android, <A HREF="https://www.droid.mobi/web-browser-apps-website-development.html">plus where required web</A> and <A HREF="https://www.droid.mobi/desktop-apps-development.html">desktop platfoms (Windows, OSX, Linux)</A>.</P>


