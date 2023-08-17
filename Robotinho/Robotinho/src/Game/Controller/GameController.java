package Game.Controller;

import Game.Model.Gatto;
import Game.Model.Mappa;
import Game.Model.Robot;
import Game.View.VistaInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.HashSet;

public class GameController implements ActionListener {
    private Robot model;
    private Gatto gatto;
    private Mappa m;
    private Collection<VistaInterface> views;

    public GameController(Gatto gatto, Robot model, Mappa m, VistaInterface... views){
        this.m = m;
        this.model = model;
        this.gatto = gatto;
        this.views= new HashSet<>();
        for (VistaInterface view:views
             ) {
            this.views.add(view);
            view.addController(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Avanza":
                try {
                    model.Avanza(m);
                }
                catch (Robot.IllegalMoveException exc){
                    for (VistaInterface view: views
                    ) {
                        view.errore("Che male!");
                    }
                }
                break;
            case "Dx":
                model.giraDx();
                for (VistaInterface view: views
                     ) {
                    view.updateLabelRobot(model.getDirezione());

                }

                break;
            case "Sx":
                model.giraSx();
                for (VistaInterface view: views
                ) {
                    view.updateLabelRobot(model.getDirezione());

                }
                break;
            case "Asciuga":
                try {
                    model.Asciuga(m.getStatoPavimento());
                }
                catch (Robot.IllegalActionException exc){
                    for (VistaInterface view: views
                    ) {
                        view.errore("E' gia' asciutto coglione!");
                    }
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + e.getActionCommand());
        }
        gatto.Avanza(m);
        m.aggiornaMappa();
        for (VistaInterface view: views) {
            view.refresh(m, m.getStatoPavimento());
        }
    }
}

