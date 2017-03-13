package telas.colaborador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import banco.de.dados.DAO.LoginDAO;
import banco.de.dados.DAO.SugestaoDAO;
import banco.de.dados.DAO.SugestaoJTableDAO;
import banco.de.dados.Model.Sugestao;

import java.awt.*;
import java.awt.event.*;



public class TelaHistoricoDeSugestoes extends JFrame implements ActionListener, MouseListener {

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





	
   private DefaultTableModel modelo = new DefaultTableModel();
	
   private JLabel lbhistorico,lbbranco;
	
	//private JButton bntmeuperfil, bnthistorico, bntnovasugestao,bntsair,bntretornar;

   private JLabel espaco;
	
   private JButton bntsugestao1;

   private JPanel jPanelMenu,jPanelHistorico;
	
	//JTable
   private JPanel painelFundo;
   private JTable tabela;
   private JScrollPane barraRolagem;
	   
   public TelaHistoricoDeSugestoes(){
      super("Uni - Histórico de sugestões");
   	
   	
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
      lbhistorico = new JLabel("Histórico de Sugestões");
      bntsugestao1 = new JButton("");
      lbbranco = new JLabel("ooooooooooooooooo");
   		
   			
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
        
      jPanelHistorico.add(lbbranco,BorderLayout.CENTER);
      lbbranco.setFont(new Font("Arial", 1, 34)); 
      lbbranco.setForeground(new Color(255, 255, 255));
   
        
   	//Jtable
      painelFundo = new JPanel();
      jPanelHistorico.add(painelFundo);
      painelFundo.setPreferredSize(new Dimension(650,450));
      painelFundo.setLayout(new GridLayout(1, 1));
   
        
      tabela = new JTable(modelo);
      barraRolagem = new JScrollPane(tabela);
      painelFundo.add(BorderLayout.CENTER, barraRolagem);
      modelo.addColumn("Título");
      modelo.addColumn("Likes");
      modelo.addColumn("Deslikes");
      modelo.addColumn("Categoria");
      modelo.addColumn("Status");
      modelo.addColumn("Data Postada");
      tabela.getColumnModel().getColumn(0).setPreferredWidth(150);
      tabela.getColumnModel().getColumn(1).setPreferredWidth(5);
      tabela.getColumnModel().getColumn(2).setPreferredWidth(5);
      tabela.getColumnModel().getColumn(3).setPreferredWidth(50);
      tabela.getColumnModel().getColumn(4).setPreferredWidth(75);
      tabela.getColumnModel().getColumn(5).setPreferredWidth(27);
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
      bntsugestao1.addActionListener(this);
   
   	// Adiciona a ação na JTable
      tabela.addMouseListener(this);
   	
   }

	
   public void actionPerformed(ActionEvent e) {
   	
      if (e.getSource() == bntmeuperfil) {
         this.dispose();
         new telas.colaborador.TelaMeuPerfil().setVisible(true);  
      }
   	
      if (e.getSource() == bnthistorico) {
         JOptionPane.showMessageDialog(null, "Você já está nesta página!"); 
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
      if (e.getSource() == bntsugestao1) {
         this.dispose();
         new telas.colaborador.TelaSugestoesAguardandoColaborador().setVisible(true);  
      }
   }
	
   public static void PreencherJTable(DefaultTableModel modelo) {
   	
      modelo.setNumRows(0);
   	
      SugestaoDAO sugestao = new SugestaoDAO();
   	
   
      for(Sugestao s: sugestao.CarregarSugestoesHistorico()){
         modelo.addRow(new Object[]{
            	
            	s.getTitulo(),
            	s.getLike(),
            	s.getDeslike(),
            	s.getCategoria(),
            	s.getStatus(),
            	s.getData()});
      }
   }


   public void mouseClicked(MouseEvent e) {
      if(tabela.getSelectedRow() != -1){
    	  SugestaoJTableDAO su = new SugestaoJTableDAO();
      	
         if(tabela.getValueAt(tabela.getSelectedRow(), 4).equals("Aguardando Avaliador")){
            su.PreencherSugestaoAguardando(tabela.getValueAt(tabela.getSelectedRow(), 0).toString(),tabela.getValueAt(tabela.getSelectedRow(), 5).toString());
            this.dispose();
            new telas.colaborador.TelaSugestoesAguardandoColaborador().setVisible(true);
         }
         else{
            if(tabela.getValueAt(tabela.getSelectedRow(), 4).equals("Aprovada")){
               su.PreencherSugestaoAprovada(tabela.getValueAt(tabela.getSelectedRow(), 0).toString(),tabela.getValueAt(tabela.getSelectedRow(), 5).toString());
               this.dispose();
               new telas.colaborador.TelaSugestoesAprovadasColaborador().setVisible(true);
            }
            else{
               if(tabela.getValueAt(tabela.getSelectedRow(), 4).equals("Reprovada")){
                  su.PreencherSugestaoReprovada(tabela.getValueAt(tabela.getSelectedRow(), 0).toString(),tabela.getValueAt(tabela.getSelectedRow(), 5).toString());
                  this.dispose();
                  new telas.colaborador.TelaSugestoesReprovadasColaborador().setVisible(true);
               }
               else{
                  JOptionPane.showMessageDialog(null, "Erro: Status da sugestão inválido , por favor avise um de nossos administradores.");
               }
            }
         }
      		
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

