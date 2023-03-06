package com.westerneagles.faros.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.westerneagles.faros.Activities.LoginAndRegister.LogIn;
import com.westerneagles.faros.Activities.LoginAndRegister.Registration;
import com.westerneagles.faros.Core.CommonActivityStyle;
import com.westerneagles.faros.R;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        CommonActivityStyle.make(this);

        TextView button = findViewById(R.id.textViewAsButton);
        button.setOnClickListener(view -> {
            startActivity(new Intent(WelcomeScreen.this, Registration.class));
            Animatoo.INSTANCE.animateSlideLeft(WelcomeScreen.this);
        });


        TextView registerText = findViewById(R.id.qeydiyyatText);
        registerText.setOnClickListener(view -> {
            startActivity(new Intent(WelcomeScreen.this, Registration.class));
            Animatoo.INSTANCE.animateSlideLeft(WelcomeScreen.this);
        });

        Button loginButton = findViewById(R.id.log_in);
        loginButton.setOnClickListener(view -> {
            startActivity(new Intent(WelcomeScreen.this, LogIn.class));
            Animatoo.INSTANCE.animateSlideLeft(WelcomeScreen.this);
        });

    }
}