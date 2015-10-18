/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Leandro
 */
@SessionScoped
@ManagedBean(name = "estatisticasControle")
public class EstatisticasControle extends AbstractControle implements Serializable {

    private static final long serialVersionUID = 1L;
}
