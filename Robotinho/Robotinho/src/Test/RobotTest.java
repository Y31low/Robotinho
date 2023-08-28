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
        assertEquals(p, r.getPosizione());
    }

    @org.junit.jupiter.api.Test
    void avanzaBump(){
        Exception exception = assertThrows(RuntimeException.class, () -> {
            m[r.getPosizione().getX()+1][r.getPosizione().getY()]=new Muro(r.getPosizione().getX()+1,r.getPosizione().getY(),true);
            r.Avanza(m);
        });

        String msgE = "BUMP";
        String msg = exception.getMessage();

        assertTrue(msg.contains(msgE));
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
        stato.put(r.getPosizione(),new StatoCasella(r.getPosizione(),true,true));
        r.Asciuga(stato);
        Assertions.assertFalse(stato.get(r.getPosizione()).getStato());
    }
    @org.junit.jupiter.api.Test
    public void asciugaCasellaNonBagnata() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            stato.put(r.getPosizione(),new StatoCasella(r.getPosizione(),true,false));
            r.Asciuga(stato);
        });

        String msgE = "La casella non è bagnata!";
        String msg = exception.getMessage();

        assertTrue(msg.contains(msgE));
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
    void forneloGiaSpento(){
        Exception exception = assertThrows(RuntimeException.class, () -> {
            Fornello f=new Fornello(r.getPosizione().getX()+1,r.getPosizione().getY(),true);
            m[r.getPosizione().getX()+1][r.getPosizione().getY()]=f;
            r.spegniFornello(m);
        });

        String msgE = "Il fornello e' gia spento!";
        String msg = exception.getMessage();

        assertTrue(msg.contains(msgE));
    }

    @org.junit.jupiter.api.Test
    void nessunFornelloDirezione(){
        Exception exception = assertThrows(RuntimeException.class, () -> r.spegniFornello(m));

        String msgE = "Nessun fornello nella mia direzione!";
        String msg = exception.getMessage();

        assertTrue(msg.contains(msgE));
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
    void lavatriceNonRotta(){
        Exception exception = assertThrows(RuntimeException.class, () -> {
            Lavatrice l=new Lavatrice(r.getPosizione().getX()+1,r.getPosizione().getY(),true);
            m[r.getPosizione().getX()+1][r.getPosizione().getY()]=l;
            r.interrompiLavatrice(m);
        });

        String msgE = "La lavatrice non è rotta!";
        String msg = exception.getMessage();

        assertTrue(msg.contains(msgE));
    }
    @org.junit.jupiter.api.Test
    void nessunaLavatriceDirezione(){
        Exception exception = assertThrows(RuntimeException.class, () -> r.interrompiLavatrice(m));

        String msgE = "Nessuna lavatrice nella mia direzione!";
        String msg = exception.getMessage();

        assertTrue(msg.contains(msgE));
    }

    @org.junit.jupiter.api.Test
    void interrompiRubinetto() {
        rubinetto = new Rubinetto(2, 2, true);
        m[2][2] = rubinetto;
        rubinetto.inizioPerdita(true);
        r.interrompiRubinetto(m);
        Assertions.assertFalse(rubinetto.isStato());
    }


    @org.junit.jupiter.api.Test
    void rubinettoNonRotto(){
        Exception exception = assertThrows(RuntimeException.class, () -> {
            Rubinetto rubinetto=new Rubinetto(r.getPosizione().getX()+1,r.getPosizione().getY(),true);
            m[r.getPosizione().getX()+1][r.getPosizione().getY()]=rubinetto;
            r.interrompiRubinetto(m);
        });

        String msgE = "Il rubinetto non è rotto!";
        String msg = exception.getMessage();

        assertTrue(msg.contains(msgE));
    }
    @org.junit.jupiter.api.Test
    void nessunRubinettoDirezione(){
        Exception exception = assertThrows(RuntimeException.class, () -> r.interrompiRubinetto(m));

        String msgE = "Nessun rubinetto nella mia direzione!";
        String msg = exception.getMessage();

        assertTrue(msg.contains(msgE));
    }
}