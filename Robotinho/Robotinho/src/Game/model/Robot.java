package Game.model;

import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Robot extends Casella implements Movable{
    //private Mappa m ;
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
    public void Avanza(Mappa m) {
        int i = this.getPosizionex();
        int j = this.getPosizioney();
        switch (this.direzione) {
            case North:
                this.setDirezione(Direzione.North);

                if(m.getMappa()[getPosizionex()-1][getPosizioney()].toString().equals("Muro"))
                    JOptionPane.showMessageDialog(null,
                            "Bump! Non posso attraversare i muri!",
                            "BUMP",
                            JOptionPane.INFORMATION_MESSAGE);

                else if(m.getMappa()[getPosizionex()-1][getPosizioney()].toString().equals("Cat"))
                    JOptionPane.showMessageDialog(null,
                            "Bump! Non posso calpestare il gatto!!",
                            "BUMP",
                            JOptionPane.INFORMATION_MESSAGE);

                else if((! m.getMappa()[getPosizionex()-1][getPosizioney()].toString().equals("Lavatrice")) &&
                        (! m.getMappa()[getPosizionex()-1][getPosizioney()].toString().equals("Fornello")) &&
                        (! m.getMappa()[getPosizionex()-1][getPosizioney()].toString().equals("Rubinetto")))
                    this.setPosizionex(this.getPosizionex() - 1);

                break;
            case West:
                this.setDirezione(Direzione.West);

                if(m.getMappa()[getPosizionex()][getPosizioney()-1].toString().equals("Muro"))
                    JOptionPane.showMessageDialog(null,
                            "Bump! Non posso attraversare i muri!",
                            "BUMP",
                            JOptionPane.INFORMATION_MESSAGE);

                else if(m.getMappa()[getPosizionex()][getPosizioney()-1].toString().equals("Cat"))
                    JOptionPane.showMessageDialog(null,
                            "Bump! Non posso calpestare il gatto!!",
                            "BUMP",
                            JOptionPane.INFORMATION_MESSAGE);

                else if((! m.getMappa()[getPosizionex()][getPosizioney()-1].toString().equals("Lavatrice")) &&
                        (! m.getMappa()[getPosizionex()][getPosizioney()-1].toString().equals("Fornello")) &&
                        (! m.getMappa()[getPosizionex()][getPosizioney()-1].toString().equals("Rubinetto")))
                    this.setPosizioney(this.getPosizioney() - 1);

                break;
            case East:
                this.setDirezione(Direzione.East);

                if(m.getMappa()[getPosizionex()][getPosizioney()+1].toString().equals("Muro"))
                    JOptionPane.showMessageDialog(null,
                            "Bump! Non posso attraversare i muri!",
                            "BUMP",
                            JOptionPane.INFORMATION_MESSAGE);

                else if(m.getMappa()[getPosizionex()][getPosizioney()+1].toString().equals("Cat"))
                    JOptionPane.showMessageDialog(null,
                            "Bump! Non posso calpestare il gatto!!",
                            "BUMP",
                            JOptionPane.INFORMATION_MESSAGE);

                else if((! m.getMappa()[getPosizionex()][getPosizioney()+1].toString().equals("Lavatrice")) &&
                        (! m.getMappa()[getPosizionex()][getPosizioney()+1].toString().equals("Fornello")) &&
                        (! m.getMappa()[getPosizionex()][getPosizioney()+1].toString().equals("Rubinetto")))
                    this.setPosizioney(this.getPosizioney() + 1);

                break;
            case South:
                this.setDirezione(Direzione.South);

                if(m.getMappa()[getPosizionex()+1][getPosizioney()].toString().equals("Muro"))
                    JOptionPane.showMessageDialog(null,
                            "Bump! Non posso attraversare i muri!",
                            "BUMP",
                            JOptionPane.INFORMATION_MESSAGE);

                else if(m.getMappa()[getPosizionex()+1][getPosizioney()].toString().equals("Cat"))
                    JOptionPane.showMessageDialog(null,
                            "Bump! Non posso calpestare il gatto!!",
                            "BUMP",
                            JOptionPane.INFORMATION_MESSAGE);

                else if((! m.getMappa()[getPosizionex()+1][getPosizioney()].toString().equals("Lavatrice")) &&
                        (! m.getMappa()[getPosizionex()+1][getPosizioney()].toString().equals("Fornello")) &&
                        (! m.getMappa()[getPosizionex()+1][getPosizioney()].toString().equals("Rubinetto")))
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
}