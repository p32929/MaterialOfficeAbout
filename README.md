# MaterialOfficeAbout

A Material Design "About us" screen for Android team apps — company logo, social links and a member list, all loaded from a JSON file you host. The successor to [OfficeAbout](https://github.com/p32929/OfficeAbout).

## Features

- **Material Design** about activity, drop-in with two lines
- **JSON-driven** — update the team without shipping a new build
- **Optional toolbar** and a `LoadListener` so you can inject extra views at runtime
- **Shuffle the member list** but pin someone at the top, by name or designation

## Screenshot

<img src="https://user-images.githubusercontent.com/6418354/65818936-5c886780-e238-11e9-834e-5a39e4ce7850.jpg" width="300">

## Installation
Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
  repositories {
    maven { url 'https://jitpack.io' }
  }
}
```

Add the dependency
```gradle
dependencies {
	        implementation 'com.github.p32929:MaterialOfficeAbout:1.0.6'
}
```

## How to use
### 1. Initialize
To initialize you can use ```new OfficeAboutHelper(context, jsonUrl)``` like this:

```java
OfficeAboutHelper officeAboutHelper = new OfficeAboutHelper(this, "https://raw.githubusercontent.com/p32929/SomeHowTosAndTexts/master/Office/OfficeInfoMaterial.json");
```

### 2. Show about activity
You can show the about activity in 4 ways.

1. ```officeAboutHelper.showAboutActivity();``` // It will show a toolbar by default
2. ```officeAboutHelper.showAboutActivity(boolean showToolbar);```
3. ```officeAboutHelper.showAboutActivity(boolean showToolbar, LoadListener listener);```
4. ```officeAboutHelper.showAboutActivity(LoadListener listener);``` // It will show a toolbar by default

* Tip: If you want to add some more views dynamically, you might wanna use the ```LoadListener listener``` and add the views in ```onLoad(LinearLayout linearLayoutDummy)``` callback.
* Tip: If you want to shuffle the members list but keep someone at the top, you can use ```shuffleAndBringSomeoneTopByName()``` or ```shuffleAndBringSomeoneTopByDesignation()``` methods
For more info, check out the app in the repository

And lastly, if you are using Pro Guard add this line(Otherwise, the app will crash):

```proguard
-keep public class org.richit.materialofficeaboutlib.Models.** { *; }
```

## License

MIT License — Copyright (c) 2019 Fayaz Bin Salam. See [LICENSE](LICENSE) for the full text.

## Contributing

Contributions are warmly welcomed and greatly appreciated! Whether it's a bug fix, new feature, or improvement, your input helps make this project better for everyone.

Before submitting a pull request, please:

1. Create an issue describing the feature or bug fix you'd like to work on
2. Wait for discussion and approval to ensure alignment with project goals
3. Fork the repository and create your feature branch
4. Submit your pull request with a clear description of changes

This approach helps avoid duplicate efforts and ensures smooth collaboration. Thank you for considering contributing!

## Share

Sharing this repository with your friends is just one click away from here

[![facebook](https://user-images.githubusercontent.com/6418354/179013321-ac1d1452-0689-493f-9066-940cf2302b6e.png)](https://www.facebook.com/sharer/sharer.php?u=https://github.com/p32929/MaterialOfficeAbout/)
[![twitter](https://user-images.githubusercontent.com/6418354/179013351-7d8d6d1c-4ce2-46ab-bef8-4c4765a1b888.png)](https://twitter.com/intent/tweet?url=https://github.com/p32929/MaterialOfficeAbout/)
[![tumblr](https://user-images.githubusercontent.com/6418354/179013343-3111f55a-3b90-40c7-8487-9777348672b0.png)](https://www.tumblr.com/share?v=3&u=https://github.com/p32929/MaterialOfficeAbout/)
[![pocket](https://user-images.githubusercontent.com/6418354/179013334-b095c45f-becf-49f4-9ee1-5a731a9b1f85.png)](https://getpocket.com/save?url=https://github.com/p32929/MaterialOfficeAbout/)
[![pinterest](https://user-images.githubusercontent.com/6418354/179013331-44cd9206-11b1-4b65-becb-5863b61c828f.png)](https://pinterest.com/pin/create/button/?url=https://github.com/p32929/MaterialOfficeAbout/)
[![reddit](https://user-images.githubusercontent.com/6418354/179013338-7416ae3f-73ba-4522-86e1-1374d7082d22.png)](https://www.reddit.com/submit?url=https://github.com/p32929/MaterialOfficeAbout/)
[![linkedin](https://user-images.githubusercontent.com/6418354/179013327-ca7b7102-1da8-4b1c-858f-1a6e5f21bd70.png)](https://www.linkedin.com/shareArticle?mini=true&url=https://github.com/p32929/MaterialOfficeAbout/)
[![whatsapp](https://user-images.githubusercontent.com/6418354/179013353-f477fa0b-3e6f-4138-a357-c9991b23ff88.png)](https://api.whatsapp.com/send?text=https://github.com/p32929/MaterialOfficeAbout/)

---

## Support

If this saved you time, you can buy me a coffee — it keeps these projects maintained and free. Other payment options: https://p32929.github.io/SendMoney2MeV1/

[![Buy Me A Coffee](https://img.shields.io/badge/Buy%20me%20a%20coffee-%E2%98%95-FFDD00?style=for-the-badge&logo=buymeacoffee&logoColor=black)](https://www.buymeacoffee.com/p32929)

<!-- hire-block -->

---

## 💼 Need this customised — or need it yesterday?

I take fixed-price native Android work on my own projects. No hourly billing, no surprise scope:

| | |
|---|---|
| **Drop-in integration** — I wire this into your codebase and hand you a PR that builds | **$45** · 3 days |
| **Priority bug fix or small feature** — jumps ahead of the free issue queue | **$95** · 72 hours |
| **Custom build** — branded, packaged and deployed, source yours | **$130** · 7 days |
| **A full app from scratch** | **from $350** · quoted first |

All prices and how to buy → **[p32929.github.io/hire](https://p32929.github.io/hire/)**  
Or buy through [Fiverr](https://www.fiverr.com/fayazbinsalam) (escrow, ID-verified, 5.0★) — safest for a first job.

Scoping and quotes are free: [open an issue](https://github.com/p32929/hire/issues/new) and describe the job.
