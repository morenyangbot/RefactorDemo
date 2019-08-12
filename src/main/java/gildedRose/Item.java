package gildedRose;

public class Item {


    private static final int MAX_QUALITY = 50;
    private String name;

    private int sellIn;

    private int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void updateQuality() {
        switch (name) {
            case "Sulfuras, Hand of Ragnaros":
                new Sulfuras().updateQuality(this);
            case "Aged Brie":
                new AgedBrie().updateQuality(this);
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

    public void decreaseSellIn() {
        sellIn -= 1;
    }

    public void safeIncreaseQuality() {
        if (quality < MAX_QUALITY) {
            quality = quality + 1;
        }
    }

}
