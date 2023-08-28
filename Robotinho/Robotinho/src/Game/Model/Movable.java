package Game.Model;

/**
 * @author Adil Lagzouli 20045391
 * @author Samuele Giallorenzo 20045100
 * @author Federico Mannisi 20045099
 */

public interface Movable {
    /**
     * Muove l'oggetto di una casella sulla matrice.
     *
     * @param m La matrice di caselle su cui l'oggetto avanza.
     */
    void Avanza(Casella[][] m);
}
