/**
 * Class ThreadA
 * Adaptado de https://www.devmedia.com.br/simplificando-o-uso-de-threads/18236
 */
package br.thread;
import java.util.Date;	
public class ThreadA extends Thread {
	private long tempoGasto;
	private long numeroInteracoes;
	public ThreadA(long numeroInteracoes){
		this.numeroInteracoes=numeroInteracoes;
	}
	@Override
	public void run(){
		Date inicio=new Date();
		long tempoInicio=inicio.getTime();
		for (long i=0;i<numeroInteracoes;i++){
			tempoGasto=(new Date().getTime()-tempoInicio);
		}
	}
	
	public long getTempoGasto(){
		return this.tempoGasto;
	}
}