package net.soybeans.oretestmod.creativemodtab;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.soybeans.oretestmod.OreTestMod;
import net.soybeans.oretestmod.item.ModItems;

import java.util.function.Supplier;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, OreTestMod.MODID);

    public static void register(IEventBus eventBus){
        CREATIVE_MOD_TABS.register((eventBus));
    }

    public static final Supplier<CreativeModeTab> BISMUTH_ITEMS_TAB = CREATIVE_MOD_TABS.register("bismuth_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BISMUTH.get()))

                    .title(Component.translatable("creativetab.oretestmod.bismuth_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.BISMUTH);
                        output.accept(ModItems.RAW_BISMUTH);
                    })
                    .build()

    );
}
