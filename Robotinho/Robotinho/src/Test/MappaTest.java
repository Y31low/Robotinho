package Test;

import Game.Model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Adil Lagzouli 20045391
 * @author Samuele Giallorenzo 20045100
 * @author Federico Mannisi 20045099
 */

class MappaTest {
    Mappa m;

    @BeforeEach
    void setup(){
        m=new Mappa(6,1,2,2);
        m.inizializza();
        this.inizializza();
    }

    void inizializza(){
        for (int i = 0; i < 6;   i++) {
            for (int j = 0; j < 6; j++) {
                m.getMappa()[i][j]=new Pavimento(i,j,true);
                m.getStatoMappa().put(new Posizione(i,j),new StatoCasella(new Posizione(i,j),false,false));
            }
        }
    }


    @org.junit.jupiter.api.Test
    void aggiornaRobot() {
       Robot r = new Robot(1,2,true,Direzione.South);
       m.setR(r);
       m.setPosizioneRobot(r.getPosizione());
       r.Avanza(m.getMappa());
       m.aggiornaRobot();
       Assertions.assertInstanceOf(Pavimento.class,m.getMappa()[1][2]);
       Assertions.assertInstanceOf(Robot.class,m.getMappa()[2][2]);

    }

    @org.junit.jupiter.api.Test
    void aggiornaGatto() {
        Gatto g = new Gatto(1,2,true);
        m.setG(g);
        m.setPosizioneGatto(g.getPosizione());
        g.Avanza(m.getMappa());
        m.aggiornaGatto();
        Assertions.assertInstanceOf(Pavimento.class,m.getMappa()[1][2]);
        Assertions.assertInstanceOf(Gatto.class,m.getMappa()[g.getPosizione().getX()][g.getPosizione().getY()]);

    }

    @org.junit.jupiter.api.Test
    void getDim() {
        Assertions.assertEquals(6, m.getDim());
    }

    @org.junit.jupiter.api.Test
    void getMappa() {
        Assertions.assertInstanceOf(Casella[][].class,m.getMappa());
    }

    @org.junit.jupiter.api.Test
    void getRobot() {
        Assertions.assertInstanceOf(Robot.class,m.getRobot());
    }

    @org.junit.jupiter.api.Test
    void getStatoMappa() {
        Assertions.assertInstanceOf(HashMap.class, m.getStatoMappa());
    }

    @org.junit.jupiter.api.Test
    void getGatto() {
        Assertions.assertInstanceOf(Gatto.class,m.getGatto());
    }

    @org.junit.jupiter.api.Test
    void getLavatrice() {
        Assertions.assertInstanceOf(Lavatrice[].class,m.getLavatrice());
    }

    @org.junit.jupiter.api.Test
    void getRubinetto() {
        Assertions.assertInstanceOf(Rubinetto[].class,m.getRubinetto());
    }

    @org.junit.jupiter.api.Test
    void getFornello() {
        Assertions.assertInstanceOf(Fornello[].class,m.getFornello());
    }
}