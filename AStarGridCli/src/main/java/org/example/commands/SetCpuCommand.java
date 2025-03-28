package org.example.commands;

import org.example.ServerClient;

public class SetCpuCommand implements ConsoleCommand {
    private double cpu;
    private final ServerClient client = new ServerClient();

    @Override
    public void setArgs(String[] args) {
        for (int i = 1; i < args.length; i++) {
            if ("--cpu".equals(args[i]) && i + 1 < args.length) {
                cpu = Double.parseDouble(args[i + 1]);
            }
        }
    }

    @Override
    public void execute() {
        if (cpu <= 0) {
            System.out.println("Error: need --cpu");
            return;
        }

        String response = client.setCpuLimit(cpu);
        System.out.println(response);
    }
}
