package io.yukonisen.potatocore.event.listener;

import me.dreamvoid.miraimc.api.MiraiBot;
import io.yukonisen.potatocore.util.Config;
import me.dreamvoid.miraimc.bukkit.event.MiraiGroupMessageEvent;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class QQMessageEvent implements Listener {

    @EventHandler
    public void OnGroupMessage(MiraiGroupMessageEvent event) {

        String msg = event.getMessage();
        String[] args = msg.split(" ");

        if (msg.startsWith("#") && event.getGroupID() == Config.group) {
            String forwardMsg = msg.substring(1);
            String sender = event.getSenderNameCard();
            if (sender == null) {
                sender = String.valueOf(event.getSenderID());
            }
            Bukkit.broadcastMessage(sender + " > " + forwardMsg);
        }

        if (msg.equals("!#ping") && event.getGroupID() == Config.group) {
            MiraiBot.getBot(Config.bot).getGroup(Config.group).sendMessageMirai("Okay");
        }

        if (args[0].equals("!#ptb") && args[1].equals("ban") && event.getGroupID() == Config.group) {

            if (event.getSenderID() == Config.op) {
                System.out.println(event.getSenderID());
                if (args.length == 5) {
                    Bukkit.getBanList(BanList.Type.NAME).addBan(args[2], args[3], null, null);
                    MiraiBot.getBot(Config.bot).getGroup(Config.group).sendMessageMirai(Config.INSTANCE.getPrefix_QQ() + "Banned" + args[2] + "\nReason:" + args[3]);
                } else {
                        MiraiBot.getBot(Config.bot).getGroup(Config.group).sendMessageMirai(Config.INSTANCE.getPrefix_QQ() + "Invalid arguments");
                }
            } else {
                MiraiBot.getBot(Config.bot).getGroup(Config.group).sendMessageMirai("No Permission");
            }
        }
    }


}
