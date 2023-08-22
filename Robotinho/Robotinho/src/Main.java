import Game.Controller.GameController;
import Game.Model.*;
import Game.View.Gui;
import Game.View.GuiGioco;
import Game.View.GuiMappa;

import java.io.File;

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