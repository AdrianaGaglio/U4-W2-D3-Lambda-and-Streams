package it.epicode.esercizio_3;

import it.epicode.classes.Product;
import it.epicode.esercizio_1.GetProducts;

import java.util.List;
import java.util.stream.Collectors;

public class ApplyDiscount {

    // Metodo per applicare uno sconto del 10% ai prodotti della categoria "Boys"
    public static List<Product> addDiscountToBoys(List<Product> products) {
        // Usa il metodo 'getProductsByCategory' per ottenere i prodotti della categoria "Boys"
        return GetProducts.getProductsByCategory("Boys", products).stream()
                // Trasforma ogni prodotto (usando 'map') applicando lo sconto
                .map(product -> {
                    // Calcola il nuovo prezzo con uno sconto del 10% (divide per 1.1)
                    double price = product.getPrice() / 1.1;
                    // Aggiorna il prezzo del prodotto
                    product.setPrice(price);
                    // Ritorna il prodotto aggiornato
                    return product;
                })
                // Colleziona i prodotti con il prezzo scontato in una lista
                .toList();
    }
}

/*
SPIEGAZIONE DEL CODICE:

Metodo addDiscountToBoys => Riceve una lista di prodotti (products) come input.
                            Filtra i prodotti che appartengono alla categoria "Boys" utilizzando il metodo getProductsByCategory della classe GetProducts.
                            Applica uno sconto del 10% a ciascun prodotto di quella categoria.
                            Restituisce una nuova lista di prodotti con i prezzi scontati.
*/

/*
* PASSAGGI:
Ottenere i prodotti della categoria "Boys":

* GetProducts.getProductsByCategory("Boys", products) => Questo metodo restituisce una lista di prodotti che appartengono alla categoria "Boys".

* Creare uno stream di prodotti:
.stream() => Converte la lista filtrata in uno stream per poter applicare operazioni come trasformazioni e filtri.

* Applicare lo sconto con map:

.map(product -> {
    double price = product.getPrice() / 1.1;
    product.setPrice(price);
    return product;
}) => Per ogni prodotto dello stream:
      - Calcola il nuovo prezzo dividendo il prezzo attuale per 1.1 (equivalente a uno sconto del 10%).
      - Aggiorna il prezzo del prodotto con setPrice.
      - Restituisce il prodotto aggiornato.

* Collezionare i risultati in una lista:
.collect(Collectors.toList()); => Converte lo stream di prodotti modificati in una lista.
* */
