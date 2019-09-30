package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pacotepadrao.ClienteController;

/**
* Representação de testes da classe ClienteController
*/
class testClienteController {
	private ClienteController clienteController = new ClienteController();
	
	@Test
	void Construct() {
		try {
			clienteController.cadastraCliente("Gustavo", "@ccc", "CG", "12345");
		} catch (Exception e) {
			fail("Não era esperado exceção");
		}
		try {
			clienteController.cadastraCliente("Gustavo", "@ccc", "CG", "12345");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {
			
		}
	}

	@Test
	void NullConstruct() {
		try {
			clienteController.cadastraCliente(null, "@test", "testCity", "733573-0");
			fail("Era esperado exceção ao passar nome nulo.");
		} catch (NullPointerException e) {
			
		}
		try {
			clienteController.cadastraCliente("Teste", null, "testCity", "733573-0");
			fail("Era esperado exceção ao passar email nulo.");
		} catch (NullPointerException e) {
			
		}
		try {
			clienteController.cadastraCliente("Teste", "@test", null, "733573-0");
			fail("Era esperado exceção ao passar localização nulo.");
		} catch (NullPointerException e) {
			
		}
		try {
			clienteController.cadastraCliente("Teste", "@test", "testCity", null);
			fail("Era esperado exceção ao passar cpf nulo.");
		} catch (NullPointerException e) {
			
		}
	}
	
	void EmptyConstruct() {
		try {
			clienteController.cadastraCliente(" ", "@test", "testCity", "733573-0");
			fail("Era esperado exceção ao passar nome vazio.");
		} catch (IllegalArgumentException e) {
			
		}
		try {
			clienteController.cadastraCliente("Teste", " ", "testCity", "733573-0");
			fail("Era esperado exceção ao passar email vazio.");
		} catch (IllegalArgumentException e) {
			
		}
		try {
			clienteController.cadastraCliente("Teste", "@test", "", "733573-0");
			fail("Era esperado exceção ao passar localização vazio.");
		} catch (IllegalArgumentException e) {
			
		}
		try {
			clienteController.cadastraCliente("Teste", "@test", "testCity", "");
			fail("Era esperado exceção ao passar cpf vazio.");
		} catch (IllegalArgumentException e) {
			
		}
	}
	
	@Test
	void testGetCliente() {
		try {
			clienteController.cadastraCliente("Gustavo", "@ccc", "CG", "12345");
			assertEquals(clienteController.getCliente("12345"), "Gustavo - CG - @ccc");
		} catch (Exception e) {
			fail("Não era esperado exceção");
		}
		try {
			clienteController.cadastraCliente("", "@ccc", "CG", "12345");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {
			
		}

	}

	@Test
	void testGetClientes() {
		clienteController.cadastraCliente("Gustavo", "@ccc", "CG", "12345");
		clienteController.cadastraCliente("Gustavo", "@hotmail", "CG", "54321");
		assertEquals(clienteController.getClientes(), "Gustavo - CG - @hotmail | Gustavo - CG - @ccc\n");
	}

	@Test
	void testSetClienteLocalizacao() {
		clienteController.cadastraCliente("Gustavo", "@ccc", "CG", "12345");
		try {
			clienteController.setClienteLocalizacao("Campina Grande", "12345");
		} catch (Exception e) {
			fail("Não era esperado exceção");
		}
		try {
			clienteController.setClienteLocalizacao("", "12345");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
		try {
			clienteController.setClienteLocalizacao(null, "12345");
			fail("Era esperado exceção");
		} catch (NullPointerException e) {

		}
		try {
			clienteController.setClienteLocalizacao("@gmail", "1");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {
			
		}
	}

	@Test
	void testSetClienteNome() {
		clienteController.cadastraCliente("Gustavo", "@ccc", "CG", "12345");
		try {
			clienteController.setClienteNome("Ovatsug", "12345");
		} catch (Exception e) {
			fail("Não era esperado exceção");
		}
		try {
			clienteController.setClienteNome("", "12345");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
		try {
			clienteController.setClienteNome(null, "12345");
			fail("Era esperado exceção");
		} catch (NullPointerException e) {

		}
		try {
			clienteController.setClienteNome("@gmail", "1");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {
			
		}
	}

	@Test
	void testSetClienteEmail() {
		clienteController.cadastraCliente("Gustavo", "@ccc", "CG", "12345");
		try {
			clienteController.setClienteEmail("@hotmaill", "12345");
		} catch (Exception e) {
			fail("Não era esperado exceção");
		}
		try {
			clienteController.setClienteEmail("", "12345");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {

		}
		try {
			clienteController.setClienteEmail(null, "12345");
			fail("Era esperado exceção");
		} catch (NullPointerException e) {

		}
		try {
			clienteController.setClienteEmail("@gmail", "1");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {
			
		}
	}

	@Test
	void testRemoveCliente() {
		clienteController.cadastraCliente("Gustavo", "@ccc", "CG", "12345");
		try {
			clienteController.removeCliente("12345");
		} catch (Exception e) {
			fail("Não era esperado exceção");
		}
		try {
			clienteController.removeCliente("1");
			fail("Era esperado exceção");
		} catch (IllegalArgumentException e) {
		
		}
	}
}