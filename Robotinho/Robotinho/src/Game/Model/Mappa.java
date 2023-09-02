package Game.Model;

import java.util.HashMap;
import java.util.Random;

/**
 * @author Adil Lagzouli 20045391
 * @author Samuele Giallorenzo 20045100
 * @author Federico Mannisi 20045099
 */

public class Mappa {
    private final int N;
    private Robot r;
    private Posizione posizioneRobot;
    private Posizione posizioneGatto;
    private Gatto g;
    private final int N_LAVATRICI;
    private final int N_FORNELLI;
    private final int N_RUBINETTI;
    private final Lavatrice[] lavatrice;
    private final Rubinetto[] rubinetto;
    private final Fornello[] fornello;
    private final HashMap<Posizione, StatoCasella> statoMappa;
    private final Casella[][] mappa;

    /**
     * Costruttore per la classe Mappa.
     *
     * @param N           Indica la dimensione della mappa.
     * @param N_LAVATRICI Indica il numero di lavatrici sulla mappa.
     * @param N_FORNELLI  Indica il numero di fornelli sulla mappa.
     * @param N_RUBINETTI Indica il numero di rubinetti sulla mappa.
     */
    public Mappa(int N, int N_LAVATRICI, int N_FORNELLI, int N_RUBINETTI) throws IllegalArgumentException {
        if(N<=0 || N_LAVATRICI<=0 || N_FORNELLI<=0 || N_RUBINETTI<=0) new IllegalArgumentException("Parametri errati");
        this.N = N;
        this.mappa = new Casella[this.N][this.N];
        this.N_LAVATRICI = N_LAVATRICI;
        this.N_FORNELLI = N_FORNELLI;
        this.N_RUBINETTI = N_RUBINETTI;
        this.statoMappa = new HashMap<>();
        this.lavatrice = new Lavatrice[N_LAVATRICI];
        this.rubinetto = new Rubinetto[N_RUBINETTI];
        this.fornello = new Fornello[N_FORNELLI];
        this.inizializza();
    }

    /**
     * Inizializza la mappa con gli elementi robot, gatto, lavatrici, fornelli e rubinetti.
     */
    public void inizializza() {
        for (int i = 0; i < this.N; i++) {
            for (int j = 0; j < this.N; j++) {
                if (i == 0 || j == 0 || i == N - 1 || j == N - 1) {
                    this.mappa[i][j] = new Muro(i, j, true);
                } else {
                    this.mappa[i][j] = new Pavimento(i, j, false);
                }
                this.statoMappa.put(new Posizione(i, j), new StatoCasella(new Posizione(i, j), this.mappa[i][j].isVisibile(), false));
            }
        }

        generaRobot();
        generaLavatrici();
        generaFornelli();
        generaRubinetti();
        generaGatto();
    }

    private void generaRobot() {
        posizioneRobot = randomPos();
        this.r = new Robot(posizioneRobot.getX(), posizioneRobot.getY(), true, Direzione.South);
        this.mappa[posizioneRobot.getX()][posizioneRobot.getY()] = r;

        statoMappa.get(new Posizione(posizioneRobot.getX(), posizioneRobot.getY())).setVisibile(true);

    }

    private void generaGatto() {
        posizioneGatto = randomPos();
        this.g = new Gatto(posizioneGatto.getX(), posizioneGatto.getY(), true);
        this.mappa[posizioneGatto.getX()][posizioneGatto.getY()] = this.g;
    }

    private void generaRubinetti() {
        Posizione posizioneRubinetto;

        for (int i = 0; i < N_RUBINETTI; i++) {
            posizioneRubinetto = randomPos();
            this.rubinetto[i] = new Rubinetto(posizioneRubinetto.getX(), posizioneRubinetto.getY(), false);
            this.mappa[posizioneRubinetto.getX()][posizioneRubinetto.getY()] = rubinetto[i];
        }
    }

    private void generaFornelli() {
        Posizione posizioneFornello;

        for (int i = 0; i < N_FORNELLI; i++) {
            posizioneFornello = randomPos();
            this.fornello[i] = new Fornello(posizioneFornello.getX(), posizioneFornello.getY(), false);
            this.mappa[posizioneFornello.getX()][posizioneFornello.getY()] = fornello[i];
        }
    }

    private void generaLavatrici() {
        Posizione posizioneLavatrice;

        for (int i = 0; i < N_LAVATRICI; i++) {
            posizioneLavatrice = randomPos();
            this.lavatrice[i] = new Lavatrice(posizioneLavatrice.getX(), posizioneLavatrice.getY(), false);
            this.mappa[posizioneLavatrice.getX()][posizioneLavatrice.getY()] = lavatrice[i];
        }
    }

    private void aggiornaElemento(Posizione posizioneElemento, Casella elemento) {
        Posizione vecchiaPosizione;
        vecchiaPosizione = posizioneElemento;
        mappa[vecchiaPosizione.getX()][vecchiaPosizione.getY()] = new Pavimento(vecchiaPosizione.getX(), vecchiaPosizione.getY(), statoMappa.get(vecchiaPosizione).isVisibile());

        posizioneElemento.setX(elemento.getPosizione().getX());
        posizioneElemento.setY(elemento.getPosizione().getY());

        mappa[posizioneElemento.getX()][posizioneElemento.getY()] = elemento;
    }

    /**
     * Aggiorna la posizione del robot sulla mappa.
     */
    public void aggiornaRobot() {
        aggiornaElemento(this.posizioneRobot, this.r);
    }

    /**
     * Aggiorna la posizione del gatto sulla mappa.
     */
    public void aggiornaGatto() {
        aggiornaElemento(this.posizioneGatto, this.g);
    }

    /**
     * Restituisce la dimensione della mappa.
     *
     * @return la dimensione della mappa.
     */
    public int getDim() {
        return N;
    }

    /**
     * Restituisce la matrice di caselle che compone la mappa.
     *
     * @return la matrice di caselle.
     */
    public Casella[][] getMappa() {
        return mappa;
    }

    /**
     * Restituisce l'oggetto Robot sulla mappa.
     *
     * @return l'oggetto Robot sulla mappa.
     */
    public Robot getRobot() {
        return this.r;
    }

    public HashMap<Posizione, StatoCasella> getStatoMappa() {
        return statoMappa;
    }

    /**
     * Restituisce l'oggetto Gatto sulla mappa.
     *
     * @return l'oggetto Gatto sulla mappa.
     */
    public Gatto getGatto() {
        return this.g;
    }

    /**
     * Restituisce l'array di tutte le lavatrici sulla mappa.
     *
     * @return l'array delle lavatrici.
     */
    public Lavatrice[] getLavatrice() {
        return lavatrice;
    }

    /**
     * Restituisce l'array di tutti i rubinetti sulla mappa.
     *
     * @return l'array dei rubinetti.
     */
    public Rubinetto[] getRubinetto() {
        return rubinetto;
    }

    /**
     * Restituisce l'array di tutti i fornelli sulla mappa.
     *
     * @return l'array dei fornelli.
     */
    public Fornello[] getFornello() {
        return fornello;
    }

    private Posizione randomPos() {
        Random random = new Random();
        Posizione posRandom;

        do {
            posRandom = new Posizione(random.nextInt(this.N), random.nextInt(this.N));
        } while (!this.mappa[posRandom.getX()][posRandom.getY()].tipo().equals("Pavimento"));

        return posRandom;
    }

    /**
     * Imposta la posizione del robot sulla mappa.
     *
     * @param posizioneRobot Indica la nuova posizione del robot sulla mappa.
     */
    public void setPosizioneRobot(Posizione posizioneRobot) {
        this.posizioneRobot = posizioneRobot;
    }

    /**
     * Imposta la posizione del gatto sulla mappa.
     *
     * @param posizioneGatto Indica la nuova posizione del gatto sulla mappa.
     */
    public void setPosizioneGatto(Posizione posizioneGatto) {
        this.posizioneGatto = posizioneGatto;
    }


    /**
     * Imposta l'oggetto Robot sulla mappa.
     *
     * @param r Indica il nuovo oggetto Robot da impostare.
     */
    public void setR(Robot r) {
        this.r = r;
    }

    /**
     * Imposta l'oggetto Gatto sulla mappa.
     *
     * @param g Indica il nuovo oggetto Gatto da impostare.
     */
    public void setG(Gatto g) {
        this.g = g;
    }
}