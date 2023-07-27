package Game.model;

import Game.view.GuiMappa;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Gatto extends Casella implements Movable {
    private Mappa m;
    public Gatto(int x, int y){
        super(x, y);
    }

    public String toString() {
        return "Cat";
    }

    @Override
    public void Avanza(Direzione direzione) {

    }


}
