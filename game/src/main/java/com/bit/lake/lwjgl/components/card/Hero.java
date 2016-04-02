package com.bit.lake.lwjgl.components.card;

import com.bit.lake.lwjgl.components.ComponentTextureName;

/**
 * Created by tom on 02.04.2016.
 */
public class Hero extends Card {

    private int life;
    private int currentLife;
    private int attackStrength;

    private String name;

    public Hero(float x, float y, ComponentTextureName textureName, final int currentMaxLife, final int currentMaxAttackStrength) {
        super(x, y, textureName);
        this.life = currentMaxLife;
        this.attackStrength = currentMaxAttackStrength;
    }

    public void sufferDamage(int damage) {
        int currentLifeAmount = getLife();
        currentLifeAmount -= damage;
        setLife(currentLifeAmount);
    }

    public void decreaseAttackDamage(int decreaseHigh) {
        int currentDamageAmount = getAttackStrength();
        currentDamageAmount -= decreaseHigh;
        setAttackStrength(currentDamageAmount);
    }

    public void increaseAttackDamage(int increaseHigh) {
        int currentAttackStrength = getAttackStrength();
        currentAttackStrength += increaseHigh;
        setAttackStrength(currentAttackStrength);
    }

    public void resetLife() {
        life = getLife();
        setCurrentLife(life);
    }

    public void increaseLife(int increaseHigh) {
        int currentLife = getLife();
        currentLife += increaseHigh;
        setLife(currentLife);
    }


    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getCurrentLife() {
        return currentLife;
    }

    public void setCurrentLife(int currentLife) {
        this.currentLife = currentLife;
    }

    public int getAttackStrength() {
        return attackStrength;
    }

    public void setAttackStrength(int attackStrength) {
        this.attackStrength = attackStrength;
    }

    @Override
    protected void handleMouseEvent() {

    }
}
