package Game.Model;

public class Rubinetto extends ElementoRompibile {


    public Rubinetto(int posizionex, int posizioney,boolean visibile) {
        super(posizionex, posizioney,visibile);
    }

    @Override
    public String tipo() {
        return "Rubinetto";
    }
}