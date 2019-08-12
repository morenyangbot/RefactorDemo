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
        if (name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }
        sellIn = sellIn - 1;

        if (name.equals("Aged Brie")) {
            safeIncreaseQuality();
            if (sellIn < 0) {
                safeIncreaseQuality();
            }
        } else if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
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
        } else {
            if (quality > 0) {
                quality = quality - 1;
                if (sellIn < 0) {
                    quality = quality - 1;
                }
            }
        }
    }

    private void safeIncreaseQuality() {
        if (quality < MAX_QUALITY) {
            quality = quality + 1;
        }
    }

}
