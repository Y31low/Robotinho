package Game.Model;

public class StatoCasella extends Casella{
    private boolean stato;

    public StatoCasella(Posizione posizione, boolean visibile, boolean stato) {
        super(posizione, visibile);
        this.stato = stato;
    }

    public StatoCasella(int x, int y, boolean visibile, boolean stato) {
        super(x, y, visibile);
        this.stato = stato;
    }

    public boolean getStato() {
        return stato;
    }

    public void setStato(boolean stato) {
        this.stato = stato;
    }



}
