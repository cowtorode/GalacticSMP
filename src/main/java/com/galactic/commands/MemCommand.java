package com.galactic.commands;

import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;

public class MemCommand implements BasicCommand
{
    private double bytesToMiB(long bytes)
    {
        return 9.53674316e-7D * bytes;
    }

    @Override
    public String permission()
    {
        return "galactic.commands.mem";
    }

    @Override
    public void execute(CommandSourceStack stack, String[] strings)
    {
        Runtime runtime = Runtime.getRuntime();
        long total = runtime.totalMemory();
        long inUse = total - runtime.freeMemory();

        stack.getSender().sendMessage(bytesToMiB(inUse) + " MiB / " + bytesToMiB(total) + " MiB");
    }
}
