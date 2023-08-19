package Game.Model;

import javax.swing.event.SwingPropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class ThreadTempo extends Thread{
    private final Gioco g;
    private final SwingPropertyChangeSupport support;
    public ThreadTempo(Gioco g) {
        this.g = g;
        this.support=new SwingPropertyChangeSupport(this);
    }

    @Override
    public void run() {
        super.run();
        long lasTimeLavatrice = System.currentTimeMillis();
        long lasTimeRubinetto = System.currentTimeMillis();
        long lastTimeFornello = System.currentTimeMillis();
        Posizione p;

        while (true) {
            long tempoLavatrice = (System.currentTimeMillis() - lasTimeLavatrice) / 1000;
            long tempoRubinetto = (System.currentTimeMillis() - lasTimeRubinetto) / 1000;
            long tempoFornello = (System.currentTimeMillis() - lastTimeFornello) / 1000;

            if (tempoLavatrice > 10) {
                p=g.perdiAcquaLavatrice();
                lasTimeLavatrice = System.currentTimeMillis();
                this.support.firePropertyChange("TimerLavatrice", null,p);

            }
            if (tempoRubinetto > 15) {
                p=g.perdiAcquaRubinetto();
                lasTimeRubinetto = System.currentTimeMillis();
                this.support.firePropertyChange("TimerRubinetto", null,p);
            }
            if (tempoFornello > 7) {
                p=g.accendiFornello();
                lastTimeFornello = System.currentTimeMillis();
                this.support.firePropertyChange("TimerFornello", null,p);
            }
        }
    }
    public void addObserver(PropertyChangeListener observer) {
        this.support.addPropertyChangeListener(observer);
    }

}
