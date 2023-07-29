package Game.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeListenerProxy;
import java.beans.PropertyChangeSupport;

public class Mappa implements Cloneable {
    private int N;
    private Robot r;
    private int robotx, roboty;
    private Gatto g;
    private int gattox, gattoy;
    private Lavatrice lavatrice;
    private int lavax, lavay;

    private Rubinetto rubinetto;
    private int rubinettox, rubinettoy;

    private Fornello fornello;
    private int fornellox, fornelloy;

    Casella[][] mappa;

    public Mappa() {
        this.N = 10;
        this.mappa = new Casella[this.N][this.N];
        this.inizializza();
    }
    public Mappa(int N) {
        this.N = N;
        this.mappa = new Casella[this.N][this.N];
    }

    private void inizializza() {
        for (int i = 0; i < this.N; i++) {
            for (int j = 0; j < this.N; j++) {
                if (i == 0 || j == 0 || i == N - 1 || j == N - 1) {
                    this.mappa[i][j] = new Muro(i, j);
                } else {
                    this.mappa[i][j] = new Pavimento(i, j, 0);
                }
            }
        }
        this.mappa[5][7] = new Fornello(5,7);
        fornello=(Fornello)this.mappa[5][7];
        fornellox = this.mappa[5][7].getPosizionex();
        fornelloy = this.mappa[5][7].getPosizioney();

        this.mappa[4][4] = new Lavatrice(4,4);
        lavatrice=(Lavatrice)this.mappa[4][4];
        lavax = this.mappa[4][4].getPosizionex();
        lavay = this.mappa[4][4].getPosizioney();

        this.mappa[7][1] = new Rubinetto(7,1);
        rubinetto = (Rubinetto)this.mappa[7][1];
        rubinettox = this.mappa[7][1].getPosizionex();
        rubinettoy = this.mappa[7][1].getPosizioney();

        this.mappa[8][8] = new Gatto(8,8);
        g=(Gatto)this.mappa[8][8];
        gattox = this.mappa[8][8].getPosizionex();
        gattoy = this.mappa[8][8].getPosizioney();

        this.mappa[1][1] = new Robot(1,1,Direzione.South);
        r=(Robot)this.mappa[1][1];
        robotx=this.mappa[1][1].getPosizionex();
        roboty=this.mappa[1][1].getPosizioney();
    }

    public void aggiornaMappa() {
        this.mappa[robotx][roboty] = new Pavimento(robotx,roboty,0);
        robotx = r.getPosizionex();
        roboty =r.getPosizioney();
        this.mappa[robotx][roboty] = r;
    }


    public int getDim() {
        return N;
    }

    public Casella[][] getMappa() {
        return mappa;
    }

    public Casella getRobot() {
        return this.mappa[1][1];
    }

    public Casella getGatto() {
        return this.mappa[8][8];
    }

    public void printMap(){
        for (int i = 0; i < this.N; i++) {
            for (int j = 0; j < this.N; j++) {
                System.out.print("|"+mappa[i][j].toString()+"|");
            }
            System.out.println();
        }
    }
}