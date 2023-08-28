package Game.View;

import Game.Model.*;
import java.awt.*;
import java.util.HashMap;

/**
 * @author Adil Lagzouli 20045391
 * @author Samuele Giallorenzo 20045100
 * @author Federico Mannisi 20045099
 */

public class GuiMappa extends Gui implements VistaInterface{
    public GuiMappa(Mappa m, HashMap<Posizione, StatoCasella> bagnato) throws HeadlessException {
        super(m,bagnato);
        invisible();
    }

    private void invisible() {
        this.setVisible(false);
    }

}
