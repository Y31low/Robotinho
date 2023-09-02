package Game.Test;

import Game.Model.Pavimento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

/**
 * @author Adil Lagzouli 20045391
 * @author Samuele Giallorenzo 20045100
 * @author Federico Mannisi 20045099
 */

class PavimentoTest {
    Pavimento p;
    @BeforeEach
    void setup(){
        p = new Pavimento(1,4,true);
    }
    @org.junit.jupiter.api.Test
    void tipo() {
        Assertions.assertEquals("Pavimento",p.tipo());
    }
}