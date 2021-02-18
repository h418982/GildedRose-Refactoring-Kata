package com.gildedrose;

import java.util.Map;
import java.util.HashMap;

public class ItemImplementation {

    public static String brie = "Aged Brie";
    public static String backstagePass = "Backstage passes to a TAFKAL80ETC concert";
    public static String sulfuras = "Sulfuras, Hand of Ragnaros";
    public static String conjuredItem = "Conjured";

    private final static Map<String, ItemInterface> ITEM_TYPE_MAP = new HashMap<>();

    public ItemImplementation(Item item){
        ITEM_TYPE_MAP.put(brie, new Brie(item));
        ITEM_TYPE_MAP.put(backstagePass, new BackStagePass(item));
        ITEM_TYPE_MAP.put(sulfuras, new Sulfuras());
        ITEM_TYPE_MAP.put(conjuredItem, new ConjuredItem(item));
    }

    private boolean isStandardItem(Item item){
        return !ITEM_TYPE_MAP.keySet().contains(item.name);
    }

    public ItemInterface itemInterface(Item item){
        if (isStandardItem(item)){
            return new StandardItem(item);
        }else{
            return ITEM_TYPE_MAP.get(item.name);
        }
    }
    
}
