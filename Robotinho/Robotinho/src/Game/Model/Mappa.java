package Game.Model;


import java.util.HashMap;
import java.util.Random;

public class Mappa {
    private final int N;
    private Robot r;
    private Posizione posizioneRobot;
    private Posizione posizioneGatto;
    private Posizione posizioneFornello;
    private Posizione posizioneRubinetto;
    private Posizione posizioneLavatrice;
    private Gatto g;
    private  int N_LAVATRICI;
    private  int N_FORNELLI;
    private  int N_RUBINETTI;

    private Lavatrice[] lavatrice;


    private Rubinetto[] rubinetto;


    private Fornello[] fornello;


    private final HashMap<Posizione,StatoCasella> statoMappa;

    private Casella[][] mappa;

    public Mappa() {
        this.N = 10;
        this.mappa = new Casella[this.N][this.N];
        this.statoMappa =new HashMap<>();

    }
    public Mappa(int N,int N_LAVATRICI, int N_FORNELLI, int N_RUBINETTI ) {
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

        posizioneRobot = randomPos(); //da aggiustare la posizione del robot nel costruttore
        r = new Robot(posizioneRobot.getX(), posizioneRobot.getY(), true, Direzione.South);
        this.mappa[posizioneRobot.getX()][posizioneRobot.getY()] = r;

        for (int i = 0; i < N_LAVATRICI; i++) {
            posizioneLavatrice = randomPos();
            lavatrice[i] = new Lavatrice(posizioneLavatrice.getX(), posizioneLavatrice.getY(), false);
            this.mappa[posizioneLavatrice.getX()][posizioneLavatrice.getY()] = lavatrice[i];


        }

        for (int i = 0; i < N_FORNELLI; i++) {
            posizioneFornello = randomPos();
            fornello[i] = new Fornello(posizioneFornello.getX(), posizioneFornello.getY(), false);
            this.mappa[posizioneFornello.getX()][posizioneFornello.getY()] = fornello[i];

        }

        for (int i = 0; i < N_RUBINETTI; i++) {
            posizioneRubinetto = randomPos();
            rubinetto[i] = new Rubinetto(posizioneRubinetto.getX(), posizioneRubinetto.getY(), false);
            this.mappa[posizioneRubinetto.getX()][posizioneRubinetto.getY()] = rubinetto[i];
        }

        posizioneGatto = randomPos();
        g = new Gatto(posizioneGatto.getX(), posizioneGatto.getY(), true);
        this.mappa[posizioneGatto.getX()][posizioneGatto.getY()] = g;


    }

    public void aggiornaMappa() {
        statoMappa.get(new Posizione(posizioneRobot.getX() - 1, posizioneRobot.getY())).setVisibile(true);
        statoMappa.get(new Posizione(posizioneRobot.getX() + 1, posizioneRobot.getY())).setVisibile(true);
        statoMappa.get(new Posizione(posizioneRobot.getX(), posizioneRobot.getY() - 1)).setVisibile(true);
        statoMappa.get(new Posizione(posizioneRobot.getX(), posizioneRobot.getY() + 1)).setVisibile(true);
        this.mappa[posizioneRobot.getX()][posizioneRobot.getY()] = new Pavimento(posizioneRobot.getX(), posizioneRobot.getY(), statoMappa.get(posizioneRobot).isVisibile());
        posizioneRobot.setX(r.getPosizione().getX());
        posizioneRobot.setY(r.getPosizione().getY());
        this.mappa[posizioneRobot.getX()][posizioneRobot.getY()] = r;
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



    public int getN_LAVATRICI() {
        return N_LAVATRICI;
    }

    public int getN_FORNELLI() {
        return N_FORNELLI;
    }

    public int getN_RUBINETTI() {
        return N_RUBINETTI;
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