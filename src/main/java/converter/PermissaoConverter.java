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
import modelo.Permissao;

@FacesConverter("permissaoConverter")
public class PermissaoConverter extends AbstractControle implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && !value.isEmpty()) {
            return (Permissao) uic.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof Permissao) {
            Permissao teste = (Permissao) value;
            if (teste != null && teste instanceof Permissao && teste.getIdPermissao() != null) {
                uiComponent.getAttributes().put(teste.getIdPermissao().toString(), teste);
                return teste.getIdPermissao().toString();
            }
        }
        return "";
    }
}
