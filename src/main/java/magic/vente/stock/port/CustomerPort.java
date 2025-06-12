package magic.vente.stock.port;

import magic.vente.stock.domain.model.Customer;

public interface CustomerPort {
    void create(Customer customer);
    void retrieve(long id);
}
