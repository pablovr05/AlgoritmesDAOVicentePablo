package com.project;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DaoEina {
    private static final String PATH = Main.einesPath;
    private List<ObjEina> eines;

    public DaoEina() {
        eines = load();
    }

    private List<ObjEina> load() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(PATH), new TypeReference<List<ObjEina>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void add(ObjEina eina) {
        eines.add(eina);
        save();
    }

    public void update(int id, ObjEina eina) {
        for (int i = 0; i < eines.size(); i++) {
            if (eines.get(i).getId() == id) {
                eines.set(i, eina);
                save();
                break;
            }
        }
    }

    public void delete(int id) {
        eines.removeIf(eina -> eina.getId() == id);
        save();
    }

    public ObjEina get(int id) {
        return eines.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public List<ObjEina> getAll() {
        return eines;
    }

    public void setNom(int id, String nom) {
        eines.stream().filter(e -> e.getId() == id).findFirst().ifPresent(e -> e.setNom(nom));
        save();
    }

    public void setAny(int id, int any) {
        eines.stream().filter(e -> e.getId() == id).findFirst().ifPresent(e -> e.setAny(any));
        save();
    }

    public void setLlenguatgesAdd(int id, int idLlenguatge) {
        eines.stream().filter(e -> e.getId() == id).findFirst().ifPresent(e -> {
            e.getLlenguatges().add(idLlenguatge);
            save();
        });
    }

    public void setLlenguatgesDelete(int id, int idLlenguatge) {
        eines.stream().filter(e -> e.getId() == id).findFirst().ifPresent(e -> {
            e.getLlenguatges().remove(Integer.valueOf(idLlenguatge));
            save();
        });
    }

    public void print() {
        eines.forEach(System.out::println);
    }

    private void save() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(PATH), eines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
