package telas.superior;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;


import banco.de.dados.DAO.LoginDAO;
import banco.de.dados.DAO.SugestaoDAO;
import banco.de.dados.DAO.SugestaoJTableDAO;
import banco.de.dados.Model.Sugestao;

public class TelaInfraestrutura extends JFrame implements ActionListener, MouseListener {

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


//Top sugestão
ImageIcon top = new ImageIcon(getClass().getResource("img/troufeu.png"));
	
JButton bntTop = new JButton(top);
		
private JLabel lbbrancotop, lbbrancotopp, lbtop, lbtopp;  












	
	private JLabel lbcategorias,lbcategoria, lbtitulo , lbautor, lblike, lbdeslike,lbbranco,lbbrancoo,espaco;
	

	private JPanel jPanelMenu,jPanelTop,jPanelSugestoes;
   
   
	   
		//JTable
		private DefaultTableModel modelo = new DefaultTableModel();
	   private JPanel painelFundo;
	   private JTable tabela;
	   private JScrollPane barraRolagem;  
    

	
	public TelaInfraestrutura(){
		super("Uni - Infraestrutura");
      

		
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
		// top sugestão

	      bntTop.setContentAreaFilled(false);
			bntTop.setBorder(null);//tira as bordas


      //maozinha


       bntmeuperfil.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
		bnthistorico.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
		bntnovasugestao.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
      bntsair.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
      bntretornar.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
      // top sugestão
   		bntTop.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
		
		//Categorias
		lbcategorias = new JLabel("                    Mural de Sugestões                ");
		lbbrancoo = new JLabel("                                   ");
		lbcategoria = new JLabel("(Infraestrutura)             ");
		
		lbbranco = new JLabel("                                                                                                            ");
		
		//Top sugestões
		lbtop = new JLabel("         Top");		
		lbtopp = new JLabel("    Sugestões");
		lbbrancotop = new JLabel("");
		lbbrancotopp = new JLabel("");		
				
		jPanelMenu = new JPanel();
		jPanelTop = new JPanel();
		jPanelSugestoes = new JPanel();
		

		//Container
		
		Container caixa = getContentPane();

		caixa.setLayout(new BorderLayout());
		caixa.add(jPanelMenu,BorderLayout.WEST);
		caixa.add(jPanelTop, BorderLayout.EAST);
		caixa.add(jPanelSugestoes,BorderLayout.CENTER);
		
		
		
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
        jPanelSugestoes.setBackground(new java.awt.Color(255,255,255));

        jPanelSugestoes.add(lbcategorias,BorderLayout.CENTER);
        lbcategorias.setFont(new Font("Arial", 1, 24)); 
        lbcategorias.setForeground(new Color(0, 102, 204));
        
        jPanelSugestoes.add(lbbrancoo);
        jPanelSugestoes.add(lbcategoria,BorderLayout.CENTER);
        lbcategoria.setFont(new Font("Arial", 0, 24)); 
        lbcategoria.setForeground(new Color(0, 102, 204)); // Cor azul 
        
        jPanelSugestoes.add(lbbranco);
        
        
       // bntsugestao1.setPreferredSize(new Dimension(480,80));//tamanho do bota0
        
        
        //Jtable
        painelFundo = new JPanel();
        jPanelSugestoes.add(painelFundo);
        painelFundo.setPreferredSize(new Dimension(450,450));
        painelFundo.setLayout(new GridLayout(1, 1));

        
        tabela = new JTable(modelo);
        barraRolagem = new JScrollPane(tabela);
        painelFundo.add(BorderLayout.CENTER, barraRolagem);
		modelo.addColumn("Título");
		modelo.addColumn("Likes");
		modelo.addColumn("Deslikes");
		modelo.addColumn("Data Postada");
		tabela.getColumnModel().getColumn(0).setPreferredWidth(180);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(30);
		PreencherJTable(modelo);
        //fim JTable

        
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
	
        
       
        
        
        
        
        
		//Padroes da tela
		setSize(840,620);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // deixa a posição da janela no meio
		setResizable(false);//Não deixa maximizar
		setVisible(true);
		
		//botoes
		bntmeuperfil.addActionListener(this);
		bnthistorico.addActionListener(this);
		bntnovasugestao.addActionListener(this);
		bntsair.addActionListener(this);
		bntretornar.addActionListener(this);
		bntTop.addActionListener(this);
		
		
	   	// Adiciona a ação na JTable
	      tabela.addMouseListener(this);
		

		
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
			this.dispose();
	        new telas.superior.TelaSuperiorRelatorio().setVisible(true);  
		}
		
		if (e.getSource() == bntretornar) {
				this.dispose();
				new telas.superior.TelaPrincipal().setVisible(true);  
	    }		
		
		
		if (e.getSource() == bntsair) {
			this.dispose();
			new telas.TelaLogin().setVisible(true);  
		}
	      if (e.getSource() == bntTop) {
	          this.dispose();
	          new telas.superior.TelaTop().setVisible(true);  
	       }
		
}
	public static void PreencherJTable(DefaultTableModel modelo) {
		
		modelo.setNumRows(0);
		
		SugestaoDAO sugestao = new SugestaoDAO();
		

		for(Sugestao s: sugestao.CarregarSugestoesInfraestruturaAprovadas()){
			modelo.addRow(new Object[]{
					
					s.getTitulo(),
					s.getLike(),
					s.getDeslike(),
					s.getData()});
		}
	}
	
	   public void mouseClicked(MouseEvent e) {
	      if(tabela.getSelectedRow() != -1){
	    	  SugestaoJTableDAO su = new SugestaoJTableDAO();
	      				
	      				
	         su.PreencherSugestaoAprovada(tabela.getValueAt(tabela.getSelectedRow(), 0).toString(),tabela.getValueAt(tabela.getSelectedRow(), 3).toString());
	         this.dispose();
	         new telas.superior.TelaSugestoesAprovadasSuperior().setVisible(true);  
	      } 
	   	
	   }
	   public void mousePressed(MouseEvent e) {
		   	
	   }
	   public void mouseReleased(MouseEvent e) {
	   	
	   }
	   public void mouseEntered(MouseEvent e) {
	   	
	   }
	   public void mouseExited(MouseEvent e) {
	   	
	   }   
	}

