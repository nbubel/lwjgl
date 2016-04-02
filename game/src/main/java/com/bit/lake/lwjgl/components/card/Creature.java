package com.bit.lake.lwjgl.components.card;

/**
 * Created by tom on 02.04.2016.
 */
public class Creature {

    private String name;

    private int converetedResources;
    private int costsResourceZero;
    private int costsResourceOne;
    private int costsResourceTwo;
    private int costsResourceThree;
    private int costsResourceFour;
    private int costsResourceFive;

    private int life;
    private int attackStrength;

    private int currentLife;
    private int currentAttackStrength;



    // Creature
    public Creature(int deliveredLife, int deliveredDamage, int deliveredConvertedResources)
    {
        life = deliveredLife;
        attackStrength = deliveredDamage;
        converetedResources = deliveredConvertedResources;
    }

    public int checkConvertedResources()
    {
        int convertedResources = costsResourceOne + costsResourceTwo + costsResourceThree + costsResourceFour + costsResourceFive;
        return convertedResources;
    }

    public void sufferDamage(int damage)
    {
        int currentLifeAmount = getLife();
        currentLifeAmount -= damage;
        setLife(currentLifeAmount);
    }

    public void decreaseAttackDamage(int decreaseHigh)
    {
        int currentDamageAmount = getAttackStrength();
        currentDamageAmount -= decreaseHigh;
        setAttackStrength(currentDamageAmount);
    }

    public void increaseAttackDamage(int increaseHigh)
    {
        int currentAttackStrength = getAttackStrength();
        currentAttackStrength += increaseHigh;
        setAttackStrength(currentAttackStrength);
    }

    public void resetLife()
    {
        life = getLife();
        setCurrentLife(life);
    }

    public void increaseLife(int increaseHigh)
    {
        int currentLife = getLife();
        currentLife += increaseHigh;
        setAttackStrength(currentAttackStrength);

    }



    public int getLife()
    {
        return life;
    }

    public void setLife(int life)
    {
        this.life = life;
    }

    public int getCurrentLife()
    {
        return currentLife;
    }

    public void setCurrentLife(int currentLife)
    {
        this.currentLife = currentLife;
    }

    public int getAttackStrength()
    {
        return attackStrength;
    }

    public void setAttackStrength(int attackStrength)
    {
        this.attackStrength = attackStrength;
    }

}
