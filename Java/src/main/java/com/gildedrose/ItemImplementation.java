package com.gildedrose;

import java.util.Map;
import java.util.HashMap;

public class ItemImplementation {

    public static String brie = "Aged Brie";
    public static String backstagePass = "Backstage passes to a TAFKAL80ETC concert";
    public static String sulfuras = "Sulfuras, Hand of Ragnaros";
    public static String specialItem = "Special";

    private final static Map<String, itemInterface> ITEM_TYPE_MAP = new HashMap<>();

    public ItemImplementation(Item item){
        ITEM_TYPE_MAP.put(brie, new Brie(item));
        ITEM_TYPE_MAP.put(backstagePass, new BackStagePass(item));
        ITEM_TYPE_MAP.put(sulfuras, new Sulfuras());
        ITEM_TYPE_MAP.put(specialItem, new ConjuredItem(item));
    }

    private boolean isStandardItem(Item item){
        return !ITEM_TYPE_MAP.keySet().contains(item.name);
    }

    public itemInterface itemInterface(Item item){
        if (isStandardItem(item)){
            return new ConjuredItem(item);
        }else{
            return ITEM_TYPE_MAP.get(item.name);
        }
    }
    
}
