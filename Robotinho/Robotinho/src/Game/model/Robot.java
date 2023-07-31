package Game.model;

import javax.swing.*;
import java.util.ArrayList;

public class Robot extends Casella implements Movable{
    //private Mappa m ;
    private Direzione direzione;
    private ArrayList<Casella> vicini;

    public Robot(int posizionex, int posizioney, Direzione direzione) {
        super(posizionex, posizioney);
        this.direzione = direzione;
        vicini= new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Robot";
    }

    public void setDirezione(Direzione direzione) {
        this.direzione = direzione;
    }

    public Direzione getDirezione() {
        return direzione;
    }

    @Override
    public boolean Avanza(Mappa m) {

        boolean bump=false;
        switch (this.direzione) {
            case North:
                this.setDirezione(Direzione.North);
                if (!this.vicini.get(0).toString().equals("Pavimento")){
                    bump = true;
                }
                else {
                    this.setPosizionex(this.getPosizionex() - 1);
                }
                break;
            case West:
                this.setDirezione(Direzione.West);
                if (!this.vicini.get(1).toString().equals("Pavimento")){
                    bump=true;
                }
                else{
                    this.setPosizioney(this.getPosizioney() - 1);
                }
                break;
            case East:
                this.setDirezione(Direzione.East);
                if (!this.vicini.get(2).toString().equals("Pavimento")){
                    bump=true;
                }
                else{
                    this.setPosizioney(this.getPosizioney() + 1);
                }

                break;
            case South:
                this.setDirezione(Direzione.South);
                if (!this.vicini.get(3).toString().equals("Pavimento")){
                    bump=true;
                }
                else {
                    this.setPosizionex(this.getPosizionex() + 1);
                }

                break;
            default:
                break;
        }

        return bump;
    }

    @Override
    public void giraSx() {
        switch (this.direzione) {
            case North:
                this.setDirezione(Direzione.West);
                break;
            case South:
                this.setDirezione(Direzione.East);
                break;
            case West:
                this.setDirezione(Direzione.South);
                break;
            case East:
                this.setDirezione(Direzione.North);
                break;
        }
    }

    public void giraDx() {
        switch (this.direzione) {
            case North:
                this.setDirezione(Direzione.East);
                break;
            case South:
                this.setDirezione(Direzione.West);
                break;
            case West:
                this.setDirezione(Direzione.North);
                break;
            case East:
                this.setDirezione(Direzione.South);
                break;
        }
    }

    public void interagisci(){

    }
    public void setVicini(ArrayList<Casella>vicini){
        this.vicini=vicini;
    }
}