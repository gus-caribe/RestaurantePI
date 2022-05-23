package com.example.projetorestaurante.models;

import java.util.ArrayList;
import java.util.List;

public class ItemDatabase {
    public static List<Item> myDataset = new ArrayList<>();

    static {
        myDataset.add(new Item(1, "Macarrão com alho e olho", "Banana", 1500.20));
        myDataset.add(new Item(2, "Macarrão com alho e olho", "Banana", 1500.20));
        myDataset.add(new Item(3, "Macarrão com alho e olho", "Banana", 1500.20));
        myDataset.add(new Item(4, "Macarrão com alho e olho", "Banana", 1500.20));
        myDataset.add(new Item(5, "Macarrão com alho e olho", "Banana", 1500.20));
        myDataset.add(new Item(6, "Macarrão com alho e olho", "Banana", 1500.20));
        myDataset.add(new Item(7, "Macarrão com alho e olho", "Banana", 1500.20));
        myDataset.add(new Item(8, "Macarrão com alho e olho", "Banana", 1500.20));
        myDataset.add(new Item(9, "Macarrão com alho e olho", "Banana", 1500.20));
        myDataset.add(new Item(10, "Macarrão com alho e olho", "Banana", 1500.20));
    }
}
