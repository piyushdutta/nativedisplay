package com.pushnotification.nativedisplay;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.clevertap.android.sdk.CleverTapAPI;

import java.util.HashMap;

public class InputActivity extends AppCompatActivity
{
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        String title = "";
        String message= "";
        String unitId = "";
        String inputtitle1 = "";
        String inputtitle2 = "";
        String passvalue = "";

        if (extras != null) {
            title = extras.getString("title");
            message = extras.getString("message");
            unitId = extras.getString("unitId");
            inputtitle1 = extras.getString("inputtitle1");
            inputtitle2 = extras.getString("inputtitle2");
            passvalue = extras.getString("passvalue");

        }

        setContentView(R.layout.input_layout);

        TextView title_alert, message_alert, inputtitle_1, inputtitle_2;
        final EditText input_message_1, input_message_2;


        title_alert = findViewById(R.id.title);
        message_alert = findViewById(R.id.message);

        inputtitle_1 = findViewById(R.id.inputtitle1);
        inputtitle_2 = findViewById(R.id.inputtitle2);
        input_message_1 = findViewById(R.id.inputbox1);
        input_message_2 = findViewById(R.id.inputbox2);

        title_alert.setText(title);
        message_alert.setText(message);
        inputtitle_1.setText(inputtitle1);
        inputtitle_2.setText(inputtitle2);


        Button buttonOk=findViewById(R.id.submit);
        final String finalUnitId = unitId;
        final String finalPassvalue = passvalue;
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                CleverTapAPI.getDefaultInstance(InputActivity.this).pushDisplayUnitClickedEventForID(finalUnitId);

                if(finalPassvalue.contains("profile"))
                {
                    HashMap<String, Object> profileUpdate = new HashMap<>();
                    profileUpdate.put("input_message_1", input_message_1.getText().toString());
                    profileUpdate.put("input_message_2", input_message_2.getText().toString());
                    profileUpdate.put("Unit Id", finalUnitId);

                    CleverTapAPI.getDefaultInstance(getApplicationContext()).pushProfile(profileUpdate);

                }else {
                    HashMap<String, Object> prodViewedAction = new HashMap<>();
                    prodViewedAction.put("input_message_1", input_message_1.getText().toString());
                    prodViewedAction.put("input_message_2", input_message_2.getText().toString());
                    prodViewedAction.put("Unit Id", finalUnitId);

                    CleverTapAPI.getDefaultInstance(getApplicationContext()).pushEvent("Feedback Submited", prodViewedAction);

                }
                finish();
            }
        });

    }
}

