package Game.View;

import Game.Controller.GameController;
import Game.Model.Direzione;
import Game.Model.Mappa;
import Game.Model.Posizione;
import Game.Model.StatoCasella;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;



public class GuiGioco extends Gui implements VistaInterface {

    private final JButton visualizzaMappa;

    public GuiGioco(Mappa m, HashMap<Posizione, StatoCasella> bagnato) throws HeadlessException {
        super(m, bagnato);
        visualizzaMappa = new JButton("Visualizza");
        buttons.add(visualizzaMappa);
        this.add(buttons, BorderLayout.SOUTH);
        creaMappa(m,bagnato);
        refresh(m,bagnato);
        visible();
    }


    @Override
    public void addController(GameController controller) {
        this.avanza.addActionListener(controller);
        this.dx.addActionListener(controller);
        this.sx.addActionListener(controller);
        this.asciuga.addActionListener(controller);
        this.aggiustaLavatrice.addActionListener(controller);
        this.aggiustaRubinetto.addActionListener(controller);
        this.spegni.addActionListener(controller);
        this.visualizzaMappa.addActionListener(controller);
    }

    @Override
    public Label[][] updateMapLabels(Mappa m, HashMap<Posizione, StatoCasella> bagnato) {
        boolean stato;
        Label[][] mappa = new Label[m.getDim()][m.getDim()];

        for (int i = 0; i < mappa.length; i++) {
            for (int j = 0; j < mappa[i].length; j++) {
                if (m.getMappa()[i][j].isVisibile()) {
                    Label label;

                    switch (m.getMappa()[i][j].tipo()) {
                        case "Muro":
                            label = new LabelMuro();
                            break;
                        case "Pavimento":
                            stato = bagnato.get(new Posizione(i, j)).getStato();
                            if (stato)
                                label = new LabelBagnato();
                            else
                                label = new LabelPavimento();
                            break;
                        case "Robot":
                            label = R;
                            break;
                        case "Cat":
                            label = new LabelGatto();
                            break;
                        case "Fornello":
                            label = F.get(new Posizione(i, j));
                            break;
                        case "Lavatrice":
                            label = L.get(new Posizione(i, j));
                            break;
                        case "Rubinetto":
                            label = rubinetto.get(new Posizione(i, j));
                            break;
                        default:
                            label = new LabelSconosciuto();
                            break;
                    }

                    mappa[i][j] = label;
                } else {
                    mappa[i][j] = new LabelSconosciuto();
                }
            }
        }
        return mappa;
    }


}
