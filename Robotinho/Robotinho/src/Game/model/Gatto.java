package Game.model;

public class Gatto extends Casella implements Movable {
    private Mappa m;
    public Gatto(int x, int y){
        super(x, y);
    }

    public String toString() {
        return "Cat";
    }

    @Override
    public void Avanza() {

    }

    @Override
    public void giraDx() {

    }

    @Override
    public void giraSx(){

    }
}
