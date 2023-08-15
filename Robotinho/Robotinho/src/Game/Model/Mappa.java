package Game.Model;


import java.util.HashMap;

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
        this.mappa[5][7] = new Fornello(5,7,false);
        fornello=(Fornello)this.mappa[5][7];
        fornellox = this.mappa[5][7].getPosizione().getX();
        fornelloy = this.mappa[5][7].getPosizione().getY();

        this.mappa[4][4] = new Lavatrice(4,4,false);
        lavatrice=(Lavatrice)this.mappa[4][4];
        lavax = this.mappa[4][4].getPosizione().getX();
        lavay = this.mappa[4][4].getPosizione().getY();

        this.mappa[7][1] = new Rubinetto(7,1,false);
        rubinetto = (Rubinetto)this.mappa[7][1];
        rubinettox = this.mappa[7][1].getPosizione().getX();
        rubinettoy = this.mappa[7][1].getPosizione().getY();

        this.mappa[8][8] = new Gatto(8,8,true);
        g=(Gatto)this.mappa[8][8];
        gattox = this.mappa[8][8].getPosizione().getX();
        gattoy = this.mappa[8][8].getPosizione().getY();

        this.mappa[1][1] = new Robot(1,1,true,Direzione.South);
        r=(Robot)this.mappa[1][1];
        robotx=this.mappa[1][1].getPosizione().getX();
        roboty=this.mappa[1][1].getPosizione().getY();

        this.mappa[1][3] = new Pavimento(1, 3, true);
        this.statoPavimento.put(new Posizione(1,3),new StatoCasella(new Posizione(1,3), true, true));
    }

    public void aggiornaMappa() {
        this.mappa[robotx][roboty] = new Pavimento(robotx,roboty,true);

        robotx = r.getPosizione().getX();
        roboty = r.getPosizione().getY();
        this.mappa[robotx][roboty] = r;

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
        return this.mappa[1][1];
    }

    public HashMap<Posizione,StatoCasella> getStatoPavimento() {
        return statoPavimento;
    }

    public Casella getGatto() {
        return this.mappa[8][8];
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