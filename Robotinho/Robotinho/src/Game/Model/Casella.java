package Game.Model;

public abstract class Casella {

    private Posizione posizione;
    private boolean visibile;

    public Casella(Posizione posizione,boolean visibile) {
        this.posizione=posizione;
        this.visibile= visibile;
    }

    public Casella(int x,int y,boolean visibile){
        this.posizione= new Posizione(x, y);
        this.visibile=visibile;
    }

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

    public boolean isPassable(Casella[][] m, int x, int y) {
        return m[x][y].tipo().equals("Pavimento");
    }
    public boolean isVisibile() {
        return visibile;
    }

    public void setVisibile(boolean visibile) {
        this.visibile = visibile;
    }

    public Posizione getPosizione() {
        return posizione;
    }

    public void setPosizione(Posizione posizione) {
        this.posizione = posizione;
    }

    public abstract String tipo();

}
