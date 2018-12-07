package sla.org.androidtopselling;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Controller {
    public static final String MEDIA_TYPE = "sla.org.androidtopselling.MediaType";

    // UI Controls from MediaChooserActivity
    private Button albumsButton;
    private Button moviesButton;
    private MediaChooserActivity activity;

    // UI Controls from MediaListsActivity
    private Button prevButton;
    private TextView countText;
    private Button nextButton;
    private TextView titleText;
    private TextView descriptionText;

    private Model topSellingMedia;

    Controller(Button a, Button m, MediaChooserActivity mca) {
        albumsButton = a;
        moviesButton = m;
        activity = mca;

        albumsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pressedMedia("albums");
            }
        });

        moviesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pressedMedia("movies");
            }
        });

    }

    Controller(Button p, TextView c, Button n, TextView tt, TextView dt, Context ctxt, String message) {
        prevButton = p;
        countText = c;
        nextButton = n;
        titleText = tt;
        descriptionText = dt;

        if (message.equals("albums")) {
            topSellingMedia = new MediaLists(ctxt, true);
        } else if (message.equals("movies")) {
            topSellingMedia = new MediaLists(ctxt, false);
        }
        updateText();

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previous();
                updateText();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
                updateText();
            }
        });
    }

    private void pressedMedia(String mediaType) {
        Intent intent = new Intent(activity, MediaListsActivity.class);
        intent.putExtra(MEDIA_TYPE, mediaType);
        activity.startActivity(intent);
    }

    private void updateText() {
        countText.setText(topSellingMedia.countText());
        titleText.setText(topSellingMedia.titleText());
        descriptionText.setText(topSellingMedia.descriptionText());
    }

    private void previous() {
        topSellingMedia.previous();
    }

    private void next() {
        topSellingMedia.next();
    }
}
