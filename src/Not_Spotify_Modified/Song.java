package Not_Spotify_Modified;

public class Song {
    String title;
    String artist;
    double duration; // in minutes
    String genre;
    String mood;

    public Song(String title, String artist, double duration, String genre, String mood) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.genre = genre;
        this.mood = mood;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public double getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }

    public String getMood() {
        return mood;
    }

    public void displaySongInfo() {
        System.out.println("Title: " + title + " Artist: " + artist + " Duration: " + duration + " minutes Genre: " + genre + " Mood: " + mood);
    }
}