package Game.model;

public class Pavimento extends Casella{

    private int stato;
    public Pavimento(int posizionex, int posizioney,int stato) {
        super(posizionex, posizioney);
        this.stato=stato;
    }

    @Override
    public String toString() {
        return "Pavimento";
    }

    public int getStato() {
        return stato;
    }

    public void setStato(int stato) {
        this.stato = stato;
    }
}
