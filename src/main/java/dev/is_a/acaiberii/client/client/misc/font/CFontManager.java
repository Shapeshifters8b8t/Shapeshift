package dev.is_a.acaiberii.client.client.misc.font;

import java.awt.Font;

public class CFontManager {

    public static Font REGULAR = getFontByName("regular").deriveFont(18f);
    public static Font BOLD = getFontByName("bold").deriveFont(18f);

    public static Font getFontByName(String name) {
        if (name.equalsIgnoreCase("regular")) {
            return getFontFromInput("/assets/gavhack/Regular.ttf");
        }

        if (name.equalsIgnoreCase("bold")) {
            return getFontFromInput("/assets/gavhack/Bold.ttf");
        }

        return null;
    }

    public static Font getFontFromInput(String path) {

        try {
            Font newFont = Font.createFont(Font.TRUETYPE_FONT, CFontManager.class.getResourceAsStream(path));
            return newFont;
        }
        catch (Exception e) {
            return null;
        }
    }
}