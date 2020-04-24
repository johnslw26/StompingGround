package pooter.pot.pie.StompingGround.inventory;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.NonNullList;
import pooter.pot.pie.StompingGround.enchantment.ModEnchantmentsRegistry;
import pooter.pot.pie.StompingGround.items.ItemRegistry;

import java.util.Map;
import java.util.function.Supplier;

public class StompingGroundItemGroup extends ItemGroup {
    public static StompingGroundItemGroup STOMPING_GROUND;
    public final Supplier<ItemStack> iconSupplier;

    public StompingGroundItemGroup(String name, Supplier<ItemStack> supplier) {
        super(name);
        this.iconSupplier = supplier;
        this.setTabPath("stomping_ground");
        STOMPING_GROUND =  this;
    }

    @Override
    public ItemStack createIcon() {
        return iconSupplier.get();
    }

    @Override
    public void fill(NonNullList<ItemStack> items) {


        items.add(new ItemStack(ItemRegistry.boneFragmentItem));

        //Enchantments
        NonNullList<ItemStack> enchantedBooks = NonNullList.create();

        Items.ENCHANTED_BOOK.fillItemGroup(ItemGroup.SEARCH, enchantedBooks);

        for (ItemStack item : enchantedBooks) {
            EnchantedBookItem enchantedBook = item.getItem() instanceof EnchantedBookItem ? (EnchantedBookItem)item.getItem() : null;
            Map<Enchantment, Integer> enchantment = EnchantmentHelper.func_226652_a_(enchantedBook.getEnchantments(item));
            if (enchantment.containsKey(ModEnchantmentsRegistry.CONCUSSIVEINATOR) || enchantment.containsKey(ModEnchantmentsRegistry.SWINGLINEINATOR) && enchantedBook != null) {
                items.add(item);
            }
        }



    }

}
