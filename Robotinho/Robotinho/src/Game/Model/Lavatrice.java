package Game.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * @author Adil Lagzouli 20045391
 * @author Samuele Giallorenzo 20045100
 * @author Federico Mannisi 20045099
 */

public class Lavatrice extends ElementoRompibile {
    private static ArrayList<Lavatrice> lavatrici = new ArrayList<>();

    /**
     * Costruisce un nuovo oggetto Lavatrice con le coordinate specificate e la visibilità indicata.
     *
     * @param posizionex Indica la coordinata X della posizione della lavatrice.
     * @param posizioney Indica la coordinata Y della posizione della lavatrice.
     * @param visibile   Indica se la lavatrice è visibile nella mappa.
     */
    public Lavatrice(int posizionex, int posizioney, boolean visibile) {
        super(posizionex, posizioney, visibile);
        lavatrici.add(this);
    }

    /**
     * Restituisce una stringa che rappresenta il tipo di oggetto, ovvero "Lavatrice".
     *
     * @return la stringa "Lavatrice".
     */
    @Override
    public String tipo() {
        return "Lavatrice";
    }

    /**
     * Genera casualmente la rottura di una lavatrice e restituisce la posizione della lavatrice rotta.
     *
     * @return La posizione della lavatrice rotta.
     */
    public static Posizione rompiLavatriceRandom() {
        int rnd = new Random().nextInt(lavatrici.size());
        lavatrici.get(rnd).inizioPerdita(true);
        return lavatrici.get(rnd).getPosizione();
    }

    /**
     * Genera la perdita d'acqua da parte delle lavatrici rotta.
     *
     * @param m La matrice delle caselle della mappa.
     * @param s Una mappa che associa le posizioni allo stato delle caselle correnti.
     */
    public static void perditaLavatrici(Casella[][] m, HashMap<Posizione, StatoCasella> s) {
        for (Lavatrice l : lavatrici
        ) {
            if (l.isStato()) l.perdita(m, s);
        }
    }

}
