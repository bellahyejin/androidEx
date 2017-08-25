package com.beginner.bellalee.dbdemoapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Button mInsert;
    private Button mDelete;
    private Button mUpdate;
    private Button mSearch;
    private TextView mResult;
    private CheckBox mAllDelete;
    private CheckBox mAllSearch;
    private LinearLayout mDeleteLayout;
    private LinearLayout mSearchLayout;
    private LinearLayout mSearchContentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInsert = (Button) findViewById(R.id.btn_insert);
        mUpdate = (Button) findViewById(R.id.btn_update);
        mDelete = (Button) findViewById(R.id.btn_delete);
        mSearch = (Button) findViewById(R.id.btn_search);
//        mResult = (TextView) findViewById(R.id.text_result);
        mAllDelete = (CheckBox) findViewById(R.id.chb_delete);
        mAllSearch = (CheckBox) findViewById(R.id.chb_search);
        mDeleteLayout = (LinearLayout) findViewById(R.id.grp_delete);
        mSearchLayout = (LinearLayout) findViewById(R.id.grp_search);


        mInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent insertIntent = new Intent(MainActivity.this, InsertActivity.class);
                startActivity(insertIntent);
            }
        });

        mUpdate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent updateIntent = new Intent(MainActivity.this, UpdateActivity.class);
                startActivity(updateIntent);
            }
        });

        mDelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(mAllDelete.isChecked()) {
//                    Log.d(TAG, String.valueOf(mDeleteLayout.get));
                    if(mDeleteLayout.getChildCount() > 0) {
//                        mDeleteLayout.removeView();
                    }
                    Toast.makeText(MainActivity.this, R.string.success_all_delete, Toast.LENGTH_SHORT).show();
                }
                else {
                    View mView = (View) getLayoutInflater().inflate(R.layout.component_delete, null);
                    mDeleteLayout.addView(mView);
                }
            }
        });

        mSearch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(mAllSearch.isChecked()) {

                }
                else {
                    View mView = getLayoutInflater().inflate(R.layout.component_search, null);
                    mSearchLayout.addView(mView);

                    mSearchContentLayout = (LinearLayout) findViewById(R.id.related_content);
                    setRadioEvent();
                }
            }
        });

    }

    private void setRadioEvent(){
        RadioGroup mRadio = (RadioGroup) findViewById(R.id.search_content);

        mRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i) {
                    case R.id.rd_name: addEditor(getResources().getString(R.string.user_name));break;
                    case R.id.rd_major: addEditor(getResources().getString(R.string.user_major)); break;
                    case R.id.rd_age: addSelectNumber(getResources().getString(R.string.user_age)); break;
                    case R.id.rd_sex: addCheckbox(getResources().getString(R.string.user_sex));break;
                }
            }
        });
    }

    private void addEditor(String label){
//        Log.d(TAG, label);
        if (mSearchContentLayout.getChildCount() > 0) {
            mSearchContentLayout.removeAllViewsInLayout();
        }

        TextView mTextView = new TextView(this);
        EditText mEditor = new EditText(this);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(20, 10, 0, 20);

        mTextView.setText(label);
        mTextView.setTextSize(17);
        mSearchContentLayout.addView(mTextView);

        mEditor.setHint(R.string.search_hint);
        mEditor.setPadding(30, 0, 30, 30);
        mEditor.setLayoutParams(params);
        mSearchContentLayout.addView(mEditor);
    }

    private void addSelectNumber(String label) {
        Log.d(TAG, label);
        if (mSearchContentLayout.getChildCount() > 0) {
            mSearchContentLayout.removeAllViewsInLayout();
        }

        NumberPicker mNumberPicker = new NumberPicker(this);
        mNumberPicker.setMinValue(1);
        mNumberPicker.setMaxValue(99);
        mNumberPicker.setHorizontalGravity(View.TEXT_ALIGNMENT_CENTER);

        mSearchContentLayout.addView(mNumberPicker);
    }

    private void addCheckbox(String label) {
        Log.d(TAG, label);
        String[] titles = {
                getResources().getString(R.string.male),
                getResources().getString(R.string.female)
        };

        if (mSearchContentLayout.getChildCount() > 0) {
            mSearchContentLayout.removeAllViewsInLayout();
        }

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0,0,30,0);

        TextView mTextView = new TextView(this);
        mTextView.setText(label);
        mTextView.setTextSize(17);
        mTextView.setLayoutParams(params);
        mSearchContentLayout.addView(mTextView);

        for (int i = 0 ; i < titles.length; i++){
            CheckBox mCheckBox = new CheckBox(this);
            mCheckBox.setText(titles[i]);
            mCheckBox.setId(i);
            mSearchContentLayout.addView(mCheckBox);
        }
    }
}
