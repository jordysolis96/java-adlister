import daos.DaoFactory;
import models.Album;
import models.Author;
import models.Product;
import models.Quote;

import java.util.ArrayList;

public class BeanTest {
    public static void main(String[] args) {
        Album album = new Album();
        album.setId(1L);
        album.setName("Loose");
        album.setArtist("Nelly Furtado");
        album.setGenre("Pop, R&B");
        album.setReleaseDate(2006);
        album.setSales(52000);

        System.out.println("album.getName() = " + album.getName());
        System.out.println("album.getArtist() = " + album.getArtist());

        Author author = new Author();
        author.setId(1L);
        author.setFirstName("Douglas");
        author.setLastName("Adams");

        Quote firstQuote = new Quote();
        firstQuote.setId(1L);
        firstQuote.setAuthor(author);
        firstQuote.setContent("I love deadlines. I love the whooshing noise they make as they go by.");

        Quote secondQuote = new Quote();
        secondQuote.setId(2L);
        secondQuote.setAuthor(author);
        secondQuote.setContent("Don't Panic.");

        ArrayList<Quote> quotes = new ArrayList<>();
        quotes.add(firstQuote);
        quotes.add(secondQuote);

        for (Quote q: quotes) {
            System.out.println("quote.getContent() = " + q.getContent());
            System.out.println("quote.getAuthor().getFirstName() = " + q.getAuthor().getFirstName());
            System.out.println("quote.getAuthor().getLastName() = " + q.getAuthor().getLastName());
        }

        DaoFactory.getProductsDao().all(); // create a connection to the DB
        DaoFactory.getProductsDao().insert(new Product()); // keeps using an existing connection to the DB

    }
}


