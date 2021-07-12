
package projetojogovelha;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class JogoVelha extends JFrame implements ActionListener{
    private Campo[][] campo = new Campo[3][3];
    private JButton[][] tabuleiro = new JButton[3][3];
    private Map <JButton,String> indice = new HashMap<>();
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    String nomeX;
    String nomeBola;
    private boolean vez = true;
    private ImageIcon bola = new ImageIcon(getClass().getResource("/image/bola.png"));
    private ImageIcon bola1 = new ImageIcon(getClass().getResource("/image/bola1.png"));
    private ImageIcon bola2 = new ImageIcon(getClass().getResource("/image/bola2.png"));
    private ImageIcon bola3 = new ImageIcon(getClass().getResource("/image/bola3.png"));
    private ImageIcon bola4 = new ImageIcon(getClass().getResource("/image/bola4.png"));
    private ImageIcon xis = new ImageIcon(getClass().getResource("/image/xis.png"));
    private ImageIcon xis1 = new ImageIcon(getClass().getResource("/image/xis1.png"));
    private ImageIcon xis2 = new ImageIcon(getClass().getResource("/image/xis2.png"));
    private ImageIcon xis3 = new ImageIcon(getClass().getResource("/image/xis3.png"));
    private ImageIcon xis4 = new ImageIcon(getClass().getResource("/image/xis4.png"));
    private ImageIcon qb = new ImageIcon(getClass().getResource("/image/qb.png"));
    
    public JogoVelha() {
        configurarFrame();
        
    }
    private void centralizarComponente() { 
        Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dw = getSize(); 
        setLocation((ds.width - dw.width) / 2, (ds.height - dw.height) / 2); 
    }
    
    private void configurarFrame(){
        this.setTitle("Jogo da Velha");
        this.setLayout((new GridLayout(3,3)));
        this.setSize(600,600);
        this.criarTabuleiro();
        this.setResizable(false);
        centralizarComponente();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    private void criarTabuleiro(){
        for(int i = 0;i<tabuleiro.length;i++){
            for(int j = 0;j <tabuleiro[0].length;j++){
                this.tabuleiro[i][j]= new JButton();
                this.indice.put(this.tabuleiro[i][j],i+""+j+"");
                this.tabuleiro[i][j].setSize(200,200);
                this.tabuleiro[i][j].setIcon(scaleImage(this.qb,this.tabuleiro[i][j]));
                this.tabuleiro[i][j].addActionListener(this);
                this.campo[i][j]=new Campo();
                this.add(this.tabuleiro[i][j]);
            }
        }
    }
    private ImageIcon scaleImage(ImageIcon image, JButton l){
            
            ImageIcon icon = image;
            Image img = icon.getImage();
            Image imgScale = img.getScaledInstance(l.getWidth(),l.getHeight(),Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(imgScale);
            
            return scaledIcon;
    }
    private int linha(String linha){
        int var = Character.getNumericValue(linha.charAt(0));
        return var;
    }
    private int coluna(String coluna){
        int var = Character.getNumericValue(coluna.charAt(1));
        return var;
    }
    private void venceu(){
        int contXis = 0;
        int contBola = 0;
        int contEmpate = 0;
        // Ganhando por Linha
        for(int i = 0;i<tabuleiro.length;i++){
            for(int j = 0;j <tabuleiro[0].length;j++){
                if(!this.campo[i][j].isVazio()){
                    if(this.campo[i][j].isBola()){
                        contBola++;
                    }
                    if(this.campo[i][j].isXis()){
                        contXis++;
                    }
                
                }
            }
            if(contBola == 3){
                
                for(int j = 0;j <tabuleiro[0].length;j++){
                    tabuleiro[i][j].setIcon(scaleImage(this.bola2,tabuleiro[i][j]));
                }
                JOptionPane.showMessageDialog(null,nomeBola+" Venceu");
                this.dispose();
                
                break;
            }else{
                contBola = 0;
            }
            if(contXis == 3){
                
                for(int j = 0;j <tabuleiro[0].length;j++){
                    tabuleiro[i][j].setIcon(scaleImage(this.xis2,tabuleiro[i][j]));
                }
                JOptionPane.showMessageDialog(null,nomeX+" Venceu");
                this.dispose();
               
                break;
            }else{
                contXis = 0;
            }
        }
        contBola = 0;
        contXis = 0;
        // Ganhando por Coluna
        for(int i = 0;i<tabuleiro[0].length;i++){
            for(int j = 0;j <tabuleiro.length;j++){
                if(!this.campo[j][i].isVazio()){
                    if(this.campo[j][i].isBola()){
                        contBola++;
                    }
                    if(this.campo[j][i].isXis()){
                        contXis++;
                    }
                
                }
            }
            if(contBola == 3){
                
                for(int j = 0;j <tabuleiro[0].length;j++){
                    tabuleiro[j][i].setIcon(scaleImage(this.bola1,tabuleiro[j][i]));
                }
                JOptionPane.showMessageDialog(null,nomeBola+" Venceu");
                this.dispose();
                
                break;
            }else{
                contBola = 0;
            }
            if(contXis == 3){
                
                for(int j = 0;j <tabuleiro[0].length;j++){
                    tabuleiro[j][i].setIcon(scaleImage(this.xis1,tabuleiro[j][i]));
                }
                JOptionPane.showMessageDialog(null,nomeX+" Venceu");
                this.dispose();
                
                break;
            }else{
                contXis = 0;
            }
        }
        contBola = 0;
        contXis = 0;
        //Ganhando por Diagonal 1
        for(int i = 0;i < tabuleiro.length;i++){
            if(!this.campo[i][i].isVazio()){
                    if(this.campo[i][i].isBola()){
                        contBola++;
                    }
                    if(this.campo[i][i].isXis()){
                        contXis++;
                    }
                
            }
           if(contBola == 3){
                for(int j = 0;j <tabuleiro[0].length;j++){
                    tabuleiro[j][j].setIcon(scaleImage(this.bola3,tabuleiro[j][j]));
                }
                JOptionPane.showMessageDialog(null,nomeBola+" Venceu");
                this.dispose();
                
            }
            if(contXis == 3){
                for(int j = 0;j <tabuleiro[0].length;j++){
                    tabuleiro[j][j].setIcon(scaleImage(this.xis3,tabuleiro[j][j]));
                }
                JOptionPane.showMessageDialog(null,nomeX+" Venceu");
                this.dispose();  
                
            }
        }
        contBola = 0;
        contXis = 0;
        //Ganhando por Diagonal 2
        for(int i = 0;i < tabuleiro.length;i++){
            for(int j = 2;j < tabuleiro[0].length;){
                j-=i;
                if(!this.campo[i][j].isVazio()){
                    if(this.campo[i][j].isBola()){
                        contBola++;
                    }
                    if(this.campo[i][j].isXis()){
                        contXis++;
                    }
                
                }
                break;
            }
            if(contBola == 3){
                for(int a = 0;a < tabuleiro.length;a++){
                    for(int j = 2;j < tabuleiro[0].length;){
                        j-=a;
                        tabuleiro[a][j].setIcon(scaleImage(this.bola4,tabuleiro[a][j]));
                        break;
                    }
                }
                JOptionPane.showMessageDialog(null,nomeBola+" Venceu");
                this.dispose();
                
            }
            if(contXis == 3){
                for(int a = 0;a < tabuleiro.length;a++){
                    for(int j = 2;j < tabuleiro[0].length;){
                        j-=a;
                        tabuleiro[a][j].setIcon(scaleImage(this.xis4,tabuleiro[a][j]));
                        break;
                    }
                }
                JOptionPane.showMessageDialog(null,nomeX+" Venceu");
                this.dispose();
                
            }
        }
        //Caso Empate
        for(int i = 0;i<tabuleiro.length;i++){
            for(int j = 0;j <tabuleiro[0].length;j++){
                if(!this.campo[i][j].isVazio()){
                    contEmpate++;
                }
            }
            if(contEmpate == 9){
                JOptionPane.showMessageDialog(null,"Empate");
                this.dispose(); 
                criarTabuleiro();
            }
        }

        
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String var = this.indice.get(e.getSource());
        int linha = linha(var);
        int coluna = coluna(var);
        
        if(vez){
            if(campo[linha][coluna].isVazio()){
                campo[linha][coluna].setXisB(true);
                tabuleiro[linha][coluna].setIcon(scaleImage(this.xis,tabuleiro[linha][coluna]));
                this.vez = !this.vez;
            }
                  
        
    
        }else{
             if(campo[linha][coluna].isVazio()){
                campo[linha][coluna].setBolaB(true);
                tabuleiro[linha][coluna].setIcon(scaleImage(this.bola,tabuleiro[linha][coluna]));
                this.vez = !this.vez;
            }
        }
        this.venceu();
        
    }
}
