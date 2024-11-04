package hu.szamalk;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Gson gson = new Gson();
        Konyv konyv = new Konyv("Kosztolányi Dezső", "Esti Kornél", 1891, 1999);
        String objJson = gson.toJson(konyv);

        System.out.println(objJson);

        Konyv ujKonyv = gson.fromJson(objJson, Konyv.class);

        System.out.println(ujKonyv);

        List<Konyv> konyvek = new ArrayList<>();
        konyvek.add(konyv);
        konyvek.add(new Konyv("Igen", "nem", 1233, 500));
        konyvek.add(new Konyv("Ahha", "Jajaa", 1212, 5200));

        String listaToJson = gson.toJson(konyvek);

        System.out.println(listaToJson);

        String[] t = listaToJson.split(",");

        for (String s : t) {
            System.out.println(s);
        }
        Type tipus = new TypeToken<List<Konyv>>() {
        }.getType();
        List<Konyv> ujLista = gson.fromJson(listaToJson, tipus);

        for (Konyv konyv1 : ujLista) {
            System.out.println(konyv1);
        }
    }

    private static class Konyv {

        private String szerzo;
        private String cim;
        private int kiadasEve;
        private double ar;

        public Konyv(String szerzo, String cim, int kiadasEve, double ar) {

            this.szerzo = szerzo;
            this.cim = cim;
            this.kiadasEve = kiadasEve;
            this.ar = ar;
        }

        public String getSzerzo() {

            return szerzo;
        }

        public String getCim() {

            return cim;
        }

        public int getKiadasEve() {

            return kiadasEve;
        }

        public double getAr() {

            return ar;
        }

        @Override
        public String toString() {

            return "Konyv{" + "szerzo='" + szerzo + '\'' + ", cim='" + cim + '\'' + ", kiadasEve=" + kiadasEve + ", ar=" + ar + '}';
        }
    }
}