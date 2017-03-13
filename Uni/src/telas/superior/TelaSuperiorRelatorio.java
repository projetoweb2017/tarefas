package telas.superior;

import javax.swing.*;

import banco.de.dados.DAO.RelatorioDAO;
import banco.de.dados.Model.Relatorio;

//import banco.de.dados.DAO.LoginDAO;

import java.awt.*;
import java.awt.event.*;


public class TelaSuperiorRelatorio extends JFrame implements ActionListener {
	
	


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








	
	private JLabel lbhistorico,lbbranco;
	
	//Todos
	private JLabel lbtotal,total,lbaprovadas,lbreprovadas,aprovadas,reprovadas;
	
	//Infraestrutura
		private JLabel lbtotali,totali,lbaprovadasi,lbreprovadasi,aprovadasi,reprovadasi;
		
		//Eventos
		private JLabel lbtotale,totale,lbaprovadase,lbreprovadase,aprovadase,reprovadase;
		
		//Cursos
		private JLabel lbtotalc,totalc,lbaprovadasc,lbreprovadasc,aprovadasc,reprovadasc;
		
		//Apoio
		private JLabel lbtotala,totala,lbaprovadasa,lbreprovadasa,aprovadasa,reprovadasa;
		
		//Segurança
		private JLabel lbtotals,totals,lbaprovadass,lbreprovadass,aprovadass,reprovadass;
		
		//Sugestões Livres
		private JLabel lbtotalsu,totalsu,lbaprovadassu,lbreprovadassu,aprovadassu,reprovadassu;
	
	//private JButton bntmeuperfil, bnthistorico, bntnovasugestao,bntsair,bntretornar;

	private JLabel espaco;
	
	
	private JPanel jPanelMenu,jPanelHistorico,jPanelsugestao;
	
	private JPanel jPanelInfraestrutura,jPanelCursos,jPanelEventos,jPanelSeguranca,jPanelApoio,jPanelSugestoesLivres;
	
	private JLabel lbTodos,lbInfraestrutura,lbCursos,lbEventos,lbSeguranca,lbApoio,lbSugestoesLivres;
	
	
	   //scroll
	   private  JPanel painelFundo;
	   private JScrollPane barraRolagem;

public TelaSuperiorRelatorio(){
		super("Uni - Relátorios");
		
		   RelatorioDAO rel = new RelatorioDAO();
		   Relatorio relatorio = Relatorio.getInstance();
		  
		   
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
		//Historico
		lbhistorico = new JLabel("Relátorios do sistema");
		
		lbbranco = new JLabel("ooooooooooooooooo");
      
		
		//Todas
		
	      rel.TotalPostadasSuperior();
	      rel.AguardandoSuperior();
	      rel.AprovadasSuperior();
	      rel.ReprovadaSuperior();
		
		lbTodos = new JLabel("                           Todas as Sugestões");
		lbtotal = new JLabel("Total de sugestões postadas: ");
      	total = new JLabel(relatorio.getTotal());
      
      	lbaprovadas = new JLabel(" Total de sugestões aprovadas: ");
      	aprovadas = new JLabel(relatorio.getAprovadas());

        lbreprovadas = new JLabel(" Total de sugestões reprovadas: ");
        reprovadas = new JLabel(relatorio.getReprovadas());

     
      // Infraestrutura
        
        rel.TotalPostadas("Infraestrutura");
        rel.Aguardando("Infraestrutura");
        rel.Aprovadas("Infraestrutura");
        rel.Reprovada("Infraestrutura");
      
      lbInfraestrutura = new JLabel("                                 Infraestrutura");
		lbtotali = new JLabel("Total de sugestões postadas: ");
      	totali = new JLabel(relatorio.getTotal());
      
      	lbaprovadasi = new JLabel("Total de sugestões aprovadas: ");
      	aprovadasi = new JLabel(relatorio.getAprovadas());

        lbreprovadasi = new JLabel("Total de sugestões reprovadas: ");
        reprovadasi = new JLabel(relatorio.getReprovadas());
        
        
        
        
        
      //Cursos
        
        rel.TotalPostadas("Cursos");
        rel.Aguardando("Cursos");
        rel.Aprovadas("Cursos");
        rel.Reprovada("Cursos");
        
      
      lbCursos = new JLabel("                                       Cursos");
		lbtotalc = new JLabel("Total de sugestões postadas: ");
      	totalc = new JLabel(relatorio.getTotal());
      
      	lbaprovadasc = new JLabel("Total de sugestões aprovadas: ");
      	aprovadasc = new JLabel(relatorio.getAprovadas());

        lbreprovadasc = new JLabel("Total de sugestões reprovadas: ");
        reprovadasc = new JLabel(relatorio.getReprovadas());
      
        
        
        
        
      lbEventos = new JLabel("                                       Eventos");
		lbtotale = new JLabel("Total de sugestões postadas: ");
      	totale = new JLabel(relatorio.getTotal());
      
      	lbaprovadase = new JLabel("Total de sugestões aprovadas: ");
      	aprovadase = new JLabel(relatorio.getAprovadas());

        lbreprovadase = new JLabel("Total de sugestões reprovadas: ");
        reprovadase = new JLabel(relatorio.getReprovadas());
      
        
        
        //Apoio
        
        rel.TotalPostadas("Apoio");
        rel.Aguardando("Apoio");
	      rel.Aprovadas("Apoio");
	      rel.Reprovada("Apoio");     
        
        
        
      lbApoio = new JLabel("                                         Apoio");
		lbtotala = new JLabel("Total de sugestões postadas: ");
      	totala = new JLabel(relatorio.getTotal());
      
      	lbaprovadasa = new JLabel("Total de sugestões aprovadas: ");
      	aprovadasa = new JLabel(relatorio.getAprovadas());

        lbreprovadasa = new JLabel("Total de sugestões reprovadas: ");
        reprovadasa = new JLabel(relatorio.getReprovadas());
      
        
        
        //Segurança
        
        rel.TotalPostadas("Segurança");
        rel.Aguardando("Segurança");
        rel.Aprovadas("Segurança");
        rel.Reprovada("Segurança");   
        
        
        
      lbSeguranca = new JLabel("                                    Segurança");
		lbtotals = new JLabel("Total de sugestões postadas: ");
      	totals = new JLabel(relatorio.getTotal());
      
      	lbaprovadass = new JLabel("Total de sugestões aprovadas: ");
      	aprovadass = new JLabel(relatorio.getAprovadas());

        lbreprovadass = new JLabel("Total de sugestões reprovadas: ");
        reprovadass = new JLabel(relatorio.getReprovadas());
      
        
        
        
        //Sugestões Livres
        
        rel.TotalPostadas("Sugestões Livres");
        rel.Aguardando("Sugestões Livres");
        rel.Aprovadas("Sugestões Livres");
        rel.Reprovada("Sugestões Livres"); 
        
        
        
      lbSugestoesLivres = new JLabel("                                Sugestões Livres");
		lbtotalsu = new JLabel("Total de sugestões postadas: ");
      	totalsu = new JLabel(relatorio.getTotal());
      
      	lbaprovadassu = new JLabel("Total de sugestões aprovadas: ");
      	aprovadassu = new JLabel(relatorio.getAprovadas());

        lbreprovadassu = new JLabel("Total de sugestões reprovadas: ");
        reprovadassu = new JLabel(relatorio.getReprovadas());
      
      
      
      
      
      
			
				
		jPanelMenu = new JPanel();
		jPanelHistorico = new JPanel();
		
        jPanelsugestao = new JPanel();
        jPanelInfraestrutura = new JPanel();
        jPanelCursos = new JPanel();
        jPanelApoio = new JPanel();
        jPanelEventos = new JPanel();
        jPanelSugestoesLivres = new JPanel();
        jPanelSeguranca = new JPanel();

      
      
      
      
      
      
     
		
      
      
		//Container
		
		Container caixa = getContentPane();

		caixa.setLayout(new BorderLayout());
		caixa.add(jPanelMenu,BorderLayout.WEST);
		caixa.add(jPanelHistorico,BorderLayout.CENTER);
		caixa.add(jPanelsugestao,BorderLayout.SOUTH);
		caixa.add(jPanelInfraestrutura,BorderLayout.SOUTH);
		caixa.add(jPanelCursos,BorderLayout.SOUTH);
		caixa.add(jPanelEventos,BorderLayout.SOUTH);
		caixa.add(jPanelApoio,BorderLayout.SOUTH);
		caixa.add(jPanelSugestoesLivres,BorderLayout.SOUTH);
		caixa.add(jPanelSeguranca,BorderLayout.SOUTH);
		
		
		
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
              
      
      
      
      
              
		
		
		//botoes
 // 	bntlimpar.addActionListener(this);
 // 	bntenviar.addActionListener(this);
		
		
	    bntmeuperfil.setPreferredSize(new Dimension(140,100));//tamanho do bota0
        bnthistorico.setPreferredSize(new Dimension(140,100));//tamanho do bota0
        bntnovasugestao.setPreferredSize(new Dimension(140,100));//tamanho do bota0
        bntsair.setPreferredSize(new Dimension(140,60));//tamanho do bota0
        bntretornar.setPreferredSize(new Dimension(140,80));//tamanho do bota0      
      
      
      
		        
		        
		
        
        //Painel de Sugestoes       
        jPanelHistorico.setBackground(new java.awt.Color(255,255,255));
        jPanelHistorico.setLayout(new FlowLayout());
        jPanelHistorico.setPreferredSize(new Dimension(600,2300));
        

        jPanelHistorico.add(lbhistorico,BorderLayout.CENTER);
        lbhistorico.setFont(new Font("Arial", 1, 34)); 
        lbhistorico.setForeground(new Color(0, 102, 204));
        
        jPanelHistorico.add(lbbranco,BorderLayout.CENTER);
        lbbranco.setFont(new Font("Arial", 1, 34)); 
        lbbranco.setForeground(new Color(255, 255, 255));
        
        
	
         jPanelHistorico.add(jPanelsugestao,BorderLayout.SOUTH);
        jPanelsugestao.setLayout(new FlowLayout());
        jPanelsugestao.setPreferredSize(new Dimension(600,300));
        jPanelsugestao.setForeground(new Color(105,105,105));
        
        // scroll
       painelFundo = new JPanel();
       painelFundo.setLayout(new GridLayout(1,1));
       barraRolagem = new JScrollPane(jPanelHistorico);
       painelFundo.add(barraRolagem); 
       setSize(40,100);
       setVisible(true);
       getContentPane().add(painelFundo);
        
        
        jPanelsugestao.add(lbTodos);
        lbTodos.setFont(new Font("Arial", 1, 24)); 
        lbTodos.setForeground(new Color(105,105,105));
        lbTodos.setPreferredSize(new Dimension(600,60));
        
        jPanelsugestao.add(lbtotal);
        lbtotal.setFont(new Font("Arial", 1, 16)); 
        lbtotal.setForeground(new Color(105,105,105));
        lbtotal.setPreferredSize(new Dimension(230,60));

        jPanelsugestao.add(total);
        total.setFont(new Font("Arial", 1, 16)); 
        total.setForeground(new Color(105,105,105));
        total.setPreferredSize(new Dimension(300,60));

        
        jPanelsugestao.add(lbaprovadas);
        lbaprovadas.setFont(new Font("Arial", 1, 16)); 
        lbaprovadas.setForeground(new Color(105,105,105));
        lbaprovadas.setPreferredSize(new Dimension(250,60));

        jPanelsugestao.add(aprovadas);
        aprovadas.setFont(new Font("Arial", 1, 16)); 
        aprovadas.setForeground(new Color(105,105,105));
        aprovadas.setPreferredSize(new Dimension(305,60));


        
        jPanelsugestao.add(lbreprovadas);
        lbreprovadas.setFont(new Font("Arial", 1, 16)); 
        lbreprovadas.setForeground(new Color(105,105,105));
        lbreprovadas.setPreferredSize(new Dimension(250,60));

        jPanelsugestao.add(reprovadas);
        reprovadas.setFont(new Font("Arial", 1, 16)); 
        reprovadas.setForeground(new Color(105,105,105));
        reprovadas.setPreferredSize(new Dimension(300,60));
        
        
        
        // Todas infraestrutura
        
        jPanelHistorico.add(jPanelInfraestrutura,BorderLayout.SOUTH);
        jPanelInfraestrutura.setLayout(new FlowLayout());
        jPanelInfraestrutura.setPreferredSize(new Dimension(600,300));
        jPanelInfraestrutura.setForeground(new Color(105,105,105));
        
        
        jPanelInfraestrutura.add(lbInfraestrutura);
        lbInfraestrutura.setFont(new Font("Arial", 1, 24)); 
        lbInfraestrutura.setForeground(new Color(105,105,105));
        lbInfraestrutura.setPreferredSize(new Dimension(600,60));
        
        jPanelInfraestrutura.add(lbtotali);
        lbtotali.setFont(new Font("Arial", 1, 16)); 
        lbtotali.setForeground(new Color(105,105,105));
        lbtotali.setPreferredSize(new Dimension(230,60));

        jPanelInfraestrutura.add(totali);
        totali.setFont(new Font("Arial", 1, 16)); 
        totali.setForeground(new Color(105,105,105));
        totali.setPreferredSize(new Dimension(300,60));

        
        jPanelInfraestrutura.add(lbaprovadasi);
        lbaprovadasi.setFont(new Font("Arial", 1, 16)); 
        lbaprovadasi.setForeground(new Color(105,105,105));
        lbaprovadasi.setPreferredSize(new Dimension(250,60));

        jPanelInfraestrutura.add(aprovadasi);
        aprovadasi.setFont(new Font("Arial", 1, 16)); 
        aprovadasi.setForeground(new Color(105,105,105));
        aprovadasi.setPreferredSize(new Dimension(305,60));


        
        jPanelInfraestrutura.add(lbreprovadasi);
        lbreprovadasi.setFont(new Font("Arial", 1, 16)); 
        lbreprovadasi.setForeground(new Color(105,105,105));
        lbreprovadasi.setPreferredSize(new Dimension(250,60));

        jPanelInfraestrutura.add(reprovadasi);
        reprovadasi.setFont(new Font("Arial", 1, 16)); 
        reprovadasi.setForeground(new Color(105,105,105));
        reprovadasi.setPreferredSize(new Dimension(300,60));
        
        


        //Cursos
        
        jPanelHistorico.add(jPanelCursos,BorderLayout.SOUTH);
        jPanelCursos.setLayout(new FlowLayout());
        jPanelCursos.setPreferredSize(new Dimension(600,300));
        jPanelCursos.setForeground(new Color(105,105,105));
        
        jPanelCursos.add(lbCursos);
        lbCursos.setFont(new Font("Arial", 1, 24)); 
        lbCursos.setForeground(new Color(105,105,105));
        lbCursos.setPreferredSize(new Dimension(600,60));
        
        jPanelCursos.add(lbtotalc);
        lbtotalc.setFont(new Font("Arial", 1, 16)); 
        lbtotalc.setForeground(new Color(105,105,105));
        lbtotalc.setPreferredSize(new Dimension(230,60));

        jPanelCursos.add(totalc);
        totalc.setFont(new Font("Arial", 1, 16)); 
        totalc.setForeground(new Color(105,105,105));
        totalc.setPreferredSize(new Dimension(300,60));

        
        jPanelCursos.add(lbaprovadasc);
        lbaprovadasc.setFont(new Font("Arial", 1, 16)); 
        lbaprovadasc.setForeground(new Color(105,105,105));
        lbaprovadasc.setPreferredSize(new Dimension(250,60));

        jPanelCursos.add(aprovadasc);
        aprovadasc.setFont(new Font("Arial", 1, 16)); 
        aprovadasc.setForeground(new Color(105,105,105));
        aprovadasc.setPreferredSize(new Dimension(305,60));


        
        jPanelCursos.add(lbreprovadasc);
        lbreprovadasc.setFont(new Font("Arial", 1, 16)); 
        lbreprovadasc.setForeground(new Color(105,105,105));
        lbreprovadasc.setPreferredSize(new Dimension(250,60));

        jPanelCursos.add(reprovadasc);
        reprovadasc.setFont(new Font("Arial", 1, 16)); 
        reprovadasc.setForeground(new Color(105,105,105));
        reprovadasc.setPreferredSize(new Dimension(300,60));
        
        
        
        //Eventos
        
        jPanelHistorico.add(jPanelEventos,BorderLayout.SOUTH);
        jPanelEventos.setLayout(new FlowLayout());
        jPanelEventos.setPreferredSize(new Dimension(600,300));
        jPanelEventos.setForeground(new Color(105,105,105));
        
        jPanelEventos.add(lbEventos);
        lbEventos.setFont(new Font("Arial", 1, 24)); 
        lbEventos.setForeground(new Color(105,105,105));
        lbEventos.setPreferredSize(new Dimension(600,60));
        
        jPanelEventos.add(lbtotale);
        lbtotale.setFont(new Font("Arial", 1, 16)); 
        lbtotale.setForeground(new Color(105,105,105));
        lbtotale.setPreferredSize(new Dimension(230,60));

        jPanelEventos.add(totale);
        totale.setFont(new Font("Arial", 1, 16)); 
        totale.setForeground(new Color(105,105,105));
        totale.setPreferredSize(new Dimension(300,60));

        
        jPanelEventos.add(lbaprovadase);
        lbaprovadase.setFont(new Font("Arial", 1, 16)); 
        lbaprovadase.setForeground(new Color(105,105,105));
        lbaprovadase.setPreferredSize(new Dimension(250,60));

        jPanelEventos.add(aprovadase);
        aprovadase.setFont(new Font("Arial", 1, 16)); 
        aprovadase.setForeground(new Color(105,105,105));
        aprovadase.setPreferredSize(new Dimension(305,60));


        
        jPanelEventos.add(lbreprovadase);
        lbreprovadase.setFont(new Font("Arial", 1, 16)); 
        lbreprovadase.setForeground(new Color(105,105,105));
        lbreprovadase.setPreferredSize(new Dimension(250,60));

        jPanelEventos.add(reprovadase);
        reprovadase.setFont(new Font("Arial", 1, 16)); 
        reprovadase.setForeground(new Color(105,105,105));
        reprovadase.setPreferredSize(new Dimension(300,60));
        

        //Apoio
        
        jPanelHistorico.add(jPanelApoio,BorderLayout.SOUTH);
        jPanelApoio.setLayout(new FlowLayout());
        jPanelApoio.setPreferredSize(new Dimension(600,300));
        jPanelApoio.setForeground(new Color(105,105,105));
        
        jPanelApoio.add(lbApoio);
        lbApoio.setFont(new Font("Arial", 1, 24)); 
        lbApoio.setForeground(new Color(105,105,105));
        lbApoio.setPreferredSize(new Dimension(600,60));
        
        jPanelApoio.add(lbtotala);
        lbtotala.setFont(new Font("Arial", 1, 16)); 
        lbtotala.setForeground(new Color(105,105,105));
        lbtotala.setPreferredSize(new Dimension(230,60));

        jPanelApoio.add(totala);
        totala.setFont(new Font("Arial", 1, 16)); 
        totala.setForeground(new Color(105,105,105));
        totala.setPreferredSize(new Dimension(300,60));

        
        jPanelApoio.add(lbaprovadasa);
        lbaprovadasa.setFont(new Font("Arial", 1, 16)); 
        lbaprovadasa.setForeground(new Color(105,105,105));
        lbaprovadasa.setPreferredSize(new Dimension(250,60));

        jPanelApoio.add(aprovadasa);
        aprovadasa.setFont(new Font("Arial", 1, 16)); 
        aprovadasa.setForeground(new Color(105,105,105));
        aprovadasa.setPreferredSize(new Dimension(305,60));


        
        jPanelApoio.add(lbreprovadasa);
        lbreprovadasa.setFont(new Font("Arial", 1, 16)); 
        lbreprovadasa.setForeground(new Color(105,105,105));
        lbreprovadasa.setPreferredSize(new Dimension(250,60));

        jPanelApoio.add(reprovadasa);
        reprovadasa.setFont(new Font("Arial", 1, 16)); 
        reprovadasa.setForeground(new Color(105,105,105));
        reprovadasa.setPreferredSize(new Dimension(300,60));
 
        
        
        //Segurança
        
        jPanelHistorico.add(jPanelSeguranca,BorderLayout.SOUTH);
        jPanelSeguranca.setLayout(new FlowLayout());
        jPanelSeguranca.setPreferredSize(new Dimension(600,300));
        jPanelSeguranca.setForeground(new Color(105,105,105));
        
        
        
        jPanelSeguranca.add(lbSeguranca);
        lbSeguranca.setFont(new Font("Arial", 1, 24)); 
        lbSeguranca.setForeground(new Color(105,105,105));
        lbSeguranca.setPreferredSize(new Dimension(600,60));
        
        jPanelSeguranca.add(lbtotals);
        lbtotals.setFont(new Font("Arial", 1, 16)); 
        lbtotals.setForeground(new Color(105,105,105));
        lbtotals.setPreferredSize(new Dimension(230,60));

        jPanelSeguranca.add(totals);
        totals.setFont(new Font("Arial", 1, 16)); 
        totals.setForeground(new Color(105,105,105));
        totals.setPreferredSize(new Dimension(300,60));

        
        jPanelSeguranca.add(lbaprovadass);
        lbaprovadass.setFont(new Font("Arial", 1, 16)); 
        lbaprovadass.setForeground(new Color(105,105,105));
        lbaprovadass.setPreferredSize(new Dimension(250,60));

        jPanelSeguranca.add(aprovadass);
        aprovadass.setFont(new Font("Arial", 1, 16)); 
        aprovadass.setForeground(new Color(105,105,105));
        aprovadass.setPreferredSize(new Dimension(305,60));


        
        jPanelSeguranca.add(lbreprovadass);
        lbreprovadass.setFont(new Font("Arial", 1, 16)); 
        lbreprovadass.setForeground(new Color(105,105,105));
        lbreprovadass.setPreferredSize(new Dimension(250,60));

        jPanelSeguranca.add(reprovadass);
        reprovadass.setFont(new Font("Arial", 1, 16)); 
        reprovadass.setForeground(new Color(105,105,105));
        reprovadass.setPreferredSize(new Dimension(300,60));
        
        
        
        
        //Sugestões Livres
        
        jPanelHistorico.add(jPanelSugestoesLivres,BorderLayout.SOUTH);
        jPanelSugestoesLivres.setLayout(new FlowLayout());
        jPanelSugestoesLivres.setPreferredSize(new Dimension(600,300));
        jPanelSugestoesLivres.setForeground(new Color(105,105,105));
        
        jPanelSugestoesLivres.add(lbSugestoesLivres);
        lbSugestoesLivres.setFont(new Font("Arial", 1, 24)); 
        lbSugestoesLivres.setForeground(new Color(105,105,105));
        lbSugestoesLivres.setPreferredSize(new Dimension(600,60));
        
        jPanelSugestoesLivres.add(lbtotalsu);
        lbtotalsu.setFont(new Font("Arial", 1, 16)); 
        lbtotalsu.setForeground(new Color(105,105,105));
        lbtotalsu.setPreferredSize(new Dimension(230,60));

        jPanelSugestoesLivres.add(totalsu);
        totalsu.setFont(new Font("Arial", 1, 16)); 
        totalsu.setForeground(new Color(105,105,105));
        totalsu.setPreferredSize(new Dimension(300,60));

        
        jPanelSugestoesLivres.add(lbaprovadassu);
        lbaprovadassu.setFont(new Font("Arial", 1, 16)); 
        lbaprovadassu.setForeground(new Color(105,105,105));
        lbaprovadassu.setPreferredSize(new Dimension(250,60));

        jPanelSugestoesLivres.add(aprovadassu);
        aprovadassu.setFont(new Font("Arial", 1, 16)); 
        aprovadassu.setForeground(new Color(105,105,105));
        aprovadassu.setPreferredSize(new Dimension(305,60));


        
        jPanelSugestoesLivres.add(lbreprovadassu);
        lbreprovadassu.setFont(new Font("Arial", 1, 16)); 
        lbreprovadassu.setForeground(new Color(105,105,105));
        lbreprovadassu.setPreferredSize(new Dimension(250,60));

        jPanelSugestoesLivres.add(reprovadassu);
        reprovadassu.setFont(new Font("Arial", 1, 16)); 
        reprovadassu.setForeground(new Color(105,105,105));
        reprovadassu.setPreferredSize(new Dimension(300,60));
        
        
        
        
        
		//Padroes da tela
		setSize(840,620);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // deixa a posição da janela no meio
		setResizable(false);//Não deixa maximizar
		setVisible(true);
		
		
		//Ações dos botões
		bntmeuperfil.addActionListener(this);
		bnthistorico.addActionListener(this);
		bntnovasugestao.addActionListener(this);
		bntsair.addActionListener(this);
		bntretornar.addActionListener(this);
				
	}

public void actionPerformed(ActionEvent e) {
	
	if (e.getSource() == bntmeuperfil) {
	this.dispose();
    new telas.superior.TelaMeuPerfil().setVisible(true);  
	}
	
	if (e.getSource() == bnthistorico) {
	this.dispose();
    new telas.superior.TelaSuperiorRegistro().setVisible(true);  
	}
	
	if (e.getSource() == bntnovasugestao) {
		JOptionPane.showMessageDialog(null, "Você já está nesta página!"); 
	}
	
	if (e.getSource() == bntsair) {
	this.dispose();
    new telas.TelaLogin().setVisible(true);  
	}
	if (e.getSource() == bntretornar) {
	this.dispose();
    new telas.superior.TelaPrincipal().setVisible(true);  
	}

	}    
          
}
