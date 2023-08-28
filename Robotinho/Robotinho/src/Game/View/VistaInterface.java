package Game.View;

import Game.Controller.GameController;
import Game.Model.Direzione;
import Game.Model.Mappa;
import Game.Model.Posizione;
import Game.Model.StatoCasella;

import java.util.HashMap;

/**
 * @author Adil Lagzouli 20045391
 * @author Samuele Giallorenzo 20045100
 * @author Federico Mannisi 20045099
 */

public interface VistaInterface {

     void refresh(Mappa m, HashMap<Posizione,StatoCasella> bagnato);

     void updateLabelRobot(Direzione d);

     void updateLabelFornello(Posizione p, boolean acceso);
     void updateLabelLavatrice(Posizione p,boolean rotta);
     void updateLabelRubinetto(Posizione p,boolean rotto);

     void visible();

     void addController(GameController controller);

     void errore(String s);

     void visualizzaStato(boolean stato);
      Label[][] updateMapLabels(Mappa m, HashMap<Posizione, StatoCasella> bagnato);

}
