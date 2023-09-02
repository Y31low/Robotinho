package Game.Model;

import java.util.HashMap;

/**
 * @author Adil Lagzouli 20045391
 * @author Samuele Giallorenzo 20045100
 * @author Federico Mannisi 20045099
 */

public class ElementoRompibile extends Casella implements Rompibile {
    private boolean stato;

    /**
     * Primo costruttore per creare un nuovo oggetto ElementoRompibile con la posizione e la visibilità indicata.
     *
     * @param posizione La posizione dell'ElementoRompibile nella mappa di gioco.
     * @param visibile  Indica se l'ElementoRompibile è visibile sulla mappa.
     */
    public ElementoRompibile(Posizione posizione, boolean visibile) {
        super(posizione, visibile);
        this.stato = false;
    }

    /**
     * Secondo costruttore per creare un nuovo oggetto ElementoRompibile con le coordinate specificate e la visibilità indicata.
     *
     * @param x        La coordinata x della posizione dell'ElementoRompibile nella mappa.
     * @param y        La coordinata y della posizione dell'ElementoRompibile nella mappa.
     * @param visibile Indica se l'ElementoRompibile è visibile sulla mappa.
     */
    public ElementoRompibile(int x, int y, boolean visibile) {
        super(x, y, visibile);
        this.stato = false;
    }

    /**
     * Restituisce una stringa che rappresenta il tipo di oggetto, ovvero "Elemento rompibile".
     *
     * @return La stringa "Elemento rompibile".
     */
    @Override
    public String tipo() {
        return "Elemento rompibile";
    }

    /**
     * Avvia il processo di "perdita" per l'ElementoRompibile, iniziando l'espansione
     * dello stato di "bagnato" nelle caselle adiacenti in base a una direzione scelta casualmente.
     *
     * @param m       La matrice di Caselle in cui l'ElementoRompibile si trova.
     * @param bagnato Una mappa che tiene traccia dello stato "bagnato" delle caselle.
     */
    @Override
    public void perdita(Casella[][] m, HashMap<Posizione, StatoCasella> bagnato) {
        Direzione direzione = Direzione.randomDirection();
        Posizione p;
        Casella successiva = getCasellaSuccessiva(m, direzione);

        if (isPassable(m, successiva.getPosizione().getX(), successiva.getPosizione().getY())) {
            p = new Posizione(successiva.getPosizione().getX(), successiva.getPosizione().getY());
            espandiPerdita(m, p, bagnato, direzione);
        }


    }

    /**
     * Espande lo stato di "bagnato" a partire dalla posizione specificata, propagandolo
     * alle caselle adiacenti secondo la direzione data.
     *
     * @param m       La matrice di Caselle in cui l'ElementoRompibile si trova.
     * @param p       La posizione da cui iniziare l'espansione dello stato di "bagnato".
     * @param bagnato Una mappa che tiene traccia dello stato di "bagnato" delle caselle.
     * @param dir     La direzione di espansione dell'acqua.
     */
    @Override
    public void espandiPerdita(Casella[][] m, Posizione p, HashMap<Posizione, StatoCasella> bagnato, Direzione dir) {
        if (m[p.getX()][p.getY()].tipo().equals("Pavimento")) {
            if (!bagnato.get(p).getStato()) {
                bagnato.get(p).setStato(true);
            } else {
                switch (dir) {
                    case North:
                        espandiPerdita(m, new Posizione(p.getX() - 1, p.getY()), bagnato, dir);
                        break;
                    case East:
                        espandiPerdita(m, new Posizione(p.getX(), p.getY() + 1), bagnato, dir);
                        break;
                    case South:
                        espandiPerdita(m, new Posizione(p.getX() + 1, p.getY()), bagnato, dir);
                        break;
                    case West:
                        espandiPerdita(m, new Posizione(p.getX(), p.getY() - 1), bagnato, dir);
                        break;
                }
            }
        }
    }

    /**
     * Verifica lo stato corrente dell'ElementoRompibile (se è rotto o no).
     *
     * @return True se l'ElementoRompibile è rotto, altrimenti false.
     */
    public boolean isStato() {
        return stato;
    }

    /**
     * Imposta lo stato iniziale di perdita dell'ElementoRompibile.
     *
     * @param stato Lo stato iniziale di perdita (true per ElementoRompibile rotto, false altrimenti).
     */
    public void inizioPerdita(boolean stato) {
        this.stato = stato;
    }

    /**
     * Interrompe lo stato di perdita dell'ElementoRompibile, ripristinando il suo stato a false.
     * Questo metodo imposta lo stato dell'ElementoRompibile in modo che l'elemento non risulti più rotto.
     */
    @Override
    public void interrompiPerdita() {
        this.stato = false;
    }
}
