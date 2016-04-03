package com.bit.lake.lwjgl.components.card;
import com.bit.lake.lwjgl.components.ComponentTextureName;
import com.bit.lake.lwjgl.components.LocalizationKey;
import com.bit.lake.lwjgl.components.TargetAction;
import com.bit.lake.lwjgl.environments.Environment;
import com.bit.lake.lwjgl.environments.menu.GameMenu;
import com.bit.lake.lwjgl.game.GameController;
import com.bit.lake.lwjgl.utils.InternalTextureLoader;
import com.bit.lake.lwjgl.utils.MouseButton;
import org.lwjgl.input.Mouse;
/**
 * Created by tom on 02.04.2016.
 */
public class Hero extends Card  {
    private int globalMaxconvertedResources;
    private int currentMaxConvertedResources;
    private int currentConvertedResources;
    private int costsResourceZero;
    private int costsResourceOne;
    private int costsResourceTwo;
    private int costsResourceThree;
    private int costsResourceFour;
    private int costsResourceFive;
    private int globalMaxLife;
    private int currentMaxLife;
    private int currentLife;
    private int globalMaxAttackStrength;
    private int currentMaxAttackStrength;
    private int currentAttackStrength;
    private static Hero instance;
    public enum currentStatus
    {SUMMONSICKNESS, READY, TAPPED, HASBLOCKED}

    private Hero(float x, float y, ComponentTextureName textureName,  final TargetAction targetAction, String deliveredName, int deliveredCurrentMaxLife, int deliveredCurrentAttackStrength) {
        super(x, y, textureName);
        this.currentMaxLife = deliveredCurrentMaxLife;
        this.currentMaxAttackStrength = deliveredCurrentAttackStrength;
    }

    public static Hero newInstance(float x, float y, ComponentTextureName textureName, final TargetAction targetAction, String deliveredName, int deliveredCurrentMaxLife, int deliveredCurrentAttackStrength)
    {
        if (instance == null)
        {
            instance = new Hero(x, y, textureName, targetAction, deliveredName, deliveredCurrentMaxLife, deliveredCurrentAttackStrength);
        }
        return instance;
    }
    @Override
    public void renderComponent() {
        super.renderComponent();
        if(currentLife == 0)
        {
            // end game
        }
    }

    // Life
    public void decreaseCurrentLife(int damageValue)
    {
        int currentLifeHigh = getCurrentLife();
        currentLifeHigh -= damageValue;
        setCurrentLife(currentLifeHigh);
    }
    public void increaseCurrentLife(int healValue)
    {
        int currentLifeHigh = getCurrentLife();
        currentLifeHigh += healValue;
        setCurrentLife(currentLifeHigh);
    }
    public void decreaseCurrentMaxLife(int lifeDecrease)
    {
        int currentMaxLifeHigh = getCurrentMaxLife();
        currentMaxLifeHigh -= lifeDecrease;
        setCurrentMaxLife(currentMaxLifeHigh);
    }
    public void increaseCurrentMaxLife(int lifeIncrease)
    {
        int currentMaxLifeHigh = getCurrentMaxLife();
        currentMaxLifeHigh += lifeIncrease;
        setCurrentMaxLife(currentMaxLifeHigh);
    }
    // Attack Strength
    public void decreaseCurrentAttackStrength(int decreaseValue)
    {
        int currentAttackStrengthHigh = getCurrentAttackStrength();
        currentAttackStrengthHigh -= decreaseValue;
        setCurrentLife(currentAttackStrengthHigh);
    }
    public void increaseCurrentAttackStrength(int increaseValue)
    {
        int currentAttackStrengthHigh = getCurrentAttackStrength();
        currentAttackStrengthHigh += increaseValue;
        setCurrentAttackStrength(currentAttackStrengthHigh);
    }
    public void decreaseCurrentMaxAttackStrength(int maxAttackStrengthDecrease)
    {
        int currentMaxAttackStrengthHigh = getCurrentMaxAttackStrength();
        currentMaxAttackStrengthHigh -= maxAttackStrengthDecrease;
        setCurrentMaxAttackStrength(currentMaxAttackStrengthHigh);
    }
    public void increaseCurrentMaxAttackStrength(int maxAttackStrengthIncrease)
    {
        int currentMaxAttackStrengthHigh = getCurrentMaxAttackStrength();
        currentMaxAttackStrengthHigh += maxAttackStrengthIncrease;
        setCurrentMaxAttackStrength(currentMaxAttackStrengthHigh);
    }
    public void resetLife()
    {
        currentMaxLife = getCurrentMaxLife();
        setCurrentLife(currentMaxLife);
    }
    public void resetAttackStrength()
    {
        currentMaxAttackStrength = getCurrentMaxAttackStrength();
        setCurrentAttackStrength(currentMaxAttackStrength);
    }
    // Life
    public int getGlobalMaxLife()
    {
        return globalMaxLife;
    }
    public int getCurrentMaxLife()
    {
        return currentMaxLife;
    }
    public int getCurrentLife()
    {
        return currentLife;
    }
    public void setGlobalMaxLife(int globalMaxLife)
    {
        this.globalMaxLife = globalMaxLife;
    }
    public void setCurrentMaxLife(int currentMaxLife)
    {
        this.currentMaxLife = currentMaxLife;
    }
    public void setCurrentLife(int currentLife)
    {
        this.currentLife = currentLife;
    }
    // AttackStrength
    public int getGlobalMaxAttackStrength()
    {
        return globalMaxAttackStrength;
    }
    public int getCurrentMaxAttackStrength()
    {
        return currentMaxAttackStrength;
    }
    public int getCurrentAttackStrength()
    {
        return currentAttackStrength;
    }
    public void setGlobalMaxAttackStrength(int globalMaxAttackStrength)
    {
        this.globalMaxAttackStrength = globalMaxAttackStrength;
    }
    public void setCurrentMaxAttackStrength(int currentMaxAttackStrength)
    {
        this.currentMaxAttackStrength = currentMaxAttackStrength;
    }
    public void setCurrentAttackStrength(int currentAttackStrength)
    {
        this.currentAttackStrength = currentAttackStrength;
    }
}