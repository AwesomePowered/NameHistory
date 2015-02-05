package net.awesomepowered.namehistory;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

/**
 * Created by John on 2/4/2015.
 */
public class NameHistoryCommand extends Command {

    NameHistory plugin;

    public NameHistoryCommand(NameHistory plugin) {
        super("nh");
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer p = (ProxiedPlayer) sender; //sue me
        if (sender.hasPermission("namehistory.lookup")) {
            if (args.length >= 1) {
                ProxiedPlayer victim = ProxyServer.getInstance().getPlayer(args[0]);
                if (victim != null) {
                    plugin.doRequest(victim.getUniqueId().toString(), p);
                } else {
                    p.sendMessage(ChatColor.RED + "Player is not online!");
                }
            } else {
                p.sendMessage(ChatColor.RED + "Usage: /nh PLAYER");
            }
        }
    }
}
