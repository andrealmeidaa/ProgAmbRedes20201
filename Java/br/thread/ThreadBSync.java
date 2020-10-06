package br.thread;
public class ThreadBSync extends Thread{
    private int total=0;
    @Override
    public void run(){
        //synchronized(this){
            for(int i=0;i<350;i++){
                total+=i;
            }
           // notify();
       // }
    }
    public int getTotal(){
        return total;
    }
}