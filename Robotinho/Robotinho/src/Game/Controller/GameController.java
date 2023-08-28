package Game.Controller;

import Game.Model.Gioco;
import Game.Model.Posizione;
import Game.Model.Robot;
import Game.Model.ThreadTempo;
import Game.View.VistaInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * @author Adil Lagzouli 20045391
 * @author Samuele Giallorenzo 20045100
 * @author Federico Mannisi 20045099
 */

public class GameController implements ActionListener, PropertyChangeListener {
    private final Gioco g;
    private final VistaInterface guiGioco;
    private final VistaInterface guiMappa;
    private final ThreadTempo threadTempo;

    public GameController(Gioco g, ThreadTempo threadTempo, VistaInterface guiGioco,VistaInterface guiMappa) {
        this.g = g;
        this.threadTempo = threadTempo;
        this.guiGioco=guiGioco;
        this.guiMappa=guiMappa;
        this.guiGioco.addController(this);
        this.guiMappa.addController(this);
        this.guiGioco.visualizzaStato(g.getStatoCasella().get(g.getRobot().getPosizione()).getStato());
        this.guiMappa.visualizzaStato(g.getStatoCasella().get(g.getRobot().getPosizione()).getStato());
        threadTempo.addObserver(this);
        threadTempo.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Avanza":
                try {
                    g.avanza();
                } catch (Robot.IllegalMoveException exc) {
                    guiGioco.errore(exc.getMessage());
                    guiMappa.errore(exc.getMessage());
                }
                break;
            case "Dx":
                g.giraDx();

                guiMappa.updateLabelRobot(g.getRobot().getDirezione());
                guiGioco.updateLabelRobot(g.getRobot().getDirezione());

                break;
            case "Sx":
                g.giraSx();
                guiMappa.updateLabelRobot(g.getRobot().getDirezione());
                guiGioco.updateLabelRobot(g.getRobot().getDirezione());
                break;
            case "Asciuga":
                try {
                    g.asciuga();
                } catch (Robot.IllegalActionException exc) {
                    guiGioco.errore(exc.getMessage());
                    guiMappa.errore(exc.getMessage());
                }
                break;
            case "Spegni":
                try {
                   Posizione p=g.spegniFornello();
                   if(p!=null){

                       guiMappa.updateLabelFornello(p,false);
                       guiGioco.updateLabelFornello(p,false);

                   }

                } catch (Robot.IllegalActionException exc) {
                    guiGioco.errore(exc.getMessage());
                    guiMappa.errore(exc.getMessage());
                }
                break;
            case "Aggiusta Lavatrice": {
                try {
                    Posizione p=g.aggiustaPerditaLavatrice();
                    if(p!=null){
                        guiGioco.updateLabelLavatrice(p,false);
                        guiMappa.updateLabelLavatrice(p,false);

                    }

                } catch (Robot.IllegalActionException exc) {
                    guiGioco.errore(exc.getMessage());
                    guiMappa.errore(exc.getMessage());
                }
            }
            break;
            case "Aggiusta Rubinetto":
                try {
                    Posizione p=g.aggiustaPerditaRubinetto();
                    if(p!=null){
                        guiGioco.updateLabelRubinetto(p,false);
                        guiMappa.updateLabelRubinetto(p,false);

                    }

                } catch (Robot.IllegalActionException exc) {
                    guiGioco.errore(exc.getMessage());
                    guiMappa.errore(exc.getMessage());
                }
                break;
            case "Visualizza":
                guiMappa.visible();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + e.getActionCommand());
        }

        guiMappa.visualizzaStato(g.getStatoCasella().get(g.getRobot().getPosizione()).getStato());
        guiMappa.refresh(g.getMappa(), g.getStatoCasella());
        guiGioco.visualizzaStato(g.getStatoCasella().get(g.getRobot().getPosizione()).getStato());
        guiGioco.refresh(g.getMappa(), g.getStatoCasella());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Posizione p;
        if (evt.getPropertyName().equals("TimerRubinetto")) {
            p=(Posizione) evt.getNewValue();
            guiGioco.updateLabelRubinetto(p,true);
            guiMappa.updateLabelRubinetto(p,true);
            guiGioco.refresh(g.getMappa(), g.getStatoCasella());
            guiMappa.refresh(g.getMappa(), g.getStatoCasella());
        }

        if (evt.getPropertyName().equals("TimerLavatrice")) {
            p=(Posizione) evt.getNewValue();
            guiGioco.updateLabelLavatrice(p,true);
            guiMappa.updateLabelLavatrice(p,true);
            guiGioco.refresh(g.getMappa(), g.getStatoCasella());
            guiMappa.refresh(g.getMappa(), g.getStatoCasella());
        }

        if (evt.getPropertyName().equals("TimerFornello")) {
            p=(Posizione) evt.getNewValue();

            guiGioco.updateLabelFornello(p, true);
            guiMappa.updateLabelFornello(p, true);
            guiGioco.refresh(g.getMappa(), g.getStatoCasella());
            guiMappa.refresh(g.getMappa(), g.getStatoCasella());
        }
    }
}