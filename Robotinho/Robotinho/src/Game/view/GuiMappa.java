package Game.view;

import Game.Controller.GameController;
import Game.model.Direzione;
import Game.model.Mappa;
import Game.model.Posizione;
import Game.model.StatoCasella;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GuiMappa extends JFrame implements VistaInterface {
    private final JPanel main;
    private final JPanel buttons;
    private final JButton dx;
    private final JButton sx;
    private final LabelRobot R;
    private final JButton avanza;
    private final JButton spegni;
    private final JButton asciuga;

    private JLabel[][] map;

    public GuiMappa(Mappa m, ArrayList<StatoCasella> bagnato) throws HeadlessException {

        super("Robotinho");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.map = new JLabel[m.getDim()][m.getDim()];
        this.main = new JPanel();

        StatoCasella stato = null;

        this.R = new LabelRobot();
        main.setLayout(new GridLayout(m.getDim(), m.getDim()));
        main.setVisible(true);
        for (int i = 0; i < m.getDim(); i++) {
            for (int j = 0; j < m.getDim(); j++) {
                if (m.getMappa()[i][j].toString().equals("Muro")) {
                    this.map[i][j] = new LabelMuro();
                    main.add(this.map[i][j]);
                } else if (m.getMappa()[i][j].toString().equals("Pavimento")) {
                    for(StatoCasella s : bagnato) {
                        if(s.getPosizione().equals(new Posizione(i, j)))
                            stato = s;
                    }
                    if(stato != null){
                        if(stato.getStato())
                            this.map[i][j] = new LabelBagnato();
                    }
                    else
                        this.map[i][j] = new LabelPavimento();

                    main.add(this.map[i][j]);

                } else if (m.getMappa()[i][j].toString().equals("Robot")) {
                    this.map[i][j] = new LabelRobot();
                    main.add(this.map[i][j]);
                } else if (m.getMappa()[i][j].toString().equals("Cat")) {
                    this.map[i][j] = new LabelGatto();
                    main.add(this.map[i][j]);
                } else if (m.getMappa()[i][j].toString().equals("Fornello")) {
                    this.map[i][j] = new LabelFornello();
                    main.add(this.map[i][j]);
                } else if (m.getMappa()[i][j].toString().equals("Lavatrice")) {
                    this.map[i][j] = new LabelLavatrice();
                    main.add(this.map[i][j]);
                } else if (m.getMappa()[i][j].toString().equals("Rubinetto")) {
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
        buttons.add(avanza, BorderLayout.CENTER);
        buttons.add(sx, BorderLayout.WEST);
        buttons.add(dx, BorderLayout.EAST);
        //buttons.add(spegni, BorderLayout.AFTER_LAST_LINE);
        //buttons.add(asciuga, BorderLayout.BEFORE_FIRST_LINE);
        this.add(buttons, BorderLayout.SOUTH);


        visible();
    }

    @Override
    public void visible() {
        this.setVisible(true);
    }

    @Override
    public void refresh(Mappa m, ArrayList<StatoCasella> bagnato) {
        main.removeAll();
        StatoCasella stato = null;

        for (int i = 0; i < m.getDim(); i++) {
            for (int j = 0; j < m.getDim(); j++) {
                if (m.getMappa()[i][j].toString().equals("Muro")) {
                    this.map[i][j] = new LabelMuro();
                    main.add(this.map[i][j]);
                }
                if (m.getMappa()[i][j].toString().equals("Pavimento")) {
                    for(StatoCasella s : bagnato) {
                        if(s.getPosizione().equals(new Posizione(i, j)))
                            stato = s;
                    }
                    if(stato != null){
                        if(stato.getStato())
                            this.map[i][j] = new LabelBagnato();
                    }
                    else
                        this.map[i][j] = new LabelPavimento();

                    main.add(this.map[i][j]);
                }
                if (m.getMappa()[i][j].toString().equals("Robot")) {
                    this.map[i][j] = this.R;
                    main.add(this.map[i][j]);
                }
                if (m.getMappa()[i][j].toString().equals("Cat")) {
                    this.map[i][j] = new LabelGatto();
                    main.add(this.map[i][j]);
                }
                if (m.getMappa()[i][j].toString().equals("Fornello")) {
                    this.map[i][j] = new LabelFornello();
                    main.add(this.map[i][j]);
                }
                if (m.getMappa()[i][j].toString().equals("Lavatrice")) {
                    this.map[i][j] = new LabelLavatrice();
                    main.add(this.map[i][j]);
                }
                if (m.getMappa()[i][j].toString().equals("Rubinetto")) {
                    this.map[i][j] = new LabelRubinetto();
                    main.add(this.map[i][j]);
                }
            }
        }
        main.updateUI();
    }

    @Override
    public void updateLabelRobot(Direzione d) {
        this.R.setDir(d);

    }

    public void addController(GameController controller) {
        this.avanza.addActionListener(controller);
        this.dx.addActionListener(controller);
        this.sx.addActionListener(controller);
    }

    @Override
    public void bump() {
        JDialog dialog = new JDialog(this);
        JLabel content = new JLabel("Che male!");
        content.setHorizontalAlignment(SwingConstants.CENTER);
        dialog.add(content);
        dialog.setSize(300, 100);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}
