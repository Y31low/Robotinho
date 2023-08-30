package Game.Model;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Adil Lagzouli 20045391
 * @author Samuele Giallorenzo 20045100
 * @author Federico Mannisi 20045099
 */

public class Fornello extends Casella{
    private Boolean acceso;
    private static ArrayList<Fornello> fornelli=new ArrayList<>();
    /**
     * Costruisce un nuovo oggetto Fornello con le coordinate specificate e la visibilità indicata.
     *
     * @param x        Coordinata x della posizione del Fornello nella mappa.
     * @param y        Coordinata y della posizione del Fornello nella mappa.
     * @param visibile Indica se il Fornello è visibile nella mappa.
     */
    public Fornello(int x, int y,boolean visibile){
        super(x, y,visibile);
        this.acceso = false;
        fornelli.add(this);
    }

    /**
     * Restituisce una stringa che rappresenta il tipo di oggetto, ovvero "Fornello".
     *
     * @return La stringa "Fornello".
     */
    @Override
    public String tipo() {
        return "Fornello";
    }

    /**
     * Ottiene lo stato attuale del Fornello (acceso/spento).
     *
     * @return Lo stato attuale del Fornello (true se acceso, false se spento).
     */
    public Boolean getAcceso() {
        return acceso;
    }

    /**
     * Imposta lo stato del Fornello a true o false, in base al parametro "acceso".
     *
     * @param acceso Il nuovo stato del Fornello (true per accendere, false per spegnere).
     */
    public void setAcceso(Boolean acceso) {
        this.acceso = acceso;
    }

    /**
     * Accende casualmente un fornello e restituisce la posizione del fornello acceso.
     *
     * @return La posizione del fornello acceso.
     */
    public static Posizione accendiFornelloRandom(){
        int rnd= new Random().nextInt(fornelli.size());
        fornelli.get(rnd).setAcceso(true);
        return  fornelli.get(rnd).getPosizione();
    }
}