package Controller;

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
        this.m=m;
        this.model = model;
        this.gatto = gatto;
        this.view = view;
        this.view.addController(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Nord":
                model.Avanza(Direzione.North);
                break;
            case "Sud":
                model.Avanza(Direzione.South);
                break;
            case "Est":
                model.Avanza(Direzione.East);
                break;
            case "Ovest":
                model.Avanza(Direzione.West);
                break;
        }
        m.aggiornaMappa();
        view.refresh(m);
    }
}

