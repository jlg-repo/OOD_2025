package Not_Spotify;

public class RockPlaylist extends Playlist {
    public RockPlaylist(String name) {
        super(name);

    }

    @Override
    //for custom version just for the rock playlist, also did this for Pop and Jazz
    public void playAllSongs(){
        System.out.println("Rock Playlist: " + name + "!");
        super.playAllSongs();
    }

    public void playLouder() {
        System.out.println("This one goes to 11 - MAXIMUM VOLUME ROCK: " + name + "!");
    }

}
