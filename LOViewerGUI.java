
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *********************************************************************
 * @author Josivan Pereira da Silva - Msc. Engenharia da Informação
 * Professor em: 
 * Universidade Cruzeiro do Sul e
 * Faculdade Impacta de Tecnologia
 * *******************************************************************
 */

public class LOViewerGUI extends JFrame{
    
    private JTextField text;
    private JButton btn;
    private JLabel lbl1, lbl2, lblImagem;
  
    public LOViewerGUI () {  
        super ("Get OA 1.1");  
        this.startWindow ();  
    }  
  
    private void startWindow () {   

        this.setLayout(new FlowLayout());
        
               
        text = new JTextField(20); 
        btn = new JButton("Iniciar Busca!");
        lbl1 = new JLabel("1°- Digite uma palavra chave para a busca");
        lbl2 = new JLabel("2°- Aperte o botão INICIAR BUSCA");
        lblImagem = new JLabel(new ImageIcon("src\\logo_getOA.png"));
        
        this.add(lbl1);
        this.add(lbl2);
        this.add(lblImagem);
        this.add(text);  
        this.add(btn);         

        text.setText("");
        text.setColumns(20);        
        text.setSize(100, 100);
        text.setAlignmentX(Component.CENTER_ALIGNMENT);
        text.setVisible(true);
        
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setVisible(true);
        
        lbl1.setAlignmentX(Component.CENTER_ALIGNMENT);
        lbl1.setVisible(true);
        
        lbl2.setAlignmentX(Component.CENTER_ALIGNMENT);
        lbl2.setVisible(true);
        
        lblImagem.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblImagem.setVisible(true);
        
        this.pack();
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize (400, 240);  
        this.setVisible (true);
        this.setResizable(false);
          
   }  
  

}
