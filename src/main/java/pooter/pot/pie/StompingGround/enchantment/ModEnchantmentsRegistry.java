package pooter.pot.pie.StompingGround.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class ModEnchantmentsRegistry {
    public static SwinglineInator SWINGLINEINATOR;
    public static ConcussiveInator CONCUSSIVEINATOR;

    @SubscribeEvent
    public static void registerEnchantment(RegistryEvent.Register<Enchantment> event){
        SWINGLINEINATOR = new SwinglineInator();
        CONCUSSIVEINATOR = new ConcussiveInator();

        event.getRegistry().registerAll(SWINGLINEINATOR,CONCUSSIVEINATOR); //We can also use DefferedRegister<T>

    }
}
