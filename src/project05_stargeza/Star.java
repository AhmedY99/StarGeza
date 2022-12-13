/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project05_stargeza;

//import java.util.ArrayList;
import acm.graphics.GOval;
import acm.graphics.GPoint;
import java.awt.Color;

/**
 *
 * @author Ayuss
 */
public class Star {

    public double xStar, yStar, magnitude;
    public int starId;
    public int xPixel, yPixel;

    public Star(double xStar, double yStar, double magnitude, int starId) {
        this.xStar = xStar;
        this.yStar = yStar;
        this.magnitude = magnitude;
        this.starId = starId;
    }
    /**
     * Defines the getXStar method
     * @return the x pixel of the star
     */
    public double getXStar() {
        return xStar;
    }
    /**
     * Defines the getYStar method
     * @return the y pixel of the star 
     */
    public double getYStar() {
        return yStar;
    }
/**
 * Defines the getMagnitude method
 * @return star magnitude
 */
    public double getMagnitude() {
        return magnitude;
    }
    /**
     * Defines the getHenry_Draper_ID_Num
     * @return the starId
     */

    public int getHenry_Draper_ID_Num() {
        return starId;
    }

    @Override
    public String toString() {
        return this.xStar + " " + this.yStar + " " + this.starId + " " + this.magnitude;
    }
    /**
     * Defines the GPoint coordinate method
     * @param picSize
     * @return the GPoints of the star
     */

    public GPoint coordsToPoint(int picSize) {
        picSize = 630;
        
        xPixel = (int) ((xStar + 1) * picSize /2);
        yPixel = picSize-(int) ((yStar + 1) * picSize / 2);

        GPoint a = new GPoint(xPixel+20, yPixel+4);
        return a;

    }
    /**
     * Defines the GOval getDot method, and sets the dot
     * @param picSize
     * @param maxSize
     * @return myDot
     */

    public GOval getDot(int picSize, int maxSize) {
        maxSize = 10;
        double starSize = Math.round(maxSize/(this.magnitude + 2));

        
        GPoint p = coordsToPoint(picSize);

        GOval myDot = new GOval(p.getX(), p.getY(), starSize, starSize);
        myDot.setFilled(true);
        myDot.setColor(Color.white);

        return myDot;
    }
}
