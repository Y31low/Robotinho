package Game.Model;

public class Fornello extends Casella{
    private Boolean acceso;

    public Fornello(int x, int y,boolean visibile){
        super(x, y,visibile);
        this.acceso = false;
    }
    public Fornello(int x, int y,boolean visibile, Boolean acceso){
        super(x, y,visibile);
        this.acceso = acceso;
    }
    @Override
    public String tipo() {
        return "Fornello";
    }

    public Boolean getAcceso() {
        return acceso;
    }

    public void setAcceso(Boolean acceso) {
        this.acceso = acceso;
    }
}