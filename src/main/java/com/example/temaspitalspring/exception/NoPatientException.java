package com.example.temaspitalspring.exception;
public class NoPatientException extends Exception{
    public NoPatientException(){
        super("the patient you have introduced does not exist");
    }
}
