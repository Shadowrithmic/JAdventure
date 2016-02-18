package com.jadventure.game.abilities.spells;

import com.jadventure.game.abilities.AAbility;
import com.jadventure.game.entities.Entity;

abstract public class ASpell extends AAbility{
    private int manaCost;

    public ASpell(int cost, int damage){
        super(damage);
        manaCost = cost;
    }

   public boolean payCost(Entity caster){
        if(this.manaCost <= 0){
            return true;
        } else {
            int mana = caster.getMana();
            if (mana >= this.manaCost){
               caster.setMana(mana - this.manaCost);
               return true;
            } else {
                return false;
            }
        }
   }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int cost){
        this.manaCost = cost;
    }

    public void cast(Entity caster, Entity target) {
        if (this.payCost(caster)) {
            super.cast(target);
        }
    }

    @Override
    public void cast(Entity target){
        throw new UnsupportedOperationException("Cannot cast a Spell without a caster.");
    }
}
