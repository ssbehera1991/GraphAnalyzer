/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphinitialization;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 *
 * @author Administrator
 */
class GraphButton extends JButton
{
    static Font f=new Font("Comic Sans MS",Font.PLAIN,12);
    public GraphButton(String str)
    {
        super(str);
        setFont(f);
        setSize(140,20);
    }
}
class GraphTextField extends JTextField
{
    public GraphTextField()
    {
        super();
        setFont(GraphButton.f);
        setSize(100,20);
        setAlignmentY(JTextField.HORIZONTAL);
    }
}
class GraphLabel extends JLabel
{
    public GraphLabel(String str)
    {
        super(str);
        setFont(GraphButton.f);
        setSize(60,20);
    }
}
class GraphRadioButton extends JRadioButton
{
    public GraphRadioButton(String str)
    {
        super(str);
        setFont(GraphButton.f);
        setSize(140,30);
    }
}