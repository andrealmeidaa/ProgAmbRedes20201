package br.thread;
public class TestSync{
    public static void main(String args[]){
        ThreadBSync thread01=new ThreadBSync();
        thread01.start();
        
        /*synchronized(thread01){
             try {
                 System.out.println("Processando o Thread");
                 thread01.wait();
             } catch(Exception e) {
                 e.printStackTrace();
             } 
        }*/
        
        System.out.println("Total encontrado = "+thread01.getTotal());
    }
}