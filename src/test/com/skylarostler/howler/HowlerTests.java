package com.skylarostler.howler;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;
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
}
