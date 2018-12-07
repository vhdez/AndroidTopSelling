package sla.org.androidtopselling;

class Album implements Media {
    private String artist;
    private String album;
    private int year;
    private String genre;
    private float copies;
    private int sales;

    // Constructor
    Album(String albumData) {
        // Split up albumData into 7 parts as separated by tab characters (\t) or tab
        String[] parts = albumData.split("\\t+", 6);
        artist = parts[0];
        album = parts[1];
        year = Integer.parseInt(parts[2]);
        genre = parts[3];
        sales = Integer.parseInt(parts[4]);
    }

    // Methods
    public String title() {
        return artist + " - " + album;
    }

    public String description() {
        return "Year: " + year + "\nGenre: " + genre + "\nClaimed sales: " + sales + " million";
    }
}
