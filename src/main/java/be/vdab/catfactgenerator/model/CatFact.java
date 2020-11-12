package be.vdab.catfactgenerator.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CatFact {

    private String fact;

    @Override
    public String toString() {
        return fact;
    }
}
