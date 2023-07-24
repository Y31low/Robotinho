package Game.model;

public class Fornello extends Casella{
    private Boolean acceso;

    public Fornello(int x, int y){
        super(x, y);
        this.acceso = false;
    }
    public Fornello(int x, int y, Boolean acceso){
        super(x, y);
        this.acceso = acceso;
    }

    public Boolean getAcceso() {
        return acceso;
    }

    public void setAcceso(Boolean acceso) {
        this.acceso = acceso;
    }
}
