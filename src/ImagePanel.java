import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagePanel extends JPanel {
    private BufferedImage image;

    public ImagePanel(BufferedImage image) {
        if (image == null) {
            try {
                this.image = ImageIO.read(new File("C:\\Users\\Patrik Santa\\Prog\\Java\\carScraping\\noCar.png"));
            } catch (IOException e) {
                this.image = null;
            }
        } else this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(getScaledImage(image, getSize().width), 0, 0, this);
    }

    private Image getScaledImage(Image Img, int width) {
        return image.getScaledInstance(width, (int) (width * 0.75), Image.SCALE_FAST);
    }
}