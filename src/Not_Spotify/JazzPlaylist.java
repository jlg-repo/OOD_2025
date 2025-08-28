package Not_Spotify;

public class JazzPlaylist extends Playlist {
    public JazzPlaylist(String name) {
        super(name);
    }

    @Override
    public void playAllSongs() {
        System.out.println("Acquiring a taste for freeform jazz: " + name);
        super.playAllSongs();
    }

}
