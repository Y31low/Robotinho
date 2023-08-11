package Game.view;

import javax.swing.*;
import java.awt.*;

public class LabelPavimento extends JLabel {
    private ImageIcon img;

    public LabelPavimento() {
        img = new ImageIcon(new ImageIcon("Robotinho/Robotinho/src/img/pavimento.png").getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT));
        this.setIcon(img);
        this.setOpaque(true);
        //this.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
    }
}
