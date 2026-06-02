package com.library.controller;

import com.library.entity.Book;
import com.library.entity.User;
import com.library.repository.BookRepository;
import com.library.repository.UserRepository;
import com.library.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private UserRepository userRepository;

    // ================= REGISTER PAGE =================

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    // ================= SAVE USER =================

    @PostMapping("/saveUser")
    public String saveUser(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password
    ) {

        User user = new User();

        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        userRepository.save(user);

        System.out.println("USER REGISTERED");

        return "login";
    }

    // ================= LOGIN PAGE =================

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    // ================= LOGIN CHECK =================

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {

        User user =
                userRepository.findByNameAndPassword(username, password);

        if (user != null) {

            System.out.println("LOGIN SUCCESS");

            return "redirect:/dashboard";
        }

        System.out.println("INVALID LOGIN");

        return "login";
    }

    // ================= DASHBOARD =================

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        List<Book> books = bookRepository.findAll();

        long total = books.size();
        long issued = books.stream().filter(Book::isIssued).count();
        long available = books.stream().filter(b -> !b.isIssued()).count();

        model.addAttribute("books", books);
        model.addAttribute("total", total);
        model.addAttribute("issued", issued);
        model.addAttribute("available", available);

        return "dashboard";
    }

    // ================= ADD BOOK PAGE =================

    @GetMapping("/addBook")
    public String addBookPage() {
        return "add-book";
    }

    // ================= SAVE BOOK =================

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute Book book) {

        book.setIssued(false);

        bookRepository.save(book);

        return "redirect:/dashboard";
    }

    // ================= ISSUE BOOK =================

    @GetMapping("/issueBook/{id}")
    public String issueBook(@PathVariable Long id) {

        Book book = bookRepository.findById(id).orElse(null);

        if (book != null) {

            book.setIssued(true);

            bookRepository.save(book);
        }

        return "redirect:/dashboard";
    }

    // ================= RETURN BOOK =================

    @GetMapping("/returnBook/{id}")
    public String returnBook(@PathVariable Long id) {

        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        book.setIssued(false);

        bookRepository.save(book);

        return "redirect:/dashboard";
    }

    // ================= ISSUE PAGE =================

    @GetMapping("/issue-book")
    public String issueBookPage() {
        return "issue-book";
    }

    // ================= SEARCH =================

    @GetMapping("/search")
    public String searchBook(@RequestParam String keyword,
                             Model model) {

        List<Book> books =
                bookRepository.findByTitleContaining(keyword);

        long total = books.size();

        long issued =
                books.stream().filter(Book::isIssued).count();

        long available =
                books.stream()
                        .filter(b -> !b.isIssued())
                        .count();

        model.addAttribute("books", books);
        model.addAttribute("total", total);
        model.addAttribute("issued", issued);
        model.addAttribute("available", available);

        return "dashboard";
    }

    // ================= EDIT BOOK =================

    @GetMapping("/editBook/{id}")
    public String editBook(@PathVariable Long id, Model model) {

        Book book = bookService.getBookById(id);

        if (book == null) {
            return "redirect:/dashboard";
        }

        model.addAttribute("book", book);

        return "editBook";
    }

    // ================= UPDATE BOOK =================

    @PostMapping("/updateBook")
    public String updateBook(@ModelAttribute Book book) {

        bookService.saveBook(book);

        return "redirect:/dashboard";
    }

    // ================= DELETE BOOK =================

    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable Long id) {

        bookService.deleteBook(id);

        return "redirect:/dashboard";
    }

    // ================= LOGOUT =================

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
}