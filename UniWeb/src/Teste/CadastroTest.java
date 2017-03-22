package Teste;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import Model.Cadastro;
import Service.CadastroService;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CadastroTest {

	Cadastro cadastro, copia;
	CadastroService cadastroService;
	static int id = 0;

	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco nenhuma
	 * linha com o id igual ao do escolhido para o to instanciado abaixo. Se
	 * houver, delete. 
	 * Certifique-se também que sobrecarregou o equals na classe
	 * Cliente. 
	 * Certifique-se que a fixture cliente1 foi criada no banco.
	 * Além disso, a ordem de execução dos testes é importante; por
	 * isso a anotação FixMethodOrder logo acima do nome desta classe
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		cadastro = new Cadastro();
		
		cadastro.setNome_Completo("Luan Peixoto");
		cadastro.setData_de_Nascimento("01/01/2016");
		cadastro.setSexo("Masculino");
		cadastro.setCPF("010.101.010-10");
		cadastro.setRG("01.010.101-0");
		cadastro.setCEP("00000-000");
		cadastro.setEndereco("Rua.");
		cadastro.setNumero("00");
		cadastro.setComplemento("");
		cadastro.setBairro("Mooca");
		cadastro.setCidade("S�o Paulo");
		cadastro.setUF("SP");
		cadastro.setEmail("Admin@gmail.com");
		cadastro.setTelefone_Residencial("(  )     -    ");
		cadastro.setTelefone_Celular("(11) 00000-0000");
		cadastro.setUniversidade("Universidade Novo Intelecto");
		cadastro.setEnderecoUniversidade("Av. Brigadeiro Faria Lima, 2443 - Itaim Bibi");
		cadastro.setCurso("Analise e desenvolvimento de sistemas");
		cadastro.setUsuario("Luan");
		cadastro.setSenha("123456");
		cadastro.setPerguntaSecreta("Arroz");
		cadastro.setCargo("Colaborador");
		cadastro.setCategoria("Colaborador");

		
		
		copia = new Cadastro();
		copia.setNome_Completo("Luan Peixoto");
		copia.setData_de_Nascimento("01/01/2016");
		copia.setSexo("Masculino");
		copia.setCPF("010.101.010-10");
		copia.setRG("01.010.101-0");
		copia.setCEP("00000-000");
		copia.setEndereco("Rua.");
		copia.setNumero("00");
		copia.setComplemento("");
		copia.setBairro("Mooca");
		copia.setCidade("S�o Paulo");
		copia.setUF("SP");
		copia.setEmail("Admin@gmail.com");
		copia.setTelefone_Residencial("(  )     -    ");
		copia.setTelefone_Celular("(11) 00000-0000");
		copia.setUniversidade("Universidade Novo Intelecto");
		copia.setEnderecoUniversidade("Av. Brigadeiro Faria Lima, 2443 - Itaim Bibi");
		copia.setCurso("Analise e desenvolvimento de sistemas");
		copia.setUsuario("Luan");
		copia.setSenha("123456");
		copia.setPerguntaSecreta("Arroz");
		copia.setCargo("Colaborador");
		copia.setCategoria("Colaborador");
		
		cadastroService = new CadastroService();
		System.out.println(cadastro);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test
	public void test00Inserir() {
		System.out.println("Inserir Cadastro");
		
		Cadastro fixture = new Cadastro();
		fixture.setNome_Completo("Luan Peixoto");
		fixture.setData_de_Nascimento("01/01/2016");
		fixture.setSexo("Masculino");
		fixture.setCPF("010.101.010-10");
		fixture.setRG("01.010.101-0");
		fixture.setCEP("00000-000");
		fixture.setEndereco("Rua.");
		fixture.setNumero("00");
		fixture.setComplemento("");
		fixture.setBairro("Mooca");
		fixture.setCidade("S�o Paulo");
		fixture.setUF("SP");
		fixture.setEmail("Admin@gmail.com");
		fixture.setTelefone_Residencial("(  )     -    ");
		fixture.setTelefone_Celular("(11) 00000-0000");
		fixture.setUniversidade("Universidade Novo Intelecto");
		fixture.setEnderecoUniversidade("Av. Brigadeiro Faria Lima, 2443 - Itaim Bibi");
		fixture.setCurso("Analise e desenvolvimento de sistemas");
		fixture.setUsuario("Luan");
		fixture.setSenha("123456");
		fixture.setPerguntaSecreta("Arroz");
		fixture.setCargo("Colaborador");
		fixture.setCategoria("Colaborador");

		CadastroService novoService = new CadastroService();
		
		Cadastro novo = novoService.InserirCadastro(fixture);
		
		assertEquals("testa inclusao", novo, fixture);	

		
	}
	@Test
	public void test00checkUsuario(){
		System.out.println("Check Usuario");

		CadastroService novoService = new CadastroService();
			
		novoService.CheckUsuario("Azevedo");
		
		assertTrue("True se tiver o usuario no BD", true);
	}
	
	@Test
	public void test00checkEmail(){
		System.out.println("Check Email");

		CadastroService novoService = new CadastroService();
			
		novoService.CheckEmail("Admin@gmail.com");
		
		assertTrue("True se tiver o usuario no BD", true);
	}
	
}