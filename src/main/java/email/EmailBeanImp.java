/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email;

/**
 *
 * @author Leandro
 */

/*
 * EmailUtil.java
 *
 * Copyright 1988 MINIpay.
 * All Rights Reserved. Patents pending.
 *
 * This software is the proprietary information of MINIpay
 * Use is subject to license terms.
 *
 */
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.mail.MessagingException;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import util.Email;
import util.Util;

/**
 *
 * @author minipay.eu
 */
@Stateless
public class EmailBeanImp implements EmailBeanFacade {

    private static String HOST_NAME = "smtp.gmail.com";
    private static String FROM_EMAIL = "ecovilearaguaia@gmail.com";
    private static String DESCRICAO_FROM = "Condominio";
    private static String SENHA = "condominio2015";
    private static int PORTA = 465;

    @Override
    public void sendMessage(Email email) throws MessagingException {
        try {
            HtmlEmail enviar = new HtmlEmail();
            //destinatário
            enviar.addTo(email.getEmail(), email.getUsuario().getNome());
            // assunto do e-mail
            enviar.setSubject(email.getAssunto());
            // conteudo do e-mail, configura a mensagem para o formato HTML   
            enviar = templateEmail(enviar, email);
            // configure uma mensagem alternativa caso o servidor não suporte HTML    
            enviar.setTextMsg("Seu servidor de e-mail não suporta mensagem HTML");

            enviarEmail(enviar);
        } catch (Exception ex) {
            Logger.getLogger(EmailBeanImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private HtmlEmail templateEmail(HtmlEmail enviar, Email email) throws MalformedURLException, EmailException {
        // adiciona uma imagem ao corpo da mensagem e retorna seu id    
        URL url = new URL("https://i1.createsend1.com/ei/i/2C/B42/B69/155227/csfinal/logo.png");
        String cid = enviar.embed(url, "Logo Aragauaia");

        StringBuilder string = new StringBuilder();
        string.append(" <!DOCTYPE html>                                                                                                                                                                                                                        \n");
        string.append(" <html>                                                                                                                                                                                                                                 \n");
        string.append("     <head>                                                                                                                                                                                                                             \n");
        string.append("         <title>Start Page</title>                                                                                                                                                                                                      \n");
        string.append("         <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">                                                                                                                                                        \n");
        string.append("     </head>                                                                                                                                                                                                                            \n");
        string.append(" 	<body>                                                                                                                                                                                                                             \n");
        string.append(" 		<table style=\"border-collapse: collapse;border-spacing: 0;Margin-left: auto;Margin-right: auto;width: 602px\">                                                                                                                \n");
        string.append(" 			<tbody>                                                                                                                                                                                                                    \n");
        string.append(" 				<tr>                                                                                                                                                                                                                   \n");
        string.append(" 					<td>                                                                                                                                                                                                               \n");
        string.append(" 						<div align=\"center\">                                                                                                                                                                                         \n");
        string.append(" 							<a target=\"_blank\" href=\"" + Util.URL_PORTAL + "\">                                                                                                                                                                           \n");
        string.append(" 								<img src='cid:" + cid + "'  alt=\"\" height=\"100\" width=\"175\"/>                                                                                 \n");
        string.append(" 							</a>                                                                                                                                                                                                       \n");
        string.append(" 						</div>                                                                                                                                                                                                         \n");
        string.append(" 					</td>                                                                                                                                                                                                              \n");
        string.append(" 				</tr>                                                                                                                                                                                                                  \n");
        string.append(" 			</tbody>                                                                                                                                                                                                                   \n");
        string.append(" 		</table>                                                                                                                                                                                                                       \n");
        string.append(" 		<table style=\"border-collapse: collapse;border-spacing: 0;Margin-left: auto;Margin-right: auto\">                                                                                                                             \n");
        string.append(" 			<tbody>                                                                                                                                                                                                                    \n");
        string.append(" 				<tr>                                                                                                                                                                                                                   \n");
        string.append(" 					<td style=\"padding: 0;vertical-align: top\">                                                                                                                                                                      \n");
        string.append(" 						<table style=\"border-collapse: collapse;border-spacing: 0;Margin-left: auto;Margin-right: auto;width: 600px;background-color: #ffffff;font-size: 14px;table-layout: fixed\">                                  \n");
        string.append(" 							<tbody>                                                                                                                                                                                                    \n");
        string.append(" 								<tr>                                                                                                                                                                                                   \n");
        string.append(" 									<td>                                                                                                                                                                                               \n");
        string.append(" 										<table style=\"border-collapse: collapse;border-spacing: 0;table-layout: fixed;width: 100%\">                                                                                                  \n");
        string.append(" 											<tbody>                                                                                                                                                                                    \n");
        string.append(" 												<tr>                                                                                                                                                                                   \n");
        string.append(" 													<td style=\"padding: 0;vertical-align: top;padding-left: 32px;padding-right: 32px;word-break: break-word;word-wrap: break-word\">                                                  \n");
        if (email.getTipoEmail().equals("NovoUsuario")) {
            string.append(corpoEmailNovoUsuario(email));
        } else {
            if (email.getTipoEmail().equals("NovaSenha")) {
                string.append(corpoEmailNovaSenha(email));
            }
        }
        string.append(" 													</td>                                                                                                                                                                              \n");
        string.append(" 												</tr>                                                                                                                                                                                  \n");
        string.append(" 											</tbody>                                                                                                                                                                                   \n");
        string.append(" 										</table>                                                                                                                                                                                       \n");
        string.append(" 									</td>                                                                                                                                                                                              \n");
        string.append(" 								</tr>                                                                                                                                                                                                  \n");
        string.append(" 							</tbody>                                                                                                                                                                                                   \n");
        string.append(" 						</table>                                                                                                                                                                                                       \n");
        string.append(" 					</td>                                                                                                                                                                                                              \n");
        string.append(" 				</tr>                                                                                                                                                                                                                  \n");
        string.append(" 			</tbody>                                                                                                                                                                                                                   \n");
        string.append(" 		</table>                                                                                                                                                                                                                       \n");
        string.append(" 	</body>                                                                                                                                                                                                                            \n");
        string.append(" </html>                                                                                                                                                                                                                                     \n");
        // configura a mensagem para o formato HTML   
        enviar.setHtmlMsg(string.toString()); //conteudo do e-mail
        return enviar;
    }

    private String corpoEmailNovoUsuario(Email email) {
        StringBuilder string = new StringBuilder();
        string.append(" <h1 style=\"Margin-top: 0;color: #4cbfae;font-weight: 700;font-size: 36px;Margin-bottom: 18px;font-family: sans-serif;line-height: 42px\">Bem vindo,</h1>                      \n");
        string.append(" <p style=\"Margin-top: 0;color: #0d010d;font-family: Georgia,serif;font-size: 16px;line-height: 25px;Margin-bottom: 25px\">Prezado " + email.getUsuario().getNome() + ", bem vindo ao condominio online.</p>    \n");
        string.append(" <p style=\"Margin-top: 0;color: #0d010d;font-family: Georgia,serif;font-size: 16px;line-height: 25px;Margin-bottom: 25px\">Para acessar ao sistema seus dados são:</p>         \n");
        string.append(" <p style=\"Margin-top: 0;color: #0d010d;font-family: Georgia,serif;font-size: 16px;line-height: 25px;Margin-bottom: 25px\">                                                    \n");
        string.append(" <strong style=\"font-weight: bold\">Login: " + email.getUsuario().getCpf() + "<br>Senha: " + email.getUsuario().getSenha() + "</strong></p>                                    \n");
        string.append(" <p style=\"Margin-top: 0;color: #0d010d;font-family: Georgia,serif;font-size: 16px;line-height: 25px;Margin-bottom: 24px\">Qualquer dúvida estamos a disposição.<br>           \n");
        string.append(" &nbsp;</p>																				       \n");
        return string.toString();
    }

    private String corpoEmailNovaSenha(Email email) {
        StringBuilder string = new StringBuilder();
        string.append(" <h1 style=\"Margin-top: 0;color: #4cbfae;font-weight: 700;font-size: 36px;Margin-bottom: 18px;font-family: sans-serif;line-height: 42px\">Alteração de senha,</h1>             \n");
        string.append(" <p style=\"Margin-top: 0;color: #0d010d;font-family: Georgia,serif;font-size: 16px;line-height: 25px;Margin-bottom: 25px\">Para acessar ao sistema seus novos dados são:</p>   \n");
        string.append(" <p style=\"Margin-top: 0;color: #0d010d;font-family: Georgia,serif;font-size: 16px;line-height: 25px;Margin-bottom: 25px\">                                                    \n");
        string.append(" <strong style=\"font-weight: bold\">Login: " + email.getUsuario().getCpf() + "<br>Senha: " + email.getUsuario().getSenha() + "</strong></p>                                            \n");
        string.append(" <p style=\"Margin-top: 0;color: #0d010d;font-family: Georgia,serif;font-size: 16px;line-height: 25px;Margin-bottom: 24px\">Qualquer dúvida estamos a disposição.<br>           \n");
        string.append(" &nbsp;</p>																																									   \n");

        return string.toString();
    }

    private void enviarEmail(HtmlEmail enviar) {
        try {
            // o servidor SMTP para envio do e-mail
            enviar.setHostName(HOST_NAME);
            // remetente
            enviar.setFrom(FROM_EMAIL, DESCRICAO_FROM);
            // Senha e login getor
            enviar.setAuthentication(FROM_EMAIL, SENHA);
            // porta de enviou de email smtp
            enviar.setSmtpPort(PORTA);
            // configure uma mensagem alternativa caso o servidor não suporte HTML    
            enviar.setTextMsg("Seu servidor de e-mail não suporta mensagem HTML");
            enviar.setSSL(true);
            enviar.setTLS(true);
            enviar.send();
        } catch (Exception ex) {
            Logger.getLogger(EmailBeanImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
