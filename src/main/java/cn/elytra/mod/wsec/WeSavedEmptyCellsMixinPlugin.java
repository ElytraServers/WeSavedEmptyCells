package cn.elytra.mod.wsec;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import org.spongepowered.libraries.org.objectweb.asm.tree.ClassNode;

import com.google.common.collect.ImmutableMap;
import cpw.mods.fml.common.Loader;

public class WeSavedEmptyCellsMixinPlugin implements IMixinConfigPlugin {

    private static final Map<String, Supplier<Boolean>> CLASSES_REQUIRE_CONDITIONAL_LOAD = ImmutableMap
            .of("cn.elytra.mod.wsec.MixinBlockDrum", () -> Loader.isModLoaded("ExtraUtilities"));

    @Override
    public void onLoad(String mixinPackage) {

    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if (CLASSES_REQUIRE_CONDITIONAL_LOAD.containsKey(targetClassName)) {
            return CLASSES_REQUIRE_CONDITIONAL_LOAD.get(targetClassName).get();
        }
        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {

    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String s, ClassNode classNode, String s1, IMixinInfo iMixinInfo) {

    }

    @Override
    public void postApply(String s, ClassNode classNode, String s1, IMixinInfo iMixinInfo) {

    }
}
