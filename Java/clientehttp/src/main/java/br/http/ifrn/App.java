package br.http.ifrn;

/**
 * Hello world!
 *
 */
 import java.util.Scanner;
public class App 
{
    public static void main( String[] args )
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("Usuario:");
        String username=scan.nextLine();
        System.out.println("Senha:");
        String password=scan.nextLine();
        try {
            ClientForm.executeLogin(username,password);
        } catch(Exception e) {
            e.printStackTrace();
        } 
      
    }
}
