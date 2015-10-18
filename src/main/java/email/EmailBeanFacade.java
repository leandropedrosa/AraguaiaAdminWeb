/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email;

import javax.ejb.Local;
import javax.mail.MessagingException;
import util.Email;

/**
 *
 * @author Leandro
 */

@Local
public interface EmailBeanFacade {

    public void sendMessage(Email email) throws MessagingException;
}
