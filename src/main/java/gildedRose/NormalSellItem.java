package gildedRose;

public class NormalSellItem implements SellItem {
    @Override
    public void updateQuality(Item item) {
        item.decreaseSellIn();
        item.safeDecreaseQuality();
        if (item.getSellIn() < 0) {
            item.safeDecreaseQuality();
        }
    }
}

