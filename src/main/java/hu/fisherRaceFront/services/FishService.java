package hu.fisherRaceFront.services;

import hu.fisherRaceFront.domain.FishList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class FishService {

    @Autowired
    private RestTemplate restTemplate;
    private final String API_URL = "http://localhost:9090";

    public List<FishList> getFishList() {
        String url = API_URL+"/fishes";
        FishList[] fishLists = restTemplate.getForObject(url, FishList[].class);
        return Arrays.asList(fishLists);
    }
}
