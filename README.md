# MvvmDemo
Model View ViewModel

Goal
===============
MVVM stands for Model-View-ViewModel, which is a pattern widely adopted in Microsoft WPF and Silverlight.
Demo project to implement MVVM pattern in Android with the help of Android-Binding framework.

MVVM Android
===============
Model: Model in Android can be data coming from within your application (including Shared Preferences), Database (in Cursor, or via other Data Access Object) or externally (via Cursor to other Data Contract).
View: All the elements displayed in GUI, that include android.widget.* family, and your custom views.
ViewModel: ViewModel exposes properties and commands for the View, it also serves in data binding between the View and the Model. In Android, most of this job is done in Activity.

What do I need:
===============
Minimum API-Level 7 (2.1)
Android Studio 1.3.0-beta1 or higher
Add to project's build.gradle file dependencies "com.android.databinding:dataBinder:1.0-rc0"
Apply databinding plugin -> apply plugin: 'com.android.databinding'
More info @ https://developer.android.com/tools/data-binding/guide.html
