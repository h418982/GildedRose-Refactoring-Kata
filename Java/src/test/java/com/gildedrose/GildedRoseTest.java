package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.gildedrose.itemInterface;
import com.gildedrose.Item;
import com.gildedrose.ItemImplementation;

class GildedRoseTest {
    private int itemSellInDayNum(GildedRose app) {
        return app.items[0].sellIn;
    }

    private int itemQualityVal(GildedRose app) {
        return app.items[0].quality;
    }

    private GildedRose newGildedRose(String itemName, int itemSellIn, int itemQuality) {
        Item[] items = new Item[] { new Item(itemName, itemSellIn, itemQuality)};
        return new GildedRose(items);
    }

    @Test
    public void sulfurasHasQualityEighty() {
        GildedRose app = newGildedRose(ItemImplementation.sulfuras, 1, 80);
        assertEquals(80, itemQualityVal(app));
    }

    @Test
    public void sulfurasNotAltered() {
        GildedRose app = newGildedRose(ItemImplementation.sulfuras, 1, 80);

        app.updateQuality();

        assertEquals(80, itemQualityVal(app));
        assertEquals(1, itemSellInDayNum(app));
    }

    @Test
    public void brieIncreaseQualityOne(){
        GildedRose app = newGildedRose(ItemImplementation.brie, 1, 1);
        app.updateQuality();
        assertEquals(2, itemQualityVal(app));
    }

    @Test
    public void brieDecreasesSellInByOne() {
        GildedRose app = newGildedRose(ItemImplementation.brie, 0, 0);
        app.updateQuality();
        assertEquals(-1, itemSellInDayNum(app));
    }

    @Test
    public void brieQualityCapsAtFifty(){
        GildedRose app = newGildedRose(ItemImplementation.brie, 1, 49);
        app.updateQuality();
        app.updateQuality();
        assertEquals(50, itemQualityVal(app));
    }

    @Test
    public void backstagePassIncreaseQualityOne(){
        GildedRose app = newGildedRose(ItemImplementation.backstagePass, 12, 1);
        app.updateQuality();
        assertEquals(2, itemQualityVal(app));
    }

    @Test
    public void backstagePassDecreasesSellInByOne() {
        GildedRose app = newGildedRose(ItemImplementation.backstagePass, 0, 0);
        app.updateQuality();
        assertEquals(-1, itemSellInDayNum(app));
    }

    @Test
    public void backstagePassesItemDecreasesQualityByOneSellInOverEleven() {
        GildedRose app = newGildedRose(ItemImplementation.backstagePass, 12, 1);
        app.updateQuality();
        assertEquals(2, itemQualityVal(app));
    }

    @Test
    public void backstagePassesItemDecreasesQualityByTwoSellInOverSix() {
        GildedRose app = newGildedRose(ItemImplementation.backstagePass, 9, 1);
        app.updateQuality();
        assertEquals(3, itemQualityVal(app));
    }

    @Test
    public void backstagePassesItemDecreasesQualityByTwoSellInOverZeroUnderSix() {
        GildedRose app = newGildedRose(ItemImplementation.backstagePass, 4, 1);
        app.updateQuality();
        assertEquals(4, itemQualityVal(app));
    }

    @Test
    public void backstagePassesItemQualityIsZeroSellInAtZero() {
        GildedRose app = newGildedRose(ItemImplementation.backstagePass, 0, 50);
        app.updateQuality();
        assertEquals(0, itemQualityVal(app));
    }

    @Test
    public void conjuredItemDecreasesQualityByOne() {
        GildedRose app = newGildedRose(ItemImplementation.conjuredItem, 0, 0);
        app.updateQuality();
        assertEquals(-1, itemSellInDayNum(app));
    }


    @Test
    public void conjuredItemQualityDecreaseSellInOverZero() {
        GildedRose app = newGildedRose(ItemImplementation.conjuredItem, 2, 5);
        app.updateQuality();
        assertEquals(3, itemQualityVal(app));
    }

    @Test
    public void standardItemDecreaseQualityByTwoSellInZero() {
        GildedRose app = newGildedRose("standard",0, 5);
        app.updateQuality();
        assertEquals(3, itemQualityVal(app));
    }

    @Test
    public void standardItemDecreasesSellInOne() {
        GildedRose app = newGildedRose("standard item", 0, 0);
        app.updateQuality();
        assertEquals(-1, itemSellInDayNum(app));
    }
    

}
