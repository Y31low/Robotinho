package Game.Model;

import java.util.ArrayList;
import java.util.HashMap;

public interface Rompibile{

    void perdita(Mappa m, HashMap<Posizione,StatoCasella> bagnato);

    void espandiPerdita(Mappa m);

    void interrompiPerdita();


}
