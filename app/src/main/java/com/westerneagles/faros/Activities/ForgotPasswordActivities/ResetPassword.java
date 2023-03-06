package com.westerneagles.faros.Activities.ForgotPasswordActivities;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.westerneagles.faros.Activities.Core.EmailVefrification;
import com.westerneagles.faros.Core.CommonActivityStyle;
import com.westerneagles.faros.R;
import com.westerneagles.faros.databinding.ActivityResetPasswordBinding;

public class ResetPassword extends AppCompatActivity {

    ActivityResetPasswordBinding binding;
    boolean eyeClosed = true;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = com.westerneagles.faros.databinding.ActivityResetPasswordBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        CommonActivityStyle.make(this);
        binding.editTextNewPass.setOnTouchListener((v, event) -> {
            final int DRAWABLE_RIGHT = 2;

            if(event.getAction() == MotionEvent.ACTION_UP) {
                if(event.getRawX() >= (binding.editTextNewPass.getRight() - binding.editTextNewPass.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                    if (eyeClosed) {
                        binding.editTextNewPass.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                        binding.editTextNewPass.setSelection(binding.editTextNewPass.length());
                        eyeClosed = false;
                    } else {
                        binding.editTextNewPass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        eyeClosed = true;
                        binding.editTextNewPass.setSelection(binding.editTextNewPass.length());
                    }
                    return true;
                }
            }
            return false;
        });

        binding.editTextRePass.setOnTouchListener((v, event) -> {

            if(event.getAction() == MotionEvent.ACTION_UP) {
                if(event.getRawX() >= (binding.editTextRePass.getRight() - binding.editTextRePass.getCompoundDrawables()[2].getBounds().width())) {
                    if (eyeClosed) {
                        binding.editTextRePass.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
                        binding.editTextRePass.setSelection(binding.editTextRePass.length());
                        eyeClosed = false;
                    } else {
                        binding.editTextRePass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        eyeClosed = true;
                        binding.editTextRePass.setSelection(binding.editTextRePass.length());
                    }
                    return true;
                }
            }
            return false;
        });

        binding.backLogoResetPass.setOnClickListener(view1 -> {
            finish();
            Animatoo.INSTANCE.animateSlideRight(ResetPassword.this);
        });


    }

    @Override
    public void onBackPressed() {
        finish();
        Animatoo.INSTANCE.animateSlideRight(ResetPassword.this);
    }
}