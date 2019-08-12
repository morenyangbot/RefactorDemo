package gildedRose;

public class Item {
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;

    public String name;

    public int sellIn;

    public int quality;

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

    public void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void updateQuality() {
        switch (name) {
            case "Sulfuras, Hand of Ragnaros":
                new Sulfuras().updateQuality(this);
                break;
            case "Aged Brie":
                new AgedBrie().updateQuality(this);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                new BackstagePass().updateQuality(this);
                break;
            default:
                new NormalSellItem().updateQuality(this);
                break;

        }
    }

    public void decreaseSellIn() {
        sellIn -= 1;
    }

    public void safeDecreaseQuality() {
        if (quality > MIN_QUALITY) {
            quality = quality - 1;
        }
    }

    public void safeIncreaseQuality() {
        if (quality < MAX_QUALITY) {
            quality = quality + 1;
        }
    }

}
