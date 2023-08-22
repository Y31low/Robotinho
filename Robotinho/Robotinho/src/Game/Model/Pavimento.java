package Game.Model;

public class Pavimento extends Casella{
    public Pavimento(int posizionex, int posizioney,boolean visibile) {
        super(posizionex, posizioney, visibile);
    }

    @Override
    public String tipo() {
        return "Pavimento";
    }
}
