package Game.model;

import java.util.ArrayList;


public class Lavatrice extends Casella implements Rompibile{
    private boolean stato;

    public Lavatrice(int posizionex, int posizioney,boolean visibile) {
        super(posizionex, posizioney,visibile);
        this.stato = false;
    }

    public String toString() {
        return "Lavatrice";
    }

    public StatoCasella getStatoCasella(ArrayList<StatoCasella> bagnato, Posizione p){
        for(StatoCasella s : bagnato) {
            if(s.getPosizione().equals(p))
                return s;
        }
        return null;
    }

    @Override
    public void perdita(Mappa m, ArrayList<StatoCasella> bagnato) {
        Direzione direzione = Direzione.randomDirection();
        Pavimento p;
        switch(direzione){
            case North:
                if(isPassable(m, this.getPosizione().getX()-1, this.getPosizione().getY())){
                    p = (Pavimento) m.getMappa()[this.getPosizione().getX()-1][this.getPosizione().getY()];
                    StatoCasella s = getStatoCasella(bagnato, p.getPosizione());

                    if(!s.getStato())
                        s.setStato(true);
                }
                break;
            case East:
                if(isPassable(m, this.getPosizione().getX(), this.getPosizione().getY()+1)){
                    p = (Pavimento) m.getMappa()[this.getPosizione().getX()][this.getPosizione().getY()+1];
                    StatoCasella s = getStatoCasella(bagnato, p.getPosizione());

                    if(!s.getStato())
                        s.setStato(true);
                }
                break;
            case South:
                if(isPassable(m, this.getPosizione().getX()+1, this.getPosizione().getY())){
                    p = (Pavimento) m.getMappa()[this.getPosizione().getX()+1][this.getPosizione().getY()];
                    StatoCasella s = getStatoCasella(bagnato, p.getPosizione());

                    if(!s.getStato())
                        s.setStato(true);
                }
                break;
            case West:
                if(isPassable(m, this.getPosizione().getX(), this.getPosizione().getY()-1)){
                    p = (Pavimento) m.getMappa()[this.getPosizione().getX()][this.getPosizione().getY()-1];
                    StatoCasella s = getStatoCasella(bagnato, p.getPosizione());

                    if(!s.getStato())
                        s.setStato(true);
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
