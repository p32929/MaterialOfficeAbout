# MaterialOfficeAbout

A Material Design "About us" screen for Android apps made by a team. It shows your company logo, social links and every team member, all loaded from a JSON file you host. Change the team in that file and every app shows it, with no new release.

> **Looking for the newest version?** [OfficeAbout 2.0.0](https://github.com/p32929/OfficeAbout) (2026) is a Kotlin and Material 3 rewrite with light and dark mode, and it uses the same kind of JSON file. This library is the older Java version and is kept as it was.

## Screenshot

<img src="https://user-images.githubusercontent.com/6418354/65818936-5c886780-e238-11e9-834e-5a39e4ce7850.jpg" width="300">

## Features

1. **A Material Design "About us" screen,** added with two lines of code.
2. **Team details from a JSON file,** so you can update the team without shipping a new build.
3. **Toolbar on or off,** your choice.
4. **Add your own views** to the screen with a `LoadListener`.
5. **Shuffle the member list** but keep one person at the top, by name or by role.

## Install

1. Add JitPack to your root `build.gradle`:

```gradle
allprojects {
  repositories {
    maven { url 'https://jitpack.io' }
  }
}
```

2. Add the library:

```gradle
dependencies {
    implementation 'com.github.p32929:MaterialOfficeAbout:1.0.6'
}
```

## How to use

1. Create the helper with your JSON file's link:

```java
OfficeAboutHelper officeAboutHelper = new OfficeAboutHelper(this, "https://raw.githubusercontent.com/p32929/SomeHowTosAndTexts/master/Office/OfficeInfoMaterial.json");
```

2. Show the screen in one of these ways:

```java
officeAboutHelper.showAboutActivity();                                // with a toolbar
officeAboutHelper.showAboutActivity(boolean showToolbar);
officeAboutHelper.showAboutActivity(boolean showToolbar, LoadListener listener);
officeAboutHelper.showAboutActivity(LoadListener listener);           // with a toolbar
```

3. To add more views, pass a `LoadListener` and add them in its `onLoad(LinearLayout linearLayoutDummy)` callback.
4. To shuffle the members but keep someone first, use `shuffleAndBringSomeoneTopByName()` or `shuffleAndBringSomeoneTopByDesignation()`.
5. If you use ProGuard, add this line, or the app will crash:

```proguard
-keep public class org.richit.materialofficeaboutlib.Models.** { *; }
```

The `app` module in this repo is a full working example.

## License

MIT License — Copyright (c) 2019 Fayaz Bin Salam. See [LICENSE](LICENSE) for the full text.

## Contributing

Contributions are very welcome, thank you! Before you start on a pull request, please open an issue and tell me what you would like to add or change. That way we can agree on it first, and your time is not wasted on something that might not fit. Thanks for helping make MaterialOfficeAbout better.

## You might also like

<p><a href="https://openstore.pfay.workers.dev/more/p32929/materialofficeabout/personal/0"><picture><source media="(prefers-color-scheme: dark)" srcset="https://openstore.pfay.workers.dev/more/p32929/materialofficeabout/personal/0-dark.svg"><img src="https://openstore.pfay.workers.dev/more/p32929/materialofficeabout/personal/0-light.svg" width="50%" align="top" alt="More apps by p32929 on OpenStore (1)"></picture></a><a href="https://openstore.pfay.workers.dev/more/p32929/materialofficeabout/personal/1"><picture><source media="(prefers-color-scheme: dark)" srcset="https://openstore.pfay.workers.dev/more/p32929/materialofficeabout/personal/1-dark.svg"><img src="https://openstore.pfay.workers.dev/more/p32929/materialofficeabout/personal/1-light.svg" width="50%" align="top" alt="More apps by p32929 on OpenStore (2)"></picture></a><br><a href="https://openstore.pfay.workers.dev/more/p32929/materialofficeabout/personal/2"><picture><source media="(prefers-color-scheme: dark)" srcset="https://openstore.pfay.workers.dev/more/p32929/materialofficeabout/personal/2-dark.svg"><img src="https://openstore.pfay.workers.dev/more/p32929/materialofficeabout/personal/2-light.svg" width="50%" align="top" alt="More apps by p32929 on OpenStore (3)"></picture></a><a href="https://openstore.pfay.workers.dev/more/p32929/materialofficeabout/personal/3"><picture><source media="(prefers-color-scheme: dark)" srcset="https://openstore.pfay.workers.dev/more/p32929/materialofficeabout/personal/3-dark.svg"><img src="https://openstore.pfay.workers.dev/more/p32929/materialofficeabout/personal/3-light.svg" width="50%" align="top" alt="More apps by p32929 on OpenStore (4)"></picture></a></p>

<p><a href="https://p32929.github.io/share/?repo=MaterialOfficeAbout"><picture><source media="(prefers-color-scheme: dark)" srcset="https://p32929.github.io/readme/footer-share-dark.svg"><img src="https://p32929.github.io/readme/footer-share-light.svg" width="50%" align="top" alt="Share this project with your friends in one click"></picture></a><a href="https://p32929.github.io/support/"><picture><source media="(prefers-color-scheme: dark)" srcset="https://p32929.github.io/readme/footer-support-dark.svg"><img src="https://p32929.github.io/readme/footer-support-light.svg" width="50%" align="top" alt="If you like my work and want to support me, feel free to support"></picture></a><br><a href="https://openstore.pfay.workers.dev/add"><picture><source media="(prefers-color-scheme: dark)" srcset="https://p32929.github.io/readme/footer-join-dark.svg"><img src="https://p32929.github.io/readme/footer-join-light.svg" width="100%" align="top" alt="Put your own apps on OpenStore: free, your listing lives in your own repo"></picture></a></p>
