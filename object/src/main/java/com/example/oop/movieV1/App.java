package com.example.oop.movieV1;

import java.sql.SQLOutput;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class App {
    public static void main(String[] args) {
        Movie avatar = new Movie("아바타",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new AmountDiscountPolicy(
                        Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))
                ));
        Screening screening = new Screening(avatar, 2, LocalDateTime.of(2021, 7, 12, 9, 0));
        Screening screening_sale = new Screening(avatar, 2, LocalDateTime.of(2021, 7, 12, 10, 0));
        System.out.println(avatar.calculateMovieFee(screening));
        System.out.println(avatar.calculateMovieFee(screening_sale));

        Movie starWars = new Movie("스타워즈",
                Duration.ofMinutes(210),
                Money.wons(10000),
                new NoneDiscountPolicy());
        Screening screening_starWars = new Screening(starWars, 2, LocalDateTime.of(2021, 7, 12, 9, 0));
        System.out.println(starWars.calculateMovieFee(screening_starWars));
    }
}
