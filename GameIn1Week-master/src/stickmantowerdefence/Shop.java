
package stickmantowerdefence;

public class Shop {
    
    public void upgradeWarriorHealth()
    {
        Warrior.setHealthFactor(Warrior.getHealthFactor()+1);
    }
    
    public void upgradMageHeath(){
        Mage.setHealthFactor(Mage.getHealthFactor()+1);
    }
    
    public void upgradeArcherHealth(){
        Archer.setHealthFactor(Archer.getHealthFactor()+1);
    }
    
    public void upgradeHealerHealth(){
        Healer.setHealthFactor(Healer.getHealthFactor()+1);
    }
    
    public void upgradeMageMana(){
        Mage.setManaFactor(Mage.getManaFactor()+1);
    }
    
    public void upgradeMageRegen(){
        Mage.setManaRegenFactor(Mage.getManaRegenFactor()+1);
    }
    
    public void upgradeHealerMana(){
        Healer.setManaFactor(Mage.getManaFactor()+50);
    }
    
    public void upgradeHealerRegen(){
        Healer.setManaRegenFactor(Healer.getManaRegenFactor()+1);
    }
    
    public void upgradeArcherRange(){
        Archer.setRangeFactor(Archer.getRangeFactor()+1);
    }
    
    public void upgradeMageRange(){
        Mage.setRangeFactor(Mage.getRangeFactor()+1);
    }
    
    public void upgradeHealerRange(){
        Healer.setRangeFactor(Healer.getRangeFactor()+1);
    }
    
    public void upgradeWarriorDamage(){
        Warrior.setDamageFactor(Warrior.getDamageFactor()+1);
    }
    
    public void upgradeMageDamage(){
        Mage.setDamageFactor(Mage.getDamageFactor()+1);
    }
    
    public void upgradeArcherDamage(){
        Archer.setDamageFactor(Archer.getDamageFactor()+1);
    }
}
