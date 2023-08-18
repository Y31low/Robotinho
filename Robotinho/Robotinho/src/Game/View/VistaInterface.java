package Game.View;

import Game.Controller.GameController;
import Game.Model.Direzione;
import Game.Model.Mappa;
import Game.Model.Posizione;
import Game.Model.StatoCasella;

import java.util.ArrayList;
import java.util.HashMap;

public interface VistaInterface {

     void refresh(Mappa m, HashMap<Posizione,StatoCasella> bagnato);

     void updateLabelRobot(Direzione d);

     void updateLabelFornello(boolean acceso);
     void updateLabelLavatrice(boolean rotta);
     void updateLabelRubinetto(boolean rotto);

     void visible();

     void addController(GameController controller);

     void errore(String s);

     void visualizzaStato(boolean stato);

}
