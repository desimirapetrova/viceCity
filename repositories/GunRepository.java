package viceCity.repositories;

import viceCity.models.guns.Gun;
import viceCity.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

public class GunRepository implements Repository <Gun>{
    Collection<Gun>models;
    public GunRepository(){
        this.models=new LinkedHashSet<>();
    }
    @Override
    public Collection<Gun> getModels() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Gun model) {
        if(!models.contains(model)){
            this.models.add(model);
        }

    }

    @Override
    public boolean remove(Gun model) {
        return this.models.remove(model);
    }

    @Override
    public Gun find(String name) {
        Gun gun = null;
        for (Gun model : models) {
            if (model.getName().equals(name)) {
                gun=model;
            }
        }
        return gun;
    }
}
