package net.soybeans.oretestmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.soybeans.oretestmod.OreTestMod;
import net.soybeans.oretestmod.block.ModBlocks;


import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {

    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, OreTestMod.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.getRK(ModBlocks.BISMUTH_BLOCK.get()))
                .add(ModBlocks.getRK(ModBlocks.BISMUTH_ORE.get()))
                .add(ModBlocks.getRK(ModBlocks.BISMUTH_DEEPSLATE_ORE.get()));

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.getRK(ModBlocks.BISMUTH_BLOCK.get()))
                .add(ModBlocks.getRK(ModBlocks.BISMUTH_ORE.get()))
                .add(ModBlocks.getRK(ModBlocks.BISMUTH_DEEPSLATE_ORE.get()));
    }
}
