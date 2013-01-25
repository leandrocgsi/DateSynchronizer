package br.com.semeru.datesynchronizer;

import br.com.semeru.datesynchronizer.beans.Timezone;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class RecoveryDateWitchURL {

    //Determino a URL de onde será recuperada a informação do webservice
    private static String url = "http://www.earthtools.org/timezone/-18.5134/-46.512809";
        
    //Método main
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        //Invoco o método passando como parâmetro a URL
        readXMLURL(url);
    }

    // Método responsável por recuperar um inputstream a
    // partir de uma URL e converter o resultado em objeto
    private static void readXMLURL(String url) throws IOException {
        
        //Crio uma instancia de cliente HTTP
        HttpClient client = new DefaultHttpClient();
        
        //Crio uma instancia de HTTPGet passando a URL como parâmetro
        HttpGet method = new HttpGet(url);
        
        //Atribuo à HTTP response o resutado da execução do método get
        HttpResponse httpResponse = client.execute(method);
        
        //Declaro uma variável que recebe o código de status da requisição HTTP
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        
        //Verifico se o código do status é igual a SC_OK (200)
        if (statusCode == HttpStatus.SC_OK) {
            
            //Se for significa que a requisição foi bem sucedida e então
            //crio uma instancia de InputStream pegando o conteúdo da response
            InputStream inputStream = httpResponse.getEntity().getContent();
            
            //Invoco o método parserXMLToObject passando o inputStream como parâmetro
            parserXMLToObject(inputStream);
        }
    }
    
    //Método que efetivmente converte o input stream em XML e depois em objeto
    private static Timezone parserXMLToObject(InputStream inputStream) {
        
        //Crio uma instancia de XStream que recebe via
        //construtor uma instancia de DomDriver
        XStream xStream = new XStream(new DomDriver());
        
        //Processa as anotações da classe Timezone
        xStream.processAnnotations(Timezone.class);
        
        //Crio uma instancia de Timezone que recebe um cast para Timezone 
        //do inputstream convertido para XML e depois para Objetc
        Timezone timezone = (Timezone) xStream.fromXML(inputStream);
        
        //Imprimo algumas informações de timezone para testar
        System.out.println("O TimeZone É: " + timezone.getLocaltime() + " - " + timezone.getUtctime() + "\n"
                + "e as Cordenadas são: " + timezone.getLocation().getLatitude() + " de Latitude Sul" + timezone.getLocation().getLongitude() + " de Longitude Oeste. :->");
        
        //Retorno um objeto do tipo Timezone que poderá
        //ser usado em outras partes da aplicação.
        return timezone;
    }

}
