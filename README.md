# Super Pickaxe Mod

Craft a Super Pickaxe that breaks a 3×3 plane of blocks at once. The mining logic runs on the server, so players do not need SuperPickaxe installed on their clients.

<p align="center">
  <img src="https://raw.githubusercontent.com/tantaihaha4487/SuperPickaxeMod/master/src/main/resources/assets/superpickaxe/icon.png" alt="Super Pickaxe icon" width="128">
</p>

## Features

- Break a 3×3 plane oriented to the face you mine.
- Run the mod on a dedicated server while keeping the client mod optional.
- Craft wooden, stone, copper, golden, iron, diamond, and netherite variants.
- Add the variants to the Tools & Utilities creative tab when the client mod is installed.

## Requirements

All 1.0.5 releases require Java 25 or newer and Fabric Loader 0.19.3 or newer.

| Minecraft | Mod file | Fabric API |
| --- | --- | --- |
| 26.1.2 | `SuperPickaxe-26.1.2-1.0.5.jar` | `0.155.2+26.1.2` |
| 26.2 | `SuperPickaxe-26.2-1.0.5.jar` | `0.155.2+26.2` |

Install the build and Fabric API version that match your Minecraft version.

## Installation

1. Download the matching mod JAR from the [GitHub releases](https://github.com/tantaihaha4487/SuperPickaxeMod/releases).
2. Install Fabric Loader, Fabric API, and Java 25+ on the server.
3. Put the SuperPickaxe JAR and Fabric API JAR in the server's `mods` folder.
4. Start the server.

SuperPickaxe is optional on clients joining a server that has the mod. Installing it on the client adds the items to the creative tab and provides the custom item assets locally.

For singleplayer, install the matching JAR and Fabric API in the instance's `mods` folder.

For clients without the mod, install the [SuperPickaxe resource pack](https://modrinth.com/project/WRfA5BM1) to display the custom item models and textures. The resource pack is not required for crafting or 3×3 mining.

## Use

1. Craft a Super Pickaxe using the recipe below.
2. Hold it in your main hand.
3. Mine a block. The pickaxe breaks the surrounding 3×3 plane, and only blocks the pickaxe can harvest are included.

## Crafting

Use three matching, undamaged, unenchanted pickaxes and two sticks:

```text
PPP
_S_
_S_
```

- `P` is the pickaxe tier you want to upgrade.
- `S` is a stick.
- `_` is an empty slot.

The recipe is available for these tiers:

| Input pickaxe | Result |
| --- | --- |
| Wooden | <img src="https://raw.githubusercontent.com/tantaihaha4487/SuperPickaxeMod/master/resourcepacks/SuperPickaxe/assets/superpickaxe/textures/item/super_wooden_pickaxe.png" alt="Super Wooden Pickaxe texture" width="32"> Super Wooden Pickaxe |
| Stone | <img src="https://raw.githubusercontent.com/tantaihaha4487/SuperPickaxeMod/master/resourcepacks/SuperPickaxe/assets/superpickaxe/textures/item/super_stone_pickaxe.png" alt="Super Stone Pickaxe texture" width="32"> Super Stone Pickaxe |
| Copper | <img src="https://raw.githubusercontent.com/tantaihaha4487/SuperPickaxeMod/master/resourcepacks/SuperPickaxe/assets/superpickaxe/textures/item/super_copper_pickaxe.png" alt="Super Copper Pickaxe texture" width="32"> Super Copper Pickaxe |
| Golden | <img src="https://raw.githubusercontent.com/tantaihaha4487/SuperPickaxeMod/master/resourcepacks/SuperPickaxe/assets/superpickaxe/textures/item/super_golden_pickaxe.png" alt="Super Golden Pickaxe texture" width="32"> Super Golden Pickaxe |
| Iron | <img src="https://raw.githubusercontent.com/tantaihaha4487/SuperPickaxeMod/master/resourcepacks/SuperPickaxe/assets/superpickaxe/textures/item/super_iron_pickaxe.png" alt="Super Iron Pickaxe texture" width="32"> Super Iron Pickaxe |
| Diamond | <img src="https://raw.githubusercontent.com/tantaihaha4487/SuperPickaxeMod/master/resourcepacks/SuperPickaxe/assets/superpickaxe/textures/item/super_diamond_pickaxe.png" alt="Super Diamond Pickaxe texture" width="32"> Super Diamond Pickaxe |
| Netherite | <img src="https://raw.githubusercontent.com/tantaihaha4487/SuperPickaxeMod/master/resourcepacks/SuperPickaxe/assets/superpickaxe/textures/item/super_netherite_pickaxe.png" alt="Super Netherite Pickaxe texture" width="32"> Super Netherite Pickaxe |

## License

SuperPickaxe is licensed under the [MIT License](LICENSE.txt).
