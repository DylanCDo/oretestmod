package net.soybeans.oretestmod.block;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.soybeans.oretestmod.OreTestMod;
import net.soybeans.oretestmod.item.ModItems;

import java.util.function.Function;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(OreTestMod.MODID);

    public static final DeferredBlock<Block> BISMUTH_BLOCK =
            registerBlock("bismuth_block",
                    properties -> new Block(properties.strength(4f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.ANCIENT_DEBRIS)));

    public static final DeferredBlock<Block> BISMUTH_ORE =
            registerBlock("bismuth_ore",
                    properties -> new DropExperienceBlock(UniformInt.of(2,4),properties.strength(4f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> BISMUTH_DEEPSLATE_ORE =
            registerBlock("bismuth_deepslate_ore",
                    properties -> new DropExperienceBlock(UniformInt.of(2,4),properties.strength(4f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.DEEPSLATE)));

    public static ResourceKey<Block> getRK(Block block){
        return BuiltInRegistries.BLOCK.getResourceKey(block).get();
    }

    private static <T extends Block> void registerBlockItems(String name, DeferredBlock block) {
        ModItems.ITEMS.registerItem(name, properties -> new BlockItem((Block) block.get(),
                properties.useBlockDescriptionPrefix()));
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItems(name, toReturn);
        return toReturn;
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
