package dev.is_a.acaiberii.client.cloosh.ui.gui.components;

import dev.is_a.acaiberii.client.BeriiOnToppe;
import dev.is_a.acaiberii.client.cloosh.misc.util.FontUtil;
import dev.is_a.acaiberii.client.cloosh.misc.util.Utils;
import dev.is_a.acaiberii.client.cloosh.module.Module;
import dev.is_a.acaiberii.client.cloosh.setting.impl.NumberSetting;
import dev.is_a.acaiberii.client.cloosh.ui.gui.Component;
import net.minecraft.client.gui.Gui;

import java.math.BigDecimal;
import java.math.RoundingMode;

// code was referenced from past by olliem5 to do the sliders
public class NumberComponent extends Component {

    public NumberSetting setting;
    public double sliderWidth;
    public boolean draggingSlider;

    public NumberComponent(Module parent, NumberSetting setting, int x, int y, int width, int height, int offset) {
        super(parent, x, y, width, height, offset);

        this.setting = setting;
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) {
        if (isMouseWithin(mouseX, mouseY) && button == 0) {
            Utils.playClick();
            this.draggingSlider = true;
        }
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int mouseButton) {
        this.draggingSlider = false;
    }

    @Override
    public void draw(int mouseX, int mouseY) {
        updateComponent(mouseX, mouseY);
        Gui.drawRect(x, y, x + width, y + height, 0xcf000000);

        // drawing slider
        Gui.drawRect(x, y, (int) (x + sliderWidth), y + height, BeriiOnToppe.gui.guiColor.getRGB());
        FontUtil.drawStringWithShadow(setting.name + " " + setting.getValue(), x + 3, y + 3, -1);
        Gui.drawRect(x, y, x + 1, y + height, BeriiOnToppe.gui.guiColor.getRGB());
    }

    public void updateComponent(int mouseX, int mouseY) {
        double diff = Math.min(width, Math.max(0, mouseX - this.x));
        double min = this.setting.getMinimun();
        double max = this.setting.getMaximum();
        this.sliderWidth = width * (this.setting.getValue() - min) / (max - min);
        if (this.draggingSlider) {
            if (diff == 0) {
                this.setting.setValue(this.setting.getMinimun());
            } else {
                double newValue = roundToPlace(diff / width * (max - min) + min, 2);
                this.setting.setValue(newValue);
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