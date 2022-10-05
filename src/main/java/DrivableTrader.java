/* A subclass of Trader named DrivableTrader.
 * This class is identical to Trader, except that it takes
 * only Drivable objects in its inventory, wishlist, etc.
 *
 * Overrides getSellingPrice so that the return value
 * is equal to the:
 *     Object's price + Object's max speed
 * If the object is Tradable (and Tradable.MISSING_PRICE otherwise.)
 */

import java.util.List;

class DrivableTrader extends Trader<Drivable> {

    /**
     * Construct a DrivableTrader, giving them the given inventory,
     * wishlist, and money.
     *
     * @param inventory Objects in this Trader's inventory
     * @param wishlist  Objects in this Trader's wishlist
     * @param money     The Trader's money
     */
    public DrivableTrader(List<Drivable> inventory, List<Drivable> wishlist, int money) {
        super(inventory, wishlist, money);
    }

    /**
     * Construct a DrivableTrader with the given money and an empty inventory and wishlist.
     *
     * @param money The Trader's money
     */
    public DrivableTrader(int money) {
        super(money);
    }

    /**
     * Return the selling price (price + max speed) of the item, if it is Tradable.
     * If the given item is not Tradable, return Tradable.MISSING_PRICE.
     *
     * @param item The item to get the price of
     * @return If the item is Tradable, the selling price of the item, calculated as
     * (Object's price + Object's max speed); otherwise, Tradable.MISSING_PRICE
     */
    @Override
    public int getSellingPrice(Drivable item) {
        if (item instanceof Tradable) {
            return ((Tradable) item).getPrice() + item.getMaxSpeed();
        } else {
            return Tradable.MISSING_PRICE;
        }
    }

}
