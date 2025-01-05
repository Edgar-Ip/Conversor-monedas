import java.util.Scanner;

public class PrincipalConversion {
    private final ExchangeRateAPI exchangeRateAPI = new ExchangeRateAPI();

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("=== Conversor de Monedas ===");
            System.out.println("1- Dólar a Peso Argentino");
            System.out.println("2- Peso Argentino a Dólar");
            System.out.println("3- Dólar a Real brasileño");
            System.out.println("4- Real brasileño a Dólar");
            System.out.println("5- Dólar a Peso colombiano");
            System.out.println("6- Peso colombiano a Dólar");
            System.out.println("7- Peso mexicano a Dólar");
            System.out.println("8- Dólar a Peso Mexicano");
            System.out.println("9- Dólar Americano a Dólar canadiense");
            System.out.println("10- Dólar Canadiense a Dólar Americano");
            System.out.println("11- Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();

            String fromCurrency = "", toCurrency = "";
            switch (option) {
                case 1 -> { fromCurrency = "USD"; toCurrency = "ARS"; }
                case 2 -> { fromCurrency = "ARS"; toCurrency = "USD"; }
                case 3 -> { fromCurrency = "USD"; toCurrency = "BRL"; }
                case 4 -> { fromCurrency = "BRL"; toCurrency = "USD"; }
                case 5 -> { fromCurrency = "USD"; toCurrency = "COP"; }
                case 6 -> { fromCurrency = "COP"; toCurrency = "USD"; }
                case 7 -> { fromCurrency = "MXN"; toCurrency = "USD"; }
                case 8 -> { fromCurrency = "USD"; toCurrency = "MXN"; }
                case 9 -> { fromCurrency = "USD"; toCurrency = "CAD"; }
                case 10 -> { fromCurrency = "CAD"; toCurrency = "USD"; }
                case 11 -> System.out.println("Gracias por utilizar la aplicación de conversión de Monedas. ¡Hasta luego!");
                default -> System.out.println("Opción no encontrada. Inténtelo nuevamente.");
            }

            if (option >= 1 && option <= 10) {
                System.out.print("Ingrese el monto a convertir: ");
                double amount = scanner.nextDouble();
                double rate = exchangeRateAPI.getExchangeRate(fromCurrency, toCurrency);

                if (rate != 0.0) {
                    double convertedAmount = amount * rate;
                    System.out.printf("Tasa de cambio: 1 %s = %.2f %s%n", fromCurrency, rate, toCurrency);
                    System.out.printf("Monto convertido: %.2f %s%n", convertedAmount, toCurrency);
                } else {
                    System.out.println("No se pudo obtener la tasa de cambio. Intente más tarde.");
                }
            }
        } while (option != 11);

        scanner.close();
    }
}

