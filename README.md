# Super Pickaxe Mod
Pickaxe with 3*3 block breaking ability, server-authoritative and multiplayer friendly.


## Features
- **3x3 Mining**: Breaks a 3x3 area (9 blocks) at once.
- **Server Compatible**: Does not require the mod on the client side.
## Requirements

The **1.0.5** release supports Minecraft **26.1.2** and **26.2** on Java **25+**.
Install the build matching your Minecraft version.

Fabric Loader **0.19.3+** remains a runtime dependency. Use the matching Fabric API:

- Minecraft 26.1.2: Fabric API **0.155.2+26.1.2**
- Minecraft 26.2: Fabric API **0.155.2+26.2**

### Client

- Install Fabric Loader, Fabric API, and Java 25+.
- Installing SuperPickaxe on a client is optional when joining a server that provides the mod, but it enables the local creative-tab entries and bundled custom assets.
- The resource pack is optional for gameplay, but required for the custom item models and textures when those assets are not supplied by the client mod.

### Server
Download [Resource Pack](https://modrinth.com/project/WRfA5BM1)
- **Mod Required**: The server needs the mod installed in the `mods` folder.
- **Client Optional**: SuperPickaxe is not required on multiplayer clients when the server provides it. Fabric Loader and Fabric API are still required for the Fabric runtime.
- **Resource Pack**: Optional for crafting and mining, but required for the custom item visuals when the client does not have the mod assets.

### Feature Matrix

| Feature | Server Only | Client Only | Both |
|---------|:-----------:|:-----------:|:----:|
| 3x3 Mining | ✅ | ✅ | ✅ |
| Crafting Recipes | ✅ | ✅ | ✅ |
| Custom Textures | ❌* | ✅ | ✅ |
| Creative Tab Items | ❌ | ✅ | ✅ |

*\*Server can provide textures via resource pack*


## Crafting Recipes
All recipes are **Shaped**. Place three matching **fresh, undamaged pickaxes** across
the top row, then place two **sticks** in the center column below them.

```text
PPP
 S
 S
```

`P` is the pickaxe tier you want to upgrade and `S` is a stick.

### All Pickaxe Variants

#### Wooden Super Pickaxe
| ![Wooden Pickaxe](https://minecraft.wiki/images/thumb/Wooden_Pickaxe_JE1_BE1.png/32px-Wooden_Pickaxe_JE1_BE1.png) | ![Wooden Pickaxe](https://minecraft.wiki/images/thumb/Wooden_Pickaxe_JE1_BE1.png/32px-Wooden_Pickaxe_JE1_BE1.png) | ![Wooden Pickaxe](https://minecraft.wiki/images/thumb/Wooden_Pickaxe_JE1_BE1.png/32px-Wooden_Pickaxe_JE1_BE1.png) |
|:---:|:---:|:---:|
|  | ![Stick](https://minecraft.wiki/images/thumb/Stick_JE1_BE1.png/32px-Stick_JE1_BE1.png) |  |
|  | ![Stick](https://minecraft.wiki/images/thumb/Stick_JE1_BE1.png/32px-Stick_JE1_BE1.png) |  |
| **Result** | ![Super Wooden Pickaxe](https://wsrv.nl/?url=raw.githubusercontent.com/tantaihaha4487/SuperPickaxeMod/master/resourcepacks/SuperPickaxe/assets/superpickaxe/textures/item/super_wooden_pickaxe.png&w=32&h=32&fit=contain) **Super Wooden Pickaxe** |  |

#### Stone Super Pickaxe
| ![Stone Pickaxe](https://minecraft.wiki/images/thumb/Stone_Pickaxe_JE1_BE1.png/32px-Stone_Pickaxe_JE1_BE1.png) | ![Stone Pickaxe](https://minecraft.wiki/images/thumb/Stone_Pickaxe_JE1_BE1.png/32px-Stone_Pickaxe_JE1_BE1.png) | ![Stone Pickaxe](https://minecraft.wiki/images/thumb/Stone_Pickaxe_JE1_BE1.png/32px-Stone_Pickaxe_JE1_BE1.png) |
|:---:|:---:|:---:|
|  | ![Stick](https://minecraft.wiki/images/thumb/Stick_JE1_BE1.png/32px-Stick_JE1_BE1.png) |  |
|  | ![Stick](https://minecraft.wiki/images/thumb/Stick_JE1_BE1.png/32px-Stick_JE1_BE1.png) |  |
| **Result** | ![Super Stone Pickaxe](https://wsrv.nl/?url=raw.githubusercontent.com/tantaihaha4487/SuperPickaxeMod/master/resourcepacks/SuperPickaxe/assets/superpickaxe/textures/item/super_stone_pickaxe.png&w=32&h=32&fit=contain) **Super Stone Pickaxe** |  |

#### Copper Super Pickaxe
| ![Copper Pickaxe](https://minecraft.wiki/images/thumb/Copper_Pickaxe_JE1_BE1.png/32px-Copper_Pickaxe_JE1_BE1.png) | ![Copper Pickaxe](https://minecraft.wiki/images/thumb/Copper_Pickaxe_JE1_BE1.png/32px-Copper_Pickaxe_JE1_BE1.png) | ![Copper Pickaxe](https://minecraft.wiki/images/thumb/Copper_Pickaxe_JE1_BE1.png/32px-Copper_Pickaxe_JE1_BE1.png) |
|:---:|:---:|:---:|
|  | ![Stick](https://minecraft.wiki/images/thumb/Stick_JE1_BE1.png/32px-Stick_JE1_BE1.png) |  |
|  | ![Stick](https://minecraft.wiki/images/thumb/Stick_JE1_BE1.png/32px-Stick_JE1_BE1.png) |  |
| **Result** | ![Super Copper Pickaxe](https://wsrv.nl/?url=raw.githubusercontent.com/tantaihaha4487/SuperPickaxeMod/master/resourcepacks/SuperPickaxe/assets/superpickaxe/textures/item/super_copper_pickaxe.png&w=32&h=32&fit=contain) **Super Copper Pickaxe** |  |

#### Iron Super Pickaxe
| ![Iron Pickaxe](https://minecraft.wiki/images/thumb/Iron_Pickaxe_JE2_BE1.png/32px-Iron_Pickaxe_JE2_BE1.png) | ![Iron Pickaxe](https://minecraft.wiki/images/thumb/Iron_Pickaxe_JE2_BE1.png/32px-Iron_Pickaxe_JE2_BE1.png) | ![Iron Pickaxe](https://minecraft.wiki/images/thumb/Iron_Pickaxe_JE2_BE1.png/32px-Iron_Pickaxe_JE2_BE1.png) |
|:---:|:---:|:---:|
|  | ![Stick](https://minecraft.wiki/images/thumb/Stick_JE1_BE1.png/32px-Stick_JE1_BE1.png) |  |
|  | ![Stick](https://minecraft.wiki/images/thumb/Stick_JE1_BE1.png/32px-Stick_JE1_BE1.png) |  |
| **Result** | ![Super Iron Pickaxe](https://wsrv.nl/?url=raw.githubusercontent.com/tantaihaha4487/SuperPickaxeMod/master/resourcepacks/SuperPickaxe/assets/superpickaxe/textures/item/super_iron_pickaxe.png&w=32&h=32&fit=contain) **Super Iron Pickaxe** |  |

#### Golden Super Pickaxe
| ![Golden Pickaxe](https://minecraft.wiki/images/thumb/Golden_Pickaxe_JE2_BE1.png/32px-Golden_Pickaxe_JE2_BE1.png) | ![Golden Pickaxe](https://minecraft.wiki/images/thumb/Golden_Pickaxe_JE2_BE1.png/32px-Golden_Pickaxe_JE2_BE1.png) | ![Golden Pickaxe](https://minecraft.wiki/images/thumb/Golden_Pickaxe_JE2_BE1.png/32px-Golden_Pickaxe_JE2_BE1.png) |
|:---:|:---:|:---:|
|  | ![Stick](https://minecraft.wiki/images/thumb/Stick_JE1_BE1.png/32px-Stick_JE1_BE1.png) |  |
|  | ![Stick](https://minecraft.wiki/images/thumb/Stick_JE1_BE1.png/32px-Stick_JE1_BE1.png) |  |
| **Result** | ![Super Golden Pickaxe](https://wsrv.nl/?url=raw.githubusercontent.com/tantaihaha4487/SuperPickaxeMod/master/resourcepacks/SuperPickaxe/assets/superpickaxe/textures/item/super_golden_pickaxe.png&w=32&h=32&fit=contain) **Super Golden Pickaxe** |  |

#### Diamond Super Pickaxe
| ![Diamond Pickaxe](https://minecraft.wiki/images/thumb/Diamond_Pickaxe_JE1_BE1.png/32px-Diamond_Pickaxe_JE1_BE1.png) | ![Diamond Pickaxe](https://minecraft.wiki/images/thumb/Diamond_Pickaxe_JE1_BE1.png/32px-Diamond_Pickaxe_JE1_BE1.png) | ![Diamond Pickaxe](https://minecraft.wiki/images/thumb/Diamond_Pickaxe_JE1_BE1.png/32px-Diamond_Pickaxe_JE1_BE1.png) |
|:---:|:---:|:---:|
|  | ![Stick](https://minecraft.wiki/images/thumb/Stick_JE1_BE1.png/32px-Stick_JE1_BE1.png) |  |
|  | ![Stick](https://minecraft.wiki/images/thumb/Stick_JE1_BE1.png/32px-Stick_JE1_BE1.png) |  |
| **Result** | ![Super Diamond Pickaxe](https://wsrv.nl/?url=raw.githubusercontent.com/tantaihaha4487/SuperPickaxeMod/master/resourcepacks/SuperPickaxe/assets/superpickaxe/textures/item/super_diamond_pickaxe.png&w=32&h=32&fit=contain) **Super Diamond Pickaxe** |  |

#### Netherite Super Pickaxe
| ![Netherite Pickaxe](https://minecraft.wiki/images/thumb/Netherite_Pickaxe_JE2_BE1.png/32px-Netherite_Pickaxe_JE2_BE1.png) | ![Netherite Pickaxe](https://minecraft.wiki/images/thumb/Netherite_Pickaxe_JE2_BE1.png/32px-Netherite_Pickaxe_JE2_BE1.png) | ![Netherite Pickaxe](https://minecraft.wiki/images/thumb/Netherite_Pickaxe_JE2_BE1.png/32px-Netherite_Pickaxe_JE2_BE1.png) |
|:---:|:---:|:---:|
|  | ![Stick](https://minecraft.wiki/images/thumb/Stick_JE1_BE1.png/32px-Stick_JE1_BE1.png) |  |
|  | ![Stick](https://minecraft.wiki/images/thumb/Stick_JE1_BE1.png/32px-Stick_JE1_BE1.png) |  |
| **Result** | ![Super Netherite Pickaxe](https://wsrv.nl/?url=raw.githubusercontent.com/tantaihaha4487/SuperPickaxeMod/master/resourcepacks/SuperPickaxe/assets/superpickaxe/textures/item/super_netherite_pickaxe.png&w=32&h=32&fit=contain) **Super Netherite Pickaxe** |  |

---
