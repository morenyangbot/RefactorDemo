package gildedRose;

import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.*;

public class GildedRoseTest {
    private static final String NORMAL_ITEM_NAME = "Normal Item";
    private static final String AGED_BRIE_NAME = "Aged Brie";
    private static final String BACKSTAGE_NAME = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_NAME = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED = "Conjured";

    @Test
    public void shouldReturn19_givenANormalItemSellInIs10AndQualityIs20() {
        Item item = new Item(NORMAL_ITEM_NAME, 10, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(19, item.getQuality());
    }

    @Test
    public void shouldReturn18_givenANormalItemSellInIs0AndQualityIs20() {
        Item item = new Item(NORMAL_ITEM_NAME, 0, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(18, item.getQuality());
    }

    @Test
    public void shouldReturn0_givenANormalItemSellInIs10AndQualityIs0() {
        Item item = new Item(NORMAL_ITEM_NAME, 10, 0);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(0, item.getQuality());
    }

    @Test
    public void shouldReturn41_givenAgedBrieSellInIs10AndQualityIs40() {
        Item item = new Item(AGED_BRIE_NAME, 10, 40);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(41, item.getQuality());
    }

    @Test
    public void shouldReturn50_givenAgedBrieSellInIs10AndQualityIs50() {
        Item item = new Item(AGED_BRIE_NAME, 10, 50);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(50, item.getQuality());
    }

    @Test
    public void shouldReturn50_givenAgedBrieSellInIs0AndQualityIs48() {
        Item item = new Item(AGED_BRIE_NAME, 0, 48);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(50, item.getQuality());
    }

    @Test
    public void shouldReturn50_givenAgedBrieSellInIs0AndQualityIs49() {
        Item item = new Item(AGED_BRIE_NAME, 0, 49);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(50, item.getQuality());
    }

    @Test
    public void shouldReturn21_givenBackstageISellInIs10AndQualityIs20() {
        Item item = new Item(BACKSTAGE_NAME, 10, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(22, item.getQuality());
    }

    @Test
    public void shouldReturn50_givenBackstageISellInIs10AndQualityIs49() {
        Item item = new Item(BACKSTAGE_NAME, 10, 49);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(50, item.getQuality());
    }

    @Test
    public void shouldReturn23_givenBackstageISellInIs5AndQualityIs20() {
        Item item = new Item(BACKSTAGE_NAME, 5, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(23, item.getQuality());
    }

    @Test
    public void shouldReturn50_givenBackstageISellInIs5AndQualityIs48() {
        Item item = new Item(BACKSTAGE_NAME, 5, 48);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(50, item.getQuality());
    }

    @Test
    public void shouldReturn0_givenBackstageISellInIs0AndQualityIs20() {
        Item item = new Item(BACKSTAGE_NAME, 0, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(0, item.getQuality());
    }

    @Test
    public void shouldReturn80_givenSulfurasSellInIs10AndQualityIs80() {
        Item item = new Item(SULFURAS_NAME, 10, 80);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(80, item.getQuality());
    }

    @Test
    public void shouldReturn80_givenSulfurasSellInIs0AndQualityIs80() {
        Item item = new Item(SULFURAS_NAME, 0, 80);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(80, item.getQuality());
    }

    @Test
    public void shouldReturn18_givenAConjuredSellInIs10AndQualityIs20() {
        Item item = new Item(CONJURED, 10, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(18, item.getQuality());
    }

    @Test
    public void shouldReturn16_givenAConjuredSellInIs0AndQualityIs20() {
        Item item = new Item(CONJURED, 0, 20);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertEquals(16, item.getQuality());
    }
}