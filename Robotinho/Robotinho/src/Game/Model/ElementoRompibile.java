package Game.Model;

import java.util.HashMap;

public class ElementoRompibile extends Casella implements Rompibile{
    private boolean stato;

    public ElementoRompibile(Posizione posizione, boolean visibile) {
        super(posizione, visibile);
        this.stato=false;
    }

    public ElementoRompibile(int x, int y, boolean visibile) {
        super(x, y, visibile);
        this.stato=false;
    }

    @Override
    public String tipo() {
        return "Elememento rompibile";
    }

    @Override
    public void perdita(Casella[][] m, HashMap<Posizione,StatoCasella> bagnato) {
        Direzione direzione = Direzione.randomDirection();
        Posizione p;
        inizioPerdita(true);
        Casella successiva = getCasellaSuccessiva(m, direzione);

        if(isPassable(m, successiva.getPosizione().getX(), successiva.getPosizione().getY())){
            p = new Posizione(successiva.getPosizione().getX(), successiva.getPosizione().getY());
            espandiPerdita(m, p, bagnato, direzione);
        }
    }

    @Override
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

    public void inizioPerdita(boolean stato){
        this.stato = stato;
    }

    @Override
    public void interrompiPerdita() {
        this.stato = false;
    }
}
