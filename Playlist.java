public class Playlist {
    private final String[] songs;
    private int count;

    public Playlist(int maxSongs) {
        songs = new String[maxSongs];
        count = 0;
    }

    public void addSong(String song) {
        if (count < songs.length) {
            songs[count] = song;
            count++;
        }
    }

    public String[] getSongs() {
        String[] copy = new String[count];
        for (int i = 0; i < count; i++) {
            copy[i] = songs[i];
        }
        return copy;
    }

    public int getSongCount() {
        return count;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked";

        String[] songs = p.getSongs();

        System.out.println("Song 1: " + songs[0]);
        System.out.println("Song 2: " + songs[1]);
        System.out.println("Song Count: " + p.getSongCount());
    }
}