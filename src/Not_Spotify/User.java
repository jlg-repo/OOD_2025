package Not_Spotify;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    String username;
    List<Playlist> playlists;

    public User(String username) {
        this.username = username;
        this.playlists = new ArrayList<>();
    }

    public Playlist createPlaylist(String name, String type) {
        Playlist playlist;

        if (Objects.equals(type, "Pop") || Objects.equals(type, "pop")) {
            playlist = new PopPlaylist(name);
        } else if (Objects.equals(type, "Rock") || Objects.equals(type, "rock")) {
            playlist = new RockPlaylist(name);
        } else if (Objects.equals(type, "Jazz") || Objects.equals(type, "jazz")) {
            playlist = new JazzPlaylist(name);
        } else {
            System.out.println("Unknown playlist type, what kind of weird stuff do you listen to?");
            playlist = new Playlist(name);
        }

        playlists.add(playlist);
        System.out.println("Created " + type + " playlist: " + name);

        return playlist;
    }

    public void deletePlaylist(Playlist playlist) {
        if (playlists.remove(playlist)) {
            System.out.println("Deleted playlist: " + playlist.getName());
        } else {
            System.out.println("Playlist not found.");
        }
    }

    public void addSongToPlaylist(Playlist playlist, Song song) {
        if (playlists.contains(playlist)) { //null check
            playlist.addSong(song);
        } else {
            System.out.println("You don't own this playlist");

        }
    }

    public void removeSongFromPlaylist(Playlist playlist, Song song) {
        if (playlists.contains(playlist)) {
            playlist.removeSong(song);
        } else {
            System.out.println("You don't own this playlist");
        }
    }

    public String getUsername() {
        return username;
    }
    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void displayAllPlaylists() {
        System.out.println(username + "'s playlists: ");
        if (playlists.isEmpty()) {
            System.out.println("No Playlists found.");
            return;
        }

        for (int i = 0; i < playlists.size(); i++) {
            System.out.println((i+1) + ". " + playlists.get(i).getName() +
                    " (" + playlists.get(i).getSongs().size() + " songs)");
        }
    }
}
