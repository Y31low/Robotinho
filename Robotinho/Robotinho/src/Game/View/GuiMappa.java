package Game.View;

import Game.Controller.GameController;
import Game.Model.Direzione;
import Game.Model.Mappa;
import Game.Model.Posizione;
import Game.Model.StatoCasella;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

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

    public GuiMappa(Mappa m, HashMap<Posizione,StatoCasella> bagnato) throws HeadlessException {

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
        for (int i = 0; i < m.getMappa().length; i++) {
            for (int j = 0; j < m.getMappa()[i].length; j++) {
                switch (m.getMappa()[i][j].tipo()) {
                    case "Muro":
                        this.map[i][j] = new LabelMuro();
                        break;
                    case "Pavimento":
                        stato = bagnato.get(new Posizione(i, j));
                        if (stato != null) {
                            if (stato.getStato())
                                this.map[i][j] = new LabelBagnato();
                            else
                                this.map[i][j] = new LabelPavimento();
                        }
                        break;
                    case "Robot":
                        this.map[i][j] = R;
                        break;
                    case "Cat":
                        this.map[i][j] = new LabelGatto();
                        break;
                    case "Fornello":
                        this.map[i][j] = new LabelFornello();
                        break;
                    case "Lavatrice":
                        this.map[i][j] = new LabelLavatrice();
                        break;
                    case "Rubinetto":
                        this.map[i][j] = new LabelRubinetto();
                        break;
                    default:
                        break;
                }
                main.add(this.map[i][j]);
            }
        }


        dx = new JButton("Dx");
        sx = new JButton("Sx");
        avanza = new JButton("Avanza");
        spegni = new JButton("Spegni Fornello");
        asciuga = new JButton("Asciuga");

        this.add(main, BorderLayout.CENTER);
        buttons = new JPanel();
        buttons.setLayout(new BorderLayout());
        buttons.add(avanza, BorderLayout.CENTER);
        buttons.add(sx, BorderLayout.WEST);
        buttons.add(dx, BorderLayout.EAST);
        buttons.add(spegni, BorderLayout.NORTH);
        buttons.add(asciuga, BorderLayout.SOUTH);
        this.add(buttons, BorderLayout.SOUTH);


        visible();
    }

    @Override
    public void visible() {
        this.setVisible(true);
    }

    @Override
    public void refresh(Mappa m, HashMap<Posizione,StatoCasella> bagnato) {
        main.removeAll();
        StatoCasella stato = null;

        for (int i = 0; i < m.getMappa().length; i++) {
            for (int j = 0; j < m.getMappa()[i].length; j++) {
                switch (m.getMappa()[i][j].tipo()) {
                    case "Muro":
                        this.map[i][j] = new LabelMuro();
                        break;
                    case "Pavimento":
                        stato = bagnato.get(new Posizione(i, j));
                        if (stato != null) {
                            if (stato.getStato())
                                this.map[i][j] = new LabelBagnato();
                            else
                                this.map[i][j] = new LabelPavimento();
                        }
                        break;
                    case "Robot":
                        this.map[i][j] = R;
                        break;
                    case "Cat":
                        this.map[i][j] = new LabelGatto();
                        break;
                    case "Fornello":
                        this.map[i][j] = new LabelFornello();
                        break;
                    case "Lavatrice":
                        this.map[i][j] = new LabelLavatrice();
                        break;
                    case "Rubinetto":
                        this.map[i][j] = new LabelRubinetto();
                        break;
                    default:
                        break;
                }
                main.add(this.map[i][j]);
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
        this.asciuga.addActionListener(controller);
    }

    @Override
    public void errore(String s) {
        JDialog dialog = new JDialog(this);
        JLabel content = new JLabel(s);
        content.setHorizontalAlignment(SwingConstants.CENTER);
        dialog.add(content);
        dialog.setSize(300, 100);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}
