package Game.Model;

import java.util.HashMap;

public class Gioco {
    private Robot robot;
    private Gatto gatto;
    private Lavatrice lavatrice;
    private Rubinetto rubinetto;
    private Fornello fornello;
    private Mappa mappa;
    private HashMap<Posizione,StatoCasella> statoCasella;
    private final int  N=10;//dimensione mappa

    public Gioco(int N){
        this.mappa = new Mappa(10);
        this.mappa.inizializza();
        this.robot = this.mappa.getRobot();
        this.gatto = this.mappa.getGatto();
        this.lavatrice = this.mappa.getLavatrice();
        this.rubinetto = this.mappa.getRubinetto();
        this.fornello = this.mappa.getFornello();
        this.statoCasella= this.mappa.getStatoPavimento();
    }

    public void avanza(){
        robot.Avanza(mappa.getMappa());
        gatto.Avanza(mappa.getMappa());
        mappa.aggiornaMappa();
    }
    public void giraDx(){
        robot.giraDx();
        gatto.Avanza(mappa.getMappa());
    }

    public void giraSx(){
        robot.giraSx();
        gatto.Avanza(mappa.getMappa());
    }

    public void asciuga(){
        robot.Asciuga(this.statoCasella);
        gatto.Avanza(mappa.getMappa());
    }

    public void spegniFornello(){
        robot.spegniFornello(mappa.getMappa());
        gatto.Avanza(mappa.getMappa());
    }

    public void perdiAcquaLavatrice(){
        this.lavatrice.perdita(mappa.getMappa(),statoCasella);
    }

    public void perdiAcquaRubinetto(){
        this.rubinetto.perdita(mappa.getMappa(), statoCasella);
    }

    public void aggiustaPerditaLavatrice(){
       this.robot.interrompiLavatrice(mappa.getMappa());
    }
    public void aggiustaPerditaRubinetto(){
        this.robot.interrompiRubinetto(mappa.getMappa());
    }
    public void accendiFornello(){
        this.fornello.setAcceso(true);
    }

    public Robot getRobot() {
        return robot;
    }

    public Gatto getGatto() {
        return gatto;
    }

    public Lavatrice getLavatrice() {
        return lavatrice;
    }

    public Rubinetto getRubinetto() {
        return rubinetto;
    }

    public Fornello getFornello() {
        return fornello;
    }

    public Mappa getMappa() {
        return mappa;
    }

    public HashMap<Posizione, StatoCasella> getStatoCasella() {
        return statoCasella;
    }
}
