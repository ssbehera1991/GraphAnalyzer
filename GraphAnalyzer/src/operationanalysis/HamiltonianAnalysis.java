/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package operationanalysis;
import java.util.ArrayList;
import graphinitialization.Vertex;
import graphinitialization.Edge;
import java.util.LinkedList;
/**
 *
 * @author Administrator
 */
public class HamiltonianAnalysis {
    LinkedList<LinkedList<Vertex>> hamitonianList=new LinkedList<LinkedList<Vertex>>();
    public LinkedList<LinkedList<Vertex>> checkHamiltonian(ArrayList <ArrayList <Vertex>> adjacencyList,int root)
    {
        hamiltonianProcess(adjacencyList,null,root,root);
        return hamitonianList;
    }
    void hamiltonianProcess(ArrayList <ArrayList <Vertex>> adjacencyList,Node n,int value,int root)
    {
        ArrayList<Integer> validAdjacencyList=new ArrayList <Integer> ();
        if(n==null)
        {
            n=new Node();
            n.value=value;
            n.index=0;
            n.prev=null;
        }
        validAdjacencyList=findValidAdjacencyList(adjacencyList,n);
        if(validAdjacencyList.size()==0)
        {
            n.next=null;
            if(n.index==adjacencyList.size()-1)
            {
                boolean status=false;
                for(int i=1;i<adjacencyList.get(n.value).size();i++)
                {
                    if(adjacencyList.get(n.value).get(i).id==root)
                    {
                        status=true;
                        break;
                    }
                }
                if(status)
                    printHamiltonian(n,adjacencyList);
            }
            return;
        }
        n.next=new LinkedList[validAdjacencyList.size()];
        for(int i=0;i<validAdjacencyList.size();i++)
        {
            n.next[i]=new LinkedList();
            int temp=validAdjacencyList.get(i);
            n.next[i].add(new Node(temp,n.index+1,n));
            hamiltonianProcess(adjacencyList,(Node)n.next[i].get(0),temp,root);
        }
        return;
    }
    void printHamiltonian(Node n,ArrayList <ArrayList <Vertex>> adjacencyList)
    {
        hamitonianList.add(new LinkedList<Vertex>());
        while(n!=null)
        {
            hamitonianList.get(hamitonianList.size()-1).addFirst(adjacencyList.get(n.value).get(0));
            if(n.prev!=null)
                n=(Node)n.prev.get(0);
            else
                n=null;
        }
    }
    ArrayList findValidAdjacencyList(ArrayList <ArrayList <Vertex>> adjacencyList,Node n)
    {
        ArrayList validAdjacencyList=new ArrayList<Integer>();
        int status,itemp;
        Node temp;
        for(int i=1;i<adjacencyList.get(n.value).size();i++)
        {
            itemp=adjacencyList.get(n.value).get(i).id;
            temp=n;
            status=0;
            while(temp!=null)
            {
                if(temp.value==itemp)
                {
                    status=1;
                    break;
                }
                if(temp.prev!=null)
                    temp=(Node)temp.prev.get(0);
                else
                    temp=null;
            }
            if(status==0)
            {
                validAdjacencyList.add(itemp);
            }
        }
        return validAdjacencyList;
    }
}
class Node
{
    int value,index;
    LinkedList []next;
    LinkedList prev;
    Node()
    {}
    Node(int value,int index,Node n)
    {
        this.value=value;
        this.index=index;
        prev=new LinkedList();
        prev.add(n);
    }
}
