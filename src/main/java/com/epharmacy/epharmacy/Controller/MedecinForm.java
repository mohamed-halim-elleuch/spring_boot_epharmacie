package com.epharmacy.epharmacy.Controller;

import com.epharmacy.epharmacy.model.AppUser;
import com.epharmacy.epharmacy.model.Medecin;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MedecinForm {
    private AppUser appUser = new AppUser();
    private List<Medecin> medecins = new ArrayList<>();
}
