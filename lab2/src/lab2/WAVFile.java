	package lab2;

	public class WAVFile extends AbstractAudioFile {
	    public WAVFile(String fileName) {
	        super(fileName);
	    }

	    public void play() {
	        if (isOpened) {
	            System.out.println("Файл " + fileName + " вже відтворюється.");
	        } else {
	            isOpened = true;
	            isPaused = false;
	            System.out.println("Відтворення WAV файлу: " + fileName);
	        }
	    }

	    public void pause() {
	        if (isOpened && !isPaused) {
	            isPaused = true;
	            System.out.println("Пауза WAV файлу: " + fileName);
	        } else if (isPaused) {
	            isPaused = false;
	            System.out.println("Зняття паузи WAV файлу: " + fileName);
	        } else {
	            System.out.println("Неможливо поставити на паузу, оскільки файл не відтворюється: " + fileName);
	        }
	    }
	}