package Test;

import Game.Model.Gioco;
import Game.Model.Posizione;
import Game.Model.StatoCasella;
import org.junit.jupiter.api.BeforeEach;
import java.util.HashMap;

/**
 * @author Adil Lagzouli 20045391
 * @author Samuele Giallorenzo 20045100
 * @author Federico Mannisi 20045099
 */

class GiocoTest {
    Gioco g;
    HashMap<Posizione, StatoCasella> stato;

    @BeforeEach
    void setup(){
        g = new Gioco(6);
        stato=new HashMap<>();
    }

    @org.junit.jupiter.api.Test
    void avanza() {
    }

    @org.junit.jupiter.api.Test
    void giraDx() {
    }

    @org.junit.jupiter.api.Test
    void giraSx() {
    }

    @org.junit.jupiter.api.Test
    void asciuga() {
    }

    @org.junit.jupiter.api.Test
    void spegniFornello() {
    }

    @org.junit.jupiter.api.Test
    void perdiAcquaLavatrice() {
    }

    @org.junit.jupiter.api.Test
    void perdiAcquaRubinetto() {
    }

    @org.junit.jupiter.api.Test
    void aggiustaPerditaLavatrice() {
    }

    @org.junit.jupiter.api.Test
    void aggiustaPerditaRubinetto() {
    }

    @org.junit.jupiter.api.Test
    void accendiFornello() {
    }

    @org.junit.jupiter.api.Test
    void getMappa() {
    }

    @org.junit.jupiter.api.Test
    void getStatoCasella() {
        g.perdiAcquaLavatrice();
        //Assertions.assertTrue(g.getStatoCasella());
    }
}