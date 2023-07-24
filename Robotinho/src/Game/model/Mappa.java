package Game.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeListenerProxy;
import java.beans.PropertyChangeSupport;

public class Mappa implements Cloneable {
    private int N;

    private int robotx;
    private Robot r;
    private int roboty;

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
        this.mappa[1][1] = new Robot(1,1,Direzione.South);
        r=(Robot)this.mappa[1][1];
        robotx=this.mappa[1][1].getPosizionex();
        roboty=this.mappa[1][1].getPosizioney();

    }

    public void aggiornaMappa() {
        this.mappa[robotx][roboty]=new Pavimento(robotx,roboty,0);
        robotx= r.getPosizionex();
        roboty=r.getPosizioney();
        this.mappa[robotx][roboty]=r;
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

    public void printMap(){
        for (int i = 0; i < this.N; i++) {
            for (int j = 0; j < this.N; j++) {
                System.out.print("|"+mappa[i][j].toString()+"|");
            }
            System.out.println();
        }

    }

}