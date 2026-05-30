package Windows;

import Settings.Setting;
import Settings.SettingControlType;
import Settings.SimulationConfig;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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

        JScrollPane scroll = new JScrollPane(container);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scroll);

        setVisible(true);
    }

    private void showAllSettings(JPanel container){

        for(Setting setting : config.getSettings()){


            container.add(buildSetting(setting));

        }


    }

    private JPanel buildSetting(Setting setting) {
        JPanel row = new JPanel(new GridBagLayout());
        row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 56));
        row.setBorder(BorderFactory.createEmptyBorder(4, 10, 4, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy   = 0;
        gbc.insets  = new Insets(0, 4, 0, 4);
        gbc.anchor  = GridBagConstraints.WEST;

        gbc.gridx   = 0;
        gbc.weightx = 0;
        JLabel label = new JLabel(setting.getSliderLabel());
        label.setPreferredSize(new Dimension(110, 20));
        row.add(label, gbc);

        if (setting.getControlType() != SettingControlType.SLIDEBAR) {
            gbc.gridx = 1;
            JToggleButton toggle = new JToggleButton(setting.isEnabled() ? "On" : "Off");

            toggle.setSelected(true);
            Customs.settingsButton(toggle);

            toggle.addActionListener(e -> {
                Customs.settingsButton(toggle);
                boolean isOn = !setting.isEnabled() ;
                setting.setEnabled(isOn);
                toggle.setText(isOn ? "On" : "Off");
            });

            row.add(toggle, gbc);
        }

        if (setting.getControlType() == SettingControlType.TOGGLE_WITH_SLIDEBAR
                || setting.getControlType() == SettingControlType.SLIDEBAR) {

            gbc.gridx   = 2;
            gbc.weightx = 1.0;
            gbc.fill    = GridBagConstraints.HORIZONTAL;
            JSlider slider = new JSlider((int) setting.getSliderMin(),
                    (int) setting.getSliderMax(),
                    (int) setting.getSliderValue());
            Customs.settingsSlider(slider);

            JLabel readout = new JLabel(String.format("%.1f", setting.getSliderValue()));
            readout.setPreferredSize(new Dimension(36, 20));

            slider.addChangeListener(e -> {
                setting.setSliderValue(slider.getValue());
                readout.setText(String.format("%.1f", (double) slider.getValue()));
            });

            row.add(slider, gbc);

            gbc.gridx   = 3;
            gbc.weightx = 0;
            gbc.fill    = GridBagConstraints.NONE;
            row.add(readout, gbc);
        }

        return row;
    }

}
