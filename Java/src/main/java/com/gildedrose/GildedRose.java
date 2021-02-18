package com.gildedrose;

class GildedRose {
    
    private static final int lowestQuality = 0;
    Item[] items;

    public GildedRose(Item[] items){
        this.items = items;
    }

    public void updateQuality(){
        for (Item item : items){
            itemInterface(item).updateItem();
            if (isLowestQuality(item)){
                item.quality = lowestQuality;
            }else if (isHighestQuality(item)){
                item.quality = QualityValues.highesQuality(item);
            }
        }
    }

    private ItemInterface itemInterface(Item item){
        return new ItemImplementation(item).itemInterface(item);
    }

    private boolean isLowestQuality(Item item){
        return item.quality < lowestQuality;
    }

    private boolean isHighestQuality(Item item){
        return item.quality > QualityValues.highesQuality(item);
    }
   
}