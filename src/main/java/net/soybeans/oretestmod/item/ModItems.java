package net.soybeans.oretestmod.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.soybeans.oretestmod.OreTestMod;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(OreTestMod.MODID);

    public static final DeferredItem<Item> BISMUTH =  ITEMS.registerSimpleItem("bismuth");
    public static final DeferredItem<Item> RAW_BISMUTH =  ITEMS.registerSimpleItem("raw_bismuth");

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
