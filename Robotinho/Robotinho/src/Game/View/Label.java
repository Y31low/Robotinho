package Game.View;

import javax.swing.*;
import java.awt.*;

/**
 * @author Adil Lagzouli 20045391
 * @author Samuele Giallorenzo 20045100
 * @author Federico Mannisi 20045099
 */

public class Label extends JLabel{
    protected ImageIcon img;
    protected final ImageIcon sfondo;

    public Label(String filename) {
        img = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT));
        this.setIcon(img);
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
}
