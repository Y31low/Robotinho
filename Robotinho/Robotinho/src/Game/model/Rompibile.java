package Game.model;

import java.util.ArrayList;

public interface Rompibile{

    void perdita(Mappa m, ArrayList<StatoCasella> bagnato);

    void espandiPerdita(Mappa m);

    void interrompiPerdita();

    StatoCasella getStatoCasella(ArrayList<StatoCasella> bagnato, Posizione p);
}
