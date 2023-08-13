package Game.model;
import java.util.Random;

public class Gatto extends Casella implements Movable {
    private Mappa m;
    public Gatto(int x, int y,boolean visibile){
        super(x, y,visibile);
    }

    public String toString() {
        return "Cat";
    }

    @Override
    public boolean isPassable(Mappa m, int x, int y) {
        return m.getMappa()[x][y].toString().equals("Pavimento");
    }

    @Override
    public void Avanza(Mappa m) {

        Random random = new Random();
        /*0 = North; 1 = East; 2 = South; 3 = West; 4 = DoNothing*/
        int direzione = random.nextInt(5);

        Posizione p;

        switch(direzione){
            case 0:
                if(isPassable(m, this.getPosizione().getX() - 1, this.getPosizione().getY())){
                    p = new Posizione(this.getPosizione().getX() - 1, this.getPosizione().getY());
                    this.setPosizione(p);
                }
                break;
            case 1:
                if(isPassable(m, this.getPosizione().getX(), this.getPosizione().getY() +1)){
                    p = new Posizione(this.getPosizione().getX(), this.getPosizione().getY() + 1);
                    this.setPosizione(p);
                }
                break;
            case 2:
                if(isPassable(m, this.getPosizione().getX() + 1, this.getPosizione().getY())){
                    p = new Posizione(this.getPosizione().getX() + 1, this.getPosizione().getY());
                    this.setPosizione(p);
                }
                break;
            case 3:
                if(isPassable(m, this.getPosizione().getX(), this.getPosizione().getY() -1)){
                    p = new Posizione(this.getPosizione().getX(), this.getPosizione().getY() - 1);
                    this.setPosizione(p);
                }
                break;
            case 4:
                break;
        }

    }

    @Override
    public void giraDx() {

    }

    @Override
    public void giraSx(){

    }
}
