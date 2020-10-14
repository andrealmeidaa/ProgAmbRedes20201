package br.http.ifrn;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.net.URISyntaxException;

public class ClientForm {

    public static void executeLogin(String user,String pwd) throws Exception {
        CloseableHttpClient httpClient=HttpClients.createDefault(); //Cria um cliente http
        
        /*Cria um request builder, usando o método HTTP POST*/
        RequestBuilder request=RequestBuilder.post(); 
        /*httbin.org é um site para "brincar" com requisições http*/
        request.setUri("http://httpbin.org/post");//Define a URL de submissão
        request.addParameter("Name",user);//Passa o parâmetro name
        request.addParameter("Password",pwd);//Passa o parâmetro password
        
        HttpUriRequest httpPost=request.build();//Cria o objeto para ser executado
        
        HttpResponse response=httpClient.execute(httpPost); //Efetiva o post e recebe a resposta
        
        System.out.println(EntityUtils.toString(response.getEntity()));//Imprime a resposta
        System.out.println(response.getStatusLine());//Imprime o código http da resposta
        
    }
}