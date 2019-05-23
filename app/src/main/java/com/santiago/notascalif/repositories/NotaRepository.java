package com.santiago.notascalif.repositories;

import com.orm.SugarRecord;
import com.santiago.notascalif.models.Nota;

import java.util.Date;
import java.util.List;

public class NotaRepository {

    public static List<Nota> list(){
        List<Nota> notas = SugarRecord.listAll(Nota.class);
        return notas;
    }

    public static Nota read(Long id){
        Nota nota = SugarRecord.findById(Nota.class, id);
        return nota;
    }

    public static void create(String title, String content){
        Nota nota = new Nota();
        Date fecha = new Date();

        nota.setTitle(title);
        nota.setDate(fecha.getTime());
        nota.setContent(content);

        SugarRecord.save(nota);
    }

    /*public static User login(String username, String password) {
        List<User> users = SugarRecord.find(User.class, "username=? and password=?", username, password);

        if(!users.isEmpty()) {
            return users.get(0);
        }
        return null;
    }*/

    public static Nota load(Long id) {
        Nota nota = SugarRecord.findById(Nota.class, id);
        return nota;
    }

    public static void update(String title, String content, Long id){
        Nota nota = SugarRecord.findById(Nota.class, id);
        nota.setTitle(title);
        nota.setContent(content);
        SugarRecord.save(nota);
    }

    public static void delete(Long id){
        Nota nota = SugarRecord.findById(Nota.class, id);
        SugarRecord.delete(nota);
    }

}
