package Game.view;

import Game.Controller.GameController;
import Game.model.Direzione;
import Game.model.Mappa;
import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GuiMappa extends JFrame {
    private final JPanel main;
    private final JPanel buttons;
    private final JButton dx;
    private final JButton sx;
    private final LabelRobot R;
    private final JButton avanza;
    private final JButton spegni;
    private final JButton asciuga;

    private JLabel[][] map;

    private class LabelMuro extends JLabel {
        private ImageIcon img;

        public LabelMuro() {
            img = new ImageIcon(new ImageIcon("Robotinho/Robotinho/src/img/muro.png").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
            this.setIcon(img);
            this.setOpaque(true);
            //this.setBorder(BorderFactory.createLineBorder(Color.BLACK,1,true));
        }
    }

    private class LabelPavimento extends JLabel {
        private ImageIcon img;

        public LabelPavimento() {
            img = new ImageIcon(new ImageIcon("Robotinho/Robotinho/src/img/pavimento.png").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
            this.setIcon(img);
            this.setOpaque(true);
            //this.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        }
    }

    private class LabelRobot extends JLabel {
        private ImageIcon img;
        private final ImageIcon sfondo;

        public LabelRobot() {
            img = new ImageIcon(new ImageIcon("Robotinho/Robotinho/src/img/RobotS.png").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
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

    private class LabelGatto extends JLabel {
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

    private class LabelFornello extends JLabel {
        private final ImageIcon img;
        private final ImageIcon sfondo;

        public LabelFornello() {
            img = new ImageIcon(new ImageIcon("Robotinho/Robotinho/src/img/fornello.png").getImage().getScaledInstance(40,45,Image.SCALE_DEFAULT));
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
    }

    private class LabelLavatrice extends JLabel {
        private final ImageIcon img;
        private final ImageIcon sfondo;

        public LabelLavatrice() {
            img = new ImageIcon(new ImageIcon("Robotinho/Robotinho/src/img/lavatrice.png").getImage().getScaledInstance(45,45,Image.SCALE_DEFAULT));
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
    }

    private class LabelRubinetto extends JLabel {
        private final ImageIcon img;
        private final ImageIcon sfondo;

        public LabelRubinetto() {
            img = new ImageIcon(new ImageIcon("Robotinho/Robotinho/src/img/rubinetto.png").getImage().getScaledInstance(45,45,Image.SCALE_DEFAULT));
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
    }

    public GuiMappa(Mappa m) throws HeadlessException {
        super("Robotinho");
        this.setSize(500,500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.map=new JLabel[m.getDim()][m.getDim()];
        this.main=new JPanel();

        this.R=new LabelRobot();
        main.setLayout(new GridLayout(m.getDim(),m.getDim()));
        main.setVisible(true);
        for (int i = 0; i < m.getDim(); i++) {
            for (int j = 0; j < m.getDim(); j++){
                if(m.getMappa()[i][j].toString().equals("Muro")){
                    this.map[i][j] = new LabelMuro();
                    main.add(this.map[i][j]);
                }
                else if(m.getMappa()[i][j].toString().equals("Pavimento")){
                    this.map[i][j] = new LabelPavimento();
                    main.add(this.map[i][j]);
                }
                else if(m.getMappa()[i][j].toString().equals("Robot")) {
                    this.map[i][j] = new LabelRobot();
                    main.add(this.map[i][j]);
                }
                else if(m.getMappa()[i][j].toString().equals("Cat")) {
                    this.map[i][j] = new LabelGatto();
                    main.add(this.map[i][j]);
                }
                else if(m.getMappa()[i][j].toString().equals("Fornello")) {
                    this.map[i][j] = new LabelFornello();
                    main.add(this.map[i][j]);
                }
                else if(m.getMappa()[i][j].toString().equals("Lavatrice")) {
                    this.map[i][j] = new LabelLavatrice();
                    main.add(this.map[i][j]);
                }
                else if(m.getMappa()[i][j].toString().equals("Rubinetto")) {
                    this.map[i][j] = new LabelRubinetto();
                    main.add(this.map[i][j]);
                }
            }
        }

        dx = new JButton("Dx");
        sx = new JButton("Sx");
        avanza = new JButton("Avanza");
        spegni = new JButton("Spegni Fornello");
        asciuga = new JButton("Asciuga Pavimento");

        this.add(main, BorderLayout.CENTER);
        buttons = new JPanel();
        buttons.setLayout(new BorderLayout());
        buttons.add(avanza,BorderLayout.CENTER);
        buttons.add(sx, BorderLayout.WEST);
        buttons.add(dx, BorderLayout.EAST);
        //buttons.add(spegni, BorderLayout.AFTER_LAST_LINE);
        //buttons.add(asciuga, BorderLayout.BEFORE_FIRST_LINE);
        this.add(buttons, BorderLayout.SOUTH);


        this.setVisible(true);
    }

    public void addController(GameController controller){
        this.avanza.addActionListener(controller);
        this.dx.addActionListener(controller);
        this.sx.addActionListener(controller);
    }

    public void refresh(Mappa m){
        main.removeAll();

        for (int i = 0; i < m.getDim(); i++) {
            for (int j = 0; j < m.getDim(); j++){
                if(m.getMappa()[i][j].toString().equals("Muro")){
                    this.map[i][j] = new LabelMuro();
                    main.add(this.map[i][j]);
                }
                if(m.getMappa()[i][j].toString().equals("Pavimento")){
                    this.map[i][j] = new LabelPavimento();
                    main.add(this.map[i][j]);
                }
                if(m.getMappa()[i][j].toString().equals("Robot")) {
                    this.map[i][j] = this.R;
                    main.add(this.map[i][j]);
                }
                if(m.getMappa()[i][j].toString().equals("Cat")) {
                    this.map[i][j] = new LabelGatto();
                    main.add(this.map[i][j]);
                }
                if(m.getMappa()[i][j].toString().equals("Fornello")) {
                    this.map[i][j] = new LabelFornello();
                    main.add(this.map[i][j]);
                }
                if(m.getMappa()[i][j].toString().equals("Lavatrice")) {
                    this.map[i][j] = new LabelLavatrice();
                    main.add(this.map[i][j]);
                }
                if(m.getMappa()[i][j].toString().equals("Rubinetto")) {
                    this.map[i][j] = new LabelRubinetto();
                    main.add(this.map[i][j]);
                }
            }
        }
        main.updateUI();
    }

    public void bump(){
        JDialog dialog = new JDialog(this);
        JLabel content = new JLabel("Che male!");
        content.setHorizontalAlignment(SwingConstants.CENTER);
        dialog.add(content);
        dialog.setSize(300,100);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    public void updateLabelRobot(Direzione d){
        this.R.setDir(d);

    }
}
