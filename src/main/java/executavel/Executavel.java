package executavel;

import java.util.ArrayList;

import model.entity.Cliente;
import model.entity.Endereco;
import model.entity.Telefone;

public class Executavel {

	public static void main(String[] args) {
		
		ArrayList<Telefone> telefones = new ArrayList<Telefone>();
		
		
		
		Endereco endereco1 = new Endereco ("Rua Augusta", "91.469-240", "SP", "São Paulo", "110","Mooca");
		Endereco endereco2 = new Endereco ("Rua Bruna", "92.469-240", "SC", "São José", "220","Kobrasol");
		Endereco endereco3 = new Endereco ("Rua Carla", "93.469-240", "SC", "São José", "330","Campinas");
		Endereco endereco4 =  new Endereco ("Rua Dalma", "94.469-240", "SC", "Florianopolis", "440","Centro");
		Endereco endereco5 =  new Endereco ("Rua Rogeria", "95.469-240", "SC", "Florianopolis", "550","Capoeiras");
		
		Cliente cliente1 = new Cliente ("Tiago", "037.803.449-22", telefones,"Souza Garcia", endereco1);
		Cliente cliente2 = new Cliente ("Altieste", "048.804.449-22", telefones,"Carlos Schmidt", endereco2);
		Cliente cliente3 = new Cliente ("Gabriel", "059.805.449-22", telefones,"dos Santos", endereco3);
		Cliente cliente4 = new Cliente ("Demetrio", "060.806.449-22", telefones,"da Silva Sauro", endereco4);
		Cliente cliente5 = new Cliente ("Esteve", "061.807.449-22", telefones,"Wonderman", endereco5);
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		clientes.add(cliente1);
		clientes.add(cliente2);
		clientes.add(cliente3);
		clientes.add(cliente4);
		clientes.add(cliente5);
		
		
		for (Cliente c : clientes) {
			System.out.println("*************************************************************************************");
			System.out.println(c);
			
		}
		
		System.out.println("*************************************************************************************");	
	}
	
	private static ArrayList <telefone> criarTelefones ();
	telefones.add(new Telefone("55", "048", "2424-6969", "Fixo", true));
	telefones.add(new Telefone("55", "048", "2424-6969", "Fixo", true));
	telefones.add(new Telefone("55", "048", "2424-6969", "Fixo", true));
	telefones.add(new Telefone("55", "048", "2424-6969", "Fixo", true));
	telefones.add(new Telefone("55", "048", "2424-6969", "Fixo", true));

}
