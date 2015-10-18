/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Leandro
 */
@FacesConverter("dataConverter")
public class DataConverter extends DateTimeConverter {
    
    public DataConverter() {
        setPattern("dd/MM/yyyy");
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.equals("")) {
            throw new ConverterException("Formato Inválido");
        } else {
            if (value.length() != getPattern().length()) {
                throw new ConverterException("Formato Inválido");
            }
        }
        
        return super.getAsObject(context, component, value);
    }
    
}
