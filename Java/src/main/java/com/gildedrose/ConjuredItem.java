package com.gildedrose;

public class ConjuredItem extends StandardItem {
    
    public ConjuredItem(Item item){
        super(item);
    }

    @Override
    public int decreaseValueOverZeroDays(){
        return 2;
    }
    
}
