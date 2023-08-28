package Game.Model;

import java.util.HashMap;

/**
 * @author Adil Lagzouli 20045391
 * @author Samuele Giallorenzo 20045100
 * @author Federico Mannisi 20045099
 */

public class Robot extends Casella implements Movable{
    private Direzione direzione;

    /**
     * Costruttore per la classe Robot.
     *
     * @param posizionex Indica la coordinata X della posizione del robot.
     * @param posizioney Indica laa coordinata Y della posizione del robot.
     * @param visibile   Indica se il robot è visibile nella mappa.
     * @param direzione  Indica la direzione iniziale del robot.
     */
    public Robot(int posizionex, int posizioney, boolean visibile, Direzione direzione) {
        super(posizionex, posizioney,visibile);
        this.direzione = direzione;
    }

    /**
     * Restituisce una stringa che indica il tipo dell'elemento, ovvero "Robot".
     *
     * @return la stringa "Robot".
     */
    @Override
    public String tipo() {
        return "Robot";
    }

    /**
     * Imposta la direzione del robot.
     *
     * @param direzione la nuova direzione del robot.
     */
    public void setDirezione(Direzione direzione) {
        this.direzione = direzione;
    }

    /**
     * Restituisce la direzione attuale del robot.
     *
     * @return la direzione attuale del robot.
     */
    public Direzione getDirezione() {
        return direzione;
    }

    private void discover(Casella[][] m, Posizione p) {
        m[p.getX()-1][p.getY()].setVisibile(true);
        m[p.getX()+1][p.getY()].setVisibile(true);
        m[p.getX()][p.getY()-1].setVisibile(true);
        m[p.getX()][p.getY()+1].setVisibile(true);
    }

    /**
     * Muove in avanti il robot sulla matrice di caselle.
     *
     * @param m La matrice di caselle.
     * @throws IllegalMoveException Se il movimento non è consentito.
     */
    @Override
    public void Avanza(Casella[][] m) throws IllegalMoveException{
        Posizione p;
        Casella successiva = getCasellaSuccessiva(m, direzione);

        if(!isPassable(m, successiva.getPosizione().getX(), successiva.getPosizione().getY())){
            throw new IllegalMoveException("BUMP");
        }
        else{
            m[successiva.getPosizione().getX()][successiva.getPosizione().getY()].setVisibile(true);
            p = new Posizione(successiva.getPosizione().getX(), successiva.getPosizione().getY());
            this.setPosizione(p);
        }
        this.discover(m, this.getPosizione());

    }

    /**
     * Modifica la direzione del robot verso sinistra.
     */
    public void giraSx() {
        switch (this.direzione) {
            case North:
                this.setDirezione(Direzione.West);
                break;
            case South:
                this.setDirezione(Direzione.East);
                break;
            case West:
                this.setDirezione(Direzione.South);
                break;
            case East:
                this.setDirezione(Direzione.North);
                break;
        }
    }

    /**
     * Modifica la direzione del robot verso destra.
     */
    public void giraDx() {
        switch (this.direzione) {
            case North:
                this.setDirezione(Direzione.East);
                break;
            case South:
                this.setDirezione(Direzione.West);
                break;
            case West:
                this.setDirezione(Direzione.North);
                break;
            case East:
                this.setDirezione(Direzione.South);
                break;
        }
    }

    /**
     * Asciuga la casella bagnata.
     *
     * @param s Mappa delle posizioni delle caselle con lo stato.
     * @throws IllegalActionException Se l'azione non è consentita.
     */
    public void Asciuga(HashMap<Posizione,StatoCasella> s) throws IllegalActionException{
        StatoCasella bagnato=s.get(this.getPosizione());
        if (!bagnato.getStato()) throw new IllegalActionException("La casella non è bagnata!");
        else
            bagnato.setStato(false);
    }

    /**
     * Classe per rappresentare un'eccezione di movimento non consentito.
     */
    public static class IllegalMoveException extends RuntimeException {
        public IllegalMoveException(String message) {
            super(message);
        }
    }

    /**
     * Classe per rappresentare un'eccezione di azione non consentita.
     */
    public static class IllegalActionException extends RuntimeException {
        public IllegalActionException(String message) {
            super(message);
        }
    }

    /**
     * Spegne un fornello nella direzione del robot.
     *
     * @param m Indica la matrice di caselle.
     * @return la posizione del fornello spento.
     * @throws IllegalActionException Se l'azione non è consentita.
     */
    public Posizione spegniFornello(Casella[][] m) throws IllegalActionException {
        Posizione p;
        Fornello f;
        Casella c = getCasellaSuccessiva(m, direzione);

        if(c.tipo().equals("Fornello")){
            f = (Fornello) c;
            if (!f.getAcceso()) {
                throw new IllegalActionException("Il fornello e' gia spento!");

            } else {
                f.setAcceso(false);
                p = f.getPosizione();
            }
        }
        else {
            throw new IllegalActionException("Nessun fornello nella mia direzione!");
        }
        return p;
    }

    /**
     * Interrompi la perdita di una lavatrice nella direzione del robot.
     *
     * @param m Indica la matrice di caselle.
     * @return la posizione della lavatrice interrotta.
     * @throws IllegalActionException Se l'azione non è consentita.
     */
    public Posizione interrompiLavatrice(Casella[][] m) throws IllegalActionException{
        Posizione p;
        Casella successiva = getCasellaSuccessiva(m, direzione);
        Lavatrice l;

        if(successiva.tipo().equals("Lavatrice")){
            l=(Lavatrice) successiva;
            if (!l.isStato()){
                throw new IllegalActionException("La lavatrice non è rotta!");
            }
            else{
                l.interrompiPerdita();
                p=l.getPosizione();
            }
        }
        else {
            throw new IllegalActionException("Nessuna lavatrice nella mia direzione!");
        }
        return p;
    }

    /**
     * Interrompi la perdita di un rubinetto nella direzione del robot.
     *
     * @param m Indica la griglia di caselle.
     * @return la posizione del rubinetto interrotto.
     * @throws IllegalActionException Se l'azione non è consentita.
     */
    public Posizione interrompiRubinetto(Casella[][] m) throws IllegalActionException{
        Posizione p;
        Casella successiva = getCasellaSuccessiva(m, direzione);
        Rubinetto r;

        if(successiva.tipo().equals("Rubinetto")){
            r=(Rubinetto) successiva;
            if (!r.isStato()){
                throw new IllegalActionException("Il rubinetto non è rotto!");
            }
            else{
                r.interrompiPerdita();
                p=r.getPosizione();           }
        }
        else {
            throw new IllegalActionException("Nessun rubinetto nella mia direzione!");
        }
        return p;
    }
}