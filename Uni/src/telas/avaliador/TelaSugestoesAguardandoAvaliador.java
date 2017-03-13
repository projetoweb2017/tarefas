package telas.avaliador;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicBorders;

import banco.de.dados.DAO.LoginDAO;
import banco.de.dados.DAO.SugestaoDAO;
import banco.de.dados.DAO.SugestaoJTableDAO;
import banco.de.dados.Model.Login;
import banco.de.dados.Model.Sugestao;
import banco.de.dados.Model.SugestoesJTable;

import java.awt.*;
import java.awt.event.*;


//Sugestão para o Historico do Avaliador Status aguardando - 1
public class TelaSugestoesAguardandoAvaliador extends JFrame implements ActionListener {


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










	
		
   private JLabel lblsugestaot,lbltitulo,lblautor,lbldata,espaco,espacoo;
	
   private JLabel lbltitulousuario,lbldatausuario,lblautorusuario;
	
   private JTextArea txasugestao;
	
   private JScrollPane scroll;
		
	//private JButton bntmeuperfil, bnthistorico, bntnovasugestao,bntsair,bntretornar; //menu
	
   private JButton bntaprovar,bntreprovar;

   private JPanel jPanelMenu,jPanelSugestao;
	
	
   public TelaSugestoesAguardandoAvaliador(){
      super("Uni - Sugestão Aguardando");
         
      SugestoesJTable sugestao = SugestoesJTable.getInstance();
   	
   	//Menu
      espaco  = new JLabel("");
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
   	
      scroll = new JScrollPane();
   	
      bntaprovar = new JButton("Aprovar");
      bntreprovar = new JButton("Reprovar");
   	
      jPanelMenu = new JPanel();
      jPanelSugestao = new JPanel();
   
   					
     
      //labels
      
      lblsugestaot = new JLabel("             Sugestão Aguardando...");   
                    
      lbltitulo = new JLabel(" Título: ");
        
      lbldata = new JLabel("Data de postagem:");
        		
      lblautor = new JLabel("Autor: ");
        
      lbltitulousuario = new JLabel(sugestao.getTitulo());
   
      lbldatausuario = new JLabel(sugestao.getData());
        
      lblautorusuario = new JLabel(sugestao.getAutor());
   
      espacoo  = new JLabel("");
   
      //txt    
      txasugestao = new JTextArea(6, 8);
      txasugestao.add(new JScrollPane(new JTextArea(6, 8)));
      txasugestao.setBorder(BorderFactory.createEtchedBorder());
      scroll.setViewportView(txasugestao);
      txasugestao.setText(sugestao.getTexto());
   
   
      Container caixa = getContentPane();
   	
      caixa.setLayout(new BorderLayout());
      caixa.add(jPanelMenu, BorderLayout.WEST);
      caixa.add(jPanelSugestao, BorderLayout.CENTER);
   	
   	
   
   	
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
   	
   	
      bntmeuperfil.addActionListener(this);
      bnthistorico.addActionListener(this);
      bntnovasugestao.addActionListener(this);
      bntretornar.addActionListener(this);
      bntsair.addActionListener(this);
      bntaprovar.addActionListener(this);
      bntreprovar.addActionListener(this);
   		
   	
      bntmeuperfil.setPreferredSize(new Dimension(140,100));//tamanho do bota0
      bnthistorico.setPreferredSize(new Dimension(140,100));//tamanho do bota0
      bntnovasugestao.setPreferredSize(new Dimension(140,100));//tamanho do bota0
      bntsair.setPreferredSize(new Dimension(140,60));//tamanho do bota0
      bntretornar.setPreferredSize(new Dimension(140,80));//tamanho do bota0
   	        
   	        
   	
        
                
   	
   	
   	        
        
        
        
                
        
        
           //painel Sugestao
           
      jPanelSugestao.setBackground(new Color(255,255,255));  
      jPanelSugestao.setLayout(new FlowLayout());
        
   
      jPanelSugestao.add(lblsugestaot); 
      lblsugestaot.setFont(new Font("Arial", 1, 34)); 
      lblsugestaot.setForeground(new Color(0, 102, 204));
      lblsugestaot.setPreferredSize(new Dimension(600,100));
            
      jPanelSugestao.add(lbltitulo);
      lbltitulo.setFont(new Font("Arial", 0, 18)); 
      lbltitulo.setForeground(new Color(0, 0, 0));
           
           //lbl com o titulo da sugestão
           
      jPanelSugestao.add(lbltitulousuario); 
      lbltitulousuario.setFont(new Font("Arial", 0, 18)); 
      lbltitulousuario.setForeground(new Color(0, 102, 204));
      lbltitulousuario.setPreferredSize(new Dimension(550,30));
   	   
      jPanelSugestao.add(txasugestao);
      txasugestao.setPreferredSize(new Dimension(610,250));
      txasugestao.setEditable(false);
   
      jPanelSugestao.add(lblautor);
      lblautor.setFont(new Font("Arial", 0, 18)); 
      lblautor.setForeground(new Color(0, 0, 0));
           
           //lbl com o nome do Autor
      jPanelSugestao.add(lblautorusuario);
      lblautorusuario.setFont(new Font("Arial", 0, 18)); 
      lblautorusuario.setForeground(new Color(0, 102, 204));
      lblautorusuario.setPreferredSize(new Dimension(545,20));
           
      jPanelSugestao.add(lbldata); 
      lbldata.setFont(new Font("Arial", 0, 18)); 
      lbldata.setForeground(new Color(0, 0, 0));
           
            //lbl a data da postagem
           
      jPanelSugestao.add(lbldatausuario); 
      lbldatausuario.setFont(new Font("Arial", 0, 18)); 
      lbldatausuario.setForeground(new Color(0, 102, 204));
      lbldatausuario.setPreferredSize(new Dimension(445,20));
           
      jPanelSugestao.add(espacoo); 
      espacoo.setPreferredSize(new Dimension(600,50));
                     
           
      jPanelSugestao.add(bntreprovar);
      bntreprovar.setPreferredSize(new Dimension(130,30));
   
      jPanelSugestao.add(bntaprovar);
      bntaprovar.setPreferredSize(new Dimension(130,30));
           
           
           
              
        
        
        
        
        
        
        
        //Padroes da tela
      setSize(840,620);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null); // deixa a posição da janela no meio
      setResizable(false);//Não deixa maximizar
      setVisible(true);
   }
	
   public void actionPerformed(ActionEvent e) {
   	
      Login lo = Login.getInstance();
      SugestoesJTable sugestao = SugestoesJTable.getInstance();
   	
   	
      if (e.getSource() == bntmeuperfil) {
         this.dispose();
         new telas.avaliador.TelaMeuPerfil().setVisible(true);  
      }
   	
      if (e.getSource() == bnthistorico) {
      	
      	
         if(lo.getCategoria() == "Apoio"){
            this.dispose();
            new telas.avaliador.TelaSugestoesPostadasApoio().setVisible(true);  
         }
         else{
            if(lo.getCategoria() == "Cursos"){
               this.dispose();
               new telas.avaliador.TelaSugestoesPostadasCursos().setVisible(true); 
            	
            }
            else{
               if(lo.getCategoria() == "Eventos"){
                  this.dispose();
                  new telas.avaliador.TelaSugestoesPostadasEventos().setVisible(true); 
               	
               }
               else{
                  if(lo.getCategoria() == "Infraestrutura"){
                     this.dispose();
                     new telas.avaliador.TelaSugestoesPostadasInfraestrutura().setVisible(true); 
                  	
                  }
                  else{
                     if(lo.getCategoria() == "Segurança"){
                        this.dispose();
                        new telas.avaliador.TelaSugestoesPostadasSeguranca().setVisible(true); 
                     }
                     else{
                        if(lo.getCategoria() == "Sugestões Livres"){
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
   	
      if (e.getSource() == bntaprovar) {
         int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente Aprovar essa sugestão?", null, JOptionPane.YES_NO_OPTION);
      
         if (resposta == JOptionPane.YES_OPTION) {
            SugestaoDAO dao = SugestaoDAO.getInstance();
         	
         					
            dao.AprovarSugestao(sugestao.getId());
         	
            this.dispose();
            new telas.avaliador.TelaPrincipal().setVisible(true); 
            JOptionPane.showMessageDialog(null, "Sugestão Aprovada com sucesso!"); 
         } 
         else if (resposta == JOptionPane.NO_OPTION) {
         	
         }
      
      }
      if (e.getSource() == bntreprovar) {
         int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente Reprovar essa sugestão?", null, JOptionPane.YES_NO_OPTION);
      
         if (resposta == JOptionPane.YES_OPTION) {
            SugestaoDAO dao = SugestaoDAO.getInstance();
         	
         	
            dao.ReprovarSugestao(sugestao.getId());
         	
            this.dispose();
            new telas.avaliador.TelaPrincipal().setVisible(true); 
            JOptionPane.showMessageDialog(null, "Sugestão Reprovada com sucesso!"); 
         } 
         else if (resposta == JOptionPane.NO_OPTION) {
         
         }
      
      }
   			
   }
}
