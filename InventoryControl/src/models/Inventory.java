package models;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {
    private static ObservableList<Part> part = FXCollections.observableArrayList();
    private static ObservableList<Product> product = FXCollections.observableArrayList();
   // private final Part newPart;
    //private final Product newProduct;

    public Inventory() {
    }
    //adds

    public static void addPart(Part newPart) {
        part.add(newPart);
    }

    public void addProduct(Product newProduct) {
        product.add(newProduct);
    }

    //lookups

    public Part lookupPart(int partId) {
        for (int i = 0; i < part.size(); i++) {
            if (part.get(i).getID() == partId) {
                return part.get(i);
            }
        }
        return null;
    }

    public Product lookupProduct(int productId) {
        for (int i = 0; i < product.size(); i++) {
            if (product.get(i).getID() == productId) {
                return product.get(i);
            }
        }
        return null;
    }

    public ObservableList<Part> lookupPart(String partName) {
        ObservableList partSearchResults = FXCollections.observableArrayList();
        for (Part j : getAllParts()) {
            if (j.getName().contains(partName)) {
                partSearchResults.add(j);
            }
            return partSearchResults;
        }
        return null;
    }

    public ObservableList<Product> lookupProduct(String productName) {
        ObservableList productSearchResults = FXCollections.observableArrayList();
        for (Product j: getAllProducts()) {
            if (j.getName().contains(productName)) {
                productSearchResults.add(j);
            }
            return productSearchResults;
        }
        return null;
    }

    //updates

    public void updatePart(int index, Part selectedPart) {
        part.set(index, selectedPart);
    }

    public void updateProduct(int index, Product newProduct) {
        product.set(index, newProduct);
    }

    //deletes

    public boolean deletePart(Part selectedPart) {
        part.remove(selectedPart);
        return true;
    }

    public boolean deleteProduct(Product selectedProduct) {
        product.remove(selectedProduct);
        return true;
    }

    //gets

    public ObservableList<Part> getAllParts(){
        return part;
    }

    public ObservableList<Product> getAllProducts(){
        return product;
    }


}
