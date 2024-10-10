package lab2;

public class FLACFile extends AbstractAudioFile {
    public FLACFile(String fileName) {
        super(fileName);
    }

    public void play() {
        if (isOpened) {
            System.out.println("Файл " + fileName + " вже відтворюється.");
        } else {
            isOpened = true;
            isPaused = false;
            System.out.println("Відтворення FLAC файлу: " + fileName);
        }
    }

    public void pause() {
        if (isOpened && !isPaused) {
            isPaused = true;
            System.out.println("Пауза FLAC файлу: " + fileName);
        } else if (isPaused) {
            isPaused = false;
            System.out.println("Зняття паузи FLAC файлу: " + fileName);
        } else {
            System.out.println("Неможливо поставити на паузу, оскільки файл не відтворюється: " + fileName);
        }
    }
}