/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphinitialization;

import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Container;
import java.awt.Toolkit;
/**
 *
 * @author Administrator
 */
public class ResultText extends JFrame{
    private static JTextArea resultText;
    private static JScrollPane resultScrollPane;
    private static String result;
    public ResultText(LinkedList<LinkedList<Vertex>> hamiltonianVertexList,boolean connected,int no_of_vertices,int no_of_edges)
    {
        super();
        setSize(400,200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Results");
        setLayout(null);
        setVisible(true);
        Container con=super.getContentPane();
        resultText=new JTextArea();
        resultScrollPane=new JScrollPane(resultText);
        resultScrollPane.setBounds(10,10,365,145);
        con.add(resultScrollPane);
        int x=Toolkit.getDefaultToolkit().getScreenSize().width/2;
        int y=Toolkit.getDefaultToolkit().getScreenSize().height/2;
        super.setLocation(x-super.getWidth()/2,y-super.getHeight()/2);
        result="The no. of Vertices in the Graph is "+no_of_vertices;
        result=result+"\nThe no. of Edges in the Graph is "+no_of_edges;
        result=result+"\nThe Graph is ";
        if(connected)
            result=result+"Connected";
        else
            result=result+"Not Connected";
        result=result+"\nThe no. of Hamiltonian Cycles present in the Graph is "+hamiltonianVertexList.size();
        if(hamiltonianVertexList.size()>=1)
        {
            result=result+"\nThe Hamiltonian Cycles present in the graph are: ";
            for(int i=0;i<hamiltonianVertexList.size();i++)
            {
                result=result+"\n";
                for(int j=0;j<hamiltonianVertexList.get(i).size();j++)
                {
                    result=result+(hamiltonianVertexList.get(i).get(j).id+1);
                }
                result=result+(hamiltonianVertexList.get(i).get(0).id+1);
            }
        }
        resultText.setText(result);
        resultText.setEditable(false);
    }
}
