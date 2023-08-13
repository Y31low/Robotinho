package Game.model;

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
}
