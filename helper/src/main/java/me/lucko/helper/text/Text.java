/*
 * This file is part of helper, licensed under the MIT License.
 *
 *  Copyright (c) lucko (Luck) <luck@lucko.me>
 *  Copyright (c) contributors
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

package me.lucko.helper.text;

import net.kyori.text.Component;
import net.kyori.text.TextComponent;
import net.kyori.text.serializer.ComponentSerializers;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Utilities for working with {@link Component}s and formatted text strings.
 */
@SuppressWarnings("deprecation")
public final class Text {

    public static final char SECTION_CHAR = '\u00A7'; // §
    public static final char AMPERSAND_CHAR = '&';

    public static String joinNewline(String... strings) {
        return joinNewline(Arrays.stream(strings));
    }

    public static String joinNewline(Stream<String> strings) {
        return strings.collect(Collectors.joining("\n"));
    }

    public static TextComponent fromLegacy(String input, char character) {
        return ComponentSerializers.LEGACY.deserialize(input, character);
    }

    public static TextComponent fromLegacy(String input) {
        return ComponentSerializers.LEGACY.deserialize(input);
    }

    public static String toLegacy(Component component, char character) {
        return ComponentSerializers.LEGACY.serialize(component, character);
    }

    public static String toLegacy(Component component) {
        return ComponentSerializers.LEGACY.serialize(component);
    }

    public static void sendMessage(CommandSender sender, Component message) {
        BukkitTextUtils.sendJsonMessage(sender, message);
    }

    public static void sendMessage(Iterable<CommandSender> senders, Component message) {
        BukkitTextUtils.sendJsonMessage(senders, message);
    }

    public static String colorize(String s) {
        return s == null ? null : ChatColor.translateAlternateColorCodes(AMPERSAND_CHAR, s);
    }

    private Text() {
        throw new UnsupportedOperationException("This class cannot be instantiated");
    }

}
