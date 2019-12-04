package java_study.desing_pattern.factory;

import java_study.desing_pattern.factory.concrete.HpCreator;
import java_study.desing_pattern.factory.concrete.MpCreator;
import java_study.desing_pattern.factory.framework.Item;
import java_study.desing_pattern.factory.framework.ItemCreator;

public class Main {
    public static void main(String[] args) {
        ItemCreator creator;
        Item item;

        creator = new HpCreator();
        item = creator.create();
        item.use();

        creator = new MpCreator();
        item = creator.create();
        item.use();

    }
}
