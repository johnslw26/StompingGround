package pooter.pot.pie.StompingGround.items;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import pooter.pot.pie.StompingGround.StompingGround;

@Mod.EventBusSubscriber(modid = StompingGround.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemRegistry {
    public static SkullFragmentItem skullFragmentItem;


    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        skullFragmentItem = new SkullFragmentItem(new Item.Properties());
        event.getRegistry().registerAll(skullFragmentItem);
    }
}
