package Game.Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

/**
 * @author Adil Lagzouli 20045391
 * @author Samuele Giallorenzo 20045100
 * @author Federico Mannisi 20045099
 */

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

    /**
     * Costruttore per creare un nuovo oggetto Gioco con la dimensione di mappa specificata.
     *
     * @param N La dimensione della mappa di gioco.
     */
    public Gioco(int N) {
        this.N=N;
        this.mappa = new Mappa(this.N,N_LAVATRICI,N_FORNELLI,N_RUBINETTI);
        this.mappa.inizializza();
        this.robot = this.mappa.getRobot();
        this.gatto = this.mappa.getGatto();
        this.lavatrice = this.mappa.getLavatrice();
        this.rubinetto = this.mappa.getRubinetto();
        this.fornello = this.mappa.getFornello();
        this.statoCasella = this.mappa.getStatoMappa();
    }

    /**
     * Costruttore per creare un nuovo oggetto Gioco leggendo la dimensione della mappa da un file.
     *
     * @param f Il file da cui leggere la dimensione della mappa.
     */
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
        this.N = Integer.parseInt(n.toString());
        this.mappa = new Mappa(this.N,N_LAVATRICI,N_FORNELLI,N_RUBINETTI);
        this.mappa.inizializza();
        this.robot = this.mappa.getRobot();
        this.gatto = this.mappa.getGatto();
        this.lavatrice = this.mappa.getLavatrice();
        this.rubinetto = this.mappa.getRubinetto();
        this.fornello = this.mappa.getFornello();
        this.statoCasella = this.mappa.getStatoMappa();

    }

    /**
     *
     * Questo metodo fa avanzare il robot e il gatto e ne riflette gli spostamenti sulla mappa.
     *
     */
    public void avanza() {
        robot.Avanza(mappa.getMappa());
        gatto.Avanza(mappa.getMappa());
        mappa.aggiornaRobot();
        mappa.aggiornaGatto();
    }

    /*
    * Questo metodo permette al robot di girarsi verso destra e permette al gatto di spostarsi.
     */
    public void giraDx() {
        robot.giraDx();
        gatto.Avanza(mappa.getMappa());
        mappa.aggiornaGatto();
    }

    /*
     * Questo metodo permette al robot di girarsi verso sinistra e permette al gatto di spostarsi.
     */
    public void giraSx() {
        robot.giraSx();
        gatto.Avanza(mappa.getMappa());
        mappa.aggiornaGatto();
    }

    /*
    * Questo metodo permette al robot di asciugare una casella se è bagnata.
     */
    public void asciuga() {
        robot.Asciuga(this.statoCasella);
        gatto.Avanza(mappa.getMappa());
        mappa.aggiornaGatto();
    }

    /**
     * Spegne un fornello sulla mappa di gioco e restituisce la posizione del fornello spento.
     *
     * @return La posizione del fornello appena spento.
     */
    public Posizione spegniFornello() {
        Posizione p=robot.spegniFornello(mappa.getMappa());
        gatto.Avanza(mappa.getMappa());
        mappa.aggiornaGatto();
        return p;
    }

    /**
     * Inizia la perdita di acqua da una lavatrice sulla mappa di gioco
     * e restituisce la posizione della lavatrice scelta.
     *
     * @return La posizione della lavatrice scelta per la perdita d'acqua.
     */
    public Posizione perdiAcquaLavatrice() {
        int rnd = new Random().nextInt(this.lavatrice.length);
        this.lavatrice[rnd].perdita(mappa.getMappa(), statoCasella);
        return this.lavatrice[rnd].getPosizione();
    }

    /**
     * Inizia la perdita di acqua da un rubinetto casuale sulla mappa di gioco
     * e restituisce la posizione del rubinetto scelto.
     *
     * @return La posizione del rubinetto colpito dalla perdita d'acqua.
     */
    public Posizione perdiAcquaRubinetto() {
        int rnd = new Random().nextInt(this.rubinetto.length);
        this.rubinetto[rnd].perdita(mappa.getMappa(), statoCasella);
        return this.rubinetto[rnd].getPosizione();
    }

    /**
     * Aggiusta una perdita d'acqua di una lavatrice sulla mappa
     * e restituisce la posizione della lavatrice riparata.
     *
     * @return La posizione della lavatrice riparata.
     */
    public Posizione aggiustaPerditaLavatrice() {
        return robot.interrompiLavatrice(mappa.getMappa());
    }

    /**
     * Aggiusta una perdita d'acqua di un rubinetto sulla mappa
     * e restituisce la posizione del rubinetto riparato.
     *
     * @return La posizione del rubinetto riparato.
     */
    public Posizione aggiustaPerditaRubinetto() {
        return robot.interrompiRubinetto(mappa.getMappa());
    }

    /**
     * Accendi un fornello sulla mappa
     * e restituisce la posizione del fornello acceso.
     *
     * @return La posizione del fornello acceso.
     */
    public Posizione accendiFornello() {
        int rnd = new Random().nextInt(this.fornello.length);
        this.fornello[rnd].setAcceso(true);
        return this.fornello[rnd].getPosizione();
    }

    /**
     * Restituisce l'oggetto Robot del gioco.
     *
     * @return L'oggetto Robot del gioco.
     */
    public Robot getRobot() {
        return robot;
    }

    /**
     * Restituisce l'oggetto Gatto del gioco.
     *
     * @return L'oggetto Gatto del gioco.
     */
    public Gatto getGatto() {
        return gatto;
    }

    /**
     * Restituisce un array di oggetti Lavatrice presenti nel gioco.
     *
     * @return Un array di oggetti Lavatrice nel gioco.
     */
    public Lavatrice[] getLavatrice() {
        return lavatrice;
    }

    /**
     * Restituisce un array di oggetti Rubinetto presenti nel gioco.
     *
     * @return Un array di oggetti Rubinetto nel gioco.
     */
    public Rubinetto[] getRubinetto() {
        return rubinetto;
    }

    /**
     * Restituisce un array di oggetti Fornello presenti nel gioco.
     *
     * @return Un array di oggetti Fornello nel gioco.
     */
    public Fornello[] getFornello() {
        return fornello;
    }

    /**
     * Restituisce l'oggetto Mappa del gioco.
     *
     * @return L'oggetto Mappa del gioco.
     */
    public Mappa getMappa() {
        return mappa;
    }

    /**
     * Restituisce una mappa che tiene traccia dello stato delle caselle nella mappa di gioco.
     *
     * @return Una mappa di stato delle caselle nel gioco.
     */
    public HashMap<Posizione, StatoCasella> getStatoCasella() {
        return statoCasella;
    }
}