package Game.Controller;

import Game.model.Gatto;
import Game.model.Mappa;
import Game.model.Robot;
import Game.view.VistaInterface;

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
                    m.aggiornaMappa();
                    for (VistaInterface view: views
                    ){
                        view.refresh(m, m.getStatoPavimento());
                    }
                }
                catch (Robot.IllegalMoveException exc){
                    for (VistaInterface view: views
                    ) {
                        view.bump();
                    }
                }
                break;
            case "Dx":
                model.giraDx();
                for (VistaInterface view: views
                     ) {
                    view.updateLabelRobot(model.getDirezione());
                    view.refresh(m, m.getStatoPavimento());

                }

                break;
            case "Sx":
                model.giraSx();
                for (VistaInterface view: views
                ) {
                    view.updateLabelRobot(model.getDirezione());
                    view.refresh(m, m.getStatoPavimento());

                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + e.getActionCommand());
        }
        gatto.Avanza(m);
        m.aggiornaMappa();
        for (VistaInterface view: views
        ) {
            view.refresh(m, m.getStatoPavimento());

        }
    }
}

