/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo.formas;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.MouseEvent;

/**
 *
 * @author jahaziel
 */
public class Forma extends Polygon {
    
    public Color color = null;
    public boolean relleno = false;
    //coordenadas del centro de la forma
    public int x = 0;
    public int y = 0;
    
    public Forma (int _posX, int _posY, int _lados, Color _color, boolean _relleno){//Es el constructor
        super( new int [_lados], new int [_lados], _lados);// [todas las coordenads x de los puntos que forman los lados del poligono],[puntos en y]. Es como x1,x2,x3.... y y1, y2, y3....
        this.x =_posX;
        this.y =_posY;
        this.color = _color;
        relleno = _relleno;
        
    }
    
    public void dibujate(Graphics2D g2, int _posX, int _posY){
        calculaVertices (y - _posY, x - _posX);
        g2.setColor(color);
        if(relleno){
            g2.fill(this); 
        }
        else{
            g2.draw(this);
        }
    }
    //Este método recalcula la posición de los vertices en un poligóno regular
    public void calculaVertices ( int _radio, double _giro){
        for (int i = 0; i<npoints; i++ ){
            xpoints[i] = (int) (x + _radio*Math.cos((2*Math.PI * i + _giro/40)/npoints));
            ypoints[i] = (int) (y + _radio*Math.sin((2*Math.PI * i + _giro/40)/npoints));
        }
    }

    public void dibujate(Graphics2D bufferGraphics, int x, MouseEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
