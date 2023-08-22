package Game.Model;

public class Muro extends Casella {
    //Il padre del gioco
    public Muro(int posizionex, int posizioney,boolean visibile) {
        super(posizionex, posizioney,visibile);
    }

    @Override
    public String tipo() {
        return "Muro";
    }
}
