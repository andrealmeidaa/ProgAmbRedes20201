package br.ifrn.thread.race;
import java.util.Random;
public class Piloto implements Runnable{
    private String name;
    private long tempoCorrida;
    public Piloto(String name){
        this.name=name;
        tempoCorrida=0;
    }
    @Override
    public void run(){
        long tempoVolta=0;
        for(int i=0;i<65;i++){
            System.out.println(this.name+" deu a "+(i+1)+" volta.");
            tempoVolta=((int)((Math.random()+0.0001)*1000));
            try {
                 Thread.sleep(tempoVolta);
                 tempoCorrida+=tempoVolta;
                
            } catch(Exception e) {
                e.printStackTrace();
            } 
        }
        System.out.println(this.name+" terminou a corrida!");
    }
    public long getTempoVolta(){
        return this.tempoCorrida;
    }
}