package com.luan.cm.modelo;

import java.util.ArrayList;
import java.util.List;

import com.luan.cm.excecao.ExplosaoException;

public class Campo {
	
	private final int linha;
	private final int coluna;
	
	private boolean aberto;
	private boolean minado;
	private boolean marcado;
	
	private List<Campo> vizinhos = new ArrayList<>();
	
	 Campo(int linha, int coluna){
		this.linha = linha;
		this.coluna = coluna;
		aberto = false;
		minado = false;
		marcado = false;
	}
	
	 boolean adicionarVizinho(Campo vizinho) {
		
		boolean linhaDiferente = linha != vizinho.linha;
		boolean colunaDiferente = coluna != vizinho.coluna;
		boolean diagonal = linhaDiferente && colunaDiferente;
		
		int deltaLinha = Math.abs(linha - vizinho.linha);
		int deltaColuna = Math.abs(coluna - vizinho.coluna);
		int deltaGeral = deltaColuna + deltaLinha;
		if(deltaGeral == 1 && !diagonal) {
			vizinhos.add(vizinho);
			return true;
		}else if(deltaGeral == 2 && diagonal) {
			vizinhos.add(vizinho);
			return true;
		}else return false;
	}
	 
	 void alternarMarcacao() {
		 if(!aberto) {
			 marcado = !marcado;
		 }
	 }
	 
	 boolean abrirCampo() {
		 if(!aberto && !marcado) {
			 aberto = true;
			 
			 if(minado) {
				 throw new ExplosaoException();
			 }
			 if(vizinhancaSegura()) {
				 vizinhos.forEach(v -> v.abrirCampo());
			 }
			 return true;
		 }
		 else return false;
	 }
	 
	 void setAberto(boolean aberto) {
		 this.aberto = aberto;
	 }
	 
	 boolean vizinhancaSegura() {
		 return vizinhos.stream().noneMatch(v -> v.minado);
	 }
	 
	 void minar() {
		 minado = true;
	 }
	 
	 public boolean isMarcado() {
		 return marcado;
	 }
	 
	 public boolean isAberto() {
		return aberto;
	 }
	 
	 public boolean isFechado() {
		 return !isAberto();
	 }

	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}
	 
	 boolean objetivoAlcancado() {
		 boolean descoberto = !minado && aberto;
		 boolean protegido = minado && marcado;
		 
		 return descoberto || protegido;
	 }
	 
	 long minasNaVizinhanca() {		 
		 return vizinhos.stream().filter(v -> v.minado).count();	 
	 }
	 
	 void resetar() {
		 aberto = false;
		 minado = false;
		 marcado = false;
	 }
	 
	 public boolean isMinado() {
		 return minado;
	 }
	 
	public String toString() {
		 if(marcado) {
			 return "x";
		 }else if(aberto && minado) {
			 return "*";
		 }else if(aberto && minasNaVizinhanca() > 0) {
			 return Long.toString(minasNaVizinhanca());
		 }else if(aberto) {
			 return  " ";
		 }else return "?";
	 }
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
