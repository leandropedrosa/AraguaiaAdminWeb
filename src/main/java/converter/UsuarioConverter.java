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
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.Usuario;

@FacesConverter("usuarioConverter")
public class UsuarioConverter extends AbstractControle implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && !value.isEmpty()) {
            return (Usuario) uic.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof Usuario) {
            Usuario teste = (Usuario) value;
            if (teste != null && teste instanceof Usuario && teste.getIdUsuario() != null) {
                uiComponent.getAttributes().put(teste.getIdUsuario().toString(), teste);
                return teste.getIdUsuario().toString();
            }
        }
        return "";
    }
}
