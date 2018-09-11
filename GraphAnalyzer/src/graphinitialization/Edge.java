/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphinitialization;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.Point;
/**
 *
 * @author Administrator
 */
public class Edge
{
    Line2D line;
    Vertex source=null,dest=null;
    double length,slope;
    Edge(Vertex s,Vertex d)
    {
        source=new Vertex(s);
        dest=new Vertex(d);
        line=new Line2D.Double(s.centerx+5,s.centery+5,d.centerx+5,d.centery+5);
        length=Math.sqrt(Math.pow(line.getX1()-line.getX2(),2)+Math.pow(line.getY1()-line.getY2(),2));
        slope=Math.toDegrees(Math.atan((line.getY1()-line.getY2())/(line.getX1()-line.getX2())));
    }
    public void drawArrow(Graphics2D g2d,int pos)
    {
        Point temp1=new Point();
        Point temp2=new Point();
        int x1,y1,x2,y2,x3,y3;
        if(line.getX1()<line.getX2())
        {
            if(pos==0)
            {
                temp1.x=(int)(line.getX1()+(length-30)*Math.cos(slope*(Math.PI/180)));
                temp1.y=(int)(line.getY1()+(length-30)*Math.sin(slope*(Math.PI/180)));
                temp2.x=(int)(line.getX1()+(length-20)*Math.cos(slope*(Math.PI/180)));
                temp2.y=(int)(line.getY1()+(length-20)*Math.sin(slope*(Math.PI/180)));
                x1=(int)(line.getX1()+(length-10)*Math.cos(slope*(Math.PI/180)));
                y1=(int)(line.getY1()+(length-10)*Math.sin(slope*(Math.PI/180)));
            }
            else
            {
                temp1.x=(int)(line.getX1()+(length/2-20)*Math.cos(slope*(Math.PI/180)));
                temp1.y=(int)(line.getY1()+(length/2-20)*Math.sin(slope*(Math.PI/180)));
                temp2.x=(int)(line.getX1()+(length/2-10)*Math.cos(slope*(Math.PI/180)));
                temp2.y=(int)(line.getY1()+(length/2-10)*Math.sin(slope*(Math.PI/180)));
                x1=(int)(line.getX1()+line.getX2())/2;
                y1=(int)(line.getY1()+line.getY2())/2;
            }
        }
        else
        {
            if(pos==0)
            {
                temp1.x=(int)(line.getX1()-(length-30)*Math.cos(slope*(Math.PI/180)));
                temp1.y=(int)(line.getY1()-(length-30)*Math.sin(slope*(Math.PI/180)));
                temp2.x=(int)(line.getX1()-(length-20)*Math.cos(slope*(Math.PI/180)));
                temp2.y=(int)(line.getY1()-(length-20)*Math.sin(slope*(Math.PI/180)));
                x1=(int)(line.getX1()-(length-10)*Math.cos(slope*(Math.PI/180)));
                y1=(int)(line.getY1()-(length-10)*Math.sin(slope*(Math.PI/180)));
            }
            else
            {
                temp1.x=(int)(line.getX1()-(length/2-20)*Math.cos(slope*(Math.PI/180)));
                temp1.y=(int)(line.getY1()-(length/2-20)*Math.sin(slope*(Math.PI/180)));
                temp2.x=(int)(line.getX1()-(length/2-10)*Math.cos(slope*(Math.PI/180)));
                temp2.y=(int)(line.getY1()-(length/2-10)*Math.sin(slope*(Math.PI/180)));
                x1=(int)(line.getX1()+line.getX2())/2;
                y1=(int)(line.getY1()+line.getY2())/2;
            }
        }
        x2=(int)(temp1.x+((temp2.x-temp1.x)*Math.cos(45*(Math.PI/180)))-((temp2.y-temp1.y)*Math.sin(45*(Math.PI/180))));
        y2=(int)(temp1.y+((temp2.x-temp1.x)*Math.sin(45*(Math.PI/180)))+((temp2.y-temp1.y)*Math.cos(45*(Math.PI/180))));
        x3=(int)(temp1.x+((temp2.x-temp1.x)*Math.cos(-45*(Math.PI/180)))-((temp2.y-temp1.y)*Math.sin(-45*(Math.PI/180))));
        y3=(int)(temp1.y+((temp2.x-temp1.x)*Math.sin(-45*(Math.PI/180)))+((temp2.y-temp1.y)*Math.cos(-45*(Math.PI/180))));
        g2d.drawLine(x1,y1,x2,y2);
        g2d.drawLine(x1,y1,x3,y3);
    }
    public void drawEdge(Graphics2D g2d)
    {
        g2d.draw(line);
        drawArrow(g2d,0);
    }
}
