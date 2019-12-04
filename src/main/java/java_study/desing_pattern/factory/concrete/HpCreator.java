package java_study.desing_pattern.factory.concrete;

import java_study.desing_pattern.factory.framework.Item;
import java_study.desing_pattern.factory.framework.ItemCreator;

import java.util.Date;

public class HpCreator extends ItemCreator {
    @Override
    protected void requestItemsInfo() {
        System.out.println("데이터베이스에서 회복 물약의 정보를 가져옴");
    }

    @Override
    protected void createItemLog() {
        System.out.println("회복 물약을 새로 생성했습니다." + new Date());
    }

    @Override
    protected Item createItem() {
        return new HpPotion();
    }
}
