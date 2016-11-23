# Currency Converter

A quick android currency converter that uses exchange rates from http://fixer.io/

## How to build and run the application

### How To Install

1. Go to your android device's settings
2. Navigate to security settings
3. Ensure "Unknown sources" is enabled / checked (as in picture below)
4. Visit https://github.com/phlogistic/currencyConverter/releases/download/0.1/app-debug.apk in your android device's browser
5. Install

![Install APKs from unknown sources](http://i.imgur.com/l8OCmy2.png)

### How To Build

1. Install git
2. Clone the project (`git clone https://github.com/phlogistic/currencyConverter.git`)
3. Install the android development kit
4. Use the SDK manager to download libraries & a version of android
5. Install gradle, or use gradle embedded in Android Studio
6. Execute `gradle clean assembleDebug`
7. The (debug) APK will be available in ./app/build/outputs/apk/app-debug.apk

## How to run the tests

### How to run unit tests

### How to run integration (instrumented) tests

## Developer notes

Having packages that only contain one class - such as presenter - by itself seems like overkill, but the purpose of doing so
is to demonstrate use of MVP in android. This application only requires one activity, however if there were more, there'd be more
than just one class in the presenter package.

Everything I wanted to do, but didn't get time:
* Dependency injection
* Offline / saving responses / cached for when you're somewhere that doesn't have internet access for exchange rates
* Activity indicator
* i18n (americans aren't the only ones who use dollars)
* Kotlin app
* Kotlin gradle
* Better creative
* Crash tool

## RESTful endpoint consumed

http://api.fixer.io/latest?base=USD