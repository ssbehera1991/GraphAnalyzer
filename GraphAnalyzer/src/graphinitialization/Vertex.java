/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphinitialization;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.Graphics2D;
import java.awt.Color;
/**
 *
 * @author Administrator
 */
public class Vertex
{
    Ellipse2D.Double innerCircle,outterCircle;
    boolean statusClicked,statusHover;
    static int sourcei=-1;
    int centerx,centery;
    public int id;
    public Vertex(int x,int y)
    {
        innerCircle=new Ellipse2D.Double(x,y,10,10);
        outterCircle=new Ellipse2D.Double(x-3,y-3,16,16);
        centerx=x;
        centery=y;
        statusClicked=false;
        statusHover=false;
        id=GraphInitialization.vertexList.size();
    }
    public Vertex(Vertex v)
    {
        this.centerx=v.centerx;
        this.centery=v.centery;
        this.id=v.id;
        innerCircle=new Ellipse2D.Double(centerx,centery,10,10);
        outterCircle=new Ellipse2D.Double(centerx-3,centery-3,16,16);
    }
    public void drawInner(Graphics2D g2d)
    {
        g2d.fill(innerCircle);
        g2d.setColor(Color.black);
        g2d.drawString(""+(id+1),centerx,centery);
    }
    public void drawOutter(Graphics2D g2d)
    {
        g2d.fill(outterCircle);
        g2d.setColor(Color.red);
        drawInner(g2d);
    }
    public boolean checkIntersection()
    {
        if(centerx-3<=0 || centerx+13>=GraphInitialization.graphBoard.getWidth())
                return true;
        if(centery-10<=0|| centery+13>=GraphInitialization.graphBoard.getHeight())
            return true;
        for(int i=0;i<GraphInitialization.vertexList.size();i++)
        {
            Rectangle2D bnd =outterCircle.getBounds2D();
            if(GraphInitialization.vertexList.get(i).get(0).outterCircle.intersects(bnd))
            {
                Graphics2D g2d=(Graphics2D)GraphInitialization.gtool.getGraphics();
                g2d.setColor(Color.GREEN);
                GraphInitialization.vertexList.get(i).get(0).drawOutter(g2d);
                return true;
            }
        }
        return false;
    }
}
