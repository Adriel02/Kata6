package view;

import model.Histogram;
import model.Mail;

import java.util.List;

public class HistogramBuilder<T> {

    public HistogramBuilder(List<T> items) {
        this.items = items;
    }

    private final List <T> items;

    public  <A>Histogram<A> build(Attribute <T,A> attribute){
        Histogram<A> histo = new Histogram<>();
        for (T item:items) {
            A value = attribute.get(item);
            histo.increment(value);
        }
    return histo;
    }
}
