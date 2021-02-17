package com.gildedrose;

public class BackStagePass implements itemInterface {

    private final Item item;

    public BackStagePass(Item item){
        this.item = item;
    }
    public void updateItem(){
        decreaseSellIn();
        if (checkSellIn(10)){
            increaseQualityByAmount(1);
        }else if (checkSellIn(5)){
            increaseQualityByAmount(2);
        }else if (checkSellIn(0)){
            increaseQualityByAmount(3);
        }else{
            zeroOutQuality();
        }

    }

    private boolean checkSellIn (int numCheck){
        return item.sellIn > numCheck;
    }

    private void decreaseSellIn(){
        item.sellIn -= 1;
    }

    private void increaseQualityByAmount(int numCheck){
        item.quality += numCheck;
    }

    private void zeroOutQuality(){
        item.quality = 0;
    }
    
}
