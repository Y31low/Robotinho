package Game.view;

import javax.swing.*;
import java.awt.*;

public class LabelMuro extends JLabel {
    private ImageIcon img;

    public LabelMuro() {
        img = new ImageIcon(new ImageIcon("Robotinho/Robotinho/src/img/muro.png").getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT));
        this.setIcon(img);
        this.setOpaque(true);
        //this.setBorder(BorderFactory.createLineBorder(Color.BLACK,1,true));
    }
}
