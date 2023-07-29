package Game.model;

public class Rubinetto extends Casella implements Rompibile{
    private boolean stato;

    public Rubinetto(int posizionex, int posizioney) {
        super(posizionex, posizioney);
        this.stato = false;
    }

    public String toString() {
        return "Rubinetto";
    }

    @Override
    public void perdita() {

    }

    @Override
    public void espandiPerdita() {

    }

    @Override
    public void interrompiPerdita() {

    }
}
