package Game.Model;

import java.util.ArrayList;
import java.util.HashMap;

public interface Rompibile{

    void perdita(Mappa m, HashMap<Posizione,StatoCasella> bagnato);

     void espandiPerdita(Casella[][] m, Posizione p, HashMap<Posizione,StatoCasella> bagnato, Direzione dir);

    void interrompiPerdita();


}
