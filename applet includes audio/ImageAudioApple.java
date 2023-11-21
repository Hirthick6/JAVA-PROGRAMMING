import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageAudioApple extends Applet implements KeyListener {
    private Image currentImage;
    private AudioClip currentAudio;

    public void init() {
        setSize(400, 400); // Set applet size
        addKeyListener(this);
        setBackground(Color.LIGHT_GRAY); // Set background color
        loadResources("default.jpeg", "default.wav");
    }

    private void loadResources(String imageFileName, String audioFileName) {
        currentImage = getImage(getCodeBase(), imageFileName);
        currentAudio = getAudioClip(getCodeBase(), audioFileName);
    }

    public void paint(Graphics g) {
        if (currentImage != null) {
            g.drawImage(currentImage, 150, 100, 100, 100, this);
        }
    }

    public void keyPressed(KeyEvent e) {
        char key = e.getKeyChar();
        switch (key) {
            case 'S':
            case 's':
                loadResources("smile.png", "smiley.wav");
                break;
            case 'O':
            case 'o':
                loadResources("ol.png", "olympic.wav");
                break;
            case 'M':
            case 'm':
                loadResources("mo.png", "moon.wav");
                break;
            default:
                loadResources("default.jpeg", "default.wav");
                break;
        }
        repaint();
        playAudio();
    }

    private void playAudio() {
        if (currentAudio != null) {
            currentAudio.play();
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }
}