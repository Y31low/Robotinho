package Game.view;

import Game.model.Direzione;

import javax.swing.*;
import java.awt.*;

public class LabelRobot extends JLabel{

        private ImageIcon img;
        private final ImageIcon sfondo;

        public LabelRobot() {
            img = new ImageIcon(new ImageIcon("Robotinho/Robotinho/src/img/RobotS.png").getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT));
            this.setIcon(img);
            this.setBackground(Color.decode("#b4844c"));
            this.setOpaque(true);
            //this.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));

            sfondo = new ImageIcon("Robotinho/Robotinho/src/img/pavimento.png");
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (sfondo != null) {
                g.drawImage(sfondo.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
            }

            if (img != null) {
                int x = (this.getWidth() - img.getIconWidth()) / 2;
                int y = (this.getHeight() - img.getIconHeight()) / 2;
                img.paintIcon(this, g, x, y);
            }
        }

    public void setDir(Direzione dir){
        this.setIcon(null);
        switch (dir) {
            case North:
                img = new ImageIcon(new ImageIcon("Robotinho/Robotinho/src/img/RobotN.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
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
