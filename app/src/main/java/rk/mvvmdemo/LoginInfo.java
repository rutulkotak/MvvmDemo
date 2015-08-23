package rk.mvvmdemo;

import android.content.res.Resources;
import android.util.Patterns;

import rk.mvvmdemo.utils.BindableBoolean;
import rk.mvvmdemo.utils.BindableString;

/**
 * Rutul Kotak
 */
public class LoginInfo {
    // Email
    public BindableString email = new BindableString();
    public BindableString emailError = new BindableString();
    // Password
    public BindableString password = new BindableString();
    public BindableString passwordError = new BindableString();
    // New user or current
    public BindableBoolean existingUser = new BindableBoolean();
    public boolean loginExecuted;

    public void reset() {
        email.set(null);
        password.set(null);
        emailError.set(null);
        passwordError.set(null);
        loginExecuted = false;
    }

    public boolean validate(Resources res) {
        if (!loginExecuted) {
            return true;
        }
        int emailErrorRes = 0;
        int passwordErrorRes = 0;
        if (email.get().isEmpty()) {
            emailErrorRes = R.string.mandatory_field;
        } else {
            if (!Patterns.EMAIL_ADDRESS.matcher(email.get()).matches()) {
                emailErrorRes = R.string.invalid_email;
            }
        }
        if (existingUser.get() && password.get().isEmpty()) {
            passwordErrorRes = R.string.mandatory_field;
        }
        emailError.set(emailErrorRes != 0 ? res.getString(emailErrorRes) : null);
        passwordError.set(passwordErrorRes != 0 ? res.getString(passwordErrorRes) : null);
        return emailErrorRes == 0 && passwordErrorRes == 0;
    }
}