package com.databinding.model;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

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

    @Bindable({"email"})
    public String getEmailError() {
        if (getEmail().isEmpty()) {
            return "Email is empty";
        }
        return "";
    }

    @Bindable
    public String getPassword() {
        if (password == null) {
            return "";
        }
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    @Bindable({"password"})
    public String getPasswordError() {
        if (getPassword().isEmpty()) {
            return "Password is empty";
        } else {
            return "";
        }
    }
}