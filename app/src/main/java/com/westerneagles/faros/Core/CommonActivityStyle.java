package com.westerneagles.faros.Core;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

public final class CommonActivityStyle {
    public static void make(AppCompatActivity activity){

        if (activity.getSupportActionBar() != null) {
            activity.getSupportActionBar().hide();
        }

        Window window = activity.getWindow();
        window.setStatusBarColor(Color.WHITE);

        View decor = activity.getWindow().getDecorView();
        decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }
}
