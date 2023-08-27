package Game.Model;

public class StatoCasella extends Casella{
    private boolean stato;

    /**
     * Primo costruttore per la classe StatoCasella.
     *
     * @param posizione Indica la posizione della casella.
     * @param visibile  Indica se la casella è visibile nella mappa.
     * @param stato     Indica lo stato associato alla casella.
     */

    public StatoCasella(Posizione posizione, boolean visibile, boolean stato) {
        super(posizione, visibile);
        this.stato = stato;
    }

    /**
     * Secondo costruttore per la classe StatoCasella.
     *
     * @param x        Indica la coordinata X della posizione della casella.
     * @param y        Indica la coordinata Y della posizione della casella.
     * @param visibile Indica se la casella è visibile nella mappa.
     * @param stato    Indica lo stato associato alla casella.
     */

    public StatoCasella(int x, int y, boolean visibile, boolean stato) {
        super(x, y, visibile);
        this.stato = stato;
    }

    /**
     * Restituisce lo stato associato alla casella.
     *
     * @return lo stato associato alla casella.
     */

    public boolean getStato() {
        return stato;
    }

    /**
     * Imposta lo stato associato alla casella.
     *
     * @param stato Il nuovo stato da impostare.
     */

    public void setStato(boolean stato) {
        this.stato = stato;
    }

    /**
     * Restituisce una stringa che indica il tipo di oggetto, ovvero "Stato Casella".
     *
     * @return la stringa "Stato Casella".
     */

    @Override
    public String tipo() {
        return "Stato Casella";
    }
}
