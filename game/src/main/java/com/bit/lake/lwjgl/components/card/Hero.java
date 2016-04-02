package com.bit.lake.lwjgl.components.card;

/**
 * Created by tom on 02.04.2016.
 */
public class Hero extends Card  {

    private int life;
    private int currentLife;
    private int attackStrength;

    private String name;

    // Hero
    Hero(int deliveredLife, int deliveredAttackStrength)
    {
        life = deliveredLife;
        currentLife = life;
        attackStrength = deliveredAttackStrength;
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
        setLife(currentLife);
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
