package com.fpmislata.banco.persistencia.dao.impl.hibernate.common;

import java.util.ArrayList;
import java.util.List;

public class BussinessException extends Exception{
    
    private List<BussinessMessage> BussinessMessageList = new ArrayList();
    
    public BussinessException(List<BussinessMessage> bussinessMessageList){   
            this.BussinessMessageList.addAll(bussinessMessageList);     
    }
    
    public BussinessException(BussinessMessage bussinessMessage){   
            this.BussinessMessageList.add(bussinessMessage);     
    }
    
    public BussinessException(String fieldName,String message){   
            
            BussinessMessage bussinessMessage=new BussinessMessage(fieldName,message);
            this.BussinessMessageList.add(bussinessMessage);     
    }

    public List<BussinessMessage> getBussinessMessageList() {
        return BussinessMessageList;
    }
    
}
