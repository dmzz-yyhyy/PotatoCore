# PotatoCore for Spigot

[![Kotlin Version](https://img.shields.io/badge/Kotlin-1.6.21-blue.svg)](https://kotlinlang.org)
[![Chat on Telegram](https://img.shields.io/badge/Chat%20on-Telegram-brightgreen.svg)](https://t.me/curiousersgames)

A multifunctional plugin powered by MiraiMC.
PotatoCore can run on Spigot or its forks, tested on PaperMC, Debian11.

##### [中文 (简体)](https://github.com/dmzz-yyhyy/PotatoCore/blob/main/README.md) | [中文(繁體)](https://github.com/dmzz-yyhyy/PotatoCore/blob/main/README_zh-Hant.md) | [English](https://github.com/dmzz-yyhyy/PotatoCore/blob/main/README_en-US.md)

## Functions

- [x] Online / Offline boardcasting
- [x] Forward messages between QQ and game chat
- [x] Execute command from QQ (admin only)
- [ ] Manage material warehouse
- [ ] Daily progress reminder

## Usage

### In-Game

| Command       | Note                         |
|---------------|------------------------------|
| /ptb reload   | Reload configuration files   |

### In-Group

| Command    | Usage                          | Permission          |
|------------|--------------------------------|---------------------|
| !#ping     | Check server status            | None                |
| #[message] | Forward message to Server Chat | None                |
| !#[command]| Run a command on the sever     | PotatoAdministrator |

## Permissions

| Permission      | Note             | Default |
|-----------------|------------------|---------|
| potato.admin    | PotatoCore admin | OP      |

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
