package telas.avaliador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import banco.de.dados.DAO.LoginDAO;
import banco.de.dados.Model.Login;



public class TelaPrincipal extends JFrame implements ActionListener {

//imagens nos botoes



   ImageIcon infra = new ImageIcon(getClass().getResource("img/bntinfra.png"));
	
   JButton bntinfraestrutura = new JButton(infra);	


   ImageIcon curso = new ImageIcon(getClass().getResource("img/bntcurso.png"));
	
   JButton bntcursos = new JButton(curso);	

   ImageIcon eventos = new ImageIcon(getClass().getResource("img/bntevent.png"));
	
   JButton bnteventos = new JButton(eventos);	


   ImageIcon apoio = new ImageIcon(getClass().getResource("img/bntapoio.png"));
	
   JButton bntapoio = new JButton(apoio);	


   ImageIcon segurança = new ImageIcon(getClass().getResource("img/bntseg.png"));
	
   JButton bntseguranca = new JButton(segurança);	


   ImageIcon sl = new ImageIcon(getClass().getResource("img/bntsl.png"));
	
   JButton bntsugestoeslivres = new JButton(sl);	


//imagen menu
   ImageIcon mp = new ImageIcon(getClass().getResource("img/bntmp.png"));
	
   JButton bntmeuperfil = new JButton(mp);	

   ImageIcon historico = new ImageIcon(getClass().getResource("img/bntns.png"));
	
   JButton bnthistorico = new JButton(historico);	



   ImageIcon novasuges = new ImageIcon(getClass().getResource("img/bnthist.png"));
	
   JButton bntnovasugestao = new JButton(novasuges);	



   ImageIcon sair = new ImageIcon(getClass().getResource("img/bntsair.png"));
	
   JButton bntsair = new JButton(sair);	


// Top sugestão
ImageIcon top = new ImageIcon(getClass().getResource("img/troufeu.png"));
	
JButton bntTop = new JButton(top);
		
private JLabel lbbrancotop, lbbrancotopp, lbtop, lbtopp;        
      

		
   private JLabel lbcategorias, espaco;

   private JPanel jPanelMenu,jPanelTop,jPanelCategorias;
	
   public TelaPrincipal(){
      super("Uni - Tela Principal");
   	
   	//Menu
      espaco  = new JLabel("");
   	
   	
   	
   	//Categorias
      lbcategorias = new JLabel("Categorias de Sugestões");
      
      
      
      
      
      //fundo dos botoes
      bntinfraestrutura.setContentAreaFilled(false);//tira o fundo
      bntcursos.setContentAreaFilled(false);
      bntinfraestrutura.setBorder(null);//tira as bordas
      bntcursos.setBorder(null);
      
      bnteventos.setContentAreaFilled(false);//tira o fundo
      bntapoio.setContentAreaFilled(false);
      bnteventos.setBorder(null);//tira as bordas
      bntapoio.setBorder(null);
      
      bntseguranca.setContentAreaFilled(false);//tira o fundo
      bntsugestoeslivres.setContentAreaFilled(false);
      bntseguranca.setBorder(null);//tira as bordas
      bntsugestoeslivres.setBorder(null);
   
      bntmeuperfil.setContentAreaFilled(false);//tira o fundo
      bnthistorico.setContentAreaFilled(false);
      bntmeuperfil.setBorder(null);//tira as bordas
      bnthistorico.setBorder(null);
      
      bntnovasugestao.setContentAreaFilled(false);
      bntnovasugestao.setBorder(null);//tira as bordas
      
      bntsair.setContentAreaFilled(false);
      bntsair.setBorder(null);//tira as bordas
      
		// top sugestão

      bntTop.setContentAreaFilled(false);
		bntTop.setBorder(null);//tira as bordas
   
   
      
      //maozinha
      bntinfraestrutura.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
      bntcursos.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
      bnteventos.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
      
      bntapoio.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
      bntseguranca.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
      bntsugestoeslivres.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
   
   
   
      bntmeuperfil.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
      bnthistorico.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
      bntnovasugestao.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
      bntsair.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
      // top sugestão
   		bntTop.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
   
   	
		//Top sugestões
		lbtop = new JLabel("         Top");		
		lbtopp = new JLabel("    Sugestões");
		lbbrancotop = new JLabel("");
		lbbrancotopp = new JLabel("");
   	
   	
   	
   	
      jPanelMenu = new JPanel();
      jPanelTop = new JPanel();
      jPanelCategorias = new JPanel();
   			
   
   	
      Container caixa = getContentPane();
   	
      caixa.setLayout(new BorderLayout());//leyout nulo para poder posicionar os components
      caixa.add(jPanelMenu, BorderLayout.WEST);
      caixa.add(jPanelTop, BorderLayout.EAST);
      caixa.add(jPanelCategorias, BorderLayout.CENTER);
   	
   	
   	
   	
   	//Painel do Menu
      jPanelMenu.setBackground(new java.awt.Color(0,102,204));
      
     
     
      jPanelMenu.setPreferredSize(new Dimension(170,200));//tamanha do painel
        
      jPanelMenu.setLayout(new FlowLayout());
        
      jPanelMenu.add(bntmeuperfil);
      
        
      jPanelMenu.add(bnthistorico);
      jPanelMenu.add(bntnovasugestao);        
        
        
      jPanelMenu.add(espaco,BorderLayout.CENTER);
      espaco.setFont(new Font("Arial", 1, 270)); 
      espaco.setForeground(new Color(102,153,255));
      espaco.setPreferredSize(new Dimension(170,150));
        
      jPanelMenu.add(bntsair);
                
        
        
        
        
      //Painel do TOP sugestoes
      jPanelTop.setBackground(new java.awt.Color(0, 102, 204));
      jPanelTop.setPreferredSize(new Dimension(170,200));//tamanha do painel
      jPanelTop.setLayout(new FlowLayout());
      
      jPanelTop.add(lbbrancotop);
      lbbrancotop.setFont(new Font("Arial", 1, 24)); 
      lbbrancotop.setForeground(new Color(0, 102, 204));
      lbbrancotop.setPreferredSize(new Dimension(170,60));
      
      jPanelTop.add(lbtop);
      lbtop.setFont(new Font("Arial", 1, 24)); 
      lbtop.setForeground(new Color(255, 255, 255));
      lbtop.setPreferredSize(new Dimension(170,30));
      
      jPanelTop.add(lbtopp);
      lbtopp.setFont(new Font("Arial", 1, 24)); 
      lbtopp.setForeground(new Color(255, 255, 255));
      lbtopp.setPreferredSize(new Dimension(170,30));
      
      jPanelTop.add(lbbrancotopp);
      lbbrancotopp.setFont(new Font("Arial", 1, 24)); 
      lbbrancotopp.setForeground(new Color(0, 102, 204));
      lbbrancotopp.setPreferredSize(new Dimension(170,20));
      
      jPanelTop.add(bntTop);
        
   
        //Painel Categorias       
                      
                      
      jPanelCategorias.setPreferredSize(new Dimension(471,840));//tamanha do painel
      jPanelCategorias.setBackground(new java.awt.Color(255,255,255));
        
      jPanelCategorias.setLayout(new FlowLayout());
        
        
      jPanelCategorias.add(lbcategorias);
      lbcategorias.setFont(new Font("Arial", 1, 34)); 
      lbcategorias.setForeground(new Color(0, 102, 204));
        
        
       
      jPanelCategorias.add(bntinfraestrutura);
        
      jPanelCategorias.add(bntcursos);
        
      jPanelCategorias.add(bnteventos);
        
      jPanelCategorias.add(bntapoio);
        
      jPanelCategorias.add(bntseguranca);
        
      jPanelCategorias.add(bntsugestoeslivres);
        
        
   
        
        
   	
   	
   	//botoes
      bntmeuperfil.addActionListener(this);
      bnthistorico.addActionListener(this);
      bntnovasugestao.addActionListener(this);
      bntsair.addActionListener(this);
      bntinfraestrutura.addActionListener(this);
      bntcursos.addActionListener(this);
      bnteventos.addActionListener(this);
      bntapoio.addActionListener(this);
      bntseguranca.addActionListener(this);
      bntsugestoeslivres.addActionListener(this);
      bntTop.addActionListener(this);
      
      // Menu
      bntmeuperfil.setPreferredSize(new Dimension(140,100));//tamanho do bota0
      bnthistorico.setPreferredSize(new Dimension(140,100));//tamanho do bota0
      bntnovasugestao.setPreferredSize(new Dimension(140,100));//tamanho do bota0
      bntsair.setPreferredSize(new Dimension(140,60));//tamanho do bota0
   
        
        
      // Categorias  
      bntinfraestrutura.setPreferredSize(new Dimension(180, 150));
      bntcursos.setPreferredSize(new Dimension(180, 150));
      bnteventos.setPreferredSize(new Dimension(180, 150));
      bntapoio.setPreferredSize(new Dimension(180, 150));
      bntseguranca.setPreferredSize(new Dimension(180, 150));
      bntsugestoeslivres.setPreferredSize(new Dimension(180, 150));//tamanho do bota0
   
   
        
        
        
        
        
        
        
        
      //Padroes da tela
      setSize(840,620);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null); // deixa a posição da janela no meio
      setResizable(false);//Não deixa maximizar
      setVisible(true);
   }
	
   public void actionPerformed(ActionEvent e) {
      Login lo = Login.getInstance();
   	
      if (e.getSource() == bntmeuperfil) {
         this.dispose();
         new telas.avaliador.TelaMeuPerfil().setVisible(true);  
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
   	
      if (e.getSource() == bntsair) {
      
         this.dispose();
         new telas.TelaLogin().setVisible(true);  
      }
   	
      if (e.getSource() == bntinfraestrutura) {
         this.dispose();
         new telas.avaliador.TelaInfraestrutura().setVisible(true);  
      }
   	
      if (e.getSource() == bnteventos) {
         this.dispose();
         new telas.avaliador.TelaEventos().setVisible(true);  
      }
   	
      if (e.getSource() == bntcursos) {
         this.dispose();
         new telas.avaliador.TelaCursos().setVisible(true);  
      }
   	
      if (e.getSource() == bntapoio) {
         this.dispose();
         new telas.avaliador.TelaApoio().setVisible(true);  
      }
   	
      if (e.getSource() == bntseguranca) {
         this.dispose();
         new telas.avaliador.TelaSeguranca().setVisible(true);  
      }
   	
      if (e.getSource() == bntsugestoeslivres) {
         this.dispose();
         new telas.avaliador.TelaSugestoesLivres().setVisible(true);  
      }
      if (e.getSource() == bntTop) {
          this.dispose();
          new telas.avaliador.TelaTop().setVisible(true);  
       }
      
   	
   }   
}
