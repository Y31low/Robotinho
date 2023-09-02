import Game.Controller.GameController;
import Game.Model.Mappa;
import Game.Model.ThreadTempo;
import Game.View.Gui;
import Game.View.GuiGioco;
import Game.View.GuiMappa;

/**
 * @author Adil Lagzouli 20045391
 * @author Samuele Giallorenzo 20045100
 * @author Federico Mannisi 20045099
 */

public class Main {
    public static void main(String[] args) {

            //File f = new File("Robotinho/Robotinho/src/Livello/DimensioniLivello.txt");
            //Gioco g= new Gioco(f);
            Mappa m=new Mappa(10,2,3,2);
            ThreadTempo threadTempo= new ThreadTempo(m.getMappa(),m.getStatoMappa());

            Gui guiMappa= new GuiMappa(m, m.getStatoMappa());
            Gui guiGioco = new GuiGioco(m, m.getStatoMappa());
            GameController controller = new GameController(m, threadTempo, guiGioco, guiMappa);



    }
}