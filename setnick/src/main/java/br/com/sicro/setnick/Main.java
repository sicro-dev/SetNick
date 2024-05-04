package br.com.sicro.setnick;

import br.com.sicro.setnick.listeners.setnicklistener;
import br.com.sicro.setnick.command.setnickcommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("NickPlugin ativado com sucesso!");
        this.getCommand("nick").setExecutor(new setnickcommand());
        this.getServer().getPluginManager().registerEvents(new setnicklistener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("NickPlugin desativado com sucesso!");
    }
}
