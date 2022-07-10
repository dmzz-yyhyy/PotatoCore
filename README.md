# PotatoCore for Spigot

A multifunctional plugin (not yet)
PotatoCore can run on Spigot or its forks, tested on PaperMC, Debian11.

##### [中文 (简体)](https://github.com/dmzz-yyhyy/PotatoCore/blob/main/README_zh-CN.md) | [中文 (繁體)](https://github.com/dmzz-yyhyy/PotatoCore/blob/main/README_zh-Hant.md) | [English](https://github.com/dmzz-yyhyy/PotatoCore/blob/main/README.md)

## plans

- [x] Online / Offline broadcasting
- [x] Forward messages between QQ and game chat
- [x] Execute command from QQ (admins only)
- [x] Reload config file using command
- [x] Daily progress reminder
- [ ] Self-collection of compensation/benefits
- [ ] custom command(on qq group)
- [ ] Manage storage items
- [ ] Player express box

## Known features
- Send a message reminder in the group chat when the player is online or offline
- Through the keyword # all messages in the game and group chat will be exchanged
- The administrator can execute commands on the server through the QQ group chat through the keyword !#
- Create and manage schedules through group chat, you can set daily schedules to send all unfinished schedules

## Usage

### In-Game

| Command       | Note                         |
|---------------|------------------------------|
| /ptb reload   | Reload configuration files   |

### In-Group

| Command                                                                                                                                                                                                                                                               | Usage                                        | Permission |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------|------------|
| !#ping                                                                                                                                                                                                                                                                | Check server status                          | None       |
| #[message]                                                                                                                                                                                                                                                            | Forward message to Server Chat               | None       |
| 添加日程 [schedule name] [responsible person (if there are multiple people, please use &#124; to separate, such as: dmzz&#124;yyhyy] [associated warehouse (optional)]                                                                                                    | Add a schedule                               | None       |
| 修改日程 [the name of the schedule to be modified] [the name of the modified schedule] [the person in charge after the modification (if there are multiple people, please use &#124; to separate, such as: dmzz&#124;yyhyy)] [modified association Repository (optional)] | Modify an existing schedule                  | None       |
| 完成日程 [completed schedule name]                                                                                                                                                                                                                                        | Complete an schedule and delete the schedule | None       |

## Config file
### config.yml
```yml
# Configuration file for PotatoCore
# by yukonisen#QwQ

# When to automatically send the schedule
schedule_timer: "14:51"
# language "zh-cn" “en-us”
language: "zh-cn"

format:

  prefix:
    console: "[PotatoCore]"
    to-mc: "&aPotatoCore &7> "
    to-qq: "[Core]"
```
### potatobotcfg.yml
```yml
# Configuration for PotatoBot

qqnumber:

  # Enter the group number where you want to use PTB. (eg. 114514)
  group: 114514
  # Enter the QQ number of the bot (login required, eg. 1919810)
  bot: 1919810
  # Enter the QQ number of the bot operators
  op:
    - "1145141919810"
    - "1145141919810000"

  # These example qq numbers should be long enough to never be real qq numbers

messages:

  # messages when player join or quit server
  player:
    join: "%player% 连接至服务器"
    quit: "%player% 断开连接"

```


## Permissions

| Permission      | Note             | Default |
|-----------------|------------------|---------|
| potato.admin    | PotatoCore admin | OP      |

## Credits

- [DreamVoid/MiraiMC](https://github.com/DreamVoid/MiraiMC)

## License

```
Copyright (C) 2022 by yukonisen#QwQ <whenten99@gmail.com>
Copyright (C) 2022 by dmzz-yyhyy <hk198580666@outlook.com>

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or (at
your option) any later version.

This program is distributed in the hope that it will be useful, but
WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program. If not, see <http://www.gnu.org/licenses/>.
```
