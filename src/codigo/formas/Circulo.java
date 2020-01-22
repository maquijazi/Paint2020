/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo.formas;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author jahaziel
 */
public class Circulo extends Ellipse2D.Double {

    public Color color = Color.BLACK;
    public boolean relleno = false;

    //Creo constructor porque aun no existe el objeto 2d de la elipse
    public Circulo(int _posX, int _posY, int _diametro, Color _color, boolean _relleno) {
        super();//invoco al constructor de la clase superior (en este caso ellipse2d)
        x = _posX; //asigno la _posx que me pasan al construir el objeto a la propiedad x de los ellipse2D.double
        y = _posY;
        width = _diametro;
        height = _diametro;
        color = _color;
        relleno = _relleno;
    }
    
    public void dibujate(Graphics2D g2, int _posX){
        int diametro = Math.abs((int) x - _posX);// "x" es un double y por eso hay que castearlo
        width = diametro;
        height = diametro;
        g2.setColor(color);
        if(relleno){
            g2.fill(this); // this: parametro del propio circulo (que es this, el propio circulo)
        }
        else{
            g2.draw(this);
        }
    }
}
