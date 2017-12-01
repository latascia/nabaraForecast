package console_input_runner;

import request.Request;

import java.util.Scanner;

public class ConsoleInputGetter {

    private Scanner scanner = new Scanner(System.in);

    private String getData(String message) {
        System.out.println(String.format("Please enter %s", message));
        return scanner.nextLine();
    }

    public Request getRequestFromConsole() {
        return new Request(getData("city name"), getData("country code"));
    }

}
