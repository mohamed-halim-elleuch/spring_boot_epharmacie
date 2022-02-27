package com.epharmacy.epharmacy.Controller;


import com.epharmacy.epharmacy.model.AppUser;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CommandeForm {
    private int id;
    private AppUser appUser=new AppUser();
    private List<CommandeAricle> aricles=new ArrayList<>();
}
@Data
class CommandeAricle{
    private Long id;
    private int quantity;
    private String name;
    private int price;
}
