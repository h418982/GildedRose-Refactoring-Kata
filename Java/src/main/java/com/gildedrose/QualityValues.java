package com.gildedrose;

public class QualityValues {

    public static int highesQuality(Item item){
        if(item.name.equals(ItemImplementation.sulfuras)){
            return 80;
        }else{
            return 50;
        }
    }
    
}
