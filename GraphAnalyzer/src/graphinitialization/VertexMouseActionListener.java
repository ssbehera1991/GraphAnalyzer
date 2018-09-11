/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphinitialization;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
class VertexMouseActionListener implements MouseListener
{
    public void mouseExited(MouseEvent me)
    {
        
    }
    public void mouseEntered(MouseEvent me)
    {
        
    }
    public void mouseReleased(MouseEvent me)
    {
        
    }
    public void mousePressed(MouseEvent me)
    {
    }
    public void mouseClicked(MouseEvent me)
    {
        Graphics2D g2d=(Graphics2D)((JPanel)me.getSource()).getGraphics();
        g2d.setColor(Color.red);
        Vertex c=new Vertex(me.getPoint().x-5,me.getPoint().y-5);
        if(!c.checkIntersection())
        {
            c.drawInner(g2d);
            GraphInitialization.addVertex(c);
        }
    }
}