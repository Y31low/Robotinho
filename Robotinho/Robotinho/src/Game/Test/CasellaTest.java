package Game.Test;

import Game.Model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

/**
 * @author Adil Lagzouli 20045391
 * @author Samuele Giallorenzo 20045100
 * @author Federico Mannisi 20045099
 */

class CasellaTest {
    Gatto g;
    Robot r;
    Casella[][] c;

    @BeforeEach
    public void setup() {
        g = new Gatto(3, 4, true);
        r = new Robot(1, 1, true, Direzione.South);
        c = new Casella[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                c[i][j] = new Pavimento(i, j, true);
            }
        }
        c[3][4] = g;
    }

    @org.junit.jupiter.api.Test
    void getCasellaNorth() {
        Posizione p = new Posizione(2, 4);
        Assertions.assertEquals(g.getCasellaSuccessiva(c, Direzione.North).getPosizione(), p);
    }
    @org.junit.jupiter.api.Test
    void getCasellaSouth() {
        Posizione p = new Posizione(4, 4);
        Assertions.assertEquals(g.getCasellaSuccessiva(c, Direzione.South).getPosizione(), p);
    }
    @org.junit.jupiter.api.Test
    void getCasellaWest() {
        Posizione p = new Posizione(3, 3);
        Assertions.assertEquals(g.getCasellaSuccessiva(c, Direzione.West).getPosizione(), p);
    }
    @org.junit.jupiter.api.Test
    void getCasellaEast() {
        Posizione p = new Posizione(3, 5);
        Assertions.assertEquals(g.getCasellaSuccessiva(c, Direzione.East).getPosizione(), p);
    }

    @org.junit.jupiter.api.Test
    void isPassableNorth() {
        Posizione p = g.getCasellaSuccessiva(c, Direzione.North).getPosizione();
        Assertions.assertTrue(g.isPassable(c, p.getX(), p.getY()));
    }
    @org.junit.jupiter.api.Test
    void isPassableSouth() {
        Posizione p = g.getCasellaSuccessiva(c, Direzione.South).getPosizione();
        Assertions.assertTrue(g.isPassable(c, p.getX(), p.getY()));
    }
    @org.junit.jupiter.api.Test
    void isPassableWest() {
        Posizione p = g.getCasellaSuccessiva(c, Direzione.West).getPosizione();
        Assertions.assertTrue(g.isPassable(c, p.getX(), p.getY()));
    }
    @org.junit.jupiter.api.Test
    void isPassableEast() {
        Posizione p = g.getCasellaSuccessiva(c, Direzione.East).getPosizione();
        Assertions.assertTrue(g.isPassable(c, p.getX(), p.getY()));
    }

    @org.junit.jupiter.api.Test
    void isVisibile() {
        Assertions.assertTrue(g.isVisibile());
    }

    @org.junit.jupiter.api.Test
    void setVisibile() {
        r.setVisibile(false);
        Assertions.assertFalse(r.isVisibile());
    }

    @org.junit.jupiter.api.Test
    void getPosizione() {
        Posizione pos = new Posizione(1, 1);
        Assertions.assertEquals( pos, r.getPosizione());
    }

    @org.junit.jupiter.api.Test
    void setPosizione() {
        Posizione pos = r.getCasellaSuccessiva(c, Direzione.East).getPosizione();
        Posizione pos2 = new Posizione(1, 2);
        r.setPosizione(pos);
        Assertions.assertEquals(pos2, r.getPosizione());
    }

    @org.junit.jupiter.api.Test
    void tipo() {
        Assertions.assertEquals("Gatto", g.tipo());
        Assertions.assertEquals("Robot", r.tipo());
    }
}