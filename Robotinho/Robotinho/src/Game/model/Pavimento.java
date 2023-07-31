package Game.model;

public class Pavimento extends Casella{

    private boolean stato;
    public Pavimento(int posizionex, int posizioney,boolean stato) {
        super(posizionex, posizioney);
        this.stato=stato;
    }

    @Override
    public String toString() {
        return "Pavimento";
    }

    public boolean getStato() {
        return stato;
    }

    public void setStato(boolean stato) {
        this.stato = stato;
    }
}
