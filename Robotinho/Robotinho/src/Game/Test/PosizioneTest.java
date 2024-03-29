package Game.Test;

import Game.Model.Posizione;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

/**
 * @author Adil Lagzouli 20045391
 * @author Samuele Giallorenzo 20045100
 * @author Federico Mannisi 20045099
 */

class PosizioneTest {

    Posizione p;

    @BeforeEach
    void setup(){
        p = new Posizione(2, 3);
    }
    @org.junit.jupiter.api.Test
    void getX() {
        Assertions.assertEquals(2, p.getX());
    }

    @org.junit.jupiter.api.Test
    void getY() {
        Assertions.assertEquals(3, p.getY());
    }

    @org.junit.jupiter.api.Test
    void setX(){
        p.setX(5);
        Assertions.assertEquals(5, p.getX());
    }

    @org.junit.jupiter.api.Test
    void setY(){
        p.setY(6);
        Assertions.assertEquals(6,p.getY());
    }
}