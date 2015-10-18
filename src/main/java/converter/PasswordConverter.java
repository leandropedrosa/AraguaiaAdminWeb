/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

/**
 *
 * @author Leandro
 */
import controle.AbstractControle;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("Char[]Converter")
public class PasswordConverter extends AbstractControle implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String newValue) {
        if (newValue == null) {
            return newValue;
        }
        return newValue.toCharArray();
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        char[] inputValue;
        try {
            inputValue = (char[]) value;
        } catch (ClassCastException ccex) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Objeto não estava presente no formato desejado", null);
            throw new ConverterException(message);
        }
        return new String(inputValue);
    }
}
