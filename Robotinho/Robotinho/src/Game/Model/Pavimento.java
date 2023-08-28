package Game.Model;

/**
 * @author Adil Lagzouli 20045391
 * @author Samuele Giallorenzo 20045100
 * @author Federico Mannisi 20045099
 */

public class Pavimento extends Casella{

    /**
     * Costruttore per la classe Pavimento.
     *
     * @param posizionex Indica la coordinata X della posizione del pavimento.
     * @param posizioney Indica la coordinata Y della posizione del pavimento.
     * @param visibile  Indica se il pavimento è visibile nella mappa.
     */
    public Pavimento(int posizionex, int posizioney,boolean visibile) {
        super(posizionex, posizioney, visibile);
    }

    /**
     * Restituisce una stringa che rappresenta il tipo di oggetto, ovvero "Pavimento".
     *
     * @return la stringa "Pavimento".
     */
    @Override
    public String tipo() {
        return "Pavimento";
    }
}
