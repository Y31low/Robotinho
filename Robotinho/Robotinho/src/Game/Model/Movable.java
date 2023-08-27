package Game.Model;

public interface Movable {
    /**
     * Muove l'oggetto di una casella sulla matrice.
     *
     * @param m La matrice di caselle su cui l'oggetto avanza.
     */
    void Avanza(Casella[][] m);
}
