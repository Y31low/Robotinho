package Game.Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

public class Gioco {
    private final Robot robot;
    private final Gatto gatto;
    private final Lavatrice[] lavatrice;
    private final Rubinetto[] rubinetto;
    private final Fornello[] fornello;
    private final Mappa mappa;
    private final HashMap<Posizione, StatoCasella> statoCasella;
    private final int N;//dimensione mappa
    private final int N_LAVATRICI=2;
    private final int N_FORNELLI=3;
    private final int N_RUBINETTI=2;

    public Gioco(int N) {
        this.mappa = new Mappa(10,N_LAVATRICI,N_FORNELLI,N_RUBINETTI);
        this.mappa.inizializza();
        this.robot = this.mappa.getRobot();
        this.gatto = this.mappa.getGatto();
        this.lavatrice = this.mappa.getLavatrice();
        this.rubinetto = this.mappa.getRubinetto();
        this.fornello = this.mappa.getFornello();
        this.statoCasella = this.mappa.getStatoMappa();
    }

    public Gioco(File f) {
        char[] in = new char[50];
        int size = 0;
        StringBuilder n = new StringBuilder();
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            size = br.read(in);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < size; i++) {
            n.append(in[i]);
        }
        System.out.println(n);
        int dimensione = Integer.parseInt(n.toString());
        this.mappa = new Mappa(dimensione,N_LAVATRICI,N_FORNELLI,N_RUBINETTI);
        this.mappa.inizializza();
        this.robot = this.mappa.getRobot();
        this.gatto = this.mappa.getGatto();
        this.lavatrice = this.mappa.getLavatrice();
        this.rubinetto = this.mappa.getRubinetto();
        this.fornello = this.mappa.getFornello();
        this.statoCasella = this.mappa.getStatoMappa();

    }

    public void avanza() {
        robot.Avanza(mappa.getMappa());
        gatto.Avanza(mappa.getMappa());
        mappa.aggiornaMappa();
    }

    public void giraDx() {
        robot.giraDx();
        gatto.Avanza(mappa.getMappa());
        mappa.aggiornaMappa();
    }

    public void giraSx() {
        robot.giraSx();
        gatto.Avanza(mappa.getMappa());
        mappa.aggiornaMappa();
    }

    public void asciuga() {
        robot.Asciuga(this.statoCasella);
        gatto.Avanza(mappa.getMappa());
        mappa.aggiornaMappa();
    }

    public Posizione spegniFornello() {
        Posizione p=robot.spegniFornello(mappa.getMappa());
        gatto.Avanza(mappa.getMappa());
        mappa.aggiornaMappa();
        return p;
    }

    public Posizione perdiAcquaLavatrice() {
        int rnd = new Random().nextInt(this.lavatrice.length);
        this.lavatrice[rnd].perdita(mappa.getMappa(), statoCasella);
        return this.lavatrice[rnd].getPosizione();

    }

    public Posizione perdiAcquaRubinetto() {
        int rnd = new Random().nextInt(this.rubinetto.length);
        this.rubinetto[rnd].perdita(mappa.getMappa(), statoCasella);
        return this.rubinetto[rnd].getPosizione();

    }

    public Posizione aggiustaPerditaLavatrice() {
        return robot.interrompiLavatrice(mappa.getMappa());
    }

    public Posizione aggiustaPerditaRubinetto() {
        return robot.interrompiRubinetto(mappa.getMappa());
    }

    public Posizione accendiFornello() {
        int rnd = new Random().nextInt(this.fornello.length);
        this.fornello[rnd].setAcceso(true);
        return this.fornello[rnd].getPosizione();
    }

    public Robot getRobot() {
        return robot;
    }


    public Gatto getGatto() {
        return gatto;
    }

    public Lavatrice[] getLavatrice() {
        return lavatrice;
    }

    public Rubinetto[] getRubinetto() {
        return rubinetto;
    }

    public Fornello[] getFornello() {
        return fornello;
    }

    public Mappa getMappa() {
        return mappa;
    }

    public HashMap<Posizione, StatoCasella> getStatoCasella() {
        return statoCasella;
    }

    
}
