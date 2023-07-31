package Game.model;
import java.util.Random;

public class Gatto extends Casella implements Movable {
    private Mappa m;
    public Gatto(int x, int y){
        super(x, y);
    }

    public String toString() {
        return "Cat";
    }

    @Override
    public boolean Avanza(Mappa m) {
        int i = this.getPosizionex();
        int j = this.getPosizioney();

        Random random = new Random();
        /*0 = North; 1 = East; 2 = South; 3 = West; 4 = DoNothing*/
        int direzione = random.nextInt(5);

        switch(direzione){
            case 0:
                if((! m.getMappa()[getPosizionex()-1][getPosizioney()].toString().equals("Lavatrice")) &&
                        (! m.getMappa()[getPosizionex()-1][getPosizioney()].toString().equals("Fornello")) &&
                        (! m.getMappa()[getPosizionex()-1][getPosizioney()].toString().equals("Rubinetto")) &&
                        (! m.getMappa()[getPosizionex()-1][getPosizioney()].toString().equals("Robot")) &&
                        (! m.getMappa()[getPosizionex()-1][getPosizioney()].toString().equals("Muro")))
                    this.setPosizionex(this.getPosizionex() - 1);
                break;
            case 1:
                if((! m.getMappa()[getPosizionex()][getPosizioney()+1].toString().equals("Lavatrice")) &&
                        (! m.getMappa()[getPosizionex()][getPosizioney()+1].toString().equals("Fornello")) &&
                        (! m.getMappa()[getPosizionex()][getPosizioney()+1].toString().equals("Rubinetto")) &&
                        (! m.getMappa()[getPosizionex()][getPosizioney()+1].toString().equals("Robot")) &&
                        (! m.getMappa()[getPosizionex()][getPosizioney()+1].toString().equals("Muro")))
                    this.setPosizioney(this.getPosizioney() + 1);
                break;
            case 2:
                if((! m.getMappa()[getPosizionex()+1][getPosizioney()].toString().equals("Lavatrice")) &&
                        (! m.getMappa()[getPosizionex()+1][getPosizioney()].toString().equals("Fornello")) &&
                        (! m.getMappa()[getPosizionex()+1][getPosizioney()].toString().equals("Rubinetto")) &&
                        (! m.getMappa()[getPosizionex()+1][getPosizioney()].toString().equals("Robot")) &&
                        (! m.getMappa()[getPosizionex()+1][getPosizioney()].toString().equals("Muro")))
                    this.setPosizionex(this.getPosizionex() + 1);
                break;
            case 3:
                if((! m.getMappa()[getPosizionex()][getPosizioney()-1].toString().equals("Lavatrice")) &&
                        (! m.getMappa()[getPosizionex()][getPosizioney()-1].toString().equals("Fornello")) &&
                        (! m.getMappa()[getPosizionex()][getPosizioney()-1].toString().equals("Rubinetto")) &&
                        (! m.getMappa()[getPosizionex()][getPosizioney()-1].toString().equals("Robot")) &&
                        (! m.getMappa()[getPosizionex()][getPosizioney()-1].toString().equals("Muro")))
                    this.setPosizioney(this.getPosizioney() - 1);
                break;
            case 4:
                break;
        }
        return true;
    }

    @Override
    public void giraDx() {

    }

    @Override
    public void giraSx(){

    }
}
