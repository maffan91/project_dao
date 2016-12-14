package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class MainGenerator {

    public static void main(String[] args)  throws Exception {


        Schema schema = new Schema(1,"com.app.maffan.mydaoapp.db");
        Entity entity = schema.addEntity("User");
        entity.addIdProperty();
        entity.addStringProperty("first_name").notNull();
        entity.addStringProperty("last_name").notNull();
        entity.addStringProperty("email").notNull();
        new DaoGenerator().generateAll(schema,"./app/src/main/java");



    }
}
