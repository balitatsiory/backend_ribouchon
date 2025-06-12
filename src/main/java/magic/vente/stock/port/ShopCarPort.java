package magic.vente.stock.port;

import magic.vente.stock.domain.model.ShopCar;

import java.util.List;

public interface ShopCarPort {
    void create(List<ShopCar> shopCars);
}
