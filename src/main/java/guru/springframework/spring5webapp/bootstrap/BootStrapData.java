package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.pojo.Address;
import guru.springframework.spring5webapp.pojo.Author;
import guru.springframework.spring5webapp.pojo.Book;
import guru.springframework.spring5webapp.pojo.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book ("Domain Driven Design", "123123");
        Publisher pub1 = new Publisher("publisher 1", new Address("123 memory lane", null, "San Marcos", "Texas", "78666"));
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(pub1);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "456456");
        Publisher pub2 = new Publisher("publisher 2", new Address("56 E 7th Ave", "Manhattan", "New York", "New York", "21201"));
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(pub2);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
        for (Publisher publisher : publisherRepository.findAll()) {
            System.out.println("Publisher street 1: " + publisher.getStreetAddress1());
            System.out.println("Publisher street 2: " + publisher.getStreetAddress2());
            System.out.println("Publisher city: " + publisher.getCity());
            System.out.println("Publisher state: " + publisher.getState());
            System.out.println("Publisher zip: " + publisher.getZip());
        }
    }
}
