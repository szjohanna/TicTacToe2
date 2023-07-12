
package tictactoe2.settings;

import java.net.URL;
import java.util.ArrayList;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Music {
    
    //Makes sure that music can be accessed within the jar file 
    static String pathSong1 = "/tictactoe2/sounds/music/song1.mp3";
    static URL resourceUrlSong1 = Music.class.getResource(pathSong1);
    
    static String pathSong2 = "/tictactoe2/sounds/music/song2.mp3";
    static URL resourceUrlSong2 = Music.class.getResource(pathSong2);
    
    static String pathSong3 = "/tictactoe2/sounds/music/song3.mp3";
    static URL resourceUrlSong3 = Music.class.getResource(pathSong3);
    
    static String pathSong4 = "/tictactoe2/sounds/music/song4.mp3";
    static URL resourceUrlSong4 = Music.class.getResource(pathSong4);
    
    static String pathSong5 = "/tictactoe2/sounds/music/song5.mp3";
    static URL resourceUrlSong5 = Music.class.getResource(pathSong5);
    
    static String pathSong6 = "/tictactoe2/sounds/music/song6.mp3";
    static URL resourceUrlSong6 = Music.class.getResource(pathSong6);
    
    
//Implementing the singleton design pattern:
//Constructor has to be called in TicTacToe2's start method once in the lifetime of the program so there is only one mediaPlayer running at a time
    private Music() {
        //Adding path of each sound to the "songs" ArrayList
        songs.add(0, resourceUrlSong1);
        songs.add(1, resourceUrlSong2);
        songs.add(2, resourceUrlSong3);
        songs.add(3, resourceUrlSong4);
        songs.add(4, resourceUrlSong5);
        songs.add(5, resourceUrlSong6);
      
        sound = new Media(songs.get(songsIndex).toExternalForm()); 
        mediaPlayer = new MediaPlayer(sound);
    }
    
    //Singleton object
    private static Music musicSingleton;

    public static Music getInstance() {
        if (musicSingleton == null) {
            musicSingleton = new Music();
        } 
        return musicSingleton;
    }

    public static ArrayList<URL> songs = new ArrayList();
    public static int songsIndex;
    
    private static String soundNumber;
    
    public static String getSoundNumber() {
        return soundNumber;
    }
    
    public static void setSoundNumber(String soundNumber) {
        Music.soundNumber = soundNumber;
    }
    
    Media sound;
    
    private static MediaPlayer mediaPlayer;
    
    //Makes sure that sound effects can be accessed within the jar file 
    static String path1 = "/tictactoe2/sounds/sounds/pencilsound1.mp3";
    static URL resourceUrl1 = Music.class.getResource(path1);
    
    static String path2 = "/tictactoe2/sounds/sounds/pencilsound2.mp3";
    static URL resourceUrl2 = Music.class.getResource(path2);
    
    static Media soundEffect1 = new Media(resourceUrl1.toExternalForm());
    static Media soundEffect2 = new Media(resourceUrl2.toExternalForm());
    
    
    private static MediaPlayer mediaplayerSoundEffects1;
    private static MediaPlayer mediaplayerSoundEffects2;
    

    public static void playSoundEffect1() throws Exception {
        mediaplayerSoundEffects1 = new MediaPlayer(soundEffect1);
        mediaplayerSoundEffects1.setCycleCount(1);
        mediaplayerSoundEffects1.play();
    }
    
    public static void playSoundEffect2()  throws Exception {
        mediaplayerSoundEffects2 = new MediaPlayer(soundEffect2);
        mediaplayerSoundEffects2.setCycleCount(1);
        mediaplayerSoundEffects2.play();
    }
    
    public static MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public static void setMediaPlayer(MediaPlayer player) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.dispose();
        }
        mediaPlayer = player;
    }

    private static boolean firstTimeMediaIsStarted = true;

    public static boolean getFirstTimeMediaIsStarted() {
        return firstTimeMediaIsStarted;
    }

    public static void setFirstTimeMediaIsStarted(boolean firstTimeMediaIsStarted) {
        Music.firstTimeMediaIsStarted = firstTimeMediaIsStarted;
    }
    
    private static boolean firstTimeVolumeIsSet = true;

    public static boolean getFirstTimeVolumeIsSet() {
        return firstTimeVolumeIsSet;
    }

    public static void setFirstTimeVolumeIsSet(boolean firstTimeVolumeIsSet) {
        Music.firstTimeVolumeIsSet = firstTimeVolumeIsSet;
    }
    
    private static boolean firstTimeMusicIsTurnedOn = true;

    public static boolean getFirstTimeMusicIsTurnedOn() {
        return firstTimeMusicIsTurnedOn;
    }

    public static void setFirstTimeMusicIsTurnedOn(boolean firstTimeMusicIsTurnedOn) {
        Music.firstTimeMusicIsTurnedOn = firstTimeMusicIsTurnedOn;
    }
    
    private static double volume = 0.0;

    public static double getVolume() {
        return volume;
    }

    public static void setVolume(double volume) {
        Music.volume = volume;
    }
    
}
