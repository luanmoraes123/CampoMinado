package com.luan.cm.modelo;



import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.luan.cm.modelo.Campo;

public class CampoTeste {

	private Campo campo;
	
	@BeforeEach
	void iniciarCampo() {
		campo = new Campo(3, 3);
	}
	@Test
	void testeVizinhoRealDistancia1() {
		Campo vizinho = new Campo(2, 2);		
		boolean resultado = campo.adicionarVizinho(vizinho);		
		assert(resultado);
	}
	@Test
	void testeVizinhoRealDistancia2() {
		Campo vizinho = new Campo(2, 3);		
		boolean resultado = campo.adicionarVizinho(vizinho);		
		assert(resultado);
	}
	@Test
	void testeVizinhoRealDistancia3() {
		Campo vizinho = new Campo(2, 4);		
		boolean resultado = campo.adicionarVizinho(vizinho);		
		assert(resultado);
	}
	@Test
	void testeVizinhoRealDistancia4() {
		Campo vizinho = new Campo(3, 2);		
		boolean resultado = campo.adicionarVizinho(vizinho);		
		assert(resultado);
	}
	@Test
	void testeVizinhoRealDistancia5() {
		Campo vizinho = new Campo(3, 4);		
		boolean resultado = campo.adicionarVizinho(vizinho);		
		assert(resultado);
	}
	@Test
	void testeVizinhoRealDistancia6() {
		Campo vizinho = new Campo(4, 2);		
		boolean resultado = campo.adicionarVizinho(vizinho);		
		assert(resultado);
	}
	@Test
	void testeVizinhoRealDistancia7() {
		Campo vizinho = new Campo(4, 3);		
		boolean resultado = campo.adicionarVizinho(vizinho);		
		assert(resultado);
	}
	@Test
	void testeVizinhoRealDistancia8() {
		Campo vizinho = new Campo(4, 4);		
		boolean resultado = campo.adicionarVizinho(vizinho);		
		assert(resultado);
	}
	
	@Test
	void valorPadraoMarcado() {
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void alternarMarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}
	
	@Test
	void abrirComVizinhos() {
		
		Campo campo11 = new Campo(1, 1);
		Campo campo12 = new Campo(1, 1);
		Campo campo22 = new Campo(2, 2);
		campo12.minar();
		campo22.adicionarVizinho(campo11);
		campo22.adicionarVizinho(campo12);
		campo.adicionarVizinho(campo22);
		
		campo.abrirCampo();
		
		assertTrue(campo22.isAberto() && campo11.isFechado());							
	}
}
