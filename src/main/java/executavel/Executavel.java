package executavel;

import java.util.ArrayList;
import java.util.Random;

import model.dao.ClienteDAO;
import model.dao.EnderecoDAO;
import model.dao.TelefoneDAO;
import model.entity.Cliente;
import model.entity.Endereco;
import model.entity.Telefone;

public class Executavel {
	
	private static final String CODIGO_PAIS_BRASIL = "55";

	public static void main(String[] args) {
		
		criarEndereco();
		
		salvarNovoCliente();
		
	}
		
	private static void salvarNovoCliente() {
		Cliente c = new Cliente ("João", "da Silva Sauro", "55577788811", criarTelefones(), criarEndereco());
		ClienteDAO cliDAO = new ClienteDAO();
		c = cliDAO.salvar(c);
		
		if (c.getId() > 0) {
			System.out.println("Cliente salvo com sucesso. ID: " + c.getId());
			System.out.println("************* Telefones do cliente *************");
			System.out.println("");
			for(Telefone t: c.getTelefones()) {
				System.out.println(t);
			}
			System.out.println("");
			System.out.println("**********************************************");
		} else {
			System.out.println("Não salvou cliente");
		}	
	}
	
	private static void consultarEnderecos() {
		EnderecoDAO endDAO = new EnderecoDAO();
		System.out.println("************* Todos os endereços *************");
		System.out.println("");
		ArrayList<Endereco> todosOsEnderecos = endDAO.consultarTodos();
		
		for (Endereco e : todosOsEnderecos) {
			System.out.println(e);
		}
		System.out.println("");
		System.out.println("**********************************************");
	}
	
	private static void consultarEndereco(int id) {
		EnderecoDAO endDAO = new EnderecoDAO();
		Endereco enderecoConsultado = endDAO.consultarPorId(id);
		
		System.out.println(enderecoConsultado);
	}
	
	private static void atualizarEndereco() {
		Endereco enderecoQueSeraAtualizado = new Endereco ("Rua Nova", "88032000", "PR", "Curitiba", "Centro", "10");
		enderecoQueSeraAtualizado.setId(2);
		
		EnderecoDAO endDAO = new EnderecoDAO();
		
		if (endDAO.alterar(enderecoQueSeraAtualizado)) {
			System.out.println("Alterou endereço");
		} else {
			System.out.println("Não alterou endereço");
		}
	}
	
	private static void excluirEndereco(int id) {
		EnderecoDAO endDAO = new EnderecoDAO();

		if (endDAO.excluir(id)) {
			System.out.println("Excluiu endereÃ§o " + id);
		} else {
			System.out.println("NÃ£o excluiu endereÃ§o " + id);
		}
	}
	
	private static void consultarTelefones() {
		TelefoneDAO telefoneDAO = new TelefoneDAO();
		System.out.println(telefoneDAO.consultarPorId(2));
		System.out.println("");
		System.out.println("************* Todos os telefones *************");
		ArrayList<Telefone> todosOsTelefones = telefoneDAO.consultarTodos();

		for (Telefone t : todosOsTelefones) {
			System.out.println(t);
		}
		System.out.println("");
		System.out.println("**********************************************");
	}

	private static void atualizarTelefone() {
		TelefoneDAO telefoneDAO = new TelefoneDAO();
		Telefone telefoneQueSeraAtualizado = new Telefone(2, null, "88", "66", "1232-3211", "MÃ³vel", false);
		if (telefoneDAO.alterar(telefoneQueSeraAtualizado)) {
			System.out.println("Alterou");
		} else {
			System.out.println("NÃ£o alterou");
		}
	}
	
	private static void excluirTelefone() {
		TelefoneDAO telefoneDAO = new TelefoneDAO();
		if (telefoneDAO.excluir(3)) {
			System.out.println("Excluiu");	
		} else {
			System.out.println("Não excluiu");
		}
	}
	
	private static void salvarTelefoneAleatorios() {
		TelefoneDAO telefoneDAO = new TelefoneDAO();
		ArrayList<Telefone> telefones = criarTelefones();

		for (Telefone t : telefones) {
			telefoneDAO.salvar(t);
		}
	}
	
	private static void criarClientesMostrarNoConsole() {
		Endereco endereco1 = new Endereco("Mauro Ramos", "88000-123", "SC", "FlorianÃ³polis", "Centro", "10A");

		ArrayList<Telefone> telefonesCliente1 = new ArrayList<Telefone>();
		Telefone tel1 = new Telefone(0, null, "55", "048", "2020-5555", "Fixa", true);
		Cliente cliente1 = new Cliente ("Tiago", "037.803.449-22", "Souza Garcia",criarTelefones(), endereco1);
		Cliente cliente2 = new Cliente ("Altieste", "048.804.449-22", "Carlos Schmidt",criarTelefones(), endereco1);
		Cliente cliente3 = new Cliente ("Gabriel", "059.805.449-22", "dos Santos",criarTelefones(), endereco1);
		Cliente cliente4 = new Cliente ("Demetrio", "060.806.449-22", "da Silva Sauro",criarTelefones(), endereco1);
		Cliente cliente5 = new Cliente ("Esteve", "061.807.449-22", "Wonderman",criarTelefones(), endereco1);
		Cliente cliente6 = new Cliente("Edson", "Arantes do Nascimento", "010.010.100-10", telefonesCliente1,
				endereco1);
		Cliente cliente7 = new Cliente("Artur", "Antunes Coimbra", "000.000.100-10", criarTelefones(), endereco1);
		Cliente cliente8 = new Cliente("Manoel", "dos Santos", "777.010.100-10", criarTelefones(), endereco1);
		Cliente cliente9 = new Cliente("Roberto", "Rivellino", "011.010.100-10", criarTelefones(), endereco1);
		Cliente cliente10 = new Cliente("Eduardo", "GonÃ§alves de Andrade", "009.010.100-10", criarTelefones(),
				endereco1);
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(cliente1);
		clientes.add(cliente2);
		clientes.add(cliente3);
		clientes.add(cliente4);
		clientes.add(cliente5);
		clientes.add(cliente6);
		clientes.add(cliente7);
		clientes.add(cliente8);
		clientes.add(cliente9);
		clientes.add(cliente10);
		
		for (Cliente c : clientes) {
			System.out.println("************************************************************************************");
			System.out.println(c);
		}
		System.out.println("************************************************************************************");

		// TODO exercÃ­cio 2 -> salvar os clientes no banco
	}
	
	private static Endereco criarEndereco() {
		Random ran = new Random();
		String cep = "" + ran.nextInt(10) + ran.nextInt(10) + ran.nextInt(10) + ran.nextInt(10) + ran.nextInt(10)
		+ ran.nextInt(10) + ran.nextInt(10) + ran.nextInt(10);
		
		String numero = "" + ran.nextInt(1000);
		Endereco novoEndereco = new Endereco ("Novo endereço " + ran.nextInt(100), cep, "SC", "Florianópolis", "Centro",
				numero);
		
		EnderecoDAO dao = new EnderecoDAO();
		novoEndereco = dao.salvar(novoEndereco);
		
		return novoEndereco;
	}
	
	private static ArrayList <Telefone> criarTelefones () { 
		ArrayList <Telefone> telefones = new ArrayList<Telefone>();
		telefones.add(new Telefone(0, null, CODIGO_PAIS_BRASIL, criarDdd(), criarNumeroTelefone(), "Fixa", true));
		telefones.add(new Telefone(0, null, CODIGO_PAIS_BRASIL, criarDdd(), criarNumeroTelefone(), "Fixa", true));
		telefones.add(new Telefone(0, null, CODIGO_PAIS_BRASIL, criarDdd(), criarNumeroTelefone(), "MÃ³vel", true));

		return telefones;
		
	}

	private static String criarDdd() {
		Random ran = new Random();
		return "" + ran.nextInt(10) + ran.nextInt(10);
	}
	

	private static String criarNumeroTelefone() {
		Random ran = new Random();
		String prefixo = "" + ran.nextInt(10) + ran.nextInt(10) + ran.nextInt(10) + ran.nextInt(10);
		String ramal = "" + ran.nextInt(10) + ran.nextInt(10) + ran.nextInt(10) + ran.nextInt(10);
		
		return prefixo + "-" + ramal;
	}
}
	
	
	
