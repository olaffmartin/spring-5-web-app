package com.example.demo.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Publisher;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;

	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		initData();

	}

	private void initData() {
		// Olaff
		Author olaff = new Author("Olaff", "Molero");
		Publisher mcgraw = new Publisher("McGraw-Hill", "2 Penn Plaza, 10th Floor New York, NY");
		Book book1 = new Book("Spring MVC", "1234", mcgraw);
		olaff.getBooks().add(book1);
		book1.getAuthors().add(olaff);
		authorRepository.save(olaff);
		publisherRepository.save(mcgraw);
		bookRepository.save(book1);

		// Martin
		Author martin = new Author("Martin", "Nucette");
		Publisher packt = new Publisher("Packt Publishing Ltd.",
				"32 Lincoln Road Olton, Birmingham, United Kingdom, B27 6PA");
		Book book2 = new Book("Spring Core 5", "5647", packt);
		martin.getBooks().add(book2);
		book2.getAuthors().add(martin);
		authorRepository.save(martin);
		publisherRepository.save(packt);
		bookRepository.save(book2);

	}

}
