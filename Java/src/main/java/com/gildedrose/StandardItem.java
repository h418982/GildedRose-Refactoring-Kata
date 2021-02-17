package com.gildedrose;

public class StandardItem implements itemInterface {

    private final Item item;

    public StandardItem(Item item){
        this.item = item;
    }

    public void updateItem(){
        decreaseSellIn();
        if (sellInOverZeroDays()){
            decreaseQuality(decreaseValueOverZeroDays());
        }else{
            decreaseQuality(decreaseValueUnderZeroDays());
        }


    }

    public void decreaseQuality(int qualityAmount){
        item.quality = item.quality - qualityAmount;
    }

    public int decreaseSellIn(){
        return item.sellIn--;
    }

    public boolean sellInOverZeroDays (){
        return item.sellIn > 0;
    }

    public int decreaseValueOverZeroDays(){
        return 1;
    }

    public int decreaseValueUnderZeroDays(){
        return decreaseValueOverZeroDays() * 2;
    }



    
}
