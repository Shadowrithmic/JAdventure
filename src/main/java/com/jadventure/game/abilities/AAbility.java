package com.jadventure.game.abilities;

import com.jadventure.game.entities.Entity;

/**
 * superclass of all abilities
 */
public abstract class AAbility {
    private int damage;

    public AAbility(int damage){
        this.damage = damage;
    }

    public void cast(Entity target){
        target.setHealth(target.getHealth() - damage);
    }

    public int getDamage(){
        return damage;
    }

    public void setDamage(int damage){
        this.damage = damage;
    }
}
