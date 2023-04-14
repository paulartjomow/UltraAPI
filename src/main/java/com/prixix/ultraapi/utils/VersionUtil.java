package com.prixix.ultraapi.utils;

import lombok.Getter;
import org.bukkit.Bukkit;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VersionUtil {

    @Getter
    private static int MAJOR_VERSION = -1;

    @Getter
    private static int MINOR_VERSION = -1;

    static {
        Matcher matcher = Pattern.compile("MC: \\d\\.(\\d+)(\\.(\\d+))?").matcher(Bukkit.getVersion());
        if(matcher.find()) {
            MAJOR_VERSION = Integer.parseInt(matcher.group(1));
            MINOR_VERSION = Optional.ofNullable(matcher.group(3)).filter(s -> !s.isEmpty()).map(Integer::parseInt).orElse(0);
        }
    }

    public static boolean isAtLeast(int version) {
        return MAJOR_VERSION >= version;
    }

    public static boolean isAtLeast(int majorVersion, int minorVersion) {
        return MAJOR_VERSION > majorVersion || (MAJOR_VERSION == majorVersion && MINOR_VERSION >= minorVersion);
    }

    public static boolean isAt(int majorVersion) {
        return MAJOR_VERSION == majorVersion;
    }

    public static boolean isAt(int majorVersion, int minorVersion) {
        return MAJOR_VERSION == majorVersion && MINOR_VERSION == minorVersion;
    }

}
