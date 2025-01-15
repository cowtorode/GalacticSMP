package com.galactic.globals;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

public class Messages
{
    public static final Component LOCKED_SERVER = Component.text("The server is locked, please wait...", NamedTextColor.RED);
    public static final Component SERVER_LOCKED = Component.text("Locked: ").append(Component.text("true", NamedTextColor.GREEN));
    public static final Component SERVER_UNLOCKED = Component.text("Locked: ").append(Component.text("false", NamedTextColor.RED));
}
