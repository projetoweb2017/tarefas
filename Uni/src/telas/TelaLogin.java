package telas;

import javax.swing.*;
import banco.de.dados.DAO.LoginDAO;
import banco.de.dados.Model.Login;

import java.awt.*;
import java.awt.event.*;

public class TelaLogin extends JFrame implements ActionListener {

   ImageIcon logo = new ImageIcon(getClass().getResource("logo.jpg"));
	
   JLabel label = new JLabel(logo);
	
   private JTextField  txtusuario, txtsenha;
	
   private JLabel lbusuario, lbsenha,lbcadastro,lbbranco,lbbrancoo,lbbrancooo;
	
   private JButton bntentrar, bntesqsenha, bntcadastro;
   
   private JPanel jPanelusuario;
   	
   public TelaLogin(){
      super("Uni - Login");
   	
      
      // montando o painel dos dados de entrada
   	
      txtusuario = new JTextField(20);
      txtsenha = new JPasswordField(20);
   	
      lbusuario = new JLabel ("Usuário: ");
      lbsenha = new JLabel("  Senha: ");
      lbbranco = new JLabel("                                                                                              ");
      lbbrancoo = new JLabel("                                                                                              ");
      lbbrancooo = new JLabel("                                                                                              ");
      lbcadastro = new JLabel("Caso não tenha uma conta");
   	
      bntentrar = new JButton("Entrar");
      bntesqsenha = new JButton("Recuperar conta");
      bntcadastro = new JButton("clique aqui");
   	
      Container caixa = getContentPane();
      
      jPanelusuario = new JPanel();
   	
      caixa.setLayout(new FlowLayout());//leyout nulo para poder posicionar os components
   	
      bntcadastro.setForeground(new Color(0, 102, 204));//Cor do texto do botao
      bntesqsenha.setForeground(new Color(0, 102, 204));
   	
   	//posicionamento e tamanho
   			
      bntesqsenha.setContentAreaFilled(false);//tira o fundo
      bntcadastro.setContentAreaFilled(false);
      bntesqsenha.setBorder(null);//tira as bordas
      bntcadastro.setBorder(null);
   	
   	
   		
   	
      lbcadastro.setFont(new Font("Arial", 1, 13)); 
      bntcadastro.setFont(new Font("Arial", 1, 13)); 
      bntesqsenha.setFont(new Font("Arial", 1, 13)); 
   	
   	//maozinha
      bntentrar.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
      bntesqsenha.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
      bntcadastro.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
   
   	
   	//adiciona os componentes em ordem
   	
      
      
      
      
      
      caixa.add(label);
      label.setPreferredSize(new Dimension(500,255));//tamanho da label
      
      
   
      
      
      caixa.add(jPanelusuario);
      jPanelusuario.setPreferredSize(new Dimension(320,240));//tamanha do painel
      jPanelusuario.setLayout(new FlowLayout());
        
      jPanelusuario.add(lbbrancooo);
      jPanelusuario.add(lbusuario);
      jPanelusuario.add(txtusuario);
      jPanelusuario.add(lbsenha);
      jPanelusuario.add(txtsenha);
      jPanelusuario.add(bntentrar);
      jPanelusuario.add(lbbranco);
      jPanelusuario.add(lbbrancoo);
      jPanelusuario.add(lbcadastro);
      jPanelusuario.add(bntcadastro);
      jPanelusuario.add(bntesqsenha);
        
      jPanelusuario.setBorder(BorderFactory.createEtchedBorder());
      caixa.setBackground(new java.awt.Color(255,255,255));  
      jPanelusuario.setBackground(new java.awt.Color(232,232,232));  
        
      txtusuario.setPreferredSize(new Dimension(50,30));
      txtsenha.setPreferredSize(new Dimension(50,30));
      bntesqsenha.setPreferredSize(new Dimension(130,35));
      bntentrar.setPreferredSize(new Dimension(100,30));
   
   	
      bntentrar.addActionListener(this);
      bntesqsenha.addActionListener(this);
      bntcadastro.addActionListener(this);
   	
      setSize(450,550);
   	
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null); // deixa a posição da janela no meio
      setResizable(false);//Não deixa maximizar
      setVisible(true);
   	
      getRootPane().setDefaultButton(bntentrar);
   }

	//Ação para os botoes
   public void actionPerformed(ActionEvent e) {
   	
      if (e.getSource() == bntentrar) {
         Login lo = Login.getInstance();
         LoginDAO dao = new LoginDAO();
           
         if(dao.checkLogin(txtusuario.getText(), txtsenha.getText())){
            if(lo.getCargo().equals("Colaborador")){
               this.dispose();
               new telas.colaborador.TelaPrincipal().setVisible(true);
            }
            if(lo.getCargo().equals("Avaliador")){
               this.dispose();
               new telas.avaliador.TelaPrincipal().setVisible(true);
            }
            if(lo.getCargo().equals("Superior")){
               this.dispose();
               new telas.superior.TelaPrincipal().setVisible(true);
            }
           	
         }
         else{
            JOptionPane.showMessageDialog(null,"Usuário ou senha incorreta.");
         }
      }
   	
      if (e.getSource() == bntcadastro) {
         TelaCadastro JanelaCadastro = new TelaCadastro();  
      
         JanelaCadastro.setVisible(true);   
      }
      if (e.getSource() == bntesqsenha) {
         RecuperarConta JanelaRecuperar = new RecuperarConta();  
      	  
         JanelaRecuperar.setVisible(true);  
      }
   	
   }
}