package io.yukonisen.potatocore.event.timer;

import io.yukonisen.potatocore.PotatoCore;
import io.yukonisen.potatocore.util.Config;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class SendQQDailyProgressReminderMessage extends BukkitRunnable {

    private Boolean isSendMessageLastTime = false;

    @Override
    public void run() {
        String sendMessage;
        if (PotatoCore.getGroup() == null) {
            return;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        Date date = new Date(System.currentTimeMillis());
        if (formatter.format(date).replace("\\p{C}", "").equals(Config.INSTANCE.getScheduleTimer()) && !isSendMessageLastTime) {
            FileConfiguration schedules = YamlConfiguration.loadConfiguration(new File(PotatoCore.getInstance().getDataFolder(), "data/todolist.yml"));
            sendMessage = Config.INSTANCE.getSendScheduleTimer();
            List<Map<?, ?>> schedulesList = schedules.getMapList("data");
            for (Map<?, ?> schedule : schedulesList) {
                String scheduleName = schedule.get("schedule").toString();
                String responsible = "";
                for (Object name : (List<?>) schedule.get("responsible")) {
                    responsible = responsible.concat(name.toString());
                }
                responsible = responsible.replaceFirst(", ", "");
                sendMessage = sendMessage + "\n{scheduleName}\n      " + Config.INSTANCE.getResponsible() + ":{responsible}\n";
                sendMessage = sendMessage.replace("{scheduleName}", scheduleName).replace("{responsible}", responsible);
                sendMessage = sendMessage + Config.INSTANCE.getComeOntoday();
            }
            isSendMessageLastTime = true;
            PotatoCore.getGroup().sendMessage(sendMessage);
        }
        if (!formatter.format(date).equals(Config.INSTANCE.getScheduleTimer()) && isSendMessageLastTime) {
            isSendMessageLastTime = false;
        }
    }

    public void start(long delay, long time) {
        this.runTaskTimer(PotatoCore.getInstance(), 20L * delay, time);
    }
}
