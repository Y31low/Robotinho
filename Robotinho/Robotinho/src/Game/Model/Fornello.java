package Game.Model;

public class Fornello extends Casella{
    private Boolean acceso;

    public Fornello(int x, int y,boolean visibile){
        super(x, y,visibile);
        this.acceso = false;
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
