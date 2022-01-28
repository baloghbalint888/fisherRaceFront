package hu.fisherRaceFront.services;

import hu.fisherRaceFront.domain.CatchList;
import hu.fisherRaceFront.domain.Competition;
import hu.fisherRaceFront.domain.Fisher;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class FisherService {

    @Autowired
    private RestTemplate restTemplate;
    private final String API_URL = "http://localhost:9090";


    public List<Fisher> getFishers() {
        String url = API_URL+"/fishers";
        Fisher[] fishers = restTemplate.getForObject(url, Fisher[].class);
        return Arrays.asList(fishers);
    }


    public Fisher getFisher(int startNumber) {
        String url = API_URL+"/fishers/{id}";
        Fisher fisher = restTemplate.getForObject(url, Fisher.class, startNumber);
        return fisher;
    }

    public int addFisher(int startNumber, String name, String country) {
        String url = API_URL+"/fishers";
        Fisher fisher = new Fisher(startNumber, name, country, "avatar.png");
        HttpEntity<Fisher> requestEntity = new HttpEntity<>(fisher);
        try {
            ResponseEntity<Fisher> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Fisher.class);
            return responseEntity.getStatusCodeValue();
        } catch(HttpClientErrorException ex){
            return ex.getStatusCode().value(); // conflict ( létező start number)
        }

    }

    public List<CatchList> getCatchList(int startNumber) {
        String url = API_URL+"/catchlist/{id}";
        CatchList[] list = restTemplate.getForObject(url, CatchList[].class, startNumber);
        return Arrays.asList(list);
    }

    public List<Competition> getCompetition() {
        String url = API_URL+"/comp";
        Competition[] list = restTemplate.getForObject(url, Competition[].class);
        return Arrays.asList(list);
    }

    public int updateFisher(int startNumber, String country) {
        String url = API_URL+"/fishers/{id}";
        Fisher fisher = new Fisher(startNumber, country);

        // az alábbi két sorral állítjuk be a restTemplate példányt arra, hogy tudja kezelni a patch kérést
        // ezért kellett a httpclient dependency a pom.xml-be
        CloseableHttpClient client = HttpClientBuilder.create().build();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(client));

        HttpEntity<Fisher> requestEntity = new HttpEntity<>(fisher);
        ResponseEntity<Fisher> responseEntity = restTemplate.exchange(url, HttpMethod.PATCH, requestEntity, Fisher.class, startNumber);
        return responseEntity.getStatusCodeValue();
    }

    public int deleteFisher(int startnumber) {
        System.out.println("Service: "+(startnumber-1));
        String url = API_URL+"/fishers/{id}";
        restTemplate.delete(url, startnumber);
        System.out.println("return 100");
        return 100;
    }

}
