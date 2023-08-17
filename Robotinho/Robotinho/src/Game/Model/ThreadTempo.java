package Game.Model;

import javax.swing.event.SwingPropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class ThreadTempo extends Thread{
    private Gioco g;
    private SwingPropertyChangeSupport support;
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

        while (true) {
            long tempoLavatrice = (System.currentTimeMillis() - lasTimeLavatrice) / 1000;
            long tempoRubinetto = (System.currentTimeMillis() - lasTimeRubinetto) / 1000;
            long tempoFornello = (System.currentTimeMillis() - lastTimeFornello) / 1000;

            if (tempoLavatrice > 10) {
                g.perdiAcquaLavatrice();
                lasTimeLavatrice = System.currentTimeMillis();
                this.support.firePropertyChange("TimerLavatrice", lasTimeLavatrice,System.currentTimeMillis()/1000);

            }
            if (tempoRubinetto > 15) {
                g.perdiAcquaRubinetto();
                lasTimeRubinetto = System.currentTimeMillis();
                this.support.firePropertyChange("TimerRubinetto", lasTimeRubinetto,System.currentTimeMillis()/1000);
            }
            if (tempoFornello > 7) {
                g.accendiFornello();
                lastTimeFornello = System.currentTimeMillis();
                this.support.firePropertyChange("TimerFornello", lastTimeFornello,System.currentTimeMillis()/1000);
            }
        }


    }
    public void addObserver(PropertyChangeListener observer) {
        this.support.addPropertyChangeListener(observer);
    }

}
