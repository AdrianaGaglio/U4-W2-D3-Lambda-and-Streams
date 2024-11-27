package it.epicode.esercizio_2;

import it.epicode.classes.Order;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GetOrders {

    // Metodo per ottenere una lista di ordini contenenti solo prodotti di una specifica categoria
    public static List<Order> getOrdersByProductCategory(List<Order> orders, String category) {
        return orders.stream()
                // Crea uno stream per lavorare con gli ordini
                .filter(order -> order.getProducts().stream()
                        // Controlla se tutti i prodotti dell'ordine appartengono alla categoria specificata
                        .allMatch(product -> product.getCategory().equals(category)))
                // Converte il risultato filtrato in una lista
                .toList();
    }
}

/*
SPIEGAZIONE DEL CODICE:

1. orders.stream() => Converte la lista di ordini (List<Order>) in uno stream, che permette di lavorare in modo funzionale sui dati.

2. .filter(order -> ...) => Filtra gli ordini per includere solo quelli che soddisfano una condizione.
                            La condizione è che tutti i prodotti di un ordine devono appartenere alla categoria specificata.

3. .allMatch(product -> ...) => Per ogni ordine, controlla i prodotti contenuti in quell'ordine.
                                Usa un altro stream sui prodotti di quell'ordine (order.getProducts().stream()).
                                allMatch => verifica se tutti i prodotti dell'ordine appartengono alla categoria fornita.
4. .toList() => Dopo aver filtrato gli ordini, converte il risultato in una lista (List<Order>).
*/
