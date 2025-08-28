package Not_Spotify_Modified;

import java.util.List;
import java.util.Scanner;

public class SpotifyMain {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        MusicLibrary library = new MusicLibrary();

        System.out.println("Welcome to Modified 'Spotify'!");
        System.out.println("----------------------------------");

        System.out.print("Enter your username: ");
        String username = scnr.nextLine();
        User user = new User(username);

        System.out.println("Hello " + username + "!");
        System.out.println();

        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("1. Browse songs");
            System.out.println("2. Get recommendations by genre");
            System.out.println("3. Create playlist");
            System.out.println("4. View my playlists");
            System.out.println("5. Add song to playlist");
            System.out.println("6. Play playlist");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

            int choice = getValidInt(scnr);
            System.out.println();

            switch (choice) {
                case 1:
                    browseSongs(scnr, library);
                    break;
                case 2:
                    getRecommendations(scnr, library, user);
                    break;
                case 3:
                    createPlaylist(scnr, user);
                    break;
                case 4:
                    user.displayAllPlaylists();
                    break;
                case 5:
                    addSongToPlaylist(scnr, user, library);
                    break;
                case 6:
                    playPlaylist(scnr, user);
                    break;
                case 0:
                    System.out.println("Thanks for using Modified 'Spotify'!");
                    scnr.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
            System.out.println();
        }
    }

    private static void browseSongs(Scanner scnr, MusicLibrary library) {
        System.out.println("How would you like to browse?");
        System.out.println("1. All songs");
        System.out.println("2. By genre (Pop, Rock, Jazz)");
        System.out.println("3. By mood (happy, sad, idk)");
        System.out.print("Choice: ");

        int browseChoice = getValidInt(scnr);

        switch (browseChoice) {
            case 1:
                library.displaySongs(library.getAllSongs(), "All");
                break;
            case 2:
                System.out.print("Enter genre (Pop, Rock, Jazz): ");
                String genre = scnr.nextLine();
                library.displaySongs(library.getSongsByGenre(genre), genre);
                break;
            case 3:
                System.out.print("Enter mood (happy, sad, idk): ");
                String mood = scnr.nextLine();
                library.displaySongs(library.getSongsByMood(mood), mood);
                break;
            default:
                System.out.println("Invalid choice (PS: Your mood is not invalid but I am too lazy to program more moods)");
        }
    }

    private static void getRecommendations(Scanner scnr, MusicLibrary library, User user) {
        System.out.print("Enter genre for recommendations (Pop, Rock, Jazz): ");
        String genre = scnr.nextLine();

        List<Song> recommendations = library.getRecommendations(genre, user);

        if (recommendations.isEmpty()) {
            System.out.println("No new " + genre + " songs to recommend. Bother the dev until he adds more songs");
        } else {
            System.out.println("\nNew " + genre + " songs you may like:");
            library.displaySongs(recommendations, genre + " Recommendations");
        }
    }

    private static void createPlaylist(Scanner scanner, User user) {
        System.out.print("Enter playlist name: ");
        String name = scanner.nextLine();

        System.out.print("Enter playlist type (Pop, Rock, Jazz, or Basic): ");
        String type = scanner.nextLine();

        user.createPlaylist(name, type);
    }

    private static void addSongToPlaylist(Scanner scanner, User user, MusicLibrary library) {
        if (user.getPlaylists().isEmpty()) {
            System.out.println("You have no playlists. Create one first!");
            return;
        }

        user.displayAllPlaylists();
        System.out.print("Select playlist number: ");
        int playlistNum = getValidInt(scanner);

        if (playlistNum < 1 || playlistNum > user.getPlaylists().size()) { //handles negative inputs or number choices greater than playlist number options
            System.out.println("Invalid playlist number.");
            return;
        }

        PlaylistInterface selectedPlaylist = user.getPlaylists().get(playlistNum - 1);

        library.displaySongs(library.getAllSongs(), "Available");
        System.out.print("Select song number to add: ");
        int songNum = getValidInt(scanner);

        Song selectedSong = library.getSongByNumber(library.getAllSongs(), songNum);
        if (selectedSong != null) {
            user.addSongToPlaylist(selectedPlaylist, selectedSong);
        } else {
            System.out.println("Invalid song number");
        }
    }

    private static void playPlaylist(Scanner scanner, User user) {
        if (user.getPlaylists().isEmpty()) {
            System.out.println("You have no playlists");
            return;
        }

        user.displayAllPlaylists();
        System.out.print("Select playlist number to play: ");
        int playlistNum = getValidInt(scanner);

        if (playlistNum >= 1 && playlistNum <= user.getPlaylists().size()) { //this handles the proper range of playlist numbers
            PlaylistInterface playlist = user.getPlaylists().get(playlistNum - 1);
            playlist.playAllSongs();

            //Test specific methods
            if (playlist instanceof PopPlaylist) {
                ((PopPlaylist) playlist).shuffle();
            } else if (playlist instanceof RockPlaylist) {
                ((RockPlaylist) playlist).playLouder();
            }
        } else {
            System.out.println("Invalid playlist number.");
        }
    }

    //simple method to handle invalid input
    private static int getValidInt(Scanner scanner) {
        while (true) {
            try {
                int result = scanner.nextInt();
                scanner.nextLine();
                return result;
            } catch (Exception e) {
                System.out.print("Please enter a valid number: ");
                scanner.nextLine();
            }
        }
    }
}