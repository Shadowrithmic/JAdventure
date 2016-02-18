package com.jadventure.game.abilities;

import com.jadventure.game.entities.Entity;

/**
 * superclass of all abilities
 */
public abstract class AAbility {
    private int cost;
    private String cost_type;
    private int damage;

    abstract public void cast(Entity target, Entity caster);

    public int getCost(){
        return this.cost;
    }

    public String getCost_type(){
        return this.cost_type;
    }
}
