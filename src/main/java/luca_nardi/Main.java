package luca_nardi;

import luca_nardi.model.*;
import luca_nardi.repository.ElementoCatalogoRepository;
import luca_nardi.repository.PrestitoRepository;
import luca_nardi.repository.UtenteRepository;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ElementoCatalogoRepository elementoRepo = new ElementoCatalogoRepository();
        UtenteRepository utenteRepo = new UtenteRepository();
        PrestitoRepository prestitoRepo = new PrestitoRepository();

        Libro libro = new Libro();
        libro.setIsbn("978-0261102385");
        libro.setTitolo("Il Signore degli Anelli");
        libro.setAnnoPubblicazione(1954);
        libro.setNumeroPagine(1216);
        libro.setAutore("J.R.R. Tolkien");
        libro.setGenere("Fantasy");

        elementoRepo.save(libro);

        Rivista rivista = new Rivista();
        rivista.setIsbn("1234-5678-9012");
        rivista.setTitolo("National Geographic");
        rivista.setAnnoPubblicazione(2023);
        rivista.setNumeroPagine(120);
        rivista.setPeriodicita(Periodicita.MENSILE);

        elementoRepo.save(rivista);

        Utente utente = new Utente();
        utente.setNome("Mario");
        utente.setCognome("Rossi");
        utente.setDataDiNascita(new Date(90, 1, 1));
        utente.setNumeroTessera("12345");

        utenteRepo.save(utente);

        Prestito prestito = new Prestito();
        prestito.setUtente(utente);
        prestito.setElementoPrestato(libro);
        prestito.setDataInizioPrestito(new Date());

        prestitoRepo.save(prestito);

        System.out.println("Prestiti attivi:");
        for (Prestito p : prestitoRepo.findAll()) {
            System.out.println(p.getUtente().getNome() + " ha preso in prestito " + p.getElementoPrestato().getTitolo());
        }
    }
}

