package com.pushnotification.nativedisplay;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.clevertap.android.sdk.CleverTapAPI;

import java.util.HashMap;

public class RatingActivity extends AppCompatActivity
{
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
         String title = "";
         String message= "";
         String unitId = "";
        if (extras != null) {
            title = extras.getString("title");
            message = extras.getString("message");
            unitId = extras.getString("unitId");

        }

        setContentView(R.layout.rating_layout);

        TextView title_alert, message_alert;
        final EditText comment;
        final RatingBar rating;

        title_alert = findViewById(R.id.title);
        message_alert = findViewById(R.id.message);
        comment = findViewById(R.id.comments);
         rating = findViewById(R.id.ratingBar);

        title_alert.setText(title);
        message_alert.setText(message);

        Button buttonOk=findViewById(R.id.submit);
        final String finalUnitId = unitId;
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                CleverTapAPI.getDefaultInstance(RatingActivity.this).pushDisplayUnitClickedEventForID(finalUnitId);

                HashMap<String, Object> prodViewedAction = new HashMap<String, Object>();
                prodViewedAction.put("Rating", rating.getRating());
                prodViewedAction.put("Comment", comment.getText().toString());
                prodViewedAction.put("Unit Id", finalUnitId);

                CleverTapAPI.getDefaultInstance(getApplicationContext()).pushEvent("Feedback Submited", prodViewedAction);

                finish();
                //alertDialog.dismiss();
            }
        });
        //alertDialog.show();

    }
}
