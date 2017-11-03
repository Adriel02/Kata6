package main;

import model.Histogram;
import model.Mail;
import view.HistogramDisplay;
import view.MailHistogramBuilder;
import view.MailListReader;

import java.io.IOException;
import java.util.List;

public class Kata4 {
    public List<Mail> mailList;
    Histogram<String> histogram;

    public static void main(String[] args) throws IOException {
        Kata4 kata4=new Kata4();
        kata4.execute();
    }

    private void input() throws IOException {
        String filename ="C:\\Users\\ADRIELGARCÍADÍAZ\\IdeaProjects\\Kata4\\emails.txt";
        mailList= MailListReader.read(filename);
    }

    private void process(){
        histogram = MailHistogramBuilder.build(mailList);
    }

    private void output(){
        HistogramDisplay histoDisplay= new HistogramDisplay(histogram);
    }

    private void execute() throws IOException {
        input();
        process();
        output();
    }
}
