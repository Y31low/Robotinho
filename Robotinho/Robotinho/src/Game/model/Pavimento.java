package Game.model;

public class Pavimento extends Casella{

    public Pavimento(int posizionex, int posizioney,boolean visibile) {
        super(posizionex, posizioney,visibile);
    }

    @Override
    public String toString() {
        return "Pavimento";
    }

}
