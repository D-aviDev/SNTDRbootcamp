package com.project.SNTDRbootcamp.exceptions;

import com.project.SNTDRbootcamp.util.MessageUtils;
import org.aspectj.bridge.Message;

public class NotFoundException extends RuntimeException{

    public NotFoundException(){
        super(MessageUtils.NO_RECORDS_FOUND);
    }
}
