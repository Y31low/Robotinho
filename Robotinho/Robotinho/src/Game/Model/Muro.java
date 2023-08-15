package Game.Model;

public class Muro extends Casella {
    public Muro(int posizionex, int posizioney,boolean visibile) {
        super(posizionex, posizioney,visibile);
    }

    @Override
    public String toString() {
        return "Muro";
    }
}
