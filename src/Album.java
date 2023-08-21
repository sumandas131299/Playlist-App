import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String artist;

    private String name;

   private List<Song> songs;

   //constructor
    public Album() {
    }

    public Album(String artist, String name) {
        this.artist = artist;
        this.name = name;
        this.songs = new ArrayList<>();
    }

    // Getter and setter
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    // functionalities in the album

    boolean findSong(String name){
        for (Song song: songs){
           if (song.getTitle().equals(name)) return true;
        }
        return  false;
    }
    //add songs
    public String addsongToAlbum(String title ,double duration){
        if (findSong(title)==false) {
            Song song = new Song(title,duration);
            this.songs.add(song);
            return "song has been successfully added to the album";
        }
        return "Songs already exists";
    }

    //add to playlist from album
    public String addtoplaylistFromAblum(String title, LinkedList<Song> playlist){

        for(Song song : this.songs){
           if (song.getTitle().equals(title)){
               playlist.add(song);
               return "Song has been added to your playlist";
           }
        }
        return "song doesn't exist in album ";
    }

    /**
     * polymorphism overloading
     * @param songNo
     * @param playlist
     * @return
     */
    public String addtoplaylistFromAlbum(int songNo, LinkedList<Song> playlist){

        songNo-=1;
        if(songNo >0 && songNo<this.songs.size()){
            playlist.add(songs.get(songNo));
            return "Song has been added successfully";
        }

        return "Incorrect Song no. ";
    }
}
