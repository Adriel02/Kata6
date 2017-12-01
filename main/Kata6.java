package main;

import model.Histogram;
import model.Mail;
import view.Attribute;
import view.HistogramBuilder;
import view.HistogramDisplay;
import view.MailListReader;

import java.io.IOException;
import java.util.List;

public class Kata6 {
    public List<Mail> mailList;
    Histogram<String> histogram;
    Histogram<String> domains;
    Histogram<Character> letters;


    public static void main(String[] args) throws IOException {
        Kata6 kata6 =new Kata6();
        kata6.execute();
    }

    private void input() throws IOException {
        String filename ="/home/jackdar/IdeaProjects/Kata6/emails.txt";
        mailList= MailListReader.read(filename);
    }

    private void process(){
        //histogram = HistogramBuilder.build(mailList);
        HistogramBuilder<Mail> builder= new HistogramBuilder<>(mailList);

         domains= builder.build(new Attribute<Mail, String>() {
            @Override
            public String get(Mail item) {
                return item.getMail().split("@")[1];
            }
        });

         letters=builder.build(new Attribute<Mail, Character>() {
             @Override
             public Character get(Mail item) {
                 return item.getMail().charAt(0);
             }
         });
    }

    private void output(){
        //HistogramDisplay histoDisplay= new HistogramDisplay(histogram);

        new HistogramDisplay(domains,"Dominios").execute();
        new HistogramDisplay(letters,"Primer Caracter").execute();

        //histoDisplay.execute();
    }

    private void execute() throws IOException {
        input();
        process();
        output();
    }
}
