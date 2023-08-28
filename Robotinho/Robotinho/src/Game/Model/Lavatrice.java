package Game.Model;

/**
 * @author Adil Lagzouli 20045391
 * @author Samuele Giallorenzo 20045100
 * @author Federico Mannisi 20045099
 */

public class Lavatrice extends ElementoRompibile {

    /**
     * Costruisce un nuovo oggetto Lavatrice con le coordinate specificate e la visibilità indicata.
     *
     * @param posizionex Indica la coordinata X della posizione della lavatrice.
     * @param posizioney Indica la coordinata Y della posizione della lavatrice.
     * @param visibile  Indica se la lavatrice è visibile nella mappa.
     */
    public Lavatrice(int posizionex, int posizioney,boolean visibile) {
        super(posizionex, posizioney,visibile);
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
}
