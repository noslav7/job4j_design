package ru.job4j.ood.srp;

import java.util.function.Predicate;

public class ReportEngineAccountants implements Report {

    private Store store;

    public ReportEngineAccountants(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Wages;");
        final double workDays = 20.0;
        for (Employee employee : store.findBy(filter)) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append((employee.getSalary()) / workDays).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
