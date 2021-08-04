import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagePanel extends JPanel{
    public BufferedImage image;

    public ImagePanel() { }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(getScaledImage(image, 500), 0, 0, this); // see javadoc for more info on the parameters
    }

    Image getScaledImage(Image Img, int width) {
        int height = (width / 91) * 68;
        BufferedImage resizedImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(Img, 0, 0, width, height, null);
        g2.dispose();

        return resizedImg;
    }
}