package com.westerneagles.faros.Activities.LoginAndRegister;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.westerneagles.faros.Activities.Core.EmailVefrification;
import com.westerneagles.faros.Core.CommonActivityStyle;
import com.westerneagles.faros.databinding.ActivityRegistrationBinding;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.westerneagles.faros.databinding.ActivityRegistrationBinding binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        View view= binding.getRoot();
        setContentView(view);
        CommonActivityStyle.make(this);

        binding.backLogo.setOnClickListener(view1 -> {
            finish();
            Animatoo.INSTANCE.animateSlideRight(Registration.this);
        });

        binding.registerButton.setOnClickListener(view1 -> {
            startActivity(new Intent(Registration.this, EmailVefrification.class));
            Animatoo.INSTANCE.animateSlideLeft(Registration.this);
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        Animatoo.INSTANCE.animateSlideRight(Registration.this);
    }
}