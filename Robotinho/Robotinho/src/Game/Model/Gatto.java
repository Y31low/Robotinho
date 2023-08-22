package Game.Model;

import java.util.HashMap;

public class Gatto extends Casella implements Movable {

    public Gatto(int x, int y,boolean visibile){
        super(x, y,visibile);
    }
    @Override
    public String tipo() {
        return "Gatto";
    }

    @Override
    public void Avanza(Casella[][] m) {

        Direzione direzione = Direzione.randomDirection();

        Posizione p;
        Casella successiva = getCasellaSuccessiva(m, direzione);

        if(isPassable(m, successiva.getPosizione().getX(), successiva.getPosizione().getY())){
            p = new Posizione(successiva.getPosizione().getX(), successiva.getPosizione().getY());
            this.setPosizione(p);
        }
    }
}