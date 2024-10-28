package com.project;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DaoSoftware {
    private static final String PATH = Main.softwarePath;
    private List<ObjSoftware> software;

    public DaoSoftware() {
        software = load();
    }

    private List<ObjSoftware> load() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(PATH), new TypeReference<List<ObjSoftware>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void add(ObjSoftware soft) {
        software.add(soft);
        save();
    }

    public void update(int id, ObjSoftware soft) {
        for (int i = 0; i < software.size(); i++) {
            if (software.get(i).getId() == id) {
                software.set(i, soft);
                save();
                break;
            }
        }
    }

    public void delete(int id) {
        software.removeIf(soft -> soft.getId() == id);
        save();
    }

    public ObjSoftware get(int id) {
        return software.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    public List<ObjSoftware> getAll() {
        return software;
    }

    public void setNom(int id, String nom) {
        software.stream().filter(s -> s.getId() == id).findFirst().ifPresent(s -> s.setNom(nom));
        save();
    }

    public void setAny(int id, int any) {
        software.stream().filter(s -> s.getId() == id).findFirst().ifPresent(s -> s.setAny(any));
        save();
    }

    public void print() {
        software.forEach(System.out::println);
    }

    private void save() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(PATH), software);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
