package com.timzappfanclub.app.mapper;
import com.timzappfanclub.app.dto.*;
import com.timzappfanclub.app.entity.*;

public class CredsMapper {
    public static CredsDto mapToCredsDto(Creds c){
        return new CredsDto(
            c.getId(),
            c.getUrl(),
            c.getUsername(),
            c.getHashed_pass(),
            c.getSalt()
        );
    }

    public  static Creds mapToCreds(CredsDto c){
        return new Creds(
            c.getId(),
            c.getUrl(),
            c.getUsername(),
            c.getHashed_pass(),
            c.getSalt()
        ); 
    }
}
