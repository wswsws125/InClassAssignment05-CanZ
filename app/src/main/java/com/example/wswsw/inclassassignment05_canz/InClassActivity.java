package com.example.wswsw.inclassassignment05_canz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class InClassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_class);

        Intent intent1 = getIntent();
        String title1 = intent1.getStringExtra("TITLE_STRING");
        String message1 = intent1.getStringExtra("MESSAGE_STRING");


        setTitle(title1);

        TextView textView1 = (TextView)findViewById(R.id.message_view2);
        textView1.setText(message1);
    }


}
