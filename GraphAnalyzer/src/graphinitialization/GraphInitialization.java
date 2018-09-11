/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphinitialization;
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.Toolkit;
import javax.swing.SwingUtilities;
import java.util.ArrayList;
import java.util.LinkedList;
/**
 *
 * @author Administrator
 */
public class GraphInitialization extends JFrame{
    static GraphBoard graphBoard;
    static GraphTool gtool;
    static OperationTool otool;
    static VertexMouseActionListener vertexMouseAction;
    static EdgeMouseActionListener edgeMouseAction;
    static EdgeMouseMotionListener edgeMouseMotion;
    static ArrayList<ArrayList <Vertex>> vertexList;
    static ArrayList<Edge> edgeList;
    static LinkedList<LinkedList<Vertex>> hamiltonianVertexList=null;
    public GraphInitialization()
    {
        int x,y;
        Container con=super.getContentPane();
        vertexList=new ArrayList<ArrayList<Vertex>>();
        edgeList=new ArrayList<Edge>();
        vertexMouseAction=new VertexMouseActionListener();
        edgeMouseAction=new EdgeMouseActionListener();
        edgeMouseMotion=new EdgeMouseMotionListener();
        //
        this.setTitle("Graph Analyzer");
        this.setSize(620,420);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        con.setLayout(null);
        //
        graphBoard=new GraphBoard();
        gtool=new GraphTool();
        otool=new OperationTool();
        graphBoard.setLocation(10,6);
        gtool.setLocation(416,6);
        otool.setLocation(416,180);
        con.add(graphBoard);
        con.add(gtool);
        con.add(otool);
        //
        x=Toolkit.getDefaultToolkit().getScreenSize().width/2;
        y=Toolkit.getDefaultToolkit().getScreenSize().height/2;
        super.setLocation(x-super.getWidth()/2,y-super.getHeight()/2);
    }
    public static void addVertex(Vertex c)
    {
        vertexList.add(new ArrayList<Vertex>());
        vertexList.get(vertexList.size()-1).add(c);
    }
    public static void addEdge(Edge e)
    {
        int index=e.source.id;
        boolean edgeExist=false;
        for(int i=1;i<vertexList.get(index).size();i++)
        {
            if(vertexList.get(index).get(i).id==e.dest.id)
                edgeExist=true;
        }
        if(!edgeExist)
        {
            edgeList.add(e);
            vertexList.get(index).add(e.dest);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run()
            {
                new GraphInitialization();
            }
        });
    }
}