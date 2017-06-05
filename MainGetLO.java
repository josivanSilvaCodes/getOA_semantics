
/**
 *********************************************************************
 * @author Josivan Pereira da Silva - Msc. Engenharia da Informação
 * Professor em: 
 * Universidade Cruzeiro do Sul e
 * Faculdade Impacta de Tecnologia
 * *******************************************************************
 */
public class MainGetLO {
    
    public static void main(String [ ] args){  
        
        LOViewerGUI lovg = new LOViewerGUI();
               
        SynonymsOnWebFinder sowf = new SynonymsOnWebFinder();
        sowf.lookforSynonyms("ar");
        
    }    
}
