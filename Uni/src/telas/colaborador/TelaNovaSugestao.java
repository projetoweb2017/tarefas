package telas.colaborador;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.Toolkit;




import javax.swing.event.*;
import javax.swing.text.*;

import banco.de.dados.DAO.LoginDAO;
import banco.de.dados.DAO.SugestaoDAO;
import banco.de.dados.Model.Login;
import banco.de.dados.Model.Sugestao;







public class TelaNovaSugestao extends JFrame implements ActionListener {

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









   private DefaultStyledDocument doc;//limite do txtArea
    private DefaultStyledDocument doco;//limite do txttitulo



   private JComboBox cat;
   private static final String[] names = {"","Infraestrutura","Cursos","Eventos","Apoio","Segurança","Sugestões Livres"};

	
		
   private JLabel lblnovasugestao,lbltitulo,lblsugestao,espaco;
	
   private JTextArea txasugestao;
   
   
   
   private JLabel remaningLabel = new JLabel();
   
   private JTextField txttitulo;
	
   private JButton bntenviar,bntlimpar;

   private JPanel jPanelMenu,jPanelNovaSugestao;
	
	
   public TelaNovaSugestao(){
      super("Uni - Nova Sugestão");
      
      
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
   
           	
   	
      bntenviar = new JButton("Enviar");
      bntlimpar = new JButton("Limpar");
   	
      jPanelMenu = new JPanel();
      jPanelNovaSugestao = new JPanel();
   
   					
     
      //labels
      
      lblnovasugestao = new JLabel("       Nova sugestão");
      lblnovasugestao.setFont(new Font("Arial", 1, 35)); 
      lblnovasugestao.setForeground(new Color(0, 102, 204));
   
      
            
      
      lblsugestao = new JLabel("Você deseja dar uma sugestão em qual categoria:");
      lblsugestao.setFont(new Font("Arial", 0, 15)); 
      lblsugestao.setForeground(new Color(0,0,0));
   
      lbltitulo = new JLabel(" Título: ");
   
   
      //txt 
      
      txttitulo = new JTextField(0);
   
      txasugestao = new JTextArea(6, 8);
      
      
      //barra
      
JScrollPane scroll = new JScrollPane(txasugestao);  
  
add(scroll);  
      
      //limite
      doc = new DefaultStyledDocument();
      doc.setDocumentFilter(new DocumentSizeFilter(500));
     
     
      doc.addDocumentListener(
         new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
               updateCount();
            }
         
            @Override
            public void insertUpdate(DocumentEvent e) {
               updateCount();
            }
         
            @Override
            public void removeUpdate(DocumentEvent e) {
               updateCount();
            }
         });
   
     
    //limite titulo
      doco = new DefaultStyledDocument();
      doco.setDocumentFilter(new DocumentSizeFilter(50));
     
     
      doco.addDocumentListener(
         new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
               updateCount();
            }
         
            @Override
            public void insertUpdate(DocumentEvent e) {
               updateCount();
            }
         
            @Override
            public void removeUpdate(DocumentEvent e) {
               updateCount();
            }
         });

   
   
   
      txasugestao.setDocument(doc);
      txttitulo.setDocument(doco);

        //insere o valor inicial restante
      updateCount();
   
   
   //fim limite
   

      //txasugestao.add(new JScrollPane(new JTextArea(6, 8)));
      txasugestao.setBorder(BorderFactory.createEtchedBorder());
      //JScrollPane scroll = new JScrollPane (txasugestao);
      scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      txasugestao.setLineWrap(true); // coloca limite  no lado horizontal e joga para outra linha txttitulo
      
   	
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
      bntlimpar.addActionListener(this);
      bntenviar.addActionListener(this);
   	
   	
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
      lblsugestao.setPreferredSize(new Dimension(330,50));
           
           
            
   
      jPanelNovaSugestao.add(cat);
      cat.setPreferredSize(new Dimension(150,30));
            
            
      jPanelNovaSugestao.add(lbltitulo);
      lbltitulo.setPreferredSize(new Dimension(530,30));
   
      jPanelNovaSugestao.add(txttitulo);
      txttitulo.setPreferredSize(new Dimension(530,30));
           
      jPanelNovaSugestao.add(scroll);
      scroll.setPreferredSize(new Dimension(530,200));
      jPanelNovaSugestao.add(remaningLabel);
   
      jPanelNovaSugestao.add(scroll);
   
   
   
   
   
   
           
                     
      jPanelNovaSugestao.add(bntlimpar);
      bntlimpar.setPreferredSize(new Dimension(130,30));
   
           
      jPanelNovaSugestao.add(bntenviar);
      bntenviar.setPreferredSize(new Dimension(130,30));
   
           
           
           
              
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //Padroes da tela
      setSize(840,620);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null); // deixa a posição da janela no meio
      setResizable(false);//Não deixa maximizar
      setVisible(true);
   }
   
   
   
   
   
   
   
   
   
   
   private void updateCount() {
      remaningLabel.setText((500 - doc.getLength()) + " Caracteres restantes");
   }

    //esta classe que faz a limitação de caracteres
   class DocumentSizeFilter extends DocumentFilter {
   
      int maxCharacters;
      boolean DEBUG = false;
   
      public DocumentSizeFilter(int maxChars) {
         maxCharacters = maxChars;
      }
   
      public void insertString(DocumentFilter.FilterBypass fb, int offs,
                String str, AttributeSet a)
                throws BadLocationException {
         if (DEBUG) {
            System.out.println("in DocumentSizeFilter's insertString method");
         }
      
            //Isto rejeita novas inserções de caracteres se
            //a string for muito grande. Outra opção seria
            //truncar a string inserida, de forma que seja
            //adicionado somente o necessário para atingir
            //o limite máximo permitido
         if((fb.getDocument().getLength() + str.length()) <= maxCharacters) {
            super.insertString(fb, offs, str, a);
         } 
         else {
            Toolkit.getDefaultToolkit().beep();
         }
      }
   
      public void replace(DocumentFilter.FilterBypass fb, int offs,
                int length,
                String str, AttributeSet a)
                throws BadLocationException {
         if (DEBUG) {
            System.out.println("in DocumentSizeFilter's replace method");
         }
            //Isto rejeita novas inserções de caracteres se
            //a string for muito grande. Outra opção seria
            //truncar a string inserida, de forma que seja
            //adicionado somente o necessário para atingir
            //o limite máximo permitido
         if((fb.getDocument().getLength() + str.length() - length) <= maxCharacters) {
            super.replace(fb, offs, length, str, a);
         } 
         else {
            Toolkit.getDefaultToolkit().beep();
         }
      }
   
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
         JOptionPane.showMessageDialog(null, "Você já está nesta página!");  
      }
      
      
      
      if (e.getSource() == bntretornar) {
         this.dispose();
         new telas.colaborador.TelaPrincipal().setVisible(true);  
      }
      
      
   	
      if (e.getSource() == bntsair) {
         this.dispose();
         new telas.TelaLogin().setVisible(true);  
      }
   	
      if (e.getSource() == bntlimpar) {
         txasugestao.setText("");
         txttitulo.setText("");
         cat.setSelectedItem("");
      }
      if (e.getSource() == bntenviar) {
         if(cat.getSelectedItem() == ""){
            JOptionPane.showMessageDialog(null, "Erro: Antes de enviar sua sugestão é necessario preencher a categoria dela.");
         	
         }
         else{
            if(txttitulo.getText().equals("")){
               JOptionPane.showMessageDialog(null, "Erro: Antes de enviar sua sugestão é necessario preencher um título.");
            }
            else{
               if(txasugestao.getText().equals("")){
                  JOptionPane.showMessageDialog(null, "Erro: Antes de enviar sua sugestão é necessario preencher com alguma ideia.");
               }
               else{
               	
                  Sugestao su = new Sugestao();
                  SugestaoDAO dao = new SugestaoDAO();
                  Login lo = Login.getInstance();
                     
                  su.setCategoria(cat.getSelectedItem().toString());
                  su.setTitulo(txttitulo.getText());
                  su.setTexto(txasugestao.getText());
                  su.setCadastro_ID(lo.getID());
                  su.setAutor(lo.getNome_Completo());
                     
                  dao.InserirSugestao(su);   
                     
                  this.dispose();
                  new telas.colaborador.TelaHistoricoDeSugestoes().setVisible(true);  
               }
            }
         }
      }
   			
   }
   
  
   
   
}
