package br.ifrn.thread;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
 /*
    Classe que representa os threads dos clientes conectados
    Para cada conexão, um novo Thread é aberto
    */
public class ClienteThread extends Thread{
        private Socket cSocket;//Recebe a instância referente o socket cliente
        private int idCliente;//Id do cliente
        ClienteThread(Socket cSocket,int idCliente){
            this.cSocket=cSocket;
            this.idCliente=idCliente;
        }
        @Override
        public void run(){
            System.out.println("Conexão recebida de "+idCliente);
            try {
                //Recupera os streams de escrita/leitura do socket cliente
                BufferedReader in=new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
                PrintWriter out=new PrintWriter(new OutputStreamWriter(cSocket.getOutputStream()));
                String mensagemCliente;
                while(true){//Enquanto tiver mensagens
                    mensagemCliente=in.readLine();//Leia do socket do cliente
                    //Se o cliente for encerrado e vier a letra q, encerre o loop;
                    if (mensagemCliente==null || mensagemCliente.equals("q")){
                        break;
                    }else{
                        System.out.println("Cliente "+(idCliente)+" disse: "+mensagemCliente);
                        out.println("Recebi sua mensagem :"+mensagemCliente);//Escreve para o cliente
                        out.flush();
                    }
                }
                System.out.println("Conexao Encerrada com "+idCliente);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        
    }