/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphinitialization;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.Toolkit;
import java.io.InputStream;
/**
 *
 * @author Administrator
 */
public class Help extends JFrame{
    private static JTextArea helpText;
    private static JScrollPane helpScrollPane;
    private static String help="";
    public Help()
    {
        super();
        setSize(400,200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Hello");
        setLayout(null);
        setVisible(true);
        Container con=super.getContentPane();
        helpText=new JTextArea();
        helpScrollPane=new JScrollPane(helpText);
        helpScrollPane.setBounds(10,10,365,145);
        con.add(helpScrollPane);
        int x=Toolkit.getDefaultToolkit().getScreenSize().width/2;
        int y=Toolkit.getDefaultToolkit().getScreenSize().height/2;
        super.setLocation(x-super.getWidth()/2,y-super.getHeight()/2);
        try
        {
            int ch;
            InputStream fip=getClass().getResourceAsStream("help.txt"); 
            while((ch=fip.read())!=-1)
            {
                help=help+(char)ch;
            }
        }
        catch(Exception ex)
        {}
        helpText.setText(help);
        helpText.setEditable(false);
    }
}