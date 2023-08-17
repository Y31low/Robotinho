package Game.Model;


import java.util.HashMap;
import java.util.Random;

public class Mappa {
    private int N;
    private Robot r;
    private int robotx, roboty;
    private Gatto g;
    private int gattox, gattoy;
    private Lavatrice lavatrice;
    private int lavax, lavay;

    private Rubinetto rubinetto;
    private int rubinettox, rubinettoy;

    private Fornello fornello;
    private int fornellox, fornelloy;

    private HashMap<Posizione,StatoCasella> statoPavimento;

    Casella[][] mappa;

    public Mappa() {
        this.N = 10;
        this.mappa = new Casella[this.N][this.N];
        this.statoPavimento = new HashMap<>();
        this.inizializza();
    }
    public Mappa(int N) {
        this.N = N;
        this.mappa = new Casella[this.N][this.N];
        this.statoPavimento = new HashMap<>();
    }

    private void inizializza() {
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
        this.mappa[posizioneRobot.getX()][posizioneRobot.getY()] = r = new Robot(posizioneRobot.getX(), posizioneRobot.getY(), true, Direzione.South);

        posizioneLavatrice = randomPos();
        this.mappa[posizioneLavatrice.getX()][posizioneLavatrice.getY()] = lavatrice = new Lavatrice(posizioneLavatrice.getX(), posizioneLavatrice.getY(), false);

        posizioneFornello = randomPos();
        this.mappa[posizioneFornello.getX()][posizioneFornello.getY()] = fornello = new Fornello(posizioneFornello.getX(), posizioneFornello.getY(), false);

        posizioneRubinetto = randomPos();
        this.mappa[posizioneRubinetto.getX()][posizioneRubinetto.getY()] = rubinetto = new Rubinetto(posizioneRubinetto.getX(), posizioneRubinetto.getY(), false);

        posizioneGatto = randomPos();
        this.mappa[posizioneGatto.getX()][posizioneGatto.getY()] = g = new Gatto(posizioneGatto.getX(), posizioneGatto.getY(), true);

        this.mappa[1][3] = new Pavimento(1, 3, true);
        this.statoPavimento.put(new Posizione(1,3),new StatoCasella(new Posizione(1,3), true, true));
    }

    public void aggiornaMappa() {
        this.mappa[robotx][roboty] = new Pavimento(robotx,roboty,true);

        posizioneRobot.setX(r.getPosizione().getX());
        posizioneRobot.setY(r.getPosizione().getY());
        this.mappa[posizioneRobot.getX()][posizioneRobot.getY()] = r;

        this.mappa[gattox][gattoy] = new Pavimento(gattox, gattoy, false);
        gattox = g.getPosizione().getX();
        gattoy = g.getPosizione().getY();
        this.mappa[gattox][gattoy] = g;
    }

    public int getDim() {
        return N;
    }

    public Casella[][] getMappa() {
        return mappa;
    }

    public Casella getRobot() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (mappa[i][j].tipo().equals("Robot")) {
                    return mappa[i][j];
                }
            }
        }
        return null;
    }

    public HashMap<Posizione,StatoCasella> getStatoPavimento() {
        return statoPavimento;
    }

    public Casella getGatto() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (mappa[i][j].tipo().equals("Cat")) {
                    return mappa[i][j];
                }
            }
        }
        return null;
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
}