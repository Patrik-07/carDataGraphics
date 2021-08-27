import org.patriksanta.Car.Data.Car;
import org.patriksanta.Car.Data.CarList;

import javax.swing.*;
import java.awt.*;

public class CarListPanel extends JPanel {
    public CarListPanel(CarList carList) {
        setLayout(new GridLayout(0, 1));
        for (Car car : carList.getCars())
            add(new CarPanel(car), BorderLayout.LINE_END);
    }
}
