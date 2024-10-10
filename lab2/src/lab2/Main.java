package lab2;

public class Main {
    public static void main(String[] args) {
		AbstractAudioFile[] audioFiles = {
            new MP3File("song1.mp3"),
            new WAVFile("song2.wav"),
            new FLACFile("song3.flac")
        };

        AudioPlayerSystem audioSystem = new AudioPlayerSystem(audioFiles);

        audioSystem.playAll();

        audioFiles[0].pause();
        audioFiles[0].pause();
        audioFiles[1].stop();
        audioFiles[1].play();
        audioFiles[2].stop();
        audioFiles[2].getStatus();
        
        audioSystem.stopAll();
    }
}