package pooter.pot.pie.StompingGround.util;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pooter.pot.pie.StompingGround.enchantment.ModEnchantmentsRegistry;
import pooter.pot.pie.StompingGround.network.StompingGroundPacketHandler;
import pooter.pot.pie.StompingGround.network.packets.LeftClickPKT;

import java.util.Map;

@Mod.EventBusSubscriber
public class StompingGroundEventHandler {

    private static final Logger LOGGER = LogManager.getLogger();

    @SubscribeEvent
    public static void onPlayerLeftClicksEmptySpace(PlayerInteractEvent.LeftClickEmpty event){
        if(event.getWorld().isRemote) {
            PlayerEntity player = event.getPlayer();
            Map.Entry<EquipmentSlotType, ItemStack> enchantments = EnchantmentHelper.func_222189_b(ModEnchantmentsRegistry.SWINGLINEINATOR,player);

            if(enchantments != null){
                ItemStack enchantedItems = enchantments.getValue();
                if(!enchantedItems.isEmpty() && player.getHealth() != player.getMaxHealth() && !player.isCreative()) {
                    StompingGroundPacketHandler.HANDLER.sendToServer(new LeftClickPKT("No Reason For This But Hey, I guess it works. Learning experience. Learn more about networking and SimplChannel"));
                }
            }
        }
    }
}
