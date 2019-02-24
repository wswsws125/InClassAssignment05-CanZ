package com.example.wswsw.inclassassignment05_canz;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //onClick event of send email button
    public void sendEmail(View view) {
        //get message from 2 EditText views and a CheckBox
        EditText title = (EditText) findViewById(R.id.input_title_view);
        String title1 = title.getText().toString();

        EditText message = (EditText) findViewById(R.id.input_message_view);
        String message1 = message.getText().toString();

        CheckBox sendTitleCheckBox = (CheckBox) findViewById(R.id.only_send_title);
        boolean onlySendTitle = sendTitleCheckBox.isChecked();

        //Create an intent to open email
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, title1);
        if (onlySendTitle == false) {
            intent.putExtra(Intent.EXTRA_TEXT, message1);
        }
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);

            //add onClick listener for launchActivity Button
        Button launchActivity = (Button)findViewById(R.id.launch_activity);
            launchActivity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, InClassActivity.class);

             //get message from 2 EditText views
                    EditText title = (EditText) findViewById(R.id.input_title_view);
                    String title1 = title.getText().toString();

                    EditText message = (EditText) findViewById(R.id.input_message_view);
                    String message1 = message.getText().toString();


             // pass string to the second activity
                    intent.putExtra("TITLE_STRING", title1);
                    intent.putExtra("MESSAGE_STRING", message1);

                    startActivity(intent);
                }
            });

            //add onClick listener for launchCamera Button
            Button launchCamera = (Button)findViewById(R.id.launch_camera);
            launchCamera.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }

                }
            });

        }
    }
}