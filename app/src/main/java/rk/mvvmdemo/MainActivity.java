package rk.mvvmdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;

import rk.mvvmdemo.utils.TextWatcherAdapter;
import rk.mvvmdemo.databinding.ActivityMainBinding;

/**
 * ViewModel – The object that ties Model and View together
 * Model – Represents your business logic
 * View – Displayed content
 * Rutul Kotak
 */
public class MainActivity extends AppCompatActivity {

    private LoginInfo loginInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // The binding object is a completly automatically generated object which enables the view acces to the data model
        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        loginInfo = new LoginInfo();
        binding.setLoginInfo(loginInfo);

        // Text Watcher to validate inputs
        TextWatcherAdapter watcher = new TextWatcherAdapter() {
            @Override public void afterTextChanged(Editable s) {
                loginInfo.validate(getResources());
            }
        };

        // Add listener for fields
        binding.email.addTextChangedListener(watcher);
        binding.password.addTextChangedListener(watcher);

        // If validation pass then show Snackbar with Email and Password
        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                loginInfo.loginExecuted = true;
                if (loginInfo.validate(getResources())) {
                    Snackbar.make(binding.getRoot(), loginInfo.email.get() + " - " +
                            loginInfo.password.get(), Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }
}