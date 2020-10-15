package br.ifrn.thread;
import java.net.ServerSocket;
import java.net.Socket;
//Classe Principal
public class ServidorMultiThread{
    public static void main(String args[]){
        int i=0;
        try {
            ServerSocket socketServidor=new ServerSocket(2346);//Cria um servidor Socket na porta 2346
            while (true){
                Socket clienteSocket=socketServidor.accept();//Aguarda novas conexões
                i++;//Controla o número de clientes
                //Cria uma nova instância da classe ClienteThread
                ClienteThread cliThread=new ClienteThread(clienteSocket,i);
                cliThread.start();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
