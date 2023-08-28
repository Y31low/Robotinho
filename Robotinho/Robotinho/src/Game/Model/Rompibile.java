package Game.Model;

import java.util.HashMap;

/**
 * @author Adil Lagzouli 20045391
 * @author Samuele Giallorenzo 20045100
 * @author Federico Mannisi 20045099
 */

public interface Rompibile{
    /**
     * Avvia il processo di "perdita" per l'elemento rompibile, iniziando l'espansione
     * dell'acqua nelle caselle adiacenti.
     *
     * @param m       La matrice di Caselle in cui l'elemento rompibile è posizionato.
     * @param bagnato Una mappa che tiene traccia dello stato di "bagnato" delle caselle.
     */
    void perdita(Casella[][] m, HashMap<Posizione,StatoCasella> bagnato);

    /**
     * Espande lo stato di "bagnato" partendo dalla posizione specificata,
     * propagandolo alle caselle adiacenti secondo una direzione data.
     *
     * @param m       La matrice di Caselle in cui l'elemento rompibile è posizionato.
     * @param p       La posizione da cui iniziare l'espansione dello stato di "bagnato".
     * @param bagnato Una mappa che tiene traccia dello stato di "bagnato" delle caselle.
     * @param dir     La direzione di espansione.
     */
    void espandiPerdita(Casella[][] m, Posizione p, HashMap<Posizione,StatoCasella> bagnato, Direzione dir);

    /**
     * Interrompe lo stato di "perdita" dell'elemento rompibile.
     * Ripristina il suo stato, interrompendo la diffusione del'acqua'.
     */
    void interrompiPerdita();
}
