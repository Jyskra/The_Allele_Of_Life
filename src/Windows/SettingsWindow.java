package Windows;

import Settings.Setting;
import Settings.SettingControlType;
import Settings.SimulationConfig;

import javax.swing.*;
import java.awt.*;

public class SettingsWindow extends JDialog {

    private SimulationConfig config;

    public SettingsWindow(SimulationConfig config, JFrame parent){
        super(parent, "Settings", true);
        setSize(500, 500);
        setLocationRelativeTo(parent);

        this.config = config;

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        showAllSettings(container);

        add(new JScrollPane(container));

        setVisible(true);
    }

    private void showAllSettings(JPanel container){

        for(Setting setting : config.getSettings()){

            container.add(buildSetting(setting));

        }


    }

    private void makeRadiusSetting(){

    }

    private JPanel buildSetting(Setting setting){

        JPanel settingContainer = new JPanel(new BorderLayout());
        settingContainer.setMaximumSize(new Dimension(Integer.MAX_VALUE, 64));
        settingContainer.setBorder(BorderFactory.createEmptyBorder(6, 10, 6, 10));

        JLabel label = new JLabel(setting.getSliderLabel());
        JToggleButton toggle = new JToggleButton("Off");
        Customs.settingsButton(toggle);

        toggle.addActionListener(e -> {
            Customs.settingsButton(toggle);
            boolean isOn = toggle.isSelected();
            toggle.setText(isOn ? "On" : "Off");
            config.configure(setting, isOn);
        });

        JPanel left = new JPanel(new FlowLayout(FlowLayout.LEFT));
        left.add(label);
        left.add(toggle);

        settingContainer.add(left, BorderLayout.WEST);

        if(setting.getControlType() == SettingControlType.TOGGLE_WITH_SLIDEBAR){
            JPanel sliderPanel = buildSlider(setting);
            settingContainer.add(sliderPanel, BorderLayout.EAST);
        }

        return settingContainer;

    }

    private JPanel buildSlider(Setting setting){
        int min   = (int)(setting.getSliderMin());
        int max   = (int)(setting.getSliderMax());
        int initialValue = (int)(setting.getSliderValue());

        JSlider slider = new JSlider(min, max, initialValue);

        Customs.settingsSlider(slider);

        JLabel  readout = new JLabel(String.format("%.2f", setting.getSliderValue()));
        readout.setPreferredSize(new Dimension(40, 20));

        slider.addChangeListener(e -> {
            double value = slider.getValue();
            setting.setSliderValue(value);
            readout.setText(String.format("%.2f", value));
        });

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.add(new JLabel(setting.getSliderLabel()));
        panel.add(slider);
        panel.add(readout);
        return panel;

    }
}
