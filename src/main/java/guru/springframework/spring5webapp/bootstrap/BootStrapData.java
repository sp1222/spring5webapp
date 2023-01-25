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

        Publisher publisher = new Publisher("publisher 1", new Address("123 memory lane", null, "San Marcos", "Texas", "78666"));
        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book ("Domain Driven Design", "123123");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);
        publisher.addBook(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "456456");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        publisher.addBook(noEJB);
        noEJB.setPublisher(publisher);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher street 1: " + publisher.getStreetAddress1());
        System.out.println("Publisher street 2: " + publisher.getStreetAddress2());
        System.out.println("Publisher city: " + publisher.getCity());
        System.out.println("Publisher state: " + publisher.getState());
        System.out.println("Publisher zip: " + publisher.getZip());
        System.out.println("Publisher book count: " + publisher.getBooks().size());
    }
}
