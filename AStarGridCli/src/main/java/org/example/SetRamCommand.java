package org.example;

public class SetRamCommand implements ConsoleCommand {
    private int ram;
    private final ServerClient client = new ServerClient();

    @Override
    public void setArgs(String[] args) {
        for (int i = 1; i < args.length; i++) {
            if ("--ram".equals(args[i]) && i + 1 < args.length) {
                ram = Integer.parseInt(args[i + 1]);
            }
        }
    }

    @Override
    public void execute() {
        if (ram <= 0) {
            System.out.println("Ошибка: укажите размер RAM в MB через --ram");
            return;
        }

        String response = client.setRamLimit(ram);
        System.out.println(response);
    }
}
