package util;

import enuns.ApartamentoEnum;
import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class AutoComplete implements Serializable {

    private String[] apartamentos;

    public String[] getApartamentos() {
        if (apartamentos == null) {
            apartamentos = new String[ApartamentoEnum.getLista().size()];
            apartamentos = ApartamentoEnum.getLista().toArray(apartamentos);
        }

        return apartamentos;
    }

    public void setApartamentos(String[] apartamentos) {
        this.apartamentos = apartamentos;
    }

}
