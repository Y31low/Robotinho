package Game.Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Robot extends Casella implements Movable{
    //private Mappa m ;
    private Direzione direzione;

    private int mosse;


    public Robot(int posizionex, int posizioney, boolean visibile, Direzione direzione) {
        super(posizionex, posizioney,visibile);
        this.direzione = direzione;
        this.mosse=0;
        //c[p.getX()][p.getY()].setVisibile(true);
    }

    @Override
    public String tipo() {
        return "Robot";
    }

    public void setDirezione(Direzione direzione) {
        this.direzione = direzione;
    }

    public Direzione getDirezione() {
        return direzione;
    }

    private void discover(Casella[][] m, Posizione p) {
        m[p.getX()-1][p.getY()].setVisibile(true);
        m[p.getX()+1][p.getY()].setVisibile(true);
        m[p.getX()][p.getY()-1].setVisibile(true);
        m[p.getX()][p.getY()+1].setVisibile(true);
    }


    @Override
    public void Avanza(Casella[][] m) throws IllegalMoveException{
        Posizione p;

        switch (this.direzione) {
            case North:
                this.setDirezione(Direzione.North);
                if (! isPassable(m, this.getPosizione().getX()-1, this.getPosizione().getY())){
                    throw new IllegalMoveException("BUMP");
                }
                else {
                    m[this.getPosizione().getX()][this.getPosizione().getY()].setVisibile(true);
                    p = new Posizione(this.getPosizione().getX() - 1, this.getPosizione().getY());
                    this.setPosizione(p);

                }
                break;
            case West:
                this.setDirezione(Direzione.West);
                if (! isPassable(m, this.getPosizione().getX(), this.getPosizione().getY()-1)){
                    throw new IllegalMoveException("BUMP");
                }
                else{
                    m[this.getPosizione().getX()][this.getPosizione().getY()].setVisibile(true);
                    p = new Posizione(this.getPosizione().getX(), this.getPosizione().getY() - 1);
                    this.setPosizione(p);
                }
                break;
            case East:
                this.setDirezione(Direzione.East);
                if (! isPassable(m, this.getPosizione().getX(), this.getPosizione().getY()+1)){
                    throw new IllegalMoveException("BUMP");
                }
                else{
                    m[this.getPosizione().getX()][this.getPosizione().getY()].setVisibile(true);
                    p = new Posizione(this.getPosizione().getX(), this.getPosizione().getY() + 1);
                    this.setPosizione(p);
                }
                break;
            case South:
                this.setDirezione(Direzione.South);
                if (! isPassable(m, this.getPosizione().getX()+1, this.getPosizione().getY())){
                    throw new IllegalMoveException("BUMP");
                }
                else {
                    m[this.getPosizione().getX()][this.getPosizione().getY()].setVisibile(true);
                    p = new Posizione(this.getPosizione().getX() + 1, this.getPosizione().getY());
                    this.setPosizione(p);
                }
                break;
            default:
                break;
        }
        this.discover(m, this.getPosizione());
        this.mosse++;
    }

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
        this.mosse++;
    }

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
        this.mosse++;
    }

    public void Asciuga(HashMap<Posizione,StatoCasella> s) throws IllegalActionException{
        StatoCasella bagnato=s.get(this.getPosizione());
        if (!bagnato.getStato()) throw new IllegalActionException("La casella non è bagnata!");
        else
            bagnato.setStato(false);
        this.mosse++;
    }

    public static class IllegalMoveException extends RuntimeException {
        public IllegalMoveException(String message) {
            super(message);
        }
    }

    public static class IllegalActionException extends RuntimeException {
        public IllegalActionException(String message) {
            super(message);
        }
    }

    public int getMosse() {
        return mosse;
    }

    public Posizione spegniFornello(Casella[][] m) throws IllegalActionException{
        Posizione p=null;
        Fornello f;
        switch (this.direzione){
            case North:
                if(m[this.getPosizione().getX()-1][this.getPosizione().getY()].tipo().equals("Fornello")){
                   f=(Fornello) m[this.getPosizione().getX()-1][this.getPosizione().getY()];
                   if (!f.getAcceso()){
                       throw new IllegalActionException("E' gia' spento pirla!");

                   }
                   else{
                       f.setAcceso(false);
                       p= f.getPosizione();
                   }
                }
                else {
                    throw new IllegalActionException("Nessun fornello nella mia direzione!");

                }
                break;
            case East:
                if(m[this.getPosizione().getX()][this.getPosizione().getY()+1].tipo().equals("Fornello")){
                    f = (Fornello)m[this.getPosizione().getX()][this.getPosizione().getY()+1];
                    if(!f.getAcceso()){
                        throw new IllegalActionException("E' già spento pirla");

                    }
                    else{
                        f.setAcceso(false);
                        p= f.getPosizione();
                    }
                }
                else{
                    throw new IllegalActionException("Nessun fornello nella mia direzione!");

                }
                break;
            case South:
                if(m[this.getPosizione().getX()+1][this.getPosizione().getY()].tipo().equals("Fornello")){
                    f = (Fornello)m[this.getPosizione().getX()+1][this.getPosizione().getY()];
                    if(!f.getAcceso()){
                        throw new IllegalActionException("E' già spento pirla");

                    }
                    else{
                        f.setAcceso(false);
                        p= f.getPosizione();
                    }
                }
                else{
                    throw new IllegalActionException("Nessun fornello nella mia direzione!");

                }
                break;
            case West:
                if(m[this.getPosizione().getX()][this.getPosizione().getY()-1].tipo().equals("Fornello")){
                    f = (Fornello)m[this.getPosizione().getX()][this.getPosizione().getY()-1];
                    if(!f.getAcceso()){
                        throw new IllegalActionException("E' già spento pirla");

                    }
                    else{
                        f.setAcceso(false);
                        p= f.getPosizione();
                    }
                }
                else{
                    throw new IllegalActionException("Nessun fornello nella mia direzione!");
                }
                break;
        }
        return p;
    }

    private Casella getCasellaSuccessiva(Casella[][] m){
        Casella c = null;
        switch(this.direzione){
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
    public Posizione interrompiLavatrice(Casella[][] m) throws IllegalActionException{
        Posizione p=null;
        Casella successiva = getCasellaSuccessiva(m);
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

    public Posizione interrompiRubinetto(Casella[][] m) throws IllegalActionException{
        Posizione p=null;
        Casella successiva = getCasellaSuccessiva(m);
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