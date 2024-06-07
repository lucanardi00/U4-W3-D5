package luca_nardi.servizio;

import luca_nardi.model.ElementoCatalogo;
import luca_nardi.repository.ElementoCatalogoRepository;

public class CatalogoService {
    private ElementoCatalogoRepository elementoRepo = new ElementoCatalogoRepository();

    public void aggiungiElemento(ElementoCatalogo elemento) {
        elementoRepo.save(elemento);
    }
    
}
