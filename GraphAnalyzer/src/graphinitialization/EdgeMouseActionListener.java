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
class EdgeMouseActionListener implements MouseListener
{
    public void mouseClicked(MouseEvent me)
    {
        Graphics2D g2d=(Graphics2D)((JPanel)me.getSource()).getGraphics();
        boolean outsideClick=true;
        for(int i=0;i<GraphInitialization.vertexList.size();i++)
        {
            if(GraphInitialization.vertexList.get(i).get(0).outterCircle.contains(me.getPoint()))
            {
                outsideClick=false;
                if(Vertex.sourcei==-1)
                {
                    g2d.setColor(Color.GREEN);
                    GraphInitialization.vertexList.get(i).get(0).drawOutter(g2d);
                    GraphInitialization.vertexList.get(i).get(0).statusClicked=true;
                    Vertex.sourcei=i;
                }
                else
                {
                    if(i!=Vertex.sourcei)
                    {
                        Edge e=new Edge(GraphInitialization.vertexList.get(Vertex.sourcei).get(0),GraphInitialization.vertexList.get(i).get(0));
                        g2d.setColor(Color.red);
                        e.drawEdge(g2d);
                        GraphInitialization.addEdge(e);
                        if(GraphInitialization.gtool.getSelectedEdgeType()==1)
                        {
                            Edge f=new Edge(GraphInitialization.vertexList.get(i).get(0),GraphInitialization.vertexList.get(Vertex.sourcei).get(0));
                            f.drawEdge(g2d);
                            GraphInitialization.addEdge(f);
                        }
                    }
                    GraphInitialization.vertexList.get(Vertex.sourcei).get(0).statusClicked=false;
                    g2d.setColor(Color.white);
                    GraphInitialization.vertexList.get(Vertex.sourcei).get(0).drawOutter(g2d);
                    Vertex.sourcei=-1;
                }
            }
        }
        if(outsideClick==true)
        {
            if(Vertex.sourcei!=-1)
            {
                GraphInitialization.vertexList.get(Vertex.sourcei).get(0).statusClicked=false;
                g2d.setColor(Color.white);
                GraphInitialization.vertexList.get(Vertex.sourcei).get(0).drawOutter(g2d);
                Vertex.sourcei=-1;
            }
        }
    }
    public void mouseExited(MouseEvent me)
    {}
    public void mouseEntered(MouseEvent me)
    {}
    public void mouseReleased(MouseEvent me)
    {}
    public void mousePressed(MouseEvent me)
    {}
}
