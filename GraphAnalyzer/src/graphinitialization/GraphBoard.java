/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphinitialization;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.EtchedBorder;
/**
 *
 * @author Administrator
 */
class GraphBoard extends JPanel{
    public GraphBoard()
    {
        super();
        setSize(400,370);
        setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
    }
    public void paintComponent(Graphics g)
    {
        Graphics2D g2d=(Graphics2D)g;
        g2d.setColor(Color.white);
        g2d.fillRect(0,0,400,370);
        for(int i=0;i<GraphInitialization.vertexList.size();i++)
        {
            g2d.setColor(Color.red);
            GraphInitialization.vertexList.get(i).get(0).drawInner(g2d);
        }
        for(int i=0;i<GraphInitialization.edgeList.size();i++)
        {
            g2d.setColor(Color.red);
            GraphInitialization.edgeList.get(i).drawEdge(g2d);
        }
        if(OperationTool.prevHamiltonianList!=null)
        {
            Vertex u,v;
            Edge e;
            int index=OperationTool.prevHamiltonPathIndex;
            g2d.setColor(Color.blue);
            for(int i=0;i<GraphInitialization.hamiltonianVertexList.get(index).size();i++)
            {
                u=new Vertex(GraphInitialization.hamiltonianVertexList.get(index).get(i));
                if(i!=GraphInitialization.hamiltonianVertexList.get(index).size()-1)
                    v=new Vertex(GraphInitialization.hamiltonianVertexList.get(index).get(i+1));
                else
                    v=new Vertex(GraphInitialization.hamiltonianVertexList.get(index).get(0));
                e=new Edge(u,v);
                e.drawArrow(g2d,1);
            }
        }
    }
    public void addVertexMouseActionListener()
    {
        addMouseListener(GraphInitialization.vertexMouseAction);
    }
    public void removeVertexMouseActionListener()
    {
        removeMouseListener(GraphInitialization.vertexMouseAction);
    }
    public void addEdgeMouseActionListener()
    {
        addMouseListener(GraphInitialization.edgeMouseAction);
    }
    public void removeEdgeMouseActionListener()
    {
        removeMouseListener(GraphInitialization.edgeMouseAction);
    }
    public void addEdgeMouseMotionListener()
    {
        addMouseMotionListener(GraphInitialization.edgeMouseMotion);
    }
    public void removeEdgeMouseMotionListener()
    {
        removeMouseMotionListener(GraphInitialization.edgeMouseMotion);
    }
}
