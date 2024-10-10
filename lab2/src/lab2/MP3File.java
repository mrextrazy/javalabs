package lab2;

public class MP3File extends AbstractAudioFile {
    public MP3File(String fileName) {
        super(fileName);
    }

    public void play() {
        if (isOpened) {
            System.out.println("Файл " + fileName + " вже відтворюється.");
        } else {
            isOpened = true;
            isPaused = false;
            System.out.println("Відтворення MP3 файлу: " + fileName);
        }
    }

    public void pause() {
        if (isOpened && !isPaused) {
            isPaused = true;
            System.out.println("Пауза MP3 файлу: " + fileName);
        } else if (isPaused) {
            isPaused = false;
            System.out.println("Зняття паузи MP3 файлу: " + fileName);
        } else {
            System.out.println("Неможливо поставити на паузу, оскільки файл не відтворюється: " + fileName);
        }
    }
}