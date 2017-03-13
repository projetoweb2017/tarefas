package telas;

import javax.swing.*;

import banco.de.dados.DAO.CadastroDAO;
import banco.de.dados.Model.Cadastro;

import java.awt.*;
import java.awt.event.*;

public class TelaCadastro extends JFrame implements ActionListener{
	
	
	
		
	
	
	//Caixa de seleção
   private JComboBox sexo,unis,curso;
	
   private static final String[] names = {"","Masculino","Feminino","Outros"};
	
   private static final String[] un = {"","Universidade Novo Intelecto"};
	
   private static final String[] cur = {"","Análise e desenvolvimento de sistemas","Banco de dados","Gestão da tecnologia da informação ","Redes de computadores","Sistemas de informações","Jogos digitais"};

	
   private JLabel lbcadastro,lbdados,lbnomec,lbdt,lbsexo,lbcpf,lbrg,lbcep,lbendereco,lbnumero,lbcomplemento,
   lbbairro,lbcidade,lbuf,lbdadosc,lbemail,lbtelr,lbtelc,lbdadosu,lbuni,lbenderecou,lbcurso,lbdadosca,
   lbusuario,lbsenha,lbcsenha,lbpergunta,esp,lbbranco,lbbrancoo,lbbrancooo;
	
   private JTextField txtnomec,txtdt,txtcpf,txtrg,txtcep,txtendereco,txtnumero,txtcomplemento,txtbairro,
   txtcidade,txtuf,txtemail,txttelefoner,txttelefonec,txtusuario,txtsenha,txtcsenha,txtenderecou,txtpergunta;

	
	
   private JButton bntverificar, bntlimpar, bntcadastrar,bntverificarc;
	
	
   private JPanel jPaneldado1,jPaneldados2,jPaneldados3;
   
   private boolean checknome = false;
   private boolean checknascimento = false;
   private boolean checksexo = false;
   private boolean checkcpf = false;
   private boolean checkrg = false;
   private boolean checkcep = false;
   private boolean checkendereco = false;
   private boolean checknumero = false;
   private boolean checkbairro = false;
   private boolean checkcidade = false;
   private boolean checkuf = false;
   private boolean checkemail = false;
   private boolean checktelr = false;
   private boolean checktelc = false;
   private boolean checktelefones = false;
   private boolean checkuniversidade = false;
   private boolean checkcurso = false;
   private boolean checkusuario = false;
   private boolean checkperguntasecreta = false;
   private boolean checksenha = false;
	
   private String ErroMSG;

	
	
	/*scron
	JLabel image = new JLabel(new ImageIcon(getClass().getResource("1.png")));
	JScrollPane scroll = new JScrollPane(image);
	*/
   public TelaCadastro(){
      super("Uni - Cadastro");
   	
   	
   	
   	
   	
   	
   	
   	
   	
      Color minhaCor = new Color(255,255,255	);
   
      getContentPane().setBackground(minhaCor);
   	
   	
   	
   	
   	//botoes
      bntverificarc = new JButton("Verificar");
      bntverificar = new JButton("Verificar");
      bntlimpar = new JButton(" Limpar");
      bntcadastrar = new JButton(" Cadastrar");
   	
   	
   	
      
      sexo = new JComboBox (names);
      sexo.setMaximumRowCount(4);
   	
   	
      unis = new JComboBox (un);
      unis.setMaximumRowCount(2);
   	
   	
      curso = new JComboBox (cur);
      curso.setMaximumRowCount(7);
   	
   	
   	
   	
   	//Labels
      lbcadastro = new JLabel("o ");
      lbcadastro.setFont(new Font("Arial", 1, 55)); 
      lbcadastro.setForeground(new Color(255,255,255));
   	
      lbbranco = new JLabel("Cadastro");
      lbbranco.setFont(new Font("Arial", 1, 32)); 
      lbbranco.setForeground(new Color(105,105,105));
   	
      lbbrancoo = new JLabel("o        ");
      lbbrancoo.setFont(new Font("Arial", 0, 37)); 
      lbbrancoo.setForeground(new Color(255,255,255));
   	
      lbbrancooo = new JLabel("o                                                              ");
      lbbrancooo.setFont(new Font("Arial", 0, 10 )); 
      lbbrancooo.setForeground(new Color(255,255,255));
   
   	
   	
      lbdados = new JLabel("                  Dados pessoais");
      lbdados.setFont(new Font("Arial", 1, 20)); 
      lbdados.setForeground(new Color(30,144,255));
   	
   	
      lbnomec = new JLabel ("Nome completo");
      lbdt = new JLabel ("    Data de nacimento");
      lbsexo = new JLabel ("Sexo");
      lbcpf = new JLabel ("CPF");
      lbrg = new JLabel ("RG");
      lbcep = new JLabel("      CEP");
      lbendereco = new JLabel ("Endereço");
      lbnumero = new JLabel("Numero");
      lbcomplemento = new JLabel ("Complemento");
      lbbairro = new JLabel ("Bairro");
      lbcidade = new JLabel ("Cidade");
      lbuf = new JLabel("UF");
   	
   	
      lbdadosc = new JLabel("  Dados para contato");
      lbdadosc.setFont(new Font("Arial", 1, 20)); 
      lbdadosc.setForeground(new Color(30,144,255));
   	
   	
      lbemail = new JLabel ("E-mail");
      lbtelr = new JLabel("Telefone residencial");
      lbtelc = new JLabel ("Telefone celular");
   	
   	
   	
      lbdadosu = new JLabel ("Dados universitarios");
      lbdadosu.setFont(new Font("Arial", 1, 20)); 
      lbdadosu.setForeground(new Color(30,144,255));
   	
   	
   	
   	
      lbuni = new JLabel (" Universidade");
      lbenderecou = new JLabel("Endereço");
      lbcurso = new JLabel ("Curso");
   	
   	
      lbdadosca = new JLabel ("Dados para cadastro");
      lbdadosca.setFont(new Font("Arial", 1, 20)); 
      lbdadosca.setForeground(new Color(30,144,255));
   	
   	
   	
      lbusuario = new JLabel ("Usuario");
      lbsenha = new JLabel ("Senha");
      lbcsenha = new JLabel ("Confirmar senha");
      lbpergunta = new JLabel ("Pergunta secreta: ");
   	
      esp = new JLabel(" ");
      
      
   	//caixas de textos
   	
      txtnomec = new JTextField(0);
   	
   	
   	 
   	
      txtendereco = new JTextField(0);
      txtnumero = new JTextField(0);
      txtcomplemento = new JTextField(0);
      txtbairro = new JTextField(0);
      txtcidade = new JTextField(0);
      txtuf = new JTextField(0);
      txtemail = new JTextField(0);
   	 
   	
      txtusuario = new JTextField(0);
      txtsenha = new JPasswordField(0);
      txtcsenha = new JPasswordField(0);
      txtenderecou = new JTextField(0);
      txtpergunta = new JTextField(" Qual é a sua comida favorita?",0);
   	
      
      
      
      
      
      jPaneldado1 = new JPanel();
      jPaneldados2 = new JPanel();
      jPaneldados3 = new JPanel();
      
      
      
      
      Container caixa = getContentPane();
   
      
      caixa.setLayout(new BorderLayout());
   	
      caixa.add(jPaneldado1, BorderLayout.WEST);
      caixa.add(jPaneldados2, BorderLayout.EAST);
      caixa.add(jPaneldados3, BorderLayout.CENTER);
      
      
      
      
      
      jPaneldado1.setBackground(new java.awt.Color(255,255,255));
      jPaneldado1.setPreferredSize(new Dimension(300,800));//tamanha do painel
      jPaneldado1.setLayout(new FlowLayout());
      
      
      
      jPaneldado1.add(lbcadastro);
           
      
      
      
      jPaneldado1.add(lbdados);
      lbdados.setPreferredSize(new Dimension(350,40));     
      
      
      
      
      
      jPaneldado1.add(lbnomec);
      jPaneldado1.add(txtnomec);
      lbnomec.setPreferredSize(new Dimension(270,30));
      txtnomec.setPreferredSize(new Dimension(270,30));
      
                 
     
     
      jPaneldado1.add(lbdt);
      lbdt.setPreferredSize(new Dimension(140,30));
      
      jPaneldado1.add(lbsexo);
      lbsexo.setPreferredSize(new Dimension(150,30));
       
            //mascara data de nacimento
      try{ 
         javax.swing.text.MaskFormatter dt= new javax.swing.text.MaskFormatter("##/##/####");
         txtdt = new javax.swing.JFormattedTextField(dt);
      }
      catch (Exception e){
      }
   
      
      jPaneldado1.add(txtdt);
      txtdt.setPreferredSize(new Dimension(130,30));
      
     
            
      
      
      jPaneldado1.add(sexo);
      sexo.setPreferredSize(new Dimension(130,30));
   
      
      
      
      
       
      jPaneldado1.add(lbcpf);
      //mascara cpf
      try{ 
         javax.swing.text.MaskFormatter cpf= new javax.swing.text.MaskFormatter("###.###.###-##");
         txtcpf = new javax.swing.JFormattedTextField(cpf);
      }
      catch (Exception e){
      }
      lbcpf.setPreferredSize(new Dimension(130,30));
        
      jPaneldado1.add(lbrg);
      lbrg.setPreferredSize(new Dimension(130,30));
        
      txtcpf.setPreferredSize(new Dimension(130,30));
        
        
        
      jPaneldado1.add(txtcpf); 
      txtcpf.setPreferredSize(new Dimension(130,30));
     
   
        
        
        
        
       
      
      //mascara RG
      try{ 
         javax.swing.text.MaskFormatter rg= new javax.swing.text.MaskFormatter("##.###.###-#");
         txtrg = new javax.swing.JFormattedTextField(rg);
      }
      catch (Exception e){
      }
   
      jPaneldado1.add(txtrg);
      txtrg.setPreferredSize(new Dimension(130,30));
      
      
      
      
      
      
      
         
      jPaneldado1.add(lbcep);
      lbcep.setPreferredSize(new Dimension(300,30));
      //mascara cep
      try{ 
         javax.swing.text.MaskFormatter cep= new javax.swing.text.MaskFormatter("#####-###");
         txtcep = new javax.swing.JFormattedTextField(cep);
      }
      catch (Exception e){
      }
      jPaneldado1.add(txtcep);
      txtcep.setPreferredSize(new Dimension(130,30));
   
      jPaneldado1.add(bntverificar);  
      bntverificar.setPreferredSize(new Dimension(130,30));  
      
      
      
      
      
      
      jPaneldado1.add(lbendereco);
      lbendereco.setPreferredSize(new Dimension(130,30));
   
      
      jPaneldado1.add(lbnumero);
      lbnumero.setPreferredSize(new Dimension(130,30));
   
      
      jPaneldado1.add(txtendereco);
      txtendereco.setPreferredSize(new Dimension(130,30));
      
      
      
      
      jPaneldado1.add(txtnumero);
      txtnumero.setPreferredSize(new Dimension(130,30));
   
      
      
      
      
      
      
      
      
   
      jPaneldado1.add(lbcomplemento);
      lbcomplemento.setPreferredSize(new Dimension(130,30));
   
      jPaneldado1.add(lbbairro);
      lbbairro.setPreferredSize(new Dimension(130,30));
   
   
      jPaneldado1.add(txtcomplemento);
      txtcomplemento.setPreferredSize(new Dimension(130,30));
   
      
      jPaneldado1.add(txtbairro);
      txtbairro.setPreferredSize(new Dimension(130,30));
   
      
      
      
      
      jPaneldado1.add(lbcidade);
      lbcidade.setPreferredSize(new Dimension(130,30));
      
      jPaneldado1.add(lbuf);
      lbuf.setPreferredSize(new Dimension(130,30));
      
      
      jPaneldado1.add(txtcidade);
      txtcidade.setPreferredSize(new Dimension(130,30));
   
      
      
      
      jPaneldado1.add(txtuf);
      txtuf.setPreferredSize(new Dimension(130,30));
   
            
      
      
      
      
      
      
      
      //Segundo painel
      
      jPaneldados2.setBackground(new java.awt.Color(255,255,255));
      jPaneldados2.setPreferredSize(new Dimension(300,800));//tamanha do painel
      jPaneldados2.setLayout(new FlowLayout());
   
      jPaneldados2.add(lbbranco);
      
      jPaneldados2.add(lbdadosc);
      lbdadosc.setPreferredSize(new Dimension(200,96));
   
      
      jPaneldados2.add(lbemail);
      jPaneldados2.add(txtemail);
      lbemail.setPreferredSize(new Dimension(270,20));
      txtemail.setPreferredSize(new Dimension(270,30));
      
      
      
      jPaneldados2.add(lbtelr);
      lbtelr.setPreferredSize(new Dimension(130,30));
      
      
      jPaneldados2.add(lbtelc);
      lbtelc.setPreferredSize(new Dimension(130,30));
   
      
      
      
      //mascara telefone res
      try{ 
         javax.swing.text.MaskFormatter telr= new javax.swing.text.MaskFormatter("(##) ####-####");
         txttelefoner = new javax.swing.JFormattedTextField(telr);
      }
      catch (Exception e){
      }
   			
      jPaneldados2.add(txttelefoner);
      txttelefoner.setPreferredSize(new Dimension(130,30));
   
            
            
            
   			
   			//mascara telefone cel
      try{ 
         javax.swing.text.MaskFormatter telc= new javax.swing.text.MaskFormatter("(##) #####-####");
         txttelefonec = new javax.swing.JFormattedTextField(telc);
      }
      catch (Exception e){
      }
   	
   
      jPaneldados2.add(txttelefonec);
      txttelefonec.setPreferredSize(new Dimension(130,30));
   
             
   
        
        
        
        
      jPaneldados2.add(lbdadosu);
      lbdadosu.setPreferredSize(new Dimension(200,65));    
   
      
            
      jPaneldados2.add(lbuni);
      lbuni.setPreferredSize(new Dimension(270,30));
      
      jPaneldados2.add(unis);
      unis.setPreferredSize(new Dimension(270,30));
   
      
      
      jPaneldados2.add(lbcurso);
      lbcurso.setPreferredSize(new Dimension(270,30));
      
      jPaneldados2.add(curso);
      curso.setPreferredSize(new Dimension(270,30));
   
   
      
      
      jPaneldados2.add(lbenderecou);
      lbenderecou.setPreferredSize(new Dimension(270,30));
      
      jPaneldados2.add(txtenderecou);
      txtenderecou.setPreferredSize(new Dimension(270,30));
   
      
      
      
      
      
      //Terceiro painel
      
      jPaneldados3.setBackground(new java.awt.Color(255,255,255));
      jPaneldados3.setPreferredSize(new Dimension(300,800));//tamanha do painel
      jPaneldados3.setLayout(new FlowLayout());
   
      
      jPaneldados3.add(lbbrancoo);
      jPaneldados3.add(lbdadosca);
      lbdadosca.setPreferredSize(new Dimension(200,86));
   
      
      jPaneldados3.add(lbusuario);
      lbusuario.setPreferredSize(new Dimension(270,30));
      
      jPaneldados3.add(txtusuario);
      txtusuario.setPreferredSize(new Dimension(270,30));
      
      
      
      
      jPaneldados3.add(lbsenha);
      lbsenha.setPreferredSize(new Dimension(270,30));
      
      jPaneldados3.add(txtsenha);
      txtsenha.setPreferredSize(new Dimension(270,30));
   
      
      
      
      
      jPaneldados3.add(lbcsenha);
      lbcsenha.setPreferredSize(new Dimension(270,30));
      
      jPaneldados3.add(txtcsenha);
      txtcsenha.setPreferredSize(new Dimension(270,30));
   
      
      jPaneldados3.add(bntverificarc);
      bntverificarc.setPreferredSize(new Dimension(130,30));
   
      
      jPaneldados3.add(lbpergunta);
      lbpergunta.setPreferredSize(new Dimension(270,30));
      
   
      jPaneldados3.add(txtpergunta);
      txtpergunta.setPreferredSize(new Dimension(270,30));
   
      jPaneldados3.add(lbbrancooo);
      
      jPaneldados3.add(bntlimpar);
      bntlimpar.setPreferredSize(new Dimension(130,30));
      
      jPaneldados3.add(bntcadastrar);
      bntcadastrar.setPreferredSize(new Dimension(130,30));
      
      
      
      
      
      
   
   	//Adicionando os elementos
      caixa.setLayout(new FlowLayout());
           
   	
   			
   	
   	
   			
   	
   			
   	
   					
   			
   			
   					
   	
   	
   	//Adicionandos os labels
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   					
   			
   	
   	
   	
   
   	
   	//Adicionando as caixas de textos
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	
   			
   	//caixa.add(scroll);
   	
   	
   	//Posiçoes dos labels
   	
   	
   	
   	
   	//Scron
   	//scroll.setBounds(0,0,800,1500);
   	
   	
   			
   	
   	
   	//posicionamento das caixas de textos
   			
   	//Ações
   			
      bntverificar.addActionListener(this);
      bntverificarc.addActionListener(this);
      bntlimpar.addActionListener(this);
      bntcadastrar.addActionListener(this);
      unis.addActionListener(this);
   	
   	
      txtpergunta.addMouseListener(
         new MouseAdapter()  
         {  
            public void mouseClicked(MouseEvent e){
               txtpergunta.setText("");
            
            } 
         }); 
   	
      setSize(1000,700);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      setResizable(false);//Não deixa maximizar
      setVisible(true);
   	
   	
   	
   }
	
   public void buscaCep() {
        //Faz a busca para o cep
      WebServiceCep webServiceCep = WebServiceCep.searchCep(txtcep.getText());
   
   
        //caso a busca ocorra bem, imprime os resultados.
      if (webServiceCep.wasSuccessful()) {
         txtendereco.setText(webServiceCep.getLogradouroFull());
         txtcidade.setText(webServiceCep.getCidade());
         txtbairro.setText(webServiceCep.getBairro());
         txtuf.setText(webServiceCep.getUf());
      
      } 
      else {
         JOptionPane.showMessageDialog(null, "Erro: O CEP digitado" + " " + webServiceCep.getResultText());
      }
   }
	 
   public void actionPerformed(ActionEvent e) {
   	
   	
   	// Botão Limpar
      if (e.getSource() == bntlimpar) {
      	
         txtnomec.setText("");
         txtdt.setText("");
         curso.setSelectedItem("");
         txtcpf.setText("");
         txtrg.setText("");
         txtcep.setText("");
         txtendereco.setText("");
         txtnumero.setText("");
         txtcomplemento.setText("");
         txtbairro.setText("");
         txtcidade.setText("");
         txtuf.setText("");
         txtemail.setText("");
         txttelefoner.setText("");
         txttelefonec.setText("");
         unis.setSelectedItem("");
         txtenderecou.setText("");
         txtusuario.setText("");
         txtsenha.setText("");
         txtcsenha.setText("");
         txtpergunta.setText(" Qual é a sua comida favorita?");
         sexo.setSelectedItem("");
         txtcpf.setText("");
      }
      if(e.getSource() == unis){
         if(unis.getSelectedItem() == "Universidade Novo Intelecto"){
            txtenderecou.setText(" Av. Brigadeiro Faria Lima, 2443 - Itaim Bibi");
         }
         else{
            txtenderecou.setText("");
         }
      }
   	//Botão - Verificar CEP 
      if (e.getSource() == bntverificar) {
         buscaCep();
      }
   	
   	//Botão - Verificar Senha
      if (e.getSource() == bntverificarc) {
         if(txtsenha.getText().length() < 6){
            JOptionPane.showMessageDialog(null,"A sua senha precisa ter no mínimo 6 caracteres!");
         }
         else{
            if(txtsenha.getText().equals(txtcsenha.getText())){
               JOptionPane.showMessageDialog(null,"                       Ok," + "\n Você digitou a mesma senha!");
               checksenha = true;
            }
            else{
               JOptionPane.showMessageDialog(null,"Você digitou uma senha diferente da outra, tente novamente");
               txtsenha.setText("");
               txtcsenha.setText("");
                  
            }
         }
      }
   	//Botão - Cadastrar
      if (e.getSource() == bntcadastrar) {	
      	
         CadastroDAO checar = new CadastroDAO();
      	
      	
      	 // Nome
         if(txtnomec.getText().equals("")){
            ErroMSG = "Você não digitou o seu Nome!";
         }
         else{
            checknome = true;
         }
      		
           //Data de Nascimento
         if(txtdt.getText().equals("  /  /    ")){
            ErroMSG = "Você não digitou a sua Data de Nascimento!";
         }
         else{
            checknascimento = true;
         }
      	
      	 // Sexo
         if(sexo.getSelectedItem() == "Masculino" || sexo.getSelectedItem() == "Feminino" || sexo.getSelectedItem() == "Outros"){
            checksexo = true;
         }
         else{
            ErroMSG = "Você não selecionou o seu Sexo!";
         }
      	
      	  //CPF
         if(txtcpf.getText().equals("   .   .   -  ")){
            ErroMSG = "Você não digitou o seu CPF!";
         }
         else{
            checkcpf = true;
         }
      			
      	      //RG
         if(txtrg.getText().equals("  .   .   - ")){
            ErroMSG = "Você não digitou o seu RG!";
         }
         else{
            checkrg = true;
         }	
      			
      		
         	 //CEP
         if(txtcep.getText().equals("     -   ")){
            ErroMSG = "Você não digitou o seu CEP!";
         }
         else{
            checkcep = true;
         }				
      	// Endereço
         if(txtendereco.getText().equals("")){
            ErroMSG = "Você não digitou o seu Endereço!";
         }
         else{
            checkendereco = true;
         }
      			
      							
      	// Numero
         if(txtnumero.getText().equals("")){
            ErroMSG = "Você não digitou o Número do seu endereço!";
         }
         else{
            checknumero = true;
         }					
         // Bairro
         if(txtbairro.getText().equals("")){
            ErroMSG = "Você não digitou o seu Bairro!";
         }
         else{
            checkbairro = true;
         }						
        // Cidade
         if(txtcidade.getText().equals("")){
            ErroMSG = "Você não digitou a sua Cidade!";
         }
         else{
            checkcidade = true;
         }					
        // UF
         if(txtuf.getText().equals("")){
            ErroMSG = "Você não digitou a sua UF!";
         }
         else{
            checkuf = true;
         }				
       
      			
        // Email 
         if(txtemail.getText().equals("")){
            ErroMSG = "Você não digitou um Email!";					
         }
         else{
            if(checar.CheckEmail(txtemail.getText())){
               checkemail = false;
               ErroMSG = "O E-mail digitado já está cadastrado, utilize um diferente!";	
            }
            else{
               checkemail = true;
            }
         }	
      				
      //Telefone Residencial
         if(txttelefoner.getText().equals("(  )     -    ")){
            checktelr = false;
         }
         else{
            checktelr = true;
         }						
      			
      //Telefone Celular
         if(txttelefonec.getText().equals("(  )      -    ")){
            checktelc = false;
         }
         else{
            checktelc = true;
         }	
       //Telefones
         if(checktelr == false && checktelc == false){
            checktelefones = false;
            ErroMSG = "Você precisa deixar pelo menos um telefone para contato!";
         }
         else{
            checktelefones = true;
         }
      			
      			
      		
      // Universidade			
         if(unis.getSelectedItem() == "Universidade Novo Intelecto"){
            checkuniversidade = true;
         }
         else{
            ErroMSG = "Você não selecionou a sua Universidade!";		
         }				
      // Curso			
         if(curso.getSelectedItem() == ""){
            checkcurso = false;
            ErroMSG = "Você não selecionou o seu Curso!";	
         }
         else{
            checkcurso = true;		
         }	
      // Usuario 
         if(txtusuario.getText().equals("")){
            ErroMSG = "Você não digitou um Usuário!";					
         }
         else{
            if(checar.CheckUsuario(txtusuario.getText())){
               checkusuario = false;
               ErroMSG = "O Usuário digitado já está cadastrado, utilize um diferente!";	
            }
            else{
               checkusuario = true;
            }
         }
       // Pergunta Secreta
         if(txtpergunta.getText().equals("") || txtpergunta.getText().equals(" ") || txtpergunta.getText().equals("   ") || txtpergunta.getText().equals("    ") || txtpergunta.getText().equals("     ") || txtpergunta.getText().equals("      ") || txtpergunta.getText().equals("       ") || txtpergunta.getText().equals(" Qual é a sua comida favorita?")){
            ErroMSG = "Você não digitou uma Pergunta Secreta!";
         }
         else{
            checkperguntasecreta = true;
         }
      									
      			
      // Verificar senha
         if(checksenha == false){
            ErroMSG = "Você não verificou a sua senha!";
         }
      
       // Ver se tudo está suave = true
         if(checknome == true && checknascimento == true && checksexo == true && checkcpf == true && checkrg == true &&
         	 checkcep == true && checkendereco == true && checknumero == true && checkbairro == true && checkcidade == true &&
         	 checkuf == true && checkemail == true && checktelefones == true && checkuniversidade == true && checkcurso == true &&
         	 checkusuario == true && checkperguntasecreta == true && checksenha == true){
         
         
            Cadastro ca = new Cadastro();
            CadastroDAO dao = new CadastroDAO();
               
            ca.setNome_Completo(txtnomec.getText());
            ca.setData_de_Nascimento(txtdt.getText());
            ca.setSexo(sexo.getSelectedItem().toString());
            ca.setCPF(txtcpf.getText());
            ca.setRG(txtrg.getText());
            ca.setCEP(txtcep.getText());
            ca.setEndereco(txtendereco.getText());
            ca.setNumero(txtnumero.getText());
            ca.setComplemento(txtcomplemento.getText());
            ca.setBairro(txtbairro.getText());
            ca.setCidade(txtcidade.getText());
            ca.setUF(txtuf.getText());
            ca.setEmail(txtemail.getText());
            ca.setTelefone_Residencial(txttelefoner.getText());
            ca.setTelefone_Celular(txttelefonec.getText());
            ca.setUniversidade(unis.getSelectedItem().toString());
            ca.setEnderecoUniversidade(txtenderecou.getText());
            ca.setCurso(curso.getSelectedItem().toString());
            ca.setUsuario(txtusuario.getText());
            ca.setSenha(txtsenha.getText());
            ca.setPerguntaSecreta(txtpergunta.getText());  
               
            dao.InserirCadastro(ca);   
               
            setVisible(false);
            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
         	 
         }
         else{
            JOptionPane.showMessageDialog(null,"Desculpe, o seu cadastro não foi realizado com sucesso!" + "\nMotivo: " + ErroMSG);
         }
      }
   }
}		 	               
