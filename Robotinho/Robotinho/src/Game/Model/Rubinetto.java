package Game.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * @author Adil Lagzouli 20045391
 * @author Samuele Giallorenzo 20045100
 * @author Federico Mannisi 20045099
 */

public class Rubinetto extends ElementoRompibile {

    private static ArrayList<Rubinetto> rubinetto =new ArrayList<>();


    /**
     * Costruttore per la classe Rubinetto.
     *
     * @param posizionex Indica la coordinata X della posizione del rubinetto.
     * @param posizioney Indica la coordinata Y della posizione del rubinetto.
     * @param visibile  Indica se il rubinetto è visibile nella mappa.
     */
    public Rubinetto(int posizionex, int posizioney,boolean visibile) {
        super(posizionex, posizioney,visibile);
        rubinetto.add(this);
    }

    /**
     * Restituisce una stringa che indica il tipo di oggetto, ovvero "Rubinetto".
     *
     * @return la stringa "Rubinetto".
     */
    @Override
    public String tipo() {
        return "Rubinetto";
    }

    public static Posizione rompiRubinettoRandom(){
        int rnd= new Random().nextInt(rubinetto.size());
        rubinetto.get(rnd).inizioPerdita(true);
        return rubinetto.get(rnd).getPosizione();
    }

    public static void perditaRubinetto(Casella[][] m, HashMap<Posizione,StatoCasella> s){
        for (Rubinetto r: rubinetto
        ) {
            if (r.isStato()) r.perdita(m,s);
        }
    }
}