package com.danny.SpringIoCLearning.service.Test;

public class DaoImpl implements DaoInterface,ServiceInterface {
    @Override
    public void save(){
        System.out.println("Dao Save");
    }


    @Override
    public void update() {
        System.out.println("Dao update");
    }
}
