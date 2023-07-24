package Game.model;

public abstract class Casella {
    private int posizionex;
    private int posizioney;

    public Casella(int posizionex, int posizioney) {
        this.posizionex = posizionex;
        this.posizioney = posizioney;
    }

    public int getPosizionex() {
        return posizionex;
    }

    public void setPosizionex(int posizionex) {
        this.posizionex = posizionex;
    }

    public int getPosizioney() {
        return posizioney;
    }

    public void setPosizioney(int posizioney) {
        this.posizioney = posizioney;
    }
}
