package com.gildedrose;

public class SpecialItem extends StandardItem {

    public SpecialItem(Item item){
        super(item);
    }

    @Override
    public int decreaseValueOverZeroDays(){
        return 2;
    }
    
}
