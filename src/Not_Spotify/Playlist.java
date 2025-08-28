package Not_Spotify;
import java.util.ArrayList;
import java.util.List;

public class Playlist {
    String name;
    List<Song> songs;

    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();

    }

    public void addSong(Song song) {
        songs.add(song);
        System.out.println("Added: " + song.getTitle() + " to " + name);

    }

    public void removeSong(Song song) {
        if (songs.remove(song)){
            System.out.println("Removed: " + song.getTitle() + " from " + name);
        } else {
            System.out.println("Song not found in " + name);
        }
    }

    public void playAllSongs() {
        System.out.println("Playing all " + songs.size() + " songs in " + name + ":");
        if (songs.isEmpty()) {
            System.out.println("No songs found in " + name + " playlist");
            return;
        }

        for (Song song : songs) {
            System.out.println("Now playing: " + song.getTitle() + " by " + song.getArtist());

        }
    }

    public String getName(){
        return name;
    }
    public List<Song> getSongs(){
        return songs;
    }

    public void displayPlaylistInfo() {
        System.out.println("Playlist: " + name + " (" + songs.size() + " songs)");
        for (Song song : songs) {
            song.displaySongInfo();
        }
    }
}
