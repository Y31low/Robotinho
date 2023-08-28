import Game.Controller.GameController;
import Game.Model.*;
import Game.View.Gui;
import Game.View.GuiGioco;
import Game.View.GuiMappa;

import java.io.File;

/**
 * @author Adil Lagzouli 20045391
 * @author Samuele Giallorenzo 20045100
 * @author Federico Mannisi 20045099
 */

public class Main {
    public static void main(String[] args) {
        File f = new File("Robotinho/Robotinho/src/Livello/DimensioniLivello.txt");
        Gioco g= new Gioco(10);
        ThreadTempo threadTempo= new ThreadTempo(g);

        Gui guiMappa= new GuiMappa(g.getMappa(), g.getStatoCasella());
        Gui guiGioco = new GuiGioco(g.getMappa(), g.getStatoCasella());
        GameController controller = new GameController(g, threadTempo, guiGioco, guiMappa);
    }
}