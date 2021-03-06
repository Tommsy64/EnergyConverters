package net.xalcon.energyconverters.common.blocks;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.xalcon.energyconverters.common.tiles.TileEntityProducerEu;

public class BlockProducerEu extends BlockConverterEuBase implements ITileEntityProvider
{
	public BlockProducerEu()
	{
		super(Material.IRON, "energy_producer_eu");
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		return new TileEntityProducerEu(meta + 1);
	}
}
