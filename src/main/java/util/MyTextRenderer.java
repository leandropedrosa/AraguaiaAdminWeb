/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Leandro
 */
import com.sun.faces.renderkit.html_basic.TextRenderer;
import enuns.ApartamentoEnum;
import java.io.IOException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

public class MyTextRenderer extends TextRenderer {

    @Override
    protected void getEndTextToRender(FacesContext context, UIComponent component, String currentValue) throws IOException {

        for (String apartamentos : ApartamentoEnum.getLista()) {
            String value = (String) component.getAttributes().get(apartamentos);
            context.getResponseWriter().writeAttribute("data-provide", value, apartamentos);
        }

        super.getEndTextToRender(context, component, currentValue);
    }
}
