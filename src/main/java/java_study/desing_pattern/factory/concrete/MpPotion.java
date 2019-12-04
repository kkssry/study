package java_study.desing_pattern.factory.concrete;

import java_study.desing_pattern.factory.framework.Item;

public class MpPotion implements Item {
    @Override
    public void use() {
        System.out.println("마력 회복!");
    }
}
