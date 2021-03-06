package dev.is_a.acaiberii.client.client.ui.rewrite.impl.setting;

import dev.is_a.acaiberii.client.client.events.NumberSettingChangedEvent;
import dev.is_a.acaiberii.client.client.misc.util.FontUtil;
import dev.is_a.acaiberii.client.client.setting.impl.NumberSetting;
import dev.is_a.acaiberii.client.client.ui.rewrite.impl.BaseComponent;
import dev.is_a.acaiberii.client.client.ui.rewrite.impl.ClickGuiScreen;
import net.minecraft.client.gui.Gui;
import net.minecraftforge.common.MinecraftForge;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberComponent extends BaseComponent {

    public NumberSetting parent;
    double sliderWidth;
    boolean draggingSlider;
    double value;

    public NumberComponent(NumberSetting parent, int x, int y, int width, int height) {
        super(x, y, width, height);
        this.parent = parent;
    }

    @Override
    public void draw(int mouseX, int mouseY) {
        update(mouseX, mouseY);
        // rect or slider
        Gui.drawRect(x, y, (int) (x + sliderWidth), y + height, ClickGuiScreen.guiColor.getRGB());

        // text
        FontUtil.drawStringWithShadow(parent.name + " " + parent.getValue(), x + 3, y + 2, -1);
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (isMouseWithin(mouseX, mouseY) && mouseButton == 0) {
            this.draggingSlider = true;
        }
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int mouseButton) {
        this.draggingSlider = false;
        NumberSettingChangedEvent event = new NumberSettingChangedEvent(parent, value);
        MinecraftForge.EVENT_BUS.post(event);
    }

    private void update(int mouseX, int mouseY) {
        double diff = Math.min(width, Math.max(0, mouseX - this.x));
        double min = this.parent.getMinimun();
        double max = this.parent.getMaximum();
        this.sliderWidth = width * (this.parent.getValue() - min) / (max - min);
        if (this.draggingSlider) {
            if (diff == 0) {
                this.parent.setValue(this.parent.getMinimun());
            } else {
                double newValue = roundToPlace(diff / width * (max - min) + min, 2);
                this.parent.setValue(newValue);
                value = newValue;
            }
        }
    }

    private static double roundToPlace(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
