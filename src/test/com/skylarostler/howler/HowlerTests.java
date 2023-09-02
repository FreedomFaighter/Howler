package com.skylarostler.howler;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.beans.Transient;

import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.bukkit.plugin.java.JavaPluginLoader;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import com.skylarostler.howler.Howler;

public class HowlerTests {
    Command falseCommand = mock(Command.class);
    CommandSender falseCommandSender = mock(CommandSender.class);
    Howler howler = mock(Howler.class);
    CommandSender commandSender = mock(CommandSender.class);
    Command command = mock(Command.class);
    @Test
    public void classesAreInstanceOf()
    {
        assertTrue(falseCommand instanceof Command);
        assertTrue(falseCommandSender instanceof CommandSender);
        assertTrue(howler instanceof Howler);
        assertTrue(command instanceof Command);
        assertTrue(commandSender instanceof CommandSender);
    }

    @Test
    public void onCommandFalseHowler()
    {
        when(falseCommand.getName()).thenReturn("notAHowlString");
        if("notAHowlString" == Howler.getCommand())
        {    
            fail("attempting to run test with valid command which would normally return a true value");
        }
        when(howler.onCommand(falseCommandSender, falseCommand, null, null)).thenReturn(false);
        assertFalse(howler.onCommand(falseCommandSender, falseCommand, null, null));
    }

    @Test
    public void onCommandHowlerTest()
    {
        when(howler.onCommand(commandSender, command, null, null)).thenReturn(true);
        assertTrue(howler.onCommand(commandSender, command, null, null));
    }
}
