package Game.View;

import Game.Controller.GameController;
import Game.Model.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class GuiMappa extends JFrame implements VistaInterface {
    private final JPanel main;
    private final JPanel buttons;
    private final JPanel infoCasella;
    private final JButton dx;
    private final JButton sx;
    private final LabelRobot R;
    private final HashMap<Posizione, LabelFornello>F;
    private final HashMap<Posizione,LabelLavatrice> L;
    private final HashMap<Posizione,LabelRubinetto> rubinetto;
    private final JButton avanza;
    private final JButton spegni;
    private final JButton asciuga;
    private final JButton aggiustaLavatrice;
    private final JButton aggiustaRubinetto;
    private final JLabel statoCasella;

    private final JLabel[][] map;

    public GuiMappa(Mappa m, HashMap<Posizione, StatoCasella> bagnato) throws HeadlessException {

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
        this.F = new HashMap<>();
        this.L = new HashMap<>();
        this.rubinetto = new HashMap<>();

        main.setLayout(new GridLayout(m.getDim(), m.getDim()));


        for (int i = 0; i < m.getDim(); i++) {
            for (int j = 0; j < m.getDim(); j++) {
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
                        F.put(new Posizione(i,j),new LabelFornello());
                        this.map[i][j] = F.get(new Posizione(i,j));
                        break;
                    case "Lavatrice":
                        L.put(new Posizione(i,j),new LabelLavatrice());
                        this.map[i][j] = L.get(new Posizione(i,j));
                        break;
                    case "Rubinetto":
                        rubinetto.put(new Posizione(i,j),new LabelRubinetto());
                        this.map[i][j] = rubinetto.get(new Posizione(i,j));
                        break;
                    default:
                        break;
                }
                main.add(this.map[i][j]);
            }
        }

        main.setVisible(true);

        dx = new JButton("Dx");
        sx = new JButton("Sx");
        avanza = new JButton("Avanza");
        spegni = new JButton("Spegni");
        asciuga = new JButton("Asciuga");
        aggiustaLavatrice = new JButton("Aggiusta Lavatrice");
        aggiustaRubinetto=new JButton("Aggiusta Rubinetto");

        this.add(main, BorderLayout.CENTER);
        buttons = new JPanel();
        buttons.setLayout(new GridLayout(2,0));
        buttons.add(sx);
        buttons.add(avanza);
        buttons.add(dx);
        buttons.add(spegni);
        buttons.add(asciuga);
        buttons.add(aggiustaLavatrice);
        buttons.add(aggiustaRubinetto);
        this.add(buttons, BorderLayout.SOUTH);

        this.infoCasella = new JPanel();
        this.infoCasella.setLayout(new BorderLayout());

        this.statoCasella = new JLabel("-", SwingConstants.CENTER);
        this.infoCasella.add(this.statoCasella, BorderLayout.CENTER);
        this.add(statoCasella, BorderLayout.NORTH);

        visible();
    }

    @Override
    public void visible() {
        this.setVisible(true);
    }

    @Override
    public void refresh(Mappa m, HashMap<Posizione, StatoCasella> bagnato) {
        main.removeAll();
        StatoCasella stato = null;

        for (int i = 0; i <m.getDim(); i++) {
            for (int j = 0; j < m.getDim(); j++) {
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
                        this.map[i][j] = F.get(new Posizione(i,j));
                        break;
                    case "Lavatrice":
                        this.map[i][j] = L.get(new Posizione(i,j));
                        break;
                    case "Rubinetto":
                        this.map[i][j] = rubinetto.get(new Posizione(i,j));
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

    public synchronized void updateLabelFornello(boolean acceso) {
        //this.F.setAcceso(acceso);
    }

    @Override
    public synchronized void updateLabelLavatrice(boolean rotta) {
       // this.L.setRotta(rotta);
    }

    public synchronized void updateLabelRubinetto(boolean rotto){
        //this.rubinetto.setRotto(rotto);
    }

    public void addController(GameController controller) {
        this.avanza.addActionListener(controller);
        this.dx.addActionListener(controller);
        this.sx.addActionListener(controller);
        this.asciuga.addActionListener(controller);
        this.aggiustaLavatrice.addActionListener(controller);
        this.aggiustaRubinetto.addActionListener(controller);
        this.spegni.addActionListener(controller);
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

    @Override
    public void visualizzaStato(boolean stato) {
        if(!stato)
            this.statoCasella.setText("Sei su una casella asciutta");
        else
            this.statoCasella.setText("Sei su una casella bagnata");
    }


}
