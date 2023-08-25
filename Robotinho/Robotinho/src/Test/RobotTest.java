package Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {

    @org.junit.jupiter.api.Test
    void tipo() {
    }

    @org.junit.jupiter.api.Test
    void setDirezione() {
    }

    @org.junit.jupiter.api.Test
    void getDirezione() {
    }

    @org.junit.jupiter.api.Test
    void avanza() {
    }

    @org.junit.jupiter.api.Test
    void giraSx() {
        r.giraSx();
        Assertions.assertEquals(Direzione.East, r.getDirezione());
    }

    @org.junit.jupiter.api.Test
    void giraDx() {
    }

    @org.junit.jupiter.api.Test
    void asciuga() {
    }

    @org.junit.jupiter.api.Test
    void spegniFornello() {
    }

    @org.junit.jupiter.api.Test
    void interrompiLavatrice() {
        l = new Lavatrice(2, 2, true);
        m[2][2] = l;
        l.perdita(m, stato);
        r.interrompiLavatrice(m);
        Assertions.assertFalse(l.isStato());
    }

    @org.junit.jupiter.api.Test
    void interrompiRubinetto() {
        rubinetto = new Rubinetto(2, 2, true);
        m[2][2] = rubinetto;
        rubinetto.perdita(m , stato);
        r.interrompiRubinetto(m);
        Assertions.assertFalse(rubinetto.isStato());
    }
}