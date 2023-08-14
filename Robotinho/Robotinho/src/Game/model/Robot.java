package Game.model;

public class Robot extends Casella implements Movable{
    //private Mappa m ;
    private Direzione direzione;


    public Robot(int posizionex, int posizioney,boolean visibile, Direzione direzione) {
        super(posizionex, posizioney,visibile);
        this.direzione = direzione;
        //c[p.getX()][p.getY()].setVisibile(true);
    }

    @Override
    public String toString() {
        return "Robot";
    }

    public void setDirezione(Direzione direzione) {
        this.direzione = direzione;
    }

    public Direzione getDirezione() {
        return direzione;
    }

    private void discover(Mappa m, Posizione p) {
        Casella[][] c;
        c = m.getMappa();

        c[p.getX()-1][p.getY()].setVisibile(true);
        c[p.getX()+1][p.getY()].setVisibile(true);
        c[p.getX()][p.getY()-1].setVisibile(true);
        c[p.getX()][p.getY()+1].setVisibile(true);
    }


    @Override
    public void Avanza(Mappa m) throws IllegalMoveException{
        Posizione p;

        switch (this.direzione) {
            case North:
                this.setDirezione(Direzione.North);
                if (! isPassable(m, this.getPosizione().getX()-1, this.getPosizione().getY())){
                    throw new IllegalMoveException("BUMP");
                }
                else {
                    m.getMappa()[this.getPosizione().getX()][this.getPosizione().getY()].setVisibile(true);
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
                    m.getMappa()[this.getPosizione().getX()][this.getPosizione().getY()].setVisibile(true);
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
                    m.getMappa()[this.getPosizione().getX()][this.getPosizione().getY()].setVisibile(true);
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
                    m.getMappa()[this.getPosizione().getX()][this.getPosizione().getY()].setVisibile(true);
                    p = new Posizione(this.getPosizione().getX() + 1, this.getPosizione().getY());
                    this.setPosizione(p);
                }
                break;
            default:
                break;
        }
        this.discover(m, this.getPosizione());
    }

    @Override
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

    public void interagisci(){

    }

    public static class IllegalMoveException extends RuntimeException {
        public IllegalMoveException(String s) {
            super(s);
        }
    }
}