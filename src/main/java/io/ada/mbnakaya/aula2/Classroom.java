package main.java.io.ada.mbnakaya.aula2;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * Assunto abordado: Java Time, trabalhando com datas e horas
 * Obs: evitaremos a utilização do Java <1.8 por conta do pacote java.time
 */
public class Classroom {

    public static void main(String[] args) {
        System.out.println("Boa noite!");
    }

    /**
     * LocalDate (representa o dia), LocalTime (representa a hora), LocalDateTime (representa o dia e hora)
     */
    private static void showDataHora() {
        // método now() -> retorna a data/hora atual do relógio do sistema host

        // método of() -> retorna a data/hora informada
    }

    /**
     * Utiliza o método parse() para converter Strings em objetos de data e/ou hora.
     * LocalDate.parse("YYYY-MM-DD")
     * LocalTime.parse("hh:mm:ss")
     * LocalDateTime.parse("YYYY-MM-DDThh:mm:ss")
     *
     * Utiliza o método DateTimeFormatter.ofPattern() para sobrescrever o formato de data/hora.
     * Obs: para um objeto de data/hora já instanciado, utilizar o método format().
     */
    private static void showParser() {}

    /**
     * EXEMPLOS:
     * getDayOfWeek() -> retorna ENUM (DayOfWeek) representando dia da semana
     * getEra() -> retorna ENUM (IsoEra) BCE (Before Christ Era) ou CE (Christ Era, vulgo AD ou Anno Domini)
     * minusDays() -> subtrai dias
     * minusDays() -> incrementa dias
     */
    private static void showOperations() {}

    /**
     * Challenge One: use o stdout para exibir o dia da semana anterior ao dia do seu nascimento.
     */
    private static void showChallengeOne() {}

    /**
     * GMT (Greenwich Mean Time) e o UTC (Universal Time Coordinated) representam o mesmo horário.
     * Cada fuso é presentado como uma operação desse horário universal, exemplo: horário de Brasília == GMT-3
     *
     * Utiliza o ZonedDateTime.of(LocalDateTime, ZoneId) para converter a data e hora para um fuso específico.
     *
     * O ZoneId.of() pode ser utilizado para obter um ZoneId à partir de uma String (precisa ser específica).
     * Obs: consultar a documentação do ZoneId para saber os fusos disponíveis.
     */
    private static void showZonedDateTime() {}

    /**
     * Utiliza a classe TemporalAdjusters para realizar operações com a data/hora já instanciada.
     *
     * EXEMPLO:
     * LocalDateTime.with(TemporalAdjusters.next(DayOfWeek)) -> retorna uma cópia do objeto original alterando a data
     * para a próxima sexta-feira.
     */
    private static void showTemporalAdjusters() {}

    /**
     * Period -> representa dias, meses ou anos
     * Duration -> representa minutos ou horas
     * Instant -> representa segundos e nano-segundos (Unix Timestamp, também conhecido como Epoch, desde 01/01/1970)
     *
     * Obs: podemos combinar as operações anteriores, como plus(), com as classes de período, duração e instante.
     */
    private static void showPeriodDurationAndInstant() {}

    /**
     * Challenge Two: use o stdout para imprimir a duração de execução do método abaixo.
     */
    private static void showChallengeTwo() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Execução de número: " + i);
        }
    }

    /**
     * Utiliza o método ZonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle).withLocale(Locale))
     * para converter uma data e hora para uma linguagem/cultura diferente.
     */
    private static void showLocaleDateTime() {
        Locale br = new Locale("pt", "BR");
        Locale jp = new Locale("ja");
        Locale us = new Locale("en", "US");

        ZonedDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(br));
    }
}
