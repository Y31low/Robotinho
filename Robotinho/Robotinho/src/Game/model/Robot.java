package Game.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Robot extends Casella implements Movable{
    private Mappa m;
    private Direzione direzione;


    public Robot(int posizionex, int posizioney, Direzione direzione) {
        super(posizionex, posizioney);
        this.direzione = direzione;
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
    public void Avanza() {
        int i = this.getPosizionex();
        int j = this.getPosizioney();
        switch (this.direzione) {
            case North:
                this.setDirezione(Direzione.North);
                if (this.getPosizionex() - 1 != 0)
                    this.setPosizionex(this.getPosizionex() - 1);
                break;
            case West:
                this.setDirezione(Direzione.West);
                if (this.getPosizioney() - 1 != 0)
                    this.setPosizioney(this.getPosizioney() - 1);
                break;
            case East:
                this.setDirezione(Direzione.East);
                if (this.getPosizioney() + 1 != 9)
                    this.setPosizioney(this.getPosizioney() + 1);
                break;
            case South:
                this.setDirezione(Direzione.South);
                if (this.getPosizionex() + 1 != 9)
                    this.setPosizionex(this.getPosizionex() + 1);
                break;
            default:
                break;
        }
    }

    @Override
    public void giraSx() {
        switch (this.direzione) {
            case North:
            case South:
                this.setDirezione(Direzione.West);
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
            case South:
                this.setDirezione(Direzione.East);
                break;
            case West:
                this.setDirezione(Direzione.North);
                break;
            case East:
                this.setDirezione(Direzione.South);
                break;
        }



    }



}
