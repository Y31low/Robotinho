package Game.Test;

import Game.Model.Casella;
import Game.Model.Gatto;
import Game.Model.Pavimento;
import Game.Model.Posizione;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

/**
 * @author Adil Lagzouli 20045391
 * @author Samuele Giallorenzo 20045100
 * @author Federico Mannisi 20045099
 */

class GattoTest {
    Gatto g;
    Casella[][] m;

    @BeforeEach
    public void setup() {
        g = new Gatto(3, 5, true);
        m = new Casella[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                m[i][j] = new Pavimento(i, j, true);
            }
        }
        m[3][5] = g;
    }

    @org.junit.jupiter.api.Test
    void tipo() {
        Assertions.assertEquals("Gatto", g.tipo());
    }

    @org.junit.jupiter.api.Test
    void avanza() {
        boolean move = false;
        Posizione[] p= new Posizione[5];

        p[0]= g.getPosizione(); //salviamo la posizione corrente perchè il gatto può restare fermo
        p[1] = new Posizione(2,5);
        p[2] = new Posizione(4,5);
        p[3] = new Posizione(3,4);
        p[4] = new Posizione(3,6);

        g.Avanza(m);
        for (Posizione pos:p) {
            if (pos.equals(g.getPosizione())) {
                move = true;
                break;
            }
        }
        Assertions.assertTrue(move);
    }
}

