package com.gmail.kurumitk78.skyshock;

import com.gmail.kurumitk78.skyshock.commands.ExampleCommand;
import com.gmail.kurumitk78.skyshock.config.ConfigHandler;
import com.gmail.kurumitk78.skyshock.events.ExampleKeybindListener;
import com.gmail.kurumitk78.skyshock.hud.ExampleHUD;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
        modid = SkyShock.MODID,
        name = SkyShock.MODNAME,
        version = SkyShock.VERSION)
public class SkyShock { // select ExampleMod and hit shift+F6 to rename it

    public static final String MODID = "skyshock";      // the id of your mod, it should never change, it is used by forge and servers to identify your mods
    public static final String MODNAME = "SkyShock";// the name of your mod
    public static final String VERSION = "1.0";           // the current version of your mod

    // this method is one entry point of you mod
    // it is called by forge when minecraft is starting
    // it is called before the other methods below
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // loads the config file from the disk
        ConfigHandler.loadConfig(event.getSuggestedConfigurationFile());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        // register your commands here
        ClientCommandHandler.instance.registerCommand(new ExampleCommand());

        // the ExampleKeybind has a method with the @SubscribeEvent annotation
        // for that code to run, that class needs to be registered on the MinecraftForge EVENT_BUS
        // register your other EventHandlers here
        MinecraftForge.EVENT_BUS.register(new ExampleKeybindListener());
        MinecraftForge.EVENT_BUS.register(new ExampleHUD());

        if (Loader.isModLoaded("patcher")) {
            // this code will only run if the mod with id "patcher" is loaded
            // you can use it to load or not while modules of your mod that depends on other mods
        }

    }
}
