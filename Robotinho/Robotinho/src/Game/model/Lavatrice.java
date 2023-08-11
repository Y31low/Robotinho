package Game.model;

import java.util.ArrayList;
import java.util.Random;

public class Lavatrice extends Casella implements Rompibile{
    private boolean stato;

    private ArrayList<Casella> vicini;

    public Lavatrice(int posizionex, int posizioney,boolean visibile) {
        super(posizionex, posizioney,visibile);
        this.stato = false;
        this.vicini = new ArrayList<>();
    }

    public String toString() {
        return "Lavatrice";
    }

    @Override
    public void perdita() {
        Random random = new Random();
        int direzione = random.nextInt(4);
        Pavimento p;
        switch(direzione){
            case 0:
                if(this.vicini.get(0).toString().equals("Pavimento")){
                    p = (Pavimento)vicini.get(0);
                    if(p.getStato())
                        p.setStato(true);
                }
                break;
            case 1:
                if(this.vicini.get(1).toString().equals("Pavimento")){
                    p = (Pavimento)vicini.get(1);
                    if(p.getStato())
                        p.setStato(true);
                }
                break;
            case 2:
                if(this.vicini.get(2).toString().equals("Pavimento")){
                    p = (Pavimento)vicini.get(2);
                    if(p.getStato())
                        p.setStato(true);
                }
                break;
            case 3:
                if(this.vicini.get(3).toString().equals("Pavimento")){
                    p = (Pavimento)vicini.get(3);
                    if(p.getStato())
                        p.setStato(true);
                }
                break;
        }
    }

    @Override
    public void espandiPerdita() {

    }

    @Override
    public void interrompiPerdita() {

    }
}
