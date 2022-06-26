package io.yukonisen.potatocore.event.listener.OnQQGroupMessageEvent

import io.yukonisen.potatocore.PotatoCore
import io.yukonisen.potatocore.util.Config.qqbot
import io.yukonisen.potatocore.util.Config.qqgroup
import io.yukonisen.potatocore.util.Config.qqop
import me.dreamvoid.miraimc.api.MiraiBot
import me.dreamvoid.miraimc.bukkit.event.MiraiGroupMessageEvent
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import java.util.*

class OnQQCommandMessage : Listener {
    @EventHandler
    fun onGroupCommandMessage(event: MiraiGroupMessageEvent) {
        val group = MiraiBot.getBot(qqbot).getGroup(qqgroup)
        val message = event.message
        if (message == "!#ping" && event.groupID == qqgroup) {
            val version = Bukkit.getVersion()
            group.sendMessageMirai("PTB running on $version")
        } else if (event.groupID == qqgroup && Objects.requireNonNull<List<String>?>(qqop)
                .contains(event.senderID.toString())
        ) {
            if (message.startsWith("!#")) {
                Bukkit.getScheduler().runTask(PotatoCore.getInstance()) {
                    Bukkit.dispatchCommand(
                        Bukkit.getConsoleSender(),
                        message.replaceFirst("!#".toRegex(), "")
                    )
                }
            }
        }
    }
}
