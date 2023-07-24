package Game.model;

public class Muro extends Casella {
    public Muro(int posizionex, int posizioney) {
        super(posizionex, posizioney);
    }

    @Override
    public String toString() {
        return "Muro";
    }
}
