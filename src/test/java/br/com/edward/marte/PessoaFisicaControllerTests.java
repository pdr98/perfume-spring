package br.com.edward.marte;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PessoaFisicaControllerTests {
	/*
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;
	
    @Test
    void validaCpfTest() {
    	Boolean resposta = this.restTemplate.getForObject(getURL() + "valida-cpf?cpf=1", Boolean.class);
    	assertFalse(resposta);
    }
    
    @Test
    void cadastrarTest() {
    	PessoaFisica p = this.restTemplate.getForObject(getURL() + "cadastrar?cpf=00000000191&nome=a", PessoaFisica.class);
    	assertTrue(p.isDocumentoValido());
    	assertEquals("00000000191", p.getDocumento());
    	assertEquals("000.000.001-91", p.getDocumentoFormatado());
    	assertEquals("a", p.getNome());
    	assertNotNull(p.getNovoDocumento());
    	assertEquals(11, p.getNovoDocumento().length());
    }

    private String getURL() {
    	return "http://localhost:" + port + "/pf/";
    }
    */
}
