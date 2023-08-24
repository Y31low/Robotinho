package Test;

import Game.Model.Fornello;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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