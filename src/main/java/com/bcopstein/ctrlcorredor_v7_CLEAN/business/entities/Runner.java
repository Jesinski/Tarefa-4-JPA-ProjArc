package com.bcopstein.ctrlcorredor_v7_CLEAN.business.entities;

public class Runner {
    private String cpf;
    private String name;
    private int birthDay,birthMonth,birthYear;
    private String gender;

    public Runner(String cpf, String name, int birthDay,int birthMonth,int birthYear, String gender) {
        this.cpf = cpf;
        this.name = name;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.gender = gender;
    }

    public String getCpf() {
        return cpf;
    }

    public String getname() {
        return name;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public int getBirthMonth() {
        return birthMonth;
    }
    public int getAbirthYear() {
        return birthYear;
    }

    public String getGender() {
        return gender;
    }

}