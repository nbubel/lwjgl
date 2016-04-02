package com.bit.lake.lwjgl.components.card;

/**
 * Created by tom on 02.04.2016.
 */
public class Card {

    private String name;

    private int converetedResources;
    private int costsResourceZero;
    private int costsResourceOne;
    private int costsResourceTwo;
    private int costsResourceThree;
    private int costsResourceFour;
    private int costsResourceFive;

    public Card()
    {
        name = "";
    }

    public int checkConvertedResources()
    {
        int convertedResources = costsResourceOne + costsResourceTwo + costsResourceThree + costsResourceFour + costsResourceFive;
        return convertedResources;
    }

}
