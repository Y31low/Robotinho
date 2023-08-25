package Test;

import Game.Model.Pavimento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

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