package sla.org.androidtopselling;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class MediaLists implements Model {
    private boolean displayingAlbums;
    private ArrayList<Media> albums;
    private ArrayList<Media> movies;
    private int currentAlbum;
    private int currentMovie;

    // Constructor
    MediaLists(Context context, boolean displayAlbums) {
        displayingAlbums = displayAlbums;
        currentAlbum = 0;
        currentMovie = 0;

        albums = new ArrayList();
        // Read album data from text file.
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open("AlbumData")));
            String nextLine;
            while ((nextLine = bufferedReader.readLine()) != null) {
                albums.add(new Album(nextLine));
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("MediaLists() reading AlbumData threw exception:");
            e.printStackTrace();
        }

        movies = new ArrayList();
        // Read movies data from text file.
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open("MoviesData")));
            String nextLine;
            while ((nextLine = bufferedReader.readLine()) != null) {
                movies.add(new Movie(nextLine));
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("MediaLists() reading MoviesData threw exception:");
            e.printStackTrace();
        }

    }

    // Interface methods
    public void next() {
        if (displayingAlbums) {
            // increment currentAlbum to point to next album
            if (currentAlbum < albums.size() - 1) {
                currentAlbum = currentAlbum + 1;
            } else {
                currentAlbum = 0;
            }
        } else {
            // increment currentMovie to point to next movie
            if (currentMovie < movies.size() - 1) {
                currentMovie = currentMovie + 1;
            } else {
                currentMovie = 0;
            }
        }
    }

    public void previous() {
        if (displayingAlbums) {
            // decrement currentAlbum to point to previous album
            if (currentAlbum > 0) {
                currentAlbum = currentAlbum - 1;
            } else {
                currentAlbum = albums.size() - 1;
            }
        } else {
            // decrement currentMovie to point to previous movie
            if (currentMovie > 0) {
                currentMovie = currentMovie - 1;
            } else {
                currentMovie = movies.size() - 1;
            }
        }
    }

    public String countText() {
        if (displayingAlbums) {
            return "Top Selling Album #" + (currentAlbum + 1) + " of " + albums.size();
        } else {
            return "Top Grossing Movie #" + (currentMovie + 1) + " of " + movies.size();
        }
    }

    public String titleText() {
        if (displayingAlbums) {
            return albums.get(currentAlbum).title();
        } else {
            return movies.get(currentMovie).title();
        }
    }

    public String descriptionText() {
        if (displayingAlbums) {
            return albums.get(currentAlbum).description();
        } else {
            return movies.get(currentMovie).description();
        }
    }

}
