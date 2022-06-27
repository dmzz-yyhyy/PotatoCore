# Spigot 的 PotatoCore

由 MiraiMC 提供支援的多功能插件。
PotatoCore 可以在 Spigot 或其分支上執行，並在 PaperMC、Debian11 上進行了測試。

##### [中文 (简体)](https://github.com/dmzz-yyhyy/PotatoCore/blob/main/README_zh-CN.md) | [中文 (繁體)](https://github.com/dmzz-yyhyy/PotatoCore/blob/main/README_zh-Hant.md) | [English](https://github.com/dmzz-yyhyy/PotatoCore/blob/main/README.md)

## 功能

- [x] 上線/離線廣播
- [x] QQ和遊戲聊天轉發訊息
- [x] 從 QQ 執行命令（僅管理員）
- [x] 使用命令重新載入配置文件
- [ ] 管理材料倉庫
- [ ] 每日進度提醒

## 用法

### 在遊戲中

| 命令          | 功能       |
|-------------|----------|
| /ptb reload | 重新載入配置文件 |

### 組內

| 命令     | 用法         | 權限     |
|--------|------------|--------|
| !#ping | 檢查服務器狀態    | 無      |
| #[訊息]  | 轉發訊息到服務器聊天 | 無      |
| !#[命令] | 在服務器上執行命令  | 馬鈴薯管理員 |

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
