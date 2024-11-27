package it.epicode;

import it.epicode.classes.Customer;
import it.epicode.classes.Order;
import it.epicode.classes.Product;
import it.epicode.esercizio_1.GetProducts;
import it.epicode.esercizio_2.GetOrders;
import it.epicode.esercizio_3.ApplyDiscount;
import it.epicode.esercizio_4.OrderedProductByTier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // creo catalogo prodotti
        List<Product> catalog = new ArrayList<>();
        Product p1 = new Product(1L, "Libro 1", "Books", 110.0);
        Product p2 = new Product(2L, "Libro 2", "Books", 80.0);
        Product p3 = new Product(3L, "Libro 3", "Books", 115.0);
        Product p4 = new Product(4L, "Pannolini", "Baby", 15.0);
        Product p5 = new Product(5L, "Biberon", "Baby", 8.0);
        Product p6 = new Product(6L, "Tutina", "Baby", 20.0);

        catalog.add(p1);
        catalog.add(p2);
        catalog.add(p3);
        catalog.add(p4);
        catalog.add(p5);
        catalog.add(p6);

        // ottengo i prodotti della categoria "Books" che costano più di 100
        List<Product> books = GetProducts.getBooksAbove100(catalog);
        System.out.println("=> Books above 100:");
        // stampo ogni singolo prodotto
        books.forEach(book -> System.out.println("Book: " + book.getName() + " - Price: " + book.getPrice()));

        // creo clienti
        Customer c1 = new Customer(111L, "Mario Rossi", 2);
        Customer c2 = new Customer(112L, "Giovanni Verdi", 3);
        Customer c3 = new Customer(115L, "Luigi Bianchi", 2);

        // creo ordini
        Order o1 = new Order(11L, "completed", LocalDate.of(2021, 02, 14), LocalDate.of(2021, 2, 14), c1);
        Order o2 = new Order(12L, "completed", LocalDate.of(2021, 11, 27), LocalDate.of(2021, 11, 30), c2);
        Order o3 = new Order(13L, "completed", LocalDate.of(2021, 03, 21), LocalDate.of(2021, 3, 21),  c3);

        // aggiungo prodotti agli ordini creati
        o1.getProducts().add(p2);
        o1.getProducts().add(p3);
        o1.getProducts().add(p1);

        o2.getProducts().add(p4);
        o2.getProducts().add(p5);

        o3.getProducts().add(p1);
        o3.getProducts().add(p4);

        // creo lista di ordini
        List<Order> orders = new ArrayList<>();
        orders.add(o1);
        orders.add(o2);
        orders.add(o3);

        // ottengo la lista di ordini che contengono prodotti nella categoria Baby
        List<Order> babyOrders = GetOrders.getOrdersByProductCategory(orders, "Baby");

        System.out.println("=> Orders with products in Baby category:");
        babyOrders.forEach(order -> {
            System.out.println("Order nr. " + order.getId() + " contains Baby category products");
        });

        // aggiungo nuovi prodotti per la categoria Boys
        Product p7 = new Product(10L, "Hat", "Boys", 10.0);
        Product p8 = new Product(10L, "T-Shirt", "Boys", 25.0);
        catalog.add(p7);
        catalog.add(p8);

        // stampo il catalogo
        System.out.println("=> Products list before discount:");
        catalog.forEach(product -> System.out.println("Product: " + product.getName() + ", Price: " + product.getPrice()));

        // ottengo la lista di prodotti con prezzo scontato per la categoria Boys
        List<Product> updatedCatalog = ApplyDiscount.addDiscountToBoys(catalog);

        System.out.println("=> Products list after discount for Boys category:");
        updatedCatalog.forEach(product -> System.out.println("Product: " + product.getName() + ", Price: " + Math.floor(product.getPrice())));

        // ottengo lista di prodotti ordinati da clienti con tier == 2
        Set<Product> orderedProducts = OrderedProductByTier.getOrderedProductsByTier(orders);

        System.out.println("Products list for tier 2 ordered between 01-feb-2021 and 01-04-2021:");
        orderedProducts.forEach(product -> System.out.println("Product:" + product.getName()));

    }
}