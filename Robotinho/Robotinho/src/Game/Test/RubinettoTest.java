package Game.Test;

import Game.Model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Adil Lagzouli 20045391
 * @author Samuele Giallorenzo 20045100
 * @author Federico Mannisi 20045099
 */

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
        boolean perdita = false;
        r.perdita(m,stato);
        for (Map.Entry<Posizione, StatoCasella> entry : stato.entrySet()) {
            StatoCasella s = entry.getValue();
            if (s.getStato()) {
                perdita = true;
                break;
            }
        }
        Assertions.assertTrue(perdita);
    }

    @org.junit.jupiter.api.Test
    void espandiPerdita() {
        stato.put(m[0][4].getPosizione(),new StatoCasella(m[0][4].getPosizione(),false,false));
        stato.get(m[1][4].getPosizione()).setStato(true);
        Posizione p= m[1][4].getPosizione();
        r.espandiPerdita(m,p,stato,Direzione.North);
        Assertions.assertTrue(stato.get(m[0][4].getPosizione()).getStato());
    }

    @org.junit.jupiter.api.Test
    void rubinettoRotto() {
        r.inizioPerdita(true);
        Assertions.assertTrue(r.isStato());
    }

    @org.junit.jupiter.api.Test
    void rubinettoNonRotto(){
        Assertions.assertFalse(r.isStato());
    }

    @org.junit.jupiter.api.Test
    void interrompiPerditaRubinetto() {
        r.inizioPerdita(true);
        r.interrompiPerdita();
        Assertions.assertFalse(r.isStato());
    }
}