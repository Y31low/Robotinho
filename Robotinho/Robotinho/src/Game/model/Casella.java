package Game.model;

public abstract class Casella {
    private int posizionex;
    private int posizioney;
    private boolean visibile;


    public Casella(int posizionex, int posizioney,boolean visibile) {
        this.posizionex = posizionex;
        this.posizioney = posizioney;
        this.visibile= visibile;
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

    public boolean isVisibile() {
        return visibile;
    }

    public void setVisibile(boolean visibile) {
        this.visibile = visibile;
    }

}
