package com.bit.lake.lwjgl.components.card;

import com.bit.lake.lwjgl.components.AbstractComponent;
import com.bit.lake.lwjgl.components.ComponentTextureName;

/**
 * Created by tom on 02.04.2016.
 */
public class Card extends AbstractComponent {

    protected String name;

    private int converetedResources;
    private int costsResourceZero;
    private int costsResourceOne;
    private int costsResourceTwo;
    private int costsResourceThree;
    private int costsResourceFour;
    private int costsResourceFive;

    public Card(float x, float y, ComponentTextureName textureName)
    {
        super(x, y, textureName);
    }

    @Override
    protected void handleMouseEvent() {

    }

    public int checkConvertedResources() {
        int convertedResources = costsResourceOne + costsResourceTwo + costsResourceThree + costsResourceFour + costsResourceFive;
        return convertedResources;
    }

}
