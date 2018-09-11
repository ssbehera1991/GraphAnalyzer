/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphinitialization;
import operationanalysis.ConnectivityAnalysis;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import operationanalysis.HamiltonianAnalysis;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.Point;
import java.util.LinkedList;
/**
 *
 * @author Administrator
 */
class OperationTool extends JPanel{
    private static GraphButton showHamiltonian,exit,nextHamiltonian,prevHamiltonian,help;
    private static GraphLabel rootL;
    private static GraphTextField root;
    static int prevHamiltonPathIndex=-1,currentHamiltonianPathIndex=-1;
    static LinkedList<Vertex> prevHamiltonianList=null;
    public OperationTool() 
    {
        super();
        setSize(180,190);
        setLayout(null);
        setBorder(BorderFactory.createTitledBorder("Operation Tool"));
        showHamiltonian=new GraphButton("Show Hamiltonian");
        exit=new GraphButton("Exit");
        rootL=new GraphLabel("Root");
        nextHamiltonian=new GraphButton("Next");
        prevHamiltonian=new GraphButton("Prev");
        help=new GraphButton("Help");
        root=new GraphTextField();
        showHamiltonian.setLocation(20,30);
        rootL.setLocation(20,60);
        root.setLocation(60,60);
        nextHamiltonian.setBounds(95,90,65,20);
        prevHamiltonian.setBounds(20,90,65,20);
        help.setLocation(20,120);
        exit.setLocation(20,150);
        add(showHamiltonian);
        add(exit);
        add(rootL);
        add(root);
        add(nextHamiltonian);
        add(prevHamiltonian);
        add(help);
        nextHamiltonian.setEnabled(false);
        prevHamiltonian.setEnabled(false);
        nextHamiltonian.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                showHamiltonianCycle(currentHamiltonianPathIndex+1,0);
                currentHamiltonianPathIndex++;
                if(currentHamiltonianPathIndex==GraphInitialization.hamiltonianVertexList.size()-1)
                    nextHamiltonian.setEnabled(false);
                prevHamiltonian.setEnabled(true);
            }
        });
        prevHamiltonian.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                showHamiltonianCycle(currentHamiltonianPathIndex-1,0);
                currentHamiltonianPathIndex--;
                if(currentHamiltonianPathIndex==0)
                    prevHamiltonian.setEnabled(false);
                nextHamiltonian.setEnabled(true);
            }
        });
        exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        root.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent f)
            {
                root.setBackground(Color.white);
                root.selectAll();
            }
            public void focusLost(FocusEvent f)
            {}
        });
        help.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                new Help();
            }
        });
        showHamiltonian.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                int rootv;
                prevHamiltonian.setEnabled(false);
                nextHamiltonian.setEnabled(false);
                if(prevHamiltonianList!=null)
                {
                    showHamiltonianCycle(prevHamiltonPathIndex,1);    
                }
                try
                {
                    rootv=Integer.parseInt(root.getText())-1;
                }
                catch(Exception ex)
                {
                    root.setText("Invalid Root");
                    root.setBackground(Color.red);
                    return;
                }
                if(rootv<0||rootv>=GraphInitialization.vertexList.size())
                {
                    root.setText("Invalid Root");
                    root.setBackground(Color.red);
                    return;
                }
                Graphics2D g2d=(Graphics2D)GraphInitialization.graphBoard.getGraphics();
                for(int i=0;i<GraphInitialization.vertexList.size();i++)
                {
                    g2d.setColor(Color.white);
                    GraphInitialization.vertexList.get(i).get(0).drawOutter(g2d);
                }
                GraphInitialization.hamiltonianVertexList=new HamiltonianAnalysis().checkHamiltonian(GraphInitialization.vertexList,rootv);
                new ResultText(GraphInitialization.hamiltonianVertexList,new ConnectivityAnalysis().isConnected(GraphInitialization.vertexList),GraphInitialization.vertexList.size(),GraphInitialization.edgeList.size());
                if(GraphInitialization.hamiltonianVertexList.size()>=1)
                {
                    g2d.setColor(Color.GREEN);
                    GraphInitialization.vertexList.get(rootv).get(0).drawOutter(g2d);
                    currentHamiltonianPathIndex=0;
                    showHamiltonianCycle(currentHamiltonianPathIndex,0);
                    prevHamiltonianList=GraphInitialization.hamiltonianVertexList.get(0);
                }
                if(GraphInitialization.hamiltonianVertexList.size()>=2)
                {
                    nextHamiltonian.setEnabled(true);
                }
            }
        });
    }
    public static void showHamiltonianCycle(int index,int status)
    {
        Vertex u,v;
        Edge e;
        Graphics2D g2d=(Graphics2D)GraphInitialization.graphBoard.getGraphics();
        if(prevHamiltonPathIndex!=-1)
        {
            g2d.setColor(Color.white);
            if(status==1)
            {
                for(int i=0;i<prevHamiltonianList.size();i++)
                {
                    u=new Vertex(prevHamiltonianList.get(i));
                    if(i!=prevHamiltonianList.size()-1)
                        v=new Vertex(prevHamiltonianList.get(i+1));
                    else
                        v=new Vertex(prevHamiltonianList.get(0));
                    e=new Edge(u,v);
                    e.drawArrow(g2d,1);
                }
            }
            else
            {
                for(int i=0;i<GraphInitialization.hamiltonianVertexList.get(prevHamiltonPathIndex).size();i++)
                {
                    u=new Vertex(GraphInitialization.hamiltonianVertexList.get(prevHamiltonPathIndex).get(i));
                    if(i!=GraphInitialization.hamiltonianVertexList.get(prevHamiltonPathIndex).size()-1)
                        v=new Vertex(GraphInitialization.hamiltonianVertexList.get(prevHamiltonPathIndex).get(i+1));
                    else
                        v=new Vertex(GraphInitialization.hamiltonianVertexList.get(index).get(0));
                    e=new Edge(u,v);
                    e.drawArrow(g2d,1);
                }
            }
        }
        if(status!=1)
        {
            prevHamiltonPathIndex=index;
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
    
}