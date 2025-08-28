package Not_Spotify;

public class PopPlaylist extends Playlist{
    public PopPlaylist(String name) {
        super(name);
    }

    @Override
    public void playAllSongs(){
        System.out.println("Playing Pop playlist: " + name);
        super.playAllSongs();
    }

    public void shuffle() {
        System.out.println("Shuffling Pop playlist for random vibes: " + name);

    }
}
