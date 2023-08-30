package Game.Controller;

import Game.Model.*;
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

    private final Mappa m;
    private final Robot r;
    private final Gatto g;
    private final VistaInterface guiGioco;
    private final VistaInterface guiMappa;
    private final ThreadTempo threadTempo;

    public GameController(Mappa m, ThreadTempo threadTempo, VistaInterface guiGioco,VistaInterface guiMappa) {
        this.m = m;
        this.r=m.getRobot();
        this.g =m.getGatto();
        this.threadTempo = threadTempo;
        this.guiGioco=guiGioco;
        this.guiMappa=guiMappa;
        this.guiGioco.addController(this);
        this.guiMappa.addController(this);
        this.guiGioco.visualizzaStato(m.getStatoMappa().get(this.m.getRobot().getPosizione()).getStato());
        this.guiMappa.visualizzaStato(this.m.getStatoMappa().get(this.m.getRobot().getPosizione()).getStato());
        threadTempo.addObserver(this);
        threadTempo.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Avanza":
                try {
                    r.Avanza(m.getMappa());
                    r.discover(m.getStatoMappa());
                    g.Avanza(m.getMappa());
                } catch (Robot.IllegalMoveException exc) {
                    guiGioco.errore(exc.getMessage());
                    guiMappa.errore(exc.getMessage());
                }
                break;
            case "Dx":
                r.giraDx();
                g.Avanza(m.getMappa());

                guiMappa.updateLabelRobot(m.getRobot().getDirezione());
                guiGioco.updateLabelRobot(m.getRobot().getDirezione());

                break;
            case "Sx":
                r.giraSx();
                g.Avanza(m.getMappa());
                guiMappa.updateLabelRobot(m.getRobot().getDirezione());
                guiGioco.updateLabelRobot(m.getRobot().getDirezione());
                break;
            case "Asciuga":
                try {
                    r.Asciuga(m.getStatoMappa());
                    g.Avanza(m.getMappa());
                } catch (Robot.IllegalActionException exc) {
                    guiGioco.errore(exc.getMessage());
                    guiMappa.errore(exc.getMessage());
                }
                break;
            case "Spegni":
                try {
                   Posizione p= r.spegniFornello(m.getMappa());
                   if(p!=null){
                       guiMappa.updateLabelFornello(p,false);
                       guiGioco.updateLabelFornello(p,false);

                   }
                   g.Avanza(m.getMappa());

                } catch (Robot.IllegalActionException exc) {
                    guiGioco.errore(exc.getMessage());
                    guiMappa.errore(exc.getMessage());
                }
                break;
            case "Aggiusta Lavatrice": {
                try {
                    Posizione p= r.interrompiLavatrice(m.getMappa());
                    if(p!=null){
                        guiGioco.updateLabelLavatrice(p,false);
                        guiMappa.updateLabelLavatrice(p,false);

                    }
                    g.Avanza(m.getMappa());

                } catch (Robot.IllegalActionException exc) {
                    guiGioco.errore(exc.getMessage());
                    guiMappa.errore(exc.getMessage());
                }
            }
            break;
            case "Aggiusta Rubinetto":
                try {
                    Posizione p= r.interrompiRubinetto(m.getMappa());
                    if(p!=null){
                        guiGioco.updateLabelRubinetto(p,false);
                        guiMappa.updateLabelRubinetto(p,false);

                    }
                    g.Avanza(m.getMappa());

                } catch (Robot.IllegalActionException exc) {
                    guiGioco.errore(exc.getMessage());
                    guiMappa.errore(exc.getMessage());
                }
                break;
            case "Visualizza":
                guiMappa.visible();
                g.Avanza(m.getMappa());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + e.getActionCommand());
        }
        m.aggiornaRobot();
        m.aggiornaGatto();

        Posizione p;
        p=Rubinetto.rompiRubinettoRandom();
        if (p!=null){
            guiGioco.updateLabelRubinetto(p,true);
            guiMappa.updateLabelRubinetto(p,true);
        }

        p= Lavatrice.rompiLavatriceRandom();
        if (p!=null){
            guiGioco.updateLabelLavatrice(p,true);
            guiMappa.updateLabelLavatrice(p,true);
        }
        guiMappa.visualizzaStato(m.getStatoMappa().get(m.getRobot().getPosizione()).getStato());
        guiMappa.refresh(m, m.getStatoMappa());
        guiGioco.visualizzaStato(m.getStatoMappa().get(m.getRobot().getPosizione()).getStato());
        guiGioco.refresh(m, m.getStatoMappa());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Posizione p;
        if (evt.getPropertyName().equals("TimerRubinetto")) {
            guiGioco.refresh(m, m.getStatoMappa());
            guiMappa.refresh(m, m.getStatoMappa());
        }

        if (evt.getPropertyName().equals("TimerLavatrice")) {
            guiGioco.refresh(m, m.getStatoMappa());
            guiMappa.refresh(m, m.getStatoMappa());
        }

        if (evt.getPropertyName().equals("TimerFornello")) {
            p=(Posizione) evt.getNewValue();
            guiGioco.updateLabelFornello(p, true);
            guiMappa.updateLabelFornello(p, true);
            guiGioco.refresh(m, m.getStatoMappa());
            guiMappa.refresh(m, m.getStatoMappa());
        }
    }
}