# MaterialOfficeAbout
A simple about screen library for Android for a Team of people

[![](https://badgen.net/github/release/p32929/MaterialOfficeAbout)]() [![](https://badgen.net/github/release/p32929/MaterialOfficeAbout/stable)]() [![](https://badgen.net/github/tag/p32929/MaterialOfficeAbout)]() [![](https://badgen.net/github/watchers/p32929/MaterialOfficeAbout)]() [![](https://badgen.net/github/checks/p32929/MaterialOfficeAbout)]() [![](https://badgen.net/github/status/p32929/MaterialOfficeAbout)]() [![](https://badgen.net/github/stars/p32929/MaterialOfficeAbout)]() [![](https://badgen.net/github/forks/p32929/MaterialOfficeAbout)]() [![](https://badgen.net/github/issues/p32929/MaterialOfficeAbout)]() [![](https://badgen.net/github/open-issues/p32929/MaterialOfficeAbout)]() [![](https://badgen.net/github/closed-issues/p32929/MaterialOfficeAbout)]() [![](https://badgen.net/github/label-issues/p32929/MaterialOfficeAbout/help-wanted/open)]() [![](https://badgen.net/github/prs/p32929/MaterialOfficeAbout)]() [![](https://badgen.net/github/open-prs/p32929/MaterialOfficeAbout)]() [![](https://badgen.net/github/closed-prs/p32929/MaterialOfficeAbout)]() [![](https://badgen.net/github/merged-prs/p32929/MaterialOfficeAbout)]() [![](https://badgen.net/github/commits/p32929/MaterialOfficeAbout)]() [![](https://badgen.net/github/last-commit/p32929/MaterialOfficeAbout)]() [![](https://badgen.net/github/branches/p32929/MaterialOfficeAbout)]() [![](https://badgen.net/github/releases/p32929/MaterialOfficeAbout)]() [![](https://badgen.net/github/tags/p32929/MaterialOfficeAbout)]() [![](https://badgen.net/github/license/p32929/MaterialOfficeAbout)]() [![](https://badgen.net/github/contributors/p32929/MaterialOfficeAbout)]() [![](https://badgen.net/github/dependents-pkg/p32929/MaterialOfficeAbout)]() 

## Share
Sharing with your friends is just one click away from here

[![facebook](https://image.flaticon.com/icons/png/32/124/124010.png)](https://www.facebook.com/sharer/sharer.php?u=https://github.com/p32929/MaterialOfficeAbout)
[![twitter](https://image.flaticon.com/icons/png/32/124/124021.png)](https://twitter.com/intent/tweet?source=https://github.com/p32929/MaterialOfficeAbout)
[![tumblr](https://image.flaticon.com/icons/png/32/124/124012.png)](https://www.tumblr.com/share?v=3&u=https://github.com/p32929/MaterialOfficeAbout)
[![pocket](https://image.flaticon.com/icons/png/32/732/732238.png)](https://getpocket.com/save?url=https://github.com/p32929/MaterialOfficeAbout)
[![pinterest](https://image.flaticon.com/icons/png/32/124/124039.png)](https://pinterest.com/pin/create/button/?url=https://github.com/p32929/MaterialOfficeAbout)
[![reddit](https://image.flaticon.com/icons/png/32/2111/2111589.png)](https://www.reddit.com/submit?url=https://github.com/p32929/MaterialOfficeAbout)
[![linkedin](https://image.flaticon.com/icons/png/32/1409/1409945.png)](https://www.linkedin.com/shareArticle?mini=true&url=https://github.com/p32929/MaterialOfficeAbout)
[![whatsapp](https://image.flaticon.com/icons/png/32/733/733585.png)](https://api.whatsapp.com/send?text=https://github.com/p32929/MaterialOfficeAbout)

## Support
If you like my works and want to support me/my works, feel free to support or donate. My payment details can be found here: https://p32929.github.io/SendMoney2Me/

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
	        implementation 'com.github.p32929:MaterialOfficeAbout:1.0.6'
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

Copyright (c) 2019 Fayaz Bin Salam

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
