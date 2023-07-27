package Game.model;

public class Lavatrice extends Casella implements Rompibile{
    private boolean stato;

    public Lavatrice(int posizionex, int posizioney) {
        super(posizionex, posizioney);
        this.stato = false;
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
