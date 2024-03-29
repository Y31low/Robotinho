package Game.View;

import Game.Controller.GameController;
import Game.Model.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/**
 * @author Adil Lagzouli 20045391
 * @author Samuele Giallorenzo 20045100
 * @author Federico Mannisi 20045099
 */

public class Gui extends JFrame implements VistaInterface{
    protected JPanel main;
    protected JPanel buttons;
    protected JButton dx;
    protected JButton sx;
    protected LabelRobot R;
    protected HashMap<Posizione, LabelFornello> F;
    protected HashMap<Posizione, LabelLavatrice> L;
    protected HashMap<Posizione, LabelRubinetto> rubinetto;
    protected JButton avanza;
    protected JButton spegni;
    protected JButton asciuga;
    protected JButton aggiustaLavatrice;
    protected JButton aggiustaRubinetto;
    protected JLabel statoCasella;
    protected JPanel infoCasella;
    protected JLabel[][] map;

public Gui(Mappa m, HashMap<Posizione, StatoCasella> bagnato) throws HeadlessException {
        super("Robotinho");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.map = new JLabel[m.getDim()][m.getDim()];
        this.main = new JPanel();

        this.R = new LabelRobot();
        this.F = new HashMap<>();
        this.L = new HashMap<>();
        this.rubinetto = new HashMap<>();

        main.setLayout(new GridLayout(m.getDim(), m.getDim()));


        creaMappa(m,bagnato);

        refresh(m,bagnato);

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
    public synchronized void refresh(Mappa m, HashMap<Posizione, StatoCasella> bagnato) {
        main.removeAll();
        this.map = updateMapLabels(m,bagnato);
        for (JLabel[] jLabels : map) {
            for (JLabel jLabel : jLabels) {
                main.add(jLabel);
            }
        }

        main.updateUI();
    }

    @Override
    public void updateLabelRobot(Direzione d) {
        this.R.setDir(d);
    }

    public synchronized void updateLabelFornello(Posizione p,boolean acceso) {
        this.F.get(p).setAcceso(acceso);
    }

    @Override
    public synchronized void updateLabelLavatrice(Posizione p,boolean rotta) {
        this.L.get(p).setRotta(rotta);
    }

    @Override
    public synchronized void updateLabelRubinetto(Posizione p,boolean rotto){
        this.rubinetto.get(p).setRotto(rotto);
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
        if(this.isVisible()){
            JDialog dialog = new JDialog(this);
            JLabel content = new JLabel(s);
            content.setHorizontalAlignment(SwingConstants.CENTER);
            dialog.add(content);
            dialog.setSize(300, 100);
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        }

    }

    @Override
    public void visualizzaStato(boolean stato) {
        if(!stato)
            this.statoCasella.setText("Sei su una casella asciutta");
        else
            this.statoCasella.setText("Sei su una casella bagnata");
    }

    public Label selectLabel(Casella m, HashMap<Posizione, StatoCasella> bagnato){
        Label label;
        boolean stato;

        switch(m.tipo()){
            case "Muro":
                label = new LabelMuro();
                break;
            case "Pavimento":
                stato = bagnato.get(new Posizione(m.getPosizione().getX(), m.getPosizione().getY())).getStato();
                if (stato)
                    label = new LabelBagnato();
                else
                    label = new LabelPavimento();
                break;
            case "Robot":
                label = R;
                break;
            case "Gatto":
                label = new LabelGatto();
                break;
            case "Fornello":
                label = F.get(new Posizione(m.getPosizione().getX(), m.getPosizione().getY()));
                break;
            case "Lavatrice":
                label = L.get(new Posizione(m.getPosizione().getX(), m.getPosizione().getY()));
                break;
            case "Rubinetto":
                label = rubinetto.get(new Posizione(m.getPosizione().getX(), m.getPosizione().getY()));
                break;
            default:
                label = new LabelSconosciuto();
                break;
        }

        return label;
    }

    public Label[][] updateMapLabels(Mappa m, HashMap<Posizione, StatoCasella> bagnato) {
        Label[][] mappa = new Label[m.getDim()][m.getDim()];

        for (int i = 0; i < mappa.length; i++) {
            for (int j = 0; j < mappa[i].length; j++) {
                mappa[i][j] = selectLabel(m.getMappa()[i][j], bagnato);
            }
        }

        return mappa;
    }


    protected void creaMappa(Mappa m, HashMap<Posizione, StatoCasella> bagnato) {
        StatoCasella stato;
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
            }
        }
    }
}
