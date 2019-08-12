package gildedRose;

public class AgedBrie implements SellItem {
    @Override
    public void updateQuality(Item item) {
        item.decreaseSellIn();
        item.safeIncreaseQuality();
        if (item.getSellIn() < 0) {
            item.safeIncreaseQuality();
        }
    }
}
