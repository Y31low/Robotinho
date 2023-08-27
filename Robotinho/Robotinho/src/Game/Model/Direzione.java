package Game.Model;
import java.util.Random;
/**
 * Questa enumerazione rappresenta le diverse direzioni possibili.
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

    public static Direzione randomDirection()  {
        Direzione[] direzioni = values();
        return direzioni[PRNG.nextInt(direzioni.length)];
    }
}
