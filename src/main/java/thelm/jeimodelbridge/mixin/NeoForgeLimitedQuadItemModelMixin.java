package thelm.jeimodelbridge.mixin;

import java.util.function.Supplier;

import org.spongepowered.asm.mixin.Mixin;

import mezz.jei.neoforge.platform.NeoForgeLimitedQuadItemModel;
import net.fabricmc.fabric.api.renderer.v1.model.FabricBakedModel;
import net.fabricmc.fabric.api.renderer.v1.render.RenderContext;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.BakedModelWrapper;

@Mixin(NeoForgeLimitedQuadItemModel.class)
public abstract class NeoForgeLimitedQuadItemModelMixin extends BakedModelWrapper<BakedModel> implements FabricBakedModel {

	private NeoForgeLimitedQuadItemModelMixin(BakedModel originalModel) {
		super(originalModel);
	}

	@Override
	public boolean isVanillaAdapter() {
		return ((FabricBakedModel)originalModel).isVanillaAdapter();
	}

	@Override
	public void emitBlockQuads(BlockAndTintGetter level, BlockState state, BlockPos pos, Supplier<RandomSource> randomSupplier, RenderContext context) {
		((FabricBakedModel)originalModel).emitBlockQuads(level, state, pos, randomSupplier, context);
	}

	@Override
	public void emitItemQuads(ItemStack stack, Supplier<RandomSource> randomSupplier, RenderContext context) {
		((FabricBakedModel)originalModel).emitItemQuads(stack, randomSupplier, context);
	}
}
