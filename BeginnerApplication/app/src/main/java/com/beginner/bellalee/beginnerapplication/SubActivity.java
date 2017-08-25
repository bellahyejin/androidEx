package com.beginner.bellalee.beginnerapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class SubActivity extends AppCompatActivity {

    Button mBack;
    CheckBox mCheckBox;
    TextView mTextView;
    RadioGroup mGroup;
    Switch mSwitch;
    ToggleButton mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        mBack = (Button) findViewById(R.id.btn_back);
        mCheckBox = (CheckBox) findViewById(R.id.selector_check);
        mTextView = (TextView) findViewById(R.id.text_appname);
        mGroup = (RadioGroup) findViewById(R.id.radio_group);
        mSwitch = (Switch) findViewById(R.id.switcher);
        mToggle = (ToggleButton) findViewById(R.id.btn_toggle);

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SubActivity.this, "Back page", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mBack.setEnabled(b);
            }
        });

        mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                String text = null;
                if (i == R.id.first_radio) {
                    text = getResources().getString(R.string.man);

                } else if (i == R.id.second_radio) {
                    text = getResources().getString(R.string.woman);
                }
                mTextView.setText(text);
            }
        });

        mSwitch.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    mTextView.setVisibility(View.VISIBLE);
                } else {
                    mTextView.setVisibility(View.INVISIBLE);
                }
            }
        });

        mToggle.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    mTextView.setTextColor(Color.BLUE);
                } else {
                    mTextView.setTextColor(Color.RED);
                }
            }
        });
    }
}
