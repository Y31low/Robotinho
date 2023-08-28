package Game.View;

import javax.swing.*;
import java.awt.*;

/**
 * @author Adil Lagzouli 20045391
 * @author Samuele Giallorenzo 20045100
 * @author Federico Mannisi 20045099
 */

public class LabelFornello extends Label {
    public LabelFornello() {
        super("Robotinho/Robotinho/src/img/fornello.png");
    }

    public void setAcceso(boolean acceso){
        this.setIcon(null);

        if(acceso)
            this.img = new ImageIcon(new ImageIcon("Robotinho/Robotinho/src/img/fornello_acceso.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        else
            this.img = new ImageIcon(new ImageIcon("Robotinho/Robotinho/src/img/fornello.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

        this.setIcon(img);
    }
}
