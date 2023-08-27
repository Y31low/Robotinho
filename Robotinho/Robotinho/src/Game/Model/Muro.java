package Game.Model;

public class Muro extends Casella {
    //Il padre del gioco
    /**
     * Costruttore per la classe Muro.
     *
     * @param posizionex Indica la coordinata X della posizione del muro.
     * @param posizioney Indica la coordinata Y della posizione del muro.
     * @param visibile  Indica se il muro è visibile nella mappa.
     */
    public Muro(int posizionex, int posizioney,boolean visibile) {
        super(posizionex, posizioney,visibile);
    }

    /**
     * Restituisce una stringa che rappresenta il tipo di oggetto, ovvero "Muro".
     *
     * @return la stringa "Muro".
     */
    @Override
    public String tipo() {
        return "Muro";
    }
}
