package telas.superior;



import banco.de.dados.DAO.CadastroDAO;
import banco.de.dados.DAO.RegistroDAO;
import banco.de.dados.Model.Cadastro;
import banco.de.dados.Model.Registro;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

//import banco.de.dados.DAO.LoginDAO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TelaSuperiorRegistro extends JFrame implements ActionListener{

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











   private static JComboBox<?> reg,cargo,cat;

   private DefaultTableModel modelo = new DefaultTableModel();

   private static final String[] names = {"Todos","Colaboradores","Avaliadores","Superiores"};
   private static final String[] cargos = {"Colaborador","Avaliador","Superior"};
   private static final String[] categoria = {"Colaborador","Infraestrutura","Cursos","Eventos","Apoio","Segurança","Sugestões Livres","Admin"};
	
   private JLabel lbregistro,lbespaco,esp1,esp2,lbcategoria,lbcargo;
	
  // private JButton bntmeuperfil, bnthistorico, bntnovasugestao,bntsair,bntretornar;

   private JLabel espaco;
   
   private JTextField txtcategoria,txtcargo;
   
   private JButton bntexcluir,bntatu;
	
   private JPanel jPanelMenu,jPanelRegistro,jPanelHistorico;

   
   //JTable
   private JPanel painelFundo;
   private JTable tabela;
   private JScrollPane barraRolagem;

   	//JCOMboBoxSet


   public TelaSuperiorRegistro(){
      super("UNI - Apoio");
      
      
      reg = new JComboBox<>(names);
      reg.setMaximumRowCount(4);
      
      
      cargo = new JComboBox<>(cargos);
      cargo.setMaximumRowCount(3);
      
      cat = new JComboBox<>(categoria);
      cat.setMaximumRowCount(8);


   
   	
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
      lbespaco = new JLabel(" ");
      lbregistro = new JLabel("Registros");
      
      
      esp1 = new JLabel(" ");
      esp2 = new JLabel(" ");
   
      
      lbcategoria = new JLabel("Categoria");
      
      lbcargo = new JLabel("Cargo");
      
      txtcategoria = new JTextField();
      
      txtcargo = new JTextField();
      
      
      bntexcluir = new JButton("Excluir");
      bntatu = new  JButton("Atualizar");
      
      
      
      
      
      
      
      
   		
   			
      jPanelMenu = new JPanel();
      jPanelHistorico = new JPanel();
      jPanelRegistro = new JPanel();
      
   
      
      
      
      
      
      
     
   	
      
      
   	//Container
   	
      Container caixa = getContentPane();
   
      caixa.setLayout(new BorderLayout());
      caixa.add(jPanelMenu,BorderLayout.WEST);
      caixa.add(jPanelHistorico,BorderLayout.CENTER);
      caixa.add(jPanelRegistro,BorderLayout.EAST);
   	
   	
   	
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
      bntretornar.setPreferredSize(new Dimension(140,80));//tamanho do bota0          //Painel de Sugestoes       
      jPanelHistorico.setBackground(new java.awt.Color(255,255,255));
      jPanelHistorico.setLayout(new FlowLayout());
        
        
      jPanelHistorico.add(lbespaco);
      lbregistro.setFont(new Font("Arial", 1, 34)); 
      lbespaco.setForeground(new Color(0, 102, 204));
      lbespaco.setPreferredSize(new Dimension(50,60));
        
        
                  
      jPanelHistorico.add(lbregistro,BorderLayout.CENTER);
      lbregistro.setFont(new Font("Arial", 1, 34)); 
      lbregistro.setForeground(new Color(0, 102, 204));
      lbregistro.setPreferredSize(new Dimension(200,60));
   
        
        
        
        
                
        
      //painel registro
   
      jPanelHistorico.add(jPanelRegistro,BorderLayout.CENTER);
      jPanelRegistro.setLayout(new FlowLayout());
      jPanelRegistro.setBackground(new java.awt.Color(255,255,255));
      jPanelRegistro.setPreferredSize(new Dimension(600,550));
            
        
        
        
      jPanelRegistro.add(reg);
      reg.setPreferredSize(new Dimension(200,30));
   
      jPanelRegistro.add(esp1);
      esp1.setPreferredSize(new Dimension(385,60));
        
        
        
      
      //Jtable
      painelFundo = new JPanel();
      jPanelRegistro.add(painelFundo);
      
      painelFundo.setPreferredSize(new Dimension(600,300));
      painelFundo.setLayout(new BorderLayout());
      
      tabela = new JTable(modelo);
      barraRolagem = new JScrollPane(tabela); //
      painelFundo.add(BorderLayout.CENTER, barraRolagem);
      modelo.addColumn("ID");
      modelo.addColumn("Nome Completo");
      modelo.addColumn("Email");
      modelo.addColumn("Cargo");
      modelo.addColumn("Categoria");
      tabela.getColumnModel().getColumn(0).setPreferredWidth(1);
      tabela.getColumnModel().getColumn(1).setPreferredWidth(200);
      tabela.getColumnModel().getColumn(2).setPreferredWidth(150);
      tabela.getColumnModel().getColumn(3).setPreferredWidth(50);
      tabela.getColumnModel().getColumn(4).setPreferredWidth(50);
      PreencherJTableTodos(modelo);
      
      //fim JTable
      
   
        
        
        
      jPanelRegistro.add(esp2);
      esp2.setPreferredSize(new Dimension(90,30));
        
      jPanelRegistro.add(lbcategoria);
      lbcategoria.setFont(new Font("Arial", 1, 16)); 
      lbcategoria.setForeground(new Color(105,105,105));
      lbcategoria.setPreferredSize(new Dimension(200,20));
   
      jPanelRegistro.add(lbcargo);
      lbcargo.setFont(new Font("Arial", 1, 16)); 
      lbcargo.setForeground(new Color(105,105,105));
      lbcargo.setPreferredSize(new Dimension(290,20));
   

      
      jPanelRegistro.add(cat);
      cat.setPreferredSize(new Dimension(220,30)); 
     
      
      
        
      jPanelRegistro.add(cargo);
      cargo.setPreferredSize(new Dimension(220,30));
   
      
      
      
      jPanelRegistro.add(bntexcluir);
      bntexcluir.setPreferredSize(new Dimension(150,30));  
        
      jPanelRegistro.add(bntatu);
      bntatu.setPreferredSize(new Dimension(150,30));  
   
      
        
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
      bntatu.addActionListener(this);
      bntexcluir.addActionListener(this);
      
      
      //Tabela pegar os dados quando clicar na JTable
      tabela.addMouseListener(
         new MouseAdapter()  
         {  
            public void mouseClicked(MouseEvent e){
               if(tabela.getSelectedRow() != -1){
                  Cadastro cadastro = new Cadastro();
               
                  cadastro.setId(Integer.parseInt((tabela.getValueAt(tabela.getSelectedRow(), 0).toString())));
                  
                  if(tabela.getValueAt(tabela.getSelectedRow(), 4).toString().length() == 11){
                	  cat.setSelectedIndex(0);
                  }else{
                	  if(tabela.getValueAt(tabela.getSelectedRow(), 4).toString().length() == 14){
                		  cat.setSelectedIndex(1);
                	  }else{
                		  if(tabela.getValueAt(tabela.getSelectedRow(), 4).toString().length() == 6){
                			  cat.setSelectedIndex(2);
                    	  }else{
                    		  if(tabela.getValueAt(tabela.getSelectedRow(), 4).toString().length() == 7){
                    			  cat.setSelectedIndex(3);
                        	  }else{
                        		  if(tabela.getValueAt(tabela.getSelectedRow(), 4).toString().equals("Apoio")){
                        			  cat.setSelectedIndex(4);
                            	  }else{
                            		  if(tabela.getValueAt(tabela.getSelectedRow(), 4).toString().length() == 9){
                            			  cat.setSelectedIndex(5);
                                  }else{
                                	  if(tabela.getValueAt(tabela.getSelectedRow(), 4).toString().length() == 16){
                            			  cat.setSelectedIndex(6);
                                  }else{
                                	  cat.setSelectedIndex(7);
                                  }
                                  }
                                }
                            }
                         }
                     }
                  }
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  if(tabela.getValueAt(tabela.getSelectedRow(), 3).toString().length() == 11){
                	  cargo.setSelectedIndex(0);
                  }else{
                	  if(tabela.getValueAt(tabela.getSelectedRow(), 3).toString().length() == 9){
                		  cargo.setSelectedIndex(1);
                	  }else{
                		  cargo.setSelectedIndex(2);
                         }
                     }
               
               } 
            
            } 
         }); 	
   
      // Acão quando for alterada a informação no JCOMBOBOX ...
      reg.addActionListener(this);
      
      reg.addActionListener (
         new ActionListener () {
            public void actionPerformed(ActionEvent e) {
               if(reg.getSelectedItem() == "Todos"){
                  PreencherJTableTodos(modelo);
               
               }
               else{
                  if(reg.getSelectedItem() == "Colaboradores"){
                     PreencherJTableColaboradores(modelo);
                  
                  }
                  else{
                     if(reg.getSelectedItem() == "Avaliadores"){
                        PreencherJTableAvaliadores(modelo);
                     }
                     else{
                        PreencherJTableSuperiores(modelo);
                     }
                  
                  }
               } 
            }
         });
   }

	
   public void actionPerformed(ActionEvent e) {
   
      if (e.getSource() == bntmeuperfil) {
         this.dispose();
         new telas.superior.TelaMeuPerfil().setVisible(true);  
      }
   
      if (e.getSource() == bnthistorico) {
         JOptionPane.showMessageDialog(null, "Você já está nesta página!"); 
      }
      if (e.getSource() == bntnovasugestao) {
         this.dispose();
         new telas.superior.TelaSuperiorRelatorio().setVisible(true);  
      }
   
      if (e.getSource() == bntsair) {
         this.dispose();
         new telas.TelaLogin().setVisible(true);  
      }
      if (e.getSource() == bntretornar) {
         this.dispose();
         new telas.superior.TelaPrincipal().setVisible(true);  
      }
      
      if (e.getSource() == bntexcluir) {
         int resposta = JOptionPane.showConfirmDialog(null, "Você deseja realmente excluir esse perfil?", null, JOptionPane.YES_NO_OPTION);
      
         if (resposta == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Perfil excluido com sucesso!");  
           
         } 
         else if (resposta == JOptionPane.NO_OPTION) {

         }
      
      } 
      if (e.getSource() == bntatu) {
    	  

               int resposta = JOptionPane.showConfirmDialog(null, "Você deseja realmente alterar esse perfil?", null, JOptionPane.YES_NO_OPTION);
               if (resposta == JOptionPane.YES_OPTION) {
               		
                  RegistroDAO dao = new RegistroDAO();
                  Registro re = Registro.getInstance();
               		
                  re.setID(Integer.parseInt(tabela.getValueAt(tabela.getSelectedRow(), 0).toString()));
                  re.setCargo(cargo.getSelectedItem().toString());
                  re.setCategoria(cat.getSelectedItem().toString());
                  dao.AlterarInformacoesDoPerfil();
                  if(reg.getSelectedItem() == "Todos"){
                     PreencherJTableTodos(modelo);
                  	
                  }
                  else{
                     if(reg.getSelectedItem() == "Colaboradores"){
                        PreencherJTableColaboradores(modelo);
                     	
                     }
                     else{
                        if(reg.getSelectedItem() == "Avaliadores"){
                           PreencherJTableAvaliadores(modelo);
                        }
                        else{
                           PreencherJTableSuperiores(modelo);
                        }
                     	
                     }
                  } 
               		
               		
               		
                  JOptionPane.showMessageDialog(null, "Perfil alterado com sucesso!"); 
               }
               else if (resposta == JOptionPane.NO_OPTION) {
               
               }
            
      }  
   
   }    
  
  
   public static void PreencherJTableTodos(DefaultTableModel modelo) {
   	
      modelo.setNumRows(0);
      CadastroDAO cadastro = new CadastroDAO();
   	
      for(Cadastro c: cadastro.CarregarCadastros()){
         modelo.addRow(new Object[]{
            	c.getId(),
            	c.getNome_Completo(),
            	c.getEmail(),
            	c.getCargo(),
            	c.getCategoria()});
      }
   }
   public static void PreencherJTableColaboradores(DefaultTableModel modelo) {
   	
      modelo.setNumRows(0);
      CadastroDAO cadastro = new CadastroDAO();
   	
      for(Cadastro c: cadastro.CarregarCadastrosColaborador()){
         modelo.addRow(new Object[]{
            	c.getId(),
            	c.getNome_Completo(),
            	c.getEmail(),
            	c.getCargo(),
            	c.getCategoria()});
      }
   }
			
			
   public static void PreencherJTableAvaliadores(DefaultTableModel modelo) {
   	
      modelo.setNumRows(0);
      CadastroDAO cadastro = new CadastroDAO();
   	
      for(Cadastro c: cadastro.CarregarCadastrosAvaliador()){
         modelo.addRow(new Object[]{
            	c.getId(),
            	c.getNome_Completo(),
            	c.getEmail(),
            	c.getCargo(),
            	c.getCategoria()});
      }
   }
			
   public static void PreencherJTableSuperiores(DefaultTableModel modelo) {
   	
      modelo.setNumRows(0);
      CadastroDAO cadastro = new CadastroDAO();
   	
      for(Cadastro c: cadastro.CarregarCadastrosSuperior()){
         modelo.addRow(new Object[]{
            	c.getId(),
            	c.getNome_Completo(),
            	c.getEmail(),
            	c.getCargo(),
            	c.getCategoria()});
      }
   }  
 
}
