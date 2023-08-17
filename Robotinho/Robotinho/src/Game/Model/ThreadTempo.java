package Game.Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThreadTempo extends Thread{
    private Gioco g;
    public ThreadTempo(Gioco g) {
        this.g = g;
    }

    @Override
    public void run() {
        super.run();
        long lastimeLavatrice = System.currentTimeMillis();
        long lastimeRubinetto = System.currentTimeMillis();
        long lasttimeFornello = System.currentTimeMillis();

        while (true) {
            long tempoLavatrice = (System.currentTimeMillis() - lastimeLavatrice) / 1000;
            long tempoRubinetto = (System.currentTimeMillis() - lastimeRubinetto) / 1000;
            long tempoFornello = (System.currentTimeMillis() - lasttimeFornello) / 1000;

            if (tempoLavatrice > 10) {
                g.perdiAcquaLavatrice();
                lastimeLavatrice = System.currentTimeMillis();

            }
            if (tempoRubinetto > 15) {
                g.perdiAcquaRubinetto();
                lastimeRubinetto = System.currentTimeMillis();
            }
            if (tempoFornello > 7) {
                g.accendiFornello();
                lasttimeFornello = System.currentTimeMillis();
            }
        }

    }
}
