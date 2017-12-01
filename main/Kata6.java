package main;

import model.Histogram;
import model.Mail;
import model.Person;
import view.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Kata6 {
    public List<Mail> mailList;
    Histogram<String> histogram;
    Histogram<String> domains;
    Histogram<Character> letters;
    Histogram<Character> gender;
    Histogram<Float> weight;

    List <Person> people;


    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        Kata6 kata6 =new Kata6();
        kata6.execute();
    }

    private void input() throws IOException {
        String filename ="/home/jackdar/IdeaProjects/Kata6/emails.txt";
        mailList= MailListReader.read(filename);
    }

    private void process() throws SQLException, IOException, ClassNotFoundException {
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

        people= DataBaseList.read();
        HistogramBuilder<Person> builderPerson=new HistogramBuilder<>(people);

         gender = builderPerson.build(new Attribute<Person,Character>(){
             @Override
             public Character get(Person item){
                 return item.getGender();
             }
         });

         weight=builderPerson.build(new Attribute<Person, Float>() {
             @Override
             public Float get(Person item) {
                 return item.getWeight();
             }
         });
    }

    private void output(){
        //HistogramDisplay histoDisplay= new HistogramDisplay(histogram);
        new HistogramDisplay(domains,"Dominios").execute();
        new HistogramDisplay(letters,"Primer Caracter").execute();
        new HistogramDisplay(gender,"Gender").execute();
        new HistogramDisplay(weight,"Weight").execute();
        //histoDisplay.execute();
    }

    private void execute() throws IOException, SQLException, ClassNotFoundException {
        input();
        process();
        output();
    }
}
