package pooter.pot.pie.StompingGround.enchantment;

import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;

public class ModEnchantmentType {
    public static final EnchantmentType WEAPON = EnchantmentType.create("weapons", (item)->{ return item instanceof SwordItem; });
    public static final EnchantmentType STICK = EnchantmentType.create("stick", (item)->{ return item == Items.STICK; });
}
