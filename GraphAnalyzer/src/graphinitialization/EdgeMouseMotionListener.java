/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphinitialization;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
/**
 *
 * @author Administrator
 */
class EdgeMouseMotionListener implements MouseMotionListener
{
    public void mouseDragged(MouseEvent me)
    {}
    public void mouseMoved(MouseEvent me)
    {
        Graphics2D g2d=(Graphics2D)((JPanel)me.getSource()).getGraphics();
        for(int i=0;i<GraphInitialization.vertexList.size();i++)
        {
            if(GraphInitialization.vertexList.get(i).get(0).statusClicked==false &&GraphInitialization.vertexList.get(i).get(0).outterCircle.contains(me.getPoint()))
            {
                g2d.setColor(Color.BLUE);
                GraphInitialization.vertexList.get(i).get(0).drawOutter(g2d);
                GraphInitialization.vertexList.get(i).get(0).statusHover=true;
            }
            else if(GraphInitialization.vertexList.get(i).get(0).statusClicked==false && GraphInitialization.vertexList.get(i).get(0).statusHover==true)
            {
                g2d.setColor(Color.white);
                GraphInitialization.vertexList.get(i).get(0).drawOutter(g2d);
                GraphInitialization.vertexList.get(i).get(0).statusHover=false;
            }
            else if(GraphInitialization.vertexList.get(i).get(0).statusClicked==true)
            {
                g2d.setColor(Color.red);
                int x=GraphInitialization.vertexList.get(i).get(0).centerx+5;
                int y=GraphInitialization.vertexList.get(i).get(0).centery+5;
                g2d.drawLine(x,y,me.getX(),me.getY());
                try
                {
                    Thread.sleep(200);
                }
                catch(Exception ex)
                {}
                g2d.setColor(Color.white);
                g2d.drawLine(x,y,me.getX(),me.getY());
            }
        }
    }
}