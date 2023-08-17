package Game.Model;

public class Gatto extends Casella implements Movable {
    private Mappa m;
    public Gatto(int x, int y,boolean visibile){
        super(x, y,visibile);
    }
    @Override
    public String tipo() {
        return "Cat";
    }

    @Override
    public void Avanza(Mappa m) {

        Direzione direzione = Direzione.randomDirection();

        Posizione p;

        switch(direzione){
            case North:
                if(isPassable(m, this.getPosizione().getX()-1, this.getPosizione().getY())){
                    p = new Posizione(this.getPosizione().getX()-1, this.getPosizione().getY());
                    this.setPosizione(p);
                }
                break;
            case East:
                if(isPassable(m, this.getPosizione().getX(), this.getPosizione().getY()+1)){
                    p = new Posizione(this.getPosizione().getX(), this.getPosizione().getY()+1);
                    this.setPosizione(p);
                }
                break;
            case South:
                if(isPassable(m, this.getPosizione().getX() + 1, this.getPosizione().getY())){
                    p = new Posizione(this.getPosizione().getX() + 1, this.getPosizione().getY());
                    this.setPosizione(p);
                }
                break;
            case West:
                if(isPassable(m, this.getPosizione().getX(), this.getPosizione().getY() -1)){
                    p = new Posizione(this.getPosizione().getX(), this.getPosizione().getY() - 1);
                    this.setPosizione(p);
                }
                break;
        }
    }
}
