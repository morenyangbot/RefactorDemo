package gildedRose;

public class Item {


    public static final int MAX_QUALITY = 50;
    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void updateQuality() {
        switch (name) {
            case "Sulfuras, Hand of Ragnaros":
                return;
            case "Aged Brie":
                decreaseSellIn();
                safeIncreaseQuality();
                if (sellIn < 0) {
                    safeIncreaseQuality();
                }
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                decreaseSellIn();
                safeIncreaseQuality();
                if (sellIn < 10) {
                    safeIncreaseQuality();
                }

                if (sellIn < 5) {
                    safeIncreaseQuality();
                }
                if (sellIn < 0) {
                    quality = 0;
                }
                break;
            default:
                decreaseSellIn();
                if (quality > 0) {
                    quality = quality - 1;
                    if (sellIn < 0) {
                        quality = quality - 1;
                    }
                }
                break;
        }
    }

    private void decreaseSellIn() {
        sellIn -= 1;
    }

    private void safeIncreaseQuality() {
        if (quality < MAX_QUALITY) {
            quality = quality + 1;
        }
    }

}
