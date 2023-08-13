package Game.model;

public interface Movable {
    void Avanza(Mappa m);

    boolean isPassable(Mappa m, int x, int y);
    void giraDx();
    void giraSx();

}
