package com.beginner.bellalee.beginnerapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//    TextView mTextView;
//    EditText mEditText;
//    Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mTextView = (TextView) findViewById(R.id.text);
//        mEditText = (EditText) findViewById(R.id.editText);
//        mBtn = (Button) findViewById(R.id.btn_enter);
//
//        mBtn.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view) {
//                mTextView.setText(mEditText.getText().toString());
//            }
//        });

        Button mToast = (Button) findViewById(R.id.toast);
        Button mGoogle = (Button) findViewById(R.id.google);
        Button mCall = (Button) findViewById(R.id.call);

        mToast.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Start buttion",Toast.LENGTH_SHORT).show();

                Intent myIntent = new Intent(MainActivity.this, SubActivity.class);
                startActivity(myIntent);
            }
        });

        mGoogle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, WebDemoActivity.class);
                startActivity(myIntent);
            }
        });

        mCall.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-6489-4102"));
                startActivity(myIntent);
            }
        });
    }
}
