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
	        implementation 'com.github.rich-it:MaterialOfficeAbout:1.0.1'
}
```

## How to use:
1. Initialize
2. Show activity

## Usage:
### Initialization:
```
OfficeAboutHelper officeAboutHelper = new OfficeAboutHelper(this, "https://raw.githubusercontent.com/p32929/SomeHowTosAndTexts/master/Office/OfficeInfoMaterial.json");
```

## Show activity:
You can call ```showAboutActivity()```

or

```showAboutActivity(boolean showToolbar)```

 or

```showAboutActivity(boolean showToolbar, LoadListener listener)```

### Show activity example:

```
officeAboutHelper.showAboutActivity();
```

or

```
officeAboutHelper.showAboutActivity(true, new LoadListener() {
            @Override
            public void onLoad(LinearLayout linearLayoutDummy) {
                // You might wanna add some more views below the activity layout
                linearLayoutDummy.addView(LayoutInflater.from(MainActivity.this).inflate(R.layout.just_a_dummy_layout, null));
            }

            @Override
            public void onError(String error) {
                // You might wanna show a toast here with the error string
            }
        });
```

If you are using Pro Guard add this line:

```
-keep public class org.richit.materialofficeabout.Models.** { *; }
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