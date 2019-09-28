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
``

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

