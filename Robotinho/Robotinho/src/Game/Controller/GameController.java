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
import java.util.Collection;
import java.util.HashSet;

public class GameController implements ActionListener, PropertyChangeListener {
    private final Gioco g;
    private final Collection<VistaInterface> views;
    private final ThreadTempo threadTempo;

    public GameController(Gioco g, ThreadTempo threadTempo, VistaInterface... views) {
        this.g = g;
        this.views = new HashSet<>();
        this.threadTempo = threadTempo;
        for (VistaInterface view : views) {
            this.views.add(view);
            view.addController(this);
            view.visualizzaStato(g.getStatoCasella().get(g.getRobot().getPosizione()).getStato());
        }
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
                    for (VistaInterface view : views) {
                        view.errore(exc.getMessage());
                    }
                }
                break;
            case "Dx":
                g.giraDx();
                for (VistaInterface view : views) {
                    view.updateLabelRobot(g.getRobot().getDirezione());
                }
                break;
            case "Sx":
                g.giraSx();
                for (VistaInterface view : views) {
                    view.updateLabelRobot(g.getRobot().getDirezione());
                }
                break;
            case "Asciuga":
                try {
                    g.asciuga();
                } catch (Robot.IllegalActionException exc) {
                    for (VistaInterface view : views) {
                        view.errore(exc.getMessage());
                    }
                }
                break;
            case "Spegni":
                try {
                   Posizione p=g.spegniFornello();
                   if(p!=null){
                       for (VistaInterface view : views) {
                           view.updateLabelFornello(p,false);
                       }
                   }

                } catch (Robot.IllegalActionException exc) {
                    for (VistaInterface view : views) {
                        view.errore(exc.getMessage());
                    }
                }
                break;
            case "Aggiusta Lavatrice": {
                try {
                    Posizione p=g.aggiustaPerditaLavatrice();
                    if(p!=null){
                        for (VistaInterface view : views) {
                            view.updateLabelLavatrice(p,false);
                        }
                    }

                } catch (Robot.IllegalActionException exc) {
                    for (VistaInterface view : views) {
                        view.errore(exc.getMessage());
                    }
                }
            }
            break;
            case "Aggiusta Rubinetto":
                try {
                    Posizione p=g.aggiustaPerditaRubinetto();
                    if(p!=null){
                        for (VistaInterface view : views) {
                            view.updateLabelRubinetto(p,false);
                        }
                    }

                } catch (Robot.IllegalActionException exc) {
                    for (VistaInterface view : views) {
                        view.errore(exc.getMessage());
                    }
                }
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + e.getActionCommand());
        }

        for (VistaInterface view : views) {
            view.visualizzaStato(g.getStatoCasella().get(g.getRobot().getPosizione()).getStato());
            view.refresh(g.getMappa(), g.getStatoCasella());
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Posizione p;
        if (evt.getPropertyName().equals("TimerRubinetto")) {
            for (VistaInterface view : views) {
                p=(Posizione) evt.getNewValue();
                view.updateLabelRubinetto(p,true);
                view.refresh(g.getMappa(), g.getStatoCasella());
            }
        }
        if (evt.getPropertyName().equals("TimerLavatrice")) {
            p=(Posizione) evt.getNewValue();
            for (VistaInterface view : views) {
                view.updateLabelLavatrice(p,true);
                view.refresh(g.getMappa(), g.getStatoCasella());
            }

        }
        if (evt.getPropertyName().equals("TimerFornello")) {
            p=(Posizione) evt.getNewValue();
            for (VistaInterface view : views) {
                view.updateLabelFornello(p, true);
                view.refresh(g.getMappa(), g.getStatoCasella());
            }
        }

    }
}