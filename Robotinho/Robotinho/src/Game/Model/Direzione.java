package Game.Model;
import java.util.Random;
/**
 * @author Adil Lagzouli 20045391
 * @author Samuele Giallorenzo 20045100
 * @author Federico Mannisi 20045099
 */
public enum Direzione {

    North,
    West,
    South,
    East;

    private static final Random PRNG = new Random();

    /**
     * Genera una direzione casuale.
     *
     * @return una direzione casuale scelta tra le possibili direzioni.
     */
    public static Direzione randomDirection()  {
        Direzione[] direzioni = values();
        return direzioni[PRNG.nextInt(direzioni.length)];
    }
}
