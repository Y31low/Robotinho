package Game.Model;

import java.util.HashMap;


public class Lavatrice extends Casella implements Rompibile{
    private boolean stato;

    public Lavatrice(int posizionex, int posizioney,boolean visibile) {
        super(posizionex, posizioney,visibile);
        this.stato = false;
    }
    @Override
    public String tipo() {
        return "Lavatrice";
    }

    @Override
    public void perdita(Casella[][] m, HashMap<Posizione,StatoCasella> bagnato) {
        Direzione direzione = Direzione.randomDirection();
        Posizione p;
        this.stato=true;
        switch(direzione){
            case North:
                if(isPassable(m, this.getPosizione().getX()-1, this.getPosizione().getY())){
                    p = new Posizione(this.getPosizione().getX()-1,this.getPosizione().getY());
                    espandiPerdita(m, p, bagnato, direzione);
                }
                break;
            case East:
                if(isPassable(m, this.getPosizione().getX(), this.getPosizione().getY()+1)){
                    p = new Posizione(this.getPosizione().getX(),this.getPosizione().getY()+1);
                    espandiPerdita(m, p, bagnato, direzione);
                }
                break;
            case South:
                if(isPassable(m, this.getPosizione().getX()+1, this.getPosizione().getY())){
                    p = new Posizione(this.getPosizione().getX()+1,this.getPosizione().getY());
                    espandiPerdita(m, p, bagnato, direzione);
                }
                break;
            case West:
                if(isPassable(m, this.getPosizione().getX(), this.getPosizione().getY()-1)){
                    p = new Posizione(this.getPosizione().getX(),this.getPosizione().getY()-1);
                    espandiPerdita(m, p, bagnato, direzione);
                }
                break;
        }
    }

    @Override
    //Da mettere private
    public void espandiPerdita(Casella[][] m, Posizione p, HashMap<Posizione,StatoCasella> bagnato, Direzione dir) {
        if (m[p.getX()][p.getY()].tipo().equals("Pavimento")){
            if(!bagnato.get(p).getStato()){
                bagnato.get(p).setStato(true);
            }
            else {
                switch(dir){
                    case North:
                        espandiPerdita(m,new Posizione(p.getX()-1,p.getY()), bagnato, dir);
                        break;
                    case East:
                        espandiPerdita(m,new Posizione(p.getX(),p.getY()+1), bagnato, dir);
                        break;
                    case South:
                        espandiPerdita(m,new Posizione(p.getX()+1,p.getY()), bagnato, dir);
                        break;
                    case West:
                        espandiPerdita(m,new Posizione(p.getX(),p.getY()-1), bagnato, dir);
                        break;
                }
            }
        }
    }

    public boolean isStato() {
        return stato;
    }

    @Override
    public void interrompiPerdita() {
        this.stato = false;
    }
}
