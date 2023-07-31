package Game.Controller;

import Game.model.Direzione;
import Game.model.Mappa;
import Game.model.Robot;
import Game.model.Gatto;
import Game.view.GuiMappa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController implements ActionListener {
    private Robot model;
    private Gatto gatto;
    private Mappa m;
    private GuiMappa view;

    public GameController(Gatto gatto, Robot model, Mappa m, GuiMappa view){
        this.m = m;
        this.model = model;
        this.gatto = gatto;
        this.view = view;
        this.view.addController(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean bump;
        switch (e.getActionCommand()) {
            case "Avanza":
                bump=model.Avanza(m);
                if (bump)
                    view.bump();
                else{
                    m.aggiornaMappa();
                    view.refresh(m);
                }
                break;
            case "Dx":
                model.giraDx();
                view.updateLabelRobot(model.getDirezione());
                view.refresh(m);
                break;
            case "Sx":
                model.giraSx();
                view.updateLabelRobot(model.getDirezione());
                view.refresh(m);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + e.getActionCommand());
        }
        gatto.Avanza(m);
        m.aggiornaMappa();
        view.refresh(m);
    }
}

