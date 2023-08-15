package Game.Model;

import java.util.HashMap;

public class Rubinetto extends Casella implements Rompibile{
    private boolean stato;


    public Rubinetto(int posizionex, int posizioney,boolean visibile) {
        super(posizionex, posizioney,visibile);
        this.stato = false;
    }

    public String toString() {
        return "Rubinetto";
    }

    @Override
    public void perdita(Mappa m, HashMap<Posizione,StatoCasella> bagnato) {
        Direzione direzione = Direzione.randomDirection();
        Posizione p;
        switch(direzione){
            case North:
                if(isPassable(m, this.getPosizione().getX()-1, this.getPosizione().getY())){
                    p = new Posizione(this.getPosizione().getX()-1,this.getPosizione().getY());
                    if(!bagnato.get(p).getStato())
                        bagnato.get(p).setStato(true);
                }
                break;
            case East:
                if(isPassable(m, this.getPosizione().getX(), this.getPosizione().getY()+1)){
                    p = new Posizione(this.getPosizione().getX()-1,this.getPosizione().getY()+1);


                    if(!bagnato.get(p).getStato())
                        bagnato.get(p).setStato(true);
                }
                break;
            case South:
                if(isPassable(m, this.getPosizione().getX()+1, this.getPosizione().getY())){
                    p = new Posizione(this.getPosizione().getX()+1,this.getPosizione().getY());
                    if(!bagnato.get(p).getStato())
                        bagnato.get(p).setStato(true);
                }
                break;
            case West:
                if(isPassable(m, this.getPosizione().getX(), this.getPosizione().getY()-1)){
                    p = new Posizione(this.getPosizione().getX(),this.getPosizione().getY()-1);
                    if(!bagnato.get(p).getStato())
                        bagnato.get(p).setStato(true);
                }
                break;
        }
    }

    @Override
    public void espandiPerdita(Mappa m) {

    }

    @Override
    public void interrompiPerdita() {

    }
}
