package lwade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;


@RestController
public class Controller {

    private static int id = 0;

    @Autowired
    private QuoteDao quoteDao;

    @RequestMapping(value="/addQuote", method= RequestMethod.POST)
    public Quotes addQuote(@RequestBody Quotes newQuote) throws IOException {
        quoteDao.create(newQuote);
        return newQuote;
    }

    @RequestMapping(value="getQuotes/{id}", method=RequestMethod.GET)
    public Quotes getQuotes(@PathVariable("id") int id) throws IOException {
        return quoteDao.getById(id);
    }

    @RequestMapping(value="updateQuote", method=RequestMethod.PUT)
    public Quotes updateQuote(@RequestBody Quotes newQuote) throws IOException {
        quoteDao.updateQuote(newQuote);
        return newQuote;
    }

    @RequestMapping(value="deleteQuote/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteQuote(@PathVariable("id") int id) throws IOException {
        quoteDao.deleteQuote(id);
        return null;
    }

    // TEST METHOD TO MAKE SURE THE REST API IS FUNCTIONING
    @RequestMapping("/quote")
    public Quotes quotes() {
        return new Quotes(id, "Boooooooo");
    }


    public void setQuoteDao(QuoteDao quoteDao) {
        this.quoteDao = quoteDao;
    }
}
