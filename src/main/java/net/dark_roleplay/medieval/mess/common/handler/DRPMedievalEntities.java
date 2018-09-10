package net.dark_roleplay.medieval.mess.common.handler;

import java.awt.Color;

import net.dark_roleplay.medieval.mess.common.DarkRoleplayMedieval;
import net.dark_roleplay.medieval.mess.common.References;
import net.dark_roleplay.medieval.mess.common.objects.entities.Wheelbarrel;
import net.dark_roleplay.medieval.mess.common.objects.entities.fox.Entity_Fox;
import net.dark_roleplay.medieval.mess.common.objects.entities.rope_slide.RopeSlider;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

@ObjectHolder(References.MODID)
@Mod.EventBusSubscriber
public class DRPMedievalEntities {

    private static int entityID = 0;

	
	@SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityEntry> event) {
        final IForgeRegistry<EntityEntry> reg = event.getRegistry();
        
//        reg.register(createBuilder("wheelbarrel").entity(Wheelbarrel.class).tracker(32, 3, true).build());        
        reg.register(createBuilder("fox").entity(Entity_Fox.class).tracker(32, 3, true).egg(new Color(255, 100, 0).getRGB(), new Color(200, 200, 200).getRGB()).build());
        reg.register(createBuilder("rope_slider").entity(RopeSlider.class).tracker(32, 10, true).build());

    }


    private static <E extends Entity> EntityEntryBuilder<E> createBuilder(final String name) {
        final EntityEntryBuilder<E> builder = EntityEntryBuilder.create();
        final ResourceLocation registryName = new ResourceLocation(References.MODID, name);
        return builder.id(registryName, entityID++).name(References.MODID + "." + name);
    }
}