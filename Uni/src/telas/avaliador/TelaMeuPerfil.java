package telas.avaliador;

import javax.swing.*;

import banco.de.dados.DAO.CadastroDAO;
import banco.de.dados.DAO.LoginDAO;
import banco.de.dados.Model.Login;

import java.awt.*;
import java.awt.event.*;

public class TelaMeuPerfil extends JFrame implements ActionListener {

   Login lo = Login.getInstance();
   
   //imagen menu
   ImageIcon mp = new ImageIcon(getClass().getResource("img/bntmp.png"));
	
   JButton bntmeuperfil = new JButton(mp);	

   ImageIcon historico = new ImageIcon(getClass().getResource("img/bntns.png"));
	
   JButton bnthistorico = new JButton(historico);	



   ImageIcon novasuges = new ImageIcon(getClass().getResource("img/bnthist.png"));
	
   JButton bntnovasugestao = new JButton(novasuges);	



   ImageIcon sair = new ImageIcon(getClass().getResource("img/bntsair.png"));
	
   JButton bntsair = new JButton(sair);	

   ImageIcon retorn = new ImageIcon(getClass().getResource("img/bntr.png"));
	
   JButton bntretornar = new JButton(retorn);	
   
		
   private JLabel lblnovasugestao,lbltitulo,lbdata,lbcurso,lbperiodo,lbtelr,lbtelc,lbusuario,lbsenha,email,esp3;
	
		
   private JTextField txttitulo,txtdt,txtcurso,txttelefoner,txttelefonec,txtusuario,txtsenha,txtemail,txtcargo;
	
   private JLabel espaco;

   
   
	
   private JButton bntenviar,bntlimpar;

   private JPanel jPanelMenu,jPanelNovaSugestao;
   
   // Mensagem de erro 
   private String ErroMSG;
   
	  private boolean checknome;
	  private boolean checkdata;
	  private boolean checktelr;
	  private boolean checktelc;
	  private boolean checkemail;
	  private boolean checkusuario;
	  private boolean checksenha;
	  private boolean checktelefones;
	
	
   public TelaMeuPerfil(){
      super("Uni - Meu Perfil");
   	     
      
     
      
      
   	
   	//Menu
   	        		
      espaco  = new JLabel(" ");
     //fundo dos botoes
   
      bntmeuperfil.setContentAreaFilled(false);//tira o fundo
      bnthistorico.setContentAreaFilled(false);
      bntmeuperfil.setBorder(null);//tira as bordas
      bnthistorico.setBorder(null);
      
      bntnovasugestao.setContentAreaFilled(false);
      bntnovasugestao.setBorder(null);//tira as bordas  
      
      bntsair.setContentAreaFilled(false);
      bntsair.setBorder(null);//tira as bordas
      
      bntretornar.setContentAreaFilled(false);
      bntretornar.setBorder(null);//tira as bordas
   
   
   
      //maozinha
   
   
      bntmeuperfil.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
      bnthistorico.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
      bntnovasugestao.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
      bntsair.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
      bntretornar.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
   
   	
   	
   			
   	
      bntenviar = new JButton("Atualizar");
      bntlimpar = new JButton("Cancelar");
   	
      jPanelMenu = new JPanel();
      jPanelNovaSugestao = new JPanel();
   
   					
     
      //labels
      esp3 = new JLabel(" ");

   
   
      
      
      lblnovasugestao = new JLabel("                Meu Perfil");
      lblnovasugestao.setFont(new Font("Arial", 1, 34)); 
      lblnovasugestao.setForeground(new Color(0, 102, 204));
   
    
          
    
      lbltitulo = new JLabel(" Nome Completo ");
      lbdata = new JLabel("                                 Data de Nascimento ");
      lbcurso = new JLabel(" Categoria ");
      lbperiodo = new JLabel("      Cargo ");
      lbtelr = new JLabel(" Telefone residencial ");
      lbtelc = new JLabel(" Telefone celular ");
      lbusuario = new JLabel(" Usuário ");
      lbsenha = new JLabel("                                          Senha ");
      email = new JLabel(" E-mail ");
   
    //txt 
    
      txttitulo = new JTextField(0);
   
      txtdt = new JTextField(0);
      txtcurso = new JTextField(0);
      txttelefoner = new JTextField(0);
      txttelefonec = new JTextField(0);
      txtusuario = new JTextField(0);
      txtsenha = new JPasswordField(0);
      txtemail = new JTextField(0);
      txtcargo = new JTextField(0);
   
   
   
   
   
   
   	
      Container caixa = getContentPane();
   	
      caixa.setLayout(new BorderLayout());//leyout nulo para poder posicionar os components
      caixa.add(jPanelMenu, BorderLayout.WEST);
      caixa.add(jPanelNovaSugestao, BorderLayout.CENTER);
   	
   	
   	
   	
   	//Painel do Menu
      jPanelMenu.setBackground(new java.awt.Color(0,102,204));
    
   
   
      jPanelMenu.setPreferredSize(new Dimension(170,200));//tamanha do painel
      
      jPanelMenu.setLayout(new FlowLayout());
      
      jPanelMenu.add(bntmeuperfil);
    
      
      jPanelMenu.add(bnthistorico);
              
      jPanelMenu.add(bntnovasugestao);
      
      jPanelMenu.add(espaco,BorderLayout.CENTER);
      espaco.setPreferredSize(new Dimension(170,50));
     
      jPanelMenu.add(bntretornar);
      
      jPanelMenu.add(bntsair);
   
    
         //painel nova sugestao
         
    
      jPanelNovaSugestao.setPreferredSize(new Dimension(300,800));//tamanha do painel
      jPanelNovaSugestao.setLayout(new FlowLayout());
      jPanelNovaSugestao.setBackground(new java.awt.Color(255,255,255));
   
      
      
      
   
      jPanelNovaSugestao.add(lblnovasugestao); 
      lblnovasugestao.setPreferredSize(new Dimension(460,50));
           
                   
                     
      jPanelNovaSugestao.add(lbltitulo);
      lbltitulo.setPreferredSize(new Dimension(300,30));
          
           
      jPanelNovaSugestao.add(lbdata);
      lbdata.setPreferredSize(new Dimension(230,30));
   
   
      jPanelNovaSugestao.add(txttitulo);
      txttitulo.setPreferredSize(new Dimension(395,30));
      txttitulo.setText(lo.getNome_Completo());
         
          
          
          
                   
          
         
         
                    
         
         
         
         
          //mascara data de nacimento
      try{ 
         javax.swing.text.MaskFormatter dt= new javax.swing.text.MaskFormatter("##/##/####");
         txtdt = new javax.swing.JFormattedTextField(dt);
      }
      catch (Exception e){
      }
   
    
      jPanelNovaSugestao.add(txtdt);
      txtdt.setPreferredSize(new Dimension(130,30));
      txtdt.setText(lo.getData_de_Nascimento());
   
        
         
         
         
        
         
         
         
      jPanelNovaSugestao.add(lbcurso);
      lbcurso.setPreferredSize(new Dimension(250,30));
         
      jPanelNovaSugestao.add(lbperiodo);
      lbperiodo.setPreferredSize(new Dimension(280,30));
   
         
         
         
      jPanelNovaSugestao.add(txtcurso);
      txtcurso.setPreferredSize(new Dimension(260,30));
      txtcurso.setText(lo.getCategoria());
      txtcurso.setEditable(false);
         
   
   
   
   
          
          
   
          
          
          
         
                  
         
      jPanelNovaSugestao.add(txtcargo);
      txtcargo.setPreferredSize(new Dimension(260,30));
      txtcargo.setText(lo.getCargo());
      txtcargo.setEditable(false);
   
      jPanelNovaSugestao.add(email);
      email.setPreferredSize(new Dimension(530,30));
         
       
      jPanelNovaSugestao.add(txtemail);
      txtemail.setPreferredSize(new Dimension(530,30));
      txtemail.setText(lo.getEmail());
         
         
      jPanelNovaSugestao.add(lbtelr);
      lbtelr.setPreferredSize(new Dimension(140,30));
    
    
      jPanelNovaSugestao.add(lbtelc);
      lbtelc.setPreferredSize(new Dimension(390,30));
   
    
    
    
    //mascara telefone res
      try{ 
         javax.swing.text.MaskFormatter telr= new javax.swing.text.MaskFormatter("(##) ####-####");
         txttelefoner = new javax.swing.JFormattedTextField(telr);
      }
      catch (Exception e){
      }
   			
      jPanelNovaSugestao.add(txttelefoner);
      txttelefoner.setPreferredSize(new Dimension(130,30));
      txttelefoner.setText(lo.getTelefone_Residencial());
   
          
          
          
   			
   			//mascara telefone cel
      try{ 
         javax.swing.text.MaskFormatter telc= new javax.swing.text.MaskFormatter("(##) #####-####");
         txttelefonec = new javax.swing.JFormattedTextField(telc);
      }
      catch (Exception e){
      }
   	
   
      jPanelNovaSugestao.add(txttelefonec);
      txttelefonec.setPreferredSize(new Dimension(130,30));
      txttelefonec.setText(lo.getTelefone_Celular());
   
   
      jPanelNovaSugestao.add(esp3);
      esp3.setPreferredSize(new Dimension(245,30));
   
   
   
         
         
      jPanelNovaSugestao.add(lbusuario);
      lbusuario.setPreferredSize(new Dimension(140,30));
          
      jPanelNovaSugestao.add(lbsenha);
      lbsenha.setPreferredSize(new Dimension(390,30));
   
          
    
      jPanelNovaSugestao.add(txtusuario);
      txtusuario.setPreferredSize(new Dimension(260,30));
      txtusuario.setText(lo.getUsuario());
   
         
   
   
   
   
        
      jPanelNovaSugestao.add(txtsenha);
      txtsenha.setPreferredSize(new Dimension(260,30));
      txtsenha.setText(lo.getSenha());
    
    
   
      jPanelNovaSugestao.add(bntlimpar);
      bntlimpar.setPreferredSize(new Dimension(135,30));
   
         
      jPanelNovaSugestao.add(bntenviar);
      bntenviar.setPreferredSize(new Dimension(135,30));
   
   	//botoes
      bntmeuperfil.addActionListener(this);
      bnthistorico.addActionListener(this);
      bntnovasugestao.addActionListener(this);
      bntretornar.addActionListener(this);
      bntsair.addActionListener(this);
      bntlimpar.addActionListener(this);
      bntenviar.addActionListener(this);
   	
   	
      bntmeuperfil.setPreferredSize(new Dimension(140,100));//tamanho do bota0
      bnthistorico.setPreferredSize(new Dimension(140,100));//tamanho do bota0
      bntnovasugestao.setPreferredSize(new Dimension(140,100));//tamanho do bota0
      bntsair.setPreferredSize(new Dimension(140,60));//tamanho do bota0
      bntretornar.setPreferredSize(new Dimension(140,80));//tamanho do bota0
         
         
            
      
      
      
      
      
      
      
      
      //Padroes da tela
      setSize(840,620);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null); // deixa a posição da janela no meio
      setResizable(false);//Não deixa maximizar
      setVisible(true);
   }
	
   public void actionPerformed(ActionEvent e) {
	   CadastroDAO checar = new CadastroDAO();
   	
      if (e.getSource() == bntmeuperfil) {
         JOptionPane.showMessageDialog(null, "Você já está nesta página!"); 
      }
   	
      if (e.getSource() == bnthistorico) {
      	
      	
         if(lo.getCategoria().equals("Apoio")){
            this.dispose();
            new telas.avaliador.TelaSugestoesPostadasApoio().setVisible(true);  
         }
         else{
            if(lo.getCategoria().equals("Cursos")){
               this.dispose();
               new telas.avaliador.TelaSugestoesPostadasCursos().setVisible(true); 
            	
            }
            else{
               if(lo.getCategoria().equals("Eventos")){
                  this.dispose();
                  new telas.avaliador.TelaSugestoesPostadasEventos().setVisible(true); 
               	
               }
               else{
                  if(lo.getCategoria().equals("Infraestrutura")){
                     this.dispose();
                     new telas.avaliador.TelaSugestoesPostadasInfraestrutura().setVisible(true); 
                  	
                  }
                  else{
                     if(lo.getCategoria().equals("Segurança")){
                        this.dispose();
                        new telas.avaliador.TelaSugestoesPostadasSeguranca().setVisible(true); 
                     }
                     else{
                        if(lo.getCategoria().equals("Sugestões Livres")){
                           this.dispose();
                           new telas.avaliador.TelaSugestoesPostadasSugestoesLivres().setVisible(true); 
                        }
                        else{
                           JOptionPane.showMessageDialog(null, "Você ainda não foi registrado em nenhuma categoria, aguarde até um Superior verificar o seu caso!"); 
                        }
                     }
                  }
               }
            }
         }
      }
   	
      if (e.getSource() == bntnovasugestao) {
      		
      		
         if(lo.getCategoria().equals("Apoio")){
             this.dispose();
             new telas.avaliador.TelaRelatorio().setVisible(true);  
          }
         else{
            if(lo.getCategoria().equals("Cursos")){
                this.dispose();
                new telas.avaliador.TelaRelatorio().setVisible(true);  
             }
            else{
               if(lo.getCategoria().equals("Eventos")){
                   this.dispose();
                   new telas.avaliador.TelaRelatorio().setVisible(true);  
                }
               else{
                  if(lo.getCategoria().equals("Infraestrutura")){
                      this.dispose();
                      new telas.avaliador.TelaRelatorio().setVisible(true);  
                   }
                  else{
                     if(lo.getCategoria().equals("Segurança")){
                         this.dispose();
                         new telas.avaliador.TelaRelatorio().setVisible(true);  
                      }
                     else{
                        if(lo.getCategoria().equals("Sugestões Livres")){
                           this.dispose();
                           new telas.avaliador.TelaRelatorio().setVisible(true);  
                        }
                        else{
                           JOptionPane.showMessageDialog(null, "Você ainda não foi registrado em nenhuma categoria, aguarde até um Superior verificar o seu caso!"); 
                        }
                     }
                  }
               }
            }
         }
      }
   	
      if (e.getSource() == bntretornar) {
      
         this.dispose();
         new telas.avaliador.TelaPrincipal().setVisible(true);  
      }
   	
      if (e.getSource() == bntsair) {
         this.dispose();
         new telas.TelaLogin().setVisible(true);  
      }
      if (e.getSource() == bntlimpar) {
         this.dispose();
         new telas.colaborador.TelaPrincipal().setVisible(true);  
      }
      if (e.getSource() == bntenviar){
    	  
          int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente alterar suas informações?", null, JOptionPane.YES_NO_OPTION);
       
          if (resposta == JOptionPane.YES_OPTION) {
           	 // Nome Completo
              if(txttitulo.getText().equals("")){
                 ErroMSG = "Você não digitou o seu Nome!";
              }
              else{
                 checknome = true;
              }
              //Data de Nascimento
              if(txtdt.getText().equals("  /  /    ")){
                 ErroMSG = "Você não digitou a sua Data de Nascimento!";
              }
              else{
             	 checkdata = true;
              }
              //Telefone Residencial
              if(txttelefoner.getText().equals("(  )     -    ")){
                 checktelr = false;
              }
              else{
                 checktelr = true;
              }						
           			
           //Telefone Celular
              if(txttelefonec.getText().equals("(  )      -    ")){
                 checktelc = false;
              }
              else{
                 checktelc = true;
              }	
            //Telefones
              if(checktelr == false && checktelc == false){
                 checktelefones = false;
                 ErroMSG = "Você precisa deixar pelo menos um telefone para contato!";
              }
              else{
                 checktelefones = true;
              }       
              // Email 
              if(txtemail.getText().equals("")){
                 ErroMSG = "Você não digitou um Email!";					
              }else{
             	if(txtemail.getText().equals(txtemail.getText())) {
             		checkemail = true;
             	}else{
                 if(checar.CheckEmail(txtemail.getText())){
                    checkemail = false;
                    ErroMSG = "O E-mail digitado já está cadastrado em outra conta, utilize um diferente!";	
                 }
                 else{
                    checkemail = true;
                 }
               }	
             }
              // Usuario 
              if(txtusuario.getText().equals("")){
                 ErroMSG = "Você não digitou um Usuário!";					
              }else{
             	 if(txtusuario.getText().equals(txtusuario.getText())) {
             		 checkusuario = true;
              	}else{
                 if(checar.CheckUsuario(txtusuario.getText())){
                    checkusuario = false;
                    ErroMSG = "O Usuário digitado já está cadastrado, utilize um diferente!";	
                 } else{
                    checkusuario = true;
                 }
              }
              }
              //Senha
              if(txtsenha.getText().length() < 6){
             	 checksenha = false;
             	 ErroMSG = "A sua senha precisa ter no mínimo 6 caracteres!";
               }
               else{
                     checksenha = true;
               }
              
         	if(checknome == true && checkdata == true && checktelefones == true && checkemail == true && checkusuario == true && checksenha == true){
      
          	 LoginDAO dao = new LoginDAO();
             
             lo.setNome_Completo(txttitulo.getText());
             lo.setData_de_Nascimento(txtdt.getText());
             lo.setTelefone_Residencial(txttelefoner.getText());
             lo.setTelefone_Celular(txttelefonec.getText());
             lo.setEmail(txtemail.getText());
             lo.setUsuario(txtusuario.getText());
             lo.setSenha(txtsenha.getText());
          
          	
             dao.AlterarInformacoesAvaliador(lo.getID());
          	
          	
          	
             JOptionPane.showMessageDialog(null, "Informações alteradas com sucesso!"); 
         	}else{
         		 JOptionPane.showMessageDialog(null,"Desculpe, a atualização do seu cadastro não foi realizado com sucesso!" + "\nMotivo: " + ErroMSG);
         	}
         }
         	else if (resposta == JOptionPane.NO_OPTION) {
          
          }
       }
   }

}



