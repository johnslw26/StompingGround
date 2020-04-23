package pooter.pot.pie.StompingGround.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;

public class SwinglineInator extends Enchantment {

    protected SwinglineInator() {
        super(Rarity.COMMON, ModEnchantmentType.WEAPON, new EquipmentSlotType[]{EquipmentSlotType.MAINHAND});
        this.setRegistryName(("swinglineinator"));
    }

    @Override
    public boolean canApply(ItemStack stack) {
        return stack.getItem() instanceof SwordItem;
    }
}
