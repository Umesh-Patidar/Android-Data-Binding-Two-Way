# Android-Data-Binding-Two-Way 

# Overview
Data binding allows to synchronize your user interface with your application model and logic. Two-way Data Binding works in the same way as regular, [One Way](https://github.com/umesh151988/Android-Data-Binding/blob/master/README.md) Data Binding. Using one-way data binding, you can set a value on an attribute and set a listener that reacts to a change in that attribute.


# Setup
To enable the usage of data binding in your Android application, add the following snippet to the app/build.gradle file.

```
 android {
     dataBinding.enabled = true
     }
```
# Binding data

A binding class is generated for each layout file. By default, the name of the class is based on the name of the layout file, converting it to Pascal case and adding the Binding suffix to it. The above layout filename is **activity_main.xml** so the corresponding generated class is **ActivityMainBinding**.
