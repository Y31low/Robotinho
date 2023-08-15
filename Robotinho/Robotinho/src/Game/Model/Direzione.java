package Game.Model;
import java.util.Random;
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
