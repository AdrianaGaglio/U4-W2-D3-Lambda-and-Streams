package it.epicode.esercizio_1;

import it.epicode.classes.Product;

import java.util.List;
import java.util.stream.Collectors;

public class GetProducts {

    // Metodo per ottenere una lista di prodotti appartenenti a una specifica categoria
    public static List<Product> getProductsByCategory(String category, List<Product> products) {
        // Converte la lista di prodotti in uno stream per lavorare su di essa
        return products.stream()
                // Filtra solo i prodotti che appartengono alla categoria specificata
                .filter(product -> product.getCategory().equals(category))
                // Converte di nuovo lo stream filtrato in una lista
                .toList();
    }

    // Metodo per ottenere una lista di prodotti con prezzo maggiore di 100
    public static List<Product> getProductsAbove100(List<Product> products) {
        // Converte la lista di prodotti in uno stream
        return products.stream()
                // Filtra solo i prodotti con prezzo maggiore di 100
                .filter(product -> product.getPrice() > 100)
                // Converte di nuovo lo stream filtrato in una lista
                .toList();
    }

    // Metodo per ottenere una lista di prodotti della categoria "Books" con prezzo maggiore di 100
    public static List<Product> getBooksAbove100(List<Product> products) {
        // Converte la lista di prodotti in uno stream
        return products.stream()
                // Filtra i prodotti che appartengono alla categoria "Books"
                .filter(product -> product.getCategory().equals("Books"))
                // Filtra ulteriormente i prodotti con prezzo maggiore di 100
                .filter(product -> product.getPrice() > 100)
                // Converte di nuovo lo stream filtrato in una lista
                .toList();
    }
}

/*
SPIEGAZIONE DEL CODICE:

getProductsByCategory => Questo metodo accetta una categoria (String category) e una lista di prodotti.
                         Usa stream() per creare un flusso dei prodotti.
                         Filtra i prodotti che appartengono solo alla categoria specificata usando il metodo filter.
                         Restituisce una lista di prodotti appartenenti a quella categoria.

getProductsAbove100 => Accetta una lista di prodotti e restituisce una lista filtrata con solo i prodotti che hanno un prezzo maggiore di 100.
                       Usa lo stesso approccio: crea un flusso con stream(), applica un filtro con filter e converte il risultato in una lista con toList().

getBooksAbove100 =>    Accetta una lista di prodotti e restituisce i prodotti che appartengono alla categoria "Books" e hanno un prezzo maggiore di 100.
                       Usa due filtri:
                       - Il primo per filtrare i prodotti appartenenti alla categoria "Books".
                       - Il secondo per filtrare i prodotti con prezzo maggiore di 100.
*/

/*
Come funziona stream() e i metodi utilizzati
stream() => Consente di lavorare con i dati in modo funzionale.
filter() => Applica una condizione per includere solo i prodotti che soddisfano quel criterio.
toList() => Converte il flusso risultante in una lista.
*/
