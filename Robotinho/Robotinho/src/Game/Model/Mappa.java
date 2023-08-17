package Game.Model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Mappa {
    private int N;
    private Robot r;
    private Posizione posizioneRobot;
    private Posizione posizioneGatto;
    private Posizione posizioneFornello;
    private Posizione posizioneRubinetto;
    private Posizione posizioneLavatrice;
    private Gatto g;
    private Lavatrice lavatrice;


    private Rubinetto rubinetto;


    private Fornello fornello;


    private HashMap<Posizione,StatoCasella> statoPavimento;

    Casella[][] mappa;

    public Mappa() {
        this.N = 10;
        this.mappa = new Casella[this.N][this.N];
        this.statoPavimento=new HashMap<>();

    }
    public Mappa(int N) {
        this.N = N;
        this.mappa = new Casella[this.N][this.N];
        this.statoPavimento=new HashMap<>();

    }

    protected void inizializza() {
        for (int i = 0; i < this.N; i++) {
            for (int j = 0; j < this.N; j++) {
                if (i == 0 || j == 0 || i == N - 1 || j == N - 1) {
                    this.mappa[i][j] = new Muro(i, j,true);
                } else {
                    this.mappa[i][j] = new Pavimento(i, j, false);
                    this.statoPavimento.put(new Posizione(i,j),new StatoCasella(new Posizione(i,j), false, false));
                }
            }
        }

        posizioneRobot = randomPos(); //da aggiustare la posizione del robot nel costruttore
        r = new Robot(posizioneRobot.getX(), posizioneRobot.getY(), true, Direzione.South);
        this.mappa[posizioneRobot.getX()][posizioneRobot.getY()] = r;

        posizioneLavatrice = randomPos();
        lavatrice = new Lavatrice(posizioneLavatrice.getX(), posizioneLavatrice.getY(), false);
        this.mappa[posizioneLavatrice.getX()][posizioneLavatrice.getY()] = lavatrice;

        posizioneFornello = randomPos();
        fornello = new Fornello(posizioneFornello.getX(), posizioneFornello.getY(), false);
        this.mappa[posizioneFornello.getX()][posizioneFornello.getY()] = fornello;

        posizioneRubinetto = randomPos();
        rubinetto = new Rubinetto(posizioneRubinetto.getX(), posizioneRubinetto.getY(), false);
        this.mappa[posizioneRubinetto.getX()][posizioneRubinetto.getY()] = rubinetto;

        posizioneGatto = randomPos();
        g = new Gatto(posizioneGatto.getX(), posizioneGatto.getY(), true);
        this.mappa[posizioneGatto.getX()][posizioneGatto.getY()] = g;
    }

    public void aggiornaMappa() {
        this.mappa[posizioneRobot.getX()][posizioneRobot.getY()] = new Pavimento(posizioneRobot.getX(), posizioneRobot.getY(), true);

        posizioneRobot.setX(r.getPosizione().getX());
        posizioneRobot.setY(r.getPosizione().getY());
        this.mappa[posizioneRobot.getX()][posizioneRobot.getY()] = r;

        this.mappa[posizioneGatto.getX()][posizioneGatto.getY()] = new Pavimento(posizioneGatto.getX(), posizioneGatto.getY(), false);
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

    public HashMap<Posizione,StatoCasella> getStatoPavimento() {
        return statoPavimento;
    }

    public Gatto getGatto() {
        return this.g;
    }
    public void rotturaLavatrice(){
        this.lavatrice.perdita(this.getMappa(),statoPavimento);
    }
    public void rotturaRubinetto(){
        this.rubinetto.perdita(this.getMappa(),statoPavimento);
    }

    public void rotturaFornello(){
        this.fornello.setAcceso(true);
    }
    /*
    public void printMap(){
        for (int i = 0; i < this.N; i++) {
            for (int j = 0; j < this.N; j++) {
                System.out.print("|"+mappa[i][j].toString()+"|");
            }
            System.out.println();
        }
    }
    */
    private Posizione randomPos() {
        Random random = new Random();
        Posizione posRandom;

        do {
            posRandom = new Posizione(random.nextInt(this.N), random.nextInt(this.N));
        } while (!this.mappa[posRandom.getX()][posRandom.getY()].tipo().equals("Pavimento"));

        return posRandom;
    }

    public Lavatrice getLavatrice() {
        return this.lavatrice;
    }

    public Rubinetto getRubinetto() {
        return this.rubinetto;
    }

    public Fornello getFornello() {
        return this.fornello;
    }
}