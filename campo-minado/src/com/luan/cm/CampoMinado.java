package com.luan.cm;


import com.luan.cm.modelo.Tabuleiro;
import com.luan.cm.visao.TabuleiroConsole;

public class CampoMinado {

	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(5, 5, 3);
		new TabuleiroConsole(tabuleiro);
		
	}

}
