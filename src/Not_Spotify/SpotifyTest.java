package Not_Spotify;

public class SpotifyTest {
    public static void main(String[] args) {
        System.out.println("Spotify Playlist System Test:");
        System.out.println("-----------------------------");

        // Create a user
        User user = new User("TheLegend27");

        // Creating songs

        Song song1 = new Song("Blinding Lights", "The Weeknd", 3.22);
        Song song2 = new Song("Lay All Your Love On Me", "Abba", 4.35);
        Song song3 = new Song("I Will Not Bow", "Breaking Benjamin", 3.37);
        Song song4 = new Song("Bad Dreams", "Teddy Swims", 3.05);
        Song song5 = new Song("Tank!", "SEAT BELTS", 3.30);
        Song song6 = new Song("Cat Blues", "SEAT BELTS", 2.37);
        Song song7 = new Song("Still Waiting", "Sum 41", 2.40);

        // Making playlists
        Playlist popPlaylist = user.createPlaylist("Pop Vibes", "Pop");
        Playlist rockPlaylist = user.createPlaylist("Late 90s/Early 2000s Rock", "Rock");
        Playlist jazzPlaylist = user.createPlaylist("Bebop Jazz", "Jazz");

        System.out.println();

        // Add songs to the playlists
        user.addSongToPlaylist(popPlaylist, song1);
        user.addSongToPlaylist(popPlaylist, song2);
        user.addSongToPlaylist(rockPlaylist, song3);
        user.addSongToPlaylist(popPlaylist, song4);
        user.addSongToPlaylist(jazzPlaylist, song5);
        user.addSongToPlaylist(jazzPlaylist, song6);
        user.addSongToPlaylist(rockPlaylist, song7);

        System.out.println();

        // Display the playlists
        user.displayAllPlaylists();

        System.out.println();

        // Test playing behavior
        popPlaylist.playAllSongs();
        System.out.println();

        rockPlaylist.playAllSongs();
        System.out.println();

        jazzPlaylist.playAllSongs();
        System.out.println();

        //methods testing
        PopPlaylist myPopPlaylist = (PopPlaylist) popPlaylist; // type cast the new popPlaylist as a PopPlaylist
        myPopPlaylist.shuffle(); // now we can use the custom shuffle method


    }
}
