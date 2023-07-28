package Game.view;

import Game.Controller.GameController;
import Game.model.Direzione;
import Game.model.Mappa;

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

    private JLabel[][] map;
    private class LabelMuro extends JLabel {


        public LabelMuro() {

            this.setBackground(Color.red);
            this.setBorder(BorderFactory.createLineBorder(Color.BLACK,1,true));
            this.setOpaque(true);
        }


    }
    private class LabelPavimento extends JLabel {


        public LabelPavimento() {

            this.setBackground(Color.LIGHT_GRAY);
            this.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
            this.setOpaque(true);
        }

    }

    private class LabelRobot extends JLabel {
        private ImageIcon img;

        public LabelRobot() {

            img=new ImageIcon(new ImageIcon("Robotinho/Robotinho/src/img/RobotS.png").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
            this.setIcon(img);
            this.setBackground(Color.LIGHT_GRAY);
            this.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
            this.setOpaque(true);
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

        public LabelGatto() {

            img=new ImageIcon(new ImageIcon("Robotinho/Robotinho/src/img/Gatto.png").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
            this.setIcon(img);
            this.setBackground(Color.LIGHT_GRAY);
            this.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
            this.setOpaque(true);
        }

    }

    private class LabelFornello extends JLabel {
        private final ImageIcon img;

        public LabelFornello() {

            img=new ImageIcon(new ImageIcon("Robotinho/Robotinho/src/img/fornello.png").getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));
            this.setIcon(img);
            this.setBackground(Color.LIGHT_GRAY);
            this.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
            this.setOpaque(true);
        }

    }

    private class LabelLavatrice extends JLabel {
        private final ImageIcon img;

        public LabelLavatrice() {

            img=new ImageIcon(new ImageIcon("Robotinho/Robotinho/src/img/lavatrice.png").getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));
            this.setIcon(img);
            this.setBackground(Color.LIGHT_GRAY);
            this.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
            this.setOpaque(true);
        }

    }


    public GuiMappa(Mappa m) throws HeadlessException {
        super("Robotinho");
        this.setSize(500,500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.map=new JLabel[m.getDim()][m.getDim()];
        this.main=new JPanel();

        this.R=new LabelRobot();
        main.setLayout(new GridLayout(m.getDim(),m.getDim()));
        main.setVisible(true);
        for (int i = 0; i < m.getDim(); i++) {
            for (int j=0;j<m.getDim();j++){
                if(m.getMappa()[i][j].toString().equals("Muro")){
                    this.map[i][j]=new LabelMuro();
                    main.add(this.map[i][j]);
                }
                else if(m.getMappa()[i][j].toString().equals("Pavimento")){
                    this.map[i][j] = new LabelPavimento();
                    main.add(this.map[i][j]);
                }
                else if (m.getMappa()[i][j].toString().equals("Robot")) {
                    this.map[i][j] = new LabelRobot();
                    main.add(this.map[i][j]);
                }
                else if (m.getMappa()[i][j].toString().equals("Cat")) {
                    this.map[i][j] = new LabelGatto();
                    main.add(this.map[i][j]);
                }
                else if (m.getMappa()[i][j].toString().equals("Fornello")) {
                    this.map[i][j] = new LabelFornello();
                    main.add(this.map[i][j]);
                }
                else if (m.getMappa()[i][j].toString().equals("Lavatrice")) {
                    this.map[i][j] = new LabelLavatrice();
                    main.add(this.map[i][j]);
                }
            }
        }

        dx=new JButton("Dx");
        sx=new JButton("Sx");
        avanza=new JButton("Avanza");



        this.add(main, BorderLayout.CENTER);
        buttons=new JPanel();
        buttons.setLayout(new BorderLayout());
        buttons.add(avanza,BorderLayout.CENTER);
        buttons.add(sx, BorderLayout.WEST);
        buttons.add(dx, BorderLayout.EAST);
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
            for (int j=0;j<m.getDim();j++){
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
            }
        }
        main.updateUI();

    }

    public void updateLabelRobot(Direzione d){
       this.R.setDir(d);

    }

}
