package lwade;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="quotes")
public class Quotes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String quote;


    public Quotes(int id, String quote) {
        this.id = id;
        this.quote = quote;
    }

    public Quotes() {
        this.id = id;
        this.quote = quote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public String toString() {
        return "lwade.Quotes{" +
                "id=" + id +
                ", quote='" + quote + '\'' +
                '}';
    }
}
