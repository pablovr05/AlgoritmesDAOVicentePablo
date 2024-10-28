package com.project;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DaoLlenguatge {
    private static final String PATH = Main.llenguatgesPath;
    private List<ObjLlenguatge> llenguatges;

    public DaoLlenguatge() {
        llenguatges = load();
    }

    private List<ObjLlenguatge> load() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(PATH), new TypeReference<List<ObjLlenguatge>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void add(ObjLlenguatge llenguatge) {
        llenguatges.add(llenguatge);
        save();
    }

    public void update(int id, ObjLlenguatge llenguatge) {
        for (int i = 0; i < llenguatges.size(); i++) {
            if (llenguatges.get(i).getId() == id) {
                llenguatges.set(i, llenguatge);
                save();
                break;
            }
        }
    }

    public void delete(int id) {
        llenguatges.removeIf(llenguatge -> llenguatge.getId() == id);
        save();
    }

    public ObjLlenguatge get(int id) {
        return llenguatges.stream().filter(l -> l.getId() == id).findFirst().orElse(null);
    }

    public List<ObjLlenguatge> getAll() {
        return llenguatges;
    }

    public void setNom(int id, String nom) {
        llenguatges.stream().filter(l -> l.getId() == id).findFirst().ifPresent(l -> l.setNom(nom));
        save();
    }

    public void setAny(int id, int any) {
        llenguatges.stream().filter(l -> l.getId() == id).findFirst().ifPresent(l -> l.setAny(any));
        save();
    }

    public void setDificultat(int id, String dificultat) {
        llenguatges.stream().filter(l -> l.getId() == id).findFirst().ifPresent(l -> l.setDificultat(dificultat));
        save();
    }

    public void setPopularitat(int id, int popularitat) {
        llenguatges.stream().filter(l -> l.getId() == id).findFirst().ifPresent(l -> l.setPopularitat(popularitat));
        save();
    }

    public void print() {
        llenguatges.forEach(System.out::println);
    }

    private void save() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(PATH), llenguatges);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
