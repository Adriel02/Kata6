package model;

public class Mail {
    public Mail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }
    public String getDomain(){
        String [] domain=mail.split("@");
        return domain[1];
    }

    private String mail;
}
