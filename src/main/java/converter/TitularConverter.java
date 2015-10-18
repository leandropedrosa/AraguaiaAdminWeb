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
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.Titular;

@FacesConverter("titularConverter")
public class TitularConverter extends AbstractControle implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && !value.isEmpty()) {
            return (Titular) uic.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof Titular) {
            Titular teste = (Titular) value;
            if (teste != null && teste instanceof Titular && teste.getIdTitular() != null) {
                uiComponent.getAttributes().put(teste.getIdTitular().toString(), teste);
                return teste.getIdTitular().toString();
            }
        }
        return "";
    }
}
