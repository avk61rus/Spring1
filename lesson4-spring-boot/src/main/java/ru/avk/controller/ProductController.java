package ru.avk.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.avk.persist.Product;
import ru.avk.persist.ProductRepository;
import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;

    @GetMapping
    public String listPage(@Valid Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "product";
    }

    @GetMapping("{id}")
    public String form(@PathVariable("id") long id, Model model) {
        model.addAttribute("product", productRepository.findById(id));
//        .orElseThrow(() -> new  EntityNotFoundException("Пользователь не найден")));
        return "product_form";
    }

    @GetMapping("/new")
    public String addNewProduct( Model model) throws NumberFormatException{
        model.addAttribute("product", new Product("", 10000, 100 ));
        return "product_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteProductById(@PathVariable long id)  {
        productRepository.delete(id);
        return "redirect:/product";
    }

    @PostMapping
    public String saveProduct(@Valid Product product, BindingResult bindingResult) throws NumberFormatException{
        if (bindingResult.hasErrors()) {
            return "product_form";
        }

    log.info("метод saveUser выполнен удачно");
        System.out.println("product.getId() = " + product.getId());
        System.out.println("product.getVendorCode() = " + product.getVendorCode());
        System.out.println("product.getUsername() = " + product.getProductName());
        System.out.println("product.getCost" + product.getCost());

        productRepository.save(product);
        return "redirect:/product";
    }

    @PostMapping("/update")
    public String updateProduct(Product product) {
        log.info("метод updateUser выполнен удачно");
        System.out.println("product.getId() = " + product.getId());
        System.out.println("product.getUsername() = " + product.getProductName());

        productRepository.save(product);
        return "redirect:/product";
    }
}

