package sla.org.androidtopselling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MediaListsActivity extends AppCompatActivity {
    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_lists);

        Button prevButton = findViewById(R.id.prevButton);
        TextView countText = findViewById(R.id.countText);
        Button nextButton = findViewById(R.id.nextButton);
        TextView titleText = findViewById(R.id.titleText);
        TextView descriptionText = findViewById(R.id.descriptionText);

        Intent intent = getIntent();
        String message = intent.getStringExtra(Controller.MEDIA_TYPE);

        controller = new Controller(prevButton, countText, nextButton, titleText, descriptionText, getApplicationContext(), message);
    }
}
