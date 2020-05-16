package com.pushnotification.nativedisplay;

import android.app.AlertDialog;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
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
//        Rect displayRectangle = new Rect();
//        Window window = RatingActivity.this.getWindow();
//        window.getDecorView().getWindowVisibleDisplayFrame(displayRectangle);
//        final AlertDialog.Builder builder = new AlertDialog.Builder(RatingActivity.this,R.style.CustomAlertDialog);
//        ViewGroup viewGroup = findViewById(android.R.id.content);
//        View dialogView = LayoutInflater.from(RatingActivity.this).inflate(R.layout.rating_layout, viewGroup, false);
//        dialogView.setMinimumWidth((int)(displayRectangle.width() * 1f));
//        dialogView.setMinimumHeight((int)(displayRectangle.height() * 1f));
//        builder.setView(dialogView);
//        final AlertDialog alertDialog = builder.create();


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
