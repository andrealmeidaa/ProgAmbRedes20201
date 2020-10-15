package br.ifrn.thread;
import java.util.Scanner;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
public class Cliente{
    public static void main(String args[]){
        int port=2346;
        String host="127.0.0.1";
        try {
            Socket cliente=new Socket(host,port);
            System.out.println("Conectou ao servidor");
            Scanner prompt=new Scanner(System.in);
            BufferedReader entradaServidor=new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            PrintWriter saidaServidor=new PrintWriter(new OutputStreamWriter(cliente.getOutputStream()));
            String mensagem="";
            System.out.println("Digite a Mensagem:");
            mensagem=prompt.nextLine();
            while (!mensagem.equals("q")){
                saidaServidor.println(mensagem);
                saidaServidor.flush();
                System.out.println(entradaServidor.readLine());
                System.out.println("Digite a Mensagem:");
                mensagem=prompt.nextLine();
            }
            saidaServidor.close();
            prompt.close();
            cliente.close();
            entradaServidor.close();
        } catch(Exception e) {
            e.printStackTrace();
        } 
    }
}