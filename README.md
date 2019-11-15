# Android-Data-Binding-Two-Way 

# Overview
Data binding allows to synchronize your user interface with your application model and logic. Two-way Data Binding works in the same way as regular, [One Way](https://github.com/umesh151988/Android-Data-Binding/blob/master/README.md) Data Binding. Using one-way data binding, you can set a value on an attribute and set a listener that reacts to a change in that attribute.In Two way the @={} notation, which importantly includes the "=" sign, receives data changes to the property and listen to user updates at the same time.

# Setup
To enable the usage of data binding in your Android application, add the following snippet to the app/build.gradle file.

```
 android {
     dataBinding.enabled = true
     }
```

# Binding data

A binding class is generated for each layout file. By default, the name of the class is based on the name of the layout file, converting it to Pascal case and adding the Binding suffix to it. The above layout filename is **activity_main.xml** so the corresponding generated class is **ActivityMainBinding**.

# Layouts and binding expressions

The expression language allows you to write expressions that connect variables to the views in the layout. The Data Binding Library automatically  generates the classes required to bind the views in the layout with your data objects.

For example, the binding variables that can be used in expressions are defined inside a data element that is a sibling of the UI layout's root element. Both elements are wrapped in a layout tag, as shown in the following example:

```
<layout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto">
    <data>
        <variable
            name="viewmodel"
            type="com.myapp.data.ViewModel" />
    </data>
    <ConstraintLayout... /> 
</layout>
```
The usage of data binding requires changes in your layout files. Such layout files starts with a **layout** root tag followed by a **data** element and a **view root element**. The **data** elements describe data which is available for binding. This view element contains your root hierarchy similar to layout files which are not used with data binding. References to the data elements or expressions within the layout are written in the attribute properties using the **@{} or @={}**.

> In order to react to changes in the backing data, you can make your layout variable an implementation of Observable, usually **BaseObservable**, and use a **@Bindable** annotation, as shown in the following code snippet:

```
public class UserData extends BaseObservable {
    private String email;
    private String password;
    private Context context;

    public UserData(Context context) {
        this.context = context;
    }

    @Bindable
    public String getEmail() {
        if (email == null) {
            return "";
        }
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }
}
```
# Two-way data binding using custom attributes

>Two-way attributes

The platform provides built-in support for two-way data binding when you use the attributes in the following table

| Class         	| Attribute(s) 	                | Binding adapter             |
| ---            | ---                           | ---                         |
| AdapterView    | 	android:selectedItemPosition | AdapterViewBindingAdapter   |
|     ---        | 	 android:selection 	         | 	  ---                      |
| CalendarView 	 |   android:date 	              | CalendarViewBindingAdapter  | 
| CompoundButton |   android:checked            	| CompoundButtonBindingAdapter| 
| DatePicker     | 	 android:year                | DatePickerBindingAdapter   	| 
|      ---       | 	 android:month               | 	---                       	|
|     ---        |   android:day                 | 	---                        |


If you want to use two-way data binding with custom attributes, you need to work with the **@InverseBindingAdapter** and **@InverseBindingMethod** annotations.

For example, if you want to enable two-way data binding on a "time" attribute in a custom view called MyView, complete the following steps:

```
1. Annotate the method that sets the initial value and updates when the value changes using @BindingAdapter

@BindingAdapter("time")
public static void setTime(MyView view, Time newValue) {
    // Important to break potential infinite loops.
    if (view.time != newValue) {
        view.time = newValue;
    }
}

2. Annotate the method that reads the value from the view using @InverseBindingAdapter:

@InverseBindingAdapter("time")
public static Time getTime(MyView view) {
    return view.getTime();
}

```

# Difference 

| Values         	       | One Way	                      | Two way                     |
|         ---            |       ---                     |      ---                    |
| Communication         	| It’s named one-way databinding because there’s only one communication way: from observable to view               | There are two communication ways: from observable to view and viceversa              |
| Symbol                	| @{}                           |  @={}                       |






















