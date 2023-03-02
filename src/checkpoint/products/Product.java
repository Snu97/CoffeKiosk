package checkpoint.products;

public abstract class Product {

    // 커피와 차의 공통 정보를 가지고 있어야 한다.
    // 이름, 가격 + id (Primary Key)
    private int id;
    private String name;
    private int price;

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public abstract void applyOption();
    public abstract String getOptionToString();
}
