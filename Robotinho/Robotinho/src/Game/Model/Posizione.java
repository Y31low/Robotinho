package Game.Model;

import java.util.Objects;

public class Posizione {
    private int x;
    private int y;

    public Posizione(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posizione posizione = (Posizione) o;
        return (x == posizione.x) && (y == posizione.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
