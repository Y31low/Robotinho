package Test;

import Game.Model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RubinettoTest {
    Rubinetto r;
    Casella[][] m;
    HashMap<Posizione, StatoCasella> stato;
    @BeforeEach
    void setup(){
        r=new Rubinetto(2,4,true);
        m=new Casella[6][6];
        stato=new HashMap<>();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                m[i][j] = new Pavimento(i, j, true);
            }
        }
        m[2][4]=r;
        stato.put(m[1][4].getPosizione(),new StatoCasella(new Posizione(1,4),true,false));
        stato.put(m[3][4].getPosizione(),new StatoCasella(new Posizione(3,4),true,false));
        stato.put(m[2][3].getPosizione(),new StatoCasella(new Posizione(2,3),true,false));
        stato.put(m[2][5].getPosizione(),new StatoCasella(new Posizione(2,5),true,false));

    }
    @org.junit.jupiter.api.Test
    void tipo() {
        Assertions.assertEquals("Rubinetto",r.tipo());
    }

    @org.junit.jupiter.api.Test
    void perdita() {
        boolean perdita=false;
        r.perdita(m,stato);
        for (Map.Entry<Posizione, StatoCasella> entry : stato.entrySet()) {
            Posizione p = entry.getKey();
            StatoCasella s = entry.getValue();
            perdita = s.getStato();
        }
        Assertions.assertEquals(true,perdita);

    }

    @org.junit.jupiter.api.Test
    void espandiPerdita() {
    }

    @org.junit.jupiter.api.Test
    void isStato() {
    }

    @org.junit.jupiter.api.Test
    void interrompiPerdita() {
    }
}