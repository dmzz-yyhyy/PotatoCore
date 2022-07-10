# 適用於 Spigot 的 PotatoCore

由 MiraiMC 提供支持的多功能插件。
PotatoCore 可以在 Spigot 或其分支上運行，並在 PaperMC、Debian11 上進行了測試。

##### [中文 (簡體)](https://github.com/dmzz-yyhyy/PotatoCore/blob/main/README_zh-CN.md) | [中文 (繁體)](https://github.com/dmzz-yyhyy/PotatoCore/blob/main/README_zh-Hant.md) | [English](https://github.com/dmzz-yyhyy/PotatoCore/blob/main/README.md)

## 計劃

- [x] 上線/離線廣播
- [x] QQ和遊戲聊天轉發消息
- [x] 從 QQ 執行命令（僅限管理員）
- [x] 使用命令重新加載配置文件
- [x] 每日進度提醒
- [ ] 自助領取補償/福利
- [ ] 自定義命令
- [ ] 管理材料倉庫
- [ ] 玩家快遞盒

## 已知功能
- 當玩家上線遊戲或者下線遊戲時在群聊內發送消息提醒
- 通過關鍵字 # 遊戲內和群聊內所有的消息都會被互通
- 管理員通過關鍵字 !# 可以通過QQ群聊在服務器上執行命令
- 通過群聊創建日程計劃，並且進行管理，可以設置每日定時發送所有未完成日程

## 用法

### 在遊戲中

| 命令          | 功能       |
|-------------|----------|
| /ptb reload | 重新加載配置文件 |

### 在QQ群內

| 命令                                                                                        | 用法            | 權限  |
|-------------------------------------------------------------------------------------------|---------------|-----|
| !#ping                                                                                    | 檢查服務器狀態       | 無   |
| #[消息]                                                                                     | 轉發消息到服務器聊天    | 無   |
| 添加日程  [日程名稱]  [負責人(如果有多人請用 &#124; 分割,如:dmzz&#124;yyhyy]  [關聯倉庫(可選)]                       | 添加一項日程        | 無   |
| 修改日程 [需要修改的日程名稱] [修改後的日程名稱] [修改後的負責人(如果有多人請用 &#124; 分割,如:dmzz&#124;yyhyy)] [修改後的關聯倉庫(可選)] | 修改一項已存在的日程內容  | 無   |
| 完成日程 [完成的日程名稱]                                                                            | 完成一項日程並且刪除該日程 | 無   |

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
    join: "%player% 連接至服務器"
    quit: "%player% 斷開連接"

```

## 權限

| 權限           | 注意             | 默認  |
|--------------|----------------|-----|
| potato.admin | PotatoCore 管理員 | OP  |

## 引用

- [DreamVoid/MiraiMC](https://github.com/DreamVoid/MiraiMC)

## 許可證

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
