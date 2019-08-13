package gildedRose;

public class SellItemFactory {

    private static final String AGED_BRIE_NAME = "Aged Brie";
    private static final String BACKSTAGE_PASS_NAME = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_NAME = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED_NAME = "Conjured";

    public static SellItem getSellItem(String name) {
        switch (name) {
            case AGED_BRIE_NAME:
                return new AgedBrie();
            case BACKSTAGE_PASS_NAME:
                return new BackstagePass();
            case SULFURAS_NAME:
                return new Sulfuras();
            case CONJURED_NAME:
                return new Conjured();
            default:
                return new NormalSellItem();
        }
    }
}
