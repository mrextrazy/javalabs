package lab2;

public class AudioPlayerSystem {
    private AbstractAudioFile[] audioFiles;

    public AudioPlayerSystem(AbstractAudioFile[] audioFiles) {
        this.audioFiles = audioFiles;
    }

    public void playAll() {
        for (AbstractAudioFile audioFile : audioFiles) {
                audioFile.play();
        }
    }

    public void stopAll() {
        for (AbstractAudioFile audioFile : audioFiles) {
            audioFile.stop();
        }
    }
}