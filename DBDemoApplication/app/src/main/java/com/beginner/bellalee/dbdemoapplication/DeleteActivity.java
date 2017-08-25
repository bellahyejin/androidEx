package com.beginner.bellalee.dbdemoapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DeleteActivity extends AppCompatActivity {

    private static final String TAG = "DeleteActivity";

    private EditText mEditor;
    private Button mSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.component_delete);

        mEditor = (EditText) findViewById(R.id.editor);
        mSubmit = (Button) findViewById(R.id.btn_delete_submit);

        mSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

            }
        });
    }
}
