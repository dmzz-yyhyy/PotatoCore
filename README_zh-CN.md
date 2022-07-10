# 适用于 Spigot 的 PotatoCore

由 MiraiMC 提供支持的多功能插件。
PotatoCore 可以在 Spigot 或其分支上运行，并在 PaperMC、Debian11 上进行了测试。

##### [中文 (简体)](https://github.com/dmzz-yyhyy/PotatoCore/blob/main/README_zh-CN.md) | [中文 (繁體)](https://github.com/dmzz-yyhyy/PotatoCore/blob/main/README_zh-Hant.md) | [English](https://github.com/dmzz-yyhyy/PotatoCore/blob/main/README.md)

## 计划

- [x] 上线/离线广播
- [x] QQ和游戏聊天转发消息
- [x] 从 QQ 执行命令（仅限管理员）
- [x] 使用命令重新加载配置文件
- [x] 每日进度提醒
- [ ] 自助领取补偿/福利
- [ ] 自定义命令
- [ ] 管理材料仓库
- [ ] 玩家快递盒

## 已知功能
- 当玩家上线游戏或者下线游戏时在群聊内发送消息提醒
- 通过关键字 # 游戏内和群聊内所有的消息都会被互通
- 管理员通过关键字 !# 可以通过QQ群聊在服务器上执行命令
- 通过群聊创建日程计划，并且进行管理，可以设置每日定时发送所有未完成日程

## 用法

### 在游戏中

| 命令          | 功能       |
|-------------|----------|
| /ptb reload | 重新加载配置文件 |

### 在QQ群内

| 命令                                                                                        | 用法            | 权限  |
|-------------------------------------------------------------------------------------------|---------------|-----|
| !#ping                                                                                    | 检查服务器状态       | 无   |
| #[消息]                                                                                     | 转发消息到服务器聊天    | 无   |
| 添加日程  [日程名称]  [负责人(如果有多人请用 &#124; 分割,如:dmzz&#124;yyhyy]  [关联仓库(可选)]                       | 添加一项日程        | 无   |
| 修改日程 [需要修改的日程名称] [修改后的日程名称] [修改后的负责人(如果有多人请用 &#124; 分割,如:dmzz&#124;yyhyy)] [修改后的关联仓库(可选)] | 修改一项已存在的日程内容  | 无   |
| 完成日程 [完成的日程名称]                                                                            | 完成一项日程并且删除该日程 | 无   |

## 配置文件

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

## 权限

| 权限           | 注意             | 默认  |
|--------------|----------------|-----|
| potato.admin | PotatoCore 管理员 | OP  |

## 引用

- [DreamVoid/MiraiMC](https://github.com/DreamVoid/MiraiMC)

## 许可证

````
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
````
