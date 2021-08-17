package ca.jrvs.practice.dataStructure.list;

import java.util.Comparator;

public class EmployeeSort {

  public static class EmployeeAgeComparable extends Employee implements Comparable<Employee> {

    @Override
    public int compareTo(Employee o) {
      return Integer.compare(getAge(), o.getAge());
    }
  }

  public static class EmployeeSalaryComparable extends Employee implements Comparable<Employee> {

    @Override
    public int compareTo(Employee o) {
      return Long.compare(getSalary(), o.getSalary());
    }
  }

  public static class EmployeeAgeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
      return Integer.compare(o1.getAge(), o2.getAge());
    }
  }

  public static class EmployeeSalaryComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
      return Long.compare(o1.getSalary(), o2.getSalary());
    }
  }
}
