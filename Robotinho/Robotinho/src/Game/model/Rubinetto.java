package Game.model;

import java.util.ArrayList;

public class Rubinetto extends Casella implements Rompibile{
    private boolean stato;
    private ArrayList<Casella> vicini;

    public Rubinetto(int posizionex, int posizioney,boolean visibile) {
        super(posizionex, posizioney,visibile);
        this.stato = false;
        vicini = new ArrayList<>();
    }

    public String toString() {
        return "Rubinetto";
    }

    @Override
    public void perdita() {
        Pavimento stato;
        if (this.vicini.get(0).toString().equals("Pavimento")) {
            stato = (Pavimento) vicini.get(0);
            if (stato.getStato())
                stato.setStato(true);
        }
        if (this.vicini.get(1).toString().equals("Pavimento")) {
            stato = (Pavimento) vicini.get(1);
            if (stato.getStato())
                stato.setStato(true);
        }
        if (this.vicini.get(2).toString().equals("Pavimento")) {
            stato = (Pavimento) vicini.get(2);
            if (stato.getStato())
                stato.setStato(true);
        }
        if(this.vicini.get(3).toString().equals("Pavimento")) {
            stato = (Pavimento) vicini.get(3);
            if (stato.getStato())
                stato.setStato(true);
        }
    }

    @Override
    public void espandiPerdita() {

    }

    @Override
    public void interrompiPerdita() {

    }
}
