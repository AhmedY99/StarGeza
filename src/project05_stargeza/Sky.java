/*
 * The Sky class hold the data of all the stars
 */
package project05_stargeza;

import acm.graphics.GCanvas;
import acm.graphics.GOval;
import static java.lang.Thread.sleep;
import java.util.ArrayList;

/**
 *
 * @author Ayuss
 */
public class Sky {

    private final ArrayList<Star> stars;
    /**
     * a default constructor which creates a new ArrayList for stars
     */
    public Sky() {
        stars = new ArrayList<>();
    }
    /**
     * This method adds stars to the list
     * @param s 
     */
    public void addStar(Star s) {
        this.stars.add(s);
    }
    /**
     * This method takes a GCanvas object, the picture size, 
     * and the max star size as 
     * parameters, then adds a GOval (correctly sized and located) to 
     * the canvas for each star in the list. 
     * @param canvas
     * @param maxSize
     * @param picSize 
     */

    public void paint(GCanvas canvas, int maxSize,int picSize) {
        GOval dot;

        for (Star s : stars) {
            dot = s.getDot(maxSize,picSize);
            canvas.add(dot);
        }
        try {
            sleep(1);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * This method takes an HD number as a parameter and returns the Star 
     * from the list with that identifier
     * @param starId
     * @return foundStar
     */

    public Star getStarInSkyByHD(int starId) {
        Star foundStar = null;
        for (Star s : stars) {
            if ((s.getHenry_Draper_ID_Num() == starId)) {
                foundStar = s;
            }
        }
        return foundStar;
    }
}
