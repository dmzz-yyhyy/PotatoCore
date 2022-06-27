package io.yukonisen.potatocore.event.listener.OnQQGroupMessageEvent

import io.yukonisen.potatocore.PotatoCore
import io.yukonisen.potatocore.util.Config.qqgroup
import io.yukonisen.potatocore.util.Config.qqop
import me.dreamvoid.miraimc.bukkit.event.message.passive.MiraiGroupMessageEvent
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import java.util.*

class OnQQCommandMessage : Listener {
    @EventHandler
    fun onGroupCommandMessage(event: MiraiGroupMessageEvent) {
        if (PotatoCore.getGroup() != null) {
            if (event.groupID == qqgroup) {
                val group = PotatoCore.getGroup()
                val message = event.message
                if (message == "!#ping") {
                    val version = Bukkit.getVersion()
                    group.sendMessageMirai("PTB running on $version")
                } else if (Objects.requireNonNull<List<String>?>(qqop)
                        .contains(event.senderID.toString())
                ) {
                    if (message.startsWith("!#")) {
                        Bukkit.getScheduler().runTask(PotatoCore.getInstance()) {
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), message.replaceFirst("!#".toRegex(), ""))
                        }
                    }
                }
            }
        }
    }
}
