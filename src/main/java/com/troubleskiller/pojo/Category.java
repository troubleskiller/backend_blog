package com.troubleskiller.pojo;

public class Category {
    private Integer id;
    private String category_name;
    private String category_py;
    private String description;
    private Integer order;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_py() {
        return category_py;
    }

    public void setCategory_py(String category_py) {
        this.category_py = category_py;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", category_name='" + category_name + '\'' +
                ", category_py='" + category_py + '\'' +
                ", description='" + description + '\'' +
                ", order=" + order +
                '}';
    }
}
