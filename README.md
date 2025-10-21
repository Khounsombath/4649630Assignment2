S4649630Assignment2 – Course Dashboard App
This Android application is developed as part of the MAP Assignment 2 project.
The app demonstrates key Android development principles including "Dependency Ijection (Hilt)", "API intergration using Retrofit", and "RecycleView-base UI" for displaying course information.
_____________________________________
Features
Login Screen – Simple authentication interface.
Dashboard Screen – Displays a list of university courses dynamically.
Detail Screen – Shows detailed course information including instructor, credits, and description.
API Integration – Fetches real course data from a RESTful API (https://nit3213api.onrender.com/dashboard/courses).
Hilt Dependency Injection – Implements clean architecture and modularity.
Offline Demo Mode – Loads sample data if API is unavailable.
________________________________________
Technical Implementation
Component	Purpose
Hilt	Used for dependency injection (AppModule.kt, S4649630Assignment2App.kt)
Retrofit & OkHttp	Handles API requests and responses
RecyclerView	Displays dynamic course list
Navigation Component	Manages navigation between Login → Dashboard → Details
JUnit	Used for unit testing the API service (DashboardApiTest.kt)
________________________________________
How to Build and Run
1. Prerequisites
Before running the project, ensure the following are installed on your system:
Android Studio (latest stable version)
Gradle (automatically managed by Android Studio)
Java JDK 17 or higher
Android SDK 33 or later
A physical Android device or emulator running Android 10 (API level 29) or higher

2. Steps to Build the Project
Clone the Repository
git clone https://github.com/Khounsombath/4649630Assignment2.git

Open in Android Studio
Launch Android Studio.
Select File → Open and choose the cloned project folder.
Wait for Gradle to finish syncing.
Build the Project
Click on Build → Make Project or use shortcut Ctrl + F9.
Ensure there are no build errors.
Run the Application
Connect your Android device (with USB debugging enabled) or open an Android Emulator.
Click Run → Run 'app' or press Shift + F10.
ependencies and Setup Instructions
The following dependencies are used in the project. They are already included in the build.gradle.kts files and will be automatically downloaded by Gradle. Core Dependencies
Dependency	Purpose
androidx.core:core-ktx	Android core extensions for Kotlin
androidx.appcompat:appcompat	Backward compatibility for older Android versions
com.google.android.material:material	Material Design components
androidx.constraintlayout:constraintlayout	Layout management
androidx.navigation:navigation-fragment-ktx	Navigation between fragments
androidx.navigation:navigation-ui-ktx	Navigation UI support
org.jetbrains.kotlinx:kotlinx-coroutines-android	Coroutine support for background tasks
com.squareup.retrofit2:retrofit	REST API integration
com.squareup.retrofit2:converter-gson	JSON parsing
com.squareup.okhttp3:logging-interceptor	API logging
org.koin:koin-android	Dependency Injection
junit:junit:4.13.2	Unit testing framework
androidx.test.ext:junit	Android JUnit support
androidx.test.espresso:espresso-core	UI testing
  Developer Information
Student Name: Khounsombath Silaxa Student ID: S4649630 Subject: (Mobile Application Programming) – Assignment 2 University: Victoria University
__________________________________________________
To Login:
Username = khounsombath
Password = 4649630
