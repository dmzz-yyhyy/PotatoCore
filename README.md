# Spigot 的 PotatoCore

[![Kotlin 版本](https://img.shields.io/badge/Kotlin-1.6.21-blue.svg)](https://kotlinlang.org)
[![在 Telegram 上聊天](https://img.shields.io/badge/Chat%20on-Telegram-brightgreen.svg)](https://t.me/curiousersgames)

由 MiraiMC 提供支持的多功能插件。
PotatoCore 可以在 Spigot 或其分支上运行，并在 PaperMC、Debian11 上进行了测试。

##### [中文 (简体)](https://github.com/dmzz-yyhyy/PotatoCore/blob/main/README.md) | [中文(繁體)](https://github.com/dmzz-yyhyy/PotatoCore/blob/main/README_zh-Hant.md) | [English](https://github.com/dmzz-yyhyy/PotatoCore/blob/main/README_en-US.md)

## 功能

- [x] 上线/离线广播
- [x] QQ和游戏聊天转发消息
- [x] 从 QQ 执行命令（仅限管理员）
- [ ] 管理材料仓库
- [ ] 每日进度提醒

## 用法

### 在游戏中

| 命令          | 功能       |
|-------------|----------|
| /ptb reload | 重新加载配置文件 |

### 组内

|命令         |用法                    | 权限     |
|------------|-----------------------|--------|
| !#ping     |检查服务器状态            | 无      |
| #[消息]     |转发消息到服务器聊天       | 无      |
| !#[命令]    |在服务器上运行命令         | 马铃薯管理员 |

## 权限

| 权限          | 注意              | 默认  |
|--------------|------------------|-------|
| potato.admin | PotatoCore 管理员 | OP    |

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
