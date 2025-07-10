public class Comida {

            private String name;
            private String origin;
            private double weight;
            private double price;

    public Comida(String name, String origin, double weight, double price) {
        this.name = name;
        this.origin = origin;
        this.weight = weight;
        this.price = price;
    }

//GETTERS&SETTERS

    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


//    VISUALIZADOR


    @Override
    public String toString() {
        return  '\n' +
                "Producto: " + name + '\n' +
                "Origen: " + origin + '\n' +
                "Peso: " + weight + "kg" + '\n' +
                "Precio: " + price + '€' + '\n' +
                "____________________________";
    }
}
