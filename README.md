# Currency Converter

A quick android currency converter that uses exchange rates from http://fixer.io/

TODO: supply link to APK

## How to build and run the application

TODO: this

## How to run the tests

TODO: this

## Developer notes

Having packages that only contain one class - such as presenter - by itself seems like overkill, but the purpose of doing so
is to demonstrate use of MVP in android. This application only requires one activity, however if there were more, there'd be more
than just one class in the presenter package.

Everything I wanted to do, but didn't get time:
* Dependency injection
* Crash tool
* Offline / saving responses / cached for when you're somewhere that doesn't have internet access for exchange rates
* Activity indicator
* i18n (americans aren't the only ones who use dollars)
* Kotlin app
* Kotlin gradle
* Better creative

## RESTful endpoint consumed

http://api.fixer.io/latest?base=USD