package Game.Model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;

/**
 * @author Adil Lagzouli 20045391
 * @author Samuele Giallorenzo 20045100
 * @author Federico Mannisi 20045099
 */

public class ThreadTempo extends Thread  {
    private Casella[][] m;
    private HashMap<Posizione,StatoCasella> s;
    private PropertyChangeSupport support;

    /**
     * Costruttore per creare un nuovo oggetto ThreadTempo.
     *
     * @param m Rappresenta il gioco associato al thread.
     * @param s
     */
    public ThreadTempo(Casella[][]m, HashMap<Posizione,StatoCasella>s) {
        this.m=m;
        this.s=s;
        this.support = new PropertyChangeSupport(this);
    }

    /**
     * Esegue il thread dedicato al controllo del tempo di gioco e alla gestione degli eventi periodici.
     */
    @Override
    public void run() {
        super.run();
        long lasTimeLavatrice = System.currentTimeMillis();
        long lasTimeRubinetto = System.currentTimeMillis();
        long lastTimeFornello = System.currentTimeMillis();
        Posizione p;
        Posizione lastPfornello=new Posizione(0,0);


        while (true) {
            long tempoLavatrice = (System.currentTimeMillis() - lasTimeLavatrice) / 1000;
            long tempoRubinetto = (System.currentTimeMillis() - lasTimeRubinetto) / 1000;
            long tempoFornello = (System.currentTimeMillis() - lastTimeFornello) / 1000;


            if (tempoLavatrice > 10) {
                Lavatrice.perditaLavatrici(m,s);
                lasTimeLavatrice = System.currentTimeMillis();
                this.support.firePropertyChange("TimerLavatrice", tempoLavatrice,lasTimeLavatrice);
            }
            if (tempoRubinetto > 15) {
                Rubinetto.perditaRubinetto(m,s);
                lasTimeRubinetto = System.currentTimeMillis();
                this.support.firePropertyChange("TimerRubinetto", lasTimeRubinetto,tempoRubinetto);
            }
            if (tempoFornello > 7) {
                p=Fornello.accendiFornelloRandom();
                lastTimeFornello = System.currentTimeMillis();
                this.support.firePropertyChange("TimerFornello",lastPfornello ,p);
                lastPfornello=p;
            }
        }
    }

    /**
     * Aggiunge un osservatore per ricevere notifiche di cambiamenti temporizzati.
     *
     * @param observer L'osservatore da aggiungere.
     */
    public void addObserver(PropertyChangeListener observer) {
        this.support.addPropertyChangeListener(observer);
    }
}
