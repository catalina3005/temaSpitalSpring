package com.example.temaspitalspring.exception;

public class NoDoctorException extends Exception{
    public NoDoctorException(){
        super("the doctor you have introduced does not exist");
    }
}