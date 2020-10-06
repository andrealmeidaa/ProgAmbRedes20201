package br.thread;
public class Principal{
    public static void main(String args[]){
        ThreadA thread01=new ThreadA(10000000);
        ThreadA thread02=new ThreadA(10000000);
        ThreadA thread03=new ThreadA(10000000);
        
        thread01.start();
        thread02.start();
        thread03.start();
        
        //Segura a execução
        
       /* try {
            thread01.join();
        thread02.join();
        thread03.join();
        } catch(Exception e) {
            e.printStackTrace();
        }*/
        
        
        System.out.println("Thread 01 : "+thread01.getTempoGasto()+" milisegundos");
        System.out.println("Thread 02 : "+thread02.getTempoGasto()+" milisegundos");
        System.out.println("Thread 03 : "+thread03.getTempoGasto()+" milisegundos");
    }
}