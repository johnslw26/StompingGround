package pooter.pot.pie.StompingGround.network.packets;


import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pooter.pot.pie.StompingGround.StompingGround;

import java.util.function.Supplier;

public class LeftClickPKT {
    private final String data;

    public LeftClickPKT(String sentData) {
        this.data = sentData;
    }

    /*
        Called with the packet instance and buffer to write the data
     */
    public void encode(PacketBuffer buf) {
        buf.writeString(this.data);
    }

    //This will be called with the byte stream data and must decode it into an instance of your packet
    public static LeftClickPKT decode(PacketBuffer buf) {
        return new LeftClickPKT(buf.toString());
    }

    //This will be called to handle your message
    public static class Handler{

        private static final Logger LOGGER = LogManager.getLogger();

        public static void handler(LeftClickPKT pkt, Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork(() -> {
                try {
                ServerPlayerEntity player = ctx.get().getSender();
                    if(!player.getServerWorld().isRemote()) {
                            double healingRatio = Math.ceil(player.getMaxHealth() * (Math.random() / 8));
                            float adjustedHealth = (float) (player.getHealth() + healingRatio);

                            if (player.getFoodStats().getFoodLevel() > 0) {
                                player.getFoodStats().addExhaustion(((float) healingRatio) * 4.8f);
                                player.setHealth(adjustedHealth);
                            }
                    }
                } catch (NullPointerException e) {
                    StompingGround.LOGGER.info(e.getMessage());
                }
            });
        }
    }
}
