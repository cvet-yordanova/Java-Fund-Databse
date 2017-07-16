package OnlineRadioDatabase;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlayList {
    private List<Song> songs;

    public PlayList(){
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song){
        this.songs.add(song);
    }

    public int getSongsCount(){
        return this.songs.size();
    }

    public String getTotalPlaylistLength(){
         int minutes = 0;
         int seconds = 0;

        for (Song song : songs) {
            minutes += song.getMinutes();
            seconds += song.getSeconds();
        }

        int totalength = (minutes*60) + seconds;
        int hour = totalength / 60 / 60;
        int totalMinutes = (totalength/60)-(hour * 60);
        int totalSeconds = totalength % 60;

        return String.format("Playlist length: %dh %dm %ds", hour, totalMinutes,totalSeconds);
    }

}
