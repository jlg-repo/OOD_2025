package Not_Spotify_Modified;

import java.util.List;

public interface PlaylistInterface {
    void addSong(Song song);
    void removeSong(Song song);
    void playAllSongs();
    String getName();
    List<Song> getSongs();
    void displayPlaylistInfo();
}