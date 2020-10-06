package br.thread;
public class ThreadC implements Runnable{
    private int tempoEspera;
    private String name;
    public ThreadC(String name, int tempoEspera){
        this.tempoEspera=tempoEspera;
        this.name=name;
    }
    @Override
    public void run(){
        try {
            for(int i=0;i<10;i++){
            System.out.println("Thread "+name+" enviando " + i);
            Thread.sleep(tempoEspera);
        }
        } catch(Exception e) {
            e.printStackTrace();
        } 
        
    }
    
    public static void main(String args[]){
        Thread thread01=new Thread(new ThreadC("01",1000));
        Thread thread02=new Thread(new ThreadC("02",2000));
        thread01.start();
        thread02.start();
        
    }
}