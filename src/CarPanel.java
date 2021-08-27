import org.patriksanta.Car.Data.Car;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CarPanel extends JPanel {
    JPanel panel;
    public CarPanel(Car car) {
        panel = new JPanel();
        panel.setBorder(new LineBorder(Color.BLACK, 1));
        panel.setLayout(new GridBagLayout());

        setBorder(new EmptyBorder(0, 50, 20, 50));
        setLayout(new BorderLayout());

        // Image
        ImageIcon imageIcon = new ImageIcon(resize(car.getImageBuffer(), 200, 150));
        JLabel imagePanel = new JLabel(imageIcon);
        imagePanel.setBorder(new MatteBorder(0, 0, 0, 1, Color.black));
        addToPanel(imagePanel, 0, 0, 1, 2);

        // Name
        JPanel namePanel = new JPanel();
        namePanel.setPreferredSize(new Dimension(400, 20));
        namePanel.setLayout(new BorderLayout());
        namePanel.setBorder(new EmptyBorder(0, 10, 0, 0));

        JLabel nameLabel = new JLabel(car.getName());
        nameLabel.setFont(new Font(nameLabel.getFont().getName(), Font.BOLD, 15));
        namePanel.add(nameLabel, BorderLayout.CENTER);

        addToPanel(namePanel, 1, 0, 1, 1);

        // Price
        JPanel pricePanel = new JPanel();
        pricePanel.setPreferredSize(new Dimension(50, 20));
        pricePanel.setLayout(new BorderLayout());
        pricePanel.setBorder(new EmptyBorder(0, 0, 0, 10));

        JLabel priceLabel = new JLabel(car.getPrice() + " Ft");
        priceLabel.setFont(new Font(priceLabel.getFont().getName(), Font.ITALIC, 15));
        pricePanel.add(priceLabel, BorderLayout.LINE_END);

        addToPanel(pricePanel, 2, 0, 1, 1);

        // Properties
        JPanel propertiesPanelContainer = new JPanel();
        propertiesPanelContainer.setLayout(new BorderLayout());
        propertiesPanelContainer.setBorder(new EmptyBorder(0, 20, 0, 0));

        JPanel propertiesPanel = new JPanel();
        propertiesPanel.setLayout(new BoxLayout(propertiesPanel, BoxLayout.Y_AXIS));

        JLabel dateLabel = new JLabel((car.getDate().getYear() + 1900) + ".");
        dateLabel.setFont(new Font(dateLabel.getFont().getName(), Font.PLAIN, 13));
        propertiesPanel.add(dateLabel);

        if (car.getDistance() != -1) {
            JLabel distanceLabel = new JLabel(car.getDistance() + " km");
            distanceLabel.setFont(new Font(distanceLabel.getFont().getName(), Font.PLAIN, 13));

            propertiesPanel.add(distanceLabel);
        }

        propertiesPanelContainer.add(propertiesPanel, BorderLayout.CENTER);
        addToPanel(propertiesPanelContainer, 1, 1, 2, 1);

        add(panel, BorderLayout.CENTER);
    }

    private void addToPanel(Component component, int gridX, int gridY, int gridWidth, int gridHeight) {
        GridBagConstraints gbc = new GridBagConstraints(gridX, gridY, gridWidth, gridHeight, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
        panel.add(component, gbc);
    }

    private BufferedImage resize(BufferedImage img, int width, int height) {
        Image temp = img.getScaledInstance(width, height, Image.SCALE_FAST);
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D graphics = resizedImage.createGraphics();
        graphics.drawImage(temp, 0, 0, null);
        graphics.dispose();

        return resizedImage;
    }
}
