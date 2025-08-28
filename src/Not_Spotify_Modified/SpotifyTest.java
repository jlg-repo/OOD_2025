package Not_Spotify_Modified;
import java.util.ArrayList;
import java.util.List;

public class SpotifyTest {
    public static void main(String[] args) {
        System.out.println("Spotify Playlist System Test:");
        System.out.println("-----------------------------");

        // create user and music library
        User user = new User("TheLegend27");
        MusicLibrary library = new MusicLibrary();

        // create playlists
        PopPlaylist popPlaylist = (PopPlaylist) user.createPlaylist("Pop Vibes", "Pop");
        RockPlaylist rockPlaylist = (RockPlaylist) user.createPlaylist("Late 90s/Early 2000s Rock", "Rock");
        JazzPlaylist jazzPlaylist = (JazzPlaylist) user.createPlaylist("Bebop Jazz", "Jazz");

        System.out.println();

        // add songs from library to playlists
        user.addSongToPlaylist(popPlaylist, library.getAllSongs().get(0)); // Blinding Lights
        user.addSongToPlaylist(popPlaylist, library.getAllSongs().get(1)); // Lay All Your Love On Me
        user.addSongToPlaylist(rockPlaylist, library.getAllSongs().get(5)); // I Will Not Bow
        user.addSongToPlaylist(popPlaylist, library.getAllSongs().get(2)); // Bad Dreams
        user.addSongToPlaylist(jazzPlaylist, library.getAllSongs().get(10)); // Tank!
        user.addSongToPlaylist(jazzPlaylist, library.getAllSongs().get(11)); // Cat Blues
        user.addSongToPlaylist(rockPlaylist, library.getAllSongs().get(6)); // Still Waiting

        System.out.println();

        // display all playlists
        user.displayAllPlaylists();

        System.out.println();

        // Test genre recommendations (should exclude songs already in playlists)
        System.out.println("=== Genre Recommendations ===");
        List<Song> rockRecs = library.getRecommendations("Rock", user);
        library.displaySongs(rockRecs, "New Rock Recommendations");

        System.out.println();


        //debugging code to test it avoids songs already in playlists
        // System.out.println("=== All Rock Songs (for comparison) ===");
        //library.displaySongs(library.getSongsByGenre("Rock"), "All Rock Songs");

        //System.out.println();

        // Test mood filtering
        System.out.println("=== Happy Songs ===");
        library.displaySongs(library.getSongsByMood("happy"), "Happy Mood");

        System.out.println();

        // Test playing behavior
        popPlaylist.playAllSongs();
        System.out.println();

        rockPlaylist.playAllSongs();
        System.out.println();

        jazzPlaylist.playAllSongs();
        System.out.println();

        // Test specific methods
        popPlaylist.shuffle();
        rockPlaylist.playLouder();

        System.out.println("\nTest finished");
    }
}