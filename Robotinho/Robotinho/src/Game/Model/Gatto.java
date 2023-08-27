package Game.Model;

/**
 * @author Adil Lagzouli 20045391
 * @author Samuele Giallorenzo 20045100
 * @author Federico Mannisi 20045099
 */

public class Gatto extends Casella implements Movable {
    /**
     * Costruttore per creare un nuovo oggetto Gatto.
     *
     * @param x         La coordinata x della posizione del gatto nella mappa.
     * @param y         La coordinata y della posizione del gatto nella mappa.
     * @param visibile  Indica se il gatto è visibile o meno nella mappa.
     */
    public Gatto(int x, int y,boolean visibile){
        super(x, y,visibile);
    }

    /**
     * Restituisce una stringa che rappresenta il tipo di oggetto, ovvero "Gatto".
     *
     * @return La stringa "Gatto".
     */
    @Override
    public String tipo() {
        return "Gatto";
    }

    /**
     * Muove il gatto in una direzione casuale all'interno della matrice di Caselle.
     * Se la casella successiva è attraversabile, il gatto viene spostato sulla casella successiva.
     *
     * @param m La matrice di Caselle in cui il gatto si muove.
     */
    @Override
    public void Avanza(Casella[][] m) {
        Direzione direzione = Direzione.randomDirection();
        Posizione p;
        Casella successiva = getCasellaSuccessiva(m, direzione);

        if(isPassable(m, successiva.getPosizione().getX(), successiva.getPosizione().getY())){
            p = new Posizione(successiva.getPosizione().getX(), successiva.getPosizione().getY());
            this.setPosizione(p);
        }
    }
}