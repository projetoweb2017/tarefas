package telas.colaborador;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.*;

import banco.de.dados.DAO.SugestaoDAO;
import banco.de.dados.DAO.SugestaoJTableDAO;
import banco.de.dados.Model.Sugestao;

public class TelaTop extends JFrame implements ActionListener, MouseListener {

//imagen menu
   ImageIcon mp = new ImageIcon(getClass().getResource("img/bntmp.png"));
	
   JButton bntmeuperfil = new JButton(mp);	

   ImageIcon historico = new ImageIcon(getClass().getResource("img/bnthist.png"));
	
   JButton bnthistorico = new JButton(historico);	



   ImageIcon novasuges = new ImageIcon(getClass().getResource("img/bntns.png"));
	
   JButton bntnovasugestao = new JButton(novasuges);	



   ImageIcon sair = new ImageIcon(getClass().getResource("img/bntsair.png"));
	
   JButton bntsair = new JButton(sair);	

   ImageIcon retorn = new ImageIcon(getClass().getResource("img/bntr.png"));
	
   JButton bntretornar = new JButton(retorn);	


   private JComboBox cat;
   private static final String[] names = {"Todos","Infraestrutura","Cursos","Eventos","Apoio","Segurança","Sugestões Livres"};

   private JLabel lblnovasugestao,lblsugestao,espaco;

   private JPanel jPanelMenu,jPanelNovaSugestao;
   
   
	//JTable
	private DefaultTableModel modelo = new DefaultTableModel();
    private JPanel painelFundo;
    private JTable tabela;
    private JScrollPane barraRolagem;
	
	
   public TelaTop(){
      super("Uni - Top Sugestões");
      
      cat = new JComboBox<Object> (names);
      cat.setMaximumRowCount(7);

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
   	
      jPanelMenu = new JPanel();
      jPanelNovaSugestao = new JPanel();
   
   					
     
      //labels
      
      lblnovasugestao = new JLabel("       Top sugestão");
      lblnovasugestao.setFont(new Font("Arial", 1, 35)); 
      lblnovasugestao.setForeground(new Color(0, 102, 204));  
      
      lblsugestao = new JLabel("Escolha uma categoria para ver as melhores sugestões: ");
      lblsugestao.setFont(new Font("Arial", 0, 15)); 
      lblsugestao.setForeground(new Color(0,0,0));
      
      Container caixa = getContentPane();
   	
      caixa.setLayout(new BorderLayout());//leyout nulo para poder posicionar os components
      caixa.add(jPanelMenu, BorderLayout.WEST);
      caixa.add(jPanelNovaSugestao, BorderLayout.CENTER);
   	
   	
      jPanelNovaSugestao.setBackground(new Color(255,255,255));  
   	
   	//Painel do Menu
      jPanelMenu.setBackground(new Color(0,102,204));
      
     
     
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
   
        
      //painel nova sugestao
           
      
      jPanelNovaSugestao.setPreferredSize(new Dimension(300,800));//tamanha do painel
      jPanelNovaSugestao.setLayout(new FlowLayout());
        
        
        
        
   
      jPanelNovaSugestao.add(lblnovasugestao); 
      lblnovasugestao.setPreferredSize(new Dimension(360,50));
             
      jPanelNovaSugestao.add(lblsugestao); 
      lblsugestao.setPreferredSize(new Dimension(375,50));
      
      jPanelNovaSugestao.add(cat);
      cat.setPreferredSize(new Dimension(150,30));
      
      //Jtable
      painelFundo = new JPanel();
      jPanelNovaSugestao.add(painelFundo);
      painelFundo.setPreferredSize(new Dimension(650,199));
      painelFundo.setLayout(new GridLayout(1, 1));

      
      tabela = new JTable(modelo);
      barraRolagem = new JScrollPane(tabela);
      painelFundo.add(BorderLayout.CENTER, barraRolagem);
		modelo.addColumn("Título");
		modelo.addColumn("Autor");
		modelo.addColumn("Likes");
		modelo.addColumn("Categoria");
		tabela.getColumnModel().getColumn(0).setPreferredWidth(180);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(150);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(80);
		PreencherJTable(modelo);
      //fim JTable
           
           
		// Adiciona a ação na JTable
		tabela.addMouseListener(this);
		
		// Acão quando for alterada a informação no JCOMBOBOX ...
		cat.addActionListener(this);
	      
		cat.addActionListener (
	         new ActionListener () {
	            public void actionPerformed(ActionEvent e) {
	               if(cat.getSelectedItem() == "Todos"){
	            	   PreencherJTable(modelo);
	               }
	               else{
	                  if(cat.getSelectedItem() == "Infraestrutura"){
	                     PreencherJTableInfraestrutura(modelo);
	                    
	                  }else{
	                     if(cat.getSelectedItem() == "Cursos"){
	                        PreencherJTableCursos(modelo);
	                     }else{
	                     if(cat.getSelectedItem() == "Apoio"){
		                     PreencherJTableApoio(modelo);
			                  
		                  }else{
		                     if(cat.getSelectedItem() == "Eventos"){
		                        PreencherJTableEventos(modelo);
		                     }
		                     else{
		                     if(cat.getSelectedItem() == "Sugestões Livres"){
			                     PreencherJTableSugestoesLivres(modelo);
				                  
			                  }
			                  else{
			                     if(cat.getSelectedItem() == "Segurança"){
			                        PreencherJTableSeguranca(modelo);
			                     }
			                     else{
			                        
			                     }
			                  }
		                     }
			               }
		                }
	                  }
	               } 
	            }
	         });
		
		
		
                
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
         new telas.colaborador.TelaMeuPerfil().setVisible(true);  
      }
   	
      if (e.getSource() == bnthistorico) {
         this.dispose();
         new telas.colaborador.TelaHistoricoDeSugestoes().setVisible(true);  
      }
   	
      if (e.getSource() == bntnovasugestao) {
    	  this.dispose();
          new telas.colaborador.TelaNovaSugestao().setVisible(true);   
      }
      
 
      if (e.getSource() == bntretornar) {
         this.dispose();
         new telas.colaborador.TelaPrincipal().setVisible(true);  
      }

      if (e.getSource() == bntsair) {
         this.dispose();
         new telas.TelaLogin().setVisible(true);  
      }
   }
   
	public static void PreencherJTableInfraestrutura(DefaultTableModel modelo) {
		
		modelo.setNumRows(0);
		
		SugestaoDAO sugestao = new SugestaoDAO();
	
		

		for(Sugestao s: sugestao.TopSugestoesInfraestrutura()){
			modelo.addRow(new Object[]{
					
					s.getTitulo(),
					s.getAutor(),
					s.getLike(),
					s.getCategoria(),
					s.getData()});
		}
	}
	public static void PreencherJTableEventos(DefaultTableModel modelo) {
		
		modelo.setNumRows(0);
		
		SugestaoDAO sugestao = new SugestaoDAO();
	
		

		for(Sugestao s: sugestao.TopSugestoesEventos()){
			modelo.addRow(new Object[]{
					
					s.getTitulo(),
					s.getAutor(),
					s.getLike(),
					s.getCategoria(),
					s.getData()});
		}
	}
	public static void PreencherJTableApoio(DefaultTableModel modelo) {
		
		modelo.setNumRows(0);
		
		SugestaoDAO sugestao = new SugestaoDAO();
	
		

		for(Sugestao s: sugestao.TopSugestoesApoio()){
			modelo.addRow(new Object[]{
					
					s.getTitulo(),
					s.getAutor(),
					s.getLike(),
					s.getCategoria(),
					s.getData()});
		}
	}
	public static void PreencherJTableSeguranca(DefaultTableModel modelo) {
		
		modelo.setNumRows(0);
		
		SugestaoDAO sugestao = new SugestaoDAO();
	
		

		for(Sugestao s: sugestao.TopSugestoesSeguranca()){
			modelo.addRow(new Object[]{
					
					s.getTitulo(),
					s.getAutor(),
					s.getLike(),
					s.getCategoria(),
					s.getData()});
		}
	}
	public static void PreencherJTableSugestoesLivres(DefaultTableModel modelo) {
		
		modelo.setNumRows(0);
		
		SugestaoDAO sugestao = new SugestaoDAO();
	
		

		for(Sugestao s: sugestao.TopSugestoesSugestoesLivres()){
			modelo.addRow(new Object[]{
					
					s.getTitulo(),
					s.getAutor(),
					s.getLike(),
					s.getCategoria(),
					s.getData()});
		}
	}
	public static void PreencherJTableCursos(DefaultTableModel modelo) {
		
		modelo.setNumRows(0);
		
		SugestaoDAO sugestao = new SugestaoDAO();
	
		

		for(Sugestao s: sugestao.TopSugestoesCursos()){
			modelo.addRow(new Object[]{
					
					s.getTitulo(),
					s.getAutor(),
					s.getLike(),
					s.getCategoria(),
					s.getData()});
		}
	}
	public static void PreencherJTable(DefaultTableModel modelo) {
		
		modelo.setNumRows(0);
		
		SugestaoDAO sugestao = new SugestaoDAO();
	
		

		for(Sugestao s: sugestao.TopSugestoes()){
			modelo.addRow(new Object[]{
					
					s.getTitulo(),
					s.getAutor(),
					s.getLike(),
					s.getCategoria(),
					s.getData()});
		}
	}
	
	public void mouseClicked(MouseEvent e) {
					if(tabela.getSelectedRow() != -1){
						SugestaoJTableDAO su = new SugestaoJTableDAO();
						
						
						
						su.PreencherSugestaoTop(tabela.getValueAt(tabela.getSelectedRow(), 0).toString(),tabela.getValueAt(tabela.getSelectedRow(), 1).toString(),Integer.parseInt(tabela.getValueAt(tabela.getSelectedRow(), 2).toString()));
						this.dispose();
				        new telas.colaborador.TelaSugestoesAprovadasColaborador().setVisible(true);  
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
