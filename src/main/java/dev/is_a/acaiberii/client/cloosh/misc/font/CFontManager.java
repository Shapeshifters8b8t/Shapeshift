package dev.is_a.acaiberii.client.cloosh.misc.font;

import java.awt.Font;

public class CFontManager {

    public static Font CUSTOM_FONT = getFontByName("muli-semibold").deriveFont(18f);
    public static Font QUCKSAND = getFontByName("quicksand").deriveFont(18f);

    public static Font getFontByName(String name) {
        if (name.equalsIgnoreCase("muli-semibold")) {
            return getFontFromInput("/assets/gavhack/Muli-SemiBold.ttf");
        }

        if (name.equalsIgnoreCase("quicksand")) {
            return getFontFromInput("/assets/gavhack/Quicksand.ttf");
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