package com.fpmislata.banco.persistencia.dao;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintViolation;

public class BussinessException extends Exception {

    private List<BussinessMessage> bussinessMessageList = new ArrayList();

    public BussinessException(List<BussinessMessage> bussinessMessageList) {
        this.bussinessMessageList.addAll(bussinessMessageList);
    }

    public BussinessException(BussinessMessage bussinessMessage) {
        this.bussinessMessageList.add(bussinessMessage);
    }

    public BussinessException(String fieldName, String message) {

        BussinessMessage bussinessMessage = new BussinessMessage(fieldName, message);
        this.bussinessMessageList.add(bussinessMessage);
    }

    public BussinessException(javax.validation.ConstraintViolationException cve) {
        
       for (ConstraintViolation constraintViolation : cve.getConstraintViolations()) {
             String fieldName;
             String message;

             fieldName = constraintViolation.getPropertyPath()+"";
             message = constraintViolation.getMessage();

             BussinessMessage bussinessMessage = new BussinessMessage(fieldName, message);
             bussinessMessageList.add(bussinessMessage);
         }
    }

    public List<BussinessMessage> getBussinessMessageList() {
        return bussinessMessageList;
    }

}
