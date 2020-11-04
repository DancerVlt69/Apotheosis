package shadows.apotheosis.deadly.affix.impl.ranged;

import java.util.Random;

import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TranslationTextComponent;
import shadows.apotheosis.deadly.affix.Affix;
import shadows.apotheosis.deadly.affix.AffixHelper;
import shadows.apotheosis.deadly.affix.EquipmentType;
import shadows.apotheosis.deadly.affix.modifiers.AffixModifier;

/**
 * Drops from killed enemies are teleported to the shooter.
 */
public class TeleportDropsAffix extends Affix {

	public TeleportDropsAffix(int weight) {
		super(weight);
	}

	@Override
	public float apply(ItemStack stack, Random rand, AffixModifier modifier) {
		int lvl = 2 + rand.nextInt(5);
		if (modifier != null) lvl = (int) modifier.editLevel(this, lvl);
		AffixHelper.addLore(stack, new TranslationTextComponent("affix." + this.getRegistryName() + ".desc", lvl));
		return lvl;
	}

	@Override
	public boolean canApply(EquipmentType type) {
		return type == EquipmentType.RANGED;
	}

	@Override
	public float getMin() {
		return 1;
	}

	@Override
	public float getMax() {
		return 64;
	}

}