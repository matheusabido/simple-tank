package com.example.examplemod.menu;

import com.example.examplemod.ExampleMod;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {

    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, ExampleMod.MOD_ID);

    public static final RegistryObject<MenuType<SimpleTankMenu>> SIMPLE_TANK = MENU_TYPES.register("simple_menu",
            () -> IForgeMenuType.create(SimpleTankMenu::new));

}