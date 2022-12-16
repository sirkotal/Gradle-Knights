package pt.up.fe.ldts.gd.model.player;

import java.io.IOException;

public class Player {
    private int gold;
    private String name;
    private int hp;
    private int damage;
    private Inventory inventory;

    public Player(String name) throws IOException {
        this.name = name;
        this.hp = 75;
        this.damage = 15;
        this.gold = 15;
        this.inventory = new Inventory(this);
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void addItem(Item item) {
        inventory.addItem(item);
    }

    public void removeItem(Item item) {
        inventory.removeItem(item);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getHP() {
        return hp;
    }

    public void setHP(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    public void use(Item item) {
        if(!inventory.getItems().contains(item)) {
            System.out.println("not found");
            return;
        }

        if (item instanceof PotionItem) {
            setHP(hp + item.getValue());
            inventory.removeItem(item);
        }

        if (item instanceof CombatItem) {
            int i;
            for(i = 0; i < inventory.size(); i++) {
                if(inventory.getItem(i).equals(item)) {
                    break;
                }
            }

            if(inventory.getItem(i).isUsed()) {
                inventory.getItem(i).setUsed(false);
                setDamage(damage - item.getValue());
                inventory.refreshOptions();
                return;
            }

            for(int j = 0; j < inventory.size(); j++) {
                if (inventory.getItem(j).isUsed() && inventory.getItem(j) instanceof CombatItem) {
                    inventory.getItem(j).setUsed(false);
                    setDamage(damage - item.getValue());
                }
            }
            setDamage(item.getValue() + damage);
            inventory.getItem(i).setUsed(true);
            inventory.refreshOptions();
        }
    }
}
