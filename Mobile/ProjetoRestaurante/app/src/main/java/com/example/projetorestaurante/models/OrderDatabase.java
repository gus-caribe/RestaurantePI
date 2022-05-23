package com.example.projetorestaurante.models;

import java.util.ArrayList;
import java.util.List;

public class OrderDatabase {
    public static List<Order> myDataset = new ArrayList<>();

    static {
        myDataset.add(new Order(1, "10/10/2022", "Gabriel Toledo", 20, 550.99));
        myDataset.add(new Order(2, "10/10/2022","Gabriel Toledo", 20, 550.99));
        myDataset.add(new Order(3, "10/10/2022", "Gabriel Toledo", 20, 550.99));
        myDataset.add(new Order(4, "10/10/2022", "Gabriel Toledo", 20, 550.99));
        myDataset.add(new Order(5, "10/10/2022", "Gabriel Toledo", 20, 550.99));
        myDataset.add(new Order(6, "10/10/2022", "Gabriel Toledo", 20, 550.99));
        myDataset.add(new Order(7, "10/10/2022", "Gabriel Toledo", 20, 550.99));
        myDataset.add(new Order(8, "10/10/2022", "Gabriel Toledo", 20, 550.99));
        myDataset.add(new Order(9, "10/10/2022", "Gabriel Toledo", 20, 550.99));
    }
}
