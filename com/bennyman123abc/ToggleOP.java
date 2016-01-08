/*    */ package com.bennyman123abc;
/*    */ 
/*    */ import java.util.logging.Logger;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.permissions.Permission;
/*    */ 
/*    */ public class ToggleOP extends org.bukkit.plugin.java.JavaPlugin
/*    */ {
/* 14 */   public Permission permission = new Permission("top.op");
/*    */   
/*    */   public void onEnable()
/*    */   {
/* 18 */     getLogger().info("Plugin Made by bennyman123abc");
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void onDisable() {}
/*    */   
/*    */ 
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 28 */     Player player = (Player)sender;
/*    */     
/* 30 */     if ((cmd.getName().equalsIgnoreCase("toggleop")) && (player.hasPermission("top.op")) && ((sender instanceof Player)))
/*    */     {
/* 32 */       int length = args.length;
/*    */       
/* 34 */       if (length == 0) {
/* 35 */         if (player.isOp()) {
/* 36 */           player.sendMessage(ChatColor.GOLD + "You Are No Longer OP");
/* 37 */           player.setOp(false);
/*    */ 
/*    */         }
/* 40 */         else if (!player.isOp()) {
/* 41 */           player.sendMessage(ChatColor.GOLD + "You Are Now OP");
/* 42 */           player.setOp(true);
/*    */         }
/*    */       }
/*    */       
/* 46 */       if (length == 1)
/*    */       {
/* 48 */         boolean playerFound = false;
/*    */         
/* 50 */         for (Player toggleop : Bukkit.getServer().getOnlinePlayers()) {
/* 51 */           if (toggleop.getName().equalsIgnoreCase(args[0])) {
/* 52 */             if (toggleop.isOp()) {
/* 53 */               toggleop.sendMessage(ChatColor.GOLD + player.getName() + " Deopped You");
/* 54 */               player.sendMessage(ChatColor.GOLD + toggleop.getName() + " Is No Longer OP");
/* 55 */               toggleop.setOp(false);
/* 56 */               playerFound = true;
/* 57 */               break;
/*    */             }
/* 59 */             if (!toggleop.isOp()) {
/* 60 */               toggleop.sendMessage(ChatColor.GOLD + player.getName() + " Has Opped You");
/* 61 */               player.sendMessage(ChatColor.GOLD + toggleop.getName() + " Is Now OP");
/* 62 */               toggleop.setOp(true);
/* 63 */               playerFound = true;
/* 64 */               break;
/*    */             }
/*    */           }
/*    */         }
/* 68 */         if (!playerFound) {
/* 69 */           player.sendMessage(ChatColor.GOLD + args[0] + " Is Not Currently Online");
/*    */         }
/*    */       }
/*    */       
/* 73 */       if (length == 2) {
/* 74 */         boolean playerFound = false;
/*    */         
/* 76 */         for (final Player toggleop : Bukkit.getServer().getOnlinePlayers()) {
/* 77 */           if (toggleop.getName().equalsIgnoreCase(args[0])) {
/* 78 */             Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
/*    */               public void run() {
/* 80 */                 toggleop.setOp(false);
/*    */               }
/*    */             });
/*    */           }
/*    */         }
/*    */       }
/* 86 */       if ((cmd.getName().equalsIgnoreCase("toggleop")) && (!player.hasPermission("top.op")) && ((sender instanceof Player))) {
/* 87 */         player.sendMessage(ChatColor.RED + "You Don't Have Permission To Do That");
/* 88 */         getLogger().warning(player.getName() + " Tried To Toggle Their OP");
/*    */       }
/*    */     }
/* 91 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\autocad\Downloads\ToggleOPPlus.jar!\com\bennyman123abc\ToggleOP.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */