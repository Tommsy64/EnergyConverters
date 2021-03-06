package net.xalcon.energyconverters.common.init;

import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.xalcon.energyconverters.common.CreativeTabEnergyConverters;
import net.xalcon.energyconverters.common.blocks.*;

public class ModBlocks
{
    public static BlockEnergyBridge EnergyBridge;
    public static BlockProducerEu ProducerEu;
    public static BlockConsumerEu ConsumerEu;
    public static BlockProducerRf ProducerRf;
    public static BlockConsumerRf ConsumerRf;
    public static BlockTeslaProducer ProducerTesla;
    public static BlockTeslaConsumer ConsumerTesla;
    public static BlockProducerFe ProducerFe;
    public static BlockConsumerFe ConsumerFe;
    public static BlockProducerMj ProducerMj;
    public static BlockConsumerMj ConsumerMj;

    public static void init()
    {
        EnergyBridge = register(new BlockEnergyBridge());
        if(Loader.isModLoaded("ic2"))
        {
            ProducerEu = new BlockProducerEu();
            register(ProducerEu, new ItemBlockEnumMeta<>(ProducerEu, EnumTypeVoltage.values()));
            ConsumerEu = new BlockConsumerEu();
            register(ConsumerEu, new ItemBlockEnumMeta<>(ConsumerEu, EnumTypeVoltage.values()));
        }

        if(Loader.isModLoaded("tesla"))
        {
            ProducerTesla = register(new BlockTeslaProducer());
            ConsumerTesla = register(new BlockTeslaConsumer());
        }

        ProducerRf = register(new BlockProducerRf());
        ConsumerRf = register(new BlockConsumerRf());

        ProducerFe = register(new BlockProducerFe());
        ConsumerFe = register(new BlockConsumerFe());

        if (Loader.isModLoaded("buildcraftenergy"))
        {
            ProducerMj = register(new BlockProducerMj());
            ConsumerMj = register(new BlockConsumerMj());
        }
    }


    private static <T extends BlockBase> T register(T block, ItemBlock itemBlock)
    {
        itemBlock.setRegistryName(block.getRegistryName());
        GameRegistry.register(block);
        GameRegistry.register(itemBlock);
        block.setCreativeTab(CreativeTabEnergyConverters.Instance);
        block.registerItemModel(itemBlock);
        return block;
    }

    private static <T extends BlockBase> T register(T block)
    {
        return register(block, new ItemBlock(block));
    }
}
