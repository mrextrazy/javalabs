package lab2;

public abstract class AbstractAudioFile implements Playable,StatusCheckable {
    protected String fileName;
    protected boolean isOpened;
    protected boolean isPaused;

    public AbstractAudioFile(String fileName) {
        this.fileName = fileName;
        this.isOpened = false;
        this.isPaused = false;
    }

    public void stop() {
        if (isOpened) {
            isOpened = false;
            isPaused = false;
            System.out.println(fileName + " закрито.");
        } else {
            System.out.println("Неможливо закрити файл, оскільки він не відтворюється: " + fileName);
        }
    }

    public abstract void play();

    public abstract void pause();
    
    public void getStatus() {
        if (isPaused) {
        	System.out.println("Файл " + this.fileName + " на паузі.");
        } else if (isOpened) {
        	System.out.println("Файл " + this.fileName + " відтворюється.");
        } else {
        	System.out.println("Файл " + this.fileName + " закритий.");
        }
    }
}