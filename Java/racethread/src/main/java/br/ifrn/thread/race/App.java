package br.ifrn.thread.race;

public class App 
{
    public static void main( String[] args )
    {
        Piloto pHamilton=new Piloto("Hamilton");
        Piloto pMassa=new Piloto("Massa");
        
        try {
            Thread tHamilton=new Thread(pHamilton);
            Thread tMassa=new Thread(pMassa);
            tHamilton.start();
            tMassa.start();
            tHamilton.join();
            tMassa.join();
        
            if (pMassa.getTempoVolta()<pHamilton.getTempoVolta()){
                System.out.println("Massa Venceu");
            }else{
                System.out.println("Hamilton Venceu");
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        
    }
}
