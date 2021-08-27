import org.patriksanta.Car.Data.CarList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CarAppFrame extends JFrame {
    public CarAppFrame(CarList carlist) {
        JPanel menu = new JPanel();
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        menu.setBorder(new EmptyBorder(50, 0, 0, 0));

        JButton searchButton = new JButton("Open dataBase");
        searchButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.setVisible(false);
                CarListPanel carListPanel = new CarListPanel(carlist);
                JScrollPane scrollPane = new JScrollPane(carListPanel);
                scrollPane.getVerticalScrollBar().setUnitIncrement(20);
                add(scrollPane);
            }
        });

        JButton scriptButton = new JButton("Run script");
        scriptButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        scriptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ProcessBuilder processBuilder = new ProcessBuilder();
                    processBuilder.command("cmd.exe", "/c", "start C:\\App.bat");
                    Process process = processBuilder.start();
                    process.waitFor();
                    process.destroy();
                } catch (IOException | InterruptedException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        menu.add(searchButton);
        menu.add(scriptButton);
        add(menu);


        /*
        CarListPanel carListPanel = new CarListPanel(carlist);
        JScrollPane scrollPane = new JScrollPane(carListPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        add(scrollPane);

        JButton button = new JButton("Jump back to top");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMinimum());
            }
        });
        button.setAlignmentX(Component.RIGHT_ALIGNMENT);
        add(button);
         */

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(1024, 768));
        pack();
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
