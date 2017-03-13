package telas.avaliador;

import javax.swing.*;

import banco.de.dados.DAO.LoginDAO;
import banco.de.dados.DAO.RelatorioDAO;
import banco.de.dados.Model.Login;
import banco.de.dados.Model.Relatorio;

import java.awt.*;
import java.awt.event.*;

public class TelaRelatorio extends JFrame implements ActionListener {
	
   Relatorio relatorio = Relatorio.getInstance();
   RelatorioDAO rel = new RelatorioDAO();
   
   
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


	
   private JLabel lbhistorico,lbbranco,lbtitulo,lbautor,lbpostado,lbdevolutivas,total,aprovadas,reprovadas,devolutivas,lbcategoria;
	

   private JLabel espaco;
	

   private JPanel jPanelMenu,jPanelHistorico,jPanelsugestao;
	
   private String categoria;
	
	
   public TelaRelatorio(){
      super("Uni - Relátorios da categoria");
   	
      this.categoria = lo.getCategoria();
   	
   	
      rel.TotalPostadas(categoria);
      rel.Aguardando(categoria);
      rel.Aprovadas(categoria);
      rel.Reprovada(categoria);
     
   
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
   
   
   	
   	//Historico
      lbhistorico = new JLabel("           Relátorios");
      lbcategoria = new JLabel(" ("+ categoria +")");
      lbbranco = new JLabel("ooooooooooooooooo");
   		
         
         
      lbtitulo = new JLabel("Total de sugestões postadas: ");
      total = new JLabel(relatorio.getTotal());
      
      
      
      lbautor = new JLabel("Total de sugestões aprovadas: ");
      aprovadas = new JLabel(relatorio.getAprovadas());
      
      
      
      lbpostado = new JLabel("Total de sugestões reprovadas: ");
      reprovadas = new JLabel(relatorio.getReprovadas());
      
      
      
      lbdevolutivas = new JLabel("Total de sugestões sem devolutivas: ");
      devolutivas = new JLabel(relatorio.getAguardando());   
         
         
         
         	
      jPanelMenu = new JPanel();
      jPanelHistorico = new JPanel();
      
      jPanelsugestao = new JPanel();
   
   	
   
   
   
   
   
   
   
   
   
   	//Container
   	
      Container caixa = getContentPane();
   
      caixa.setLayout(new BorderLayout());
      caixa.add(jPanelMenu,BorderLayout.WEST);
      caixa.add(jPanelHistorico,BorderLayout.CENTER);
      caixa.add(jPanelsugestao,BorderLayout.EAST);
   	
   	
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
   		
   	
      bntmeuperfil.setPreferredSize(new Dimension(140,100));//tamanho do bota0
      bnthistorico.setPreferredSize(new Dimension(140,100));//tamanho do bota0
      bntnovasugestao.setPreferredSize(new Dimension(140,100));//tamanho do bota0
      bntsair.setPreferredSize(new Dimension(140,60));//tamanho do bota0
      bntretornar.setPreferredSize(new Dimension(140,80));//tamanho do bota0
   	        
   	        
   	
        
        //Painel de Sugestoes       
      jPanelHistorico.setBackground(new java.awt.Color(255,255,255));
   
      jPanelHistorico.add(lbhistorico,BorderLayout.CENTER);
      lbhistorico.setFont(new Font("Arial", 1, 34)); 
      lbhistorico.setForeground(new Color(0, 102, 204));
        
      jPanelHistorico.add(lbcategoria);
      lbcategoria.setFont(new Font("Arial", 0, 28)); 
      lbcategoria.setForeground(new Color(0,102,204));
      lbcategoria.setPreferredSize(new Dimension(300,35));
   
      jPanelHistorico.add(lbbranco);
      lbbranco.setFont(new Font("Arial", 0, 28)); 
      lbbranco.setForeground(new Color(255,255,255));
      lbbranco.setPreferredSize(new Dimension(600,30));
        
        
        
        
        
        
        
      jPanelHistorico.add(jPanelsugestao);
      jPanelsugestao.setLayout(new FlowLayout());
      jPanelsugestao.setPreferredSize(new Dimension(600,280));
      jPanelsugestao.setForeground(new Color(255,255,255));
   
        
        
      jPanelsugestao.add(lbtitulo);
      lbtitulo.setFont(new Font("Arial", 1, 16)); 
      lbtitulo.setForeground(new Color(0,0,0));
      lbtitulo.setPreferredSize(new Dimension(250,60));
        
        
        
        
      jPanelsugestao.add(total);
      total.setFont(new Font("Arial", 1, 16)); 
      total.setForeground(new Color(105,105,105));
      total.setPreferredSize(new Dimension(310,60));
   
        
        
        
   
        
        
      jPanelsugestao.add(lbautor);
      lbautor.setFont(new Font("Arial", 1, 16)); 
      lbautor.setForeground(new Color(0,0,0));
      lbautor.setPreferredSize(new Dimension(260,60));
   
      jPanelsugestao.add(aprovadas);
      aprovadas.setFont(new Font("Arial", 1, 16)); 
      aprovadas.setForeground(new Color(105,105,105));
      aprovadas.setPreferredSize(new Dimension(305,60));
   
   
   
        
      jPanelsugestao.add(lbpostado);
      lbpostado.setFont(new Font("Arial", 1, 16)); 
      lbpostado.setForeground(new Color(0,0,0));
      lbpostado.setPreferredSize(new Dimension(270,60));
        
        
      jPanelsugestao.add(reprovadas);
      reprovadas.setFont(new Font("Arial", 1, 16)); 
      reprovadas.setForeground(new Color(105,105,105));
      reprovadas.setPreferredSize(new Dimension(300,60));
   
        
       
   
      jPanelsugestao.add(lbdevolutivas);
      lbdevolutivas.setFont(new Font("Arial", 1, 16)); 
      lbdevolutivas.setForeground(new Color(0,0,0));
      lbdevolutivas.setPreferredSize(new Dimension(300,60));
   
   
      jPanelsugestao.add(devolutivas);
      devolutivas.setFont(new Font("Arial", 1, 16)); 
      devolutivas.setForeground(new Color(105,105,105));
      devolutivas.setPreferredSize(new Dimension(270,60));
   
   
        
        
   
        
       
        
        
        
        
        
   	//Padroes da tela
      setSize(840,620);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null); // deixa a posição da janela no meio
      setResizable(false);//Não deixa maximizar
      setVisible(true);
   
   	
   }
 
   public void actionPerformed(ActionEvent e) {
   	
   	
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
         JOptionPane.showMessageDialog(null,"Você já está nesta página!");
      }
   	
      if (e.getSource() == bntretornar) {
         this.dispose();
         new telas.avaliador.TelaPrincipal().setVisible(true);  
      }
      
         if (e.getSource() == bntsair) {
            this.dispose();
            new telas.TelaLogin().setVisible(true);  
         }
   } 
}



