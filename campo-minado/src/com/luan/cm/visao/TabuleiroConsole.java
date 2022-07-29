package com.luan.cm.visao;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import com.luan.cm.excecao.ExplosaoException;
import com.luan.cm.excecao.SairExcecao;
import com.luan.cm.modelo.Tabuleiro;

public class TabuleiroConsole {

	private Tabuleiro tabuleiro;
	private Scanner entrada = new Scanner(System.in);

	public TabuleiroConsole(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		
		executarJogo();
	}

	private void executarJogo() {
		
		
		try {
			boolean continuar = true;
			while(continuar) {
				
				cicloDoJogo();
				System.out.println("Deseja continuar a partida? (S/n)");
				String resposta = entrada.nextLine();
				if("n".equalsIgnoreCase(resposta)) {
					continuar = false;
				} else {
					tabuleiro.reiniciar();
				}
			}
		}catch(SairExcecao e) {
			System.out.println("Tchau!!!");
		}finally {
			entrada.close();
		}
		
	}

	private void cicloDoJogo() {
		try {
			while(!tabuleiro.objetivoAlcancado()) {
				System.out.println(tabuleiro);
				String digitado = capturarValorDIgitado("Digite (x, y): ");
				
				Iterator<Integer> xy = Arrays.stream(digitado.split(","))
						.map(e -> Integer.parseInt(e.trim())).iterator();
				
				digitado = capturarValorDIgitado("1-abrir e 2-(des)marcar: ");
				if("1".equals(digitado)) {
					tabuleiro.abrir(xy.next(), xy.next());
				}else if("2".equals(digitado)) {
					tabuleiro.alterarMarcacao(xy.next(), xy.next());
				}
			}
			System.out.println(tabuleiro);
			System.out.println("VoCê ganhou!");
		}catch(ExplosaoException e) {
			System.out.println(tabuleiro);
			System.out.println("Você perdeu!");
		}
		
	}

	private String capturarValorDIgitado(String texto) {
		System.out.print(texto);
		String digitado = entrada.nextLine();
		
		if("sair".equalsIgnoreCase(digitado)) {
			throw new SairExcecao();
		}
		
		return digitado;
	}
	
	
}
