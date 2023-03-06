package com.westerneagles.faros.Activities.LoginAndRegister;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.westerneagles.faros.Activities.ForgotPasswordActivities.ResetPassword;
import com.westerneagles.faros.Core.CommonActivityStyle;
import com.westerneagles.faros.databinding.ActivityLogInBinding;

public class LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.westerneagles.faros.databinding.ActivityLogInBinding binding = ActivityLogInBinding.inflate(getLayoutInflater());
        View view= binding.getRoot();
        setContentView(view);
        CommonActivityStyle.make(this);

        binding.backLogoResetPass.setOnClickListener(view1 -> {
            finish();
            Animatoo.INSTANCE.animateSlideRight(LogIn.this);
        });
        binding.forgotPassword.setOnClickListener(view1 -> {
            startActivity(new Intent(this, ResetPassword.class));
            Animatoo.INSTANCE.animateSlideLeft(LogIn.this);
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        Animatoo.INSTANCE.animateSlideRight(LogIn.this);
    }
}