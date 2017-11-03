package view;

import model.Mail;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MailListReader {
    public static List<Mail> read(String fileName) throws IOException {
        List<Mail> mailList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
        String mail;
        while((mail=reader.readLine())!=null){
            if(mail.contains("@")){
                mailList.add(new Mail(mail));
            }

        }
        reader.close();
        return mailList;
    }
}
