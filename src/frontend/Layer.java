package frontend;

public class Layer {
    private int layer;
    private String name;

    public Layer(int layer) {
        this.layer = layer;
        this.name = "Layer " + layer;
    }

    public int getValue(){
        return layer;
    }

    @Override
    public String toString(){
        return name;
    }
}
