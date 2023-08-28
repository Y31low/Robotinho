package Test;

import Game.Model.Muro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

/**
 * @author Adil Lagzouli 20045391
 * @author Samuele Giallorenzo 20045100
 * @author Federico Mannisi 20045099
 */

class MuroTest {
    Muro m;
    @BeforeEach
    public void setup() {
        m = new Muro(6, 6, true);
    }
    @org.junit.jupiter.api.Test
    void tipo() {
        Assertions.assertEquals("Muro", m.tipo());
    }
}