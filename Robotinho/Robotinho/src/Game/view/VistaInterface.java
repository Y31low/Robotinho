package Game.view;

import Game.Controller.GameController;
import Game.model.Direzione;
import Game.model.Mappa;

public interface VistaInterface {



     void refresh(Mappa m);

     void updateLabelRobot(Direzione d);

     void visible();

     void addController(GameController controller);

     void bump();

}
