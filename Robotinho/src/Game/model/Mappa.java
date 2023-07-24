package Game.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeListenerProxy;
import java.beans.PropertyChangeSupport;

public class Mappa implements Cloneable {
    private int N;
    private Robot r;
    private PropertyChangeSupport support;

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
        r= (Robot) this.mappa[1][1];
    }

    public void aggiornaMappa() {
        Casella temp;
        int x;
        int y;
        for (int i = 0; i < this.N; i++) {
            for (int j = 0; j < this.N; j++) {
                x = mappa[i][j].getPosizionex();
                y = mappa[i][j].getPosizioney();
                temp = mappa[x][y];
                mappa[x][y] = mappa[i][j];
                mappa[i][j] = temp;

            }
        }
    }


    public int getDim() {
        return N;
    }

    public Casella[][] getMappa() {
        return mappa;
    }

    public Casella getRobot() {
        return this.r;
    }
}
