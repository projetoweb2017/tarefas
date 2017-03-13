package telas.colaborador;

import javax.swing.*;

import banco.de.dados.DAO.SugestaoJTableDAO;
import banco.de.dados.Model.SugestoesJTable;

import java.awt.*;
import java.awt.event.*;


// Sugestão para o Historico do colaborador Status aguardando - 1
public class TelaSugestoesAguardandoColaborador extends JFrame implements ActionListener {


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





	
		
	private JLabel lblsugestaot,lbltitulo,lblautor,lbldata,espaco,espacoo;
	
	private JLabel lbltitulousuario,lbldatausuario,lblautorusuario;
	
	private JTextArea txasugestao;
	
	private JScrollPane scroll;
		
	//private JButton bntmeuperfil, bnthistorico, bntnovasugestao,bntsair,bntretornar; //menu
	
	private JPanel jPanelMenu,jPanelSugestao;
	
	
	public TelaSugestoesAguardandoColaborador(){
		super("Uni - Sugestão Aguardando");
         
		SugestoesJTable sugestao = SugestoesJTable.getInstance();
		
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

		
		//
		
		scroll = new JScrollPane();
		
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
   
   
}
