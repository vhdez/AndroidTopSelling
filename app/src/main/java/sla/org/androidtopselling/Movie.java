package sla.org.androidtopselling;

class Movie implements Media {
    private int ranking;
    private int peakRanking;
    private String title;
    private String worldwideGross;
    private int year;

    // Constructor
    Movie(String movieData) {
        // Split up albumData into 7 parts as separated by tab characters (\t) or tab
        String[] parts = movieData.split("\\t+", 6);
        ranking = Integer.parseInt(parts[0]);
        peakRanking = Integer.parseInt(parts[1]);
        title = parts[2];
        worldwideGross = parts[3];
        year = Integer.parseInt(parts[4]);
    }

    // Methods
    public String title() {
        return title;
    }

    public String description() {
        return "Year: " + year + "\nPeak Ranking: " + peakRanking + "\nWorldwide gross: " + worldwideGross;
    }
}
