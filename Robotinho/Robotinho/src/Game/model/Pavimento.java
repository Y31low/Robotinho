package Game.model;

public class Pavimento extends Casella{

    private boolean bagnato;
    public Pavimento(int posizionex, int posizioney,boolean visibile,boolean bagnato) {
        super(posizionex, posizioney,visibile);
        this.bagnato=bagnato;
    }

    @Override
    public String toString() {
        return "Pavimento";
    }

    public boolean getStato() {
        return this.bagnato;
    }

    public void setStato(boolean bagnato) {
        this.bagnato = bagnato;
    }
}
