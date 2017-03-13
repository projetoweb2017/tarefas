package telas.avaliador;

import javax.swing.*;

import banco.de.dados.DAO.LoginDAO;
import banco.de.dados.DAO.SugestaoDAO;
import banco.de.dados.DAO.SugestaoJTableDAO;
import banco.de.dados.Model.Login;
import banco.de.dados.Model.Sugestao;

import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;



public class TelaSugestoesPostadasInfraestrutura extends JFrame implements ActionListener, MouseListener {


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















	
	private JLabel lbhistorico,lbbranco,lbtitulo,lbautor,lbpostado,lbinfraestrutura;
	
	//private JButton bntmeuperfil, bnthistorico, bntnovasugestao,bntsair,bntretornar;

	private JLabel espaco;

	private JPanel jPanelMenu,jPanelHistorico;
	
	//JTable
	   private JPanel painelFundo;
	   private JTable tabela;
	   private JScrollPane barraRolagem;
	   private DefaultTableModel modelo = new DefaultTableModel();
	
	
	public TelaSugestoesPostadasInfraestrutura(){
		super("Uni - Postadas em Infraestrutura");
		
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
		lbhistorico = new JLabel("Sugestões Postadas     ");
		lbbranco = new JLabel("oooooooooooooooooooooooooooooooooooooooooooo");
			
         
         
		lbinfraestrutura = new JLabel("      (Infraestrutura)");
      lbtitulo = new JLabel(" Titulo: ");
      lbautor = new JLabel("Autor: ");
      lbpostado = new JLabel("Postado: ");

         
         
         
         
         	
		jPanelMenu = new JPanel();
		jPanelHistorico = new JPanel();


		

		//Container
		
		Container caixa = getContentPane();

		caixa.setLayout(new BorderLayout());
		caixa.add(jPanelMenu,BorderLayout.WEST);
		caixa.add(jPanelHistorico,BorderLayout.CENTER);
		
		
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
        
        jPanelHistorico.add(lbinfraestrutura,BorderLayout.CENTER);
        lbinfraestrutura.setFont(new Font("Arial", 0, 24)); 
        lbinfraestrutura.setForeground(new Color(0, 102, 204));
        lbinfraestrutura.setPreferredSize(new Dimension(300,30));


        
        
        jPanelHistorico.add(lbbranco,BorderLayout.CENTER);
        lbbranco.setFont(new Font("Arial", 1, 20)); 
        lbbranco.setForeground(new Color(255, 255, 255));
        
        
	
        //Jtable
        painelFundo = new JPanel();
        jPanelHistorico.add(painelFundo);
        painelFundo.setPreferredSize(new Dimension(650,450));
        painelFundo.setLayout(new GridLayout(1, 1));

        
        tabela = new JTable(modelo);
        barraRolagem = new JScrollPane(tabela);
        painelFundo.add(BorderLayout.CENTER, barraRolagem);
		modelo.addColumn("ID");
		modelo.addColumn("Título");
		modelo.addColumn("Autor");
		modelo.addColumn("Data Postada");
		tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(200);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(180);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(20);
		PreencherJTable(modelo);
        //fim JTable
       
        
        
        
        
        
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
		
		// Adiciona a ação na JTable
		tabela.addMouseListener(this);
		
	}

	
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource() == bntmeuperfil) {
			this.dispose();
			new telas.avaliador.TelaMeuPerfil().setVisible(true);  
		}
		
		if (e.getSource() == bnthistorico) {
			
			
			JOptionPane.showMessageDialog(null, "Você já está nesta página!"); 
		}
		
	      if (e.getSource() == bntnovasugestao) {
	      		
	    	  Login lo = Login.getInstance();
	      		
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
   
   
   	
}
	public static void PreencherJTable(DefaultTableModel modelo) {
		
		modelo.setNumRows(0);
		
		SugestaoDAO sugestao = new SugestaoDAO();
		

		for(Sugestao s: sugestao.CarregarSugestoesInfraestruturaAguardando()){
			modelo.addRow(new Object[]{
					
					s.getId(),
					s.getTitulo(),
					s.getAutor(),
					s.getData()});
		}
	}


	public void mouseClicked(MouseEvent e) {
		if(tabela.getSelectedRow() != -1){
			SugestaoJTableDAO su = new SugestaoJTableDAO();
			
			
			su.PreencherSugestaoAguardando(Integer.parseInt(tabela.getValueAt(tabela.getSelectedRow(), 0).toString()));
			this.dispose();
			 new telas.avaliador.TelaSugestoesAguardandoAvaliador().setVisible(true); 
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


