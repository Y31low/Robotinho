package Game.view;

import Game.Controller.GameController;
import Game.model.Mappa;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GuiMappa extends JFrame {
    private final JPanel main;
    private final JPanel buttons;
    private final JButton Nord;
    private final JButton Sud;
    private final JButton Est;
    private final JButton Ovest;

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
        private final ImageIcon img;

        public LabelRobot() {

            img=new ImageIcon(new ImageIcon("Robotinho/src/img/giru.png").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
            this.setIcon(img);
            this.setBackground(Color.LIGHT_GRAY);
            this.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
            this.setOpaque(true);
        }

    }

    private class LabelGatto extends JLabel {
        private final ImageIcon img;

        public LabelGatto() {

            img=new ImageIcon(new ImageIcon("Robotinho/src/img/Gatto.png").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
            this.setIcon(img);
            this.setBackground(Color.LIGHT_GRAY);
            this.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
            this.setOpaque(true);
        }

    }

    private class LabelFornello extends JLabel {
        private final ImageIcon img;

        public LabelFornello() {

            img=new ImageIcon(new ImageIcon("Robotinho/src/img/fornello.png").getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT)s);
            this.setIcon(img);
            this.setBackground(Color.LIGHT_GRAY);
            this.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
            this.setOpaque(true);
        }

    }

    private class LabelLavatrice extends JLabel {
        private final ImageIcon img;

        public LabelLavatrice() {

            img=new ImageIcon(new ImageIcon("Robotinho/src/img/lavatrice.png").getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));
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

        Nord=new JButton("Nord");
        Sud=new JButton("Sud");
        Est=new JButton("Est");
        Ovest=new JButton("Ovest");


        this.add(main, BorderLayout.CENTER);
        buttons=new JPanel();
        buttons.setLayout(new BorderLayout());
        buttons.add(Nord, BorderLayout.NORTH);
        buttons.add(Sud, BorderLayout.SOUTH);
        buttons.add(Ovest, BorderLayout.WEST);
        buttons.add(Est, BorderLayout.EAST);
        this.add(buttons, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public void addController(GameController controller){
        this.Nord.addActionListener(controller);
        this.Sud.addActionListener(controller);
        this.Ovest.addActionListener(controller);
        this.Est.addActionListener(controller);
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
                    this.map[i][j] = new LabelRobot();
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

}
