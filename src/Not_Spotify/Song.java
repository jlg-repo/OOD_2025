package Not_Spotify;

public class Song {
    String title;
    String artist;
    double duration; //in minutes

    public Song(String title, String artist, double duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
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

    public void displaySongInfo(){
        System.out.println("Title: " + title + " Artist: " + artist + " Duration: " + duration + " minutes");
    }
}
