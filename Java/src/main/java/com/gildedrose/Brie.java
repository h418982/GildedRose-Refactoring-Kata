package com.gildedrose;

public class Brie implements ItemInterface {

    private final Item item;

    public Brie (Item item){
        this.item = item;
    }

    public void updateItem(){
        decreaseSellIn();
        increaseQuality();
    }

    public void decreaseSellIn(){
         item.sellIn--;
    }

    public void increaseQuality(){ 
        item.quality++;
    }

    
}
