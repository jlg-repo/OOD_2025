package Not_Spotify_Modified;

import java.util.ArrayList;
import java.util.List;

public class MusicLibrary {
    private final List<Song> allSongs;

    public MusicLibrary() {
        allSongs = new ArrayList<>();
        initializeSongs();
    }

    private void initializeSongs() {
        // Pop songs (5 total)
        allSongs.add(new Song("Blinding Lights", "The Weeknd", 3.22, "Pop", "happy"));
        allSongs.add(new Song("Lay All Your Love On Me", "ABBA", 4.35, "Pop", "happy"));
        allSongs.add(new Song("Bad Dreams", "Teddy Swims", 3.05, "Pop", "sad"));
        allSongs.add(new Song("As It Was", "Harry Styles", 2.47, "Pop", "idk"));
        allSongs.add(new Song("Anti-Hero", "Taylor Swift", 3.20, "Pop", "idk"));

        // Rock songs (5 total)
        allSongs.add(new Song("I Will Not Bow", "Breaking Benjamin", 3.37, "Rock", "idk"));
        allSongs.add(new Song("Still Waiting", "Sum 41", 2.40, "Rock", "happy"));
        allSongs.add(new Song("Bring Me to Life", "Evanescence", 3.57, "Rock", "idk"));
        allSongs.add(new Song("Numb", "Linkin Park", 3.07, "Rock", "sad"));
        allSongs.add(new Song("Mr. Brightside", "The Killers", 3.42, "Rock", "happy"));

        // Jazz songs (5 total)
        allSongs.add(new Song("Tank!", "SEAT BELTS", 3.30, "Jazz", "happy"));
        allSongs.add(new Song("Cat Blues", "SEAT BELTS", 2.37, "Jazz", "idk"));
        allSongs.add(new Song("Take Five", "Dave Brubeck", 5.24, "Jazz", "idk"));
        allSongs.add(new Song("So What", "Miles Davis", 9.22, "Jazz", "idk"));
        allSongs.add(new Song("Strange Fruit", "Billie Holiday", 3.12, "Jazz", "sad"));
    }

    public List<Song> getAllSongs() {
        return allSongs;
    }

    public List<Song> getSongsByGenre(String genre) {
        List<Song> genreSongs = new ArrayList<>();
        for (Song song : allSongs) {
            if (song.getGenre().equalsIgnoreCase(genre)) {
                //Note: started using equalsIgnoreCase found below to avoid lengthy || blocks for case sensitivity handling
                // https://www.w3schools.com/java/ref_string_equalsignorecase.asp
                // I figured Java would have something built in for this and it does. Hope you don't mind
                genreSongs.add(song);
            }
        }
        return genreSongs;
    }

    public List<Song> getSongsByMood(String mood) {
        List<Song> moodSongs = new ArrayList<>();
        for (Song song : allSongs) {
            if (song.getMood().equalsIgnoreCase(mood)) {
                moodSongs.add(song);
            }
        }
        return moodSongs;
    }

    public void displaySongs(List<Song> songs, String category) {
        System.out.println("\n" + category + " Songs:");
        System.out.println("------------------------");
        if (songs.isEmpty()) {
            System.out.println("No songs found.");
            return;
        }

        for (int i = 0; i < songs.size(); i++) {
            System.out.print((i + 1) + ". ");
            songs.get(i).displaySongInfo();
        }
    }

    public List<Song> getRecommendations(String genre, User user) {
        List<Song> genreSongs = getSongsByGenre(genre);
        List<Song> recommendations = new ArrayList<>();

        // Get all songs currently in user's playlists
        List<Song> userSongs = new ArrayList<>();
        for (PlaylistInterface playlist : user.getPlaylists()) {
            userSongs.addAll(playlist.getSongs());
        }

        // Only recommend songs not already in user's playlists
        for (Song song : genreSongs) {
            boolean alreadyHave = false;
            for (Song userSong : userSongs) {
                if (song.getTitle().equals(userSong.getTitle()) &&
                        song.getArtist().equals(userSong.getArtist())) {
                    alreadyHave = true;
                    break;
                }
            }
            if (!alreadyHave) {
                recommendations.add(song);
            }
        }

        return recommendations;
    }

    public Song getSongByNumber(List<Song> songs, int number) {
        if (number >= 1 && number <= songs.size()) {
            return songs.get(number - 1);
        }
        return null;
    }
}