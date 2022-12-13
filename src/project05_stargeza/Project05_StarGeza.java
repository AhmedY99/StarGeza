/**
 * This program uses data from a star catalog to create a picture
 * that plots the locations of stars and some well-known constellations.
 * Author: Ahmed Yussuf 
 */
package project05_stargeza;

import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.io.File;
import static java.lang.Thread.sleep;
import java.util.Scanner;

/**
 *
 * @author Ayuss
 */
public class Project05_StarGeza extends GraphicsProgram {
    
    final int WINDOW_WIDTH = 800;
    final int WINDOW_HEIGHT = 1200;
    final String TATILE = "StarGazer";
    int picSize;
    int maxStarSize = 12;
    private Sky mySky;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Project05_StarGeza().start();
    }

    @Override
    public void init() {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle(TATILE);
        setBackground(Color.BLACK);

    }

    @Override
    public void run() {
        try {
            sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        loadStar();
        GCanvas gc = getGCanvas();
        mySky.paint(gc, maxStarSize, picSize);
        drawConstellations();

    }
    /**
     * This method  read in the data from the StarList.txt file, one line at a 
     * time, create a star for each input line and add it to the Sky.
     */

    public void loadStar() {
        File star = new File("StarList.txt");
        mySky = new Sky();
        try {
            Scanner input = new Scanner(star);
            while (input.hasNextLine()) {
                String a = input.nextLine();
                String[] data = a.split(" ");

                double xStar = Double.parseDouble(data[0]);
                double yStar = Double.parseDouble(data[1]);

                double magnitude = Double.parseDouble(data[4]);
                int starId = Integer.parseInt(data[3]);

                Star s = new Star(xStar, yStar, magnitude, starId);
                mySky.addStar(s);
            }
            input.close();
        } catch (Exception v) {
            System.out.println(v.getMessage());

        }
    }
    /**
     * This methods reads the Constellations.txt file, containing the constellation names
     * followed by pairs of HD numbers which are 4the endpoints for lines 
     * in the constellation. For each pair, use the getStarInSkyByHD 
     * method to get the star objects then call coordsToPoint to get the GPoints. 
     * Use the GPoints to create a GLine, then add it to the screen.
     */

    public void drawConstellations() {
        File constellation = new File("Constellations.txt");
        //stars = new ArrayList();
        try {
            Scanner file = new Scanner(constellation);
            while (file.hasNextLine()) {
                String k = file.nextLine();
                char userChar = k.charAt(0);
                if (!Character.isLetter(userChar)) {

                    String[] data = k.split(",");
                    int startNum = Integer.parseInt(data[0]);

                    int endNum = Integer.parseInt(data[1]);

                    Star start = mySky.getStarInSkyByHD(startNum);
                    Star end = mySky.getStarInSkyByHD(endNum);

                    GPoint p = start.coordsToPoint(picSize);
                    GPoint pt = end.coordsToPoint(picSize);
                    GLine myLine = new GLine(p.getX(), p.getY(), pt.getX(), pt.getY());
                    myLine.setColor(Color.ORANGE);
                    add(myLine);
                     System.out.println(file.nextLine());
                }
            }
            file.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }
}
