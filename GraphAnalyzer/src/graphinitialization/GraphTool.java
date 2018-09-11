/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphinitialization;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.BorderFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Administrator
 */
class GraphTool extends JPanel{
    static GraphButton drawVertex,drawEdge;
    static ButtonGroup edgeBtnGrp;
    static GraphRadioButton directedEdge,undirectedEdge;
    public GraphTool()
    {
        super();
        setSize(180,160);
        setLayout(null);
        setBorder(BorderFactory.createTitledBorder("Drawing Tool"));
        drawVertex=new GraphButton("Draw Vertices");
        drawEdge=new GraphButton("Draw Edges");
        directedEdge=new GraphRadioButton("Uni-Directional Edge");
        undirectedEdge=new GraphRadioButton("Bi-Directional Edge");
        directedEdge.setFont(null);
        undirectedEdge.setFont(null);
        edgeBtnGrp=new ButtonGroup();
        drawVertex.setLocation(20,30);
        drawEdge.setLocation(20,65);
        directedEdge.setLocation(20,90);
        undirectedEdge.setLocation(20,115);
        add(drawVertex);
        add(drawEdge);
        add(directedEdge);
        add(undirectedEdge);
        edgeBtnGrp.add(directedEdge);
        edgeBtnGrp.add(undirectedEdge);
        directedEdge.setSelected(true);
        drawEdge.setEnabled(false);
        directedEdge.setEnabled(false);
        undirectedEdge.setEnabled(false);
        drawVertex.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                drawVertex.setEnabled(false);
                drawEdge.setEnabled(true);
                directedEdge.setEnabled(false);
                undirectedEdge.setEnabled(false);
                GraphInitialization.graphBoard.removeEdgeMouseActionListener();
                GraphInitialization.graphBoard.removeEdgeMouseMotionListener();
                GraphInitialization.graphBoard.addVertexMouseActionListener();
            }
        });
        drawEdge.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                drawEdge.setEnabled(false);
                directedEdge.setEnabled(true);
                undirectedEdge.setEnabled(true);
                drawVertex.setEnabled(true);
                GraphInitialization.graphBoard.removeVertexMouseActionListener();
                GraphInitialization.graphBoard.addEdgeMouseActionListener();
                GraphInitialization.graphBoard.addEdgeMouseMotionListener();
            }
        });
    }
    public int getSelectedEdgeType()
    {
        if(directedEdge.isSelected())
            return 0;
        return 1;
    }
}