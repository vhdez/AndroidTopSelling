package sla.org.androidtopselling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MediaChooserActivity extends AppCompatActivity {
    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_chooser);

        Button albumsButton = findViewById(R.id.albumsButton);
        Button moviesButton = findViewById(R.id.moviesButton);

        controller = new Controller(albumsButton, moviesButton, this);
    }
}
