package Test;

import Game.Model.Direzione;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class DirezioneTest {

    Direzione[] direzioni;

    @BeforeEach
    void setup(){
        direzioni = new Direzione[4];
        direzioni[0] = Direzione.North;
        direzioni[1] = Direzione.East;
        direzioni[2] = Direzione.West;
        direzioni[3] = Direzione.South;
    }

    @org.junit.jupiter.api.Test
    void randomDirection() {
        boolean check = false;
        Direzione rand = Direzione.randomDirection();
        for(Direzione dir:direzioni){
            if(dir.equals(rand)) check = true;
        }
        Assertions.assertTrue(check);
    }
}