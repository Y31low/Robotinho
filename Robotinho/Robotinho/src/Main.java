import Game.Controller.GameController;
import Game.Model.*;
import Game.View.GuiGioco;
import Game.View.GuiMappa;

public class Main {
    public static void main(String[] args) {
        Gioco g= new Gioco(10);
        ThreadTempo threadTempo= new ThreadTempo(g);
        GuiMappa u = new GuiMappa(g.getMappa(), g.getStatoCasella());
        GuiGioco e = new GuiGioco(g.getMappa(), g.getStatoCasella());
        GameController controller = new GameController(g, threadTempo, u, e);
    }
}