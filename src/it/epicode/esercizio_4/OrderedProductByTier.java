package it.epicode.esercizio_4;

import it.epicode.classes.Order;
import it.epicode.classes.Product;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderedProductByTier {

    // Metodo per ottenere un insieme di prodotti ordinati da clienti di livello 2 (Tier 2) in un intervallo di date
    public static Set<Product> getOrderedProductsByTier(List<Order> orders) {
        return orders.stream()
                // Filtra gli ordini in base alle condizioni specificate
                .filter(order -> {
                    // Definizione dell'intervallo di date: dal 01/02/2021 al 01/04/2021
                    LocalDate start = LocalDate.of(2021, 2, 1);
                    LocalDate end = LocalDate.of(2021, 4, 1);

                    // Condizioni per includere l'ordine:
                    // 1. Il cliente ha un livello Tier 2
                    // 2. La data dell'ordine è compresa tra start ed end
                    return order.getCustomer().getTier() == 2 &&
                            order.getOrderDate().isAfter(start) &&
                            order.getOrderDate().isBefore(end);
                })
                // Estrai i prodotti da ogni ordine filtrato e crea un flusso unico di prodotti
                .flatMap(order -> order.getProducts().stream())
                // Raccogli i prodotti in un Set (insieme), eliminando eventuali duplicati
                .collect(Collectors.toSet());
    }
}

/*
SPIEGAZIONE DEL CODICE:
1. Filtro sugli ordini => Il metodo filter filtra la lista di ordini basandosi su tre condizioni:
                          Il cliente associato all'ordine deve avere un livello Tier 2 (order.getCustomer().getTier() == 2).
                          La data dell'ordine deve essere successiva al 01/02/2021 (order.getOrderDate().isAfter(start)).
                          La data dell'ordine deve essere precedente al 01/04/2021 (order.getOrderDate().isBefore(end)).

2. Estrazione dei prodotti dagli ordini => Una volta filtrati gli ordini, il metodo:
                                           - Usa flatMap per estrarre la lista di prodotti da ogni ordine.
                                           - Combina tutti i prodotti in un unico flusso (stream).

3. Creazione di un Set => Con collect(Collectors.toSet()), raccoglie i prodotti in un Set.
                          Un Set è una collezione che elimina automaticamente i duplicati, quindi ogni prodotto appare solo una volta.
*/