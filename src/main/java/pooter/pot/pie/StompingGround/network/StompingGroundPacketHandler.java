package pooter.pot.pie.StompingGround.network;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import pooter.pot.pie.StompingGround.network.packets.LeftClickPKT;

public class StompingGroundPacketHandler {
    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel HANDLER = NetworkRegistry.newSimpleChannel(
            new ResourceLocation("stompingground","main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
            );

    public static void register(){
        int id = 0;
        HANDLER.registerMessage(id++, LeftClickPKT.class, LeftClickPKT::encode, LeftClickPKT::decode, LeftClickPKT.Handler::handler);
    }
}
