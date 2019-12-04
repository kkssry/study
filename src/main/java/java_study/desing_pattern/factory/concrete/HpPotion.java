package java_study.desing_pattern.factory.concrete;

import java_study.desing_pattern.factory.framework.Item;

public class HpPotion implements Item {
    @Override
    public void use() {
        System.out.println("체력 회복!");
    }
}
