package com.westerneagles.faros.Activities.Core;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.westerneagles.faros.Core.CommonActivityStyle;
import com.westerneagles.faros.R;
import com.westerneagles.faros.databinding.ActivityEmailVefrificationBinding;

import java.util.Locale;

public class EmailVefrification extends AppCompatActivity {
    com.westerneagles.faros.databinding.ActivityEmailVefrificationBinding binding;

    boolean clicked=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEmailVefrificationBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        CommonActivityStyle.make(this);


        binding.editTextNumberSigned.addTextChangedListener(new GenericTextWatcher(binding.editTextNumberSigned, binding.editTextNumberSigned2, this));
        binding.editTextNumberSigned2.addTextChangedListener(new GenericTextWatcher(binding.editTextNumberSigned2, binding.editTextNumberSigned3, this));
        binding.editTextNumberSigned3.addTextChangedListener(new GenericTextWatcher(binding.editTextNumberSigned3, binding.editTextNumberSigned4, this));
        binding.editTextNumberSigned4.addTextChangedListener(new GenericTextWatcher(binding.editTextNumberSigned4, null, this));

        binding.editTextNumberSigned.setOnKeyListener(new GenericKeyEvent(binding.editTextNumberSigned, null));
        binding.editTextNumberSigned2.setOnKeyListener(new GenericKeyEvent(binding.editTextNumberSigned2, binding.editTextNumberSigned));
        binding.editTextNumberSigned3.setOnKeyListener(new GenericKeyEvent(binding.editTextNumberSigned3, binding.editTextNumberSigned2));
        binding.editTextNumberSigned4.setOnKeyListener(new GenericKeyEvent(binding.editTextNumberSigned4, binding.editTextNumberSigned3));

        binding.backLogoEmailVerification.setOnClickListener(view1 -> {
            finish();
            Animatoo.INSTANCE.animateSlideRight(EmailVefrification.this);
        });
        binding.resendCode.setOnClickListener(view1 -> {
            if (!clicked){
                binding.timerText.setVisibility(View.VISIBLE);
                binding.resendCode.setTextColor(ResourcesCompat.getColor(getResources(), android.R.color.darker_gray,null));
                binding.resendCode.setEnabled(false);
                clicked=true;
                new CountDownTimer(60000,1000){
                    @Override
                    public void onTick(long l) {
                            binding.timerText.setText(String.format(Locale.getDefault(),"%02d:%02d",(int) (l /1000)/60,(int) (l /1000) % 60));
                    }
                    @Override
                    public void onFinish() {
                        binding.resendCode.setTextColor(ResourcesCompat.getColor(getResources(), R.color.purple_200,null));
                        binding.resendCode.setEnabled(true);
                        binding.timerText.setVisibility(View.INVISIBLE);
                        clicked=false;
                    }
                }.start();

            }
        });

    }

    @Override
    public void onBackPressed() {
        finish();
        Animatoo.INSTANCE.animateSlideRight(EmailVefrification.this);
    }


    static class GenericTextWatcher implements TextWatcher {
        private final View currentView;
        private final View nextView;
        private final Activity activity;

        public GenericTextWatcher(View currentView, View nextView, Activity activity) {
            this.currentView = currentView;
            this.nextView = nextView;
            this.activity = activity;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            Log.d(TAG, "CHAR: "+charSequence.toString().length());
            if (charSequence.toString().length()==0){
                currentView.setBackground(ResourcesCompat.getDrawable(activity.getResources(),R.drawable.otpsquare,null));
            }else{
                currentView.setBackground(ResourcesCompat.getDrawable(activity.getResources(),R.drawable.optsquarefocused,null));
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {
            String text = editable.toString();
            switch (currentView.getId()) {
                case R.id.editTextNumberSigned:
                    if (text.length() == 1) nextView.requestFocus();
                    break;
                case R.id.editTextNumberSigned2:
                    if (text.length() == 1) nextView.requestFocus();
                    break;
                case R.id.editTextNumberSigned3:
                    if (text.length() == 1) nextView.requestFocus();
                    break;
                case R.id.editTextNumberSigned4:
                    if (text.length() == 1) closeKeyBoard(activity);
                    break;
            }
        }

        void closeKeyBoard(Activity activity) {
            InputMethodManager inputManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }


    static class GenericKeyEvent implements View.OnKeyListener {

        private final EditText currentView;
        private final EditText previousView;

        public GenericKeyEvent(EditText currentView, EditText previousView) {
            this.currentView = currentView;
            this.previousView = previousView;
        }

        @Override
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (keyEvent.getAction() == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_DEL && currentView.getId() != R.id.editTextNumberSigned && currentView.getText().toString().isEmpty()) {
                previousView.setText(null);
                previousView.requestFocus();
                return true;
            }
            return false;
        }
    }



}