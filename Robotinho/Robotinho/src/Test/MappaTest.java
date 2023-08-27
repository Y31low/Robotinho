package Test;

import Game.Model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MappaTest {
    Mappa m;

    @BeforeEach
    void setup(){
        m=new Mappa(6,1,2,2);
        m.inizializza();
    }
    @org.junit.jupiter.api.Test
    void inizializza() {

        for (int i = 0; i <m.getDim(); i++) {
            for (int j = 0; j < m.getDim(); j++) {
                System.out.print(m.getMappa()[i][j].tipo()+" |");
            }
            System.out.println();
        }
    }

    @org.junit.jupiter.api.Test
    void aggiornaRobot() {
        
    }

    @org.junit.jupiter.api.Test
    void aggiornaGatto() {
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