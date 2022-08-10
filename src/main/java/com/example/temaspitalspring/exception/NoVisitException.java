package com.example.temaspitalspring.exception;

public class NoVisitException extends Exception{
    public NoVisitException(){
        super("the visit you have introduced does not exist");
    }
}