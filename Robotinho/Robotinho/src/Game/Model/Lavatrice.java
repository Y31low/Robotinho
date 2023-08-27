package Game.Model;

public class Lavatrice extends ElementoRompibile {

    public Lavatrice(int posizionex, int posizioney,boolean visibile) {
        super(posizionex, posizioney,visibile);
        this.stato = false;
    }
    @Override
    public String tipo() {
        return "Lavatrice";
    }
}
