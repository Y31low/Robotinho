import Game.Controller.GameController;
import Game.model.Mappa;
import Game.model.Gatto;
import Game.model.Robot;
import Game.view.GuiGioco;
import Game.view.GuiMappa;

public class Main {
    public static void main(String[] args) {
        Mappa m = new Mappa();
        Robot r = (Robot) m.getRobot();
        Gatto gatto = (Gatto) m.getGatto();


        GuiMappa g = new GuiMappa(m, m.getStatoPavimento());
        GuiGioco g2= new GuiGioco(m, m.getStatoPavimento());
        GameController controller = new GameController(gatto, r, m, g,g2);
    }
}