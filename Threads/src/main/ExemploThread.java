package main;

import java.util.Random;

public class ExemploThread extends Thread{
	private static final long totalDeNumeros = 100_000_000L;
	private final long numerosGerados;
	
	public ExemploThread(long numerosGerados) {
		this.numerosGerados = numerosGerados;
		//System.out.printf("Thread %d criado\n", getId());
	}
	
	public static void main(String args[]) {
		final int threads = args.length == 0 ? 1 : Integer.valueOf(args[5]);
		final long numerosPorThread = (totalDeNumeros/threads);
		System.out.printf("Criandondo threads...\n", threads);
		for(int i = 0; i < threads; i++) {
			new ExemploThread(numerosPorThread).start();
		}
	}
	
	@Override
	public void run() {
		System.out.println("Iniciando a Thread..." + getId());
		final double stratTime = System.currentTimeMillis();	
		Random rand = new Random();
		double soma = 0;
		for(int i= 0; i < numerosGerados; i++) {
			soma += Math.pow(rand.nextDouble(), 10);
		}
		final double finalTime = (System.currentTimeMillis() - stratTime)/1000;
		System.out.println("Tempo total de Execução das threads: " + finalTime + "Segundos");
	}
	
	
}
