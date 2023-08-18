package Game.Controller;

import Game.Model.*;
import Game.View.VistaInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Collection;
import java.util.HashSet;

public class GameController implements ActionListener, PropertyChangeListener {
    private Gioco g;
    private Collection<VistaInterface> views;
    private ThreadTempo threadTempo;

    public GameController(Gioco g, ThreadTempo threadTempo,VistaInterface... views){
        this.g=g;
        this.views= new HashSet<>();
        this.threadTempo=threadTempo;
        for (VistaInterface view:views) {
            this.views.add(view);
            view.addController(this);
            view.visualizzaStato(g.getStatoCasella().get(g.getRobot().getPosizione()).getStato());
        }
        threadTempo.addObserver(this);
        threadTempo.run();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "Avanza":
                try {
                    g.avanza();
                }
                catch (Robot.IllegalMoveException exc){
                    for (VistaInterface view: views) {
                        view.errore(exc.getMessage());
                    }
                }
                break;
            case "Dx":
                g.giraDx();
                for (VistaInterface view: views) {
                    view.updateLabelRobot(g.getRobot().getDirezione());
                }
                break;
            case "Sx":
                g.giraSx();
                for (VistaInterface view: views) {
                    view.updateLabelRobot(g.getRobot().getDirezione());
                }
                break;
            case "Asciuga":
                try {
                    g.asciuga();
                }
                catch (Robot.IllegalActionException exc){
                    for (VistaInterface view: views) {
                        view.errore(exc.getMessage());
                    }
                }
                break;
            case "Spegni":
                try {
                    g.spegniFornello();
                    for (VistaInterface view : views) {
                        view.updateLabelFornello(false);
                    }
                }
                catch (Robot.IllegalActionException exc) {
                    for (VistaInterface view : views) {
                        view.errore(exc.getMessage());
                    }
                }
                break;
            case "Aggiusta Lavatrice":
            {
                try{
                    g.aggiustaPerditaLavatrice();
                    for (VistaInterface view : views) {
                        view.updateLabelLavatrice(false);
                    }
                }
                catch(Robot.IllegalActionException exc){
                    for (VistaInterface view : views) {
                        view.errore(exc.getMessage());
                    }
                }
            }
            break;
            case "Aggiusta Rubinetto":
                try{
                    g.aggiustaPerditaRubinetto();
                    for (VistaInterface view : views) {
                        view.updateLabelRubinetto(false);
                    }
                }
                catch(Robot.IllegalActionException exc){
                    for (VistaInterface view : views) {
                        view.errore(exc.getMessage());
                    }
                }
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + e.getActionCommand());
        }

        for (VistaInterface view: views) {
            view.visualizzaStato(g.getStatoCasella().get(g.getRobot().getPosizione()).getStato());
            view.refresh(g.getMappa(), g.getStatoCasella());
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("TimerRubinetto")){
            for (VistaInterface view: views) {
                view.updateLabelRubinetto(true);
            }
        }
        if (evt.getPropertyName().equals("TimerLavatrice")){
            for (VistaInterface view: views) {
                view.updateLabelLavatrice(true);
            }

        }
        if (evt.getPropertyName().equals("TimerFornello")){
            for (VistaInterface view: views) {
                view.updateLabelFornello(true);
            }
        }
        for (VistaInterface view: views) {
            view.refresh(g.getMappa(), g.getStatoCasella());
        }
    }
}