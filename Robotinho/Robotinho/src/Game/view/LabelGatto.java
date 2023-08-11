package Game.view;

import javax.swing.*;
import java.awt.*;

public class LabelGatto extends JLabel {
    private final ImageIcon img;
    private final ImageIcon sfondo;

    public LabelGatto() {
        img = new ImageIcon(new ImageIcon("Robotinho/Robotinho/src/img/Gatto.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        this.setIcon(img);
        this.setBackground(Color.decode("#b4844c"));
        this.setOpaque(true);

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
