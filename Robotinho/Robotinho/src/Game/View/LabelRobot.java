package Game.View;

import Game.Model.Direzione;

import javax.swing.*;
import java.awt.*;

/**
 * @author Adil Lagzouli 20045391
 * @author Samuele Giallorenzo 20045100
 * @author Federico Mannisi 20045099
 */

public class LabelRobot extends Label{
    public LabelRobot() {
        super("Robotinho/Robotinho/src/img/RobotS.png");
    }

    public void setDir(Direzione dir){
        this.setIcon(null);
        switch (dir) {
            case North:
                this.img = new ImageIcon(new ImageIcon("Robotinho/Robotinho/src/img/RobotN.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
                this.setIcon(img);
                break;
            case South:
                img = new ImageIcon(new ImageIcon("Robotinho/Robotinho/src/img/RobotS.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
                this.setIcon(img);
                break;
            case East:
                img = new ImageIcon(new ImageIcon("Robotinho/Robotinho/src/img/RobotE.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
                this.setIcon(img);
                break;
            case West:
                img = new ImageIcon(new ImageIcon("Robotinho/Robotinho/src/img/RobotW.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
                this.setIcon(img);
                break;
        }
    }
}
