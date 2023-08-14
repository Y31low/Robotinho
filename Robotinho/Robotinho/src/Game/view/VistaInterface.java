package Game.view;

import Game.Controller.GameController;
import Game.model.Direzione;
import Game.model.Mappa;
import Game.model.StatoCasella;

import java.util.ArrayList;

public interface VistaInterface {

     void refresh(Mappa m, ArrayList<StatoCasella> bagnato);

     void updateLabelRobot(Direzione d);

     void visible();

     void addController(GameController controller);

     void bump();

}
