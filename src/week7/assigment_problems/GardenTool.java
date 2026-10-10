abstract class GardenTool {
    abstract String use();
}

class CuttingTool extends GardenTool {
    String use() {
        return "Using the tool in the garden, blade sharpened first";
    }
}

class Pruner extends CuttingTool {
    String use() {
        return super.use() + ", then trimming branches precisely";
    }
}

class GardenToolDemo {
    public static void main(String[] args) {
        System.out.println(new CuttingTool().use());
        System.out.println(new Pruner().use());
    }
}