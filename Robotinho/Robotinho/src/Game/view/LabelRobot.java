package Game.view;

import Game.model.Direzione;

import javax.swing.*;
import java.awt.*;

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
