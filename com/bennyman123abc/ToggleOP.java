package com.bennyman123abc;
 
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
 
public class ToggleOP extends org.bukkit.plugin.java.JavaPlugin
{
  public Permission permission = new Permission("top.op");
   
  public void onEnable()
  {
    getLogger().info("Plugin Made by bennyman123abc");
  }
   
 
 
  public void onDisable() {}
   
 
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player player = (Player)sender;
     
    if ((cmd.getName().equalsIgnoreCase("toggleop")) && (player.hasPermission("top.op")) && ((sender instanceof Player)))
    {
      int length = args.length;
       
      if (length == 0) {
        if (player.isOp()) {
          player.sendMessage(ChatColor.GOLD + "You Are No Longer OP");
          player.setOp(false);
 
        }
        else if (!player.isOp()) {
          player.sendMessage(ChatColor.GOLD + "You Are Now OP");
          player.setOp(true);
        }
      }
       
      if (length == 1)
      {
        boolean playerFound = false;
        
        for (Player toggleop : Bukkit.getServer().getOnlinePlayers()) {
          if (toggleop.getName().equalsIgnoreCase(args[0])) {
            if (toggleop.isOp()) {
              toggleop.sendMessage(ChatColor.GOLD + player.getName() + " Deopped You");
              player.sendMessage(ChatColor.GOLD + toggleop.getName() + " Is No Longer OP");
              toggleop.setOp(false);
              playerFound = true;
              break;
            }
            if (!toggleop.isOp()) {
              toggleop.sendMessage(ChatColor.GOLD + player.getName() + " Has Opped You");
              player.sendMessage(ChatColor.GOLD + toggleop.getName() + " Is Now OP");
              toggleop.setOp(true);
              playerFound = true;
              break;
            }
          }
        }
        if (!playerFound) {
          player.sendMessage(ChatColor.GOLD + args[0] + " Is Not Currently Online");
        }
      }
      
      if (length == 2) {
        
        for (final Player toggleop : Bukkit.getServer().getOnlinePlayers()) {
          if (toggleop.getName().equalsIgnoreCase(args[0])) {
            Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
              public void run() {
                toggleop.setOp(false);
              }
            });
          }
        }
      }
      if ((cmd.getName().equalsIgnoreCase("toggleop")) && (!player.hasPermission("top.op")) && ((sender instanceof Player))) {
        player.sendMessage(ChatColor.RED + "You Don't Have Permission To Do That");
        getLogger().warning(player.getName() + " Tried To Toggle Their OP");
      }
    }
    return false;
  }
}