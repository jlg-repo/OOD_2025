package Not_Spotify_Modified;

public class RockPlaylist extends Playlist {
    public RockPlaylist(String name) {
        super(name);
    }

    @Override
    public void playAllSongs() {
        System.out.println("Rock Playlist: " + name + "!");
        super.playAllSongs();
    }

    public void playLouder() {
        System.out.println("This one goes to 11 - MAXIMUM VOLUME ROCK: " + name + "!");
    }
}