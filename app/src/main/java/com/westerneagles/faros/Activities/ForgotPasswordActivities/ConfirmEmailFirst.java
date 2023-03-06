package com.westerneagles.faros.Activities.ForgotPasswordActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.westerneagles.faros.R;

public class ConfirmEmailFirst extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_email_first);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        Window window=this.getWindow();
        window.setStatusBarColor(Color.WHITE);

        View decor = getWindow().getDecorView();
        decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        TextView backLogo=findViewById(R.id.backLogoConfirmEmailFirst);
        backLogo.setOnClickListener(view1 -> {
            finish();
            Animatoo.INSTANCE.animateSlideRight(ConfirmEmailFirst.this);

        });


    }
}