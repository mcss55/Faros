package com.westerneagles.faros.Activities.ForgotPasswordActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.westerneagles.faros.Core.CommonActivityStyle;
import com.westerneagles.faros.R;
import com.westerneagles.faros.databinding.ActivitySuccessResetPassBinding;

public class SuccessResetPass extends AppCompatActivity {
    ActivitySuccessResetPassBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view=binding.getRoot();
        setContentView(view);
        CommonActivityStyle.make(this);

        binding.registerButton2.setOnClickListener(view1 -> {
            Toast.makeText(this, "SUCCESS", Toast.LENGTH_SHORT).show();
        });

    }
}