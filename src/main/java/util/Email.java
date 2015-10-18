/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;
import org.apache.commons.mail.EmailAttachment;

/**
 *
 * @author Leandro
 */
public class Email implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<String> emails;
    private String email;
    private String assunto;
    private String corpoDaMensagem;
    private EmailAttachment anexo;
    private Usuario usuario;
    private String tipoEmail;

    public Email() {
    }

    public Email(String email, String assunto, String corpoDaMensagem, EmailAttachment anexo) {
        this.email = email;
        this.assunto = assunto;
        this.corpoDaMensagem = corpoDaMensagem;
        this.anexo = anexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getEmails() {
        if (emails == null) {
            emails = new ArrayList<String>();
        }
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getCorpoDaMensagem() {
        return corpoDaMensagem;
    }

    public void setCorpoDaMensagem(String corpoDaMensagem) {
        this.corpoDaMensagem = corpoDaMensagem;
    }

    public EmailAttachment getAnexos() {
        return anexo;
    }

    public void setAnexos(EmailAttachment anexo) {
        this.anexo = anexo;
    }

    public Usuario getUsuario() {
        if (usuario == null) {
            usuario = new Usuario();
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTipoEmail() {
        return tipoEmail;
    }

    public void setTipoEmail(String tipoEmail) {
        this.tipoEmail = tipoEmail;
    }

}
