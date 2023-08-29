package Game.Model;

/**
 * @author Adil Lagzouli 20045391
 * @author Samuele Giallorenzo 20045100
 * @author Federico Mannisi 20045099
*/

public abstract class Casella {

    private Posizione posizione;
    private boolean visibile;

    /**
     * Crea una nuova istanza della classe Casella con la posizione e lo stato di visibilità specificati.
     *
     * @param posizione La posizione associata alla casella.
     * @param visibile Lo stato di visibilità della casella (true se visibile, false altrimenti).
     *
     */
    public Casella(Posizione posizione,boolean visibile) {
        this.posizione=posizione;
        this.visibile= visibile;
    }

    /**
     * Crea una nuova istanza della classe Casella con le coordinate e lo stato di visibilità specificati.
     *
     * @param x La coordinata X della posizione associata alla casella.
     * @param y La coordinata Y della posizione associata alla casella.
     * @param visibile Lo stato di visibilità della casella (true se visibile, false altrimenti).
     */
    public Casella(int x,int y,boolean visibile){
        this.posizione= new Posizione(x, y);
        this.visibile=visibile;
    }

    /**
     * Restituisce la casella successiva nella direzione specificata.
     *
     * @param m La mappa del gioco rappresentata come matrice di caselle.
     * @param direzione La direzione in cui cercare la casella successiva.
     * @return La casella successiva nella direzione specificata.
     */
    public Casella getCasellaSuccessiva(Casella[][] m, Direzione direzione){
        Casella c = null;
        switch(direzione){
            case North:
                c = m[this.getPosizione().getX()-1][this.getPosizione().getY()];
                break;
            case East:
                c = m[this.getPosizione().getX()][this.getPosizione().getY()+1];
                break;
            case South:
                c = m[this.getPosizione().getX()+1][this.getPosizione().getY()];
                break;
            case West:
                c = m[this.getPosizione().getX()][this.getPosizione().getY()-1];
                break;
        }
        return c;
    }

    /**
     * Verifica se una casella è attraversabile.
     *
     * @param m La mappa del gioco rappresentata come matrice di caselle.
     * @param x La coordinata X della casella da verificare.
     * @param y La coordinata Y della casella da verificare.
     * @return True se la casella è attraversabile, altrimenti false.
     */
    public boolean isPassable(Casella[][] m, int x, int y) {
        return m[x][y].tipo().equals("Pavimento");
    }

    /**
     *
     * Verifica lo stato di visibilità della casella.
     *
     * @return True se la casella è visibile, altrimenti false.
     */
    public boolean isVisibile() {
        return visibile;
    }

    /**
     * Cambia la visibilit&agrave di una casella secondo il parametro passato
     *
     * @param visibile True se la casella deve essere visibile, altrimenti false.
     */
    public void setVisibile(boolean visibile) {
        this.visibile = visibile;
    }

    /**
     * Restituisce la posizione della casella.
     * @return La posizione della casella.
     */
    public Posizione getPosizione() {
        return posizione;
    }

    /**
     * Imposta la posizione della casella al valore specificato.
     *
     * @param posizione  posizione La nuova posizione da assegnare alla casella.
     */
    public void setPosizione(Posizione posizione) {
        this.posizione = posizione;
    }

    /**
     * Restituisce il tipo della casella.
     *
     * @return Il tipo di casella, specificato dalle classi derivate.
     */
    public abstract String tipo();
}
