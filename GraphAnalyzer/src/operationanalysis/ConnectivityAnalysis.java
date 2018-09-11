/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package operationanalysis;
import graphinitialization.Vertex;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author Administrator
 */
public class ConnectivityAnalysis {
    public boolean isConnected(ArrayList <ArrayList <Vertex>> adjacencyList)
    {
        int arr[][]=new int[adjacencyList.size()][adjacencyList.size()];
        int status[]=new int[adjacencyList.size()];
        LinkedList<Vertex> l=new LinkedList<Vertex>();
        for(int i=0;i<adjacencyList.size();i++)
        {
            for(int j=1;j<adjacencyList.get(i).size();j++)
            {
                arr[i][adjacencyList.get(i).get(j).id]=1;
                arr[adjacencyList.get(i).get(j).id][i]=1;
            }
        }
        l.addLast(adjacencyList.get(0).get(0));
        status[0]=1;
        int no_of_deletions=0;
        while(!l.isEmpty())
        {
            for(int i=0;i<adjacencyList.size();i++)
            {
                if(arr[l.getFirst().id][i]==1&&status[i]==0)
                {
                    l.addLast(adjacencyList.get(i).get(0));
                    status[i]=1;
                    arr[l.getFirst().id][i]=0;
                    arr[i][l.getFirst().id]=0;
                }
            }
            l.removeFirst();
            no_of_deletions++;
        }
        if(no_of_deletions==adjacencyList.size())
            return true;
        return false;
    }
}
