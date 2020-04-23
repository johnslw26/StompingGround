package pooter.pot.pie.StompingGround.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ConcussiveInator extends Enchantment {


    protected ConcussiveInator() {
        super(Rarity.COMMON, ModEnchantmentType.STICK, new EquipmentSlotType[]{EquipmentSlotType.MAINHAND, EquipmentSlotType.OFFHAND});
        this.setRegistryName("concussiveinator");

        //Creates an enchanted book and applies the enchantment


    }

    @SubscribeEvent

    @Override
    public void onEntityDamaged(LivingEntity user, Entity target, int level) {
        if (!user.getEntityWorld().isRemote() && !target.getEntityWorld().isRemote()) {
            LivingEntity playerTarget = target instanceof PlayerEntity ? (LivingEntity) target : null;
            Effect concussionEffects[] = {Effects.BLINDNESS, Effects.SLOWNESS, Effects.NAUSEA};
            if (playerTarget != null && playerTarget.isAlive()) {
                for (Effect effect : concussionEffects) {
                    playerTarget.addPotionEffect(new EffectInstance(effect, 1000));
                }
            }
        }
    }
}
