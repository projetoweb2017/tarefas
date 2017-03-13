package telas;

import javax.swing.*;

import banco.de.dados.DAO.RecuperarDAO;
import banco.de.dados.Model.Recuperar;

import java.awt.*;
import java.awt.event.*;

public class RecuperarConta extends JFrame implements ActionListener{
	
   private JLabel lblusuario, lblpergunta, lblemail,lblrecuperarusuario,lblrecuperarsenha,lblbranco,lblbrancoo,lblbrancooo,lblbrancoooo,lblbrancooooo,lblbrancoooooo,lblbrancooooooo;
		
   private JTextField txtusuario,txtpergunta,txtemail;
	
   private JButton bntrecuperarsenha,bntrecuperarusuario;
	
   private JPanel jPanelUsuario,jPanelSenha;
	
   public RecuperarConta(){
      super("Uni - Recuperar Conta");
   	
   	
   	
      lblusuario = new JLabel("                 Usuário:");
      lblpergunta = new JLabel("Pergunta Secreta:");
      lblemail = new JLabel("                  Email:");
   	
   	// Senha
      txtusuario = new JTextField (17);
      txtpergunta = new JTextField(" Qual é a sua comida favorita?");
      lblrecuperarusuario = new JLabel("                              Recuperar Usuário                            ");
      lblbranco = new JLabel("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
      lblbrancoo = new JLabel("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
      lblbrancooo = new JLabel("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
      lblbrancoooo = new JLabel("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
      lblbrancooooo = new JLabel("ooooooooooooooo");
      lblbrancoooooo = new JLabel("ooooooooooooooo");
      lblbrancooooooo = new JLabel("ooooooooooooooo");
      bntrecuperarsenha = new JButton("Recuperar");
   	
   	// Usuario
      txtemail = new JTextField (18);
      lblrecuperarsenha = new JLabel("Recuperar Senha");
   	
      bntrecuperarusuario = new JButton("Recuperar");
   	
      jPanelUsuario = new JPanel();
      jPanelSenha = new JPanel();
   	
   	
   	
   	
   	
   	//Container
   	
      Container caixa = getContentPane();
   
      caixa.setLayout(new BorderLayout());
      caixa.add(jPanelUsuario,BorderLayout.NORTH);
      caixa.add(jPanelSenha,BorderLayout.SOUTH);
   
   	
   	// Painel Usuario
      jPanelUsuario.setBackground(new java.awt.Color(102,153,255));
      jPanelUsuario.setPreferredSize(new Dimension(100,145));//tamanha do painel
   	
   	
      jPanelUsuario.add(lblbranco);
      lblbranco.setFont(new Font("Arial", 1, 10)); 
      lblbranco.setForeground(new Color(102,153,255)); // Cor branca
   	
      jPanelUsuario.add(lblrecuperarusuario);
      lblrecuperarusuario.setFont(new Font("Arial", 1,20)); 
      lblrecuperarusuario.setForeground(new Color(255, 255, 255)); // Cor branca
   	
      jPanelUsuario.add(lblbrancoo);
      lblbrancoo.setFont(new Font("Arial", 1, 10)); 
      lblbrancoo.setForeground(new Color(102,153,255)); // Cor branca
   
   
      jPanelUsuario.add(lblemail);
      lblemail.setFont(new Font("Arial", 1, 18));
      lblemail.setForeground(new Color(255, 255, 255));
   	
      jPanelUsuario.add(txtemail);
      txtemail.setPreferredSize(new Dimension(20,25));
   	
      jPanelUsuario.add(lblbrancooooo);
      lblbrancooooo.setFont(new Font("Arial", 1, 10)); 
      lblbrancooooo.setForeground(new Color(102,153,255)); // Cor branca
   
   	
      jPanelUsuario.add(bntrecuperarusuario);
   	
   	
   	
   	
   	// Painel Senha
      jPanelSenha.setBackground(new java.awt.Color(255,255,255));
      jPanelSenha.setPreferredSize(new Dimension(10,180));//tamanha do painel
   	
      jPanelSenha.add(lblbrancooo);
      lblbrancooo.setFont(new Font("Arial", 1, 10)); 
      lblbrancooo.setForeground(new Color(255,255,255)); // Cor branca
   	
      jPanelSenha.add(lblrecuperarsenha);
      lblrecuperarsenha.setFont(new Font("Arial", 1, 18)); 
      lblrecuperarsenha.setForeground(new Color(54,54,54)); // Cor branca
   	
      jPanelSenha.add(lblbrancoooo);
      lblbrancoooo.setFont(new Font("Arial", 1, 10)); 
      lblbrancoooo.setForeground(new Color(255,255,255)); // Cor branca
   	
      jPanelSenha.add(lblusuario);
      lblusuario.setFont(new Font("Arial", 1, 14));
      lblusuario.setForeground(new Color(54,54,54));
   	
      jPanelSenha.add(txtusuario);
      txtusuario.setPreferredSize(new Dimension(200,25));
   	
      jPanelSenha.add(lblbrancoooooo);
      lblbrancoooooo.setFont(new Font("Arial", 1, 10)); 
      lblbrancoooooo.setForeground(new Color(255,255,255)); // Cor branca
   	
      jPanelSenha.add(lblpergunta);
      lblpergunta.setFont(new Font("Arial", 1, 14));
      lblpergunta.setForeground(new Color(54,54,54));
   	
      jPanelSenha.add(txtpergunta);
      txtpergunta.setPreferredSize(new Dimension(193,25));
   	
      jPanelSenha.add(lblbrancooooooo);
      lblbrancooooooo.setFont(new Font("Arial", 1, 10)); 
      lblbrancooooooo.setForeground(new Color(255,255,255)); // Cor branca
   
      jPanelSenha.add(bntrecuperarsenha);
   	
   	
   
   
   	
   	
   	// Padrão da Tela
      setSize(500,350);
   	
      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); //Fecha apenas a tela
      setLocationRelativeTo(null); // deixa a posição da janela no meio
      setResizable(false);//Não deixa maximizar
      setVisible(true);
   	
   	//botoes
      bntrecuperarusuario.addActionListener(this);
      bntrecuperarsenha.addActionListener(this);
   }
		
   public void actionPerformed(ActionEvent e) {
   		
      if (e.getSource() == bntrecuperarusuario) {
         RecuperarDAO UsuarioDAO = new RecuperarDAO();
         Recuperar re = Recuperar.getInstance();
              
         if(UsuarioDAO.recuperarUsuario(txtemail.getText())){
              	
            JOptionPane.showMessageDialog(null,"Email: " + txtemail.getText() + "\nUsuário: " + re.getUsuario());
         }
         else{
            JOptionPane.showMessageDialog(null,"Erro: Email informado não está cadastrado.");
         } 
      }
      if (e.getSource() == bntrecuperarsenha) {
         RecuperarDAO UsuarioDAO = new RecuperarDAO();
         Recuperar re = Recuperar.getInstance();
              
         if(UsuarioDAO.recuperarSenha(txtusuario.getText(),txtpergunta.getText())){
            JOptionPane.showMessageDialog(null,"Aperte OK para saber sua conta." + "\nAviso: Veja se não tem ninguem por perto para ver a sua senha.");
            JOptionPane.showMessageDialog(null,"Usuario: " + txtusuario.getText() + "\nSenha: " + re.getSenha());
         }
         else{
            JOptionPane.showMessageDialog(null,"Erro: Usuário ou Pergunta Secreta estão incorretos.");
         } 
      }
   }
}