import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*<applet code="Olympics" width=600 height=600>
</applet>*/

public class Olympics extends Applet implements MouseMotionListener {
    private int mouseX, mouseY;
    private Color[] backgroundColors = {Color.LIGHT_GRAY, Color.CYAN, Color.ORANGE, Color.PINK};
    private int currentColorIndex = 0;

    public void init() {
        addMouseMotionListener(this);
        changeBackgroundColorPeriodically();
    }

    public void paint(Graphics g) {
        // Calculate the positions of the Olympic rings based on mouse cursor position
        int x = mouseX - 15;
        int y = mouseY - 15;

        // Draw the Olympic rings
        drawOlympicRing(g, Color.BLUE, x, y);
        drawOlympicRing(g, Color.YELLOW, x + 30, y + 30);
        drawOlympicRing(g, Color.BLACK, x + 60, y);
        drawOlympicRing(g, Color.GREEN, x + 90, y + 30);
        drawOlympicRing(g, Color.RED, x + 120, y);
    }

    // Helper method to draw an Olympic ring
    private void drawOlympicRing(Graphics g, Color color, int x, int y) {
        g.setColor(color);
        g.drawOval(x, y, 30, 30);
    }

    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        repaint();
    }

    public void mouseDragged(MouseEvent e) {
        // Not needed, but required by the interface
    }

    private void changeBackgroundColorPeriodically() {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000); // Change background color every 5 seconds
                    currentColorIndex = (currentColorIndex + 1) % backgroundColors.length;
                    setBackground(backgroundColors[currentColorIndex]);
                    repaint();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
