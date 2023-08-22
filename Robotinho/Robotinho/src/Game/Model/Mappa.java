package Game.Model;


import java.util.HashMap;
import java.util.Random;

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
    private final HashMap<Posizione,StatoCasella> statoMappa;
    private final Casella[][] mappa;

    public Mappa(int N, int N_LAVATRICI, int N_FORNELLI, int N_RUBINETTI ) {
        this.N = N;
        this.mappa = new Casella[this.N][this.N];
        this.N_LAVATRICI=N_LAVATRICI;
        this.N_FORNELLI=N_FORNELLI;
        this.N_RUBINETTI=N_RUBINETTI;
        this.statoMappa =new HashMap<>();
        this.lavatrice=new Lavatrice[N_LAVATRICI];
        this.rubinetto=new Rubinetto[N_RUBINETTI];
        this.fornello=new Fornello[N_FORNELLI];
    }

    protected void inizializza() {
        for (int i = 0; i < this.N; i++) {
            for (int j = 0; j < this.N; j++) {
                if (i == 0 || j == 0 || i == N - 1 || j == N - 1) {
                    this.mappa[i][j] = new Muro(i, j,true);
                } else {
                    this.mappa[i][j] = new Pavimento(i, j, false);
                }
                this.statoMappa.put(new Posizione(i,j),new StatoCasella(new Posizione(i,j), false, false));
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
        this.mappa[posizioneRobot.getX()][posizioneRobot.getY()].setVisibile(true);
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

    public void aggiornaRobot(){
        statoMappa.get(new Posizione(posizioneRobot.getX() - 1, posizioneRobot.getY())).setVisibile(true);
        statoMappa.get(new Posizione(posizioneRobot.getX() + 1, posizioneRobot.getY())).setVisibile(true);
        statoMappa.get(new Posizione(posizioneRobot.getX(), posizioneRobot.getY() - 1)).setVisibile(true);
        statoMappa.get(new Posizione(posizioneRobot.getX(), posizioneRobot.getY() + 1)).setVisibile(true);

        this.mappa[posizioneRobot.getX()][posizioneRobot.getY()] = new Pavimento(posizioneRobot.getX(), posizioneRobot.getY(), statoMappa.get(posizioneRobot).isVisibile());
        posizioneRobot.setX(r.getPosizione().getX());
        posizioneRobot.setY(r.getPosizione().getY());
        this.mappa[posizioneRobot.getX()][posizioneRobot.getY()] = r;
    }

    public void aggiornaGatto() {
        this.mappa[posizioneGatto.getX()][posizioneGatto.getY()] = new Pavimento(posizioneGatto.getX(), posizioneGatto.getY(),  statoMappa.get(posizioneGatto).isVisibile());
        posizioneGatto.setX(g.getPosizione().getX());
        posizioneGatto.setY(g.getPosizione().getY());
        this.mappa[posizioneGatto.getX()][posizioneGatto.getY()] = g;
    }

    public int getDim() {
        return N;
    }

    public Casella[][] getMappa() {
        return mappa;
    }

    public Robot getRobot() {
       return this.r;
    }

    public HashMap<Posizione,StatoCasella> getStatoMappa() {
        return statoMappa;
    }

    public Gatto getGatto() {
        return this.g;
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

    private Posizione randomPos() {
        Random random = new Random();
        Posizione posRandom;

        do {
            posRandom = new Posizione(random.nextInt(this.N), random.nextInt(this.N));
        } while (!this.mappa[posRandom.getX()][posRandom.getY()].tipo().equals("Pavimento"));

        return posRandom;
    }
}