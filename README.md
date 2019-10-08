# MaterialOfficeAbout
A simple about screen library for Android for a Team of people

## Screenshot

<img src="https://user-images.githubusercontent.com/6418354/65818936-5c886780-e238-11e9-834e-5a39e4ce7850.jpg" width="300">

## Installation
Add it in your root build.gradle at the end of repositories:
```
allprojects {
  repositories {
    maven { url 'https://jitpack.io' }
  }
}
```

Add the dependency
```
dependencies {
	        implementation 'com.github.rich-it:MaterialOfficeAbout:1.0.3'
}
```

# How to use:
## 1. Initialize:
To initialize you can use ```new OfficeAboutHelper(context, jsonUrl)``` like this:

```
OfficeAboutHelper officeAboutHelper = new OfficeAboutHelper(this, "https://raw.githubusercontent.com/p32929/SomeHowTosAndTexts/master/Office/OfficeInfoMaterial.json");
```

## 2. Show about activity:
You can show the about activity in 4 ways.

1. ```officeAboutHelper.showAboutActivity();``` // It will show a toolbar by default
2. ```officeAboutHelper.showAboutActivity(boolean showToolbar);```
3. ```officeAboutHelper.showAboutActivity(boolean showToolbar, LoadListener listener);```
4. ```officeAboutHelper.showAboutActivity(LoadListener listener);``` // It will show a toolbar by default

* Tip: If you want to add some more views dynamically, you might wanna use the ```LoadListener listener``` and add the views in ```onLoad(LinearLayout linearLayoutDummy)``` callback.
* Tip: If you want to shuffle the members list but keep someone at the top, you can use ```shuffleAndBringSomeoneTopByName()``` or ```shuffleAndBringSomeoneTopByDesignation()``` methods
For more info, check out the app in the repository

And lastly, if you are using Pro Guard add this line(Otherwise, the app will crash):

```
-keep public class org.richit.materialofficeaboutlib.Models.** { *; }
```

# LICENSE

```
MIT License

Copyright (c) 2019 rich-it

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

```