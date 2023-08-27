package Game.Model;

public class Rubinetto extends ElementoRompibile {

    /**
     * Costruttore per la classe Rubinetto.
     *
     * @param posizionex Indica la coordinata X della posizione del rubinetto.
     * @param posizioney Indica la coordinata Y della posizione del rubinetto.
     * @param visibile  Indica se il rubinetto è visibile nella mappa.
     */
    public Rubinetto(int posizionex, int posizioney,boolean visibile) {
        super(posizionex, posizioney,visibile);
    }

    /**
     * Restituisce una stringa che indica il tipo di oggetto, ovvero "Rubinetto".
     *
     * @return la stringa "Rubinetto".
     */
    @Override
    public String tipo() {
        return "Rubinetto";
    }
}