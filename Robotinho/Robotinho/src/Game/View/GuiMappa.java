package Game.View;

import Game.Model.*;
import java.awt.*;
import java.util.HashMap;

public class GuiMappa extends Gui implements VistaInterface{
    public GuiMappa(Mappa m, HashMap<Posizione, StatoCasella> bagnato) throws HeadlessException {
        super(m,bagnato);
        invisible();
    }

    private void invisible() {
        this.setVisible(false);
    }

}
