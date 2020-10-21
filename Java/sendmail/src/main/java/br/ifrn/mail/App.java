package br.ifrn.mail;
import java.io.*;
import java.util.*;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;//Classe que trata e-mails html

public class App 
{
    public static void main( String[] args )
    {
        try {
            Properties props=lerPropriedades("classes/conf.properties");
            String mensagem="<html> \n"+
            "<body>\n"+
                "<p> Este é uma mensagem importante</p>\n"+
                "<p> Clique no <a href='http://www.google.com'>Google</a></p>\n"+
            "</body></html>";
            HtmlEmail sender=new HtmlEmail();//Cria objeto da classe HtmlEmail
            sender.setHostName("smtp.gmail.com");//Servidor do Gmail
            sender.setAuthentication(props.getProperty("username"),
            props.getProperty("password"));//Recupera as informações
            sender.setSSL(true);
            sender.addTo("andregustavoo@gmail.com");//Adiciona dos destinatários
            sender.addTo("andre.almeida@escolar.ifrn.edu.br");
            sender.setFrom(props.getProperty("username"));//Remetente
            sender.setSubject("Teste Mensagem Java");//Título
            sender.setHtmlMsg(mensagem);//Mensagem html
            sender.send();
        } catch(Exception e) {
        }
        
    }
    public static Properties lerPropriedades(String arquivo)throws IOException {
         // FileInputStream fis = null;
          Properties prop = null;
          InputStream fis=null;
          try {
            // fis = new FileInputStream(arquivo);
            //Realiza a leitura do arquivo dentro do jar
             fis=App.class.getClassLoader().getResourceAsStream("conf.properties");
             prop = new Properties();
             prop.load(fis);
          } catch(FileNotFoundException fnfe) {
             fnfe.printStackTrace();
          } catch(IOException ioe) {
             ioe.printStackTrace();
          } finally {
             fis.close();
          }
          return prop;
    }
}
