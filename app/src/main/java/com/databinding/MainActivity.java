package com.databinding;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.databinding.databinding.ActivityMainBinding;
import com.databinding.listener.OnClickListener;
import com.databinding.model.UserData;

public class MainActivity extends AppCompatActivity implements OnClickListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding activityMainBinding
                = DataBindingUtil.setContentView(this, R.layout.activity_main);

        UserData userData = new UserData(this);
        userData.setEmail("");
        userData.setPassword("");
        activityMainBinding.setUserdata(userData);
        activityMainBinding.setOnclicklistener(this);
    }

    @Override
    public void onButtonClick(UserData userData) {
        if (!userData.getEmail().isEmpty() && !userData.getPassword().isEmpty()) {

            Toast.makeText(MainActivity.this,
                    "You enter user name : " + userData.getEmail()
                            + "  and password: " + userData.getPassword(),
                    Toast.LENGTH_SHORT).show();
        }
    }
}
