import Controller.GameController;
import Game.model.Direzione;
import Game.model.Mappa;
import Game.model.Robot;
import Game.view.GuiMappa;

public class Main {
    public static void main(String[] args) {

        Mappa m =  new Mappa();
        Robot r = (Robot) m.getRobot();
        GuiMappa g = new GuiMappa(m);
        GameController controller = new GameController(r, m, g);
    }
}