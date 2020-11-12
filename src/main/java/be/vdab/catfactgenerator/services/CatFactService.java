package be.vdab.catfactgenerator.services;

import be.vdab.catfactgenerator.http.CatFactApiCaller;
import be.vdab.catfactgenerator.model.CatFact;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CatFactService {

    private CatFactApiCaller catFactApiCaller;

    public CatFact getFact(){
        return catFactApiCaller.requestCatFact();
    }
}
