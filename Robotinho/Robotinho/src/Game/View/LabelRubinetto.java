package Game.View;

import javax.swing.*;
import java.awt.*;

/**
 * @author Adil Lagzouli 20045391
 * @author Samuele Giallorenzo 20045100
 * @author Federico Mannisi 20045099
 */

public class LabelRubinetto extends Label {
    public LabelRubinetto() {
        super("Robotinho/Robotinho/src/img/rubinetto.png");
    }

    protected void setRotto(boolean rotto){
        this.setIcon(null);

        if(!rotto)
            this.img = new ImageIcon(new ImageIcon("Robotinho/Robotinho/src/img/rubinetto.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        else
            this.img = new ImageIcon(new ImageIcon("Robotinho/Robotinho/src/img/rubinetto_rotto.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

        this.setIcon(img);
    }
}
