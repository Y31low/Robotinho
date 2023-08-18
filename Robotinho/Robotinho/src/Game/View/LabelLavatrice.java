package Game.View;

import javax.swing.*;
import java.awt.*;

public class LabelLavatrice extends Label {
    public LabelLavatrice() {
        super("Robotinho/Robotinho/src/img/lavatrice.png");
    }

    public void setRotta(boolean rotta){
        this.setIcon(null);

        if(!rotta)
            this.img = new ImageIcon(new ImageIcon("Robotinho/Robotinho/src/img/lavatrice.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        else
            this.img = new ImageIcon(new ImageIcon("Robotinho/Robotinho/src/img/lavatrice_rotta.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

        this.setIcon(img);
    }
}
