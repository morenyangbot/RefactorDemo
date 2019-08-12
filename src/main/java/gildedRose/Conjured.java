package gildedRose;

public class Conjured implements SellItem {
    @Override
    public void updateQuality(Item item) {
        item.decreaseSellIn();
        item.safeDecreaseQuality();
        item.safeDecreaseQuality();
        if (item.getSellIn() < 0) {
            item.safeDecreaseQuality();
            item.safeDecreaseQuality();
        }
    }
}
