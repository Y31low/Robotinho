package Test;

import Game.Model.Fornello;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Adil Lagzouli 20045391
 * @author Samuele Giallorenzo 20045100
 * @author Federico Mannisi 20045099
 */

class FornelloTest {
    Fornello f;
    @BeforeEach
    public void setup(){
        f= new Fornello(1,1,true);
    }

    @Test
     public void tipo() {
        Assertions.assertEquals("Fornello", f.tipo());
     }

    @Test
    void getSpento() {
        f.setAcceso(false);
        Assertions.assertEquals(false,f.getAcceso());
    }

    @Test
    void getAcceso(){
        f.setAcceso(true);
        Assertions.assertEquals(true, f.getAcceso());
    }
}