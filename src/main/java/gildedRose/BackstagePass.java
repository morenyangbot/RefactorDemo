package gildedRose;

public class BackstagePass implements SellItem {
    @Override
    public void updateQuality(Item item) {
        item.decreaseSellIn();
        item.safeIncreaseQuality();
        if (item.getSellIn() < 10) {
            item.safeIncreaseQuality();
        }

        if (item.getSellIn() < 5) {
            item.safeIncreaseQuality();
        }
        if (item.getSellIn() < 0) {
            item.setQuality(0);
        }
    }
}
