<table style="width:100%">
  <tr>
  <td>

## ChillMax
<p align="left"> An Android mobile application that lets users search for their favourite TV/Movie Shows and also they can add to their custom list.
</p>

## Description

This is a modern Mobile Application that fetches Data from TMDB API and lets users view movies and TV shows. The Mobile Application which is specifically on Android phones currently is built on Jetpack Compose and Kotlin.

### The purpose of this repository

- Follows Android design and development best practices with Compose.
- Explore the possibilities of creating Ui and Ux using a Mobile Movies App which we can use on a daily base for entertainment
- Build a fully functional Android app built entirely with Kotlin and Jetpack Compose.

### Status: 👨‍💻 Complete

<p>ChillMax is complete and will be updated if any issues arise.</p>

</td> 
<td>

https://user-images.githubusercontent.com/95022986/185205586-5f1f974a-f5e5-4acf-a4ba-51de9aae115f.mp4
</td>
</tr>
</table>

## Setup Requirements
Obtain your key from [TMDB API](https://www.themoviedb.org/documentation/api) and replace it in the `gradle.properties` file:

```gradle
    API_KEY = "API_KEY_VALUE"
```

## 🌚 Screenshots
|   Movies Screen    |  TV Shows Screen    |   Splash Screen   |  SearchScreen |
|---	|---	|---    |---   
| ![AllTasksDark](https://user-images.githubusercontent.com/95022986/185190209-7fb3e11b-a190-4747-bcbd-f8802a3a1ba4.jpeg)|  ![AddTaskDark](https://user-images.githubusercontent.com/95022986/185190760-8b143baa-3cfa-4025-a229-c5781dedccbb.jpeg) |   ![SplashDark](https://user-images.githubusercontent.com/95022986/185190914-fca949d4-152d-4eb4-af7d-7bebe104610b.jpeg)| ![EmptyDark](https://user-images.githubusercontent.com/95022986/185191175-93d3a29b-35ae-4463-b670-158cf8728526.jpeg)

|    Details Screen    |  My List Screen    | 
|---	|---
| ![AllTasksDark](https://user-images.githubusercontent.com/95022986/185190209-7fb3e11b-a190-4747-bcbd-f8802a3a1ba4.jpeg)|  ![AddTaskDark](https://user-images.githubusercontent.com/95022986/185190760-8b143baa-3cfa-4025-a229-c5781dedccbb.jpeg) |  

## 🛠 Built With

- - [Kotlin](https://developer.android.com/kotlin) - Kotlin is a programming language that can run on JVM. Google has announced Kotlin as one of its officially supported programming languages in Android Studio; and the Android community is migrating at a pace from Java to Kotlin.
- Jetpack components:
    - [Jetpack Compose](https://developer.android.com/jetpack/compose) - Jetpack Compose is Android’s modern toolkit for building native UI. It simplifies and accelerates UI development on Android. Quickly bring your app to life with less code, powerful tools, and intuitive Kotlin APIs.
    - [Android KTX](https://developer.android.com/kotlin/ktx.html) - Android KTX is a set of Kotlin extensions that are included with Android Jetpack and other Android libraries. KTX extensions provide concise, idiomatic Kotlin to Jetpack, Android platform, and other APIs.
    -  [Jetpack DataStore](https://developer.android.com/topic/libraries/architecture/datastore) -
       Jetpack DataStore is a data storage solution that allows you to store key-value pairs or typed
       objects with protocol buffers. DataStore uses Kotlin coroutines and Flow to store data
       asynchronously, consistently, and transactionally.
    - [AndroidX](https://developer.android.com/jetpack/androidx) - Major improvement to the original Android [Support Library](https://developer.android.com/topic/libraries/support-library/index), which is no longer maintained.
    - [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - Lifecycle-aware components perform actions in response to a change in the lifecycle status of another component, such as activities and fragments. These components help you produce better-organized, and often lighter-weight code, that is easier to maintain.
    - [Flow](https://kotlinlang.org/docs/reference/coroutines/flow.html) - A flow is an asynchronous
       version of a Sequence, a type of collection whose values are lazily produced.
    - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) -The ViewModel class is designed to store and manage UI-related data in a lifecycle conscious way.
    - [Paging 3 library](https://developer.android.com/topic/libraries/architecture/paging/v3-overview) - The Paging library helps you load and display pages of data from a larger dataset from local storage or over network. This approach allows your app to use both network bandwidth and system resources more efficiently.
    - [Room database](https://developer.android.com/training/data-storage/room) - The Room persistence library provides an abstraction layer over SQLite to allow fluent database access while harnessing the full power of SQLite. -

- [Retrofit](https://square.github.io/retrofit) -  Retrofit is a REST client for Java/ Kotlin and Android by Square inc under Apache 2.0 license. Its a simple network library that is used for network transactions. By using this library we can seamlessly capture JSON response from web service/web API.
- [GSON](https://github.com/square/gson) - JSON Parser,used to parse requests on the data layer for Entities and understands Kotlin non-nullable and default parameters.
- [Dagger Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - A dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project.
- [Ramcosta Navigation Library](https://composedestinations.rafaelcosta.xyz/) - A KSP library that processes annotations and generates code that uses Official Jetpack Compose Navigation under the hood. It hides the complex, non-type-safe and boilerplate code you would have to write otherwise.
- [Logging Interceptor](https://github.com/square/okhttp/blob/master/okhttp-logging-interceptor/README.md) -  logs HTTP request and response data.
- [Coil](https://coil-kt.github.io/coil/compose/)- An image loading library for Android backed by Kotlin Coroutines.

<br />

## 🗼 Architecture
This app uses [***MVVM (Model View
View-Model)***](https://developer.android.com/jetpack/docs/guide#recommended-app-arch) architecture.

## 🧰 Build-tool
Android Studio Chipmunk

## 🤝 Contribute
If you want to contribute to this app, you're always welcome!
<br>

## 📩 Contact

I know that first and foremost you are looking for a tool to solve your problems, but if you enjoy
it that much, why not tell us? We would love to hear from you 😉

DM me at 👇

* Twitter: <a href="https://twitter.com/_CalebLangat" target="_blank">@_CalebLangat</a>
* Email: langat.caleb95@gmail.com

<br>

## 🔖 License

```
MIT License
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
FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.<br>
Copyright (c) 2022 **Caleb Langat**

```
