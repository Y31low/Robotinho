package Game.Test;

import Game.Model.Posizione;
import Game.Model.StatoCasella;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

/**
 * @author Adil Lagzouli 20045391
 * @author Samuele Giallorenzo 20045100
 * @author Federico Mannisi 20045099
 */
class StatoCasellaTest {
    StatoCasella s;

    @BeforeEach
    void setup(){
        s = new StatoCasella(new Posizione(3,4),true,false);
    }

    @org.junit.jupiter.api.Test
    void setStatoFalse() {
        s.setStato(false);
        Assertions.assertFalse(s.getStato());
    }

    @org.junit.jupiter.api.Test
    void setStatoTrue() {
        s.setStato(true);
        Assertions.assertTrue(s.getStato());
    }

    @org.junit.jupiter.api.Test
    void tipo() {
        Assertions.assertEquals("Stato Casella", s.tipo());
    }
}