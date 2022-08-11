package ru.avk;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/product")
public class ProductServlet extends HttpServlet {

    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
        this.productRepository = new ProductRepository();
        this.productRepository.insert(new Product("Монитор 24'' ", 8000L));
        this.productRepository.insert(new Product("Мышь оптическая", 750L));
        this.productRepository.insert(new Product("Клавиатура", 1550L));
        this.productRepository.insert(new Product("Жесткий диск", 3500L));
        this.productRepository.insert(new Product("Внешний накопитель",4500L));
        this.productRepository.insert(new Product("Принтер", 12000L));
        this.productRepository.insert(new Product("Колонки",2145L));
        this.productRepository.insert(new Product("Флеш память", 680L));
        this.productRepository.insert(new Product("Модуль памяти", 1620L));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("<table>");
        writer.println("<tr>");
        writer.println("<th>id</th>");
        writer.println("<th>Product</th>");
        writer.println("<th>Cost</th>");
        writer.println("</tr>");

        for (Product product : productRepository.findAll()) {
            writer.println("<tr>");
            writer.println("<td>" + product.getId() +   " </td>");
            writer.println("<td>" + product.getTitle() + " </td>");
            writer.println("<td>" + product.getCost() +  "</td>");
            writer.println("</tr>");
        }
        writer.println("</table>");
    }
}
