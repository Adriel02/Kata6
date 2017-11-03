package main;

import model.Histogram;
import model.Mail;
import view.HistogramDisplay;
import view.MailHistogramBuilder;
import view.MailListReader;

import java.io.IOException;
import java.util.List;

public class Kata4 {
    public static void main(String[] args) throws IOException {
        String filename ="C:\\Users\\ADRIELGARCÍADÍAZ\\IdeaProjects\\Kata4\\emails.txt";
        List<Mail> mailList= MailListReader.read(filename);
        Histogram<String> histogram = MailHistogramBuilder.build(mailList);
        HistogramDisplay histoDisplay= new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
}
