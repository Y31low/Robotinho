package Game.Model;

import java.util.Objects;

public class Posizione {
    private int x;
    private int y;

    /**
     * Costruttore per la classe Posizione.
     *
     * @param x Indica la coordinata X della posizione sulla mappa.
     * @param y Indica la coordinata Y della posizione sulla mappa.
     */
    public Posizione(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Restituisce la coordinata X della posizione.
     *
     * @return la coordinata X della posizione.
     */
    public int getX() {
        return x;
    }

    /**
     * Imposta la coordinata X della posizione.
     *
     * @param x la nuova coordinata X della posizione.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Restituisce la coordinata Y della posizione.
     *
     * @return la coordinata Y della posizione.
     */
    public int getY() {
        return y;
    }

    /**
     * Imposta la coordinata Y della posizione.
     *
     * @param y la nuova coordinata Y della posizione.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Verifica se due oggetti Posizione sono uguali.
     *
     * @param o L'oggetto da confrontare con questa Posizione.
     * @return True se gli oggetti sono uguali, altrimenti False.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posizione posizione = (Posizione) o;
        return (x == posizione.x) && (y == posizione.y);
    }

    /**
     * Calcola il codice hash per l'oggetto Posizione.
     *
     * @return il codice hash calcolato.
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
