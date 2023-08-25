package Test;
import Game.Model.Fornello;
import Game.Model.StatoCasella;
import Game.Model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;

class RobotTest {
    Robot r;
    Posizione p;
    Casella[][] m;
    Fornello f;
    Rubinetto rubinetto;
    Lavatrice l;
    HashMap<Posizione, StatoCasella> stato;

    @BeforeEach
    void setup(){
        r = new Robot(1,2,true, Direzione.South);
        m = new Casella[6][6];
        stato = new HashMap<>();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                m[i][j] = new Pavimento(i, j, true);
            }
        }
        m[1][2] = r;

        stato.put(m[2][2].getPosizione(), new StatoCasella(new Posizione(2, 2), true, true));
    }
    @org.junit.jupiter.api.Test
    void tipo() {
        Assertions.assertEquals("Robot", r.tipo());
    }

    @org.junit.jupiter.api.Test
    void setDirezione() {
        r.setDirezione(Direzione.East);
        Assertions.assertEquals(Direzione.East, r.getDirezione());
    }

    @org.junit.jupiter.api.Test
    void getDirezione() {
        Assertions.assertEquals(Direzione.South, r.getDirezione());
    }

    @org.junit.jupiter.api.Test
    void avanza(){
        p = new Posizione(2, 2);
        r.Avanza(m);
        Assertions.assertTrue(p.equals(r.getPosizione()));
    }

    @org.junit.jupiter.api.Test
    void giraSx() {
        r.giraSx();
        Assertions.assertEquals(Direzione.East, r.getDirezione());
    }

    @org.junit.jupiter.api.Test
    void giraDx() {
        r.giraDx();
        Assertions.assertEquals(Direzione.West, r.getDirezione());
    }

    @org.junit.jupiter.api.Test
    void asciuga() {
    }

    @org.junit.jupiter.api.Test
    void spegniFornello() {
        f = new Fornello(2, 2, true);
        m[2][2] = f;
        f.setAcceso(true);
        r.spegniFornello(m);
        Assertions.assertFalse(f.getAcceso());
    }

    @org.junit.jupiter.api.Test
    void interrompiLavatrice() {
        l = new Lavatrice(2, 2, true);
        m[2][2] = l;
        l.inizioPerdita(true);
        r.interrompiLavatrice(m);
        Assertions.assertFalse(l.isStato());
    }

    @org.junit.jupiter.api.Test
    void interrompiRubinetto() {
        rubinetto = new Rubinetto(2, 2, true);
        m[2][2] = rubinetto;
        rubinetto.inizioPerdita(true);
        r.interrompiRubinetto(m);
        Assertions.assertFalse(rubinetto.isStato());
    }
}