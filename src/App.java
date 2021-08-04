import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.patriksanta.CarCategory.*;
import org.patriksanta.CarData.Car;

public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Patrik Santa\\Prog\\Java\\carScraping\\carCategories.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        CarCategories categories = (CarCategories) objectInputStream.readObject();

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        String[] array = categories.toStringArray();
        Arrays.sort(array);

        JComboBox<String> comboBox = new JComboBox<>(array);

        /*
        JList<String> l1 = new JList<>(array);
        JList<String> l2 = new JList<>();
        JList<String> l3 = new JList<>();

        l1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        l1.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String categoryName = l1.getSelectedValue().split(" \\(")[0];
                System.out.println(categoryName);
                String[] tempCategories = categories.getSubCategoriesOf(categoryName).toStringArray();

                Arrays.sort(tempCategories);
                l2.setListData(tempCategories);
            }
        });

        l2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        l2.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String categoryName1 = l1.getSelectedValue().split(" \\(")[0];
                String categoryName2 = l2.getSelectedValue().split(" \\(")[0];
                String[] tempCategories = categories.getSubCategoriesOf(categoryName1).getSubCategoriesOf(categoryName2).toStringArray();

                Arrays.sort(tempCategories);
                l3.setListData(tempCategories);
            }
        });
         */

        fileInputStream = new FileInputStream("C:\\Users\\Patrik Santa\\Prog\\Java\\carScraping\\car.ser");
        objectInputStream = new ObjectInputStream(fileInputStream);
        Car car = (Car) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();

        ImagePanel imagePanel = new ImagePanel();
        imagePanel.image = ImageIO.read(new ByteArrayInputStream(car.imageBuffer));

        frame.add(imagePanel);

        frame.setPreferredSize(new Dimension(400, 300));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        /*
        panel.add(new JScrollPane(l1));
        panel.add(new JScrollPane(l2));
        panel.add(new JScrollPane(l3));
         */



        //panel.add(comboBox);
        //frame.add(panel);
    }
}
